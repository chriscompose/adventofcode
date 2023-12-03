package days

class DayThree {

    fun puzzleDayThree(engineParts: List<String>): Int {
        val (numbers, symbols) = parseLine(engineParts)
        return numbers
            .filter { number -> number.isAdjacent(symbols) }
            .sumOf { it.toInt() }
    }

    fun puzzleDayThreeSecondPart(engineParts: List<String>): Int {
        val (numbers, symbols) = parseLine(engineParts) { it == '*' }
        return symbols
            .sumOf { symbol ->
                val neighbors = numbers.filter { it.isAdjacentToStar(symbol) }
                if (neighbors.size == 2) {
                    neighbors.first().toInt() * neighbors.last().toInt()
                } else 0
            }
    }

    private fun parseLine(
        input: List<String>,
        specialChar: (Char) -> Boolean = { it != '.' }
    ): Pair<Set<NumberLocation>, Set<Coordinator>> {
        val numbers = mutableSetOf<NumberLocation>()
        val symbols = mutableSetOf<Coordinator>()
        var evaluatingNumber = NumberLocation()
        input
            .forEachIndexed { y, row ->
                row.forEachIndexed { x, character ->
                    if (character.isDigit()) {
                        evaluatingNumber.add(character, Coordinator(x, y))
                    } else {
                        if (evaluatingNumber.isNotEmpty()) {
                            numbers.add(evaluatingNumber)
                            evaluatingNumber = NumberLocation()
                        }
                        if (specialChar(character)) {
                            symbols.add(Coordinator(x, y))
                        }
                    }
                }
                if (evaluatingNumber.isNotEmpty()) {
                    numbers.add(evaluatingNumber)
                    evaluatingNumber = NumberLocation()
                }
            }
        return numbers to symbols
    }

    private class NumberLocation {
        val number = mutableListOf<Char>()
        val coordinates = mutableSetOf<Coordinator>()

        fun add(char: Char, coordinate: Coordinator) {
            number.add(char)
            coordinates.addAll(coordinate.adjacent())
        }

        fun isNotEmpty() =
            number.isNotEmpty()

        fun isAdjacent(coordinates: Set<Coordinator>): Boolean =
            this.coordinates.intersect(coordinates).isNotEmpty()

        fun toInt(): Int =
            number.joinToString("").toInt()

        fun isAdjacentToStar(coordinates: Coordinator): Boolean =
            coordinates in this.coordinates
    }

}

data class Coordinator(val x: Int, val y: Int) {
    fun adjacent(): Set<Coordinator> =
        setOf(
            Coordinator(x - 1, y - 1),
            Coordinator(x, y - 1),
            Coordinator(x + 1, y - 1),
            Coordinator(x - 1, y),
            Coordinator(x + 1, y),
            Coordinator(x - 1, y + 1),
            Coordinator(x, y + 1),
            Coordinator(x + 1, y + 1)
        )
}