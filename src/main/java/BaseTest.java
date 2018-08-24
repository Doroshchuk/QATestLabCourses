import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AuthorizationPage;
import pages.MainUserPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    //protected EventFiringWebDriver driver;
    protected WebDriver driver;
    protected AuthorizationPage authorizationPage;
    protected MainUserPage userPage;
    private String driverPath = Tests_HomeTask1.class.getResource("chromedriver.exe").getPath();
    private String baseUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
//        driver = new EventFiringWebDriver(new ChromeDriver());
//        driver.register(new WebDriverLogger());
        driver = new ChromeDriver();
        driver.get(baseUrl);
        authorizationPage = new AuthorizationPage(driver);
        userPage = new MainUserPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.close();
        driver.quit();
    }
}
