package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesManagerPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='page-header-desc-category-new_category']")
    public WebElement addCategoryBtn;

    @FindBy(xpath = "//h2")
    public WebElement title;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement messageBlock;

    @FindBy(xpath = "//input[@id='bo_query']")
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
