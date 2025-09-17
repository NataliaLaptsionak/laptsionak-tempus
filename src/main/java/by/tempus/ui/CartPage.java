package by.tempus.ui;

import by.tempus.webDriver.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {

    private final String HEADER_CART_ICON = "//a[@class='icons__action icons__action--cart']";
    private final String HEADER_CATALOG_BUTTON = "//button[@class='header__catalog-btn']";
    private final String CATEGORY_WOMEN = "//div[@class='text-container' and contains(., 'Женские')]";
    private final String PRODUCT_MICHAEL_KORS_MK7337 = "//a[@title='Michael Kors  Lennox MK7337']";
    private final String PRODUCT_MICHAEL_KORS_MK7325 = "//a[@title='Michael Kors Runway MK7325']";
    private final String ADD_TO_CART_BUTTON = "//div[contains(@class, 'product-page-main__actions')]//div[normalize-space()='Добавить в корзину']";
    private final String CLEAR_CART_BUTTON = "//button[@class='clear']";
    private final String ITEM_INCREASE_QUANTITY_BUTTON = "//div[@class='cart-item-counter__button is-plus']";
    private final String ITEM_DECREASE_QUANTITY_BUTTON = "//div[@class='cart-item-counter__button is-minus']";
    private final String CART_ITEMS_LIST = "//span[@class='icons__counter icons__counter--cart']";
    private final String ITEM_QUANTITY_INPUT = "//input[@class='cart-item-counter__field h6']";
    private final String EMPTY_CART_MESSAGE_BLOCK = "//div[@class='empty-cart' and contains(., 'В вашей корзине пока ничего нет.')]";
    private final String GO_TO_CATALOG_BUTTON_FROM_EMPTY_CART = "//a[@class='catalog-button']";
    private final String FULL_NAME_INPUT = "//input[@id='ORDER_PROP_19']";
    private final String EMAIL_INPUT = "//input[@id='ORDER_PROP_20']";
    private final String PHONE_INPUT = "//input[@id='ORDER_PROP_21']";
    private final String CITY_MINSK_TAG = "//a[@class='quick-location-tag' and contains(., 'Минск')]";
    private final String PAYMENT_CASH_RADIO = "//span[@class='order-variant-box__content' and contains(., 'Наличные')]";
    private final String PLACE_ORDER_BUTTON = "//a[contains(@class, 'order-page__final-button')]";
    private final String INCORRECT_EMAIL_CART_ERROR_MESSAGE = "//font[normalize-space()='Некорректный E-Mail']";
    private final String EMPTY_PHONE_CART_ERROR_MESSAGE = "//font[normalize-space()='\"Телефон\": обязательно для заполнения']";

    public CartPage clickCatalogButton() {
        WebDriver.clickElement(HEADER_CATALOG_BUTTON);
        return this;
    }

    public CartPage clickWomenCategory() {
        WebDriver.clickElement(CATEGORY_WOMEN);
        return this;
    }

    public CartPage selectFirstMichaelKorsWatch() {
        WebDriver.clickElement(PRODUCT_MICHAEL_KORS_MK7337);
        return this;
    }

    public CartPage selectSecondMichaelKorsWatch() {
        WebDriver.clickElement(PRODUCT_MICHAEL_KORS_MK7325);
        return this;
    }

    public CartPage clickAddToCart() {
        WebDriver.clickElement(ADD_TO_CART_BUTTON);
        return this;
    }

    public CartPage openCart() {
        WebDriver.clickElement(HEADER_CART_ICON);
        return this;
    }

    public CartPage increaseQuantity() {
        WebDriver.clickElement(ITEM_INCREASE_QUANTITY_BUTTON);
        return this;
    }

    public CartPage decreaseQuantity() {
        WebDriver.clickElement(ITEM_DECREASE_QUANTITY_BUTTON);
        return this;
    }

    public CartPage clearCart() {
        WebDriver.clickElement(CLEAR_CART_BUTTON);
        return this;
    }

    public CartPage fillCheckoutForm(String fullName, String email, String phone) {
        WebDriver.sendkeysToElement(FULL_NAME_INPUT, fullName);
        WebDriver.sendkeysToElement(EMAIL_INPUT, email);
        WebDriver.sendkeysToElement(PHONE_INPUT, phone);
        return this;
    }

    public CartPage selectCityMinsk() {
        WebDriver.clickElement(CITY_MINSK_TAG);
        return this;
    }

    public CartPage selectPaymentByCash() {
        WebDriver.clickElement(PAYMENT_CASH_RADIO);
        return this;
    }

    public void clickGoToCatalogFromEmptyCart() {
        WebDriver.clickElement(GO_TO_CATALOG_BUTTON_FROM_EMPTY_CART);
    }

    public int getCartItemCount() {
        WebDriverWait wait = new WebDriverWait(WebDriver.getDriver(), Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CART_ITEMS_LIST)));
            return WebDriver.getDriver().findElements(By.xpath(CART_ITEMS_LIST)).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getItemQuantity() {
        return WebDriver.findElement(ITEM_QUANTITY_INPUT).getAttribute("value");
    }

    public String getEmptyCartMessageText() {
        return WebDriver.getTextFromElement(EMPTY_CART_MESSAGE_BLOCK);
    }

    public void clickPlaceOrderButton() {
        WebDriver.clickElement(PLACE_ORDER_BUTTON);
    }

    public String getIncorrectEmailErrorMessage() {
        return WebDriver.getTextFromElement(INCORRECT_EMAIL_CART_ERROR_MESSAGE);
    }

    public String getEmptyPhoneErrorMessage() {
        return WebDriver.getTextFromElement(EMPTY_PHONE_CART_ERROR_MESSAGE);
    }
}
