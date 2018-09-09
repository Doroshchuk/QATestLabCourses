package pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.shop.customerPersonalInformationPages.AddressPersonalInformationForm;
import pages.shop.customerPersonalInformationPages.DeliveryInformationForm;
import pages.shop.customerPersonalInformationPages.MainPersonalInformationForm;
import testHelper.TestHelper;

public class CustomerPersonalInformationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private MainPersonalInformationForm mainPersonalInformationForm;
    private AddressPersonalInformationForm addressPersonalInformationForm;
    private DeliveryInformationForm deliveryInformationForm;

    public CustomerPersonalInformationPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        mainPersonalInformationForm = new MainPersonalInformationForm(driver);
        addressPersonalInformationForm = new AddressPersonalInformationForm(driver);
        deliveryInformationForm = new DeliveryInformationForm(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillInMainPersonalInformation(String address, String postcode, String city){
        mainPersonalInformationForm.fillInPersonalInformationWithRandomData();
        addressPersonalInformationForm.fillInAddress(city, address, postcode);
        deliveryInformationForm.chooseTypeOfDelivery();
    }
}
