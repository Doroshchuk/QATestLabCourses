import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.admin.AuthorizationPage;
import pages.admin.MainUserPage;
import pages.admin.ProductPage;
import pages.admin.ProductsManagerPage;
import pages.shop.ShopMainPage;

public class Tests_HomeTask3 extends BaseTest{
    private AuthorizationPage authorizationPage;
    private MainUserPage userPage;
    private ProductsManagerPage productsManagerPage;
    private ProductPage productPage;
    private Product product;
    private ShopMainPage shopMainPage;

    @BeforeClass
    public void initialize(){
        authorizationPage = new AuthorizationPage(driver);
        userPage = new MainUserPage(driver);
        productsManagerPage = new ProductsManagerPage(driver);
        productPage = new ProductPage(driver);
        shopMainPage = new ShopMainPage(driver);
    }

    @DataProvider(name = "AuthorizationData")
    public static Object[] credentials() {
        return new Object[] {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"};
    }

    @Test(priority = 0)
    public void testCreatingCategory() {
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        userPage.hoverMouseAboveSideBarItemByName("subtab-AdminCatalog");
        userPage.chooseSubmenuItem("subtab-AdminCatalog", "subtab-AdminProducts");
        productsManagerPage.clickToCreateCategory();
        product = productPage.createNewProduct();
        productPage.goToShop();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("prestashop-automation"));
        driver.switchTo().frame("prestashop-automation");
        wait.until(ExpectedConditions.visibilityOf(shopMainPage.title));
        shopMainPage.previewAllProductsLink.click();
    }
}
