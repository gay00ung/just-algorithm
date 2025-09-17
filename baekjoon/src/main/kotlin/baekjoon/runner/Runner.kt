package baekjoon.runner

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        System.err.println("Usage: ./gradlew run --args=\"[problemId]\"")
        System.err.println("Example: ./gradlew run --args=\"2557\" or ./gradlew run --args=\"p2557\"")
        exitProcess(1)
    }

    val problemId = args.first()
        .lowercase()
        .removePrefix("p")
        .also {
            require(it.all(Char::isDigit)) { "Problem id must be numeric." }
        }

    val mainClass = "baekjoon.p${problemId}.MainKt"

    runCatching {
        val targetClass = Class.forName(mainClass)
        val mainMethod = targetClass.getDeclaredMethod("main", Array<String>::class.java)
        mainMethod.invoke(null, emptyArray<String>())
    }.onFailure { throwable ->
        System.err.println("Unable to run $mainClass. Did you create baekjoon/p${problemId}/Main.kt?")
        throwable.printStackTrace()
        exitProcess(1)
    }
}
