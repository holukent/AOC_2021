fun part1(input: List<String>): Int {
    var index = 0
    var result = 0
    while (true){
        if (input[index].toInt() < input[index + 1].toInt() ) {
            result++
        }
        if (index == input.size - 2) break
        index++
    }
    return result
}

fun part2(input: List<String>): Int {
    var result = 0
    var first = input[0].toInt()
    var middle = input[1].toInt()
    var last = input[2].toInt()
    var old = first + middle + last
    var index = 3
    while (true) {
        val new = old - first + input[index].toInt()
        if (new > old) {
            result++
        }
        old = new
        first = middle
        middle = last
        last = input[index++].toInt()
        if (index == input.size) break
    }
    return result
}

fun main() {
    val testInput = readInput("Day01_test")

    println(part1(testInput))
    println(part2(testInput))

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))

}
