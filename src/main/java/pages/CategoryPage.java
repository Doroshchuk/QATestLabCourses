package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.userPageComponents.SideBar;

public class CategoryPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='page-header-desc-category-new_category']")
    public WebElement addCategoryBtn;

    @FindBy(xpath = "//h2")
    public WebElement title;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
