enum class Direction {
    UP, RIGHT, DOWN, LEFT
}

class Robot(private var x : Long = 0, private var y : Long = 0, private var direction : Direction = Direction.UP) {

    fun getX() : Long {
        return x
    }

    fun getY() : Long {
        return y
    }

    fun getDirection() : Direction {
        return direction
    }

    fun turnRight() {
        when (direction) {
            Direction.UP -> direction = Direction.RIGHT
            Direction.LEFT -> direction = Direction.UP
            Direction.DOWN -> direction = Direction.LEFT
            Direction.RIGHT -> direction = Direction.DOWN
        }
    }
    fun stepForward() {
        when (direction) {
            Direction.UP -> y++
            Direction.LEFT -> x--
            Direction.DOWN -> y--
            Direction.RIGHT -> x++
        }
    }

}

fun moveRobot(robot: Robot, toX: Long, toY: Long) {
    if (robot.getY() < toY) {
        while (robot.getDirection() !== Direction.UP) robot.turnRight()
        while (robot.getY() != toY) robot.stepForward()
    }
    if (robot.getY() > toY) {
        while (robot.getDirection() !== Direction.DOWN) robot.turnRight()
        while (robot.getY() != toY) robot.stepForward()
    }
    if (robot.getX() < toX) {
        while (robot.getDirection() !== Direction.RIGHT) robot.turnRight()
        while (robot.getX() != toX) robot.stepForward()
    }
    if (robot.getX() > toX) {
        while (robot.getDirection() !== Direction.LEFT) robot.turnRight()
        while (robot.getX() != toX) robot.stepForward()
    }
}