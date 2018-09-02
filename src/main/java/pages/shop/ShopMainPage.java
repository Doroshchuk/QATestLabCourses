package pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopMainPage {
    private WebDriver driver;
    public static String url = "http://prestashop-automation.qatestlab.com.ua/ru/";

    @FindBy(xpath = "//h1[@class='h1 products-section-title text-uppercase ']")
    public WebElement title;

    @FindBy(className = "all-product-link pull-xs-left pull-md-right h4")
    public WebElement previewAllProductsLink;

    public ShopMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
