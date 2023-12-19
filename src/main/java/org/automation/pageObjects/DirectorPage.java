package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.logger.Log;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import static org.automation.utilities.Assertions.validate_text;


public class DirectorPage extends BasePage {
    WebdriverWaits wait = new WebdriverWaits();
    public By directorsTab = By.xpath("//li[@id='Directors']");
    public By createDirectorButton = By.xpath("//button[text()='Create Director']");
    public By directorsFirstName = By.xpath("//input[@placeholder='First Name']");
    public By directorsLastName = By.xpath("//input[@placeholder='Last Name']");
    public By directorsMobileNumber = By.xpath("//input[@placeholder='(999) 999-9999']");
    public By directorsEmail = By.xpath("//input[@placeholder='Email']");
    public By assignLocation = By.xpath("//select[@id='testingLocation']");
    public By directorsLocationName = By.xpath("//option[text()='Plano']");
    public By directorsUserName = By.xpath("//input[@placeholder='Username']");
    public By password_Field = By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    public By createDirectorsButton = By.xpath("//button[text()='Create Director']");
    public By validationMsg = By.xpath("//div[text()=' An error occurred while creating the admin. Username already exists! ']");

    //**************Search created director***************
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");
    public By actualText = By.xpath("(//td)[2]");

    //****************edit created director**************

    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[text()='Update']");
    public By enableToggle = By.xpath("//label[text()='Enable User']");
    public By directorListPage = By.xpath("//h3[text()='Directors List']");

    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public By edit_SuccMsg = By.xpath("//div[text()=' Director details updated successfully. ']");
    public By UserNameGetText = By.xpath("(//td)[2]");
    public By disableUser = By.xpath("//label[text()='Enable User']");
    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton = By.xpath("//a[text()='Don’t Save']");
    public By edit_Popup = By.xpath("//h5[text()='Edit User']");
    public By enableUser = By.xpath("//label[text()='Enable User']");
    public By dashboardPage = By.xpath("//h3[text()='Dashboard']");
    public By viewAll = By.xpath("//a[text()='View All']");
    public By setAvailability = By.xpath("//h3[text()='Set Availability']");
    public By monthHeader = By.xpath("//span[text()=' December ']");
    public By yearHeader = By.xpath("//span[text()=' 2023 ']");
    public By dateHeader = By.xpath("//div[@class='mbsc-ios mbsc-ltr mbsc-schedule-header-day mbsc-schedule-header-day-today mbsc-selected ng-star-inserted']");
    public By yearsCalender = By.xpath("//mbsc-button[text()=' 2023 - 2034 ']");
    public By hihglihgtedYear=By.xpath("(//div[@class='mbsc-calendar-cell-text mbsc-calendar-year-text mbsc-ios ng-star-inserted'])[13]");
    public By clickOnBox=By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[9]");
    public By clickOnBox1=By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[10]");
    public By clickOnBox2=By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[11]");
    public By clickOnBox3=By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[12]");
    public By clickOnBox4=By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[13]");
    public By clickOnBox5=By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[14]");
   public By clickOnBox6=By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[15]");
    public By availableText=By.xpath("//div[text()='Available']");
    public By saveButton=By.xpath("//button[text()='Save']");


    //**************relogin with new password***********

    public By userNameField = By.xpath("//input[@placeholder='Username']");
    public By PasswordField = By.xpath("//input[@placeholder='Password']");
    public By login = By.id("loginFormSubmit");
    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public By directorDashBoardPage = By.xpath("//h3[text()='Dashboard']");
    public By validation_Msg = By.xpath("//small[text()='Username or password is incorrect']");
    public By loginLoading = By.cssSelector("div.ngx-spinner-overlay");


    public void click_DirectorTab() throws InterruptedException {
        WebdriverWaits.SwitchToNewTab();
        WebdriverWaits.WaitUntilVisible(directorsTab);
        WebdriverWaits.WaitUntilInvisible(loginLoading);

        click_custom(directorsTab);
    }

