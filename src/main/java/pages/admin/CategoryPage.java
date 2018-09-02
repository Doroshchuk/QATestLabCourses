package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage extends BasePage{
    @FindBy(css = "input[name='name_1']")
    public WebElement categoryNameTF;

    @FindBy(css = "button[id='category_form_submit_btn']")
    public WebElement saveBtn;

    public CategoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void createNewCategory(String name){
        categoryNameTF.sendKeys(name);
        Actions action = new Actions(driver);
        action.moveToElement(saveBtn).click().build().perform();
    }
}
