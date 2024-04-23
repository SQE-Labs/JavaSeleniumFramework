package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.CommonMethods.CommonMethods;

public class Login extends CommonMethods {

	public static By signButton = By.xpath("//a[@class='login']");
	public static By emailAddress = By.id("email");
	public static By passWord  = By.id("passwd");
	public static By submit = By.id("SubmitLogin");

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	public void LoginAdmin() throws InterruptedException {
	
		ClickOn(signButton);
		scrollIntoView(emailAddress);
		SendKeysWithClear(emailAddress,"shhubhammehta04@gmail.com");	
		SendKeysWithClear(passWord,"Shubhammehta04");
		ClickOn(submit);
		
		//Assert.assertTrue(false);
	}

}
