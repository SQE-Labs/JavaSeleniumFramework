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


//	public void reader(String[] data) {
//
//		//Arrays.toString(data);
//		//System.out.println(str);
//		// String user[] = str.split("[\\[\\],]");
//
//		//Arrays.asList(data);
//		List<String> list = new ArrayList<>();
//		for (int i = 0; i < data.length; i++) {
//			list.add(data[i]);
//		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i)+"\n");
//		}
//	}


	public void login(String username ,String password) throws InterruptedException {

		Thread.sleep(4000);
        SendKeysWithClear(userName,username);
		SendKeysWithClear(passWord,password);
		ClickOn(submit);
		//Assert.assertTrue(false);
	}

	public void loginParallel(String username ,String password) {

		SendKeysWithClear(userName,username);
		SendKeysWithClear(passWord,password);
		ClickOn(submit);

		//Assert.assertTrue(false);
	}

}
