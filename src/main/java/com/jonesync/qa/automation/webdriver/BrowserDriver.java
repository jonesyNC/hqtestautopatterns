package com.jonesync.qa.automation.webdriver;

import com.jonesync.qa.automation.webelement.Element;
import com.jonesync.qa.automation.webelement.LogElement;
import com.jonesync.qa.automation.webelement.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete component for Driver
 * Composition - wraps WebDriver
 * Find element behavior improved by waiting for element to exist.
 * Uses factory method Start to create instances of WebDriver
 */
public class BrowserDriver extends Driver {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;


    @Override
    public void start(Browser browser) {
        switch (browser) {
            case CHROME -> {
                webDriver = new ChromeDriver();
            }
            case FIREFOX -> {
                webDriver = new FirefoxDriver();
            }
            case EDGE -> {
                webDriver = new EdgeDriver();
            }
            case SAFARI -> {
                webDriver = new SafariDriver();
            }
            default -> {
                throw new InvalidArgumentException("Unsupported browser type: " + browser.name());
            }
        }
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public void goToUrl(String url) {
        webDriver.navigate().to(url);
    }

    /**
     * Overridden find element first waits until element is present before returning it.
     * Initializes our Element via concrete component UIElement
     * then pass it to the LogElement decorator.
     * And this all works because each one is an Element
     * If later you create another Decorator you can add it to the chain here and
     * its behavior will be added to the other two!
     * @param locator - By locator string
     * @return - Element (a log element)
     */
    @Override
    public Element findElement(By locator) {
        WebElement nativeElement =
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Element element = new UIElement(webDriver, nativeElement, locator);
        Element logElement = new LogElement(element);
        return logElement;
    }

    @Override
    public List<Element> findElements(By locator) {
        List<WebElement> nativeElements =
                webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

        List<Element> elements = new ArrayList<>();
        for (WebElement nativeElement : nativeElements) {
            Element element = new UIElement(webDriver, nativeElement, locator);
            // optional Element logElement = new LogElement(element);
            elements.add(element);
        }

        return elements;
    }
}
