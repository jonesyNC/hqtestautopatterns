package com.jonesync.qa.automation.webelement;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Objects;

/**
 * ConcreteComponent for Selenium WebElements.
 * Wrappers our Component Element
 * Encapsulates a WebDriver, a WebElement and a By locator.
 * This demonstrates composition over inheritance.
 */
public class UIElement extends Element {

    private WebDriver webDriver;
    private WebElement webElement;
    private By by;

    /**
     * Constructor for instance of UIElement class
     * @param webDriver - Selenium WebDriver instance
     * @param webElement - Selenium webElement
     * @param by - By locator
     */
    public UIElement(WebDriver webDriver, WebElement webElement, By by) {
        this.webDriver = webDriver;
        this.webElement = webElement;
        this.by = by;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    public By getBy() {
        return by;
    }

    @Override
    public String getText() {
        Objects.requireNonNull(webElement, "Web Element cannot be null here.");
        return webElement.getText();
    }

    @Override
    public boolean isEnabled() {
        Objects.requireNonNull(webElement, "Web Element cannot be null here.");
        return webElement.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        Objects.requireNonNull(webElement, "Web Element cannot be null here.");
        return webElement.isDisplayed();
    }

    @Override
    public void setText(String text) {
        Objects.requireNonNull(webElement, "Web Element cannot be null here.");
        Objects.requireNonNull(text, "Parameter must not be null.");
        webElement.clear();
        webElement.sendKeys(text);
    }

    @Override
    public void click() {
        webElement = waitToBeClickable(by);
        webElement.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        Objects.requireNonNull(webElement, "Web Element cannot be null here.");
        Objects.requireNonNull(attributeName, "Parameter must not be null.");
        return webElement.getAttribute(attributeName);
    }

    /**
     * SPJ Added this, and it is not correct.
     * @param by
     * @return
     */
    private WebElement waitToBeClickable(By by) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
