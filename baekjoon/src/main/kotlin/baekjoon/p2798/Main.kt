package baekjoon.p2798

fun main() {
    // input
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val cards = readLine()!!.split(" ").map { it.toInt() }

    var sum = 0

    // 3장의 카드를 고르는 모든 조합 탐색
    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            for (k in j + 1 until n) {
                val currentSum = cards[i] + cards[j] + cards[k]
                // m을 넘지 않으면서 최대인 합 갱신
                if (currentSum <= m && currentSum > sum) {
                    sum = currentSum
                }
            }
        }
    }

    // output
    println(sum)
}