package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public class BaseTest extends Browser {

    @BeforeMethod
    public void abrirNavegador(){
        browserUp("https://bugbank.netlify.app/");
    }

    @AfterMethod
    public void fecharNavegador(){
        browserDown();
    }
}
