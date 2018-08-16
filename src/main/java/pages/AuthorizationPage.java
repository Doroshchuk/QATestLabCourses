package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage {
    private WebDriver driver;

    @FindBy(xpath="//form[@id='login_form']//div[@class='form-group']//input[@name='email']")
    public WebElement emailTF;

    @FindBy(xpath="//form[@id='login_form']//div[@class='form-group']//input[@name='passwd']")
    public WebElement passwordTF;

    private void inputDataIntoTextField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void signInToAccount(String email, String password){
        inputDataIntoTextField(emailTF, email);
        inputDataIntoTextField(passwordTF, password);
    }
}
