import kotlin.math.pow


fun main() {
    fun part1(input:List<String>):Int {
        val array = Array(input[0].length) { 0 }
        var total = 0
        var result = 0
        for (i in input) {
            for (s in 0..i.lastIndex) {
                if (i[s] == '0') {
                    array[s] = array[s] - 1
                }else {
                    array[s] = array[s] + 1
                }
                if (i == input.last()){
                    total += 2.0.pow(array.size - 1 - s).toInt()
                   if (array[s] > 1) {
                       result += 2.0.pow(array.size - 1 - s).toInt()
                   }
                }
            }
        }

        return (total - result) * result
    }
    fun part2(input:List<String>):Int {
        return 0
    }
    val testInput = readInput("Day03_test")
    println(check(part1(testInput) == 198))
//    println(check(part2(testInput) == 900))

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}