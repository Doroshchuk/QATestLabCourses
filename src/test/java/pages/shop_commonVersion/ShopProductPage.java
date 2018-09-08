package pages.shop_commonVersion;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShopProductPage extends Header{
    @FindBy(className = "h1")
    private WebElement productNameLbl;

    @FindBy(id = "quantity_wanted")
    private WebElement productQuantityTF;

    @FindBy(xpath = "//div[@class='current-price']//span")
    private WebElement productPriceLbl;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement addToBasketBtn;

    public ShopProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName(){
        wait.until(ExpectedConditions.visibilityOf(productNameLbl));
        return productNameLbl.getText();
    }

    public int getProductQuantity(){
        wait.until(ExpectedConditions.elementToBeClickable(productQuantityTF));
        return Integer.parseInt(productQuantityTF.getAttribute("value"));
    }

    public double getProductPrice(){
        wait.until(ExpectedConditions.visibilityOf(productPriceLbl));
        return Double.valueOf(productPriceLbl.getAttribute("content"));
    }

    public Product addProductToBasket(){
        Product product = new Product(getProductName(), 1, getProductPrice());
        addToBasketBtn.click();
        return product;
    }
}
