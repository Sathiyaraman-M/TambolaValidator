package org.tambola.claimvalidator.validators

import org.tambola.claimvalidator.ticket.TambolaTicket

interface IValidator {
    fun validate(ticket: TambolaTicket, announcedValues: List<Int>): Boolean
}