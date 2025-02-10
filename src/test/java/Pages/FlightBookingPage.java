package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class FlightBookingPage {


        private final WebDriver driver;

//constructor
public FlightBookingPage(WebDriver driver) {
    if (driver == null) {
        throw new IllegalArgumentException("Driver cannot be null");
    }
    this.driver = driver;
}
        By departureCity=By.id("srcCode");
        By destinationCity=By.id("destCode");
        By date=By.id("departureDate");
        By qunatityOfticktes=By.id("numPax");
        By searchFlightBtn=By.id("flightSearch");
        By selectFlight=By.xpath("(//div[@class='_2Gvo0'])[1]");
        By button_FlightDetails=By.xpath("//div[@id='efdd316c57c8db57f8c4c92104e06e09']//button[@class='zHp8j'][normalize-space()='View Fare']");
        By proceedButton=By.xpath("//button[text()='Proceed']");
        By enterMobile=By.xpath("//input[@name='mobile']");
        By getlogo=By.xpath("//button[@class='_1igpg']");
        By enterGmail=By.xpath("//input[@name='email']");
        By clickOnProceedsToPayBtn=By.xpath("//button[normalize-space()='Proceed To Pay']");
        By enterLoginDetails=By.id("email_mobile_login");
        By sendOtpBtn=By.id("login_button");
        public boolean isbuttondisplayed(){
            return driver.findElement(getlogo).isDisplayed();
        }


        public void navigateToPaytm(){
            driver.get("https://paytm.com/");

        }
        public void selectDepartureCity(){
            driver.findElement(departureCity).click();


        }



        public void selectDestinationCity(){
            driver.findElement(destinationCity).click();




        }
        public void selectDate(){
            driver.findElement(date).click();

        }
        public void selectPassengers(){
            driver.findElement(qunatityOfticktes).click();



        }
        public void clickSearchFlightButton(){
            driver.findElement(searchFlightBtn).click();


        }

    public void clickFlightDetailsButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(button_FlightDetails).click();
    }


        public void clickOnProceed() {
            driver.findElement(proceedButton).click();
        }

       public void enterPhoneNo() {
            driver.findElement(enterMobile).sendKeys("9813903971");
            driver.findElement(enterGmail).sendKeys("zaffar4534@gmail.com");
            }
            public void setClickOnProceedsToPayBtn(){

            driver.findElement(clickOnProceedsToPayBtn).click();

            }
public void setEnterLoginDetails(){
          driver.findElement(enterLoginDetails).sendKeys("9813903971");
          driver.findElement(sendOtpBtn).click();

}

}

















