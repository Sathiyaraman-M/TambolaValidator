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

    fun validate(numbersAnnounced: List<Int>, claim: String): Boolean {
        return when (claim) {
            "TOP_ROW" -> topRowValidator(numbersAnnounced)
            else -> false
        }
    }

}