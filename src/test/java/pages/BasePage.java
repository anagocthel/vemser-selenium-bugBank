package pages;

import org.openqa.selenium.By;
import utils.Elements;

public class BasePage extends Elements {

    public static void sendKeys(By by, String text){
        element(by).sendKeys(text);
    }

    public static void click(By by){
        element(by).click();
    }
    public static void clear(By by){
        element(by).clear();
    }
}
