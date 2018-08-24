import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    private String driverPath = Tests_HomeTask1.class.getResource("chromedriver.exe").getPath();
    private String baseUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.close();
        driver.quit();
    }
}
