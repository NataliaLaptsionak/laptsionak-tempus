package by.tempus;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginForm {

    private final String HEAD_FORM_TITLE = "//li[contains(@class, 'is-active')]//button[text()='Вход']";
    private final String INPUT_LOGIN_EMAIL = "//input[@name=\"email\"]";
    private final String INPUT_LOGIN_PASSWORD = "//input[@name=\"password\"]";
    private final String BUTTON_LOGIN = "//button[@class='button is-primary' and normalize-space()='Войти в аккаунт']";
    private final String USER_LOGIN_EMAIL_ERROR = "//input[@name='email']/following-sibling::span[@class='form-input__error-message']";
    private final String USER_LOGIN_PASSWORD_ERROR = "//input[@name='password']/following-sibling::span[@class='form-input__error-message']";

    public LoginForm() {
    }

    public String getHeadFormTitleText() {
        return WebDriver.getTextFromElement(HEAD_FORM_TITLE);
    }

    public void sendKeysLogin(String login) {
        WebDriver.sendkeysToElement(INPUT_LOGIN_EMAIL, login);
    }

    public void sendKeysPassword(String password) {
        WebDriver.sendkeysToElement(INPUT_LOGIN_PASSWORD, password);
    }

    public void clickButtonLogin() {
        WebDriver.clickElement(BUTTON_LOGIN);
    }

    public String getLoginEmailError() {
        return WebDriver.getTextFromElement(USER_LOGIN_EMAIL_ERROR);
    }

    public String getLoginPasswordError() {
        return WebDriver.getTextFromElement(USER_LOGIN_PASSWORD_ERROR);
    }

    public String getEmailValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) WebDriver.getDriver();
        WebElement emailField = WebDriver.findElement(INPUT_LOGIN_EMAIL);
        return (String) js.executeScript("return arguments[0].validationMessage;", emailField);
    }

    public void fillLoginForm(String login, String password) {
        sendKeysLogin(login);
        sendKeysPassword(password);
        clickButtonLogin();
    }
}
