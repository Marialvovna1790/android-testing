package com.example.sampleuiautomatorproject.application.ozon

import androidx.test.uiautomator.BySelector
import com.example.sampleuiautomatorproject.application.ozon.OzonConstants.packageName
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.device
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import com.example.sampleuiautomatorproject.util.ext.waitFindObjects
import org.junit.Assert

class ProfileScreen(
    private val enterByEmailSwitch: BySelector = byText("Войти по почте"),
    private val submitButton: BySelector = byStringRes("$packageName:id/submitBtn"),
    private val emailInput: BySelector = byStringRes("$packageName:id/emailEt"),
    private val inputErrorText: BySelector = byStringRes("$packageName:id/textinput_error"),
    private val invalidEmailError: String = "Некорректный формат почты"
) :
    BaseScreen(
        listOf(
            byText("Вход или регистрация")
        )
    ) {

    fun clickEnterByEmail() {
        enterByEmailSwitch.waitFindObject().click()
        emailInput.waitFindObject()
    }

    fun enterEmail(email: String) {
        emailInput.waitFindObject().text = email
        device.waitForIdle()
    }

    fun submit() {
        submitButton.waitFindObject().click()
    }

    fun assertNoInvalidEmailError() {
        Assert.assertFalse(inputErrorText.waitFindObjects().any {
            it.text == invalidEmailError
        })
    }

    fun assertInvalidEmailError() {
        Assert.assertTrue(inputErrorText.waitFindObjects().any {
            it.text == invalidEmailError
        })
    }
}
