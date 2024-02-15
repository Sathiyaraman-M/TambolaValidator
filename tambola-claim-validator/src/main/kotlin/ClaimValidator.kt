import Constants.ClaimConstants.BOTTOM_ROW
import Constants.ClaimConstants.FIRST_FIVE
import Constants.ClaimConstants.FULL_HOUSE
import Constants.ClaimConstants.MIDDLE_ROW
import Constants.ClaimConstants.TOP_ROW
import Constants.NumericConstants.FIFTEEN
import Constants.NumericConstants.FIVE
import Constants.NumericConstants.ONE
import Constants.NumericConstants.ZERO
import Constants.TicketConstants.BOTTOM_ROW_INDEX
import Constants.TicketConstants.MIDDLE_ROW_INDEX
import Constants.TicketConstants.TOP_ROW_INDEX

class ClaimValidator(ticket: List<List<Int>>) {

    private val topRowElements = ticket[TOP_ROW_INDEX].toSet()
    private val middleRowElements = ticket[MIDDLE_ROW_INDEX].toSet()
    private val bottomRowElements = ticket[BOTTOM_ROW_INDEX].toSet()

    private val allElements = mutableSetOf<Int>()

    init {
        ticket.forEach { row ->
            row.forEach {
                allElements.add(it)
            }
        }
    }


    private fun topRowValidator(numbersAnnounced: List<Int>): Boolean {
        var count = ZERO

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in topRowElements) {
                count++
            }
            if (count == topRowElements.size) {
                return index == (numbersAnnounced.size - ONE)
            }
        }

        return false
    }


    private fun middleRowValidator(numbersAnnounced: List<Int>): Boolean {
        var count = ZERO

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in middleRowElements) {
                count++
            }
            if (count == middleRowElements.size) {
                return index == (numbersAnnounced.size - ONE)
            }
        }

        return false
    }

    private fun bottomRowValidator(numbersAnnounced: List<Int>): Boolean {
        var count = ZERO

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in bottomRowElements) {
                count++
            }
            if (count == bottomRowElements.size) {
                return index == (numbersAnnounced.size - ONE)
            }
        }

        return false
    }

    private fun firstFiveValidator(numbersAnnounced: List<Int>): Boolean {
        var count = ZERO

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in allElements) {
                count++
            }
            if (count == FIVE) {
                return index == (numbersAnnounced.size - ONE)
            }
        }

        return false
    }

    private fun fullHouseValidator(numbersAnnounced: List<Int>): Boolean {
        var count = ZERO

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in allElements) {
                count++
            }
            if (count == FIFTEEN) {
                return index == (numbersAnnounced.size - ONE)
            }
        }

        return false
    }

    fun validate(numbersAnnounced: List<Int>, claim: String) =
        when (claim) {
            TOP_ROW -> topRowValidator(numbersAnnounced)
            MIDDLE_ROW -> middleRowValidator(numbersAnnounced)
            BOTTOM_ROW -> bottomRowValidator(numbersAnnounced)
            FIRST_FIVE -> firstFiveValidator(numbersAnnounced)
            FULL_HOUSE -> fullHouseValidator(numbersAnnounced)
            else -> throw Exception("Invalid claim made")
        }

}