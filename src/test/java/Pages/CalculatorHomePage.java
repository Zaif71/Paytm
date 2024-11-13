package Pages;

import BaseTest.Base;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CalculatorHomePage extends Base {
    private final WebDriver driver;
    private WebDriverWait wait;

    public CalculatorHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateButton;

    @FindBy(id = "chouseprice")
    private WebElement enterLoanAmountTF;

    @FindBy(id = "cdownpayment")
    private WebElement enterDownPaymentTF;

    @FindBy(id = "cloanterm")
    private WebElement enterLoanTermTF;

    @FindBy(id = "cinterestrate")
    private WebElement enterLoanInterestRateTF;
    @FindBy(xpath = "//*[name()='path' and contains(@d,'M 58.5 8 A')]")
    private WebElement resultGraph;
    @FindBy(xpath = "//font[contains(text(), 'Please provide a positive home price value')]")
    private WebElement error1;
    @FindBy(xpath = "//a[@class='topNavOn']")
    private WebElement financialLink;
    @FindBy(xpath = "//h1[text()='Financial Calculators']")
    private WebElement financialLinkLogo;
    @FindBy(xpath = "//a[text()='Fitness & Health']")
    private WebElement fitnessHealthLink;
    @FindBy(xpath = "//h1[normalize-space()='Fitness and Health Calculators']")
    private WebElement fitnessHealthLinkLogo;
    @FindBy(xpath = "//div[@class='topNavAbs']//a[normalize-space()='Math']")
    private WebElement mathCalculatorLink;
    @FindBy(xpath = "//h1[normalize-space()='Math Calculators']")
    private WebElement mathCalculatorLinkLogo;
    @FindBy(xpath = "//div[@class='topNavAbs']//a[normalize-space()='Other']")
    private WebElement OtherCalculatorLink;
    @FindBy(xpath = "//h1[normalize-space()='Other Calculators']")
    private WebElement OtherCalculatorLinkLogo;
    @FindBy(xpath = "//a[text()='Heat Index Calculator']")
    private WebElement heatIndexCalculatorLink;
    @FindBy(xpath = "//input[@name='airtemperature']")
    private WebElement airTemperature;
    @FindBy(xpath = "//input[@name='humidity']")
    private WebElement humidity;
    @FindBy(xpath = "//a[text()='Percentage Calculator']")
    private WebElement percentageBtn;
    @FindBy(id = "cpar1")
    private WebElement percentageTF;
    @FindBy(id = "cpar2")
    private WebElement numTF;
    @FindBy(xpath = "(//input[@name='x'])[1]")
    private WebElement clickResultPercentage;
    @FindBy(xpath = "//h2[contains(text(), 'Result')]")
    private WebElement resultPercentage;


    public void enterLoanAmount(String loanAmount) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(enterLoanAmountTF));
        enterLoanAmountTF.clear();
        enterLoanAmountTF.sendKeys(loanAmount);
    }

    public void setEnterDownPayment(String downPayment) {
        wait.until(ExpectedConditions.elementToBeClickable(enterDownPaymentTF));
        enterDownPaymentTF.clear();
        enterDownPaymentTF.sendKeys(downPayment);
    }

    public void setEnterLoanTermTF(String loanTerm) {
        wait.until(ExpectedConditions.elementToBeClickable(enterLoanTermTF));
        enterLoanTermTF.clear();
        enterLoanTermTF.sendKeys(loanTerm);
    }

    public void setEnterLoanInterestRateTF(String interestRate) {
        wait.until(ExpectedConditions.elementToBeClickable(enterLoanInterestRateTF));
        enterLoanInterestRateTF.clear();
        enterLoanInterestRateTF.sendKeys(interestRate);
    }

    public void clickOnCalculateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(calculateButton));
        calculateButton.click();
    }

    public boolean isResultDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(resultGraph));
        return resultGraph.isDisplayed();
    }

    public void setError1(String errorMessage) {
        wait.until(ExpectedConditions.elementToBeClickable(error1));
        Assert.assertTrue("Error message", wait.until(ExpectedConditions.visibilityOf(error1)).isDisplayed());
        String error1Text = error1.getText();
        if (error1Text.equals(errorMessage)) {
            System.out.println("error message is displayed" + error1Text);
        }
    }

    public void clickOnFinancialLink() throws InterruptedException {
        financialLink.click();
        Assert.assertTrue("Financial logo is not displayed", wait.until(ExpectedConditions.visibilityOf(financialLinkLogo)).isDisplayed());
        System.out.println("financial logo page is displayed");

    }

    public void clickOnFitnessLink() throws InterruptedException {
        fitnessHealthLink.click();
        Assert.assertTrue("Financial logo is not displayed", wait.until(ExpectedConditions.visibilityOf(fitnessHealthLinkLogo)).isDisplayed());
        System.out.println("fitness health calculator page is displayed");
    }

    public void clickOnMathCalculatorLink() throws InterruptedException {
        mathCalculatorLink.click();
        Assert.assertTrue("Financial logo is not displayed", wait.until(ExpectedConditions.visibilityOf(mathCalculatorLinkLogo)).isDisplayed());
        System.out.println("math calculator page is displayed");
    }

    public void OtherCalculator() throws InterruptedException {
        OtherCalculatorLink.click();
        Assert.assertTrue("Financial logo is not displayed", wait.until(ExpectedConditions.visibilityOf(OtherCalculatorLinkLogo)).isDisplayed());
        System.out.println("Other calculator page is displayed");
    }

    public void setHeatIndexCalculatorLink() {
        heatIndexCalculatorLink.click();
    }

    public void setEnterAirTemp(String temperature) {
        airTemperature.clear();
        airTemperature.sendKeys(temperature);
    }

    public void setEnterHumidity(String humidity) {
        airTemperature.clear();
        airTemperature.sendKeys(humidity);
    }

    public void setPercentageBtn() {
        percentageBtn.click();

    }

    public void setPercentageTF(String percentage) {
        percentageTF.sendKeys(percentage);

    }

    public void setNumTF(String number) {
        numTF.sendKeys(number);


    }

    public void setClickResultPercentage() {
        clickResultPercentage.click();

    }

    public boolean setResultPercentage() {
        wait.until(ExpectedConditions.visibilityOf(resultPercentage));
        return resultPercentage.isDisplayed();

    }

    public void setMultipleExecution(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists(String.class);
        for (List<String> row:data) {
            String value1 = row.get(0);
            String value2 = row.get(1);
            enterLoanAmountTF.clear();
            enterLoanAmountTF.sendKeys(value1);
            enterDownPaymentTF.clear();
            enterDownPaymentTF.sendKeys(value2);

        }


    }
}