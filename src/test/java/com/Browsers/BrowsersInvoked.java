package com.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.Utilities.PropertiesUtils;

public class BrowsersInvoked {

	public static String browser = PropertiesUtils.getPropertyValue("browserMain");

	public static WebDriver Setup() {

		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion(PropertiesUtils.getPropertyValue("ChromeVersion"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(PropertiesUtils.getPropertyValue("URL"));
		return driver;

	}

	public static void tearDown(WebDriver driver) {
		driver.quit();
	}
}
