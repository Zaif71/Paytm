package StepDefinitions;

import Pages.FlightBookingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class paytmLoginSteps {

   public WebDriver driver;
   public FlightBookingPage flightBookingPage;
    @Given("user launch browser and enter url")
    public void userLaunchBrowserAndEnterUrl() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\zaffar\\paytm\\Drivers\\chromedriver.exe");
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }

    @Given("the user is on the Paytm flight booking page")
    public void theUserIsOnThePaytmFlightBookingPage() {
     flightBookingPage=new FlightBookingPage(driver);
        flightBookingPage.navigateToPaytm();

    }

    @When("the user selects a departure city")
    public void theUserSelectsADepartureCityAs(){
     flightBookingPage.selectDepartureCity();
    }

    @And("the user selects a destination city")
    public void theUserSelectsADestinationCityAs() {
     flightBookingPage.selectDestinationCity();

    }

    @And("the user selects the departure date")
    public void theUserSelectsTheDepartureDateAs(){
     flightBookingPage.selectDate();
    }

    @And("the user selects adult traveler")
    public void theUserSelectsAdultTraveler() {
     flightBookingPage.selectPassengers();
    }

    @And("the user clicks on the search flight button")
    public void theUserClicksOnTheButton() {
     flightBookingPage.clickSearchFlightButton();
    }



 @And("user clicks on flight details button")
 public void userClicksOnFlightDetailsButton() {
     flightBookingPage.clickFlightDetailsButton();
 }
 @Then("user click on proceed button")
 public void userClickOnProceedBtn(){

  flightBookingPage.clickOnProceed();

 }
 @And ("user switch to next window")
 public void switchToNewWindow(){
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  wait.until(driver -> driver.getWindowHandles().size() > 1);
  String originalWindow = driver.getWindowHandle();

  Set<String> allWindowHandles = driver.getWindowHandles();
  for (String windowHandle : allWindowHandles) {
   if (!windowHandle.equals(originalWindow)) {
    // Switch to the new window
    driver.switchTo().window(windowHandle);
    break; // Exit the loop after switching
   }
  }
  wait.until(ExpectedConditions.titleContains("Flight Tickets, Flight Booking Online, Book Cheap Flights, Air Ticke"));
 }

@Then("user scroll to phoneNumber")
 public void scrollToPhoneNumber(){
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  WebElement element= driver.findElement(By.xpath("//input[@name='mobile']"));
  JavascriptExecutor js = (JavascriptExecutor) driver;
  js.executeScript("arguments[0].scrollIntoView(true);",element );

 }


 @Then("user enter their Mobile no")
 public void userEnterTheirMobileNo() {

     flightBookingPage.enterPhoneNo();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  WebElement element= driver.findElement(By.xpath("//button[normalize-space()='Proceed To Pay']"));
  JavascriptExecutor js = (JavascriptExecutor) driver;
  js.executeScript("arguments[0].scrollIntoView(true);",element );

 }


 @And("user clicks on proceeds to pay")
 public void userClicksOnProceedsToPay() {
     flightBookingPage.setClickOnProceedsToPayBtn();
  driver.switchTo().frame("oauth-iframe");


 }
 @And("enter login details")
 public void enterLoginDetails() {
     flightBookingPage.setEnterLoginDetails();
 }

 @And("user checks")
 public void userChecks() {
  Assert.assertTrue(flightBookingPage.isbuttondisplayed());
 }



}
