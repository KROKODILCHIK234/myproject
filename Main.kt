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