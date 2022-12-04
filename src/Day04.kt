fun main() {
    fun part1(input: List<String>): Int {
        return input.count { pair ->
           val elves = pair
               .split(',')
               .map {elf ->
                   elf.split('-').map { it.toInt() }
               }

            val elf1 = Pair(elves[0][0], elves[0][1])
            val elf2 = Pair(elves[1][0], elves[1][1])

            (elf1.first >= elf2.first && elf1.second <= elf2.second ||
                    elf2.first >= elf1.first && elf2.second <= elf1.second)
        }
    }

    fun part2(input: List<String>): Int {
        return input.count { pair ->
            val elves = pair
                .split(',')
                .map {elf ->
                    elf.split('-').map { it.toInt() }
                }

            val elf1 = Pair(elves[0][0], elves[0][1])
            val elf2 = Pair(elves[1][0], elves[1][1])

            (elf1.first <= elf2.first && elf1.second >= elf2.first ||
                    elf2.first <= elf1.first && elf2.second >= elf1.first)
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}