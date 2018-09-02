import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.admin.*;
import testHelper.TestHelper;

public class Tests_HomeTask2 extends BaseTest {
    private AuthorizationPage authorizationPage;
    private MainUserPage userPage;
    private CategoriesManagerPage categoriesManagerPage;
    private CategoryPage categoryPage;
    private SearchResultPage searchResultPage;

    @BeforeClass
    public void initialize(){
        authorizationPage = new AuthorizationPage(driver);
        userPage = new MainUserPage(driver);
        categoriesManagerPage = new CategoriesManagerPage(driver);
        categoryPage = new CategoryPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test(priority = 0)
    public void testCreatingCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(authorizationPage.logInBtn));
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        wait.until(ExpectedConditions.visibilityOf(userPage.userImg));
        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").hoverMouseOverItem();
        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").chooseSubMenuItemById("subtab-AdminCategories");
        wait.until(ExpectedConditions.textToBePresentInElement(categoriesManagerPage.title, "категории"));
        TestHelper.ClickOnElementUsingJS(driver, categoriesManagerPage.addCategoryBtn);
        wait.until(ExpectedConditions.elementToBeClickable(categoryPage.categoryNameTF));
        categoryPage.createNewCategory("TestCategoryNewVersion4");
        wait.until(ExpectedConditions.textToBePresentInElement(categoriesManagerPage.title, "категории"));
        Assert.assertTrue(categoriesManagerPage.messageBlock.getText().contains("Создано"));
    }

    @Test(priority = 1, dependsOnMethods = {"testCreatingCategory"})
    public void testFindingCategory() {
        wait.until(ExpectedConditions.textToBePresentInElement(categoriesManagerPage.title, "категории"));
        categoriesManagerPage.header.findByName("TestCategoryNewVersion4");
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.resultTitle));
        Assert.assertEquals(searchResultPage.resultTitle.getText(), "Запросу \"TestCategoryNewVersion4\" соответствует 1 результат.");
    }
}
