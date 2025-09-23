package baekjoon.p12865

fun main() {
    // n : 물품의 수, k : 버틸 수 있는 무게
    // w : 물건의 무게, v : 물건의 가치

    val (n, k) = readln().split(" ").map { it.toInt() }
    val items = Array(n) {
        val (w, v) = readln().split(" ").map { it.toInt() }
        Pair(w, v)
    }

    val dp = Array(n + 1) { IntArray(k + 1) }

    for (i in 1..n) {
        val (weight, value) = items[i - 1]
        for (w in 0..k) {
            if (weight <= w) {
                dp[i][w] = maxOf(dp[i - 1][w], dp[i - 1][w - weight] + value)
            } else {
                dp[i][w] = dp[i - 1][w]
            }
        }
    }
    println(dp[n][k])
}