    public void click_CreateDirectorsButton() {
        WebdriverWaits.WaitUntilVisible(createDirectorButton);
        WebdriverWaits.WaitUntilInvisible(loginLoading);
        //  wait.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));

        click_custom(createDirectorButton);
    }

    public void click_directorsFirstNameField(String directorsFirstNameText) {
        WebdriverWaits.WaitUntilVisible(directorsFirstName);
        sendKeys_withClear(directorsFirstName, directorsFirstNameText);
    }

    public void click_directorsLastNameField(String directorsLastNameText) {
        WebdriverWaits.WaitUntilVisible(directorsLastName);
        sendKeys_withClear(directorsLastName, directorsLastNameText);
    }

    public void click_directorsMobileNumberField(String directorsMobileNumberText) {
        WebdriverWaits.WaitUntilVisible(directorsMobileNumber);
        sendKeys_withClear(directorsMobileNumber, directorsMobileNumberText);
    }

    public void click_directorsdirectorsEmailField(String directorsEmailText) {
        WebdriverWaits.WaitUntilVisible(directorsEmail);
        sendKeys_withClear(directorsEmail, directorsEmailText);
    }

    public void click_directorsassignLocationField() {
        WebdriverWaits.WaitUntilVisible(assignLocation);
        click_custom(assignLocation);
        WebdriverWaits.WaitUntilVisible(directorsLocationName);
        click_custom(directorsLocationName);
    }

    public void click_directorsUserNameField(String directorsUserNameText) {
        WebdriverWaits.WaitUntilVisible(directorsUserName);
        sendKeys_withClear(directorsUserName, directorsUserNameText);
    }
    public void click_LogOutLink() {
          WebdriverWaits.WaitUntilInvisible(logOutLink);
        WebdriverWaits.WaitUntilVisible(logOutLink);
        click_custom(logOutLink);
    }

    public void click_passwordField(String password_FieldText) {
        WebdriverWaits.WaitUntilVisible(password_Field);
        sendKeys_withClear(password_Field, password_FieldText);
    }

    public void click_confirmPasswordField(String confirmPasswordFieldText) {
        sendKeys_withClear(confirm_PasswordField, confirmPasswordFieldText);
    }

    public void click_createDirectorButton() {
        click_custom(createDirectorsButton);
    }

    //***************search created diagnostician******************

    public void click_filterButton() {
        WebdriverWaits.WaitUntilVisible(filterButton);
        click_custom(filterButton);
    }

    public void enterInSearchField(String searchFieldText) {
        sendKeys_withClear(searchField, searchFieldText);
    }

    //***************edit created director*****************
    public void click_On_EditButton() {
        WebdriverWaits.WaitUntilVisible(editButton);
        click_custom(editButton);
    }

    public void enter_CellNumber(String cellNumberText) {
        WebdriverWaits.WaitUntilVisible(cellNumber);
        sendKeys_withClear(cellNumber, cellNumberText);
    }

    public void click_UpdateButton() {
        click_custom(updateButton);
    }


    public void off_ToggleButton() {
        click_custom(toggle);
    }

