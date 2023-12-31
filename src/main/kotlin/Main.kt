import days.DayFour
import days.DayOne
import days.DayThree
import days.DayTwo
import java.io.File

fun main() {

    val path = "/Users/christiancano/Desktop/advent-of-code/inputs"

    /**
     * DAY 1 - Calibration Document for Elves
     */

    // PART ONE
    val calibrationList = mutableListOf<String>()
    val dayOne = DayOne()

    File("$path/d1p1.txt").useLines { lines ->
        lines.forEach {
            calibrationList.add(it)
        }
    }
    println("Calibration Code for first puzzle: " + dayOne.puzzleDayOne(calibrationList))

    // PART TWO
    val calibrationListTwo = mutableListOf<String>()

    File("$path/d1p2.txt").useLines { lines ->
        lines.forEach {
            val replacedLine = dayOne.replaceWordNumbers(it)
            calibrationListTwo.add(replacedLine)
        }
    }
    println("Calibration Code for second puzzle: " + dayOne.puzzleDayOne(calibrationListTwo))

    /**
     * DAY 2 - Colour Cubes
     */

    // PART ONE
    val gamesList = mutableListOf<String>()
    val dayTwo = DayTwo()

    File("$path/d3p1.txt").useLines { lines ->
        lines.forEach {
            gamesList.add(it)
        }
    }
    println("Total sum of legit games: " + dayTwo.puzzleDayTwo(gamesList))

    // PART TWO
    println("Total sum of legit games with new rules: " + dayTwo.puzzleDayTwoSecondPart(gamesList))

    /**
     * DAY 3 - Engine Schematic List for Parts
     */

    // PART ONE
    val engineSchematicList = mutableListOf<String>()
    val dayThree = DayThree()

    File("$path/d3p1.txt").useLines { lines ->
        lines.forEach {
            engineSchematicList.add(it)
        }
    }
    println("Test Day Three: " + dayThree.puzzleDayThree(engineSchematicList))

    // PART TWO
    println("Test Day Three, second part: " + dayThree.puzzleDayThreeSecondPart(engineSchematicList))

    /**
     *  DAY 4 - Scratchcards & Winning Numbers
     */

    // PART ONE
    val scratchCards = mutableListOf<String>()
    val dayFour = DayFour()

    File("$path/d4p1.txt").useLines { lines ->
        lines.forEach {
            scratchCards.add(it)
        }
    }
    println("Total puzzle one, day four: " + dayFour.puzzleDayFour(scratchCards))

    // PART TWO
    println("Total puzzle two, day four: " + dayFour.puzzleDayFourSecondPart(scratchCards))
}