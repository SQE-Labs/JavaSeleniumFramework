package com.commonMethods;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.logs.Log;
import com.utilities.PropertiesUtils;

public class CommonMethods {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public CommonMethods(WebDriver driver) {
		CommonMethods.driver = driver;
	}

	public void navigationURL(String Url) {
		driver.get(Url);

	}

	
	public void moveToElement(By element) {
		WebElement ele = driver.findElement(element);
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		String text = element.getText();
		return text;
	}


	public void waitUntilElementPresent(By element) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
			fluentWait1.until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void waitUntilElementClickable(WebElement element) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
			fluentWait1.until(ExpectedConditions.elementToBeClickable(element));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}


	public void waitForElementIsInteractable(By element) {

		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("QAwaitTime60"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(ElementClickInterceptedException.class, ElementNotInteractableException.class);
			fluentWait1.until(ExpectedConditions.elementToBeClickable(element));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}
	
	public static void ClickOn(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(15)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
		}
		WebElement ele = driver.findElement(element);
		ele.click();
	}
	
	public static void SendKeysWithClear(By element, String value) {
		try {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ele = driver.findElement(element);
		ele.clear();
		ele.sendKeys(value);
	}


	public void sendKeysWithWait(By element, String value) {
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement ele = driver.findElement(element);
		ele.sendKeys(value);
		Log.info("Sendkeys on " + element + " with value " + value);
	}
	
	public void scrollIntoView(By element) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement ele = driver.findElement(element);
			jse.executeScript("arguments[0].scrollIntoView(true);", ele);
			Log.info("Scroll Into View " + element);
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Scroll Into View failed.");
		}
	}


	public void clearElement(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		ele.clear();
		Log.info("Cleared value from " + element);
	}

	public void clickOnWE(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		Log.info("Clicked on " + element);
	}

	public void clickOnWE20(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		Log.info("Clicked on " + element);
	}

	public String getTextElement(By element) {

		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		// wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement ele = driver.findElement(element);
		String text = ele.getText();
		Log.info("GetText from" + element);
		return text;
	}

	
	public void movetoElementAndClick(By selector) {
		try {
			Actions act = new Actions(driver);
			WebElement element = driver.findElement(selector);
			act.moveToElement(element).build().perform();
			act.click().build().perform();
			Log.info("Move to element and Click on " + element);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
}