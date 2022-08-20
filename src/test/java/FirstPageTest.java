import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FirstPageTest extends BaseTestClass {


    @Test
    public void NameAndPass(){
        FirstPage page= new FirstPage(driver, wait);
        page.NavigateToFirstPage();
        page.EnterName("Trayana");
        page.EnterPass("12345");
        page.ClickLogin();
        WebElement Greetings= driver.findElement(By.xpath("//p[@id='greetings']"));

        String expect= "Hello Trayana, let's complete the test form:";
        String actual= Greetings.getText();

        Assert.assertEquals(expect, actual);


    }

    @Test
    public void TestSecondPageWithSave() {

        FirstPage page = new FirstPage(driver, wait);
        page.NavigateToFirstPage();
        page.EnterName("Trayana");
        page.EnterPass("12345");
        page.ClickLogin();
        page.EnterCountry();
        page.EnterAddress("Sofia, Mladost2");
        page.EnterEmail("trayana_r@abv.bg");
        page.EnterPhone("0885219119");
        page.SaveBtn();

        WebElement Saved= driver.findElement(By.xpath("//span[@class='tp-saved']"));

        String ExpectSave= "Saved";
        String ActualSave= Saved.getText();
        Assert.assertEquals(ExpectSave, ActualSave);
    }

    @Test
    public void TestSecondPageWithLogout() {

        FirstPage page = new FirstPage(driver, wait);
        page.NavigateToFirstPage();
        page.EnterName("Trayana");
        page.EnterPass("12345");
        page.ClickLogin();
        page.EnterCountry();
        page.EnterAddress("Sofia, Mladost2");
        page.EnterEmail("trayana_r@abv.bg");
        page.EnterPhone("0885219119");
        page.Logout();

        WebElement LoggedOut = driver.findElement(By.xpath("//button[@id='login']"));

        String ExpectLogout = "Login";
        String ActualLogout = LoggedOut.getText();
        Assert.assertEquals(ExpectLogout, ActualLogout);
    }

    @ParameterizedTest
    @CsvSource({"Trayana,12345,Hello Trayana, let's complete the test form:",
                "tr,12345,Hello tr, let's complete the test form:"})
    public void CorrectCredentials(String username, String password, String expectedMessage){
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);


        Assert.assertEquals(expectedMessage, login.AssertMessage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/tr.csv")
    public void CorrectCredentialsFile(String username, String password, String expectedMessage){
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);


        Assert.assertEquals(expectedMessage, login.AssertMessage());
    }

    @ParameterizedTest
    @CsvSource({"Trayana,1234,Password is invalid",
            "tr,1234,Password is invalid"})

    public void InvalidPass(String username, String password, String invalidPs){
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);


        Assert.assertEquals(invalidPs, login.AssertInvalidPs());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalid.csv")

    public void InvalidPassFile(String username, String password, String invalidPs){
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);


        Assert.assertEquals(invalidPs, login.AssertInvalidPs());
    }

    @ParameterizedTest
    @CsvSource({"'' ,12345,Hint: password is 12345",
            "'',12345,Hint: password is 12345"})

    public void InvalidName(String username, String password, String nameMess){
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);


        Assert.assertEquals(nameMess, login.AssertName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalidname.csv")

    public void InvalidNameFile(String username, String password, String invalidName){
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);


        Assert.assertEquals(invalidName, login.AssertName());
    }

}
