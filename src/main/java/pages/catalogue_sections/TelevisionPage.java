package pages.catalogue_sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TelevisionPage extends BasePage {

    private static final By samsungManufacturerBtn = By.xpath("//span[contains(text(), 'Производитель')]/../following-sibling::div/ul/li/label/span[@class='i-checkbox']/input[@value='samsung']/..");
    private static final By priceBeforeField = By.xpath("//input[ @placeholder='до']");
    private static final By optionDiagonalFrom = By.xpath("//div[@class = 'schema-filter__label']/span[contains(text(), 'Диагональ')]/../following-sibling::div//select[contains(@data-bind, 'value: facet.value.from')]//option[contains(@value, '400')]");
    private static final By optionDiagonalTo = By.xpath("//div[@class = 'schema-filter__label']/span[contains(text(), 'Диагональ')]/../following-sibling::div//select[contains(@data-bind, 'value: facet.value.to')]//option[contains(@value, '500')]");
    private static final By displayResolution = By.xpath("//span[@class='schema-filter__checkbox-text' and contains(text(), '1920')]");

    private final String productPriceLocator = "//div[@class='schema-product__price']/a/span";
    private final String productTitleLocator = "//div[@class='schema-product__title']";
    private final String productDescriptionLocator = "//div[@class='schema-product__description']";

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
            case "1920x1080 (Full HD)":
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        switch (diagonalTo) {
            case "50":
                driver.findElement(optionDiagonalTo).click();
                break;
        }
    }

    public boolean isEachProductTitleContainsFilterValue(String filterValue) {
        List<WebElement> productsTitles = driver.findElements(By.xpath(productTitleLocator));
        for (WebElement element : productsTitles) {
            if(element.getText().contains(filterValue)){
                return true;
            }
        }
        return false;
    }

    public boolean isEachProductPriceMatchesFilterValue(String filterValue) {
        List<WebElement> productsPrices = driver.findElements(By.xpath(productPriceLocator));
        for (WebElement element : productsPrices) {
            String value = element.getText();
            int price = Integer.parseInt(value.substring(0, value.indexOf(",")));
            if(!(price <= Integer.parseInt(filterValue))){
                return true;
            }
        }
        return false;
    }

    public boolean isEachProductDescriptionContainsFilterValue(String filterValue){
        List<WebElement> productsDescriptions = driver.findElements(By.xpath(productDescriptionLocator));
        for (WebElement element : productsDescriptions) {
            if(element.getText().contains(filterValue)){
                return true;
            }
        }
        return false;
    }

    public boolean isEachProductDescriptionContainsFilterValueInRange(String filterValueStartRange, String filterValueEndRange){
        List<WebElement> productsDescriptions = driver.findElements(By.xpath(productDescriptionLocator));
        for (WebElement element : productsDescriptions) {
            Double diagonal = Double.parseDouble(element.getText().substring(0, 2));
            if(diagonal >= Double.parseDouble(filterValueStartRange) && diagonal <= Double.parseDouble(filterValueEndRange)){
                return true;
            }
        }
        return false;
    }
}
