import Constants.ClaimConstants.BOTTOM_ROW
import Constants.ClaimConstants.FIRST_FIVE
import Constants.ClaimConstants.TOP_ROW

class ClaimValidator(ticket: List<List<Int>>) {

    private val topRowElements = ticket[0].toSet()
    private val bottomRowElements = ticket[2].toSet()

    private val allElements = mutableSetOf<Int>()

    init {
        ticket.forEach { row ->
            row.forEach {
                allElements.add(it)
            }
        }
    }


    private fun topRowValidator(numbersAnnounced: List<Int>): Boolean {
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

    private fun firstFiveValidator(numbersAnnounced: List<Int>): Boolean {
        var count = 0

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in allElements) {
                count++
            }
            if (count == 5) {
                return index == (numbersAnnounced.size - 1)
            }
        }

        return false
    }

    fun validate(numbersAnnounced: List<Int>, claim: String): Boolean {
        return when (claim) {
            TOP_ROW -> topRowValidator(numbersAnnounced)
            BOTTOM_ROW -> bottomRowValidator(numbersAnnounced)
            FIRST_FIVE -> firstFiveValidator(numbersAnnounced)
            else -> false
        }
    }

}