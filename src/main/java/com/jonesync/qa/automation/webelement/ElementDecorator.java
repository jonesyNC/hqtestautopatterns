package com.jonesync.qa.automation.webelement;

import org.openqa.selenium.By;

/**
 * Decorator for Element component
 * Implements the same Interface (abstract class) as the component they are going to decorate.
 * It HAS-A relationship with the objects that it is extending, which means that the Component has an
 * instance variable that holds a reference to the object it is extending.
 * This means we can nest an unlimited number of decorators, where each layer will add additional logic
 * to the default element action.
 */
public abstract class ElementDecorator extends Element {

    protected Element element;

    protected ElementDecorator(Element element) {
        this.element = element;
    }

    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        return element.getAttribute(attributeName);
    }

    @Override
    public void setText(String text) {
        element.setText(text);
    }


}
