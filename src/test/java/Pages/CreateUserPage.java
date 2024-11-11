package Pages;

import BaseTest.Base;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class CreateUserPage extends Base {
    private final WebDriverWait wait;
    private static final String path = "C:\\Users\\zaffar\\paytm\\src\\test\\TestData\\OrangeHrm2.xlsx";


    public  CreateUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    private final By addEmpButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By enterFirstName = By.xpath("//input[@name='firstName']");
    private final By enterMiddleName = By.xpath("//input[@name='middleName']");
    private final By enterLastName = By.xpath("//input[@name='lastName']");
    private final By clickOnSubmitBtn=By.xpath("//button[@type='submit']");

    public void addEmployee() throws IOException, InterruptedException {
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(3);
        Row row = sheet.getRow(1);
        String first= row.getCell(0).getStringCellValue();
        String middle= row.getCell(1).getStringCellValue();
        String last= row.getCell(2).getStringCellValue();

        WebElement clickOnAddEmp= wait.until(ExpectedConditions.visibilityOfElementLocated(addEmpButton));
        clickOnAddEmp.click();
        Thread.sleep(3000);
        WebElement enterFirstNam = wait.until(ExpectedConditions.visibilityOfElementLocated(enterFirstName));
        enterFirstNam.sendKeys(first);
        Thread.sleep(3000);
        WebElement enterMiddleNam = wait.until(ExpectedConditions.visibilityOfElementLocated(enterMiddleName));
        enterMiddleNam.sendKeys(middle);
        Thread.sleep(3000);
        WebElement enterLastNam = wait.until(ExpectedConditions.visibilityOfElementLocated(enterLastName));
        enterLastNam.sendKeys(last);
        Thread.sleep(3000);
        WebElement clickOnSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnSubmitBtn));
        clickOnSubmit .click();
        Thread.sleep(3000);
        workbook.close();
        fileInputStream.close();


    }



}
