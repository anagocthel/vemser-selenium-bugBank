package pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage{
    private static final By emailRegister = By.cssSelector("div.card__register input[name='email']");
    private static final By passwordRegister = By.cssSelector("div.card__register input[name='password']");
    private static final By nameRegister = By.cssSelector("div.card__register input[name='name']");
    private static final By passwordConfirmation = By.cssSelector("div.card__register input[name='passwordConfirmation']");
    private static final By submitRegister = By.cssSelector("div.card__register button[type='submit']");
    private static final By closeModal = By.cssSelector("a#btnCloseModal");
    private static final By modalText = By.cssSelector("p#modalText");

    private static final By ativarSaldo = By.cssSelector("label.styles__Container-sc-1pngcbh-0.kIwoPV label#toggleAddBalance");

    private static final By desativarSaldo = By.cssSelector("label.styles__Container-sc-1pngcbh-0.hsmFIT label#toggleAddBalance");

    public String modalText(){
       return element(modalText).getText();
    }
    public void registarUsuarioSemSaldo(String name, String password, String email) throws InterruptedException {
        sendKeys(emailRegister, email);
        sendKeys(nameRegister,name);
        sendKeys(passwordRegister,password);
        sendKeys(passwordConfirmation,password);
        click(submitRegister);
        Thread.sleep(2000);
        click(closeModal);
    }
    public void registarUsuarioComSaldo(String name, String password, String email) throws InterruptedException {
        sendKeys(emailRegister, email);
        sendKeys(nameRegister,name);
        sendKeys(passwordRegister,password);
        sendKeys(passwordConfirmation,password);
        click(ativarSaldo);
        click(submitRegister);
        Thread.sleep(2000);
        click(closeModal);
    }

    public void limparCadastro(){
        clear(passwordRegister);
        clear(passwordConfirmation);
        clear(emailRegister);
        clear(nameRegister);
    }
    public String registarUsuarioGetConta(String name, String password, String email) throws InterruptedException {
        sendKeys(emailRegister, email);
        sendKeys(nameRegister,name);
        sendKeys(passwordRegister,password);
        sendKeys(passwordConfirmation,password);
        click(submitRegister);
        Thread.sleep(2000);
        String text = element(modalText).getText();
        return text.replaceAll("[\\D]", "");
    }
    public void closeModal(){
        click(closeModal);
    }

}
