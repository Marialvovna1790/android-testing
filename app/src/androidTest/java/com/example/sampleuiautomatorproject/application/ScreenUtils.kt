package com.example.sampleuiautomatorproject.application

import com.example.sampleuiautomatorproject.application.ozon.BaseScreen
import com.example.sampleuiautomatorproject.util.device

object ScreenUtils {
    private val MAX_TRY_COUNT_SCREEN_MATCH = 3

    fun <T : BaseScreen> waitForScreen(screen: T): T {
        for (i in 1..MAX_TRY_COUNT_SCREEN_MATCH) {
            if (screen.match()) {
                device.waitForIdle()
                return screen
            }
        }
        throw ScreenNotAppearedException(screen.javaClass.simpleName)
    }
}