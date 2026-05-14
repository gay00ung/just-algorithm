class LeetCode7 {
    fun reverse(x: Int): Int {
        if (x < Int.MIN_VALUE || x > Int.MAX_VALUE) {
            return 0
        }

        if (x > 0) {
            return x.toString().reversed().toInt()
        } else if (x == 0) {
            return 0
        } else {
            return -x.toString().drop(1).reversed().toInt()
        }
    }
}
