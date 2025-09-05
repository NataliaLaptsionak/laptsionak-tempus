package by.tempus.ui;

import by.tempus.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.JavascriptExecutor;

public class BaseTest {

    @AfterEach
    public void tearDown() {

        org.openqa.selenium.WebDriver currentDriver = WebDriver.getInstance();

        if (currentDriver != null) {
            JavascriptExecutor js = (JavascriptExecutor) currentDriver;
            js.executeScript("window.localStorage.clear();");
            js.executeScript("window.sessionStorage.clear();");

            currentDriver.manage().deleteAllCookies();

            WebDriver.quit();
        }
    }
}
