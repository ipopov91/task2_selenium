package onliner.pageobject;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CataloguePage extends BasePage {

    private static String pageLocator = "//h1[@class='catalog-navigation__title'][contains(text(),'%s')]";

    private final String electronicsBtn = "//span[@class='catalog-navigation-classifier__item-title'][contains(.,'%s')]";
    private final String televisionsAndVideoBtn = "//div[@class='catalog-navigation-list__aside-item'][contains(.,'%s')]";
    private final String televisionsBtn = "//a[@class='catalog-navigation-list__dropdown-item'][contains(.,'%s')]";

    private WebElement webElement;

    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    public CataloguePage(String pageLocatorValue) {
        super(By.xpath(String.format(pageLocator, pageLocatorValue)));
    }

    public CataloguePage navigateMenu(String selectedCatalogNavigationItem) {
        webElement = driver.findElement(By.xpath(String.format(electronicsBtn,selectedCatalogNavigationItem)));
        webElement.click();
        return this;
    }

    public CataloguePage navigateSubMenu(String selectedCatalogNavigationItem) {
        webElement = driver.findElement(By.xpath(String.format(televisionsAndVideoBtn,selectedCatalogNavigationItem)));
        webElement.click();
        return this;
    }

    public CataloguePage navigateTelevisionList(String selectedCatalogNavigationItem) {
        webElement = driver.findElement(By.xpath(String.format(televisionsBtn,selectedCatalogNavigationItem)));
        webElement.click();
        return this;
    }
}
