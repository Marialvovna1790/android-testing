package com.example.sampleuiautomatorproject.application.ozon

import androidx.test.uiautomator.BySelector
import com.example.sampleuiautomatorproject.application.ozon.OzonConstants.packageName
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.waitFindObjects
import org.junit.Assert

class FavoritesScreen(
    toolbarTitle: BySelector = byText("Избранное"),
    private val itemTitleSelector: BySelector = byStringRes("$packageName:id/titleTv")
) : BaseScreenWithNavBar(
    listOf(toolbarTitle)
) {

    fun assertItemExists(itemTitle: String) {
        Assert.assertTrue(itemTitleSelector.waitFindObjects().any {
            it.text.contains(itemTitle)
        })
    }
}