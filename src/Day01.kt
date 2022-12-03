fun main() {
    fun part1(input: List<String>): Int {
        var highestCalories = 0
        var currentCalories = 0
        input.forEach {calories ->
            if(calories.isEmpty()) {
                if(currentCalories > highestCalories) {
                    highestCalories = currentCalories
                }
                currentCalories = 0
            } else {
                currentCalories += calories.toInt()
            }
        }
        return highestCalories
    }

    fun part2(input: List<String>): Int {
        val elvesCalories = mutableListOf<Int>()
        var currentCalories = 0
        input.forEach {calories ->
            if(calories.isEmpty()) {
                elvesCalories.add(currentCalories)
                currentCalories = 0
            } else {
                currentCalories += calories.toInt()
            }
        }
        return elvesCalories
            .sortedDescending()
            .take(3)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
