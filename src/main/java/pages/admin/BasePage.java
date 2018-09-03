package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.userPageComponents.Header;
import pages.admin.userPageComponents.SideBar;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Header header;
    protected SideBar sideBar;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        header = new Header(driver);
        sideBar = new SideBar(driver);
    }

    public void hoverMouseAboveSideBarItemByName(String name){
        sideBar.GetSideBarItem(name).hoverMouseOverItem();
    }

    public void chooseSubmenuItem(String menuItem, String submenuItem){
        sideBar.GetSideBarItem(menuItem).chooseSubMenuItemById(submenuItem);
    }
}
