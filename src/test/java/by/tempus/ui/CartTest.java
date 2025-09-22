package by.tempus.ui;

import by.tempus.resources.DataGenerator;
import by.tempus.ui.pages.cartpage.CartPage;
import by.tempus.ui.pages.homePage.HomePage;
import by.tempus.ui.pages.cartpage.CartPageExpectedMessages;
import by.tempus.webDriver.WebDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {
    private CartPage cartPage;

    @BeforeEach
    public void setUp() {
        HomePage homePage = new HomePage();
        cartPage = new CartPage();
        homePage.openSite();
    }

    @Test
    @DisplayName("Verify empty cart display")
    public void viewEmptyCartTest() {
        cartPage.openCart();
        Assertions.assertEquals(CartPageExpectedMessages.EMPTY_CART_MESSAGE, cartPage.getEmptyCartMessageText());
    }

    @Test
    @DisplayName("Verify adding multiple different items to cart")
    public void addMultipleItemsToCartTest() {
        cartPage.clickCatalogButton();
        cartPage.clickWomenCategory();
        cartPage.selectFirstMichaelKorsWatch();
        cartPage.clickAddToCart().clickCatalogButton();
        cartPage.clickWomenCategory();
        cartPage.selectSecondMichaelKorsWatch();
        cartPage.clickAddToCart();
        cartPage.openCart();
        Assertions.assertEquals(2, cartPage.getCartItemCount());
    }

    @Test
    @DisplayName("Verify increasing and decreasing item quantity")
    public void increaseAndDecreaseItemQuantityTest() throws InterruptedException {

        cartPage.clickCatalogButton();
        cartPage.clickWomenCategory();
        cartPage.selectFirstMichaelKorsWatch();
        cartPage.clickAddToCart();
        cartPage.openCart();
        Assertions.assertEquals("1", cartPage.getItemQuantity());

        cartPage.increaseQuantity();
        Thread.sleep(1000);
        Assertions.assertEquals("2", cartPage.getItemQuantity());

        cartPage.decreaseQuantity();
        Thread.sleep(1000);
        Assertions.assertEquals("1", cartPage.getItemQuantity());
    }

    @Test
    @DisplayName("Verify complete cart clearing")
    public void clearCartTest() {
        cartPage.clickCatalogButton();
        cartPage.clickWomenCategory();
        cartPage.selectFirstMichaelKorsWatch();
        cartPage.clickAddToCart();
        cartPage.openCart();
        cartPage.clearCart();
        cartPage.openCart();
        Assertions.assertEquals(CartPageExpectedMessages.EMPTY_CART_MESSAGE, cartPage.getEmptyCartMessageText());
    }

    @Test
    @DisplayName("Verify error on checkout with invalid E-mail")
    public void verifyErrorOnCheckoutWithInvalidEmailTest() {
        cartPage.clickCatalogButton();
        cartPage.clickWomenCategory();
        cartPage.selectFirstMichaelKorsWatch();
        cartPage.clickAddToCart();
        cartPage.openCart();
        cartPage.fillCheckoutForm(DataGenerator.generateValidFullName(), DataGenerator.generateIncorrectEmail(), DataGenerator.generateValidPassword());
        cartPage.selectCityMinsk();
        cartPage.clickPlaceOrderButton();
        Assertions.assertEquals(CartPageExpectedMessages.INVALID_EMAIL_ERROR, cartPage.getIncorrectEmailErrorMessage());
    }

    @Test
    @DisplayName("Verify error on checkout with empty phone number")
    public void verifyErrorOnCheckoutWithEmptyPhoneNumberTest() {
        cartPage.clickCatalogButton();
        cartPage.clickWomenCategory();
        cartPage.selectFirstMichaelKorsWatch();
        cartPage.clickAddToCart();
        cartPage.openCart();
        cartPage.fillCheckoutForm(DataGenerator.generateValidFullName(), DataGenerator.generateValidEmail(), "");
        cartPage.selectCityMinsk();
        cartPage.clickPlaceOrderButton();
        Assertions.assertEquals(CartPageExpectedMessages.EMPTY_PHONE_FIELD_ERROR, cartPage.getEmptyPhoneErrorMessage(), "");
    }

    @Test
    @DisplayName("Verify navigation to catalog from empty cart")
    public void navigateToCatalogFromEmptyCartTest() {
        cartPage.openCart();
        cartPage.clickGoToCatalogFromEmptyCart();
        Assertions.assertTrue(WebDriver.getDriver().getCurrentUrl().contains("/catalog/"));
    }
}
