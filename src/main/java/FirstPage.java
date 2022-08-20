import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstPage extends BaseClass {


    public FirstPage(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    public void NavigateToFirstPage() {
        driver.navigate().to("https://example.testproject.io/web/");
    }

    By fullName = By.xpath("//input[@id='name']");
    By pass = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//button[@id='login']");




    public void EnterName(String enterName) {
        Wait().until(ExpectedConditions.presenceOfElementLocated(fullName)).sendKeys(enterName);
    }

    public void EnterPass(String enterPass) {
        Wait().until(ExpectedConditions.presenceOfElementLocated(pass)).sendKeys(enterPass);
    }

    public void ClickLogin() {
        Wait().until(ExpectedConditions.presenceOfElementLocated(loginBtn)).click();
    }

//Below is info for second page
    By address= By.xpath("//input[@id='address']");
    By email= By.xpath("//input[@id='email']");
    By phone= By.xpath("//input[@id='phone']");
    By saveBtn= By.xpath("//button[@id='save']");
    By logoutBtn= By.xpath("//button[@id='logout']");

     public void EnterCountry(){
         Select se= new Select(driver.findElement(By.xpath("//select[@id='country']")));
     se.selectByValue("AF");
     }

    public void EnterAddress(String enterAddress){
        Wait().until(ExpectedConditions.presenceOfElementLocated(address)).sendKeys(enterAddress);}

    public void EnterEmail(String enterEmail){
        Wait().until(ExpectedConditions.presenceOfElementLocated(email)).sendKeys(enterEmail);}

    public void EnterPhone(String enterPhone){
        Wait().until(ExpectedConditions.presenceOfElementLocated(phone)).sendKeys(enterPhone);

    }
    public void SaveBtn(){
        driver.findElement(saveBtn).click();
    }

    public void Logout(){
         driver.findElement(logoutBtn).click();
    }
}


