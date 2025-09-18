package baekjoon.p11866

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val people = (1..n).toMutableList()
    val result = mutableListOf<Int>()
    var currentIndex = 0

    while (people.isNotEmpty()) {
        // K번째 사람의 인덱스 계산 (0-based)
        currentIndex = (currentIndex + k - 1) % people.size
        // 해당 사람 제거하고 결과에 추가
        result.add(people.removeAt(currentIndex))
        // 제거 후 현재 인덱스가 리스트 크기를 초과하면 조정
        if (currentIndex >= people.size) {
            currentIndex = 0
        }
    }

    println("<${result.joinToString(", ")}>")
}