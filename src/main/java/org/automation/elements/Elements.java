package org.automation.elements;

import org.automation.logger.Log;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.ExplicitWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public final class Elements  {

    private final String description;
    private final By locator;
    private final ExplicitWait wait;

    /**
     * This Constructor is used to create an object to access a <b>Text</b>.
     *
     * @param description description of the text
     * @param locator     locator of the text
     */
    public Elements(String description, By locator) {
        this.description = description;
        this.locator = locator;
        wait = new ExplicitWait();
    }

    /**
     * To provide the selenium web element.
     *
     * @return list of web elements
     */
    public List<WebElement> getWebElements() {
        Log.info("Get the list of [" + description + "] web elements");
        return wait.until(visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * Get the text from all the text elements with the mentioned locator.
     *
     * @return list of texts
     */
    public String[] getTextFromAllElements() {
        Log.info("Get the list of text from [" + description + "]");
        return wait.until(visibilityOfAllElementsLocatedBy(locator)).stream().map(WebElement::getText)
                .toArray(String[]::new);
    }

    /**
     * Get the number of elements present for the mentioned locator
     *
     * @return number of elements
     */
    public int getNumberOfElements() {
        Log.info("Get the number of [" + description + "] web elements");
        return wait.until(visibilityOfAllElementsLocatedBy(locator)).size();
    }
}