import common.ConfProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.catalogue.CataloguePage;
import pages.main.MainPage;

public class SearchTelevisionTest extends BaseTest {

    @Test
    public void checkIsRedirectToList() {
        basePage.open(ConfProperties.getProperty("homepage"));

        MainPage.navigateSection("Каталог");

        CataloguePage.navigateMenu("Электроника");
        CataloguePage.navigateSubMenu("Телевидение и видео");
        CataloguePage.navigateTelevisionList("Телевизоры");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        televisionPage.searchTelevision();
    }
}
