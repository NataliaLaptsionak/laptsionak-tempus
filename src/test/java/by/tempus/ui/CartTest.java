package by.tempus.ui;

import by.tempus.resources.DataGenerator;
import by.tempus.ui.pages.cartpage.CartPage;
import by.tempus.ui.pages.HomePage;
import by.tempus.ui.pages.cartpage.CartPageExpectedMessages;
import by.tempus.webDriver.WebDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

    @BeforeEach
    public void openHomePage() {
        new HomePage().openSite();
    }

    @Test
    @DisplayName("Проверка отображения пустой корзины")
    public void viewEmptyCartTest() {
        CartPage cartPage = new CartPage();
        cartPage.openCart();

        Assertions.assertEquals(CartPageExpectedMessages.EMPTY_CART_MESSAGE, cartPage.getEmptyCartMessageText());
    }

    @Test
    @DisplayName("Проверка добавления нескольких разных товаров в корзину")
    public void addMultipleItemsToCartTest() {
        CartPage cartPage = new CartPage();

        cartPage.clickCatalogButton();
        cartPage.clickWomenCategory();
        cartPage.selectFirstMichaelKorsWatch();
        cartPage.clickAddToCart();

        cartPage.clickCatalogButton();
        cartPage.clickWomenCategory();
        cartPage.selectSecondMichaelKorsWatch();
        cartPage.clickAddToCart();

        cartPage.openCart();

        Assertions.assertEquals(2, cartPage.getCartItemCount());
    }

    @Test
    @DisplayName("Проверка увеличения и уменьшения количества товара")
    public void increaseAndDecreaseItemQuantityTest() throws InterruptedException {
        CartPage cartPage = new CartPage();

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
    @DisplayName("Проверка полной очистки корзины")
    public void clearCartTest() {
        CartPage cartPage = new CartPage();

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
    @DisplayName("Проверка ошибки при вводе невалидного E-mail")
    public void verifyErrorOnCheckoutWithInvalidEmailTest() {
        CartPage cartPage = new CartPage();

        cartPage.clickCatalogButton();
        cartPage.clickWomenCategory();
        cartPage.selectFirstMichaelKorsWatch();
        cartPage.clickAddToCart();
        cartPage.openCart();

        cartPage.fillCheckoutForm(DataGenerator.generateValidFullName(), DataGenerator.generateInvalidEmail(), DataGenerator.generateValidPassword());
        cartPage.selectCityMinsk();
        cartPage.clickPlaceOrderButton();

        Assertions.assertEquals(CartPageExpectedMessages.INVALID_EMAIL_ERROR, cartPage.getIncorrectEmailErrorMessage());
    }

    @Test
    @DisplayName("Проверка ошибки при незаполнении номера телефона")
    public void verifyErrorOnCheckoutWithEmptyPhoneNumberTest() {
        CartPage cartPage = new CartPage();

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
    @DisplayName("Проверка перехода в каталог из пустой корзины")
    public void navigateToCatalogFromEmptyCartTest() {
        CartPage cartPage = new CartPage();

        cartPage.openCart();
        cartPage.clickGoToCatalogFromEmptyCart();

        Assertions.assertTrue(WebDriver.getDriver().getCurrentUrl().contains("/catalog/"),
                "Не произошел переход на страницу каталога.");
    }
}
