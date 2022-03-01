package pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;


public class MainPage extends BasePage {

    private final By catalogueBtn = By.xpath("//div[@class ='b-main-page-grid-6 b-main-page-catalog-layer']//*[contains(text(), 'Каталог')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage navigateSection() {
        driver.findElement(catalogueBtn).click();
            return this;
    }
}
