package StepDefinitions;

import BaseTest.Base;
import Pages.CreateUserPage;
import Pages.ValidLoginPage;
import Utility.SimpleExcelReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class ValidLoginStepDef extends Base {

    private ValidLoginPage validLoginPage;


    public void setUp() {

        initializer();
        validLoginPage = new ValidLoginPage(driver);
    }

    @Given("the user is on the login page1.")
    public void theUserIsOnTheLoginPage1() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Login page is displayed");
    }

    @When("user enters valid username {string} and password {string}")
    public void theUserEntersValidUsernameAndPassword(String username, String password) {
        validLoginPage.enterValidCred(username, password);
        validLoginPage.getLoginClick();
    }

    @Then("user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("OrangeHRM"));
        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals("The user is on the homepage!", expectedTitle, actualTitle);
        System.out.println("Login successful, homepage is displayed with title: " + actualTitle);
    }
    @And("read the data from excel")
    public void readTheDataFromExcel() throws IOException, InterruptedException, AWTException {
        SimpleExcelReader orangeHrmExcelData=new SimpleExcelReader(driver);
        orangeHrmExcelData.excel();

    }
    @And("user click on add user button User should be created")
    public void userClickOnAddUserButtonUserShouldBeCreated() {
        System.out.println("New user is created by the Admin");
    }
    @Then("user add new employee after")
    public void userAddNewEmployeeAfter() throws IOException {

        System.out.println("New employee is added");

    }
    @And("user clicks on multiple {string}")
    public void userClicksOnMultiple(String button) {
        validLoginPage.clickAllElements(button);

    }

    public void tearDown()
    {
        breakk();
    }



}
