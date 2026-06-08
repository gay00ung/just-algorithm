class LeetCode17 {
    fun letterCombinations(digits: String): List<String> {
        var result = mutableListOf("")
        val map = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

        if (digits.isEmpty()) return emptyList()

        for (digit in digits) {
            val letters = map[digit] ?: continue

            val newResult = mutableListOf<String>()

            for (prefix in result) {
                for (ch in letters) {
                    newResult.add(prefix + ch)
                }
            }
            result = newResult
        }
        return result
    }
}
