class LeetCode9 {
    fun isPalindrome(x: Int): Boolean {
        val reversed = x.toString().reversed()

        return x.toString() == x.toString().reversed()
    }
}
