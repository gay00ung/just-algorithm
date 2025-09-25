package baekjoon.p1932

fun main() {
    val n = readLine()!!.toInt()
    val triangle = Array(n) { IntArray(it + 1)}

    for (i in 0 until n) {
        val row = readLine()!!.split(" ").map { it.toInt() }
        for (j in row.indices) {
            triangle[i][j] = row[j]
        }
    }

    // dp 테이블
    val dp = Array(n) { IntArray(it + 1) }
    dp[0][0] = triangle[0][0]

    for (i in 0 until n - 1) {
        for (j in 0..i) {
            dp[i + 1][j] = maxOf(dp[i + 1][j], dp[i][j] + triangle[i + 1][j])
            dp[i + 1][j + 1] = maxOf(dp[i + 1][j + 1], dp[i][j] + triangle[i + 1][j + 1])
        }
    }
    println(dp[n - 1].maxOrNull())
}