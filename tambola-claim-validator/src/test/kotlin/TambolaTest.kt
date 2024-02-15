import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TambolaTest {

    @Test
    fun `player made claim of top row immediately after crossing all the elements of top row should be accepted`() {
        val ticket = listOf(
            listOf(4, 16, 48, 63, 76),
            listOf(7, 23, 38, 52, 80),
            listOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(90, 4, 46, 63, 89, 16, 76, 48)
        val claimMade = "TOP_ROW"

        val result = ClaimValidator(ticket).validate(numbersAnnounced, claimMade)
        assertTrue(result)
    }

    @Test
    fun `player made claim of top row after missing to claim immediately after crossing the elements of top row should be rejected`() {
        val ticket = listOf(
            listOf(4, 16, 48, 63, 76),
            listOf(7, 23, 38, 52, 80),
            listOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(90, 4, 46, 63, 89, 16, 76, 48, 55, 1)
        val claimMade = "TOP_ROW"

        val result = ClaimValidator(ticket).validate(numbersAnnounced, claimMade)
        assertFalse(result)
    }

}