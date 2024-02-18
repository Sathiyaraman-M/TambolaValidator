class FullHouseValidator : IValidator {
    override fun validate(ticket: TambolaTicket, announcedValues: List<Int>): Boolean {
        val countedElements = mutableSetOf<Int>()

        announcedValues.forEachIndexed { index, value ->
            if (value in ticket.allElements) {
                countedElements += value
            }
            if (countedElements.size == 15) {
                return index == (announcedValues.size - 1)
            }
        }

        return false
    }

}
