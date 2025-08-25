package by.tempus;

public class HomePage {
    private String URL = "https://tempus.by/";
    private String BUTTON_LOGIN = "//button[contains(@class, 'icons__action--account') and contains(@class, 'j-sidePanel')]";
    private org.openqa.selenium.WebDriver driver;

    public HomePage() {
    }

    public HomePage openSite() {
        WebDriver.getDriver().navigate().to(URL);
        return this;
    }

    public HomePage сlickButtonLogin() {
        WebDriver.clickElement(BUTTON_LOGIN);
        return this;
    }
}
