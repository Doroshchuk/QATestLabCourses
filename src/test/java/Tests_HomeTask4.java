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
    private Product expectedProduct;
    private BasketPage basketPage;
    private CustomerPersonalInformationPage customerPersonalInformationPage;
    private OrderPage orderPage;

    @BeforeClass
    public void initialize(){
        shopMainPage = new ShopMainPage(driver);
        allProductsPage = new AllProductsPage(driver);
        shopProductPage = new ShopProductPage(driver);
        productInBasketPopUp = new ProductInBasketPopUp(driver);
        basketPage = new BasketPage(driver);
        customerPersonalInformationPage = new CustomerPersonalInformationPage(driver);
        orderPage = new OrderPage(driver);
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
        expectedProduct = shopProductPage.addProductToBasket();
        productInBasketPopUp.goToOrder();
        Assert.assertTrue(basketPage.getProductName().toUpperCase().equals(expectedProduct.getName())
                && basketPage.getProductOrderedQuantity() == 1
                && basketPage.getProductPrice() == expectedProduct.getPrice());
    }

    @Test(priority = 2, dependsOnMethods = "testAddingProductToBasket")
    public void testCreatingOrder_AppearSuccessfulMessage() {
        basketPage.goToOrder();
        customerPersonalInformationPage.fillInMainPersonalInformation("Кадетский Гай 10", "03048", "Киев");
        Assert.assertTrue(orderPage.getMessage().contains("Ваш заказ подтверждён".toUpperCase()));
    }

    @Test(priority = 2, dependsOnMethods = "testCreatingOrder_AppearSuccessfulMessage")
    public void testCreatingOrder_RightPrroductData() {
        Product actualProduct = orderPage.getOrderedProduct();
        Assert.assertEquals(actualProduct, new Product(expectedProduct.getName(), 1, expectedProduct.getPrice()));
    }

    @Test(priority = 2, dependsOnMethods = "testCreatingOrder_RightPrroductData")
    public void testChangingInformationAboutProduct() {
        driver.get(baseUrl);
        shopMainPage.clickToPreviewAllProducts();
        allProductsPage.searchProductByName(expectedProduct.getName());
        allProductsPage.viewProduct(0);
        Assert.assertEquals(shopProductPage.getProductQuantity(), expectedProduct.getQuantity() - 1);
    }
}
