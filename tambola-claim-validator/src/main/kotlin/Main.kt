import org.tambola.claimvalidator.ticket.TambolaTicket
import org.tambola.claimvalidator.ticket.TambolaTicketRow
import org.tambola.claimvalidator.validators.TopRowValidator

fun main() {
    val ticket = TambolaTicket(
        TambolaTicketRow(1, 2, 3, 4, 5),
        TambolaTicketRow(1, 2, 3, 4, 5),
        TambolaTicketRow(1, 2, 3, 4, 5)
    )
    val announcements = listOf(1, 2, 3, 4, 5)
    val validator = TopRowValidator()
    val result = validator.validate(ticket, announcements)
    println(if(result) "Accepted" else "Rejected")
}
