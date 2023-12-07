package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.PropertiesUtil;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {

    public By userNameField = By.xpath("//input[@placeholder='Username']");
    public By PasswordField = By.xpath("//input[@placeholder='Password']");
    public By login = By.id("loginFormSubmit");



    public void enterUsername(String userNameText) {
        sendKeys_custom(userNameField, userNameText);
    }

    public void enterPassword(String passNameText) {
        sendKeys_custom(PasswordField, passNameText);
    }

    public void clickLoginBtn() {
        clickBtn_custom(login);
    }

    public void validLogin()   {
        sendKeys_custom(userNameField, PropertiesUtil.getPropertyValue("userName"));
        sendKeys_custom(PasswordField, PropertiesUtil.getPropertyValue("password"));
        clickBtn_custom(login);
    }

}
