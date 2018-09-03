package pages.admin;

import models.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testHelper.TestHelper;

public class CategoryPage extends BasePage{
    @FindBy(css = "input[name='name_1']")
    public WebElement categoryNameTF;

    @FindBy(css = "button[id='category_form_submit_btn']")
    public WebElement saveBtn;

    public CategoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Category createNewCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(categoryNameTF));
        Category category = new Category(TestHelper.getRandomString(10));
        categoryNameTF.sendKeys(category.getName());
        Actions action = new Actions(driver);
        action.moveToElement(saveBtn).click().build().perform();
        return category;
    }
}
