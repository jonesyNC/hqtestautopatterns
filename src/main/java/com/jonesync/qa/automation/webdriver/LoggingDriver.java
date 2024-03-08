package com.jonesync.qa.automation.webdriver;

import com.jonesync.qa.automation.webelement.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Objects;

/**
 * Concrete Decorator LoggingDriver adds
 * new behavior by extending abstract decorator
 * and overriding the methods.
 * The decorator holds the driver instance.
 */
public class LoggingDriver extends DriverDecorator {

    public LoggingDriver(Driver driver) {
        super(driver);
    }

    @Override
    public void start(Browser browser) {
        Objects.requireNonNull(browser);
        System.out.println("Start browser = " + browser.name());
        driver.start(browser);
    }

    @Override
    public void quit() {
        System.out.println("Close the browser");
        driver.quit();
    }

    @Override
    public void goToUrl(String url) {
        Objects.requireNonNull(url);
        System.out.println("Go to URL = " + url);
        driver.goToUrl(url);
    }

    @Override
    public Element findElement(By locator) {
        Objects.requireNonNull(locator);
        System.out.println("Find Element by " + locator.toString());
        return driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        Objects.requireNonNull(locator);
        System.out.println("Finding Elements by " + locator.toString());
        return driver.findElements(locator);
    }
}