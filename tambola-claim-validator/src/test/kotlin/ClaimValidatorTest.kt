import Constants.ClaimConstants.BOTTOM_ROW
import Constants.ClaimConstants.FIRST_FIVE
import Constants.ClaimConstants.FULL_HOUSE
import Constants.ClaimConstants.MIDDLE_ROW
import Constants.ClaimConstants.TOP_ROW
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ClaimValidatorTest {

    @Test
    fun `player made claim of top row immediately after crossing all the elements of top row should be accepted`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(90, 4, 46, 63, 89, 16, 76, 48)
        val claimMade = TOP_ROW

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertTrue(result)
    }

    @Test
    fun `player made claim of top row after missing to claim immediately after crossing the elements of top row should be rejected`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(90, 4, 46, 63, 89, 16, 76, 48, 55, 1)
        val claimMade = TOP_ROW

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `player made false claim of top row should be rejected`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(1, 2, 3, 4, 5, 6)
        val claimMade = TOP_ROW

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `player made claim of middle row immediately after crossing all the elements of middle row should be accepted`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(23, 84, 7, 82, 52, 38, 48, 80)
        val claimMade = MIDDLE_ROW

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertTrue(result)
    }

    @Test
    fun `player made claim of middle row after missing to claim immediately after crossing the elements of middle row should be rejected`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(23, 84, 7, 82, 52, 38, 48, 80, 12)
        val claimMade = MIDDLE_ROW

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `player made false claim of middle row should be rejected`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(1, 2, 3, 4, 5, 6)
        val claimMade = MIDDLE_ROW

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }


    @Test
    fun `player made claim of bottom row immediately after crossing all the elements of bottom row should be accepted`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(90, 9, 44, 45, 25, 64, 22, 56, 88, 83)
        val claimMade = BOTTOM_ROW

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertTrue(result)
    }

    @Test
    fun `player made claim of bottom row after missing to claim immediately after crossing the elements of bottom row should be rejected`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(90, 9, 44, 45, 25, 64, 22, 56, 88, 83, 11, 12, 13)
        val claimMade = BOTTOM_ROW

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `player made false claim of bottom row should be rejected`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(1, 2, 3, 4, 5, 6)
        val claimMade = BOTTOM_ROW

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `player made claim of first five immediately after crossing the first five elements should be accepted`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(11, 12, 4, 23, 38, 23, 24, 25, 47, 48)
        val claimMade = FIRST_FIVE

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `player made claim of first five after missing to claim immediately after crossing the elements of first five should be rejected`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(4, 7, 9, 16, 22, 99, 25, 1, 2, 3)
        val claimMade = FIRST_FIVE

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `player made false claim of first five should be rejected`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(1, 2, 3, 4, 5, 6)
        val claimMade = FIRST_FIVE

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `player made claim of full house immediately after crossing all the elements should be accepted`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(11, 12, 4, 23, 38, 23, 24, 25, 47, 48, 7, 16, 9, 52, 56, 57, 64, 60, 63, 76, 77, 79, 80, 83)
        val claimMade = FULL_HOUSE

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `player made claim of full house after missing to claim immediately after crossing all the elements should be rejected`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(11, 12, 4, 23, 38, 23, 24, 25, 47, 48, 7, 16, 9, 52, 56, 57, 64, 60, 63, 76, 77, 79, 80, 83, 3)
        val claimMade = FULL_HOUSE

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `player made false claim of full house should be rejected`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83)
        )

        val numbersAnnounced = listOf(1, 2, 3, 4, 5, 6)
        val claimMade = FULL_HOUSE

        val result = ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        assertFalse(result)
    }

    @Test
    fun `invalid claim should throw Exception`() {
        val ticket = TambolaTicket(setOf(1, 2, 3), setOf(4, 5, 5), setOf(7, 8, 9))
        val numbersAnnounced = listOf(1, 2, 3, 4)
        val claimMade = "SOME_CLAIM_THAT_DOES_NOT_EXIST"
        assertThrows<Exception> {
            ClaimValidator().validate(ticket, numbersAnnounced, claimMade)
        }
    }

}