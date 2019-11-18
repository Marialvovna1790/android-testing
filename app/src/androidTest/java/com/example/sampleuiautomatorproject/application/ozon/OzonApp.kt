package com.example.sampleuiautomatorproject.application.ozon

import com.example.sampleuiautomatorproject.application.AbstractApplication
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import org.junit.Assert


class OzonApp : AbstractApplication("ru.ozon.app.android") {

    private val searchPanel = byStringRes("$packageName:id/searchTv")
    private val searchEditText = byStringRes("$packageName:id/search_src_text")

    private val idTitleRes = "$packageName:id/titleTv"
    private val idPriceRes = "$packageName:id/priceTv"


    fun openSearchScreen() {
        /* TODO */
    }

    fun enterSearchText(text: String) {
        openSearch()
        searchEditText.waitFindObject().text = text
    }

    fun assertSuggestionTitle(expectedTitle: String) {
        assertText(expectedTitle, idTitleRes)
    }

    fun assertSuggestionPrice(expectedPrice: String) {
        assertText(expectedPrice, idPriceRes)
    }

    private fun assertText(expected: String, selector: String) {
        val uiElement = byText(expected)
            .waitFindObject(15)
        Assert.assertEquals(uiElement.resourceName, selector)
    }

    fun openSearch() {
        searchPanel.waitFindObject().click(20)
    }

}