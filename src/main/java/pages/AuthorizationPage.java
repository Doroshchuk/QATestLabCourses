package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailTF;

    @FindBy(xpath = "//input[@name='passwd']")
    public WebElement passwordTF;

    @FindBy(xpath = "//button[@name='submitLogin']")
    public WebElement logInBtn;

    @FindBy(xpath = "//input[@id='stay_logged_in']")
    public WebElement rememberMeCheckbox;

    @FindBy(xpath = "//h4[@id='shop_name']")
    public WebElement title;

    public AuthorizationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void inputDataIntoTextField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void signInToAccount(String email, String password){
        inputDataIntoTextField(emailTF, email);
        inputDataIntoTextField(passwordTF, password);
        logInBtn.click();
    }

    public void signInToAccountAndRememberData(String email, String password){
        inputDataIntoTextField(emailTF, email);
        inputDataIntoTextField(passwordTF, password);
        rememberMeCheckbox.click();
        logInBtn.click();
    }
}
