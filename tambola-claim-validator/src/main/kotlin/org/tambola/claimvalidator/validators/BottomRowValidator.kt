package org.tambola.claimvalidator.validators

import org.tambola.claimvalidator.ticket.TambolaTicket

class BottomRowValidator : IValidator {
    override fun validate(ticket: TambolaTicket, announcedValues: List<Int>): Boolean {
        return true
    }
}
