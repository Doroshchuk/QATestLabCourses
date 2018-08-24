import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CategoryPage;
import testHelper.TestHelper;

public class Tests_HomeTask2 extends BaseTest {
    private WebDriverWait wait;
    public CategoryPage categoryPage;

    @Test(priority = 0)
    public void testCreatingCategory() {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(authorizationPage.logInBtn));
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        wait.until(ExpectedConditions.visibilityOf(userPage.userImg));
        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").hoverMouseOverItem();
        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").chooseSubMenuItemById("subtab-AdminCategories");
        categoryPage = new CategoryPage(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(categoryPage.title, "категории"));
        TestHelper.ClickOnElementUsingJS(driver, categoryPage.addCategoryBtn);
    }
}
