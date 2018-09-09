package pages.shop_commonVersion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import testHelper.TestHelper;

public class CustomerPersonalInformationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstname")
    private WebElement customerNameTF;

    @FindBy(name = "lastname")
    private WebElement customerSurnameTF;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "continue")
    private WebElement continueBtn;

    public CustomerPersonalInformationPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void fillInPersonalInformationWithRandomData(){
        customerNameTF.sendKeys(TestHelper.getRandomString(9));
        customerSurnameTF.sendKeys(TestHelper.getRandomString(12));
        email.sendKeys(TestHelper.getRandomString(10) + "@gmail.com");
        continueBtn.click();
    }
}
