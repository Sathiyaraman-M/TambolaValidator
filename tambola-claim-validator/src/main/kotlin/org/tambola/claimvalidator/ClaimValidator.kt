package org.tambola.claimvalidator

import org.tambola.claimvalidator.Constants.ClaimConstants.BOTTOM_ROW
import org.tambola.claimvalidator.Constants.ClaimConstants.FIRST_FIVE
import org.tambola.claimvalidator.Constants.ClaimConstants.FULL_HOUSE
import org.tambola.claimvalidator.Constants.ClaimConstants.MIDDLE_ROW
import org.tambola.claimvalidator.Constants.ClaimConstants.TOP_ROW
import org.tambola.claimvalidator.Constants.TicketConstants.BOTTOM_ROW_INDEX
import org.tambola.claimvalidator.Constants.TicketConstants.MIDDLE_ROW_INDEX
import org.tambola.claimvalidator.Constants.TicketConstants.TOP_ROW_INDEX
import org.tambola.claimvalidator.ticket.TambolaTicket

@Deprecated("Use IValidator-based implementations instead")
class ClaimValidator {
    @Deprecated("Use row-specific validators instead, such as TopRowValidator, MiddleRowValidator and BottomRowValidator")
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

    @Deprecated("Use EarlyFiveValidator class instead")
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

    @Deprecated("Use FullHouseValidator class instead")

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