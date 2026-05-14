class LeetCode7 {
    fun reverse(x: Int): Int {
        return if (x > 0) {
            x.toString().reversed().toInt()
        } else if (x == 0) {
            0
        } else {
            -x.toString().drop(1).reversed().toInt()
        }
    }
}
