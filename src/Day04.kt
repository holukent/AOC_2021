import java.io.File

fun main() {

    fun part1(input:List<String>): Int {
        val test = input[2].split(" ").filter { it == "" }
        var balls = listOf<String>()
        val bingo = mutableListOf<MutableList<List<String>>>()
        var temp1 = mutableListOf<List<String>>()

        for (i in 2..input.lastIndex) {
            if (input[i] == "") {
                bingo.add(temp1)
                temp1 = mutableListOf()
            }else {
                val list = input[i].split(" ").filterNot { it == "" || it == " "}
                println("list : $list ")
                val temp2 = mutableListOf<String>()
                for (j in input[i].split(" ")){
                    if (j != "") {
                        temp2.add(j)
                    }
                }
                temp1.add(temp2)
            }
        }
        bingo.add(temp1)
        bingo.forEach { println(it) }
        return 0
    }
    fun part2(input:List<String>): Int {
        return 0
    }


    val testInput = readInput("Day04_test")
    println(check(part1(testInput) == 0))
    println(check(part2(testInput) == 0))

    val input = readInput("Day04")
    println(part1(input))
//    println(part2(input))

}