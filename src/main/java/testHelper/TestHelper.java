package testHelper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestHelper {
    public static void ClickOnElementUsingJS(WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void insertValueIntoTF(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }
}
