package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class RegisterTest extends BaseTest{

    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    TransferenciaPage transferenciaPage = new TransferenciaPage();

    @Test
    public void testeCadastroUsuarioValidoComSaldo() throws InterruptedException {
        loginPage.clicarNoBotaoIrParaRegistar();
        String conta = registerPage.registarUsuarioGetConta("teste", "1234", "teste@teste.com");

        String mensagem = registerPage.modalText();
        Assert.assertEquals(mensagem, "A conta "
                +transferenciaPage.contaSemUltimoDigito(conta)+"-"
                +transferenciaPage.ultimoDigito(conta)+" foi criada com sucesso");
    }

}
