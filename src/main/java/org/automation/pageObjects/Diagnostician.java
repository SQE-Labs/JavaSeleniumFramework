package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class Diagnostician extends BasePage {
    public By diagnosticianLink=By.xpath("//a[text()='Diagnosticians']");
    public By createDiagnostician=By.xpath("//button[text()='Create Diagnostician']");
    public By diagnostician_FirstName=By.xpath("//input[@placeholder='First Name']");
    public By diagnostician_LastName=By.xpath("//input[@placeholder='Last Name']");
    public By diagnostician_MobileNumber=By.xpath("//input[@placeholder='(999) 999-9999']");
    public By diagnostician_Email=By.xpath("//input[@placeholder='Email']");
    public By assignLocation=By.xpath("//select[@id='testingLocation']");
    public By locationName=By.xpath("//option[text()='Plano']");
    public By userName=By.xpath("//input[@placeholder='Username']");
    public By password_Field=By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField=By.xpath("//input[@placeholder='Confirm Password']");
    public By createDiagnosticianButton=By.xpath("//button[text()='Create Diagnostician']");
    public By logOutLink=By.xpath("//a[text()='Log Out']");
    public static By actualText=By.xpath("(//td)[2]");
    public By backButton=By.xpath("//button[text()='Back']");
    public static By diagnosticianListPage=By.xpath("//h3[text()='Diagnosticians List']");
    public By filterButton=By.xpath("//a[text()='Filter']");
    public By searchField=By.xpath("//input[@id='filterSearch']");

    //+++++++++++++EDIT Diagnostician+++++++++++++++

    public By editButton=By.xpath("(//a[text()='Edit'])[1]");
    public By cellNumber=By.xpath("//input[@placeholder='Cell Number']");
    public By updateButton=By.xpath("//button[text()='Update']");
    public static By edited_CellNumber=By.xpath("(//td[text()='(245) 678-9548'])[1]");
    public By toggle=By.xpath("//span[@class='slider round']");


    public void click_DiagnosticianLink(){

        click_custom(diagnosticianLink);
    }
    public void click_createDiagnosticianButton(){
        click_custom(createDiagnostician);
    }

    public void enter_diagnostician_FirstName(String CustomerFirstName) throws InterruptedException {
        Thread.sleep(2000);
        sendKeys_withClear(diagnostician_FirstName,CustomerFirstName);
    }
    public void enter_diagnostician_LastName(String CustomerLastName){
        sendKeys_withClear(diagnostician_LastName,CustomerLastName);
    }
    public void enter_Diagnostician_MobileNumber(String diagnostician_MobileNumberText){
        sendKeys_withClear(diagnostician_MobileNumber,diagnostician_MobileNumberText);
    }
    public void enter_Diagnostician_Email(String diagnostician_EmailText){
        sendKeys_withClear(diagnostician_Email,diagnostician_EmailText);
    }
    public void click_AssignLocation(){
        click_custom(assignLocation);
        click_custom(locationName);
    }
    public void userNameField(String userNameText){
        sendKeys_withClear(userName,userNameText);
    }
    public void create_passwordField(String passwordFieldText){
        sendKeys_withClear(password_Field,passwordFieldText);
    }
    public void confirm_PasswordField(String confirmPasswordText)
    {
        sendKeys_withClear(confirm_PasswordField,confirmPasswordText);
    }
    public void clickOn_createDiagnosticianButton(){
        click_custom(createDiagnosticianButton);
    }
    public void click_LogOutLink(){
        click_custom(logOutLink);
    }
    public void click_Back_Button() {
        click_custom(backButton);
    }
    public void click_filterButton(){
        click_custom(filterButton);
    }
    public void enterInSearchField(String searchFieldText){
        sendKeys_withClear(searchField,searchFieldText);
    }

    //+++++++++++++++++EDIT DIAGNOSTICIAN++++++++++++++

    public void click_On_EditButton(){
        click_custom(editButton);
    }
    public void enter_CellNumber(String cellNumberText){
        sendKeys_withClear(cellNumber,cellNumberText);
    }
    public void click_UpdateButton(){
        click_custom(updateButton);
    }
    public void off_ToggleButton(){
        click_custom(toggle);
    }




    public void create_Diagnostician(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName, String PasswordText, String RePassword) throws InterruptedException {
        Thread.sleep(10000);
        click_DiagnosticianLink();
        Thread.sleep(5000);
        click_createDiagnosticianButton();
        enter_diagnostician_FirstName(CustomerFirstName);
        enter_diagnostician_LastName(CustomerLastName);
        enter_Diagnostician_MobileNumber(diagnostician_MobileNumberText);
        enter_Diagnostician_Email(EmailAddress);
        click_AssignLocation();
        userNameField(UserName);
        create_passwordField(PasswordText);
        confirm_PasswordField(RePassword);
        clickOn_createDiagnosticianButton();
        Thread.sleep(4000);
      //  click_LogOutLink();
    }
public void diagnostician_ListPage() throws InterruptedException {
    click_createDiagnosticianButton();
    Thread.sleep(5000);
    click_Back_Button();
}
public void search_CreatedDiagnostician(String UserName) throws InterruptedException {
        Thread.sleep(3000);
    click_filterButton();
    enterInSearchField(UserName);
}
public void edit_Diagnostician(String cellNumberText){
    click_On_EditButton();
    enter_CellNumber(cellNumberText);
    click_UpdateButton();
}
public void disable_Diagnostician() throws InterruptedException {
        Thread.sleep(4000);
    click_On_EditButton();
    off_ToggleButton();
    click_UpdateButton();
}
}
