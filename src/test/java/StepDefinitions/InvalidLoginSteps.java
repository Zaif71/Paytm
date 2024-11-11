package StepDefinitions;

import Pages.InvalidLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InvalidLoginSteps {
    public WebDriver driver;
    public InvalidLoginPage invalidLoginPage;
    String actualErrorMessage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {

         System.setProperty("webdriver.chrome.driver","C:\\Users\\zaffar\\paytm\\Drivers\\chromedriver.exe");
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         invalidLoginPage=new InvalidLoginPage(driver);
         invalidLoginPage.navigateToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");




     }



    @When("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        invalidLoginPage=new InvalidLoginPage(driver);
         actualErrorMessage = invalidLoginPage.login(username, password);
    }


    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        driver.quit();
    }




}
