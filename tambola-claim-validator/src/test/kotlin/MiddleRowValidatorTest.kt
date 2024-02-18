import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MiddleRowValidatorTest {
    private lateinit var validator: IValidator
    private val ticket = TambolaTicket(
        TambolaTicketRow(4, 16, 48, 63, 76),
        TambolaTicketRow(7, 23, 38, 52, 80),
        TambolaTicketRow(9, 25, 56, 64, 83)
    )

    @Test
    fun `player made claim of middle row immediately after crossing all the elements of middle row should be accepted`() {
        validator = MiddleRowValidator()
        val announcedNumbers = listOf(23, 84, 7, 82, 52, 38, 48, 80)
        val result = validator.validate(ticket, announcedNumbers)
        Assertions.assertEquals(true, result)
    }

    @Test
    fun `player made claim of middle row after failing to claim immediately after crossing all the elements of middle row should be rejected`() {
        validator = MiddleRowValidator()
        val announcedNumbers = listOf(23, 84, 7, 82, 52, 38, 48, 80, 12)
        val result = validator.validate(ticket, announcedNumbers)
        Assertions.assertEquals(false, result)
    }

    @Test
    fun `player made false claim of middle row should be rejected`() {
        validator = MiddleRowValidator()
        val announcedNumbers = listOf(1, 2, 3, 5, 9)
        val result = validator.validate(ticket, announcedNumbers)
        Assertions.assertEquals(false, result)
    }
}