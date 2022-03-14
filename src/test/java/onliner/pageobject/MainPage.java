package onliner.pageobject;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage extends BasePage {

    private static String pageLocator = "onliner_logo";
    private static String navigationItemLocator = "//ul[@class='b-main-navigation']//span[text() = '%s']";

    private WebElement navigationItem;

    public MainPage(String selectedNavigationItem) {
        super(By.className(pageLocator));
    }

    public MainPage(final By locator) {
        super(locator);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage navigateSection(String selectedNavigationItem) {
        navigationItem = driver.findElement(By.xpath(String.format(navigationItemLocator, selectedNavigationItem)));
        navigationItem.click();
        return new MainPage(selectedNavigationItem);
    }
}
