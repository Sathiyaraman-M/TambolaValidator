class ClaimValidator(private val ticket: List<List<Int>>) {

    private fun topRowValidator(numbersAnnounced: List<Int>): Boolean {
        val topRowElements = ticket[0].toSet()
        var count = 0

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in topRowElements) {
                count++
            }
            if (count == topRowElements.size) {
                return index == (numbersAnnounced.size - 1)
            }
        }

        return false
    }

    private fun bottomRowValidator(numbersAnnounced: List<Int>): Boolean {
        val bottomRowElements = ticket[2].toSet()
        var count = 0

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in bottomRowElements) {
                count++
            }
            if (count == bottomRowElements.size) {
                return index == (numbersAnnounced.size - 1)
            }
        }

        return false
    }

    fun validate(numbersAnnounced: List<Int>, claim: String): Boolean {
        return when (claim) {
            "TOP_ROW" -> topRowValidator(numbersAnnounced)
            "BOTTOM_ROW" -> bottomRowValidator(numbersAnnounced)
            else -> false
        }
    }

}