package days

class DayThree {

    fun puzzleDayThree(engineParts: List<String>): Int {
        val (numbers, symbols) = parseLine(engineParts)
        return numbers
            .filter { number -> number.isAdjacentToAny(symbols) }
            .sumOf { it.toInt() }
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

        fun isAdjacentToAny(coordinates: Set<Coordinator>): Boolean =
            this.coordinates.intersect(coordinates).isNotEmpty()

        fun toInt(): Int =
            number.joinToString("").toInt()
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