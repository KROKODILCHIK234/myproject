package figures

import kotlin.math.abs

// Класс реализует Figure и новый Transforming
class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Figure(0), Transforming {

    // нужно явно указывать, что вы переопределяете метод
    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) { "Коэффициент масштабирования должен быть положительным" }
        // Находим центр, чтобы масштабировать относительно него
        val centerX = x + width / 2
        val centerY = y + height / 2

        width *= zoom
        height *= zoom

        // Пересчитываем верхний левый угол от нового центра
        x = centerX - width / 2
        y = centerY - height / 2
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        // 1. Находим центр прямоугольника
        val rectCenterX = x + width / 2
        val rectCenterY = y + height / 2

        // 2. Вычисляем вектор от центра вращения до центра прямоугольника
        val dx = rectCenterX - centerX
        val dy = rectCenterY - centerY

        // 3. Поворачиваем вектор
        val newDx: Int
        val newDy: Int
        if (direction == RotateDirection.Clockwise) {
            newDx = dy
            newDy = -dx
        } else { // CounterClockwise
            newDx = -dy
            newDy = dx
        }

        // 4. Находим новый центр прямоугольника
        val newRectCenterX = centerX + newDx
        val newRectCenterY = centerY + newDy

        // 5. При повороте на 90 градусов ширина и высота меняются местами
        val oldWidth = width
        width = height
        height = oldWidth

        // 6. Вычисляем новые координаты верхнего левого угла
        x = newRectCenterX - width / 2
        y = newRectCenterY - height / 2
    }

    // для каждого класса area() определяется по-своему
    override fun area(): Float {
        return (width * height).toFloat() // требуется явное приведение к вещественному числу
    }

    override fun toString(): String {
        return "Прямоугольник(x=$x, y=$y, width=$width, height=$height)"
    }
}