package com.example.sampleuiautomatorproject.util

import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector

fun byStringRes(stringRes: String): BySelector = By.res(stringRes)

fun byText(text: String): BySelector = By.text(text)

fun byTextContains(text: String): BySelector = By.textContains(text)
