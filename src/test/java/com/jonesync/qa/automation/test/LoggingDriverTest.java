package com.jonesync.qa.automation.test;

import com.jonesync.qa.automation.webdriver.Browser;
import com.jonesync.qa.automation.webdriver.BrowserDriver;
import com.jonesync.qa.automation.webdriver.Driver;
import com.jonesync.qa.automation.webdriver.LoggingDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoggingDriverTest {

    private static Driver driver;

    /**
     * New the desired Concrete Decorator containing the behavior we want
     *         and pass into that a new Concrete Component instance.
     *
     */
    @BeforeClass
    public static void classInitializer() {
        driver = new LoggingDriver(new BrowserDriver());
        driver.start(Browser.CHROME);
    }

    @AfterClass
    public static void ClassCleanup() {
        driver.quit();
    }

    @Test
    public void purchaseMacbookPro() {
        driver.goToUrl("https://demoblaze.com");

        driver.findElement(By.id("next2")).click();

        driver.findElement(By.cssSelector("#tbodyid > div:nth-child(6) > div > div > h4 > a")).click();

        driver.findElement(By.cssSelector("#tbodyid > div.row > div > a")).click();

        // Here is a problem . . . we are so abstracted away from the WebDriver I cannot
        // here define a new wait.  I should only be doing this in Web Page classes for sure
        // but the problem would be there as well.
                
        // Wait for alert with text "Product Added"
        Alert alert = new WeDriverWait()







    }



}
