package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends BasePage{

    RegisterPage registerPage = new RegisterPage();
    private static final By email = By.cssSelector("input[name='email']");
    private static final By password = By.cssSelector("input[name='password']");
    private static final By acessButton = By.cssSelector("div.login__buttons button[type='submit']");
    private static final By registerButton = By.cssSelector("div.login__buttons button[type='button']");
    private static final By linkRequirements = By.cssSelector("div.login__link a");
    private static final By modalText = By.cssSelector("p#modalText");

    private static final By inputError = By.cssSelector("p.input__warging");

    public void logar(String emailText, String senhaText){
        preencherEmail(emailText);
        preencherSenha(senhaText);
        click(acessButton);
    }
    public void preencherEmail(String emailText){
        sendKeys(email,emailText);

    }
    public void preencherSenha(String senhaText){
        sendKeys(password,senhaText);

    }
    public void clicarBotaoLogar(){
        click(acessButton);
    }

    public void clicarNoBotaoIrParaRegistar(){
        click(registerButton);
    }
    public WebElement findModal(){
        return element(modalText);
    }
    public String findInputError(){
        return element(inputError).getText();
    }
    public List<String> findInputErrors(){
        return elements(inputError).stream()
                .map(mensagemErro-> mensagemErro.getText()).collect(Collectors.toList());
    }

    public void cadastrarELogar(String nome, String senhaLogin, String emailLogin) throws InterruptedException {
        clicarNoBotaoIrParaRegistar();
        registerPage.registarUsuarioSemSaldo(nome, senhaLogin, emailLogin);
        logar(emailLogin, senhaLogin);
        Thread.sleep(3000);
    }
    public void cadastrarELogarComSaldo(String nome, String senhaLogin, String emailLogin) throws InterruptedException {
        clicarNoBotaoIrParaRegistar();
        Thread.sleep(1000);
        registerPage.limparCadastro();
        Thread.sleep(1000);
        registerPage.registarUsuarioComSaldo(nome, senhaLogin, emailLogin);
        logar(emailLogin, senhaLogin);
        Thread.sleep(1000);
    }
    public void limparLogin(){
        clear(email);
        clear(password);
    }

}
