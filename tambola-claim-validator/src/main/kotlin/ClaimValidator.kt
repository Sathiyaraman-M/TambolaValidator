class ClaimValidator(private val ticket: List<List<Int>>) {

    private fun topRowValidator(numbersAnnounced: List<Int>): Boolean {
        val topRowElements = ticket[0].toSet()
        val count = 0

        return false
    }

    fun validate(numbersAnnounced: List<Int>, claim: String): Boolean {
        return when (claim) {
            "TOP_ROW" -> topRowValidator(numbersAnnounced)
            else -> false
        }
    }

}