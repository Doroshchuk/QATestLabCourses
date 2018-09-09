package pages.shop;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShopProductPage extends Header{
    @FindBy(className = "h1")
    private WebElement productNameLbl;

    @FindBy(xpath = "//div[@class='product-quantities']//span")
    private WebElement productQuantityLbl;

    @FindBy(xpath = "//div[@class='current-price']//span")
    private WebElement productPriceLbl;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement addToBasketBtn;

    @FindBy(xpath = "//a[@href='#product-details']")
    private WebElement getDetailAboutProductLink;

    public ShopProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName(){
        wait.until(ExpectedConditions.visibilityOf(productNameLbl));
        return productNameLbl.getText();
    }

    public int getProductQuantity(){
        wait.until(ExpectedConditions.elementToBeClickable(getDetailAboutProductLink));
        getDetailAboutProductLink.click();
        wait.until(ExpectedConditions.visibilityOf(productQuantityLbl));
        return Integer.parseInt(productQuantityLbl.getText().split(" ")[0]);
    }

    public double getProductPrice(){
        wait.until(ExpectedConditions.visibilityOf(productPriceLbl));
        return Double.valueOf(productPriceLbl.getAttribute("content"));
    }

    public Product addProductToBasket(){
        Product product = new Product(getProductName(), getProductQuantity(), getProductPrice());
        addToBasketBtn.click();
        return product;
    }
}
