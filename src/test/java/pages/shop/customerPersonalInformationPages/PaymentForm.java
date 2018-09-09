package pages.shop.customerPersonalInformationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentForm {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "payment-option-1")
    private WebElement paymentWithCheckRB;

    @FindBy(id = "payment-option-2")
    private WebElement paymentWithCardRB;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreementWithConditionsCheckbox;

    @FindBy(xpath = "//button[@class='btn btn-primary center-block']")
    private WebElement orderWithPaymentObligationBtn;

    public PaymentForm(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void choosePaymentType(){
        paymentWithCheckRB.click();
        agreementWithConditionsCheckbox.click();
        orderWithPaymentObligationBtn.click();
    }
}