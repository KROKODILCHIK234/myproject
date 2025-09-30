package figures

// Квадрат наследуется от Figure и реализует Transforming
class Square(var x: Int, var y: Int, var side: Int) : Figure(1), Transforming {

    override fun area(): Float {
        return (side * side).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) { "Коэффициент масштабирования должен быть положительным" }
        // Логика аналогична прямоугольнику
        val centerX = x + side / 2
        val centerY = y + side / 2
        side *= zoom
        x = centerX - side / 2
        y = centerY - side / 2
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        // Логика поворота центра квадрата идентична прямоугольнику
        val squareCenterX = x + side / 2
        val squareCenterY = y + side / 2

        val dx = squareCenterX - centerX
        val dy = squareCenterY - centerY

        val newDx: Int
        val newDy: Int
        if (direction == RotateDirection.Clockwise) {
            newDx = dy
            newDy = -dx
        } else {
            newDx = -dy
            newDy = dx
        }

        val newSquareCenterX = centerX + newDx
        val newSquareCenterY = centerY + newDy

        // У квадрата стороны равны, поэтому их не нужно менять местами
        x = newSquareCenterX - side / 2
        y = newSquareCenterY - side / 2
    }

    override fun toString(): String {
        return "Квадрат(x=$x, y=$y, side=$side)"
    }
}