package com.example.sampleuiautomatorproject.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleuiautomatorproject.application.ozon.OzonApp
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OzonSearchTest : AbstractApplicationTest<OzonApp>(OzonApp()) {

    @Test
    fun testSearchJavaSuggestion() = with(app) {
        val searchText = "философия java"
        val expectedText = "Философия Java"
        val expectedPrice = "1 499\u2009\u20BD"
        open()
        enterSearchText(searchText)
        assertSuggestionTitle(expectedText)
        assertSuggestionPrice(expectedPrice)
    }
}