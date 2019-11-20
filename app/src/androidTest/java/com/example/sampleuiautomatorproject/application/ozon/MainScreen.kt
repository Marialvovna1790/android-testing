package com.example.sampleuiautomatorproject.application.ozon

import androidx.test.uiautomator.BySelector
import com.example.sampleuiautomatorproject.application.ScreenUtils
import com.example.sampleuiautomatorproject.application.ozon.OzonConstants.packageName
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.secondsToMillis
import com.example.sampleuiautomatorproject.util.ext.waitFindObject

class MainScreen(
    private val searchPanel: BySelector = byStringRes("$packageName:id/searchTv")
) : BaseScreenWithNavBar(listOf(searchPanel)) {

    fun openSearchScreen(): SearchScreen {
        searchPanel.waitFindObject(20.secondsToMillis()).click()
        return ScreenUtils.waitForScreen(SearchScreen())
    }
}