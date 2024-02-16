data class TambolaTicket(val topRow: Set<Int>, val middleRow: Set<Int>, val bottomRow: Set<Int>) {
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
