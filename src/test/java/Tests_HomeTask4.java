import models.Product;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.shop_commonVersion.*;

public class Tests_HomeTask4 extends BaseTest{
    private ShopMainPage shopMainPage;
    private AllProductsPage allProductsPage;
    private ShopProductPage shopProductPage;
    private ProductInBasketPopUp productInBasketPopUp;
    private Product product;
    private BasketPage basketPage;

    @BeforeClass
    public void initialize(){
        shopMainPage = new ShopMainPage(driver);
        allProductsPage = new AllProductsPage(driver);
        shopProductPage = new ShopProductPage(driver);
        productInBasketPopUp = new ProductInBasketPopUp(driver);
        basketPage = new BasketPage(driver);
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
    public void testCreatingOrder() {
        shopMainPage.clickToPreviewAllProducts();
        allProductsPage.viewRandomProduct();
        product = shopProductPage.addProductToBasket();
        productInBasketPopUp.goToOrder();
        Assert.assertTrue(basketPage.getProductName().toUpperCase().equals(product.getName())
                && basketPage.getProductOrderedQuantity() == product.getQuantity()
                && basketPage.getProductPrice() == product.getPrice());
    }
}
