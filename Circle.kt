package figures

import kotlin.math.PI

class Circle(var centerX: Int, var centerY: Int, var radius: Int) : Figure(2), Transforming {

    init {
        require(radius > 0) { "Радиус должен быть положительным" }
    }

    override fun area(): Float {
        return (PI * radius * radius).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        centerX += dx
        centerY += dy
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) { "Коэффициент масштабирования должен быть положительным" }
        radius *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        // Вращаем только центр окружности, ее внешний вид не меняется
        val dx = this.centerX - centerX
        val dy = this.centerY - centerY

        val newDx: Int
        val newDy: Int
        if (direction == RotateDirection.Clockwise) {
            newDx = dy
            newDy = -dx
        } else { // CounterClockwise
            newDx = -dy
            newDy = dx
        }

        this.centerX = centerX + newDx
        this.centerY = centerY + newDy
    }

    override fun toString(): String {
        return "Круг(centerX=$centerX, centerY=$centerY, radius=$radius)"
    }
}