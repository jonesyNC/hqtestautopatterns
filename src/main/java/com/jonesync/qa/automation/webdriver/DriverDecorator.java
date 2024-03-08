package com.jonesync.qa.automation.webdriver;

import com.jonesync.qa.automation.webelement.Element;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Objects;

/**
 * Driver Decorator using composition wrappers a Driver instance
 * and overrides all the Driver component methods. Why?
 * Because we need to wrapper the Concrete component in order
 * to add/change behavior without changing the Concrete component
 * implementation.
 **/
public abstract class DriverDecorator extends Driver {

    protected Driver driver;

    protected DriverDecorator(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void start(Browser browser) {
        Objects.requireNonNull(browser);
        driver.start(browser);
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public void goToUrl(String url) {
        Objects.requireNonNull(url);
        driver.goToUrl(url);
    }

    @Override
    public Element findElement(By locator) {
        Objects.requireNonNull(locator);
        return driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        Objects.requireNonNull(locator);
        return driver.findElements(locator);
    }

}
