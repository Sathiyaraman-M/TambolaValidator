import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TopRowValidatorTest {
    private lateinit var validator: IValidator
    private val ticket = TambolaTicket(
        TambolaTicketRow(4, 16, 48, 63, 76),
        TambolaTicketRow(7, 23, 38, 52, 80),
        TambolaTicketRow(9, 25, 56, 64, 83)
    )

    @Test
    fun `player made claim of top row immediately after crossing all the elements of top row should be accepted`() {
        validator = TopRowValidator()
        val announcedNumbers = listOf(90, 4, 46, 63, 89, 16, 76, 48)
        val result = validator.validate(ticket, announcedNumbers)
        Assertions.assertEquals(true, result)
    }

    @Test
    fun `player made claim of top row after failing to claim immediately after crossing all the elements of top row should be rejected`() {
        validator = TopRowValidator()
        val announcedNumbers = listOf(90, 4, 46, 63, 89, 16, 76, 48, 3)
        val result = validator.validate(ticket, announcedNumbers)
        Assertions.assertEquals(false, result)
    }

    @Test
    fun `player made false claim of top row should be rejected`() {
        validator = TopRowValidator()
        val announcedNumbers = listOf(1, 2, 3, 4, 6, 7)
        val result = validator.validate(ticket, announcedNumbers)
        Assertions.assertEquals(false, result)
    }
}