package baekjoon.p2178

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) { false } }

    repeat(n) { i ->
        val line = readln()
        for (j in line.indices) {
            graph[i][j] = line[j].digitToInt()
        }
    }

    val dist = Array(n) { IntArray(m) { 0 } }
    val q = ArrayDeque<Pair<Int, Int>>()
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    q.add(Pair(0, 0))
    visited[0][0] = true
    dist[0][0] = 1

    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        if (x == n - 1 && y == m - 1) break
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until n && ny in 0 until m) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true
                    dist[nx][ny] = dist[x][y] + 1
                    q.add(Pair(nx, ny))
                }
            }
        }
    }
    println(dist[n - 1][m - 1])
}
