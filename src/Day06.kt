fun main() {
    fun part1(input: List<String>): Int {
        val mostRecentCharactersQueue = ArrayDeque<Char>()

        fun checkQueue(): Boolean {
            var success = true
            (1..(mostRecentCharactersQueue.size)).forEach { _ ->
                val currentChar = mostRecentCharactersQueue.removeFirst()
                if (mostRecentCharactersQueue.contains(currentChar)) {
                    success = false
                }
                mostRecentCharactersQueue.addLast(currentChar)
            }
            return success
        }

        return input[0].indexOfFirst {
            if(mostRecentCharactersQueue.size == 4 && checkQueue()) {
                true
            } else {
                if(mostRecentCharactersQueue.size == 4) {
                    mostRecentCharactersQueue.removeFirst()
                }
                mostRecentCharactersQueue.addLast(it)
                false
            }
        }
    }

    fun part2(input: List<String>): Int {
        val mostRecentCharactersQueue = ArrayDeque<Char>()

        fun checkQueue(): Boolean {
            var success = true
            (1..(mostRecentCharactersQueue.size)).forEach { _ ->
                val currentChar = mostRecentCharactersQueue.removeFirst()
                if (mostRecentCharactersQueue.contains(currentChar)) {
                    success = false
                }
                mostRecentCharactersQueue.addLast(currentChar)
            }
            return success
        }

        return input[0].indexOfFirst {
            if(mostRecentCharactersQueue.size == 14 && checkQueue()) {
                true
            } else {
                if(mostRecentCharactersQueue.size == 14) {
                    mostRecentCharactersQueue.removeFirst()
                }
                mostRecentCharactersQueue.addLast(it)
                false
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part2(testInput) == 19)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}