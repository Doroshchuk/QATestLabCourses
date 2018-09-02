package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    private WebDriver driver;

    @FindBy(css = "logo pull-left']")
    public WebElement goToMainPageLogo;

    @FindBy(css = "input[id='bo_query']")
    public WebElement searchBoxTF;

    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void findByName(String name){
        searchBoxTF.sendKeys(name);
        searchBoxTF.submit();
    }
}
