package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='col-lg-12']//h2")
    public WebElement resultTitle;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
