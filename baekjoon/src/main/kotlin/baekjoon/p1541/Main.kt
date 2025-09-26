package baekjoon.p1541

fun main() {
    val input = readLine()!!
    val parts = input.split('-')

    var result = 0
    for (i in parts.indices) {
        val sum = parts[i].split('+').sumOf { it.toInt() }
        if (i == 0) {
            result += sum
        } else {
            result -= sum
        }
    }

    println(result)
}
