package pages.userPageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBarItem {
    private WebDriver driver;

    public WebElement getItem(){
        return driver.findElement(By.xpath("//li[@id='" + id + "']"));
    }

    private String id;


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

    public boolean checkItemIntoSideBar(){
        System.out.println(getTitleOfItem());
        chooseItem();
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().refresh();
        return currentUrl.equals(driver.getCurrentUrl());
    }
}
