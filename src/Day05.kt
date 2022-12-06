fun main() {
    fun part1(input: List<String>): String {
        val separator = input.indexOf(input.find { it.isBlank() })
        val crates = input.subList(0, separator - 1)
        val instructions = input.subList(separator + 1, input.size)
        val stacks = mutableListOf<ArrayDeque<Char>>()
        crates.forEach { it.chunked(4).mapTo(stacks) { ArrayDeque() } }


        crates
            .map { it
                .chunked(4)
                .map { it.find { it.isLetter() } }
                .forEachIndexed { index, crate ->
                    if(crate != null) {
                        stacks[index].addLast(crate)
                    }
                }
            }

        instructions
            .map { instruction ->
                val groupValues = Regex("move (\\d*) from (\\d*) to (\\d*)").find(instruction)!!.groupValues
                groupValues
                    .subList(1, groupValues.size)
                    .map { it.toInt() }
            }
            .forEach { instruction ->
                (1..(instruction[0])).forEach {_ ->
                    val crate = stacks[instruction[1] - 1].removeFirst()
                    stacks[instruction[2] - 1].addFirst(crate)
                }
            }

        return stacks.map { if(!it.isEmpty()) it.removeFirst() else "" }.joinToString("")
    }

    fun part2(input: List<String>): String {
        val separator = input.indexOf(input.find { it.isBlank() })
        val crates = input.subList(0, separator - 1)
        val instructions = input.subList(separator + 1, input.size)
        val stacks = mutableListOf<ArrayDeque<Char>>()
        crates.forEach { it.chunked(4).mapTo(stacks) { ArrayDeque() } }


        crates
            .map { it
                .chunked(4)
                .map { it.find { it.isLetter() } }
                .forEachIndexed { index, crate ->
                    if(crate != null) {
                        stacks[index].addLast(crate)
                    }
                }
            }

        instructions
            .map { instruction ->
                val groupValues = Regex("move (\\d*) from (\\d*) to (\\d*)").find(instruction)!!.groupValues
                groupValues
                    .subList(1, groupValues.size)
                    .map { it.toInt() }
            }
            .forEach { instruction ->
                (1..(instruction[0]))
                    .map { stacks[instruction[1] - 1].removeFirst() }
                    .reversed()
                    .forEach { stacks[instruction[2] - 1].addFirst(it) }
                }

        return stacks.map { if(!it.isEmpty()) it.removeFirst() else "" }.joinToString("")
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}