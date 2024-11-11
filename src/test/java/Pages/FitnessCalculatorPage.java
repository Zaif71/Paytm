package Pages;

import BaseTest.Base;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
public class FitnessCalculatorPage extends Base {

    private final WebDriver driver;
    private WebDriverWait wait;

    public FitnessCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//a[text()='BMI Calculator']")
    private WebElement bmiLink;
    @FindBy(id="cage")
    private WebElement enterAge;
    @FindBy(id="cheightmeter")
    private WebElement enterHeight;
    @FindBy(id="ckg")
    private WebElement enterWeight;
    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateBtn;
    @FindBy(xpath = "//h2[text()='Result']")
    private WebElement result;
    @FindBy(xpath = "//a[text()='Body Fat Calculator']")
    private WebElement bodyFatCalculator;
    @FindBy(xpath = "//input[@name='cage']")
    private WebElement enterAge1;
    @FindBy(xpath = "//input[@name='cweightkgs']")
    private WebElement enterHeight1;
    @FindBy(xpath = "//input[@id='cheightmeter']")
    private WebElement enterWeight1;
    @FindBy(xpath = "//input[@id='cneckmeter']")
    private WebElement enterNeckSize;
    @FindBy(xpath = "//input[@id='cwaistmeter']")
    private WebElement enterWaistSize;
    @FindBy(xpath = "//input[@name='x']")
    private WebElement setClickOnSubmit;
    @FindBy(xpath = "//h2[normalize-space()='Result']")
    private WebElement resultDisplayed;

    @FindBy(xpath = "//a[text()='GPA Calculator']")
    private WebElement gradECalculatorBtn;
    @FindBy(xpath = "//input[@name='da4']")
    private WebElement subjectsTF;
    @FindBy(xpath = "//input[@name='ca4']")
    private WebElement subjectMarksTF;
    @FindBy(xpath = "//select[@name='la4']")
    private WebElement marksGradeDropDown;
    @FindBy(xpath = "(//input[@name='x'])[1]")
    private WebElement calculateMarksBtn;
    @FindBy(xpath = "//font[normalize-space()='Overall GPA']")
    private WebElement marksResult;






    public void clickBmiLink() {
   bmiLink.click();
    }

    public void setEnterAge(String age) {
        enterAge.clear();
        enterAge.sendKeys(age);
    }

    public void setEnterHeight(String height) {
        enterHeight.clear();
        enterHeight.sendKeys(height);
    }
    public void setEnterWeight(String weight) {
        enterWeight.clear();
        enterWeight.sendKeys(weight);
    }

    public void clickCalculateBtn() {
        calculateBtn.click();
        Assert.assertTrue("Result Graph is not visible ", wait.until(ExpectedConditions.visibilityOf(result)).isDisplayed());
        System.out.println("BMI result is calculated");
    }
    public void clickBodyFatCalculatorLink() throws InterruptedException {
        bodyFatCalculator.click();
        Thread.sleep(3000);
    }


    public void setEnterAge1(String age) {
        enterAge1.clear();
        enterAge1.sendKeys(age);
    }

    public void setEnterHeight1(String height) {
        enterHeight1.clear();
        enterHeight1.sendKeys(height);
    }
    public void setEnterWeight1(String weight) {
        enterWeight1.clear();
        enterWeight1.sendKeys(weight);
    }
    public void setEnterNeckSize(String neck) {
        enterNeckSize.clear();
        enterNeckSize.sendKeys(neck);
    }
    public void setEnterWaistSize(String waist) {
        enterWaistSize.clear();
        enterWaistSize.sendKeys(waist);

    }
    public void setSetClickOnSubmit(){
        setClickOnSubmit.click();

    }
    public boolean isResultDisplay() {
        wait.until(ExpectedConditions.visibilityOf(resultDisplayed));
        return resultDisplayed.isDisplayed();

    }
    public void setGradECalculatorBtn(){
        gradECalculatorBtn.click();

    }
    public void setSubjectsTF(String subjects){
        subjectsTF.sendKeys(subjects);

    }
    public void setSubjectMarksTF(String marks){
        subjectMarksTF.sendKeys(marks);
    }
    public void setMarksGradeDropDown() throws AWTException {
        marksGradeDropDown.click();
        Robot r2 = new Robot();
        r2.keyPress(KeyEvent.VK_DOWN);
        r2.keyRelease(KeyEvent.VK_DOWN);
        r2.keyPress(KeyEvent.VK_ENTER);
        r2.keyRelease(KeyEvent.VK_ENTER);

    }
    public void setClickCalculateMarksBtn(){
        calculateMarksBtn.click();

    }
    public boolean setMarksResultDisplayed(){

        wait.until(ExpectedConditions.visibilityOf(marksResult));
        return marksResult.isDisplayed();
    }



}

