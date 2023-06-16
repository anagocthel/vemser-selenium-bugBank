package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.List;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void testLoginComUsuarioValido() throws InterruptedException {
        loginPage.cadastrarELogar("teste", "1234", "teste@teste.com");
        Boolean achouBotao = homePage.verificarExibixaoBotaoSair();
        Assert.assertTrue(achouBotao);
    }

    @Test
    public void testValidarMensagemDeErroLoginUsuarioNaoExistente() throws InterruptedException {
        loginPage.logar("teste@teste.com","1234");
        Thread.sleep(5000);
        String mensagemErro= loginPage.findModal().getText();
        Boolean achouBotao = homePage.verificarExibixaoBotaoSair();
        Assert.assertEquals(mensagemErro, "Usuário ou senha inválido.\n" +
                "Tente novamente ou verifique suas informações!");
    }

    @Test
    public void testValidarMensagemDeErroLoginUsuarioFormatoInvalido() throws InterruptedException {
        loginPage.logar("0","1234");
        Thread.sleep(3000);
        String mensagemErro= loginPage.findInputError();
        Assert.assertEquals(mensagemErro, "Formato inválido");
    }

    @Test
    public void testValidarMensagemDeErroLoginSenhaInvalida() throws InterruptedException {
        loginPage.clicarNoBotaoIrParaRegistar();
        registerPage.registarUsuarioSemSaldo("teste", "1234", "teste@teste.com");
        loginPage.logar("teste@teste.com", "senha");
        Thread.sleep(2000);
        String mensagemErro= loginPage.findModal().getText();

        Assert.assertEquals(mensagemErro, "Usuário ou senha inválido.\n" +
                "Tente novamente ou verifique suas informações!");
    }

    @Test
    public void testValidarMensagemDeErroLoginESenhaNulo() throws InterruptedException {
        loginPage.clicarBotaoLogar();
        Thread.sleep(1000);
        List<String> mensagensErro= loginPage.findInputErrors();

        Assert.assertEquals(mensagensErro.get(0), "É campo obrigatório");
        Assert.assertEquals(mensagensErro.get(1), "É campo obrigatório");
    }
    @Test
    public void testValidarMensagemDeErroSenhaNula() throws InterruptedException {
        loginPage.preencherEmail("teste@gmail.com");
        loginPage.clicarBotaoLogar();
        Thread.sleep(2000);
        List<String> mensagensErro= loginPage.findInputErrors();

        //Erro só na senha
        Assert.assertEquals(mensagensErro.get(1), "É campo obrigatório");
        Assert.assertEquals(mensagensErro.get(0), "");

    }

    @Test
    public void testValidarMensagemDeErroLoginNulo() throws InterruptedException {
        loginPage.preencherSenha("1234");
        loginPage.clicarBotaoLogar();
        Thread.sleep(2000);
        List<String> mensagensErro= loginPage.findInputErrors();

        //Erro só no login
        Assert.assertEquals(mensagensErro.get(0), "É campo obrigatório");
        Assert.assertEquals(mensagensErro.get(1), "");

    }


}
