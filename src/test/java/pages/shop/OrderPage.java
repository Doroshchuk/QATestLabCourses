package pages.shop;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage extends Header{

    @FindBy(xpath = "//h3[@class='h1 card-title']")
    private WebElement messageLbl;

    @FindBy(xpath = "//div[@class='col-sm-4 col-xs-9 details']//span")
    private WebElement orderedProductNameLbl;

    @FindBy(xpath = "//div[@class='col-xs-5 text-sm-right text-xs-left']")
    private WebElement orderedProductPriceLbl;

    @FindBy(className = "col-xs-2")
    private WebElement orderedProductQuantityLbl;

    public OrderPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getMessage(){
        return messageLbl.getText();
    }

    public String getProductName(){
        wait.until(ExpectedConditions.visibilityOf(orderedProductNameLbl));
        return orderedProductNameLbl.getText();
    }

    public int getProductQuantity(){
        wait.until(ExpectedConditions.visibilityOf(orderedProductQuantityLbl));
        return Integer.parseInt(orderedProductQuantityLbl.getText().split(" ")[0]);
    }

    public double getProductPrice(){
        wait.until(ExpectedConditions.visibilityOf(orderedProductPriceLbl));
        return Double.valueOf(orderedProductPriceLbl.getText().split(" ")[0].replace(',', '.'));
    }

    public Product getOrderedProduct(){
        return new Product(getProductName().toUpperCase(), getProductQuantity(), getProductPrice());
    }
}
