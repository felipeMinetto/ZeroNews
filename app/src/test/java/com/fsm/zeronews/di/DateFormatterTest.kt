package com.fsm.zeronews.di

import com.fsm.zeronews.mockDate
import com.fsm.zeronews.utils.DateFormatter
import org.junit.Assert.assertEquals
import org.junit.Test

class DateFormatterTest {

    @Test
    fun formatDate() {
        val expected = "03-08-2022"
        val result = DateFormatter.formatDate(mockDate)
        assertEquals(expected, result)
    }
}