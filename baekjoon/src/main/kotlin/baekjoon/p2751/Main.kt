package baekjoon.p2751

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = Integer.parseInt(readLine())
    val sb = StringBuilder()
    val numbers = IntArray(n) { Integer.parseInt(readLine()) }.sorted()
    val bw = BufferedWriter(System.out.bufferedWriter())

    for (num in numbers) {
        sb.append(num).append('\n')
    }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}