package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testHelper.TestHelper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "form_step1_name_1")
    public WebElement productNameTF;

    @FindBy(id = "form_step1_qty_0_shortcut")
    public WebElement productQuantityTF;

    @FindBy(id = "form_step1_price_shortcut")
    public WebElement productPriceWithoutNSD_TF;

    @FindBy(id = "form_step1_price_ttc_shortcut")
    public WebElement productPriceWithNSD_TF;

    @FindBy(xpath = "//div[input[@id='form_step1_active']]")
    public WebElement productNetworkCheckbox;

    @FindBy(className = "growl-message")
    public WebElement networkMessageBlock;

    @FindBy(className = "growl-close")
    public WebElement closeNetworkMessageBtn;

    @FindBy(xpath = "//button[@class='btn btn-primary js-btn-save' and @type = 'submit']")
    public WebElement saveProductBtn;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public Product createNewProduct(){
        Product product = new Product();
        product.setName(getRandomProductName(10));
        product.setPrice(getRandomProductPrice());
        product.setQuantity(getRandomProductQuantity());
        productNameTF.sendKeys(product.getName());
        TestHelper.insertValueIntoTF(productQuantityTF, String.valueOf(product.getQuantity()));
        TestHelper.insertValueIntoTF(productPriceWithoutNSD_TF, String.valueOf(product.getPrice()));
        productNetworkCheckbox.click();
        wait.until(ExpectedConditions.visibilityOf(networkMessageBlock));
        closeNetworkMessageBtn.click();
        saveProductBtn.click();
        wait.until(ExpectedConditions.visibilityOf(networkMessageBlock));
        closeNetworkMessageBtn.click();
        return product;
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

    private double getRandomProductPrice(){
        double result = 0.1 + (100 - 0.1) * new Random().nextDouble();
//        DecimalFormat f = new DecimalFormat("##.00");
//        String formattedResult = f.format(result);
        BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_EVEN);
        return bd.doubleValue();
    }
}