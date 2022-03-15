package onliner.pageobject;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class MainPage extends BasePage {

    private static String pageLocator = "onliner_logo";
    private static String navigationItemLocator = "//ul[@class='b-main-navigation']//span[text() = '%s']";
    private String mainPageTitle = "Onliner";

    private WebElement navigationItem;

    public MainPage(String selectedNavigationItem) {
        super(By.className(pageLocator));
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getMainPageTitle(){
        return mainPageTitle;
    }

    public MainPage navigateSection(String selectedNavigationItem) {
        navigationItem = driver.findElement(By.xpath(String.format(navigationItemLocator, selectedNavigationItem)));
        navigationItem.click();
        return new MainPage(selectedNavigationItem);
    }
}
