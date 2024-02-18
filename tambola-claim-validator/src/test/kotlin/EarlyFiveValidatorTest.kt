import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.tambola.claimvalidator.validators.EarlyFiveValidator
import org.tambola.claimvalidator.validators.IValidator
import org.tambola.claimvalidator.ticket.TambolaTicket
import org.tambola.claimvalidator.ticket.TambolaTicketRow

class EarlyFiveValidatorTest {
    private lateinit var validator: IValidator
    private val ticket = TambolaTicket(
        TambolaTicketRow(4, 16, 48, 63, 76),
        TambolaTicketRow(7, 23, 38, 52, 80),
        TambolaTicketRow(9, 25, 56, 64, 83)
    )

    @Test
    fun `player made claim of early five immediately after crossing the first five elements should be accepted`() {
        validator = EarlyFiveValidator()
        val announcedNumbers = listOf(11, 12, 4, 23, 38, 21, 24, 25, 47, 48)
        val result = validator.validate(ticket, announcedNumbers)
        assertEquals(true, result)
    }

    @Test
    fun `player made claim of early five after missing to claim immediately after crossing the first five elements should be rejected`() {
        validator = EarlyFiveValidator()
        val announcedNumbers = listOf(11, 12, 4, 23, 38, 21, 24, 25, 47, 48, 2)
        val result = validator.validate(ticket, announcedNumbers)
        assertEquals(false, result)
    }

    @Test
    fun `player made false claim of first five should be rejected`() {
        validator = EarlyFiveValidator()
        val announcedNumbers = listOf(1, 2, 4, 5, 7, 9)
        val result = validator.validate(ticket, announcedNumbers)
        assertEquals(false, result)
    }
}