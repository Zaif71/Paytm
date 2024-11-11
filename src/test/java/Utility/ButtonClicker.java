package Utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class ButtonClicker {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize the WebDriver
    public ButtonClicker(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait up to 10 seconds for elements to be clickable
    }

    // Method to click buttons by reading names from Excel
    public void clickButtonsFromExcel(String filePath) {
        try {
            // Open the Excel file
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);  // Get the first sheet

            // Iterate through each row in the Excel sheet
            for (Row row : sheet) {
                Cell firstCell = row.getCell(0);  // Get the first cell (Column A)

                if (firstCell != null) {
                    String buttonName = firstCell.toString();  // Get button name from the first column

                    // Construct a dynamic XPath using the button name
                    String dynamicXPath = "//span[contains(text(),'" + buttonName + "')]";

                    // Wait for the button to be clickable and click it
                    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
                    button.click();

                    // Add a small delay to wait for any page transitions or actions
                    Thread.sleep(2000);  // Optional: Adjust this value if needed
                }
            }

            // Close the workbook and input stream
            workbook.close();
            fileInputStream.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
