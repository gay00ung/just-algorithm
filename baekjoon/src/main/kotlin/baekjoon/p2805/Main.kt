package baekjoon.p2805

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toLong()

    st = StringTokenizer(br.readLine())
    val trees = LongArray(n)
    var maxH = 0L
    for (i in 0 until n) {
        val h = st.nextToken().toLong()
        trees[i] = h
        if (h > maxH) maxH = h
    }

    var left = 0L
    var right = maxH
    var ans = 0L

    while (left <= right) {
        val mid = (left + right) / 2
        var total = 0L
        for (h in trees) {
            if (h > mid) total += (h - mid)   // Long 누적
        }

        if (total >= m) {
            ans = mid       // 가능하니 더 높여보기
            left = mid + 1
        } else {
            right = mid - 1 // 부족하니 낮춰서 더 많이 자르기
        }
    }
    print(ans)
}
