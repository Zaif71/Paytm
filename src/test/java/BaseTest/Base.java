package BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.time.Duration;

public class Base {
    public WebDriver driver;
    @BeforeClass
    public void initializer() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\zaffar\\paytm\\Drivers\\chromedriver.exe");
            this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            this.driver.get("https://www.calculator.net/mortgage-calculator.html");
    }
    @AfterClass
    public void breakk() {
        if (driver != null) {
            driver.quit();
        }

    }
}
