package Utility;


import Pages.*;
import StepDefinitions.ValidLoginStepDef;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class SimpleExcelReader {

    private static final String path = "C:\\Users\\zaffar\\paytm\\src\\test\\TestData\\OrangeHrm2.xlsx";
    private WebDriver driver;
    private WebDriverWait wait;

    public SimpleExcelReader(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void excel() throws IOException, InterruptedException, AWTException {
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int countRow = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < 6; i++) {
            Row row = sheet.getRow(i);

            for (int j = 0; j < 1; j++) {
                Cell cell = row.getCell(j);

                System.out.print(cell.toString());
                String cellValue = cell.toString().trim();
                String xpath = "//span[text()='" + cellValue + "']";
                WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                button.click();
                Thread.sleep(3000);
              //  SoftAssert softAssert = new SoftAssert();
             //   WebElement logoutButton = driver.findElement(By.xpath("//h6[text()='" + cellValue + "']"));
              //  softAssert.assertTrue(logoutButton.isDisplayed(), "Button text is not displayed!" + cellValue);
              //  softAssert.assertAll();
                System.out.println("button is clicked");
                Cell cell2 = row.getCell(1);
                String actualURL = driver.getCurrentUrl().trim();
                System.out.println(actualURL);
                String expectedUrl = cell2.toString().trim();
                System.out.println(expectedUrl);
               // Assert.assertEquals("url not matched", actualURL, expectedUrl);
                System.out.println("url is matched");
                Cell resultCell = row.createCell(2);
                if (actualURL.equals(expectedUrl)) {
                    resultCell.setCellValue("TRUE");
                    System.out.println("result column created TRUE");
                } else {
                    resultCell.setCellValue("Fail");
                    System.out.println("url  not matched");
                }


                Sheet newSheet = workbook.getSheet(cellValue);
                if (newSheet == null) {
                    newSheet = workbook.createSheet(cellValue);
                    System.out.println("Created new sheet with name: " + cellValue);
                }


            if (cellValue.equals("Admin")){
                Row newRow = newSheet.createRow(0);
                Cell newCell = newRow.createCell(0);
                Cell newCell1=newRow.createCell(1);
                Cell newCell2=newRow.createCell(2);
                Cell newCell3=newRow.createCell(3);
                Cell newCell4=newRow.createCell(4);
                Cell newCell5=newRow.createCell(5);

                newCell.setCellValue("UserName");
                newCell1.setCellValue("Employee Name");
                newCell2.setCellValue("password");
                newCell3.setCellValue("Re-Enter-pwd");
                newCell4.setCellValue("User Role");
                newCell5.setCellValue("Status");

                ValidLoginPage validLoginPage=new ValidLoginPage(driver);
                validLoginPage.getClickAddUserButton();
            }
            if (cellValue.equals("PIM")){


                CreateUserPage createUser=new CreateUserPage(driver);
                createUser.addEmployee();

            }
            if (cellValue.equals("Leave")){
                LeavePage leavePage=new LeavePage(driver);
                leavePage.takeLeave();
                System.out.println("Leave Btn clicked");

                }
            if (cellValue.equals("Time")){
                ProjectPage projectPage=new ProjectPage(driver);
                projectPage.projectPage();

            }
            if (cellValue.equals("Recruitment")){

                RecuirtmentPage recuirtmentPage=new RecuirtmentPage(driver);
                recuirtmentPage.requirementProcess();
            }


            }

            System.out.println();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileInputStream.close();


    }
}
