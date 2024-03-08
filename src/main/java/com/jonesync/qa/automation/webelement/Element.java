package com.jonesync.qa.automation.webelement;

import org.openqa.selenium.By;

/**
 * Component class for an Element
 * Defines the default actions and state.
 */
public abstract class Element {
    private By by;
    private String text;
    private boolean enabled;
    private boolean displayed;

    public abstract By getBy();

    public abstract String getText();

    public abstract boolean isEnabled();

    public abstract boolean isDisplayed();

    public abstract void setText(String text);

    public abstract void click();

    public abstract String getAttribute(String attributeName);


}
