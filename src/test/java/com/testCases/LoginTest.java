package com.testCases;

import com.commonMethods.Data_provider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.browsers.BrowsersInvoked;
import com.pageObjects.Login;

import java.util.Map;

public class LoginTest extends BrowsersInvoked{


	public WebDriver driver;
	public Login login;

//	 login = new Login(driver);
//     super(driver);


	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = BrowsersInvoked.setup();
		login = new Login(driver);
	}

	@Test(dataProvider = "jsonDataProvider",dataProviderClass = Data_provider.class)
	public void loginAdmin(Map<String, String> testData) throws InterruptedException {
		login = new Login(driver);
		String username = testData.get("User");
		String password = testData.get("Passwd");
		login.login(username,password);

	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
		driver.quit();
	}



}
