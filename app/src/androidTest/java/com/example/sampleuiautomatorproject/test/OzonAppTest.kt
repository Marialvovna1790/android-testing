package com.example.sampleuiautomatorproject.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleuiautomatorproject.application.ScreenUtils
import com.example.sampleuiautomatorproject.application.ozon.OzonApp
import com.example.sampleuiautomatorproject.application.ozon.ProfileScreen
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OzonAppTest : AbstractApplicationTest<OzonApp>(OzonApp()) {
    private val searchText = "философия java"
    private val expectedItemText = "Философия Java"
    private val expectedItemPrice = "1 708\u2009\u20BD" // May change!


    @Test
    fun testSearchClickSuggestion() = with(app) {
        with(openMainScreen().openSearchScreen()) {
            enterSearchText(searchText)
            assertSuggestionTitle(expectedItemText)
            assertSuggestionPrice(expectedItemPrice)
        }
    }

    @Test
    fun testSearchAddFavorites() = with(app) {
        with(openMainScreen().openSearchScreen()) {
            enterSearchText(searchText)
            with(openItemDetails(expectedItemText)) {
                assertItemDetails(expectedItemText)
                makeFavorite()
                with(openFavoritesScreen()) {
                    // may be flaky because sometimes favorites
                    // screen opens with empty list...
                    assertItemExists(expectedItemText)
                }
            }
        }
    }

    @Test
    fun testAuthEmailValidation() = with(app) {
        val invalidEmail = "blahblag@"
        val validEmail = "test@example.com"
        with(openMainScreen().openProfileScreen()) {
            clickEnterByEmail()
            enterEmail(invalidEmail)
            submit()
            assertInvalidEmailError()
            enterEmail(validEmail)
            submit()
            assertNoInvalidEmailError()
        }
    }

    @Test
    fun testWriteCommentNoAuth() = with(app) {
        with(openMainScreen().openSearchScreen()) {
            enterSearchText(searchText)
            with(openItemDetails(expectedItemText)) {
                clickOnWriteComment()
                val screen = ScreenUtils.waitForScreen(ProfileScreen())
            }
        }
    }
}