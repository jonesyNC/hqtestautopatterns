package com.jonesync.qa.automation.test;

import com.jonesync.qa.automation.webdriver.Browser;
import com.jonesync.qa.automation.webdriver.BrowserDriver;
import com.jonesync.qa.automation.webdriver.Driver;
import com.jonesync.qa.automation.webdriver.LoggingDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
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
    public void purchaseBikeLight() {
        driver.goToUrl("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).setText("standard_user");
        driver.findElement(By.id("password")).setText("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add bike light to cart.
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        // Click on cart
        driver.findElement(By.cssSelector("#shopping_cart_container > a")).click();

        // Click on Checkout
        driver.findElement(By.id("checkout")).click();

        // Enter info and continue
        driver.findElement(By.id("first-name")).setText("Steve");
        driver.findElement(By.id("last-name")).setText("Boxer");
        driver.findElement(By.id("postal-code")).setText("45524");
        driver.findElement(By.id("continue")).click();

        // Verify total
        String total = driver.findElement(By.cssSelector(
                "#checkout_summary_container > div > div.summary_info > div.summary_info_label.summary_total_label")).getText();
        Assert.assertEquals(total, "Total: $10.79", "Correct total price for order.");

        driver.findElement(By.id("finish")).click();
    }
}
