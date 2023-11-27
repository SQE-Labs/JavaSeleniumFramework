package org.automation.utilities;

import org.automation.base.BaseTest;
import org.automation.elements.Element;
import org.automation.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

public class WebdriverWaits extends BaseTest {

    static WebDriverWait wait = new WebDriverWait((WebDriver) driver,Duration.ofSeconds(2));
    /**
     * Waits for a given element to be visible
     *
     * @param waitTime  WebDriver instance
     * @param locator By of the element to wait for
     */
    public static void waitForElementVisible(By locator, long waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /**
     * Waits for a given element to be visible
     *
     * @param waitTime WebDriver instance
     * @param waitTime      element to wait for
     */
    public static void waitForElementVisible(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


    /**
     * Waits for a given element to be selected
     *
     * @param waitTime  WebDriver instance
     * @param locator By of the element to wait for
     */
    public static void waitForElementSelected(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        Boolean bool = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }


    /**
     * Waits for a given element to be clickable
     *
     * @param waitTime  WebDriver instance
     * @param locator By to locate element to wait for
     */
    public static void waitForElementClickable(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementUntilVisible(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return e;
    }
    public static void waitForElementNotVisible(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    /**
     * Waits for the page to have a given title
     * <p>
     * This method is an attempt to address a problem where Chrome/IE drivers
     * are trying to check the page title on page load before the title has
     * changed to that of the new page.
     *
     * @param waitTime WebDriver instance
     * @param title  title the page should have
     */
    public static boolean waitForPageTitle(String title, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        return wait.until(ExpectedConditions.titleContains(title));
    }


    /**
     * Sleep script for the specified length
     * (generally not an ideal solution)
     *
     * @param length
     */
    public static void sleep(long length) {
        try {
            Thread.sleep(length);
        } catch (InterruptedException e) {
            /*
             * Log.error("Sleep Interrupted"); e.printStackTrace();
             */
        }
    }

    public static void fluentWait_ElementLocated( ) {
//        Wait<WebDriver> wait = new FluentWait<>(getDriver())
//                .withTimeout(waitTimeForTimeout, TimeUnit.SECONDS)
//                .pollingEvery(waitTimeForPolling, TimeUnit.SECONDS)
//                .ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(15))
                .ignoring(NoSuchElementException.class);

    }

    public static void WaitUntilVisible(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void SwitchToNewTab() throws InterruptedException {
        String originalHandle = getDriver().getWindowHandle();
        Set<String> tabs = getDriver().getWindowHandles();

        for(String handle : tabs) {
            if (!handle.equals(originalHandle)) {
                getDriver().switchTo().window(handle);
            }
        }

        Thread.sleep(3000);
    }
  public void byToWebelement(By element){

      JavascriptExecutor js=(JavascriptExecutor)driver;
      WebElement ele=driver.get().findElement(element);
      js.executeScript(String.valueOf(ele));
  }


    public String getText_custom(By path) {
        String text = "";
        try {

            Element element = new Element("", path);
            text = element.getText();
            Log.info("Text for " + path + " is " + text);
            extentTest.log(PASS, "Text retrieved is: " + text);
            return text;
        } catch (Exception e) {
            extentTest.log(FAIL, "Unable to get text due to exception : \n" + e);

        }
        return text;
    }

}



