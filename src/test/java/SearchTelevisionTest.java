import common.ConfProperties;
import org.testng.annotations.Test;
import pages.main.MainPage;

public class SearchTelevisionTest extends BaseTest {

    @Test
    public void checkIsRedirectToList() {
        basePage.open(ConfProperties.getProperty("homepage"));

        mainPage.navigateSection();

        cataloguePage
                .navigateMenu()
                .navigateSubMenu()
                .navigateTelevisionList();

        televisionPage.searchTelevision();
    }
}
