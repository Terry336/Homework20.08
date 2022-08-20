import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class BaseTestClass {
    public WebDriver driver;
    public WebDriverWait wait;

    public Action action;

    @BeforeEach
    public void Setup(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterEach
    public void AfterTest(){
        driver.quit();
    }

}
