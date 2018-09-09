import models.Product;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.shop.*;

public class Tests_HomeTask4 extends BaseTest{
    private ShopMainPage shopMainPage;
    private AllProductsPage allProductsPage;
    private ShopProductPage shopProductPage;
    private ProductInBasketPopUp productInBasketPopUp;
    private Product product;
    private BasketPage basketPage;
    private CustomerPersonalInformationPage customerPersonalInformationPage;

    @BeforeClass
    public void initialize(){
        shopMainPage = new ShopMainPage(driver);
        allProductsPage = new AllProductsPage(driver);
        shopProductPage = new ShopProductPage(driver);
        productInBasketPopUp = new ProductInBasketPopUp(driver);
        basketPage = new BasketPage(driver);
        customerPersonalInformationPage = new CustomerPersonalInformationPage(driver);
    }

    @Test(priority = 0)
    public void testSiteVersion() {
        if (browserType.equals("mobile")){
            Assert.assertEquals(shopMainPage.GetLogoBlockId(), "_mobile_logo");
        } else {
            Assert.assertEquals(shopMainPage.GetLogoBlockId(), "_desktop_logo");
        }
    }

    @Test(priority = 1)
    public void testAddingProductToBasket() {
        shopMainPage.clickToPreviewAllProducts();
        allProductsPage.viewRandomProduct();
        product = shopProductPage.addProductToBasket();
        productInBasketPopUp.goToOrder();
        Assert.assertTrue(basketPage.getProductName().toUpperCase().equals(product.getName())
                && basketPage.getProductOrderedQuantity() == 1
                && basketPage.getProductPrice() == product.getPrice());
    }

    @Test(priority = 2, dependsOnMethods = "testAddingProductToBasket")
    public void testCreatingOrder() {
        basketPage.goToOrder();
        customerPersonalInformationPage.fillInPersonalInformationWithRandomData();
    }
}
