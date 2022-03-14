package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static final String PLATFORM_AND_BROWSER = "windows_chrome";

    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case "windows_chrome":
                System.setProperty("webdriver.chrome.driver", PropertyManager.getProperty("chrome"));
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Incorrect platform or browser name " + PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyManager.getProperty("implicitWait")), TimeUnit.SECONDS);
        return driver;
    }


}
