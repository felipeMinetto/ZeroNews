package com.fsm.zeronews.utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object DateFormatter {
    fun formatDate(date: String): String {
        val localDate = ZonedDateTime.parse(date)
        val format = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return localDate.format(format)
    }
}
