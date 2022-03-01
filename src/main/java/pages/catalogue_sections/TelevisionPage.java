package pages.catalogue_sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class TelevisionPage extends BasePage {

    private final By samsungManufacturerBtn = By.xpath("//*[@id=\"schema-filter\"]/div[5]/div[3]/div[2]/ul/li[2]/label/span[1]/span");
    private  final By priceBeforeField = By.xpath("//*[@id=\"schema-filter\"]/div[5]/div[4]/div[2]/div/div[2]/input");
    private  final By optionDiagonalFrom = By.xpath("//div[@class = 'schema-filter__label']/span[contains(text(), 'Диагональ')]/../following-sibling::div//select[contains(@data-bind, 'value: facet.value.from')]//option[contains(@value, '400')]");
    private  final By optionDiagonalTo = By.xpath("//div[@class = 'schema-filter__label']/span[contains(text(), 'Диагональ')]/../following-sibling::div//select[contains(@data-bind, 'value: facet.value.to')]//option[contains(@value, '500')]");
    private  final By displayResolution = By.xpath("//*[@id=\"schema-filter\"]/div[5]/div[10]/div[3]/ul/li[3]/label/span[1]/span");


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
}
