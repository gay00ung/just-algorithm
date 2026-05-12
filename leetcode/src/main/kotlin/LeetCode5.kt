package org.example

class LeetCode5 {
    fun longestPalindrome(s: String): String {
        var answer = ""

        for (i in s.indices) {
            // 홀수 길이 검사
            var left = i
            var right = i

            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--
                right++
            }

            var current = s.substring(left + 1, right)
            if (current.length > answer.length) {
                answer = current
            }

            // 짝수 길이 검사
            left = i
            right = i + 1

            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--
                right++
            }

            current = s.substring(left + 1, right)
            if (current.length > answer.length) {
                answer = current
            }
        }

        return answer
    }
}
