package baekjoon.p2667

fun main() {
    val n = readLine()!!.toInt()
    val map = Array(n) { readLine()!!.map { it.digitToInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(n) }
    val result = mutableListOf<Int>()

    val x = arrayOf(1, -1, 0, 0)
    val y = arrayOf(0, 0, 1, -1)

    // dfs
    fun dfs(_x: Int, _y: Int): Int {
        visited[_x][_y] = true
        var count = 1
        for (i in 0 until 4) {
            val nx = _x + x[i]
            val ny = _y + y[i]

            if (nx in 0 until n && ny in 0 until n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    count += dfs(nx, ny)
                }
            }
        }
        return count
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == 1 && !visited[i][j]) {
                result.add(dfs(i, j))
            }
        }
    }

    result.sort()
    println(result.size)
    result.forEach { println(it) }
}