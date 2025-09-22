package baekjoon.p2470

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.sorted()

    var left = 0
    var right = n - 1
    var sum = Triple(left, right, arr[left] + arr[right])

        while (left < right) {
            val currentSum = arr[left] + arr[right]
            // 절댓값으로 비교
            if (abs(currentSum) < abs(sum.third)) {
                sum = Triple(left, right, currentSum)
            }
            if (currentSum < 0) {
                left++
            } else {
                right--
            }
        }
    println("${arr[sum.first]} ${arr[sum.second]}")
}