    public void enter_Director_Email1(String diagnostician_EmailText1) {
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void clickOn_PasswordField(String passwordTextFieldText) {
        sendKeys_withClear(passwordTextField, passwordTextFieldText);
    }

    public void clickOn_confirmPasswordField(String confirmPasswordFieldText) {
        sendKeys_withClear(confirmPasswordField, confirmPasswordFieldText);
    }

    public void clickOn_DontSave() {
        WebdriverWaits.WaitUntilVisible(dontSaveButton);
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


    public void clickOn_YearHeader(){
        wait.WaitUntilVisible(yearHeader);
        click_custom(yearHeader);
    }
    public void clickOn_availableBox(){
        WebdriverWaits.WaitUntilVisible(clickOnBox);
        click_custom(clickOnBox);
        click_custom(clickOnBox1);
        click_custom(clickOnBox2);
        click_custom(clickOnBox3);
        click_custom(clickOnBox4);
        click_custom(clickOnBox5);
        click_custom(clickOnBox6);
    }
    public void clickOn_SaveButton(){
        WebdriverWaits.WaitUntilVisible(saveButton);
        click_custom(saveButton);
    }






    //*********Create director**************
    public void create_Director(String directorsFirstNameText, String directorsLastNameText, String directorsMobileNumberText, String directorsEmailText, String directorsUserNameText, String password_FieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_CreateDirectorsButton();
        click_directorsFirstNameField(directorsFirstNameText);
        click_directorsLastNameField(directorsLastNameText);
        click_directorsMobileNumberField(directorsMobileNumberText);
        click_directorsdirectorsEmailField(directorsEmailText);
        click_directorsassignLocationField();
        click_directorsUserNameField(directorsUserNameText);
        click_passwordField(password_FieldText);
        click_confirmPasswordField(confirmPasswordFieldText);
        click_createDirectorButton();
    }

    public void Verify_Duplicate_Director(String directorsFirstNameText, String directorsLastNameText, String directorsMobileNumberText, String directorsEmailText, String directorsUserNameText, String password_FieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_CreateDirectorsButton();
        click_directorsFirstNameField(directorsFirstNameText);
        click_directorsLastNameField(directorsLastNameText);
        click_directorsMobileNumberField(directorsMobileNumberText);
        click_directorsdirectorsEmailField(directorsEmailText);
        click_directorsassignLocationField();
        click_directorsUserNameField(directorsUserNameText);
        click_passwordField(password_FieldText);
        click_confirmPasswordField(confirmPasswordFieldText);
        click_createDirectorButton();
    }


    //**************Search created director*************
    public void search_CreatedDirector(String UserName) throws InterruptedException {
        click_filterButton();
        enterInSearchField(UserName);
    }

    //***********edit created director*************
    public void edit_Director(String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        // test case number ( 4.6 ).
        Assertions.validate_text(edit_Popup, "Edit User");
        Log.info("Successfully Edit popUp opens");
        // enter_CellNumber(cellNumberText);
        enter_Director_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }

    //********Cheking toggole off of directore*************

    public void cheking_DisableUser() throws InterruptedException {
        click_On_EditButton();
        clickOn_DontSave();
        click_On_EditButton();
        clickOn_DontSave();
    }

    //********Enable user of director************
    public void enable_Director() throws InterruptedException {
        click_On_EditButton();
        off_ToggleButton();
        click_UpdateButton();
    }
    //**************Not Editing created director**************

    public void not_Edit_Director(String cellNumberText, String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        enter_CellNumber(cellNumberText);
        enter_Director_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordField(confirmPasswordFieldText);
        clickOn_DontSave();
        Thread.sleep(6000);
    }

    //***********Relogin using new password*************

    public void Relogin_With_newPassword(String userNameFieldText, String PasswordFieldText) throws InterruptedException {
        click_LogOutLink();
        clickOn_Login_UsernameField(userNameFieldText);
        clickOn_Login_PasswordField(PasswordFieldText);
        clickOn_Login_Button();
    }

    //************director login with old Password***********
    public void directorRelogin_With_OldPassword(String userNameFieldText, String PasswordFieldText) throws InterruptedException {
        click_LogOutLink();
        clickOn_Login_UsernameField(userNameFieldText);
        clickOn_Login_PasswordField(PasswordFieldText);
        clickOn_Login_Button();
    }
public void director_Availability() throws InterruptedException {

    clickOn_YearHeader();
    WebdriverWaits.WaitUntilVisible(yearsCalender);
    validate_text(yearsCalender, "2023 - 2034");
    WebdriverWaits.WaitUntilVisible(hihglihgtedYear);
    validate_text(hihglihgtedYear, "2023");
    clickOn_YearHeader();
    clickOn_availableBox();
    WebdriverWaits.WaitUntilVisible(availableText);
    validate_text(availableText, "Available");
    clickOn_SaveButton();

}
}
