package pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "s")
    private WebElement searchTF;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitSearch;

    @FindBy(xpath = "//a[img[@class='logo img-responsive']]//parent::div")
    public WebElement logoBlock;

    public Header(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void searchProductByName(String name){
        wait.until(ExpectedConditions.elementToBeClickable(searchTF));
        searchTF.sendKeys(name);
        submitSearch.click();
    }

    public String GetLogoBlockId(){
        return logoBlock.getAttribute("id");
    }
}
