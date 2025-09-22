package baekjoon.p7569

import java.util.*

fun main() {
    // input (m, n, h)
    val (m, n, h) = readln().split(" ").map { it.toInt() }
    val box = Array(h) { Array(n) { IntArray(m) } }
    val queue = LinkedList<Triple<Int, Int, Int>>()

    for (i in 0 until h) {
        for (j in 0 until n) {
            val line = readln().split(" ").map { it.toInt() }
            for (k in 0 until m) {
                box[i][j][k] = line[k]
                // 익은 토마토(1)들을 모두 찾아서 큐에 넣기
                if (line[k] == 1) {
                    queue.add(Triple(i, j, k)) // (h, n, m)
                }
            }
        }
    }

    val dh = listOf(-1, 1, 0, 0, 0, 0)
    val dn = listOf(0, 0, -1, 1, 0, 0)
    val dm = listOf(0, 0, 0, 0, -1, 1)

    while (queue.isNotEmpty()) { // 더 익힐 토마토가 있을 때까지
        val (ch, cn, cm) = queue.poll() // 하나씩 꺼내기

        // 6방향 탐색
        for (i in 0 until 6) {
            val nh = ch + dh[i] // 새로운 층
            val nn = cn + dn[i] // 새로운 행
            val nm = cm + dm[i] // 새로운 열

            // 범위 내에 있고, 익지 않은 토마토(0)라면
            if (nh in 0 until h && nn in 0 until n && nm in 0 until m && box[nh][nn][nm] == 0) {
                box[nh][nn][nm] = box[ch][cn][cm] + 1 // 날짜 증가
                queue.offer(Triple(nh, nn, nm)) // 큐에 추가
            }
        }
    }

    var maxDays = 0
    var hasZero = false

    // 모든 칸을 확인
    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                if (box[i][j][k] == 0) {
                    hasZero = true // 익지 않은 토마토가 하나라도 있으면 -1
                    break
                }
                maxDays = maxOf(maxDays, box[i][j][k]) // 최대 날짜 갱신
            }
        }
    }

    // 결과 출력 (최대 날짜 - 1, 처음 익은 토마토가 1이기 때문)
    println(if (hasZero) -1 else maxDays - 1)
}