data class TambolaTicket(val topRow: Set<Int>, val middleRow: Set<Int>, val bottomRow: Set<Int>) {

    constructor(topRow: TambolaTicketRow, middleRow: TambolaTicketRow, bottomRow: TambolaTicketRow)
            : this(topRow.getRowElements(), middleRow.getRowElements(), bottomRow.getRowElements())

    val allElements = topRow + middleRow + bottomRow

    operator fun get(i: Int): Set<Int> {
        return when (i) {
            0 -> topRow
            1 -> middleRow
            2 -> bottomRow
            else -> throw IndexOutOfBoundsException("Index of the Ticket Row is out of bounds")
        }
    }
}
