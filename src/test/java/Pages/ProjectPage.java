package Pages;

import BaseTest.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectPage extends Base {
    private final WebDriverWait wait;


    public  ProjectPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    private final By projectBtn = By.xpath("//*[contains(text(),'Project Info')]");
    private final By customerDropdown= By.xpath("//a[text()='Customers']");
    private final By addCustomerBtn=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By customerNameTF=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By submitBtn=By.xpath("//button[@type='submit']");


    public void projectPage() throws InterruptedException {
        WebElement clickOnProject= wait.until(ExpectedConditions.visibilityOfElementLocated(projectBtn));
        clickOnProject.click();
        Thread.sleep(3000);
        WebElement clickOnCustDropDown= wait.until(ExpectedConditions.visibilityOfElementLocated(customerDropdown));
        clickOnCustDropDown.click();
        Thread.sleep(3000);
        WebElement clickOnAddCustDropDown= wait.until(ExpectedConditions.visibilityOfElementLocated(addCustomerBtn));
        clickOnAddCustDropDown.click();
        Thread.sleep(3000);
        WebElement enterCustName= wait.until(ExpectedConditions.visibilityOfElementLocated(customerNameTF));
        enterCustName.sendKeys("zaif");
        Thread.sleep(3000);
        WebElement clickOnSubmitBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
        clickOnSubmitBtn.click();
        Thread.sleep(3000);



    }
}
