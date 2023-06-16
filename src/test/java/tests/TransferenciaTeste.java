package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TransferenciaTeste extends BaseTest{

    LoginPage loginPage = new LoginPage();
    ExtratoPage extratoPage = new ExtratoPage();
    HomePage homePage = new HomePage();
    TransferenciaPage transferenciaPage = new TransferenciaPage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void testTransferenciaValida() throws InterruptedException {
        loginPage.clicarNoBotaoIrParaRegistar();
        String conta = registerPage.registarUsuarioGetConta("TesteSaldo", "1234", "teste@teste.com");
        registerPage.closeModal();
        Thread.sleep(3000);
        loginPage.cadastrarELogarComSaldo("TesteTransferencia", "1234", "teste@transferencia.com");
        homePage.transferenciaLinkClick();
        transferenciaPage.realizarTransferencia(conta, "100", "transferencia");
        Thread.sleep(1000);
        String texto= transferenciaPage.modalText();
        Assert.assertEquals(texto, "Transferencia realizada com sucesso");

    }
    @Test
    public void testTransferenciaContaInvalida() throws InterruptedException {
        loginPage.cadastrarELogarComSaldo("TesteTransferencia", "1234", "teste@transferencia.com");
        homePage.transferenciaLinkClick();
        transferenciaPage.realizarTransferencia("1234", "100", "transferencia");
        Thread.sleep(1000);
        String texto= transferenciaPage.modalText();
        Assert.assertEquals(texto, "Conta inválida ou inexistente");
    }
    @Test
    public void testTransferenciaComSaldoInsuficiente() throws InterruptedException {
        loginPage.clicarNoBotaoIrParaRegistar();
        String conta = registerPage.registarUsuarioGetConta("TesteSaldo", "1234", "teste@teste.com");
        registerPage.closeModal();
        Thread.sleep(3000);
        loginPage.cadastrarELogarComSaldo("TesteTransferencia", "1234", "teste@transferencia.com");
        homePage.transferenciaLinkClick();
        transferenciaPage.realizarTransferencia(conta, "10000", "transferencia");
        Thread.sleep(1000);
        String texto= transferenciaPage.modalText();
        Assert.assertEquals(texto, "Você não tem saldo suficiente para essa transação");
    }

}
