package framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {

    protected static WebDriver driver;
    protected By pageLocator;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage(final By locator) {
        init(locator);
        assertIsOpen();
    }

    private void init(final By locator) {
        pageLocator = locator;
    }

    public void open(String url) {
        driver.get(url);
        Assert.assertEquals((driver.getCurrentUrl()), PropertyManager.getProperty("homepage"));
    }

    public void assertIsOpen() {
        assert driver.findElement(pageLocator).isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
