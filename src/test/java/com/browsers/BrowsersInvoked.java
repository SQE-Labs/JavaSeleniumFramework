package com.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.utilities.PropertiesUtils;

public class BrowsersInvoked {

    public static String browser = PropertiesUtils.getPropertyValue("browserMain");

    public static WebDriver setup() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion(PropertiesUtils.getPropertyValue("chromeVersion"));
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(PropertiesUtils.getPropertyValue("url"));
        return driver;

    }

    public static WebDriver setUpParallel() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion(PropertiesUtils.getPropertyValue("chromeVersion"));
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(PropertiesUtils.getPropertyValue("url2"));
        return driver;

    }

    public static void tearDown(WebDriver driver) {
        //driver.quit();
    }
}
