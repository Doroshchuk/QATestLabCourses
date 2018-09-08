package pages.shop_commonVersion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductInBasketPopUp {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement goToOrderBtn;

    public ProductInBasketPopUp(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void goToOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(goToOrderBtn));
        goToOrderBtn.click();
    }
}
