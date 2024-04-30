package com.browsers;

import com.pageObjects.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.utilities.PropertiesUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BrowsersInvoked {

    WebDriver driver;
    Login login;
    BrowsersInvoked browsers;

    public static String browser = PropertiesUtils.getPropertyValue("browserMain");

    public static WebDriver setup() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion(PropertiesUtils.getPropertyValue("chromeVersion"));
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(PropertiesUtils.getPropertyValue("url"));
        Thread.sleep(4000);
        return driver;

    }

//    @BeforeClass
//    public WebDriver BrowsersInvoked() throws InterruptedException {
//        driver = browsers.setup();
//        //login = new Login(driver);
//        return driver;
//    }

//    @AfterClass
//    public void closeDriver() {
//        BrowsersInvoked.tearDown(driver);
//        driver.quit();
//    }


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
