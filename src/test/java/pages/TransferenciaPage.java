package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class TransferenciaPage extends BasePage {
    private static final By transferenciaContainer = By.cssSelector("div[class^='transfer__Container'");
    private static final By numeroConta = By.cssSelector("input[name='accountNumber']");
    private static final By digito = By.cssSelector("input[name='digit']");
    private static final By valorTransferencia = By.cssSelector("input[name='transferValue']");
    private static final By descricao = By.cssSelector("input[name='description']");
    private static final By transferirButton = By.cssSelector("form.styles__ContainerFormTransfer-sc-1oow0wh-0.hehMDu button[type='submit']");
    private static final By modalText = By.cssSelector("p#modalText");
    private static final By closeModalButton = By.cssSelector("a#btnCloseModal");


    public String modalText(){
        return element(modalText).getText();
    }

    public void closeModalButton(){
         click(closeModalButton);
    }
    public Boolean transferenciaContainer(){
        try{
            element(transferenciaContainer).isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public String ultimoDigito(String numeroContaEDigito){
        String ultimoDigito  = String.valueOf(numeroContaEDigito.charAt(numeroContaEDigito .length()-1));
        return ultimoDigito;
    }

    public String contaSemUltimoDigito(String numeroContaEDigito){
        String contaSemUltimoDigito = numeroContaEDigito.substring(0, numeroContaEDigito.length()-1);
        return contaSemUltimoDigito;
    }

    public void realizarTransferencia (String numeroContaEDigito, String valor, String desc){
        sendKeys(digito,ultimoDigito(numeroContaEDigito));
        sendKeys(numeroConta,contaSemUltimoDigito(numeroContaEDigito));
        sendKeys(valorTransferencia, valor);
        sendKeys(descricao,desc);
        click(transferirButton);
    }
}
