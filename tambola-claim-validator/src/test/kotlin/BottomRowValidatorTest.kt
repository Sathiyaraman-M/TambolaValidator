import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.tambola.claimvalidator.ticket.TambolaTicket
import org.tambola.claimvalidator.ticket.TambolaTicketRow
import org.tambola.claimvalidator.validators.BottomRowValidator
import org.tambola.claimvalidator.validators.IValidator

class BottomRowValidatorTest {
    private lateinit var validator: IValidator
    private val ticket = TambolaTicket(
        TambolaTicketRow(4, 16, 48, 63, 76),
        TambolaTicketRow(7, 23, 38, 52, 80),
        TambolaTicketRow(9, 25, 56, 64, 83)
    )

    @Test
    fun `player made claim of bottom row immediately after crossing all the elements of bottom row should be accepted`() {
        validator = BottomRowValidator()
        val announcedNumbers = listOf(90, 9, 44, 45, 25, 64, 22, 56, 88, 83)
        val result = validator.validate(ticket, announcedNumbers)
        Assertions.assertEquals(true, result)
    }
}