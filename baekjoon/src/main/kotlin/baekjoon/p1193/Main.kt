package baekjoon.p1193

fun main() {
    // input
    val x = readLine()!!.toInt()

    // 몇번째 대각선인지
    var diagonal = 1
    // 누적된 분수
    var count = 0

    // 대각선 찾기
    while (count + diagonal < x) {
        count += diagonal
        diagonal++
    }

    // 대각선에서 몇번째 분수인지
    val position = x - count

    // 분자, 분모 계산
    val numerator: Int
    val denominator: Int

    if (diagonal % 2 == 0) {
        // 짝수 대각선: 분자가 증가, 분모가 감소 (대각선에서의 위치만큼)
        numerator = position
        denominator = diagonal - position + 1
    } else {
        // 홀수 대각선: 분자가 감소, 분모가 증가 (대각선에서의 위치만큼)
        numerator = diagonal - position + 1
        denominator = position
    }

    // output
    println("$numerator/$denominator")
}