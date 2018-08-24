package pages.userPageComponents;

import testHelper.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class SideBarItem {
    private WebDriver driver;
    private String id;

    public WebElement getItem(){
        return driver.findElement(By.xpath("//li[@id='" + id + "']"));
    }

    public WebElement getSubMenuItem(String id){
        return getItem().findElement(By.xpath("//ul[@class='submenu']//li[@id='" + id + "']//a"));
    }

    public SideBarItem(WebDriver driver, String id){
        this.driver = driver;
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
        action.moveToElement(getItem()).build().perform();
    }

    public void chooseSubMenuItemById(String id){
        TestHelper.ClickOnElementUsingJS(driver, getSubMenuItem(id));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", getSubMenuItem(id));
    }

    public boolean checkItemIntoSideBar(){
        System.out.println(getTitleOfItem());
        chooseItem();
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().refresh();
        return currentUrl.equals(driver.getCurrentUrl());
    }
}
