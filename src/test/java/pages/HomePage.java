package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class HomePage extends BasePage{
    private static final By logoutButton = By.cssSelector("a#btnExit");
    private static final By pagamentosLink = By.cssSelector("a#btn-PAGAMENTOS");
    private static final By transferenciaLink = By.cssSelector("a#btn-TRANSFERÊNCIA");
    private static final By extratoLink = By.cssSelector("a#btn-EXTRATO");
    private static final By saqueLink = By.cssSelector("a#btn-SAQUE");
    private static final By closeModal = By.cssSelector("a#btnCloseModal");
    private static final By modalText = By.cssSelector("p#modalText");

    public void pagametosLinkClick(){
        click(pagamentosLink);
    }
    public void saqueLinkClick(){
        click(saqueLink);
    }
    public void extratoLinkClick(){
        click(extratoLink);
    }
    public void transferenciaLinkClick(){
        click(transferenciaLink);
    }
    public void closeModalClick(){
        click(closeModal);
    }
    public String modalText(){
        return element(modalText).getText();
    }

    public Boolean verificarExibixaoBotaoSair(){
            try{
                element(logoutButton).isDisplayed();
                return true;
            }
            catch(NoSuchElementException e){
                return false;
            }
    }
}
