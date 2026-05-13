class LeetCode6 {
    fun convert(s: String, numRows: Int): String {
        val arr = Array(numRows) { mutableListOf<Char>() }
        var currentRow = 0
        var directionDown = true

        if (numRows == 1) {
            return s
        } else {
            for (char in s) {
                arr[currentRow].add(char)

                if (currentRow == 0) directionDown = true
                if (currentRow == numRows - 1) directionDown = false

                if (directionDown) {
                    currentRow++
                } else {
                    currentRow--
                }
            }

            val result = StringBuilder()

            for (row in arr) {
                for (char in row) {
                    result.append(char)
                }
            }
            return result.toString()
        }
    }
}
