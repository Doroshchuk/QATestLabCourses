package pages.shop.customerPersonalInformationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import testHelper.TestHelper;

public class DeliveryInformationForm {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "delivery_option_1")
    private WebElement pickUpDeliveryRB;

    @FindBy(id = "delivery_option_2")
    private WebElement deliveryWithCourierRB;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement continueBtn;

    public DeliveryInformationForm(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void chooseTypeOfDelivery(){
        //TestHelper.clickOnElementUsingJS(driver, deliveryWithCourierRB);
        continueBtn.click();
    }
}
