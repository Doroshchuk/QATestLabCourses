import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BaseTest {
    protected EventFiringWebDriver driver;
    protected WebDriverWait wait;
    private String baseUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    protected WebDriverLogger logger;

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        driver = new EventFiringWebDriver(getDriver(browser));
        logger = new WebDriverLogger();
        driver.register(logger);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
    }

    @AfterClass
    public void close() {
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }

    protected void goToNewWindow(){
        ArrayList<String> winList = new ArrayList<>(driver.getWindowHandles());
        String newWindowName = winList.get(winList.size() - 1);
        driver.switchTo().window(newWindowName);
    }

    /**
     *
     * @param browser Driver type to use in tests.
     *
     * @return New instance of {@link WebDriver} object.
     */
    private WebDriver getDriver(String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty(
                        "webdriver.gecko.driver",
                        getResource("/geckodriver.exe"));
                return new FirefoxDriver();
            case "ie":
            case "internet explorer":
                System.setProperty(
                        "webdriver.ie.driver",
                        getResource("/IEDriverServer.exe"));
                return new InternetExplorerDriver();
            case "chrome":
            default:
                System.setProperty(
                        "webdriver.chrome.driver",
                        getResource("/chromedriver.exe"));
                return new ChromeDriver();
        }
    }

    /**
     * @param resourceName The name of the resource
     * @return Path to resource
     */
    private String getResource(String resourceName) {
        try {
            return Paths.get(BaseTest.class.getResource(resourceName).toURI()).toFile().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return resourceName;
    }
}