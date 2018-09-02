package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.userPageComponents.SideBar;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Header header;
    public SideBar sideBar;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        header = new Header(driver);
        sideBar = new SideBar(driver);
    }
}
