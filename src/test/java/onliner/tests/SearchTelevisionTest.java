package onliner.tests;

import onliner.pageobject.SearchResultPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import onliner.pageobject.CataloguePage;
import onliner.pageobject.TelevisionPage;
import onliner.pageobject.MainPage;

public class SearchTelevisionTest extends BaseTest {


    protected SearchResultPage searchResultPage = new SearchResultPage(driver);
    protected TelevisionPage televisionPage = new TelevisionPage(driver);
    protected CataloguePage cataloguePage = new CataloguePage(driver);

    String ERROR_MSG_TITLE_NOT_MATCH = "Not each product title contains selected manufacturer: %s";
    String ERROR_MSG_PRICE_NOT_MATCH_RANGE = "Not each product price is within selected range: to %s";
    String ERROR_MSG_DESCRIPTION_NOT_MATCH = "Not each product description contains filtered value: %s";
    String ERROR_MSG_DESCRIPTION_NOT_MATCH_RANGE = "Not each product description contains value within selected range: %s %s";

    @Parameters({"manufacturer", "priceTo", "resolution", "diagonalFrom", "diagonalTo"})
    @Test
    public void checkIsRedirectToList(String manufacturer, String priceTo, String resolution, String diagonalFrom, String diagonalTo) {
        SoftAssert softAssert = new SoftAssert();
        MainPage mainPage = new MainPage(driver);

        softAssert.assertEquals(driver.getTitle(), mainPage.getMainPageTitle());
        mainPage.navigateSection("Каталог");

        softAssert.assertEquals(driver.getTitle(), cataloguePage.getCataloguePageTitle());
        cataloguePage
                .navigateMenu("Электроника")
                .navigateSubMenu("Телевидение")
                .navigateTelevisionList("Телевизоры");

        softAssert.assertTrue(driver.findElement(televisionPage.getTvPageTitleLocator()).isDisplayed());
        televisionPage
                .checkboxSelector( "Производитель", manufacturer)
                .choosePriceTo("цена", "до",priceTo)
                .checkboxSelector("Разрешение", resolution)
                .checkboxSelector("Диагональ" ,diagonalFrom)
                .checkboxSelector("Диагональ" ,diagonalTo);

        softAssert.assertTrue(searchResultPage.isEachProductTitleContainsFilterValue(manufacturer),
                String.format(ERROR_MSG_TITLE_NOT_MATCH,manufacturer));
        softAssert.assertTrue(searchResultPage.isEachProductPriceMatchesFilterValue(priceTo),
                String.format(ERROR_MSG_PRICE_NOT_MATCH_RANGE,priceTo));
        softAssert.assertTrue(searchResultPage.isEachProductDescriptionContainsFilterValue(resolution),
                String.format(ERROR_MSG_DESCRIPTION_NOT_MATCH,resolution));
        softAssert.assertTrue(searchResultPage.isEachProductDescriptionContainsFilterValueInRange(diagonalFrom,diagonalTo),
                String.format(ERROR_MSG_DESCRIPTION_NOT_MATCH_RANGE,diagonalFrom,diagonalTo));
        softAssert.assertAll();
    }
}
