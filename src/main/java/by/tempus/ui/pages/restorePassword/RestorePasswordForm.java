package by.tempus.ui.pages.restorePassword;

import by.tempus.webDriver.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RestorePasswordForm {
    private final String LINK_RESTORE_PASSWORD = "//button[@class='form__action j-tabBtnHandle']";
    private final String RESTORE_PASSWORD_FORM_TEXT = "//div[@class='form__recover' and normalize-space()='Для восстановления пароля, введите Email']";
    private final String BUTTON_SUBMIT_RESTORE = "//form[@class=\"form restore__form js-validate-form\"]//button[@class=\"button is-primary\"]";
    private final String RESTORE_PASSWORD_FORM_EMAIL_ERROR = "//span[@class=\"form-input__error-message\"]";
    private final String LOGIN_FORM_TITLE = "//li[contains(@class, 'is-active')]//button[text()='Вход']";
    private final String TAB_REGISTRATION = "//li[contains(@class, '')]//button[text()='Регистрация']";;
    private final String LABEL_EMAIL_FIELD = "//form[@class=\"form restore__form js-validate-form\"]//label[@class=\"form-input is-required is-email\"]";
    private final String INPUT_RESTORE_PASSWORD_EMAIL = "//input[normalize-space(@type) = 'email']";
    private final String RESTORE_PASSWORD_UNREGISTERED_EMAIL_ERROR = "//div[@class='success-popup__text']";


    public String getRestorePasswordFormText() {
        return WebDriver.getTextFromElement(RESTORE_PASSWORD_FORM_TEXT);
    }

    public String getButtonSubmitRestoreText() {
        return WebDriver.getTextFromElement(BUTTON_SUBMIT_RESTORE);
    }

    public void clickButtonSubmitRestore() {
        WebDriver.wait.until(ExpectedConditions.elementToBeClickable(WebDriver.findElement(INPUT_RESTORE_PASSWORD_EMAIL)));
        WebDriver.clickElement(BUTTON_SUBMIT_RESTORE);
    }

    public String getLabelRestorePassword_EmailText() {
        return WebDriver.getTextFromElement(LABEL_EMAIL_FIELD);
    }

    public String getLoginFormTitleText() {
        return WebDriver.getTextFromElement(LOGIN_FORM_TITLE);
    }

    public String getRestorePasswordFormEmailError() {
        return WebDriver.getTextFromElement(RESTORE_PASSWORD_FORM_EMAIL_ERROR);
    }

    public String getRestorePasswordUnregisteredEmailError() {
        return WebDriver.getTextFromElement(RESTORE_PASSWORD_UNREGISTERED_EMAIL_ERROR);
    }

    public String getEmailValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) WebDriver.getDriver();
        WebElement emailField = WebDriver.findElement(INPUT_RESTORE_PASSWORD_EMAIL);
        return (String) js.executeScript("return arguments[0].validationMessage;", emailField);
    }

    public void sendKeysEmail(String email) {
        WebDriver.sendkeysToElement(INPUT_RESTORE_PASSWORD_EMAIL, email);
    }

    public void clickLinkRestorePassword() {
        WebDriver.clickElement(LINK_RESTORE_PASSWORD);
    }

    public String getTitleRegistrationFormText() {
        return WebDriver.getTextFromElement(TAB_REGISTRATION);
    }

    public void clickTabRegistration() {
        WebDriver.clickElement(TAB_REGISTRATION);
    }

    public void fillRestorePasswordForm(String email) {
        sendKeysEmail(email);
        clickButtonSubmitRestore();
    }
}
