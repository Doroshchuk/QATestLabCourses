package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage{
    @FindBy(xpath = "//div[@class='col-lg-12']//h2")
    public WebElement resultTitle;

    public SearchResultPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
