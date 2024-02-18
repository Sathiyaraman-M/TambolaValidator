class TambolaTicketRow(
    private val value1: Int,
    private val value2: Int,
    private val value3: Int,
    private val value4: Int,
    private val value5: Int
) {
    fun getRowElements() : Set<Int> = setOf(value1, value2, value3, value4, value5)
}
