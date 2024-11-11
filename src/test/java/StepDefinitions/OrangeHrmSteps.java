package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OrangeHrmSteps {

    private WebDriver driver;

    // Constructor or a setup method to initialize the WebDriver
    public OrangeHrmSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Given("the user is on the login page1")
    public void theUserIsOnTheLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters valid1 username {string} and password {string}")
    public void theUserEntersValidUsernameAndPassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);


        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("the user should be redirected to the homepage1")
    public void theUserShouldBeRedirectedToTheHomepage() {
        // Wait for the homepage to load and verify the URL
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", "User is not redirected to the homepage");
    }

    @Then("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        // Use dynamic XPath to find and click the button based on its name
        String xpath = String.format("//span[text()='%s']//ancestor::button", buttonName);
        driver.findElement(By.xpath(xpath)).click();
    }

    @Then("the user verifies the URL for {string} button is {string}")
    public void theUserVerifiesTheUrlForButton(String buttonName, String expectedUrl) {
        // Wait until the URL changes to the expected URL
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));

        // Validate the current URL
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch after clicking '" + buttonName + "'");
    }
}
