class ClaimValidator(private val ticket: List<List<Int>>) {

    fun topRowValidator(numbersAnnounced: List<Int>): Boolean {
        val topRowElements = ticket[0].toSet()
        val count = 0

        return false
    }

    fun validate(numbersAnnounced: List<Int>, claim: String): Boolean {
        return true
    }

}