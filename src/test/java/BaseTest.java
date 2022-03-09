import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.catalogue_sections.TelevisionPage;
import pages.base.BasePage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;


public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected TelevisionPage televisionPage = new TelevisionPage(driver);

    String ERROR_MSG_TITLE_NOT_MATCH = "Not each product title contains selected manufacturer: %s";
    String ERROR_MSG_PRICE_NOT_MATCH_RANGE = "Not each product price is within selected range: до %s";
    String ERROR_MSG_DESCRIPTION_NOT_MATCH = "Not each product description contains filtered value: %s";
    String ERROR_MSG_DESCRIPTION_NOT_MATCH_RANGE = "Not each product description contains value within selected range: %s %s";

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
