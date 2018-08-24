import org.testng.Assert;
import org.testng.annotations.*;

public class Tests_HomeTask1 extends BaseTest{
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

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
