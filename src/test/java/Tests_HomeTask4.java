import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.shop_commonVersion.ShopMainPage;

public class Tests_HomeTask4 extends BaseTest{
    private ShopMainPage shopMainPage;

    @BeforeClass
    public void initialize(){
        shopMainPage = new ShopMainPage(driver);
    }

    @Test(priority = 0)
    public void testSiteVersion() {
        if (browserType.equals("mobile")){
            Assert.assertEquals(shopMainPage.GetLogoBlockId(), "_mobile_logo");
        } else {
            Assert.assertEquals(shopMainPage.GetLogoBlockId(), "_desktop_logo");
        }
    }
}
