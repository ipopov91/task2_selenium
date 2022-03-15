package onliner.pageobject;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelevisionPage extends BasePage {

    private int waitTime = 10;

    private final String checkboxLocator = "//div[@class='schema-filter__label'][contains(.,'%s')]/following-sibling::div//span[contains(text(),'%s')]";
    private final String inputLocator = "//div[@class='schema-filter__label'][contains(.,'%s')]/following-sibling::div//input[@placeholder='%s']";
    private final String buttonLocator = "//div[@class='schema-filter-button__inner-container']";
    private final By televisionPageTitleLocator = By.xpath("//h1[contains(text(), 'Телевизоры')]");

    private WebElement webElement;

    public TelevisionPage(WebDriver driver) {
        super(driver);
    }

    public By getTvPageTitleLocator() {
        return televisionPageTitleLocator;
    }

    public TelevisionPage checkboxSelector(String type,String value) {
        webElement = driver.findElement(By.xpath(String.format(checkboxLocator, type, value)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",webElement);
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonLocator)));
        webElement.click();
        return this;
    }

    public TelevisionPage choosePriceTo(String type, String value, String inputValue) {
        webElement = driver.findElement(By.xpath(String.format(inputLocator, type, value)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",webElement);
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonLocator)));
        webElement.sendKeys(inputValue);
        return this;
    }
}
