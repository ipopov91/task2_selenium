package onliner.tests;

import framework.PropertyManager;
import onliner.pageobject.SearchResultPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import framework.BasePage;
import onliner.pageobject.CataloguePage;
import onliner.pageobject.TelevisionPage;
import onliner.pageobject.MainPage;

public class SearchTelevisionTest extends BaseTest {

    protected BasePage basePage = new BasePage(driver);
    protected SearchResultPage searchResultPage = new SearchResultPage(driver);

    String ERROR_MSG_TITLE_NOT_MATCH = "Not each product title contains selected manufacturer: %s";
    String ERROR_MSG_PRICE_NOT_MATCH_RANGE = "Not each product price is within selected range: to %s";
    String ERROR_MSG_DESCRIPTION_NOT_MATCH = "Not each product description contains filtered value: %s";
    String ERROR_MSG_DESCRIPTION_NOT_MATCH_RANGE = "Not each product description contains value within selected range: %s %s";

    @Parameters({"manufacturer", "priceTo", "resolution", "diagonalFrom", "diagonalTo"})
    @Test
    public void checkIsRedirectToList(String manufacturer, String priceTo, String resolution, String diagonalFrom, String diagonalTo) {
        basePage.open(PropertyManager.getProperty("homepage"));
        MainPage mainPage = new MainPage(driver);
        CataloguePage cataloguePage = new CataloguePage(driver);

        mainPage.navigateSection("Каталог");

        cataloguePage
                .navigateMenu("Электроника")
                .navigateSubMenu("Телевидение")
                .navigateTelevisionList("Телевизоры");

        TelevisionPage.chooseManufacturer(manufacturer);
        TelevisionPage.choosePriceTo(priceTo);
        TelevisionPage.chooseDiagonalFrom(diagonalFrom);
        TelevisionPage.chooseDiagonalTo(diagonalTo);
        TelevisionPage.chooseResolution(resolution);

        SoftAssert softAssert = new SoftAssert();

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
