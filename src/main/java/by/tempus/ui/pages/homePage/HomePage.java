package by.tempus.ui.pages.homePage;

import by.tempus.webDriver.WebDriver;

public class HomePage {
    private String URL = "https://tempus.by/";
    private String BUTTON_LOGIN = "//button[contains(@class, 'icons__action--account') and contains(@class, 'j-sidePanel')]";
    private String TAB_REGISTRATION = "//li[contains(@class, '')]//button[text()='Регистрация']";
    private final String LINK_RESTORE_PASSWORD = "//button[@class='form__action j-tabBtnHandle']";

    private org.openqa.selenium.WebDriver driver;

    public HomePage() {
    }

    public HomePage openSite() {
        WebDriver.getDriver().navigate().to(URL);
        return this;
    }

    public HomePage clickButtonLogin() {
        WebDriver.clickElement(BUTTON_LOGIN);
        return this;
    }

    public HomePage clickTabRegistration() {
        WebDriver.clickElement(TAB_REGISTRATION);
        return this;
    }
}
