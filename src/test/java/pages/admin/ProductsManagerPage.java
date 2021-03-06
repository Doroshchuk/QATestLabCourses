package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsManagerPage extends BasePage{

    @FindBy(id = "page-header-desc-configuration-add")
    public WebElement addProductBtn;

    @FindBy(tagName = "h2")
    public WebElement title;

    public ProductsManagerPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickToCreateCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(addProductBtn));
        addProductBtn.click();
    }
}
