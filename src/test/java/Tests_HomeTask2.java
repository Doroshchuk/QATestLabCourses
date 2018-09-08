import models.Category;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.admin.*;

public class Tests_HomeTask2 extends BaseTest {
    private AuthorizationPage authorizationPage;
    private MainUserPage userPage;
    private CategoriesManagerPage categoriesManagerPage;
    private CategoryPage categoryPage;
    private Category category;

    @BeforeClass
    public void initialize(){
        authorizationPage = new AuthorizationPage(driver);
        userPage = new MainUserPage(driver);
        categoriesManagerPage = new CategoriesManagerPage(driver);
        categoryPage = new CategoryPage(driver);
    }

    @Test(priority = 0)
    public void testCreatingCategory() {
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        wait.until(ExpectedConditions.visibilityOf(userPage.userImg));
        userPage.hoverMouseAboveSideBarItemByName("subtab-AdminCatalog");
        userPage.chooseSubmenuItem("subtab-AdminCatalog", "subtab-AdminCategories");
        categoriesManagerPage.clickOnBtnToCreateCategory();
        category = categoryPage.createNewCategory();
        Assert.assertTrue(categoriesManagerPage.getMessageText().contains("Создано"));
    }

    @Test(priority = 1, dependsOnMethods = {"testCreatingCategory"})
    public void testFindingCategory() {
        int quantityOfCategories = categoriesManagerPage.getQuantityCategoriesByName(category.getName());
        Assert.assertTrue(quantityOfCategories == 1);
    }
}
