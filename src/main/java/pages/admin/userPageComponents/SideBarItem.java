package pages.admin.userPageComponents;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testHelper.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class SideBarItem {
    private WebDriver driver;
    protected WebDriverWait wait;
    public String id;

    public WebElement getItem(){
        return driver.findElement(By.id(id));
    }

    public WebElement getSubMenuItem(String id){
        return driver.findElement(By.xpath("//ul[@class='submenu']//li[@id='" + id + "']//a"));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SideBarItem(WebDriver driver, String id){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        this.id = id;
        PageFactory.initElements(driver, this);
    }

    public String getTitleOfItem(){
        return getItem().findElement(By.tagName("span")).getText();
    }

    public void chooseItem(){
        getItem().click();
    }

    public void hoverMouseOverItem(){
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        action.moveToElement(getItem()).build().perform();
    }

    public void chooseSubMenuItemById(String id){
        TestHelper.ClickOnElementUsingJS(driver, getSubMenuItem(id));
    }

    public boolean checkItemIntoSideBar(){
        System.out.println(getTitleOfItem());
        chooseItem();
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().refresh();
        return currentUrl.equals(driver.getCurrentUrl());
    }
}
