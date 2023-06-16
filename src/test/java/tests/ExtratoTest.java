package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExtratoPage;
import pages.HomePage;
import pages.LoginPage;

public class ExtratoTest extends BaseTest{

    LoginPage loginPage = new LoginPage();
    ExtratoPage extratoPage = new ExtratoPage();
    HomePage homePage = new HomePage();
    @Test
    public void testeValidarSaldoUsuarioCadastrado() throws InterruptedException {
        loginPage.cadastrarELogarComSaldo("TesteSaldo", "1234", "teste@teste.com");
        homePage.extratoLinkClick();
        Integer saldo = extratoPage.saldoAtual();

        Assert.assertEquals(saldo, 100000);
    }



}
