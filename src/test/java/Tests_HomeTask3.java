import models.Product;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.admin.AuthorizationPage;
import pages.admin.MainUserPage;
import pages.admin.ProductPage;
import pages.admin.ProductsManagerPage;
import pages.shop_commonVersion.AllProductsPage;
import pages.shop_commonVersion.ShopMainPage;
import pages.shop_commonVersion.ShopProductPage;

public class Tests_HomeTask3 extends BaseTest{
    private AuthorizationPage authorizationPage;
    private MainUserPage userPage;
    private ProductsManagerPage productsManagerPage;
    private ProductPage productPage;
    private Product product;
    private ShopMainPage shopMainPage;
    private AllProductsPage allProductsPage;
    private ShopProductPage shopProductPage;

    @BeforeClass
    public void initialize(){
        authorizationPage = new AuthorizationPage(driver);
        userPage = new MainUserPage(driver);
        productsManagerPage = new ProductsManagerPage(driver);
        productPage = new ProductPage(driver);
        shopMainPage = new ShopMainPage(driver);
        allProductsPage = new AllProductsPage(driver);
        shopProductPage = new ShopProductPage(driver);
    }

    @DataProvider(name = "AuthorizationData")
    public static Object[] credentials() {
        return new Object[] {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"};
    }

    @Test(priority = 0)
    public void testCreatingProduct() {
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        userPage.hoverMouseAboveSideBarItemByName("subtab-AdminCatalog");
        userPage.chooseSubmenuItem("subtab-AdminCatalog", "subtab-AdminProducts");
        productsManagerPage.clickToCreateCategory();
        product = productPage.createNewProduct();
        productPage.goToShop();
        goToNewWindow();
        shopMainPage.clickToPreviewAllProducts();
        allProductsPage.searchProductByName(product.getName());
        Assert.assertEquals(allProductsPage.getQuantityOfProducts(), 1);
    }

    @Test(priority = 1, dependsOnMethods = "testCreatingProduct")
    public void testProductName() {
        allProductsPage.viewProduct(0);
        Assert.assertTrue(shopProductPage.getProductName().equals(product.getName().toUpperCase())
            && shopProductPage.getProductQuantity() == product.getQuantity()
            && shopProductPage.getProductPrice() == product.getPrice());
    }
}
