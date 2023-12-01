package days

class DayOne {

    fun puzzleDayOne(calibrationDoc: List<String>): Int {
        val listToSum = calculateNumbersInLines(calibrationDoc)
        var calibratedNumber = 0
        listToSum.forEach {
            calibratedNumber += it
        }
        return calibratedNumber
    }



    private fun calculateNumbersInLines(calibrationDoc: List<String>): List<Int> {
        var listOfNums = mutableListOf<Int>()

        calibrationDoc.forEach {
            val digitOne = pickFirstNumber(it)
            val digitTwo = pickFirstNumber(it.reversed())
            val listItem = "$digitOne$digitTwo".toInt()
            listOfNums.add(listItem)
        }
        return listOfNums
    }

    private fun pickFirstNumber(line: String): Int {

        var firstNumber = 0

        line.toCharArray().forEach {
            if (it.isDigit()) {
                firstNumber = it.digitToInt()
                if (firstNumber != 0) {
                    return firstNumber
                }
            }
        }
        return firstNumber
    }
}