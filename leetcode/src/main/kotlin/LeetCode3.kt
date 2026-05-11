package org.example

class LeetCode3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var maxLength = 0
        val seen = mutableMapOf<Char, Int>()

        for (i in s.indices) {
            val char = s[i]

            if (seen.containsKey(char) && seen[char]!! >= start) {
                start = seen[char]!! + 1
            }

            seen[char] = i

            val currentLength = i - start + 1
            maxLength = maxOf(maxLength, currentLength)
        }
        return maxLength
    }
}
