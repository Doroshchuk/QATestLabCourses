package pages.admin.categoriesManagerForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilterTableForm {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "categoryFilter_id_category")
    private WebElement categoryIdTF;

    @FindBy(name = "categoryFilter_name")
    private WebElement categoryNameTF;

    @FindBy(name = "categoryFilter_description")
    private WebElement categoryDescriptionTF;

    @FindBy(name = "categoryFilter_sa!position")
    private WebElement categoryPositionTF;

    @FindBy(id = "submitFilterButtoncategory")
    private WebElement filterBtn;

    @FindBy(xpath = "//tr[@class=' odd']")
    private List<WebElement> recordsRows;

    public FilterTableForm(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void filterTableByName(String name){
        categoryNameTF.sendKeys(name);
        filterBtn.click();
    }

    public int getQuantityResultsAfterFiltering(){
        wait.until(ExpectedConditions.elementToBeClickable(categoryNameTF));
        return recordsRows.size();
    }
}
