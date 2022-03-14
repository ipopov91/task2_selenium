package onliner.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends TelevisionPage {

    private final String productPriceLocator = "//div[@class='schema-product__price']/a/span";
    private final String productTitleLocator = "//div[@class='schema-product__title']";
    private final String productDescriptionLocator = "//div[@class='schema-product__description']";

    public SearchResultPage(WebDriver driver) {
        super(driver);
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
            if(price <= Integer.parseInt(filterValue)){
                return false;
            }
        }
        return true;
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
