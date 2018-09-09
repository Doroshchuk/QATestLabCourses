package pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShopMainPage extends Header{
    public static String url = "http://prestashop-automation.qatestlab.com.ua/ru/";

    @FindBy(xpath = "//h1[@class='h1 products-section-title text-uppercase ']")
    private WebElement title;

    @FindBy(xpath = "//a[@class='all-product-link pull-xs-left pull-md-right h4']")
    private WebElement previewAllProductsLink;

    public ShopMainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickToPreviewAllProducts(){
        wait.until(ExpectedConditions.visibilityOf(title));
        previewAllProductsLink.click();
    }
}
