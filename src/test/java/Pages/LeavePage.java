package Pages;

import BaseTest.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class LeavePage extends Base {
    private final WebDriverWait wait;


    public  LeavePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    private final By applyBtn = By.xpath("//a[text()='Apply']");
    private final By selectReason=By.xpath("//div[text()='-- Select --']");
    private final By selectDateBtn=By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
    private final By selectDateBtn1=By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
    private final By submitBtn=By.xpath("//button[@type='submit']");
   public void takeLeave() throws InterruptedException, AWTException {
       WebElement clickOnApply= wait.until(ExpectedConditions.visibilityOfElementLocated(applyBtn));
       clickOnApply.click();
       Thread.sleep(3000);
       WebElement clickOnSelectReason= wait.until(ExpectedConditions.visibilityOfElementLocated(selectReason));
       clickOnSelectReason.click();
       Robot r = new Robot();
       r.keyPress(KeyEvent.VK_DOWN);
       r.keyRelease(KeyEvent.VK_DOWN);
       r.keyPress(KeyEvent.VK_ENTER);
       r.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(3000);
       WebElement clickOnSelectDate= wait.until(ExpectedConditions.visibilityOfElementLocated(selectDateBtn));
       clickOnSelectDate.sendKeys("2024-10-10");
       WebElement clickOnSelectDate1= wait.until(ExpectedConditions.visibilityOfElementLocated(selectDateBtn1));
       clickOnSelectDate1.click();
       WebElement clickOnSubmit= wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
       clickOnSubmit.click();
       Thread.sleep(3000);







}
}
