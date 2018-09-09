package testHelper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Random;

public class TestHelper {
    public static void clickOnElementUsingJS(WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void moveToElement(WebDriver driver, WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public static void insertValueIntoTF(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }

    public static String getRandomString (int length){
        Random random = new Random();
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase(Locale.ROOT);
        char[] symbols = (upper + lower).toCharArray();
        char[] buf = new char[length];
        return nextString(buf, random, symbols);
    }

    public static String nextString(char[] buf, Random random, char[] symbols) {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    public static int getRandomIntNumber(){
        return (int)(Math.random() * 100 + 1);
    }

    public static int getRandomIntNumber(int minRange, int maxRange){
        return (int)(Math.random() * maxRange + minRange);
    }

    public static double getRandomDoubleNumber(){
        double result = 0.1 + (100 - 0.1) * new Random().nextDouble();
        BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_EVEN);
        return bd.doubleValue();
    }
}
