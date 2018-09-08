import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected EventFiringWebDriver driver;
    protected WebDriverWait wait;
    //private String baseUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private String baseUrl = "http://prestashop-automation.qatestlab.com.ua/ru/";
    protected WebDriverLogger logger;
    protected String browserType;

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        browserType = browser;
        driver = new EventFiringWebDriver(getDriver(browser));
        logger = new WebDriverLogger();
        driver.register(logger);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
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
                InternetExplorerOptions optionsIE = new InternetExplorerOptions().
                        requireWindowFocus().
                        setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT).
                        enablePersistentHovering().
                        destructivelyEnsureCleanSession();
                optionsIE.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                optionsIE.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                return new InternetExplorerDriver(optionsIE);
            case "headless-chrome":
                System.setProperty(
                        "webdriver.chrome.driver",
                        getResource("/chromedriver.exe")
                );
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("headless");
                optionsChrome.addArguments("window-size=800x600");
                return new ChromeDriver(optionsChrome);
            case "mobile":
                System.setProperty(
                        "webdriver.chrome.driver",
                        getResource("/chromedriver.exe"));
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "iphone 7");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                return new ChromeDriver(chromeOptions);
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
