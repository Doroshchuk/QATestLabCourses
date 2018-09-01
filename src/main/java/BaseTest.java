import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.AuthorizationPage;
import pages.MainUserPage;

public class BaseTest {
    protected EventFiringWebDriver driver;
    protected WebDriverWait wait;
    private String driverPath = Tests_HomeTask1.class.getResource("chromedriver.exe").getPath();
    private String baseUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    protected WebDriverLogger logger;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new EventFiringWebDriver(new ChromeDriver());
        logger = new WebDriverLogger();
        driver.register(logger);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    @AfterTest(alwaysRun = true)
    public void close() {
        driver.close();
        driver.quit();
    }
}
