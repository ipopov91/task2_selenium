import common.ConfProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.catalogue.CataloguePage;
import pages.catalogue_sections.TelevisionPage;
import pages.main.MainPage;

public class SearchTelevisionTest extends BaseTest {

    @Parameters({"manufacturer", "priceTo", "resolution", "diagonalFrom", "diagonalTo"})
    @Test
    public void checkIsRedirectToList(String manufacturer, String priceTo, String resolution, String diagonalFrom, String diagonalTo) {
        basePage.open(ConfProperties.getProperty("homepage"));

        MainPage.navigateSection("Каталог");

        CataloguePage.navigateMenu("Электроника");
        CataloguePage.navigateSubMenu("Телевидение и видео");
        CataloguePage.navigateTelevisionList("Телевизоры");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,400)");

        TelevisionPage.chooseManufacturer(manufacturer);
        TelevisionPage.choosePriceTo(priceTo);
        TelevisionPage.chooseDiagonalFrom(diagonalFrom);
        TelevisionPage.chooseDiagonalTo(diagonalTo);
        TelevisionPage.chooseResolution(resolution);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(televisionPage.isEachProductTitleContainsFilterValue(manufacturer),
                String.format(ERROR_MSG_TITLE_NOT_MATCH,manufacturer));
        softAssert.assertTrue(televisionPage.isEachProductPriceMatchesFilterValue(priceTo),
                String.format(ERROR_MSG_PRICE_NOT_MATCH_RANGE,priceTo));
        softAssert.assertTrue(televisionPage.isEachProductDescriptionContainsFilterValue(resolution),
                String.format(ERROR_MSG_DESCRIPTION_NOT_MATCH,resolution));
        softAssert.assertTrue(televisionPage.isEachProductDescriptionContainsFilterValueInRange(diagonalFrom,diagonalTo),
                String.format(ERROR_MSG_DESCRIPTION_NOT_MATCH_RANGE,diagonalFrom,diagonalTo));
        softAssert.assertAll();
    }
}
