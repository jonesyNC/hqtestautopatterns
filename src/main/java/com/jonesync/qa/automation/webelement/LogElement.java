package com.jonesync.qa.automation.webelement;


import org.openqa.selenium.By;

/**
 * Concrete Decorator that enhances the component by extending the Decorator
 * In this example we are adding logging.
 * <p>
 * This has allowed us to alter the behavior of the methods of the Component (Element) class
 * without modifying the Concrete Component class (UIElement).  This is Open/Closed principle.
 */
public class LogElement extends ElementDecorator {

    public LogElement(Element element) {
        super(element);
    }

    /**
     * Since this method is not overriding any behavior in the abstract class
     * I think we could omit this method.
     *
     * @return - The By locator for the element
     */
    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {

        System.out.println("The Element text is: " + element.getText());
        return element.getText();
    }

    @Override
    public boolean isEnabled() {
        System.out.println("Element Enabled = " + element.isEnabled());
        return element.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        System.out.println("Element Displayed = " + element.isDisplayed());
        return element.isDisplayed();
    }

    @Override
    public void click() {
        System.out.println("Element Clicked");
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        System.out.println("Get Element's Attribute = " + attributeName);
        return element.getAttribute(attributeName);
    }

    @Override
    public void setText(String text) {
        System.out.println("Type Text = " + text);
        element.setText(text);
    }


}
