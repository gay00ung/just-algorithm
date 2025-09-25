package baekjoon.p13275

fun main() {
    val s = readLine()!!
    println(matcher(s))
}

fun preprocess(s: String): String {
    return buildString {
        append("#")
        for (c in s) {
            append(c)
            append("#")
        }
    }
}

// Manacher's Algorithm
fun matcher(s: String): Int {
    val processed = preprocess(s)
    val n = processed.length
    val p = IntArray(n)

    var center = 0
    var right = 0
    var maxLength = 0

    for (i in 0 until n) {
        if (i < right) {
            p[i] = minOf(right - i, p[2 * center - i])
        }

        while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && processed[i + p[i] + 1] == processed[i - p[i] - 1]) {
            p[i]++
        }

        if (i + p[i] > right) {
            center = i
            right = i + p[i]
        }

        maxLength = maxOf(maxLength, p[i])
    }

    return maxLength
}