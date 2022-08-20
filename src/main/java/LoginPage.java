import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseClass{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    public void NavigateToURL() {
        driver.navigate().to("https://example.testproject.io/web/");
    }

    By fullName = By.xpath("//input[@id='name']");
    By password = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//button[@id='login']");
    By message= By.xpath("//p[@id='greetings']");
    By invalidPsMessage= By.xpath("//div[text()='Password is invalid'] ");

    By invalidNameMessage= By.xpath("//small[text()='Hint: password is 12345']");


    public void Login(String user, String pass) {
        findElementWithWait(fullName).sendKeys(user);
        findElementWithWait(password).sendKeys(pass);
        findElementWithWait(loginBtn).click();
    }

    public String AssertMessage(){
        return findElementWithWait(message).getText();
    }

    public String AssertInvalidPs(){
        return findElementWithWait(invalidPsMessage).getText();
    }

    public String AssertName(){
        return findElementWithWait(invalidNameMessage).getText();
    }
    }

