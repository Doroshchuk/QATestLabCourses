import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.MainUserPage;

import java.util.concurrent.TimeUnit;

public class Tests {
    private WebDriver driver;
    private AuthorizationPage authorizationPage;
    private MainUserPage userPage;
    private String driverPath = Tests.class.getResource("chromedriver.exe").getPath();
    private String baseUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void testAuthorizationAndLogOut() {
        authorizationPage = new AuthorizationPage(driver);
        userPage = new MainUserPage(driver);
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        wait(300);
        userPage.LogOut();
        wait(300);
        Assert.assertEquals(authorizationPage.title.getText(), "prestashop-automation");
    }

    public void wait(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        } catch (Exception ex){
           System.out.println(ex);
        }
    }

    @AfterClass(alwaysRun = true)
    public void close() {
        driver.close();
    }
}
