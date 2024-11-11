package Pages;

import BaseTest.Base;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class ValidLoginPage extends Base {
    private final WebDriverWait wait;
    private static final String path = "C:\\Users\\zaffar\\paytm\\src\\test\\TestData\\OrangeHrm2.xlsx";


    public ValidLoginPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    // Locators
    private final By emailField = By.xpath("//input[@name='username']");
    private final By pwd = By.xpath("//input[@type='password']");
    private final By loginClick = By.xpath("//button[@type='submit']");
    private final By addUserButton = By.xpath("//button[normalize-space()='Add']");
    private final By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By userNam = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]");
    private final By confirmPwd = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]");
    private final By enterPwddd = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]");
    private final By selectUsr = By.xpath("(//div[@class='oxd-select-text--after'])[1]");
    private final By selectStatus = By.xpath("(//div[@class='oxd-select-text--after'])[2]");
    private final By clickOnSubmit = By.xpath("//button[@type='submit']");

    // Enter valid credentials and log in
    public void enterValidCred(String username, String password) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.clear();
        emailElement.sendKeys(username);

        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pwd));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void getLoginClick() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginClick));
        loginButton.click();

    }



    public void clickAllElements(String button) {
        String xpath = "//span[text()='" + button + "']";

            WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            buttonElement.click();
            wait.until(ExpectedConditions.stalenessOf(buttonElement));
            System.out.println("Clicked on button: " + button);
        {
            System.err.println("Unable to click button: " + button + " - " );

        }


    }

    public void getClickAddUserButton() throws InterruptedException, IOException, AWTException {
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(1);
        Row row = sheet.getRow(1);

        WebElement clickAddUserButton = wait.until(ExpectedConditions.elementToBeClickable(addUserButton));
        clickAddUserButton.click();
        WebElement selectUser = wait.until(ExpectedConditions.elementToBeClickable(selectUsr));
        selectUser.click();
        Thread.sleep(3000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        WebElement selectStats = wait.until(ExpectedConditions.elementToBeClickable(selectStatus));
        selectStats.click();
        Thread.sleep(3000);
        Robot r1 = new Robot();
        r1.keyPress(KeyEvent.VK_UP);
        r1.keyRelease(KeyEvent.VK_UP);
        r1.keyPress(KeyEvent.VK_ENTER);
        r1.keyRelease(KeyEvent.VK_ENTER);

        WebElement enterEmployee = wait.until(ExpectedConditions.elementToBeClickable(employeeName));
        String emp = row.getCell(1).getStringCellValue();
        enterEmployee.sendKeys(emp);
        Thread.sleep(3000);
        Robot r2 = new Robot();
        r2.keyPress(KeyEvent.VK_DOWN);
        r2.keyRelease(KeyEvent.VK_DOWN);
        r2.keyPress(KeyEvent.VK_ENTER);
        r2.keyRelease(KeyEvent.VK_ENTER);

        WebElement enterUser = wait.until(ExpectedConditions.elementToBeClickable(userNam));
        String userName = row.getCell(0).getStringCellValue();
        enterUser.sendKeys(userName);
        Thread.sleep(3000);
        WebElement enterPwdd1 = wait.until(ExpectedConditions.elementToBeClickable(enterPwddd));
        String repassword = row.getCell(3).getStringCellValue();
        enterPwdd1.sendKeys(repassword);
        Thread.sleep(5000);
        WebElement enterPwdd = wait.until(ExpectedConditions.elementToBeClickable(confirmPwd));
        String password = row.getCell(2).getStringCellValue();
        enterPwdd.sendKeys(password);
        Thread.sleep(5000);
        WebElement clickSubmit = wait.until(ExpectedConditions.elementToBeClickable(clickOnSubmit));
        clickSubmit.click();
        Thread.sleep(2000);

    }



}
