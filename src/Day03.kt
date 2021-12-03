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
        var oxygen = input
        var CO2 = input
        var index = 0
        while (true) {
            var oxygentemp = 0
            var CO2temp = 0

            for (str in oxygen) {
                if (str[index] == '1') oxygentemp++ else oxygentemp--
            }
            for (str in CO2) {
                if (str[index] == '1') CO2temp++ else CO2temp--
            }
            if (oxygen.size>1){
                when {
                    oxygentemp > 0 -> {
                        oxygen = oxygen.filter { it[index] == '1' }
                    }
                    oxygentemp == 0 -> {
                        oxygen = oxygen.filter { it[index] == '1' }
                    }
                    oxygentemp < 0 -> {
                        oxygen = oxygen.filter { it[index] == '0' }
                    }
                }
            }

            if (CO2.size>1){
                when {
                    CO2temp > 0 -> {
                        CO2 = CO2.filter{ it[index] == '0' }
                    }
                    CO2temp == 0 -> {
                        CO2 = CO2.filter{ it[index] == '0' }
                    }
                    CO2temp < 0 -> {
                        CO2 = CO2.filter{ it[index] == '1' }
                    }
                }
            }
            index++
            if (index >= input[0].length) break
        }
        var result = 0
        var result1 = 0
        for (i in 0..input[0].lastIndex) {
            if (oxygen[0][i] == '1') {
                result += 2.0.pow(oxygen[0].lastIndex - i).toInt()
            }
            if (CO2[0][i] == '1') {
                result1 += 2.0.pow(CO2[0].lastIndex - i).toInt()
            }
        }
        return result * result1
    }
    val testInput = readInput("Day03_test")
    println(check(part1(testInput) == 198))
    println(check(part2(testInput) == 230))

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}