package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesManagerPage {
    private WebDriver driver;

    @FindBy(css = "a[id='page-header-desc-category-new_category']")
    public WebElement addCategoryBtn;

    @FindBy(tagName = "h2")
    public WebElement title;

    @FindBy(css = "div[class='alert alert-success']")
    public WebElement messageBlock;

    @FindBy(css = "input[id='bo_query']")
    public WebElement searchBoxTF;

    public CategoriesManagerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void findCategoryByName(String name){
        searchBoxTF.sendKeys(name);
        searchBoxTF.submit();
    }
}
