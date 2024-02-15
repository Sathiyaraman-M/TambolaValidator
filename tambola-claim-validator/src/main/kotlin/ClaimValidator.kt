import Constants.ClaimConstants.BOTTOM_ROW
import Constants.ClaimConstants.FIRST_FIVE
import Constants.ClaimConstants.FULL_HOUSE
import Constants.ClaimConstants.MIDDLE_ROW
import Constants.ClaimConstants.TOP_ROW
import Constants.TicketConstants.BOTTOM_ROW_INDEX
import Constants.TicketConstants.MIDDLE_ROW_INDEX
import Constants.TicketConstants.TOP_ROW_INDEX

class ClaimValidator(private val ticket: List<List<Int>>) {

    private val topRowElements = ticket[TOP_ROW_INDEX].toSet()
    private val middleRowElements = ticket[MIDDLE_ROW_INDEX].toSet()
    private val bottomRowElements = ticket[BOTTOM_ROW_INDEX].toSet()

    private val allElements = topRowElements + middleRowElements + bottomRowElements

    private fun rowWiseValidator(row: Int, numbersAnnounced: List<Int>): Boolean {
        var count = 0

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in ticket[row]) {
                count++
            }
            if (count == ticket[row].size) {
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

    private fun fullHouseValidator(numbersAnnounced: List<Int>): Boolean {
        var count = 0

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in allElements) {
                count++
            }
            if (count == 15) {
                return index == (numbersAnnounced.size - 1)
            }
        }

        return false
    }

    fun validate(numbersAnnounced: List<Int>, claim: String) =
        when (claim) {
            TOP_ROW -> rowWiseValidator(TOP_ROW_INDEX,numbersAnnounced)
            MIDDLE_ROW -> rowWiseValidator(MIDDLE_ROW_INDEX, numbersAnnounced)
            BOTTOM_ROW -> rowWiseValidator(BOTTOM_ROW_INDEX, numbersAnnounced)
            FIRST_FIVE -> firstFiveValidator(numbersAnnounced)
            FULL_HOUSE -> fullHouseValidator(numbersAnnounced)
            else -> throw Exception("Invalid claim made")
        }

}