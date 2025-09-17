package baekjoon.common

import java.io.BufferedInputStream
import java.io.BufferedWriter
import java.io.Closeable
import java.io.OutputStreamWriter

class FastScanner(private val input: BufferedInputStream = BufferedInputStream(System.`in`)) {
    private val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
    private var bufferLength = 0
    private var bufferPointer = 0

    private fun readByte(): Int {
        if (bufferPointer >= bufferLength) {
            bufferLength = input.read(buffer)
            bufferPointer = 0
            if (bufferLength <= 0) {
                return -1
            }
        }
        return buffer[bufferPointer++].toInt()
    }

    fun next(): String {
        val builder = StringBuilder()
        var c = readByte()
        while (c <= 32 && c >= 0) {
            c = readByte()
        }
        while (c > 32) {
            builder.append(c.toChar())
            c = readByte()
        }
        return builder.toString()
    }

    fun nextInt(): Int = next().toInt()

    fun nextLong(): Long = next().toLong()

    fun nextDouble(): Double = next().toDouble()

    fun hasNext(): Boolean {
        var c = readByte()
        while (c <= 32 && c >= 0) {
            c = readByte()
        }
        if (c < 0) return false
        bufferPointer--
        return true
    }

    companion object {
        private const val DEFAULT_BUFFER_SIZE = 1 shl 16
    }
}

class FastWriter : Closeable {
    private val out = BufferedWriter(OutputStreamWriter(System.out))
    private val builder = StringBuilder()

    fun write(value: Any?): FastWriter {
        builder.append(value)
        return this
    }

    fun writeln(value: Any? = ""): FastWriter {
        builder.append(value).append('\n')
        return this
    }

    fun flush() {
        out.write(builder.toString())
        out.flush()
        builder.setLength(0)
    }

    override fun close() {
        flush()
        out.close()
    }
}

inline fun runFastIO(block: (FastScanner, FastWriter) -> Unit) {
    val scanner = FastScanner()
    FastWriter().use { writer ->
        block(scanner, writer)
    }
}
