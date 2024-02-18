package org.tambola.claimvalidator

@Deprecated(message = "These constants are used only in the ClaimValidator class which is marked deprecated in favour of new IValidator-based implementations")
object Constants {
    object ClaimConstants {
        const val TOP_ROW = "TOP_ROW"
        const val MIDDLE_ROW = "MIDDLE_ROW"
        const val BOTTOM_ROW = "BOTTOM_ROW"
        const val FIRST_FIVE = "FIRST_FIVE"
        const val FULL_HOUSE = "FULL_HOUSE"
    }

    object TicketConstants {
        const val TOP_ROW_INDEX = 0
        const val MIDDLE_ROW_INDEX = 1
        const val BOTTOM_ROW_INDEX = 2
    }

}