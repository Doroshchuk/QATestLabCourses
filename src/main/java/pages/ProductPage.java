package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "form_step1_name_1")
    public WebElement productNameTF;

    @FindBy(id = "form_step6_reference")
    public WebElement productQuantityTF;

    @FindBy(id = "form_step1_price_shortcut")
    public WebElement productPriceWithoutNSD_TF;

    @FindBy(id = "form_step1_price_ttc_shortcut")
    public WebElement productPriceWithNSD_TF;

    @FindBy(id = "form_step1_price_ttc_shortcut")
    public WebElement productNetworkCheckbox;

    @FindBy(className = "growl-message")
    public WebElement networkMessageBlock;

    @FindBy(className = "growl-close")
    public WebElement closeNetworkMessageBtn;

    @FindBy(id = "dropdownMenu")
    public WebElement saveProductBtn;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void createNewProduct(){
        productNameTF.sendKeys(getRandomProductName(10));
        productQuantityTF.sendKeys(String.valueOf(getRandomProductQuantity()));
        productPriceWithoutNSD_TF.sendKeys(getRandomProductPrice());
        productNetworkCheckbox.click();
        wait.until(ExpectedConditions.visibilityOf(networkMessageBlock));
        closeNetworkMessageBtn.click();
        saveProductBtn.click();
        wait.until(ExpectedConditions.visibilityOf(networkMessageBlock));
        closeNetworkMessageBtn.click();
    }

    private String getRandomProductName(int length){
        Random random = new Random();
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase(Locale.ROOT);
        char[] symbols = (upper + lower).toCharArray();
        char[] buf = new char[length];
        return nextString(buf, random, symbols);
    }

    public String nextString(char[] buf, Random random, char[] symbols) {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    private int getRandomProductQuantity(){
        return (int)(Math.random() * 100 + 1);
    }

    private String getRandomProductPrice(){
        double result = 0.1 + (100 - 0.1) * new Random().nextDouble();
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(result);
    }
}
