package pages.catalogue_sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class TelevisionPage extends BasePage {

    private final By samsungManufacturerBtn = By.xpath("//*[@id=\"schema-filter\"]/div[5]/div[3]/div[2]/ul/li[2]/label/span[1]");
    private  final By priceBeforeField = By.xpath("//input[ @placeholder='до']");
    private  final By optionDiagonalFrom = By.xpath("//div[@class = 'schema-filter__label']/span[contains(text(), 'Диагональ')]/../following-sibling::div//select[contains(@data-bind, 'value: facet.value.from')]//option[contains(@value, '400')]");
    private  final By optionDiagonalTo = By.xpath("//div[@class = 'schema-filter__label']/span[contains(text(), 'Диагональ')]/../following-sibling::div//select[contains(@data-bind, 'value: facet.value.to')]//option[contains(@value, '500')]");
    private  final By displayResolution = By.xpath("//span[@class='schema-filter__checkbox-text' and contains(text(), '1920')]");
    private  final By card = By.xpath("//div[@class='schema-product__part schema-product__part_2']//div[@class='schema-product__description']");


    public TelevisionPage(WebDriver driver) {
        super(driver);
    }

    public TelevisionPage searchTelevision() {
        driver.findElement(samsungManufacturerBtn).click();
        driver.findElement(optionDiagonalFrom).click();
        driver.findElement(optionDiagonalTo).click();
        driver.findElement(displayResolution).click();
        driver.findElement(priceBeforeField).sendKeys("1500");
        return this;
    }

    public TelevisionPage tvList() {
        int countTV = driver.findElements(card).size();
        Assert.assertEquals(countTV, 3);
        return this;
    }
}
