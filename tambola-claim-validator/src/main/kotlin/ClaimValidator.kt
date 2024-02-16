import Constants.ClaimConstants.BOTTOM_ROW
import Constants.ClaimConstants.FIRST_FIVE
import Constants.ClaimConstants.FULL_HOUSE
import Constants.ClaimConstants.MIDDLE_ROW
import Constants.ClaimConstants.TOP_ROW
import Constants.TicketConstants.BOTTOM_ROW_INDEX
import Constants.TicketConstants.MIDDLE_ROW_INDEX
import Constants.TicketConstants.TOP_ROW_INDEX

class ClaimValidator {

    private fun rowWiseValidator(ticket: TambolaTicket, row: Int, numbersAnnounced: List<Int>): Boolean {
        var count = 0

        if(row !in 0..2) {
            throw IndexOutOfBoundsException("Tambola tickets only has 3 rows from 0 to 2")
        }

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

    private fun firstFiveValidator(ticket: TambolaTicket, numbersAnnounced: List<Int>): Boolean {
        var count = 0

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in ticket.allElements) {
                count++
            }
            if (count == 5) {
                return index == (numbersAnnounced.size - 1)
            }
        }

        return false
    }

    private fun fullHouseValidator(ticket: TambolaTicket, numbersAnnounced: List<Int>): Boolean {
        var count = 0

        numbersAnnounced.forEachIndexed { index, value ->
            if (value in ticket.allElements) {
                count++
            }
            if (count == 15) {
                return index == (numbersAnnounced.size - 1)
            }
        }

        return false
    }

    fun validate(ticket: TambolaTicket, numbersAnnounced: List<Int>, claim: String) =
        when (claim) {
            TOP_ROW -> rowWiseValidator(ticket, TOP_ROW_INDEX,numbersAnnounced)
            MIDDLE_ROW -> rowWiseValidator(ticket, MIDDLE_ROW_INDEX, numbersAnnounced)
            BOTTOM_ROW -> rowWiseValidator(ticket, BOTTOM_ROW_INDEX, numbersAnnounced)
            FIRST_FIVE -> firstFiveValidator(ticket, numbersAnnounced)
            FULL_HOUSE -> fullHouseValidator(ticket, numbersAnnounced)
            else -> throw Exception("Invalid claim made")
        }

}