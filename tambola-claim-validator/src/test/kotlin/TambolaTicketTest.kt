import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.tambola.claimvalidator.ticket.TambolaTicket
import org.tambola.claimvalidator.ticket.TambolaTicketRow

class TambolaTicketTest {
    @Test
    fun `a tambola ticket should have a top row, middle row and bottom row`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83),
        )
        assertEquals(setOf(4, 16, 48, 63, 76), ticket.topRow)
        assertEquals(setOf(7, 23, 38, 52, 80), ticket.middleRow)
        assertEquals(setOf(9, 25, 56, 64, 83), ticket.bottomRow)
    }

    @Test
    fun `a tambola ticket should be able to created using tambola ticket rows`() {
        val ticket = TambolaTicket(
            TambolaTicketRow(4, 16, 48, 63, 76),
            TambolaTicketRow(7, 23, 38, 52, 80),
            TambolaTicketRow(9, 25, 56, 64, 83),
        )
        assertEquals(setOf(4, 16, 48, 63, 76), ticket.topRow)
        assertEquals(setOf(7, 23, 38, 52, 80), ticket.middleRow)
        assertEquals(setOf(9, 25, 56, 64, 83), ticket.bottomRow)
    }

    @Test
    fun `should get all the elements of the ticket`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83),
        )
        val allElements = ticket.allElements
        assertEquals(setOf(4, 16, 48, 63, 76, 7, 23, 38, 52, 80, 9, 25, 56, 64, 83), allElements)
    }

    @Test
    fun `should be able access any row in ticket by indexing operator`() {
        val ticket = TambolaTicket(
            setOf(4, 16, 48, 63, 76),
            setOf(7, 23, 38, 52, 80),
            setOf(9, 25, 56, 64, 83),
        )
        val topRow = ticket[0]
        val middleRow = ticket[1]
        val lastRow = ticket[2]
        assertEquals(setOf(4, 16, 48, 63, 76), topRow)
        assertEquals(setOf(7, 23, 38, 52, 80), middleRow)
        assertEquals(setOf(9, 25, 56, 64, 83), lastRow)
    }
}