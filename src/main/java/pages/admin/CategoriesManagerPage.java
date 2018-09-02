package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesManagerPage extends BasePage{

    @FindBy(css = "a[id='page-header-desc-category-new_category']")
    public WebElement addCategoryBtn;

    @FindBy(tagName = "h2")
    public WebElement title;

    @FindBy(css = "div[class='alert alert-success']")
    public WebElement messageBlock;

    public CategoriesManagerPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
