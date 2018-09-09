package pages.shop.customerPersonalInformationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testHelper.TestHelper;

public class AddressPersonalInformationForm {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "address1")
    private WebElement customerAddressTF;

    @FindBy(name = "city")
    private WebElement customerCityTF;

    @FindBy(name = "postcode")
    private WebElement customerPostcodeTF;

    @FindBy(name = "confirm-addresses")
    private WebElement continueBtn;

    public AddressPersonalInformationForm(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void fillInAddress(String city, String address, String postcode){
        wait.until(ExpectedConditions.elementToBeClickable(customerAddressTF));
        customerAddressTF.sendKeys(address);
        customerPostcodeTF.sendKeys(postcode);
        customerCityTF.sendKeys(city);
        continueBtn.click();
    }
}
