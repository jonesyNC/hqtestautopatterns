package com.jonesync.qa.automation.webdriver;

import com.jonesync.qa.automation.webelement.Element;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Abstract component for the WebDriver
 * defines the default actions
 */
public abstract class Driver {

    public abstract void start(Browser browser);

    public abstract void quit();

    public abstract void goToUrl(String url);

    public abstract Element findElement(By locator);

    public abstract List<Element> findElements(By locator);

}

