package pages.catalogue;

import common.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class CataloguePage extends BasePage {

    private static final By electronicsBtn = By.xpath("//span[contains(text(), 'Электроника')]");
    private static final By televisionsAndVideoBtn = By.xpath("//div[contains(text(), 'Телевидение')]");
    private static final By televisionsBtn = By.xpath("//div[@class='catalog-navigation-list__dropdown-list']//a[@href='https://catalog.onliner.by/tv']");

    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    public static void navigateMenu(String str) {
        switch (str) {
            case "Электроника":
                driver.findElement(electronicsBtn).click();
                break;
        }
    }

    public static void navigateSubMenu(String str) {
        switch (str) {
            case "Телевидение и видео":
                driver.findElement(televisionsAndVideoBtn).click();
                break;
        }
    }

    public static void navigateTelevisionList(String str) {
        switch (str) {
            case "Телевизоры":
            driver.findElement(televisionsBtn).click();
            Assert.assertEquals((driver.getCurrentUrl()), ConfProperties.getProperty("televisionpage"));
        }
    }
}
