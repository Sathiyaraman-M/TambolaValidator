package org.tambola.claimvalidator.validators

import org.tambola.claimvalidator.ticket.TambolaTicket

class EarlyFiveValidator : IValidator {
    override fun validate(ticket: TambolaTicket, announcedValues: List<Int>): Boolean {
        var count = 0

        announcedValues.forEachIndexed { index, value ->
            if (value in ticket.allElements) {
                count++
            }
            if (count == 5) {
                return index == (announcedValues.size - 1)
            }
        }

        return false
    }

}
