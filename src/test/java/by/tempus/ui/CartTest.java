package by.tempus.ui;

import by.tempus.CartPage;
import by.tempus.HomePage;
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

        String expectedMessage = "В вашей корзине пока ничего нет.";
        Assertions.assertTrue(cartPage.getEmptyCartMessageText().contains(expectedMessage),
                "Сообщение о пустой корзине неверное.");
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

        Assertions.assertEquals(2, cartPage.getCartItemCount(),
                "Количество уникальных товаров в корзине не равно двум.");
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

        Assertions.assertEquals("1", cartPage.getItemQuantity(), "Начальное количество товара не равно 1.");

        cartPage.increaseQuantity();
        Thread.sleep(1000); // Пауза для AJAX
        Assertions.assertEquals("2", cartPage.getItemQuantity(), "Количество товара не увеличилось до 2.");

        cartPage.decreaseQuantity();
        Thread.sleep(1000); // Пауза для AJAX
        Assertions.assertEquals("1", cartPage.getItemQuantity(), "Количество товара не уменьшилось до 1.");
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
        String expectedMessage = "В вашей корзине пока ничего нет.";
        Assertions.assertTrue(cartPage.getEmptyCartMessageText().contains(expectedMessage),
                "Сообщение о пустой корзине не появилось после очистки.");
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

        cartPage.fillCheckoutForm("Тестов Тест Тестович", "invalid-email", "+375291111111");
        cartPage.selectCityMinsk();
        cartPage.clickPlaceOrderButton();

        String expectedMessage = "Некорректный E-Mail";

        Assertions.assertEquals(expectedMessage, cartPage.getIncorrectEmailErrorMessage(),
                "Сообщение об ошибке не появилось или его текст неверный.");
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

        cartPage.fillCheckoutForm("Тестов Тест Тестович", "test8@gmail.com", "");
        cartPage.selectCityMinsk();
        cartPage.clickPlaceOrderButton();

        String expectedMessage = "\"Телефон\": обязательно для заполнения";

        Assertions.assertEquals(expectedMessage, cartPage.getEmptyPhoneErrorMessage(),
                "Сообщение об ошибке не появилось или его текст неверный.");
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
