package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//Aqui vai ter todas as configurações para abrir o navegador
public class Browser {

    public static WebDriver driver;

    //abrir o navegador no link informado
    public void browserUp(String url){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    //fechar o browser
    public void browserDown(){
        driver.quit();
    }
}
