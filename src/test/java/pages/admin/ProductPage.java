package pages.admin;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testHelper.TestHelper;

public class ProductPage extends BasePage{
    @FindBy(id = "form_step1_name_1")
    public WebElement productNameTF;

    @FindBy(id = "form_step1_qty_0_shortcut")
    public WebElement productQuantityTF;

    @FindBy(id = "form_step1_price_shortcut")
    public WebElement productPriceWithoutNSD_TF;

    @FindBy(id = "form_step1_price_ttc_shortcut")
    public WebElement productPriceWithNSD_TF;

    @FindBy(xpath = "//div[input[@id='form_step1_active']]")
    public WebElement productNetworkCheckbox;

    @FindBy(className = "growl-message")
    public WebElement networkMessageBlock;

    @FindBy(className = "growl-close")
    public WebElement closeNetworkMessageBtn;

    @FindBy(xpath = "//button[@class='btn btn-primary js-btn-save' and @type = 'submit']")
    public WebElement saveProductBtn;

    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Product createNewProduct(){
        wait.until(ExpectedConditions.visibilityOf(productNameTF));
        Product product = new Product();
        product.setName(TestHelper.getRandomString(10));
        product.setPrice(TestHelper.getRandomDoubleNumber());
        product.setQuantity(TestHelper.getRandomIntNumber());
        productNameTF.sendKeys(product.getName());
        TestHelper.insertValueIntoTF(productQuantityTF, String.valueOf(product.getQuantity()));
        TestHelper.insertValueIntoTF(productPriceWithoutNSD_TF, String.valueOf(product.getPrice()));
        productNetworkCheckbox.click();
        wait.until(ExpectedConditions.visibilityOf(networkMessageBlock));
        closeNetworkMessageBtn.click();
        saveProductBtn.click();
        wait.until(ExpectedConditions.visibilityOf(networkMessageBlock));
        closeNetworkMessageBtn.click();
        return product;
    }
}
