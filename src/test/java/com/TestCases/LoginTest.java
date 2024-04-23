package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.Browsers.BrowsersInvoked;
import com.PageObjects.Login;
import io.qameta.allure.Description;

public class LoginTest extends BrowsersInvoked{
	
	public WebDriver driver;
	public Login login;
	//ExtentReportClass extentClass;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		login = new Login(driver);
	}
	
	
//	@Test
//	public void readJson() throws FileNotFoundException, IOException, ParseException {
//	JSONParser jsonparse = new JSONParser();
//	
//	JSONObject jsonobject = (JSONObject) jsonparse.parse(new FileReader("TestData\\Demo.json"));
//	
//	
//	String id = (String) jsonobject.getString("EmplooyeeID");
//	
//	System.out.println(id);
//	}
	
	@Test
	@Description("Test case description goes here")
	public void LoginAdmin() throws InterruptedException {
		//extentClass = new ExtentReportClass();
		login.LoginAdmin();
	}
	
	
	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}

}
