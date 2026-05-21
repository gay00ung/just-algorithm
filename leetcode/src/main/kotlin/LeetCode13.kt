class LeetCode13 {
    fun romanToInt(s: String): Int {
        var string = s
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

        var result = 0

        for (i in symbols.indices) {
            while (string.startsWith(symbols[i])) {
                result += values[i]
                string = string.removePrefix(symbols[i])
            }
        }
        return result
    }
}
