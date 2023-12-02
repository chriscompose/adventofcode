package days

class DayTwo {

    /**
     *  RED > 12 CUBES
     *  GREEN > 13 CUBES
     *  BLUE > 14 CUBES
     */

    fun puzzleDayTwo(games: List<String>): Int {

        var sumOfPossibleGames = 0

        games.map {
            val redCubes = it.regexColours("red")
            val greenCubes = it.regexColours("green")
            val blueCubes = it.regexColours("blue")
            if (redCubes <= 12 && greenCubes <= 13 && blueCubes <= 14) {
                sumOfPossibleGames += Regex("\\d+").find(it)?.value?.toInt() ?: 0
            }
        }
        return sumOfPossibleGames
    }

    private fun String.regexColours(color: String): Int {
        return Regex("\\d+(?= $color)")
            .findAll(this)
            .toList()
            .maxOfOrNull {
                it.value.toInt()
            } ?: 0
    }
}