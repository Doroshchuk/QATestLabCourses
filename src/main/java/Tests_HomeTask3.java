import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests_HomeTask3 extends BaseTest{
    private WebDriverWait wait;

    @DataProvider(name = "AuthorizationData")
    public static Object[] credentials() {
        return new Object[] {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"};
    }

    @Test(priority = 0)
    public void testCreatingCategory() {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(authorizationPage.logInBtn));
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        wait.until(ExpectedConditions.visibilityOf(userPage.userImg));
        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").hoverMouseOverItem();
        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").chooseSubMenuItemById("subtab-AdminProducts");

    }
}
