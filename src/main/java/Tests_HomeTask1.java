import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AuthorizationPage;
import pages.MainUserPage;

import java.util.concurrent.TimeUnit;

public class Tests_HomeTask1 {
    private WebDriver driver;
    private AuthorizationPage authorizationPage;
    private MainUserPage userPage;
    private String driverPath = Tests_HomeTask1.class.getResource("chromedriver.exe").getPath();
    private String baseUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        authorizationPage = new AuthorizationPage(driver);
        userPage = new MainUserPage(driver);
    }

    @Test(priority = 0)
    public void testAuthenticationAndLogOut() {
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        sleep(300);
        userPage.LogOut();
        sleep(300);
        Assert.assertEquals(authorizationPage.title.getText(), "prestashop-automation");
    }

    @DataProvider(name = "SideBarItemTest")
    public static Object[][] credentials() {

        return new Object[][] {
                { "tab-AdminDashboard" },
                { "subtab-AdminParentOrders" },
                { "subtab-AdminCatalog" },
                { "subtab-AdminParentCustomer" },
                { "subtab-AdminParentCustomerThreads" },
                { "subtab-AdminStats" },
                { "subtab-AdminParentModulesSf" },
                { "subtab-AdminParentThemes" },
                { "subtab-AdminParentShipping" },
                { "subtab-AdminParentPayment" },
                { "subtab-AdminInternational" },
                { "subtab-ShopParameters" },
                { "subtab-AdminAdvancedParameters" }
        };
    }

    @Test(priority = 1, dataProvider = "SideBarItemTest")
    public void testSideBarItem(String id) throws InterruptedException {
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        sleep(300);
        boolean result = userPage.sideBar.GetSideBarItem(id).checkItemIntoSideBar();
        Assert.assertTrue(result);
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.close();
        driver.quit();
    }
}
