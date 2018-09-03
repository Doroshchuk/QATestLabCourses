package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.admin.categoriesManagerForms.FilterTableForm;
import testHelper.TestHelper;

public class CategoriesManagerPage extends BasePage{
    private FilterTableForm filterTableForm;

    @FindBy(css = "a[id='page-header-desc-category-new_category']")
    private WebElement addCategoryBtn;

    @FindBy(tagName = "h2")
    private WebElement title;

    @FindBy(css = "div[class='alert alert-success']")
    private WebElement messageBlock;

    public CategoriesManagerPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getQuantityCategoriesByName(String name){
        wait.until(ExpectedConditions.visibilityOf(addCategoryBtn));
        filterTableForm = new FilterTableForm(driver);
        filterTableForm.filterTableByName(name);
        return filterTableForm.getQuantityResultsAfterFiltering();
    }

    public String getMessageText(){
        wait.until(ExpectedConditions.visibilityOf(messageBlock));
        return messageBlock.getText();
    }

    public void clickOnBtnToCreateCategory(){
        wait.until(ExpectedConditions.visibilityOf(addCategoryBtn));
        TestHelper.ClickOnElementUsingJS(driver, addCategoryBtn);
    }
}
