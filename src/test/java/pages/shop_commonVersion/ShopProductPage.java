package pages.shop_commonVersion;

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

    @FindBy(xpath = "//div[@class='modal-content']//h1")
    private WebElement productPriceLbl;

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
        return Integer.parseInt(productPriceLbl.getAttribute("content"));
    }
}
