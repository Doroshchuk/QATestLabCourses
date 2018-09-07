import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;

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
        wait = new WebDriverWait(driver, 30);
    }

    @AfterTest(alwaysRun = true)
    public void close() {
        driver.close();
        driver.quit();
    }

    protected void goToNewWindow(){
        ArrayList<String> winList = new ArrayList<>(driver.getWindowHandles());
        String newWindowName = winList.get(winList.size() - 1);
        driver.switchTo().window(newWindowName);
    }
}
