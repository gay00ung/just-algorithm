package baekjoon.p1920

fun main() {
    readLine()
    val numbers = readLine()!!.split(" ").map { it.toInt() }.toSet()
    readLine()
    val targets = readLine()!!.split(" ").map { it.toInt() }

    val results = targets.map { if (it in numbers) 1 else 0 }

    println(results.joinToString("\n"))
}