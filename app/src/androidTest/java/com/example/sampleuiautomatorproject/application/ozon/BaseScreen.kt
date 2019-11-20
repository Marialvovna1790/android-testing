package com.example.sampleuiautomatorproject.application.ozon

import androidx.test.uiautomator.BySelector
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.secondsToMillis
import com.example.sampleuiautomatorproject.util.ext.tryWaitFindObject
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import org.junit.Assert

abstract class BaseScreen(private val selectors: List<BySelector>) {

    open fun match() = selectors.all {
        it.tryWaitFindObject() != null
    }

    fun assertText(expected: String, selector: String) {
        val uiElement = byText(expected)
            .waitFindObject(15.secondsToMillis())
        Assert.assertEquals(uiElement.resourceName, selector)
    }
}