package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ExtratoPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TransferenciaPage;

public class HomeTest extends BaseTest{

    HomePage homePage = new HomePage();
    LoginPage loginPage=new LoginPage();

    ExtratoPage extratoPage = new ExtratoPage();

    TransferenciaPage transferenciaPage = new TransferenciaPage();

    @BeforeMethod
    public void logar() throws InterruptedException {
        loginPage.cadastrarELogar("Teste", "teste", "teste@teste.com");
    }

    @Test
    public void testVerificarMensagemLinkPagamentos() throws InterruptedException {
        homePage.pagametosLinkClick();

        Thread.sleep(3000);
        String mensagem = homePage.modalText();
        Assert.assertEquals(mensagem,"Funcionalidade em desenvolvimento");
    }
    @Test
    public void testVerificarMensagemLinkSaque() throws InterruptedException {
        homePage.saqueLinkClick();

        Thread.sleep(3000);
        String mensagem = homePage.modalText();
        Assert.assertEquals(mensagem,"Funcionalidade em desenvolvimento");
    }

    @Test
    public void testVerificarSeAbreLinkTransferencia() throws InterruptedException {
        homePage.transferenciaLinkClick();
        Assert.assertTrue(transferenciaPage.transferenciaContainer());
    }

    @Test
    public void testVerificarSeAbreLinkExtrato() throws InterruptedException {
        homePage.extratoLinkClick();
        Assert.assertTrue(extratoPage.extratoContainer());
    }


}