package com.example.sampleuiautomatorproject.application.ozon

import androidx.test.uiautomator.BySelector
import com.example.sampleuiautomatorproject.application.ScreenUtils
import com.example.sampleuiautomatorproject.application.ozon.OzonConstants.packageName
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.device
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import org.junit.Assert

class SearchScreen(private val searchEditText: BySelector = byStringRes("$packageName:id/search_src_text")) :
    BaseScreen(listOf(searchEditText)) {

    private val idTitleRes = "$packageName:id/titleTv"
    private val idPriceRes = "$packageName:id/priceTv"

    fun enterSearchText(text: String) {
        searchEditText.waitFindObject().text = text
        device.pressEnter()
    }

    fun openItemDetails(itemName: String): ItemScreen {
        byText(itemName).waitFindObject().click()
        return ScreenUtils.waitForScreen(ItemScreen())
    }

    fun assertSuggestionTitle(expectedTitle: String) {
        assertText(expectedTitle, idTitleRes)
    }

    fun assertSuggestionPrice(expectedPrice: String) {
        assertText(expectedPrice, idPriceRes)
    }
}

