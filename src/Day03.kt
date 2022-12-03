import java.lang.Error

fun main() {
    fun part1(input: List<String>): Int {
        val priorities = mutableMapOf<Char, Int>()
        var count = 1
        ('a'..'z').forEach { priorities[it] = count++ }
        ('A'..'Z').forEach { priorities[it] = count++ }

        return input.sumOf {rucksack ->
            val firstCompartment = rucksack
                .substring(0, rucksack.length / 2)
                .toSet()

            val item = rucksack
                .substring(rucksack.length / 2, rucksack.length)
                .find { firstCompartment.contains(it) }

            priorities[item] ?: throw Error()
        }
    }

    fun part2(input: List<String>): Int {
        val priorities = mutableMapOf<Char, Int>()
        var count = 1
        ('a'..'z').forEach { priorities[it] = count++ }
        ('A'..'Z').forEach { priorities[it] = count++ }

        return input
            .chunked(3)
            .sumOf { elves ->
                val firstCompartment = elves[0].toSet()
                val secondCompartment = elves[1].toSet()

                val item = elves[2].find { firstCompartment.contains(it) && secondCompartment.contains(it) }

                priorities[item] ?: throw Error()
            }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}