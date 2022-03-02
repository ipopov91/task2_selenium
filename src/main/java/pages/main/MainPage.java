package pages.main;

import common.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;


public class MainPage extends BasePage {

    private static final By catalogueBtn = By.xpath("//div[@class ='b-main-page-grid-6 b-main-page-catalog-layer']//*[contains(text(), 'Каталог')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static void navigateSection(String str) {
        switch (str) {
            case "Каталог":
            driver.findElement(catalogueBtn).click();
            Assert.assertEquals((driver.getCurrentUrl()), ConfProperties.getProperty("cataloguepage"));
            break;
        }
    }
}
