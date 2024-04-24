package com.testCases;

import com.browsers.BrowsersInvoked;
import com.pageObjects.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTestParallel extends BrowsersInvoked {

    public WebDriver driver;
    public Login login;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = BrowsersInvoked.setUpParallel();
        login = new Login(driver);
    }


    @Test(enabled = true)
    public void parallelTest() throws InterruptedException {

    }

    @AfterClass
    public void closeDriver() {
        BrowsersInvoked.tearDown(driver);
        driver.quit();
    }
}
