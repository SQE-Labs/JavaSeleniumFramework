package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import static org.automation.utilities.WebdriverWaits.waitForElementVisible;

public class DirectorPage extends BasePage {
    public By directorsTab= By.xpath("//a[text()='Directors']");
    public By createDirectorButton=By.xpath("//button[text()='Create Director']");
    public By directorsFirstName=By.xpath("//input[@placeholder='First Name']");
    public By directorsLastName=By.xpath("//input[@placeholder='Last Name']");
    public By directorsMobileNumber=By.xpath("//input[@placeholder='(999) 999-9999']");
    public By directorsEmail=By.xpath("//input[@placeholder='Email']");
    public By assignLocation=By.xpath("//select[@id='testingLocation']");
    public By directorsLocationName=By.xpath("//option[text()='Plano']");
    public By directorsUserName=By.xpath("//input[@placeholder='Username']");
    public By password_Field=By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField=By.xpath("//input[@placeholder='Confirm Password']");
    public By createDirectorsButton=By.xpath("//button[text()='Create Director']");

    public void click_DirectorTab(){
//        WebdriverWaits.waitForElementVisible(createDirectorButton);
        click_custom(directorsTab);
    }
    public void click_CreateDirectorsButton(){
     //   WebdriverWaits.waitForElementVisible(createDirectorButton);
        click_custom(createDirectorButton);
    }
    public void click_directorsFirstNameField(String directorsFirstNameText){
        sendKeys_withClear(directorsFirstName,directorsFirstNameText);
    }
    public void click_directorsLastNameField(String directorsLastNameText){
        sendKeys_withClear(directorsLastName,directorsLastNameText);
    }
    public void click_directorsMobileNumberField(String directorsMobileNumberText){
        sendKeys_withClear(directorsMobileNumber,directorsMobileNumberText);
    }
    public void click_directorsdirectorsEmailField(String directorsEmailText){
        sendKeys_withClear(directorsEmail,directorsEmailText);
    }
    public void click_directorsassignLocationField( ){
       click_custom(assignLocation );
       click_custom(directorsLocationName);
    }
    public void click_directorsUserNameField(String directorsUserNameText){
        sendKeys_withClear(directorsUserName,directorsUserNameText);
    }
    public void click_passwordField(String password_FieldText){
        sendKeys_withClear(password_Field,password_FieldText);
    }
    public void click_confirmPasswordField(String confirmPasswordFieldText){
        sendKeys_withClear(confirm_PasswordField,confirmPasswordFieldText);
    }
    public void click_createDirectorButton(){
        click_custom(createDirectorsButton);
    }

    public void create_Director(String directorsFirstNameText,String directorsLastNameText,String directorsMobileNumberText,String directorsEmailText,String directorsUserNameText,String password_FieldText,String confirmPasswordFieldText) throws InterruptedException {
        Thread.sleep(10000);
        click_DirectorTab();
        Thread.sleep(4000);
        click_CreateDirectorsButton();
        Thread.sleep(4000);
        click_directorsFirstNameField(directorsFirstNameText);
        click_directorsLastNameField(directorsLastNameText);
        click_directorsMobileNumberField(directorsMobileNumberText);
        click_directorsdirectorsEmailField(directorsEmailText);
        Thread.sleep(2000);
        click_directorsassignLocationField( );
        click_directorsUserNameField(directorsUserNameText);
        click_passwordField(password_FieldText);
        click_confirmPasswordField(confirmPasswordFieldText);
        click_createDirectorButton();
    }

}
