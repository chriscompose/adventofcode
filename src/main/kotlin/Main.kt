import days.DayOne
import java.io.File

fun main() {

    /**
     * DAY 1 - Calibration Document for Elves
     */

    // PART ONE
    val listOfStrings = mutableListOf<String>()
    val path = "/Users/christiancano/Desktop/advent-of-code"
    val dayOne = DayOne()

    File("$path/d1p1.txt").useLines { lines ->
        lines.forEach {
            listOfStrings.add(it)
        }
    }
    println("Calibration Code for first puzzle: " + dayOne.puzzleDayOne(listOfStrings))

    // PART TWO
    val listOfStringsTwo = mutableListOf<String>()

    File("$path/d1p2.txt").useLines { lines ->
        lines.forEach {
            val replacedLine = dayOne.replaceWordNumbers(it)
            listOfStringsTwo.add(replacedLine)
        }
    }
    println("Calibration Code for second puzzle: " + dayOne.puzzleDayOne(listOfStringsTwo))

    /**
     *  DAY 2 - Title
     */

    // PART ONE
}