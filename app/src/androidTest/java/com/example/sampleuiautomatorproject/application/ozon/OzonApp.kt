package com.example.sampleuiautomatorproject.application.ozon

import com.example.sampleuiautomatorproject.application.AbstractApplication
import com.example.sampleuiautomatorproject.application.ScreenUtils

class OzonApp : AbstractApplication<MainScreen>(OzonConstants.packageName) {
    override fun createMainScreen() = ScreenUtils.waitForScreen(MainScreen())

}