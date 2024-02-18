import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FullHouseValidatorTest {
    private lateinit var validator: IValidator
    private val ticket = TambolaTicket(
        TambolaTicketRow(4, 16, 48, 63, 76),
        TambolaTicketRow(7, 23, 38, 52, 80),
        TambolaTicketRow(9, 25, 56, 64, 83)
    )

    @Test
    fun `player made claim of full house immediately after crossing all the elements should be accepted`() {
        validator = FullHouseValidator()
        val announcedNumbers = listOf(11, 12, 4, 23, 38, 23, 24, 25, 47, 48, 7, 16, 9, 52, 56, 57, 64, 60, 63, 76, 77, 79, 80, 83)
        val result = validator.validate(ticket, announcedNumbers)
        Assertions.assertEquals(true, result)
    }
}