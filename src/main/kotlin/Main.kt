import days.DayOne
import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    /**
     * DAY 1 - Calibration Document for Elves
     */

    // PART ONE
    val listOfStrings = mutableListOf<String>()
    val path = "/Users/christiancano/Desktop/advent-of-code"


    File("$path/d1p1.txt").useLines { lines ->
        lines.forEach {
            listOfStrings.add(it)
        }
    }

    val dayOne = DayOne()

    println("Calibration Code for first puzzle: " + dayOne.puzzleDayOne(listOfStrings))

    // PART TWO

    val listOfStringsTwo = mutableListOf<String>()

    fun String.replaceWordNumbers() =
        replace("one", "o1e")
            .replace("two", "t2")
            .replace("three", "t3e")
            .replace("four", "4")
            .replace("five", "5e")
            .replace("six", "6")
            .replace("seven", "7n")
            .replace("eight", "e8t")
            .replace("nine", "n9e")

    File("$path/d1p2.txt").useLines { lines ->
        lines.forEach {
            val replacedLine = it.replaceWordNumbers()
            listOfStringsTwo.add(replacedLine)
        }
    }

    println("Calibration Code for second puzzle: " + dayOne.puzzleDayOne(listOfStringsTwo))

}