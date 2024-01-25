package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.logger.Log;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class DirectorPage extends BasePage {

    WebdriverWaits wait = new WebdriverWaits();

    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public By directorsTab = By.xpath("//a[text()='Directors']");

    public By createDirectorButton = By.xpath("//button[text()='Create Director']");
    public By directorActualText = By.xpath("//h3[text()='Directors List']");
    public By directorsFirstName = By.xpath("//input[@placeholder='First Name']");
    public By directorsLastName = By.xpath("//input[@placeholder='Last Name']");
    public By directorsMobileNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By directorsEmail = By.xpath("//input[@placeholder='Email']");
    public By assignLocation = By.xpath("//select[@id='testingLocation']");
    public By directorsLocationName = By.xpath("//option[text()='Austin']");
    public By directorsUserName = By.xpath("//input[@placeholder='Username']");
    public By password_Field = By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    public By createDirectorsButton = By.xpath("//button[text()='Create Director']");

    //**************Search created director***************
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");


    //****************edit created director**************

    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[text()='Update']");

    public By directorListPage = By.xpath("//h3[text()='Directors List']");

    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public By edit_SuccMsg = By.xpath("//div[text()=' Director details updated successfully. ']");
    public By UserNameGetText = By.xpath("(//td)[2]");

    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton = By.xpath("//a[text()='Don’t Save']");
    public By edit_Popup = By.xpath("//h5[text()='Edit User']");
    public By enableUser = By.xpath("//label[text()='Enable User']");
    public By dashboardPage = By.xpath("//h3[text()='Dashboard']");
    public By viewAll = By.xpath("//a[text()='View All']");


    public By monthHeader = By.xpath("//span[@class='mbsc-calendar-month mbsc-calendar-title mbsc-ios ng-star-inserted']");
    public By yearHeader = By.xpath("//span[@class='mbsc-calendar-title mbsc-calendar-year mbsc-ios ng-star-inserted']");
    public By dateHeader = By.xpath("//div[@class='mbsc-ios mbsc-ltr mbsc-schedule-header-day mbsc-selected ng-star-inserted']']");

    public By yearsCalender = By.xpath("//mbsc-button[text()=' 2023 - 2034 ']");
    public By hihglihgtedYear = By.xpath("(//div[@class='mbsc-calendar-cell-text mbsc-calendar-year-text mbsc-ios ng-star-inserted'])[13]");
    public By clickOnBox = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[23]");
    public By clickOnBox1 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[24]");
    public By clickOnBox2 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[25]");
    public By clickOnBox3 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[26]");
    public By clickOnBox4 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[27]");
    public By clickOnBox5 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[28]");
    public By clickOnBox6 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[29]");
    // public By clickOnBox6=By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[21]");
    public By availableText = By.xpath("//div[text()='Available']");
    public By saveButton = By.xpath("//button[text()='Save']");
    public By validationMsg = By.xpath("//div[@class='alert alert-danger ng-star-inserted']");
    public By deletedSlot = By.xpath("//*[@id=\"diagnoSetAvailabilityForm\"]/div[1]/mbsc-eventcalendar/mbsc-calendar-view/mbsc-scheduler/div[3]/div[2]/div/div/div[5]/div/div[1]/mbsc-schedule-event[3]/div[3]/div[1]/div");
    public By deleteButton = By.xpath("//*[@class='btn btn-danger mbsc-button mbsc-button-flat mbsc-font mbsc-ios mbsc-ltr mbsc-popup-button mbsc-popup-button-center mbsc-popup-button-flex mbsc-reset ng-star-inserted']");
    public By cancelButton = By.xpath("/html/body/div/div[3]/div[2]/div[3]/mbsc-button[1]");

    public By selectYear = By.xpath("//div[text()=' 2023 ']");
    public By selectMonth = By.xpath("(//div[text()=' Dec '])[2]");


    //**************relogin with new password***********

    public By userNameField = By.xpath("//input[@placeholder='Username']");
    public By PasswordField = By.xpath("//input[@placeholder='Password']");
    public By login = By.id("loginFormSubmit");
    public By directorDashBoardPage = By.xpath("//h3[text()='Dashboard']");
    public By validation_Msg = By.xpath("//small[text()='Username or password is incorrect']");

    public By spinner = By.cssSelector("div.ngx-spinner-overlay");
    public By setAvailaibility = By.xpath("//h3[text()='Set Availability']");
    public By slotSelection = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[34]");
    public By validateAvailable = By.xpath("(//div[@class='ng-star-inserted'])[15]");
    public By avail_SaveButton = By.id("diagnoSetAvailabilitySubmit");
    public By signInToYourAccountTxt = By.xpath("//h3[text()='Sign in to your account']");
    public By today = By.xpath("//mbsc-button[@aria-label='Today']");


    //*****************Paying full payment*****************


    public void click_AvailaibleSlot() {
        WebdriverWaits.waitUntilVisible(spinner);
        WebdriverWaits.waitForSpinner();
        click_custom(slotSelection);

    }

    public void click_LogOutLink() {
        WebdriverWaits.waitUntilVisible(logOutLink);
        WebdriverWaits.waitForSpinner();
        click_custom(logOutLink);
    }

    public void click_CancelButton() {
        WebdriverWaits.waitForSpinner();
        click_custom(cancelButton);
    }

    public void click_DeleteSlot() {
        WebdriverWaits.waitUntilVisible(spinner);
        WebdriverWaits.waitForSpinner();
        click_custom(deletedSlot);
    }

    public void click_DeleteButton() {
        WebdriverWaits.waitForSpinner();
        click_custom(deleteButton);
    }

    public void click_SaveBtn() {
        WebdriverWaits.waitForSpinner();
        click_custom(avail_SaveButton);
    }

    public void click_CreateDirectorsButton() {
        WebdriverWaits.waitForSpinner();
        click_custom(createDirectorButton);
    }

    public void click_directorsFirstNameField(String directorsFirstNameText) {
        WebdriverWaits.waitUntilVisible(directorsFirstName);
        sendKeys_withClear(directorsFirstName, directorsFirstNameText);
    }

    public void click_directorsLastNameField(String directorsLastNameText) {
        WebdriverWaits.waitUntilVisible(directorsLastName);
        sendKeys_withClear(directorsLastName, directorsLastNameText);
    }

    public void click_directorsMobileNumberField(String directorsMobileNumberText) {
        WebdriverWaits.waitUntilVisible(directorsMobileNumber);
        sendKeys_withClear(directorsMobileNumber, directorsMobileNumberText);
    }

    public void click_directorsdirectorsEmailField(String directorsEmailText) {
        WebdriverWaits.waitUntilVisible(directorsEmail);
        sendKeys_withClear(directorsEmail, directorsEmailText);
    }

    public void click_directorsassignLocationField() {
        WebdriverWaits.waitUntilVisible(assignLocation);
        click_custom(assignLocation);
        WebdriverWaits.waitUntilVisible(directorsLocationName);
        click_custom(directorsLocationName);
    }

    public void click_directorsUserNameField(String directorsUserNameText) {
        WebdriverWaits.waitUntilVisible(directorsUserName);
        sendKeys_withClear(directorsUserName, directorsUserNameText);
    }

    public void click_passwordField(String password_FieldText) {
        WebdriverWaits.waitUntilVisible(password_Field);
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
        WebdriverWaits.waitUntilVisible(filterButton);
        click_custom(filterButton);
    }

    public void enterInSearchField(String searchFieldText) {
        sendKeys_withClear(searchField, searchFieldText);
    }

    public void click_SaveButton() {
        click_custom(saveButton);
    }

    //***************edit created director*****************
    public void click_EditButton() {
        WebdriverWaits.waitUntilVisible(editButton);
        click_custom(editButton);
    }

    public void enter_CellNumber(String cellNumberText) {
        WebdriverWaits.waitUntilVisible(cellNumber);
        sendKeys_withClear(cellNumber, cellNumberText);
    }

    public void click_UpdateButton() {
        click_custom(updateButton);
    }

    public void clickOn_YearHeader() {
        click_custom(yearHeader);
    }

    public void clickOn_MonthHeader() {
        WebdriverWaits.waitUntilVisible(monthHeader);
        click_custom(monthHeader);
    }

    public void select_Year() {
        WebdriverWaits.waitUntilVisible(selectYear);
        click_custom(selectYear);

    }

    public void select_Month() {
        WebdriverWaits.waitUntilVisible(selectMonth);
        click_custom(selectMonth);

    }

    public void off_ToggleButton() {
        WebdriverWaits.waitUntilVisible(toggle);
        click_custom(toggle);
    }

    public void enter_Director_Email1(String diagnostician_EmailText1) {
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void click_PasswordField(String passwordTextFieldText) {
        sendKeys_withClear(passwordTextField, passwordTextFieldText);
    }


    public void click_DontSave() {
        click_custom(dontSaveButton);
    }


    //**********DIAGNOSTICIAN LOGGING IN WITH NEW PASSWORD************
    public void click_Login_UsernameField(String userNameFieldText) {
        sendKeys_withClear(userNameField, userNameFieldText);
    }

    public void click_Login_PasswordField(String PasswordFieldText) {
        sendKeys_withClear(PasswordField, PasswordFieldText);
    }

    public void click_Login_Button() {
        click_custom(login);
    }

    public void clickOn_availableBox() {
        click_custom(clickOnBox);
        click_custom(clickOnBox1);
        click_custom(clickOnBox2);
        click_custom(clickOnBox3);
        click_custom(clickOnBox4);
        click_custom(clickOnBox5);
        click_custom(clickOnBox6);
    }

//    public void click_LogOutLink() {
//        WebdriverWaits.waitUntilVisible(logOutLink);
//        click_custom(logOutLink);
//    }


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


    //**************Search created director*************
    public void search_CreatedDirector(String UserName) throws InterruptedException {
        click_filterButton();
        enterInSearchField(UserName);
    }

    //***********edit created director*************
    public void edit_Director(String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_EditButton();
        // test case number ( 4.6 ).
        Assertions.validate_text(edit_Popup, "Edit User");
        Log.info("Successfully Edit popUp opens");
        enter_Director_Email1(EmailAddress1);
        click_PasswordField(passwordTextFieldText);
        click_confirmPasswordField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }

    //********Cheking toggole off of directore*************

    public void cheking_DisableUser() {
        click_EditButton();
        click_DontSave();
        click_EditButton();
        click_DontSave();
    }

    //********Enable user of director************
    public void enable_Director() {
        click_EditButton();
        off_ToggleButton();
        click_UpdateButton();
    }
    //**************Not Editing created director**************

    public void not_Edit_Director(String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_EditButton();
        enter_Director_Email1(EmailAddress1);
        click_PasswordField(passwordTextFieldText);
        click_confirmPasswordField(confirmPasswordFieldText);
        click_DontSave();
        Thread.sleep(6000);
    }

    //***********Relogin using new password*************

    public void Relogin_With_newPassword(String userNameFieldText, String PasswordFieldText) throws InterruptedException {
        click_LogOutLink();
        click_Login_UsernameField(userNameFieldText);
        click_Login_PasswordField(PasswordFieldText);
        click_Login_Button();
    }

    //************director login with old Password***********
    public void directorRelogin_With_OldPassword(String userNameFieldText, String PasswordFieldText) throws InterruptedException {
        click_LogOutLink();
        click_Login_UsernameField(userNameFieldText);
        click_Login_PasswordField(PasswordFieldText);
        click_Login_Button();
    }

    public void director_Availability() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted']"));
        System.out.println(list.size());
        for (WebElement box : list) {
            Thread.sleep(2000);
            click_custom(box);
            if (getDriver().findElements(By.xpath("//div[@class='ng-star-inserted']")).size() > 2) {
                if (getDriver().findElement(By.xpath("//div[@class='ng-star-inserted']")).getText().equals("Available")) {
                    break;
                }
            }

        }
        click_SaveButton();
    }
}





