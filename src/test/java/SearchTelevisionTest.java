import common.ConfProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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
        js.executeScript("javascript:window.scrollBy(250,350)");

        TelevisionPage.chooseManufacturer(manufacturer);
        TelevisionPage.choosePriceTo(priceTo);
        TelevisionPage.chooseDiagonalFrom(diagonalFrom);
        TelevisionPage.chooseDiagonalTo(diagonalTo);
        TelevisionPage.chooseResolution(resolution);
        //televisionPage.checkResultSearch();
    }
}
