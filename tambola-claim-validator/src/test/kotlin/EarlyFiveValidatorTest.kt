import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class EarlyFiveValidatorTest {
    private lateinit var validator: IValidator
    private val ticket = TambolaTicket(
        setOf(4, 16, 48, 63, 76),
        setOf(7, 23, 38, 52, 80),
        setOf(9, 25, 56, 64, 83)
    )


    @Test
    fun `player made claim of early five immediately after crossing the first five elements should be accepted`() {
        validator = EarlyFiveValidator()
        val announcedNumbers = listOf(11, 12, 4, 23, 38, 23, 24, 25, 47, 48)
        val result = validator.validate(ticket, announcedNumbers)
        assertEquals(true, result)
    }
}