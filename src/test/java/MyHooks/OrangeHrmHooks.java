package MyHooks;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class OrangeHrmHooks {
    WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("launch the browser");

    }
    @After
    public void tearDOwn(){
        driver.quit();

        System.out.println("Browser closed and WebDriver session terminated");

    }

}
