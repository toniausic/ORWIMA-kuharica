package hr.ferit.larscupec.lv1

class Robot(private var x: Int, private var y: Int) {
    fun goRight(steps: Int) {
        x += steps
    }

    fun goLeft(steps: Int) {
        x -= steps
    }

    fun goDown(steps: Int) {
        y -= steps
    }

    fun goUp(steps: Int) {
        y += steps
    }

    fun getLocation(): String {
        return "($x, $y)"
    }
}