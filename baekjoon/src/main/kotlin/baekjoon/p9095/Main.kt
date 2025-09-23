package baekjoon.p9095

fun main() {
    val t = readLine()!!.toInt()
    val dp = IntArray(12)

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..11) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    repeat(t) {
        val n = readLine()!!.toInt()
        println(dp[n])
    }
}