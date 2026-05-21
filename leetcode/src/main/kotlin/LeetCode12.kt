class LeetCode12 {
    fun intToRoman(num: Int): String {
        var n = num
        val values = intArrayOf(
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        )

        val symbols = arrayOf(
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        )

        val result = StringBuilder()

        for (i in values.indices) {
            while (n >= values[i]) {
                result.append(symbols[i])
                n -= values[i]
            }
        }
        return result.toString()
    }
}
