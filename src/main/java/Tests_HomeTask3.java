import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.MainUserPage;
import pages.ProductPage;
import pages.ProductsManagerPage;

public class Tests_HomeTask3 extends BaseTest{
    private WebDriverWait wait;
    private AuthorizationPage authorizationPage;
    private MainUserPage userPage;
    private ProductsManagerPage productsManagerPage;
    private ProductPage productPage;

    @BeforeClass
    public void initialize(){
        wait = new WebDriverWait(driver, 20);
        authorizationPage = new AuthorizationPage(driver);
        userPage = new MainUserPage(driver);
        productsManagerPage = new ProductsManagerPage(driver);
        productPage = new ProductPage(driver);
    }

    @DataProvider(name = "AuthorizationData")
    public static Object[] credentials() {
        return new Object[] {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"};
    }

    @Test(priority = 0)
    public void testCreatingCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(authorizationPage.logInBtn));
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        wait.until(ExpectedConditions.visibilityOf(userPage.userImg));
        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").hoverMouseOverItem();
        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").chooseSubMenuItemById("subtab-AdminProducts");
        wait.until(ExpectedConditions.elementToBeClickable(productsManagerPage.addProductBtn));
        productsManagerPage.addProductBtn.click();
        wait.until(ExpectedConditions.visibilityOf(productPage.productNameTF));
        productPage.createNewProduct();
    }
}
