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
import testHelper.TestHelper;

import java.util.Iterator;
import java.util.Set;

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
        wait.until(ExpectedConditions.elementToBeClickable(authorizationPage.logInBtn));
        authorizationPage.signInToAccount("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        wait.until(ExpectedConditions.visibilityOf(userPage.userImg));
//        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").hoverMouseOverItem();
//        userPage.sideBar.GetSideBarItem("subtab-AdminCatalog").chooseSubMenuItemById("subtab-AdminProducts");
//        wait.until(ExpectedConditions.elementToBeClickable(productsManagerPage.addProductBtn));
//        productsManagerPage.addProductBtn.click();
//        wait.until(ExpectedConditions.visibilityOf(productPage.productNameTF));
//        product = productPage.createNewProduct();
//        wait.until(ExpectedConditions.elementToBeClickable(productPage.header.goToShopMainPageLink));
//        TestHelper.ClickOnElementUsingJS(driver, productPage.header.goToShopMainPageLink);
        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("prestashop-automation"));
//        driver.switchTo().frame("prestashop-automation");
//        //System.out.println(driver.getCurrentUrl());
//        wait.until(ExpectedConditions.visibilityOf(shopMainPage.title));
//        shopMainPage.previewAllProductsLink.click();
    }
}
