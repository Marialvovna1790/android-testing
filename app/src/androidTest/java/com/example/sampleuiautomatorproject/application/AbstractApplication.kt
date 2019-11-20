package com.example.sampleuiautomatorproject.application

import android.content.Intent
import com.example.sampleuiautomatorproject.application.ozon.BaseScreen
import com.example.sampleuiautomatorproject.application.ozon.MainScreen
import com.example.sampleuiautomatorproject.util.context
import com.example.sampleuiautomatorproject.util.device
import com.example.sampleuiautomatorproject.util.ext.secondsToMillis
import org.junit.Assert.assertNotNull

abstract class AbstractApplication<T : BaseScreen>(val packageName: String) {

    open fun openMainScreen() : T {
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)?.apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        device.pressHome()
        context.startActivity(intent)
        device.waitForIdle()
        return createMainScreen()
    }

    abstract fun createMainScreen() : T

    fun assertInstalled() {
        assertNotNull(
            "App $packageName is not installed",
            context.packageManager.getLaunchIntentForPackage(packageName)
        )
    }

}
