Конечно, вот единый текст для файла README.md. Просто скопируйте всё, что находится в блоке ниже.

Демонстрация работы с трансформациями фигур на Kotlin

Этот проект реализует базовые геометрические трансформации для фигур на языке Kotlin. Работа выполнена на основе предоставленного набора классов и интерфейсов.

Реализованная функциональность

В рамках задания была дополнена функциональность классов Rect, Square, и Circle:

Наследование от Figure: Все классы фигур теперь наследуются от абстрактного класса Figure и реализуют его метод area().

Реализация интерфейса Transforming: Для каждой фигуры реализован интерфейс Transforming, который добавляет следующие методы:

move(dx: Int, dy: Int): перемещение фигуры.

resize(zoom: Int): целочисленное масштабирование фигуры относительно ее центра.

rotate(direction: RotateDirection, centerX: Int, centerY: Int): поворот фигуры на 90 градусов по или против часовой стрелки вокруг заданной точки.

Демонстрация работы

Для проверки работоспособности всех реализованных методов был использован следующий код в файле Main.kt.

Код (Main.kt)
code
Kotlin
download
content_copy
expand_less
import figures.*

fun main() {
    println("--- Демонстрация трансформации фигур ---")
    val rotationCenter_X = 0
    val rotationCenter_Y = 0

    // --- 1. Прямоугольник ---
    val rect = Rect(x = 10, y = 20, width = 6, height = 4)
    println("\n[Прямоугольник]")
    println("Исходное состояние: $rect, Площадь: ${rect.area()}")

    rect.move(5, -10)
    println("После перемещения:  $rect")

    rect.resize(2)
    println("После увеличения x2: $rect")

    rect.rotate(RotateDirection.CounterClockwise, rotationCenter_X, rotationCenter_Y)
    println("После поворота против часовой стрелки вокруг ($rotationCenter_X, $rotationCenter_Y): $rect")

    // --- 2. Квадрат ---
    val square = Square(x = 5, y = 5, side = 4)
    println("\n[Квадрат]")
    println("Исходное состояние: $square, Площадь: ${square.area()}")

    square.move(-5, -5)
    println("После перемещения:  $square")

    square.resize(3)
    println("После увеличения x3: $square")

    square.rotate(RotateDirection.Clockwise, rotationCenter_X, rotationCenter_Y)
    println("После поворота по часовой стрелке вокруг ($rotationCenter_X, $rotationCenter_Y):    $square")

    // --- 3. Круг ---
    val circle = Circle(centerX = 10, centerY = 0, radius = 5)
    println("\n[Круг]")
    println("Исходное состояние: $circle, Площадь: ${circle.area()}")

    circle.move(0, 15)
    println("После перемещения:  $circle")

    circle.resize(2)
    println("После увеличения x2: $circle")

    circle.rotate(RotateDirection.Clockwise, rotationCenter_X, rotationCenter_Y)
    println("После поворота по часовой стрелке вокруг ($rotationCenter_X, $rotationCenter_Y):  $circle")
}
Результат выполнения

Ниже представлен вывод программы, который показывает пошаговое изменение состояния и координат каждой фигуры.

code
Code
download
content_copy
expand_less
--- Демонстрация трансформации фигур ---

[Прямоугольник]
Исходное состояние: Прямоугольник(x=10, y=20, width=6, height=4), Площадь: 24.0
После перемещения:  Прямоугольник(x=15, y=10, width=6, height=4)
После увеличения x2: Прямоугольник(x=12, y=8, width=12, height=8)
После поворота против часовой стрелки вокруг (0, 0): Прямоугольник(x=-16, y=12, width=8, height=12)

[Квадрат]
Исходное состояние: Квадрат(x=5, y=5, side=4), Площадь: 16.0
После перемещения:  Квадрат(x=0, y=0, side=4)
После увеличения x3: Квадрат(x=-4, y=-4, side=12)
После поворота по часовой стрелке вокруг (0, 0):    Квадрат(x=-4, y=-8, side=12)

[Круг]
Исходное состояние: Круг(centerX=10, centerY=0, radius=5), Площадь: 78.53982
После перемещения:  Круг(centerX=10, centerY=15, radius=5)
После увеличения x2: Круг(centerX=10, centerY=15, radius=10)
После поворота по часовой стрелке вокруг (0, 0):  Круг(centerX=15, centerY=-10, radius=10)
