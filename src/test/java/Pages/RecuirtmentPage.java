


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

 public class RecuirtmentPage extends Base {
     private final WebDriverWait wait;


     public  RecuirtmentPage(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
     }
     private final By select1=By.xpath("(//div[@class='oxd-select-wrapper'])[1]");
     private final By select2=By.xpath("(//div[@class='oxd-select-wrapper'])[2]");
     private final By select3=By.xpath("(//div[@class='oxd-select-wrapper'])[3]");
     private final By select4=By.xpath("(//div[@class='oxd-select-wrapper'])[4]");
     private final By select5=By.xpath("(//div[@class='oxd-select-wrapper'])[5]");
     private final By addBtn=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
     public void requirementProcess() throws InterruptedException, AWTException {
         WebElement clickOnApply= wait.until(ExpectedConditions.visibilityOfElementLocated(select1));
         clickOnApply.click();
         Robot r1 = new Robot();
         r1.keyPress(KeyEvent.VK_DOWN);
         r1.keyRelease(KeyEvent.VK_DOWN);
         r1.keyPress(KeyEvent.VK_ENTER);
         r1.keyRelease(KeyEvent.VK_ENTER);
         Thread.sleep(3000);
         WebElement clickOnSelectReason= wait.until(ExpectedConditions.visibilityOfElementLocated(select2));
         clickOnSelectReason.click();
         Robot r = new Robot();
         r.keyPress(KeyEvent.VK_DOWN);
         r.keyRelease(KeyEvent.VK_DOWN);
         r.keyPress(KeyEvent.VK_ENTER);
         r.keyRelease(KeyEvent.VK_ENTER);
         Thread.sleep(3000);
         WebElement clickOnSelectDate= wait.until(ExpectedConditions.visibilityOfElementLocated(select3));
         clickOnSelectDate.click();
         Robot r2 = new Robot();
         r2.keyPress(KeyEvent.VK_DOWN);
         r2.keyRelease(KeyEvent.VK_DOWN);
         r2.keyPress(KeyEvent.VK_ENTER);
         r2.keyRelease(KeyEvent.VK_ENTER);

         WebElement clickOnSelectDate1= wait.until(ExpectedConditions.visibilityOfElementLocated(select4));
         clickOnSelectDate1.click();
         Robot r3 = new Robot();
         r3.keyPress(KeyEvent.VK_DOWN);
         r3.keyRelease(KeyEvent.VK_DOWN);
         r3.keyPress(KeyEvent.VK_ENTER);
         r3.keyRelease(KeyEvent.VK_ENTER);
         WebElement clickOnSubmit= wait.until(ExpectedConditions.visibilityOfElementLocated(select5));
         clickOnSubmit.click();
         Robot r4 = new Robot();
         r4.keyPress(KeyEvent.VK_DOWN);
         r4.keyRelease(KeyEvent.VK_DOWN);
         r4.keyPress(KeyEvent.VK_ENTER);
         r4.keyRelease(KeyEvent.VK_ENTER);
         Thread.sleep(3000);
         WebElement clickOnSubmitBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(addBtn));
         clickOnSubmitBtn.click();







     }
 }





