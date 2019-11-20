package com.example.sampleuiautomatorproject.application.ozon

import androidx.test.uiautomator.BySelector
import com.example.sampleuiautomatorproject.application.ScreenUtils
import com.example.sampleuiautomatorproject.application.ozon.OzonConstants.packageName
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.secondsToMillis
import com.example.sampleuiautomatorproject.util.ext.waitFindObject

abstract class BaseScreenWithNavBar(
    selectors: List<BySelector>,
    val homeButton: BySelector = byStringRes("$packageName:id/menu_main"),
    val favoritesButton: BySelector = byStringRes("$packageName:id/menu_favorites"),
    val profileButton: BySelector = byStringRes("$packageName:id/menu_profile")
) : BaseScreen(
    listOf(homeButton, favoritesButton, profileButton) + selectors
) {

    fun openFavoritesScreen(): FavoritesScreen {
        favoritesButton.waitFindObject().click()
        return ScreenUtils.waitForScreen(FavoritesScreen())
    }

    fun openProfileScreen(): ProfileScreen {
        profileButton.waitFindObject(20.secondsToMillis()).click()
        return ScreenUtils.waitForScreen(ProfileScreen())
    }
}
