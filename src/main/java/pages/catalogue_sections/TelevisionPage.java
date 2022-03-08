package pages.catalogue_sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class TelevisionPage extends BasePage {

    private static final By samsungManufacturerBtn = By.xpath("//span[contains(text(), 'Производитель')]/../following-sibling::div/ul/li/label/span[@class='i-checkbox']/input[@value='samsung']/..");
    private static final By priceBeforeField = By.xpath("//input[ @placeholder='до']");
    private static final By optionDiagonalFrom = By.xpath("//div[@class = 'schema-filter__label']/span[contains(text(), 'Диагональ')]/../following-sibling::div//select[contains(@data-bind, 'value: facet.value.from')]//option[contains(@value, '400')]");
    private static final By optionDiagonalTo = By.xpath("//div[@class = 'schema-filter__label']/span[contains(text(), 'Диагональ')]/../following-sibling::div//select[contains(@data-bind, 'value: facet.value.to')]//option[contains(@value, '500')]");
    private static final By displayResolution = By.xpath("//span[@class='schema-filter__checkbox-text' and contains(text(), '1920')]");

    public TelevisionPage(WebDriver driver) {
        super(driver);
    }

    public static void chooseManufacturer(String manufacturer) {
        switch (manufacturer) {
            case "Samsung":
                driver.findElement(samsungManufacturerBtn).click();
                break;
        }
    }

    public static void choosePriceTo(String priceTo) {
        driver.findElement(priceBeforeField).sendKeys(priceTo);
    }

    public static void chooseResolution(String resolution) {
        switch (resolution) {
            case "1920х1080 (Full HD)":
                driver.findElement(displayResolution).click();
                break;
        }
    }

    public static void chooseDiagonalFrom(String diagonalFrom) {
        switch (diagonalFrom) {
            case "40":
                driver.findElement(optionDiagonalFrom).click();
                break;
        }
    }

    public static void chooseDiagonalTo(String diagonalTo) {
        switch (diagonalTo) {
            case "50":
                driver.findElement(optionDiagonalTo).click();
                break;
        }
    }
}
