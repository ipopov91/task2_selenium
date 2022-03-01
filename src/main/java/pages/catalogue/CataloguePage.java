package pages.catalogue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class CataloguePage extends BasePage {

    private final By electronicsBtn = By.xpath("//span[contains(text(), 'Электроника')]");
    private final By televisionsAndVideoBtn = By.xpath("//div[contains(text(), 'Телевидение')]");
    private final By televisionsBtn = By.xpath("//div[@class='catalog-navigation-list__dropdown-list']//a[@href='https://catalog.onliner.by/tv']");

    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    public CataloguePage navigateMenu() {
        driver.findElement(electronicsBtn).click();
        return this;
    }

    public CataloguePage navigateSubMenu() {
        driver.findElement(televisionsAndVideoBtn).click();
        return this;
    }

    public CataloguePage navigateTelevisionList() {
        driver.findElement(televisionsBtn).click();
        return this;
    }
}