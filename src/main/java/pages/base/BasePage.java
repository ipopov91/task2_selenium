package pages.base;

import common.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {
    protected static WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
        Assert.assertEquals((driver.getCurrentUrl()), ConfProperties.getProperty("homepage"));
    }
}
