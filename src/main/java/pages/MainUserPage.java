package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainUserPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='employee_avatar_small']//img")
    public WebElement userImg;

    @FindBy(xpath = "//ul[@id='header_employee_box']//li//a[@id='header_logout']")
    public WebElement logOutLink;

    public MainUserPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void LogOut(){
        userImg.click();
        logOutLink.click();
    }
}
