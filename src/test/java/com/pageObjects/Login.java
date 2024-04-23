package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.commonMethods.CommonMethods;

public class Login extends CommonMethods {

	public static By userName = By.id("user-name");
	public static By passWord  = By.id("password");
	public static By submit = By.id("login-button");

	public Login(WebDriver driver) {

		super(driver);
		this.driver = driver;

	}

	public void LoginAdmin() {


		SendKeysWithClear(userName,"standard_user");
		SendKeysWithClear(passWord,"secret_sauce");
		ClickOn(submit);
		
		//Assert.assertTrue(false);
	}

}
