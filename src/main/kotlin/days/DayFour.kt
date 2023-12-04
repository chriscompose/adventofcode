package days

import kotlin.math.pow

class DayFour {

    fun puzzleDayFour(scratchcards: List<String>): Int {
        val matchedNumbers = scratchcards.map { sanitiseCard(it) }
        return matchedNumbers.sumOf { 2.0.pow(it - 1).toInt() }
    }

    fun puzzleDayFourSecondPart(scratchcards: List<String>): Int {
        val matchedNumbers = scratchcards.map { sanitiseCard(it) }
        val totalCards = IntArray(matchedNumbers.size) { 1 }
        matchedNumbers.forEachIndexed { index, score ->
            repeat(score) {
                totalCards[index+it+1] += totalCards[index]
            }
        }
        return totalCards.sum()
    }

}

private fun sanitiseCard(card: String): Int {
    val winningNumbers = card
        .substringAfter(":")
        .substringBefore("|")
        .split(" ")
        .filter { it.isNotEmpty() }
        .toSet()
    val scratchedNumbers = card
        .substringAfter("|")
        .split(" ")
        .filter { it.isNotEmpty() }.toSet()
    return winningNumbers
        .intersect(scratchedNumbers)
        .size
}