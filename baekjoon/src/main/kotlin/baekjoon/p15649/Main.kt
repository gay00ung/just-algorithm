package baekjoon.p15649

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val visited = BooleanArray(n + 1) { false }
    val output = mutableListOf<Int>()

    fun backtrack() {
        if (output.size == m) {
            println(output.joinToString(" "))
            return
        }

        for (i in 1..n) {
            // 중복되지 않는 수
            if (!visited[i]) {
                // 방문 처리
                visited[i] = true
                // 현재 수를 결과에 추가
                output.add(i)
                // 재귀 호출
                backtrack()
                // 백트래킹: 현재 수 제거 및 방문 해제
                output.removeAt(output.size - 1)
                // 방문 해제
                visited[i] = false
            }
        }
    }
}