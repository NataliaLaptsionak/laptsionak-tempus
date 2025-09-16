package by.tempus;

import by.tempus.webDriver.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginForm {

    private final String HEAD_FORM_TITLE = "//li[contains(@class, 'is-active')]//button[text()='Вход']";
    private final String INPUT_LOGIN_EMAIL = "//input[@name='email']";
    private final String INPUT_LOGIN_PASSWORD = "//input[@name='password']";
    private final String BUTTON_LOGIN = "//button[@class='button is-primary' and normalize-space()='Войти в аккаунт']";
    private final String LOGIN_EMAIL_ERROR = "//input[@name='email']/following-sibling::span[@class='form-input__error-message']";
    private final String LOGIN_PASSWORD_ERROR = "//input[@name='password']/following-sibling::span[@class='form-input__error-message']";
    private final String LOGIN_CREDENTIALS_ERROR = "//div[@class='success-popup__text']";
    private final String LABEL_EMAIL_TEXT = "//label[@class='form-input is-required is-email check-email']//span[@class='form-input__placeholder']";
    private final String LABEL_PASSWORD_TEXT = "//form[@class='form authorize__form js-validate-form']//label[@class='form-input is-required is-password']//span[@class='form-input__placeholder']";
    private final String BUTTON_RESTORE_PASSWORD = "//button[@class='form__action j-tabBtnHandle']";
    private final String RESTORE_PASSWORD_FORM_TITLE_TEXT = "//div[@class='form__recover' and normalize-space()='Для восстановления пароля, введите Email']";
    private final String BUTTON_REGISTRATION_FORM = "//li[contains(@class, '')]//button[text()='Регистрация']";
    private final String BUTTON_SUBMIT_RESTORE = "//button[@class='button is-primary' and normalize-space()='Восстановить']";
    private final String RESTORE_PASSWORD_ERROR = "//div[@class='success-popup__text']";

    public LoginForm() {
    }

    public String getHeadFormTitleText() {
        return WebDriver.getTextFromElement(HEAD_FORM_TITLE);
    }

    public String getButtonRegistrationFormText() {
        return WebDriver.getTextFromElement(BUTTON_REGISTRATION_FORM);
    }

    public void clickButtonRegistrationForm() {
        WebDriver.clickElement(BUTTON_REGISTRATION_FORM);
    }

    public String getLabelEmailText() {
        return WebDriver.getTextFromElement(LABEL_EMAIL_TEXT);
    }

    public String getButtonLoginText() {
        return WebDriver.getTextFromElement(BUTTON_LOGIN);
    }

    public String getButtonRestorePasswordText() {
        return WebDriver.getTextFromElement(BUTTON_RESTORE_PASSWORD);
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

    public String getLabelPasswordText() {
        return WebDriver.getTextFromElement(LABEL_PASSWORD_TEXT);
    }

    public String getLoginEmailError() {
        return WebDriver.getTextFromElement(LOGIN_EMAIL_ERROR);
    }

    public String getLoginPasswordError() {
        return WebDriver.getTextFromElement(LOGIN_PASSWORD_ERROR);
    }

    public String getLoginCredentialsError() {
        return WebDriver.getTextFromElement(LOGIN_CREDENTIALS_ERROR);
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

    public void clickButtonRestorePassword() {
        WebDriver.clickElement(BUTTON_RESTORE_PASSWORD);
    }

    public String getRestorePasswordFormTitleText() {
        return WebDriver.getTextFromElement(RESTORE_PASSWORD_FORM_TITLE_TEXT);
    }

    public void clickButtonSubmitRestore() {
        WebDriver.clickElement(BUTTON_SUBMIT_RESTORE);
    }

    public String getRestorePasswordError() {
        return WebDriver.getTextFromElement(RESTORE_PASSWORD_ERROR);
    }
}
