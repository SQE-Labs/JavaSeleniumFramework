package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import test.SuperAdminTest;


public class LoginPage extends BasePage {

    public By userNameField = By.xpath("//input[@placeholder='Username']");
    public By PasswordField = By.xpath("//input[@placeholder='Password']");
    public By login = By.id("loginFormSubmit");
    public void enterUsername(String userNameText) {
        sendKeys_withClear(userNameField, userNameText);
    }

    public void enterPassword(String passNameText) {
        sendKeys_withClear(PasswordField, passNameText);
    }

    public void clickLoginBtn() {
        clickBtn_custom(login);
    }


    public void superAdminLogin()   {
        sendKeys_withClear(userNameField, PropertiesUtil.getPropertyValue("userName"));
        sendKeys_withClear(PasswordField, PropertiesUtil.getPropertyValue("password"));
        clickBtn_custom(login);
    }
    public void diagnosticianLogin( String username,String PasswordFieldText ) throws InterruptedException {
        enterUsername(username);
        enterPassword(PasswordFieldText);
        click_custom(login);
    }
    public void adminLogin(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
    }
    public void directorLogin(String userNameFieldText, String PasswordFieldText){
        enterUsername(userNameFieldText);
        enterPassword(PasswordFieldText);
        click_custom(login);
    }

}
