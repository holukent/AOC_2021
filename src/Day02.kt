


fun main() {
    fun part1(input: List<String>):Int {
        var horizontal = 0
        var depth = 0
        var i = 0
        while (true) {
            val (direction, position) = input[i].split(" ")
            when(direction){
                "forward" -> horizontal += position.toInt()
                "up" -> depth -= position.toInt()
                "down" -> depth += position.toInt()
            }
            i++
            if (i > input.size - 1) break
        }
        return horizontal.times(depth)
    }

    fun part2(input: List<String>):Int {
        var horizontal = 0
        var depth = 0
        var aim = 0
        var i = 0
        while (true) {
            val (direction, position) = input[i].split(" ")
            when(direction){
                "forward" -> {
                    horizontal += position.toInt()
                    depth += aim * position.toInt()

                }
                "up" -> aim -= position.toInt()
                "down" -> aim += position.toInt()
            }
            i++
            if (i > input.size - 1) break
        }
        return horizontal.times(depth)
    }
    val testInput = readInput("Day02_test")

    println(check(part1(testInput) == 150))
    println(check(part2(testInput) == 900))

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))



}