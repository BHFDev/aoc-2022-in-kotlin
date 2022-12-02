import java.lang.Error

fun main() {


    fun part1(input: List<String>): Int {
        return input.sumOf {shapes ->
            val myShape = shapes[2]
            val opponentsShape = shapes[0]

            when (myShape) {
                'X' -> 1 + when (opponentsShape) {
                    'C' -> 6
                    'A' -> 3
                    else -> 0
                }
                'Y' -> 2 + when (opponentsShape) {
                    'A' -> 6
                    'B' -> 3
                    else -> 0
                }
                'Z' -> 3 + when (opponentsShape) {
                    'B' -> 6
                    'C' -> 3
                    else -> 0
                }
                else -> throw Error()
            }
        }
    }

    fun part2(input: List<String>): Int {

        return input.sumOf {shapes ->
            val myShape = shapes[2]
            val opponentsShape = shapes[0]

            (when (opponentsShape) {
                'A' -> when (myShape) {
                    'X' -> 3 + 0
                    'Y' -> 1 + 3
                    else -> 2 + 6
                }
                'B' -> when (myShape) {
                    'X' -> 1 + 0
                    'Y' -> 2 + 3
                    else -> 3 + 6
                }
                'C' -> when (myShape) {
                    'X' -> 2 + 0
                    'Y' -> 3 + 3
                    else -> 1 + 6
                }
                else -> throw Error()
            }).toInt()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}