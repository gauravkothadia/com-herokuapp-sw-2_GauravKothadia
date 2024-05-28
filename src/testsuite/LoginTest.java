package testsuite;
/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    @Before
    public void browserSetup() {
        openBrowser("http://the-internet.herokuapp.com/login");
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button//i")).click();
        // Verify the text “Secure Area”
        String expectedHeading = "Secure Area";
        String actualHeading = driver.findElement(By.cssSelector("div.example>h2")).getText();
        Assert.assertEquals(expectedHeading, actualHeading);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        // Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button//i")).click();
        // Verify the error message “Your username is invalid!”
        String expectedMessage = "Your username is invalid!";
        boolean isErrorMessageVerified = driver.findElement(By.cssSelector("div#flash")).getText().contains(expectedMessage);
        Assert.assertTrue("Error message does not match.",isErrorMessageVerified);
    }
    @Test
    public void verifyThePasswordErrorMessage() {
        // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button//i")).click();
        // Verify the error message “Your password is invalid!”
        String expectedMessage = "Your password is invalid!";
        boolean isErrorMessageVerified = driver.findElement(By.cssSelector("div#flash")).getText().contains(expectedMessage);
        Assert.assertTrue("Error message does not match.",isErrorMessageVerified);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
