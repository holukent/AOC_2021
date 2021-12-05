import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    fun part1(input: List<String>): Int {
        val array = MutableList(1000) { MutableList<Int>(1000) {0} }
        input.forEach {
            val (x1, y1, x2, y2)  = it.split(" -> ").map { it.split(",") }.flatMap { it }.map { it.toInt() }
            when{
                x1 == x2 -> {
                    val min = min(y1,y2)
                    val max = max(y1,y2)
                    for (y in min..max){
                        array[y][x1] = ++array[y][x1]
                    }

                }
                y1 == y2 -> {
                    val min = min(x1,x2)
                    val max = max(x1,x2)
                    for (x in min..max) {
                        array[y1][x] = ++array[y1][x]
                    }
                }
            }
        }
        return array.flatMap { it }.filter { it >= 2 }.size
    }
    fun part2(input: List<String>): Int {
        val array = MutableList(1000) { MutableList<Int>(1000) {0} }
        input.forEach {
            var (x1, y1, x2, y2)  = it.split(" -> ").map { it.split(",") }.flatMap { it }.map { it.toInt() }
            when{
                (abs(x1 - x2) == abs(y1 - y2)) || (x1 == y2 && y1 == x2)  -> {
                    val incx = if (x1 > x2) -1 else 1
                    val incy = if (y1 > y2) -1 else 1
                    while (true){
                        array[y1][x1] = ++array[y1][x1]
                        if (x1 == x2) break
                        x1 += incx
                        y1 += incy
                    }
                }
                x1 == x2 -> {
                    val min = min(y1,y2)
                    val max = max(y1,y2)
                    for (y in min..max){
                        array[y][x1] = ++array[y][x1]
                    }

                }
                y1 == y2 -> {
                    val min = min(x1,x2)
                    val max = max(x1,x2)
                    for (x in min..max) {
                        array[y1][x] = ++array[y1][x]
                    }
                }
            }
        }
        return array.flatMap { it }.filter { it >= 2 }.size
    }

    val testInput = readInput("Day05_test")
    println(check(part1(testInput) == 5))
    println(check(part2(testInput) == 12))

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}