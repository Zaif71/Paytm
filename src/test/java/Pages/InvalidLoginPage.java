package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvalidLoginPage {
    private final WebDriver driver;
    By emailField = By.xpath("//input[@name='username']");
    By pwd = By.xpath("//input[@type='password']");
    By loginClick = By.xpath("//button[@type='submit']");
    By errorMessage = By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']");

    //constructor
    public InvalidLoginPage(WebDriver driver) {

        this.driver = driver;
    }

public void enterValidCred(String username,String password){
    driver.findElement(emailField).clear();
    driver.findElement(emailField).sendKeys(username);
    driver.findElement(pwd).clear();
    driver.findElement(pwd).sendKeys(password);
    driver.findElement(loginClick).click();

}

    public void enterUsername(String username) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(username);

    }

    public void enterPassword(String password) {
        driver.findElement(pwd).clear();
        driver.findElement(pwd).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginClick).click();
    }


    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String login(String username, String password) {
        if (!username.isEmpty()) {
            enterUsername(username);
        }
        if (!password.isEmpty()) {
            enterPassword(password);
        }
        clickLoginButton();
        return getErrorMessage();  // Returns the error message after login attempt
    }
    public void navigateToLoginPage(String url) {
        driver.get(url);  // Navigates to the provided login page URL
    }
}