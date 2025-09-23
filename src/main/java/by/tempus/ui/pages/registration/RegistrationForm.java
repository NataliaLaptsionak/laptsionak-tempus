package by.tempus.ui.pages.registration;

import by.tempus.webDriver.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegistrationForm {

    private final String TAB_REGISTRATION = "//li[contains(@class, '')]//button[text()='Регистрация']";;
    private final String INPUT_REGISTRATION_FULL_NAME = "//input[@name=\"fullName\"]";
    private final String INPUT_REGISTRATION_EMAIL = "//form[@class=\"form registration__form js-validate-form\"]//input[@name=\"email\"]";
    private final String INPUT_REGISTRATION_PHONE = "//input[@type=\"tel\"]";
    private final String INPUT_REGISTRATION_PASSWORD = "//label[@class=\"form-input is-required is-password is-error\"]//input[@type=\"password\"]";
    private final String INPUT_REGISTRATION_REPEAT_PASSWORD = "//label[@class=\"form-input is-required is-confirm-password\"]//input[@type=\"password\"]";


    private final String EMPTY_FULL_NAME_ERROR = "//label[@class=\"form-input is-required is-error\"]//span[@class=\"form-input__error-message\"]";
    private final String EMPTY_EMAIL_ERROR = "//label[@class=\"form-input is-required is-email is-error\"]//span[@class=\"form-input__error-message\"]";
    private final String INCORRECT_EMAIL_ERROR = "//span[@class=\"form-input__error-message\"]";

    private final String EMPTY_PHONE_ERROR = "//label[@class=\"form-input is-required is-phone phone-input is-error\"]//span[@class=\"form-input__error-message\"]";
    private final String EMPTY_PASSWORD_ERROR = "//label[@class=\"form-input is-required is-password is-error\"]//span[@class=\"form-input__error-message\"]";
    private final String REGISTRATION_REPEAT_PASSWORD_ERROR = "//label[@class=\"form-input is-required is-confirm-password is-error\"]//span[@class=\"form-input__error-message\"]";
    private final String BUTTON_REGISTRATION = "//form[@class=\"form registration__form js-validate-form\"]//button[@type=\"submit\"]";
    private final String LABEL_FULL_NAME_FIELD_TEXT = "//form[@class=\"form registration__form js-validate-form\"]//label[@class=\"form-input is-required\"]//span[@class=\"form-input__placeholder\"]";
    private final String LABEL_EMAIL_FIELD_TEXT = "//form[@class=\"form registration__form js-validate-form\"]//label[@class=\"form-input is-required is-email\"]//span[@class=\"form-input__placeholder\"]";
    private final String LABEL_PHONE_FIELD_TEXT = "//form[@class=\"form registration__form js-validate-form\"]//label[@class=\"form-input is-required is-phone phone-input\"]//span[@class=\"form-input__placeholder\"]";
    private final String LABEL_PASSWORD_FIELD_TEXT = "//form[@class=\"form registration__form js-validate-form\"]//label[@class=\"form-input is-required is-password\"]//span[@class=\"form-input__placeholder\"]";
    private final String LABEL_REPEAT_PASSWORD_FIELD_TEXT = "//label[@class=\"form-input is-required is-confirm-password\"]//span[@class=\"form-input__placeholder\"]";
    private final String AGREEMENT_CHECKBOX = "//span[@class=\"checkbox-input__check\"]";
    private final String AGREEMENT_CHECKBOX_ERROR = "//div[@class=\"form__agreement\"]//span[@class=\"form-input__error-message\"]";
    private final String AGREEMENT_CHECKBOX_TEXT = "//form[@class=\"form registration__form js-validate-form\"]//span[@class=\"agreement__text\"]";
    private final String LOGIN_FORM_TITLE = "//button[contains(@class, 'tabs_btn-action') and text()='Вход']";


    public RegistrationForm() {
    }

    public String getTitleRegistrationTab() {
    return WebDriver.getTextFromElement(TAB_REGISTRATION);
    }

    public void clickTabRegistration() {
        WebDriver.clickElement(TAB_REGISTRATION);
    }

    public void clickLoginFormTitle() {
        WebDriver.clickElement(LOGIN_FORM_TITLE);
    }

    public String getLoginFormTitleText() {
        return WebDriver.getTextFromElement(LOGIN_FORM_TITLE);
    }

    public String getButtonRegistrationText() {
    return WebDriver.getTextFromElement(BUTTON_REGISTRATION);
    }

    public void clickButtonRegistration() {
        WebDriver.scrollToElement(BUTTON_REGISTRATION);
        WebDriver.clickElement(BUTTON_REGISTRATION);
    }

    public String getLabelFulNameFieldText() {
        return WebDriver.getTextFromElement(LABEL_FULL_NAME_FIELD_TEXT);
    }
    public void sendKeysFullName(String fullName) {
        WebDriver.sendkeysToElement(INPUT_REGISTRATION_FULL_NAME, fullName);
    }

    public String getLabelEmailFieldText() {
    return WebDriver.getTextFromElement(LABEL_EMAIL_FIELD_TEXT);
    }

    public void sendKeysEmail(String email) {
    WebDriver.sendkeysToElement(INPUT_REGISTRATION_EMAIL, email);
    }

    public String getLabelPhoneFieldText() {
    return WebDriver.getTextFromElement(LABEL_PHONE_FIELD_TEXT);
    }

    public void sendKeysPhone(String phone) {

    WebDriver.sendkeysToElement(INPUT_REGISTRATION_PHONE, phone);
    }

    public String getLabelPasswordFieldText() {

    return WebDriver.getTextFromElement(LABEL_PASSWORD_FIELD_TEXT);
    }

    public void sendKeysPassword(String password) {
        WebDriver.sendkeysToElement(INPUT_REGISTRATION_PASSWORD, password);
    }

    public String getLabelRepeatPasswordFieldText() {
        return WebDriver.getTextFromElement(LABEL_REPEAT_PASSWORD_FIELD_TEXT);
    }
    public void sendKeysRepeatPassword(String repeatPassword) {
        WebDriver.sendkeysToElement(INPUT_REGISTRATION_REPEAT_PASSWORD, repeatPassword);
    }

    public String getLabelAgreementCheckboxText() {

    return WebDriver.getTextFromElement(AGREEMENT_CHECKBOX_TEXT);
    }

    public void clickAgreementCheckbox() {
        WebDriver.scrollToElement(AGREEMENT_CHECKBOX); // Добавляем скролл к кнопке
        WebDriver.clickElement(AGREEMENT_CHECKBOX);
    }

    public String getAgreementCheckboxError() {

    return WebDriver.getTextFromElement(AGREEMENT_CHECKBOX_ERROR);
    }

    public String getRegistrationEmailError() {

    return WebDriver.getTextFromElement(EMPTY_EMAIL_ERROR);
    }

    public String getIncorrectEmailError() {

        return WebDriver.getTextFromElement(INCORRECT_EMAIL_ERROR);
    }

    public String getRegistrationFullNameError() {
        return WebDriver.getTextFromElement(EMPTY_FULL_NAME_ERROR);
    }

    public String getRegistrationPasswordError() {
        return WebDriver.getTextFromElement(EMPTY_PASSWORD_ERROR);
    }

    public String getRegistrationRepeatPasswordError() {
        return WebDriver.getTextFromElement(REGISTRATION_REPEAT_PASSWORD_ERROR);
    }

    public String getRegistrationPhoneError() {
        return WebDriver.getTextFromElement(EMPTY_PHONE_ERROR);
    }

    public String getRegistrationEmailValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) WebDriver.getDriver();
        WebElement emailField = WebDriver.findElement(INPUT_REGISTRATION_EMAIL);
        return (String) js.executeScript("return arguments[0].validationMessage;", emailField);
    }


    public void fillRegistrationForm(String fullName, String email, String phone, String password, String repeatPassword) {
        sendKeysFullName(fullName);
        sendKeysEmail(email);
        sendKeysPhone(phone);
        sendKeysPassword(password);
        sendKeysRepeatPassword(repeatPassword);
        clickAgreementCheckBox();
        clickButtonRegistration();
    }

    public void clickAgreementCheckBox() {
        WebDriver.clickElement(AGREEMENT_CHECKBOX);     }

}
