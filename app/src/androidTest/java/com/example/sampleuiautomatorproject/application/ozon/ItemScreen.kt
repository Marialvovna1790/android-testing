package com.example.sampleuiautomatorproject.application.ozon

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.example.sampleuiautomatorproject.application.ozon.OzonConstants.packageName
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.device
import com.example.sampleuiautomatorproject.util.ext.findObject
import com.example.sampleuiautomatorproject.util.ext.waitFindObject

class ItemScreen(
    private val favoriteSelector: BySelector = byStringRes("$packageName:id/favoritesIv"),
    shareSelector: BySelector = byStringRes("$packageName:id/shareIv")
) :
    BaseScreenWithNavBar(listOf(favoriteSelector, shareSelector)) {


    fun assertItemDetails(itemTitle: String) {
        byText(itemTitle).waitFindObject()
    }

    fun clickOnWriteComment() {
        val btnText = "Написать отзыв"
        val scrollable = UiScrollable(UiSelector().scrollable(true))
        scrollable.scrollTextIntoView(btnText)
        byText(btnText).waitFindObject().click()
    }

    fun makeFavorite() {
        device.waitForIdle()
        favoriteSelector.waitFindObject().click()
    }
}