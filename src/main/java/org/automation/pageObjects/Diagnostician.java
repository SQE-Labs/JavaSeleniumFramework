package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;



public class Diagnostician extends BasePage {
    public By diagnosticianLink = By.xpath("//a[text()='Diagnosticians']");
    public By createDiagnostician = By.xpath("//button[text()='Create Diagnostician']");
    public By diagnostician_FirstName = By.xpath("//input[@placeholder='First Name']");
    public By diagnostician_LastName = By.xpath("//input[@placeholder='Last Name']");
    public By diagnostician_MobileNumber = By.xpath("//input[@placeholder='(999) 999-9999']");
    public By diagnostician_Email = By.xpath("//input[@placeholder='Email']");
    public By assignLocation = By.xpath("//select[@id='testingLocation']");
    public By locationName = By.xpath("//option[text()='Plano']");
    public By userName = By.xpath("//input[@placeholder='Username']");
    public By password_Field = By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    public By createDiagnosticianButton = By.xpath("//button[text()='Create Diagnostician']");
    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public static By actualText = By.xpath("(//td)[2]");
    public By backButton = By.xpath("//button[text()='Back']");
    public static By diagnosticianDashBoardPage = By.xpath("//h3[text()='Dashboard']");



    //**************Search created diagnostician*************

    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");

    //+++++++++++++EDIT Diagnostician+++++++++++++++

    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[text()='Update']");
    public By enableToggle=By.xpath("//label[text()='Enable User']");

    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public static By edit_Succ_Msg = By.xpath("//div[text()=' Diagnostician details updated successfully. ']");
    public static By UserNameGetText=By.xpath("(//td)[2]");
    public static By disableUser=By.xpath("//label[text()='Enable User']");
    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton=By.xpath("//a[text()='Don’t Save']");

    //**************DIAGNOSTICIAN LOOGING IN WITH NEW PASSWORD*************

    public By userNameField = By.xpath("//input[@placeholder='Username']");
    public By PasswordField = By.xpath("//input[@placeholder='Password']");
    public By login = By.id("loginFormSubmit");
    public static By validation_Msg=By.xpath("//small[text()='Username or password is incorrect']");


    public void click_DiagnosticianLink() {

        click_custom(diagnosticianLink);
    }

    public void click_createDiagnosticianButton() {
        click_custom(createDiagnostician);
    }

    public void enter_diagnostician_FirstName(String CustomerFirstName) throws InterruptedException {
        Thread.sleep(2000);
        sendKeys_withClear(diagnostician_FirstName, CustomerFirstName);
    }

    public void enter_diagnostician_LastName(String CustomerLastName) {
        sendKeys_withClear(diagnostician_LastName, CustomerLastName);
    }

    public void enter_Diagnostician_MobileNumber(String diagnostician_MobileNumberText) {
        sendKeys_withClear(diagnostician_MobileNumber, diagnostician_MobileNumberText);
    }

    public void enter_Diagnostician_Email(String diagnostician_EmailText) {
        sendKeys_withClear(diagnostician_Email, diagnostician_EmailText);
    }


    public void click_AssignLocation() {
        click_custom(assignLocation);
        click_custom(locationName);
    }

    public void userNameField(String userNameText) {
        sendKeys_withClear(userName, userNameText);
    }

    public void create_passwordField(String passwordFieldText) {
        sendKeys_withClear(password_Field, passwordFieldText);
    }

    public void confirm_PasswordField(String confirmPasswordText) {
        sendKeys_withClear(confirm_PasswordField, confirmPasswordText);
    }

    public void clickOn_createDiagnosticianButton() {
        click_custom(createDiagnosticianButton);
    }

    public void click_LogOutLink() {
        click_custom(logOutLink);
    }

    public void click_Back_Button() {
        click_custom(backButton);
    }

    //*************search created diagnostician***************

    public void click_filterButton() {
        click_custom(filterButton);
    }

    public void enterInSearchField(String searchFieldText) {
        sendKeys_withClear(searchField, searchFieldText);
    }

    //+++++++++++++++++EDIT DIAGNOSTICIAN++++++++++++++

    public void click_On_EditButton() {
        click_custom(editButton);
    }

    public void enter_CellNumber(String cellNumberText) {
        sendKeys_withClear(cellNumber, cellNumberText);
    }

    public void click_UpdateButton() {
        click_custom(updateButton);
    }


    public void off_ToggleButton() {
        click_custom(toggle);
    }

    public void enter_Diagnostician_Email1(String diagnostician_EmailText1) {
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void clickOn_PasswordField(String passwordTextFieldText) {
        sendKeys_withClear(passwordTextField, passwordTextFieldText);
    }

    public void clickOn_confirmPasswordFieldField(String confirmPasswordFieldText) {
        sendKeys_withClear(confirmPasswordField, confirmPasswordFieldText);
    }
    public void clickOn_DontSave()
    {
        click_custom(dontSaveButton);
    }

    //**********DIAGNOSTICIAN LOGGING IN WITH NEW PASSWORD************
    public void clickOn_Login_UsernameField(String userNameFieldText) {
        sendKeys_withClear(userNameField, userNameFieldText);
    }

    public void clickOn_Login_PasswordField(String PasswordFieldText) {
        sendKeys_withClear(PasswordField, PasswordFieldText);
    }

    public void clickOn_Login_Button() {
        click_custom(login);
    }


    public void create_Diagnostician(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName, String PasswordText, String RePassword) throws InterruptedException {
        Thread.sleep(12000);
        click_DiagnosticianLink();
        Thread.sleep(5000);
        click_createDiagnosticianButton();
        Thread.sleep(4000);
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
         click_LogOutLink();
    }

    public void diagnostician_ListPage() throws InterruptedException {
        click_createDiagnosticianButton();
        Thread.sleep(5000);
        click_Back_Button();
    }

    public void search_CreatedDiagnostician(String UserName) throws InterruptedException {
        click_filterButton();
        enterInSearchField(UserName);
    }

    public void edit_Diagnostician(String cellNumberText, String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();

        Thread.sleep(3000);
        enter_CellNumber(cellNumberText);
        enter_Diagnostician_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }

    public void cheking_DisableUser() throws InterruptedException {
        click_On_EditButton();
        Thread.sleep(4000);
        clickOn_DontSave();
        click_On_EditButton();
        Thread.sleep(4000);
        clickOn_DontSave();
    }
    public void enable_DiagnosticianUser() throws InterruptedException {
        Thread.sleep(4000);
        click_On_EditButton();
        off_ToggleButton();
        click_UpdateButton();

    }

    public void Relogin_With_newPassword(String userNameFieldText, String PasswordFieldText) throws InterruptedException {
        Thread.sleep(6000);
        click_LogOutLink();
        clickOn_Login_UsernameField(userNameFieldText);
        clickOn_Login_PasswordField(PasswordFieldText);
        clickOn_Login_Button();
    }

    public void Relogin_With_OldPassword(String userNameFieldText, String PasswordFieldText) throws InterruptedException {
        Thread.sleep(6000);
        click_LogOutLink();
        clickOn_Login_UsernameField(userNameFieldText);
        clickOn_Login_PasswordField(PasswordFieldText);
          clickOn_Login_Button();
    }
    public void not_Edit_Diagnostician(String cellNumberText, String EmailAddress1, String passwordTextFieldText,String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        Thread.sleep(5000);
        enter_CellNumber(cellNumberText);
        enter_Diagnostician_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        clickOn_DontSave();
        Thread.sleep(6000);
    }
}
