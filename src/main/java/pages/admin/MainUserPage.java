package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainUserPage extends BasePage{
    @FindBy(xpath = "//span[@class='employee_avatar_small']//img")
    public WebElement userImg;

    @FindBy(id = "header_logout")
    public WebElement logOutLink;

    public MainUserPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void LogOut(){
        userImg.click();
        logOutLink.click();
    }

    public boolean checkItemIntoSideBar(String id){
        return sideBar.GetSideBarItem(id).checkItemIntoSideBar();
    }
}
