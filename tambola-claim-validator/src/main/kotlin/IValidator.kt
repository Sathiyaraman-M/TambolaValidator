interface IValidator {
    fun validate(ticket: TambolaTicket, announcedValues: List<Int>): Boolean
}