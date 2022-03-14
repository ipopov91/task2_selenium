package onliner.tests;

import framework.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseTest {

    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;
    public static final Boolean HOLD_BROWSER_OPEN = true;

    protected WebDriver driver = BrowserFactory.createDriver();

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            js.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite (alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
