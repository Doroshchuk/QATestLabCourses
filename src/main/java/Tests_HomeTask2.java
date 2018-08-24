import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoriesManagerPage;
import pages.CategoryPage;
import pages.SearchResultPage;
import testHelper.TestHelper;

public class Tests_HomeTask2 extends BaseTest {
    private WebDriverWait wait;
    private CategoriesManagerPage categoriesManagerPage;
    private CategoryPage categoryPage;
    private SearchResultPage searchResultPage;

    @Test(priority = 0)
    public void testCreatingCategory() {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(authorizationPage.logInBtn));
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        wait.until(ExpectedConditions.visibilityOf(userPage.userImg));
        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").hoverMouseOverItem();
        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").chooseSubMenuItemById("subtab-AdminCategories");
        categoriesManagerPage = new CategoriesManagerPage(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(categoriesManagerPage.title, "категории"));
        TestHelper.ClickOnElementUsingJS(driver, categoriesManagerPage.addCategoryBtn);
        categoryPage = new CategoryPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(categoryPage.categoryNameTF));
        categoryPage.createNewCategory("TestCategory");
        wait.until(ExpectedConditions.textToBePresentInElement(categoriesManagerPage.title, "категории"));
        Assert.assertTrue(categoriesManagerPage.messageBlock.getText().contains("Создано"));
        categoriesManagerPage.findCategoryByName("TestCategory");
        searchResultPage = new SearchResultPage(driver);
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.resultTitle));
        Assert.assertEquals(searchResultPage.resultTitle.getText(), "Запросу \"TestCategory\" соответствует 1 результат.");
    }
}
