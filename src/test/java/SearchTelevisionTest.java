import common.ConfProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class SearchTelevisionTest extends BaseTest {

    @Test
    public void checkIsRedirectToList() {
        basePage.open(ConfProperties.getProperty("homepage"));

        mainPage.navigateSection();

        cataloguePage
                .navigateMenu()
                .navigateSubMenu()
                .navigateTelevisionList();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        televisionPage
                .searchTelevision()
                .tvList();
    }
}
