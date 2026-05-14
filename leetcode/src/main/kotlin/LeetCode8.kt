class LeetCode8 {
    fun myAtoi(s: String): Int {
        val str = s.trim()
        if (str.isEmpty()) return 0

        var index = 0
        var sign = 1
        var result = 0

        if (str[index] == '-' || str[index] == '+') {
            sign = if (str[index] == '-') -1 else 1
            index++
        }

        while (index < str.length && str[index].isDigit()) {
            val digit = str[index].digitToInt()

            if (result > (Int.MAX_VALUE - digit) / 10) { // result * 10 + digit > Int.MAX_VALUE 와 동일
                return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
            }

            result = result * 10 + digit
            index++
        }
        return result * sign
    }
}
