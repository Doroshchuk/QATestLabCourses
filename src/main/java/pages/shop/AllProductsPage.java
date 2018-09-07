package pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AllProductsPage extends Header{

    @FindBy(xpath = "//div[@class='thumbnail-container']")
    private List<WebElement> products;

    public AllProductsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getQuantityOfProducts(){
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
        return products.size();
    }

    public void viewProduct(){
        WebElement speedSearchBtn = products.get(0).findElement(By.tagName("a"));
        speedSearchBtn.click();
    }
}
