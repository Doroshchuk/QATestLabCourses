package pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.shop.customerPersonalInformationPages.MainPersonalInformationForm;
import testHelper.TestHelper;

public class CustomerPersonalInformationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private MainPersonalInformationForm mainPersonalInformationForm;

    public CustomerPersonalInformationPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        mainPersonalInformationForm = new MainPersonalInformationForm(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillInMainPersonalInformation(){
        mainPersonalInformationForm.fillInPersonalInformationWithRandomData();
    }
}
