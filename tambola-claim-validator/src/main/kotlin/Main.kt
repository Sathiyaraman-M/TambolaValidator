import Constants.ClaimConstants.TOP_ROW

fun main() {
    val ticket = TambolaTicket(setOf(1, 2, 3, 4, 5), setOf(1, 2, 3, 4, 5), setOf(1, 2, 3, 4, 5))
    val announcements = listOf(1, 2, 3, 4, 5)
    val claim = TOP_ROW
    val validator = ClaimValidator()
    val result = validator.validate(ticket, announcements, claim)
    println(if(result) "Accepted" else "Rejected")
}
