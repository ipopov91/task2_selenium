package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.FileSystems;

public class BrowserFactory {

    private static WebDriver driver;
    private final static String BROWSER = PropertyManager.getProperty("Browser");
    private final static String OPERATING_SYSTEM = "Windows";
    private final static String CHROME_PROPERTY = "webdriver.chrome.driver";
    private final static String CHROME_DRIVER_PATH = "src/test/resources/chromedriver.exe";
    private final static String WINDOWS_DRIVER_EXT = ".exe";
    private static String folderName;
    private static String formatDriverPath;
    private static String absoluteDriverPath;

    private BrowserFactory() {

    }

    /**
     * The driver is selected, based on the operating system type.
     *
     */

    public static WebDriver createDriver() {

        folderName = OPERATING_SYSTEM.toLowerCase();

        if (driver == null) {
            switch (OPERATING_SYSTEM) {
                case "Windows":
                    switchBrowser(WINDOWS_DRIVER_EXT);
                    break;
            }
        }
        return driver;
    }

    /**
     * The driver is selected, based on the browser type.
     *
     */

    private static WebDriver switchBrowser(String extension){

        switch (BROWSER) {
            case "Chrome":
                getSystemProperty(CHROME_DRIVER_PATH,extension,CHROME_PROPERTY);
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }

    /**
     * path formatting
     * get absolute path
     * return system property for browser
     */
    private static String getSystemProperty(String driverPath, String driverExtension,
                                            String property){

        formatDriverPath = String.format(driverPath, folderName,
                driverExtension);
        absoluteDriverPath = FileSystems.getDefault().getPath(formatDriverPath)
                .normalize().toAbsolutePath().toString();
        return System.setProperty(property, absoluteDriverPath);
    }
}
