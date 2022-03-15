package onliner.pageobject;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CataloguePage extends BasePage {

    private final String electronicsBtn = "//span[@class='catalog-navigation-classifier__item-title'][contains(.,'%s')]";
    private final String televisionsAndVideoBtn = "//div[@class='catalog-navigation-list__aside-item'][contains(.,'%s')]";
    private final String televisionsBtn = "//a[@class='catalog-navigation-list__dropdown-item'][contains(.,'%s')]";
    private String cataloguePageTitle = "Каталог Onlíner";

    private WebElement webElement;

    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    public String getCataloguePageTitle(){
        return cataloguePageTitle;
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
