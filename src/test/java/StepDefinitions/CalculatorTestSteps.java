package StepDefinitions;

import BaseTest.Base;
import Pages.CalculatorHomePage;
import Pages.FitnessCalculatorPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CalculatorTestSteps extends Base {

    CalculatorHomePage calculatorHomePage;
    FitnessCalculatorPage fitnessCalculatorPage;
    @Before
    public void setUp() {
        initializer();
        calculatorHomePage=new CalculatorHomePage(driver);
        fitnessCalculatorPage=new FitnessCalculatorPage(driver);
    }
    @Given("the user is on homepage")
    public void theUserIsOnHomepage() {
        String expectedTitle="Mortgage Calculator";
        String actualTitle= driver.getTitle();
        Assert.assertEquals("Title not matched", actualTitle, expectedTitle);
        System.out.println("homepage is displayed");
    }
    @When("user enter some required data loan amount{string}")
    public void userEnterSomeRequiredDataLoanAmount(String loanAmount) throws InterruptedException {
        Thread.sleep(10000);
        calculatorHomePage.enterLoanAmount(loanAmount);
        System.out.println("homepage is displayed");

    }


    @And("user enter valid downPayment in % {string}")
    public void userEnterValidDownPaymentIn(String downPayment) throws InterruptedException {
        calculatorHomePage.setEnterDownPayment(downPayment);

    }
    @And("user enter valid loan term{string}")
    public void userEnterValidLoanTerm(String loanTerm) throws InterruptedException {
        calculatorHomePage.setEnterLoanTermTF(loanTerm);
    }
    @And("user enter valid interest rate in %{string}")
    public void userEnterValidInterestRateIn(String interestRate) throws InterruptedException {
        calculatorHomePage.setEnterLoanInterestRateTF(interestRate);
    }

    @And("click on calculate button")
    public void clickOnCalculateButton() throws InterruptedException {

        calculatorHomePage.clickOnCalculateButton();
        System.out.println("Button is clicked");
    }

    @Then("calculated result should be shown")
    public void calculatedResultShouldBeShown() {
        Assert.assertTrue(calculatorHomePage.isResultDisplayed());
        System.out.println("calculated Result graph is shown");

    }

    @Then("error message should be display {string}")
    public void errorMessageShouldBeDisplay(String errorMessage) {
        calculatorHomePage.setError1(errorMessage);

    }

    @When("user click on financial link financial calculator page should displayed")
    public void userClickOnFinanacialLink() throws InterruptedException {
        calculatorHomePage.clickOnFinancialLink();

    }
    @Then("user click on fitness link fitness calculator page should displayed")
    public void userClickOnLinkFitnessCalculatorPageShouldDisplayed() throws InterruptedException {
        calculatorHomePage.clickOnFitnessLink();
    }

    @And("user click on math link math calculator page should displayed")
    public void userClickOnMathLinkMathCalculatorPageShouldDisplayed() throws InterruptedException {
        calculatorHomePage.clickOnMathCalculatorLink();
    }
    @And("user click on others calculator link page should open")
    public void userClickOnOthersCalculatorLinkPageShouldOpen() throws InterruptedException {
        calculatorHomePage.OtherCalculator();
    }


    @And("user click on BMI link calculator")
    public void userClickOnBMILinkCalculator() {
        fitnessCalculatorPage.clickBmiLink();


    }

    @When("user enter valid age{string}")
    public void userEnterValidAge(String age) {
        fitnessCalculatorPage.setEnterAge(age);
    }

    @And("user enter valid height {string}")
    public void userEnterValidHeight(String height) {
        fitnessCalculatorPage.setEnterHeight(height);
    }

    @And("user enter valid weight {string}")
    public void userEnterValidWeight(String weight)
    {
        fitnessCalculatorPage.setEnterWeight(weight);
    }

    @Then("calculated BMI result graph should displayed")
    public void calculatedBMIResultGraphShouldDisplayed()
    {
        fitnessCalculatorPage.clickCalculateBtn();
    }



    @And("user click on body fat percentage calculator")
    public void userClickOnBodyFatPercentageCalculator() throws InterruptedException {
        fitnessCalculatorPage.clickBodyFatCalculatorLink();
    }

    @Then("user enter require valid age data {string}")
    public void userEnterRequireValidAgeData(String age) {
        fitnessCalculatorPage.setEnterAge1(age);
    }

    @And("user enter height \\(cm) {string}")
    public void userEnterHeightCm(String height) {
        fitnessCalculatorPage.setEnterHeight1(height);
    }

    @And("user enter weight\\(kg) {string}")
    public void userEnterWeightKg(String weight) {
        fitnessCalculatorPage.setEnterWeight1(weight);
    }

    @Then("user enter waistSize\\(cm) {string}")
    public void userEnterWaistSizeCm(String waist) {
        fitnessCalculatorPage.setEnterWaistSize(waist);
    }

    @And("user enter neckSize\\(cm) {string}")
    public void userEnterNeckSizeCm(String neck) {
        fitnessCalculatorPage.setEnterNeckSize(neck);
    }

    @Then("click on calculate")
    public void clickOnCalculate() {
        fitnessCalculatorPage.setSetClickOnSubmit();


    }
    @And("verify that result is displayed")
    public void verifyThatResultIsDisplayed() {
        Assert.assertTrue(fitnessCalculatorPage.isResultDisplay());
        System.out.println("Body fat percentage result graph is shown");


    }
    @Then("user click on temperature calculator")
    public void userClickOnTemperatureCalculator() {
        calculatorHomePage.setHeatIndexCalculatorLink();
    }

    @And("enter air temperature {string}")
    public void enterAirTemperature(String temperature) {
        calculatorHomePage.setEnterAirTemp(temperature);
    }

    @And("enter humidity {string}")
    public void enterHumidity(String humidity) {
        calculatorHomePage.setEnterHumidity(humidity);

    }
    @After
    public void tearDown()
    {
        breakk();

    }



}

