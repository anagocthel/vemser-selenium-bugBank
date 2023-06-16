package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ExtratoPage extends BasePage{
    public static final By extratoContainer = By.cssSelector("div[class^='bank-statement__Container']");
    public static final By saldo = By.cssSelector("p#textBalanceAvailable");
    public Boolean extratoContainer(){
        try{
            element(extratoContainer).isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public Integer saldoAtual(){
       return Integer.valueOf(element(saldo).getText().replaceAll("[\\D]", ""));
    }
}
