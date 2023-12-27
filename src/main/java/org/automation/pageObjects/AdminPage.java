package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.automation.utilities.Assertions.validate_text;

public class AdminPage extends BasePage {
    public By adminTab = By.xpath("//a[text()='Admins']");
    public By createAdminButton = By.xpath("//button[text()='Create Admin']");
    public By loginLoading = By.cssSelector("div.ngx-spinner-overlay");
    public By admin_FirstName = By.xpath("//input[@placeholder='First Name']");
    public By admin_LastName = By.xpath("//input[@placeholder='Last Name']");
    public By admin_MobileNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By admin_Email = By.xpath("//input[@placeholder='Email']");
    public By assignLocation = By.xpath("//select[@id='testingLocation']");
    public By locationName = By.xpath("//option[text()='Plano']");
    public By userName = By.xpath("//input[@placeholder='Username']");
    public By password_Field = By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    public By createadminButton = By.xpath("//button[text()=' Create Admin ']");
    public By succ_Msg = By.xpath("//div[text()='Admin Created Successfully']");
    public By dashboardPage = By.xpath("//h3[text()='Admins List']");

    //**************Search created Admin*************

    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");
    public By actualText = By.xpath("(//td)[2]");

    //*****************Edit Admin with valid credentials****************
    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[text()='Update']");
    public By enableToggle = By.xpath("//label[text()='Enable User']");

    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public By Succ_Msg_Upd = By.xpath("//div[text()=' Admin details updated successfully. ']");
    public By UserNameGetText = By.xpath("(//td)[2]");
    public By enableUser = By.xpath("//label[text()='Enable User']");
    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton = By.xpath("//a[text()='Don’t Save']");
    public By editUserPop_Up = By.xpath("//h5[text()='Edit User']");
    public By userNameText = By.xpath("(//td[2])[1]");
    public By Error_Msg = By.xpath("//div[text()='An error occurred while creating the admin. Error: Username is already exist!']");

    //***********DASH BOARD PAGE**********
    public By dashboard = By.xpath("//h3[text()='Dashboard']");
    //*********** EDIT ASSESSMENT TYPE ********//
    public By editAss = By.xpath("//a[text()='Edit Assessment Type']");
    public By assType = By.xpath("//h5[text()='Change Assement Type']");
    public By assestmentType = By.xpath("//select[@id='assesmentType']");
    public By updateBtn = By.xpath("(//button[text()='Update'])[1]");
    public By spinner = By.cssSelector("div.ngx-spinner-overlay");
    public By clientAsses = By.xpath("//p[text()=' IQ']");
    public By dontSaveAsses = By.xpath("//a[text()='Don’t Save']");

    //***********Re-assign appointment************//
    public By reAssignbtn = By.xpath("//a[text()='Re-assign Appointment']");
    public By diag = By.id("diag");
    public By diagLoc = By.id("testingLocation");
    public By rebtn = By.xpath("//button[text()='Re-assign']");

    //****************Edit Client**************//
    public By testPlan = By.xpath("//button[text()=' Test Plan ']");
    public By editTestPlan= By.xpath("//button[text()=' Edit Test Plan ']");
    public By testPlanText = By.xpath("//h6[text()='Please choose tests.']");
    public By checkBox = By.xpath("//label[text()='WJ Achievement']/..");
    public By validateCheckBox = By.xpath("//p[text()=' WJ Achievement ']");
    public By famCheckBox = By.xpath("//label[text()='FAM']/..");
    public By nepsyCheckBox = By.xpath("//label[text()='NEPSY']/..");
    public By ndCheckBox = By.xpath("//label[text()='ND']/..");
    public By wmsCheckBox = By.xpath("//label[text()='WMS']/..");
    public By warlCheckBox= By.xpath("//label[text()='WRAML']/..");
    public By bascSelfCheckBox = By.xpath("//label[text()='BASC Self']/..");
    public By cbrsSelfCheckBox = By.xpath("//label[text()='CBRS Self']/..");
    public By dlsDyslexiaCheckBox = By.xpath("//label[text()='DLS Dyslexia']/..");
    public By testPlanSaveButton = By.xpath("//button[text()='Save']");
    public By actualEditTest = By.xpath("//p[text()=' WRAML ']");

    public By docgList = By.xpath("//span[text()='Active']/../../td[5][text()='Plano']/../td[1]");
    public By editClientBtn = By.xpath("//a[text()='Edit Client']");
    public By editCllientActualText = By.xpath("//h5[text()='Edit Client Info']");
    public By editFirstName = By.xpath(" //input[@formcontrolname='studentFirstName']");
    public By editLastName = By.xpath(" //input[@formcontrolname='studentLastName']");
    public By editParentName = By.xpath(" //input[@formcontrolname='parentName']");
    public By editDate = By.xpath(" //input[@formcontrolname='dateOfBirth']");
    public By editPhoneNumber = By.xpath(" //input[@formcontrolname='phoneNumber']");
    public By editCellNumber = By.xpath(" //input[@placeholder='Cell Number']");
    public By editEmail = By.xpath(" //input[@formcontrolname='emailAddress']");
    public By editEmail2 = By.xpath(" //input[@formcontrolname='secondaryEmailAddress']");
    public By editGrade = By.id("schoolType");
    public By editSchoolType = By.xpath(" //input[@formcontrolname='schoolType']");
    public By editDistrict = By.xpath(" //input[@formcontrolname='school']");
    public By editReason = By.id("reasonForCall");
    public By editAddress1 = By.xpath(" //input[@formcontrolname='address1']");
    public By editAddress2 = By.xpath(" //input[@formcontrolname='address2']");
    public By editCity = By.xpath(" //input[@formcontrolname='city']");
    public By editState = By.xpath(" //input[@formcontrolname='state']");
    public By editZipCode = By.xpath(" //input[@formcontrolname='zipCode']");
    public By editAdditionalComment = By.xpath(" //input[@formcontrolname='appointmentComments']");
    public By editUpdateBtn = By.id("intakeFormSubmit");
    public By actualTextClient = By.xpath("//p[text()=' College']");
    public By followUp = By.xpath("//a[text()=' Create Follow Up ']");
    public By followUpSlot = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-ios-dark mbsc-schedule-item ng-star-inserted'])[15]");
    public By slotSaveBtn = By.xpath("//mbsc-button[text()=' Save ']");
    public By followUpSaveBtn = By.xpath("//a[text()='Save']");
    public By confirmBtn= By.xpath("//a[text()='Confirm']");
    public By validateScheduledFollowUp = By.xpath("//h4[text()='Follow Up Scheduled!!']");
    public By followUpBackBtn = By.xpath("(//a[text()='Back'])[3]");


    public void clickOn_createAdminButton() {
        WebdriverWaits.WaitUntilVisible(createAdminButton);
        //  WebdriverWaits.WaitUntilInvisible(createAdminButton);
        click_custom(createAdminButton);
    }

    public void enter_admin_FirstName(String CustomerFirstName) throws InterruptedException {
        WebdriverWaits.WaitUntilVisible(admin_FirstName);
        sendKeys_withClear(admin_FirstName, CustomerFirstName);
    }

    public void enter_admin_LastName(String CustomerLastName) {
        WebdriverWaits.WaitUntilVisible(admin_LastName);
        sendKeys_withClear(admin_LastName, CustomerLastName);
    }

    public void enter_admin_MobileNumber(String diagnostician_MobileNumberText) {
        WebdriverWaits.WaitUntilVisible(admin_MobileNumber);
        sendKeys_withClear(admin_MobileNumber, diagnostician_MobileNumberText);
    }

    public void enter_admin_Email(String diagnostician_EmailText) {
        WebdriverWaits.WaitUntilVisible(admin_Email);
        sendKeys_withClear(admin_Email, diagnostician_EmailText);
    }

    public void userNameField(String userNameText) {
        WebdriverWaits.WaitUntilVisible(userName);
        sendKeys_withClear(userName, userNameText);
    }

    public void create_passwordField(String passwordFieldText) {
        sendKeys_withClear(password_Field, passwordFieldText);
    }

    public void confirm_PasswordField(String confirmPasswordText) {
        sendKeys_withClear(confirm_PasswordField, confirmPasswordText);
    }

    public void clickOn_createadminButton() {
        click_custom(createadminButton);
    }

    //*******************SuperAdmin  searching created admin******************


    public void click_filterButton() {
        WebdriverWaits.WaitUntilVisible(filterButton);
        WebdriverWaits.WaitUntilInvisible(loginLoading);
        click_custom(filterButton);
    }

    public void enterInSearchField(String searchFieldText) {
        WebdriverWaits.WaitUntilVisible(searchField);
        sendKeys_withClear(searchField, searchFieldText);
    }

    //+++++++++++++++++EDIT Admin++++++++++++++

    public void click_On_EditButton() {
        WebdriverWaits.WaitUntilVisible(editButton);
        WebdriverWaits.WaitUntilInvisible(loginLoading);
        click_custom(editButton);
    }

    public void enter_Admin_Email1(String diagnostician_EmailText1) {
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void click_UpdateButton() {
        click_custom(updateButton);
    }


    public void off_ToggleButton() {
        click_custom(toggle);
    }

    public void enter_Diagnostician_Email1(String diagnostician_EmailText1) {
        WebdriverWaits.WaitUntilVisible(emailField);
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void clickOn_PasswordField(String passwordTextFieldText) {
        WebdriverWaits.WaitUntilVisible(passwordTextField);
        sendKeys_withClear(passwordTextField, passwordTextFieldText);
    }

    public void clickOn_confirmPasswordFieldField(String confirmPasswordFieldText) {
        WebdriverWaits.WaitUntilVisible(confirmPasswordField);
        sendKeys_withClear(confirmPasswordField, confirmPasswordFieldText);
    }

    public void clickOn_DontSave() {
        WebdriverWaits.WaitUntilVisible(dontSaveButton);
        click_custom(dontSaveButton);
    }


    //****************SuperAdmin creating Admin***********************
    public void create_Admin(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName, String PasswordText, String RePassword) throws InterruptedException {
        clickOn_createAdminButton();
        enter_admin_FirstName(CustomerFirstName);
        enter_admin_LastName(CustomerLastName);
        enter_admin_MobileNumber(diagnostician_MobileNumberText);
        enter_admin_Email(EmailAddress);

        userNameField(UserName);
        create_passwordField(PasswordText);
        confirm_PasswordField(RePassword);
        clickOn_createadminButton();
    }
//*******************SuperAdmin  searching created admin******************

    public void search_CreatedAdmin(String UserName) throws InterruptedException {
        click_filterButton();
        enterInSearchField(UserName);
    }

    //******************EDIT ADMIN****************

    public void edit_Admin(String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        WebdriverWaits.WaitUntilVisible(editUserPop_Up);
        validate_text(editUserPop_Up, "Edit User");
        // enter_CellNumber(cellNumberText);
        enter_Admin_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }
    //************Checking toggle of or not*************

    public void cheking_DisableUser() throws InterruptedException {
        click_On_EditButton();
        clickOn_DontSave();
        click_On_EditButton();
        clickOn_DontSave();
    }

    //**********Enable user In Admin************
    public void enable_Admin() throws InterruptedException {
        click_On_EditButton();
        off_ToggleButton();
        click_UpdateButton();
    }

    //************Verify dontsave button******************

    public void verify_DontSave(String adminEmailAddress, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        enter_Diagnostician_Email1(adminEmailAddress);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        clickOn_DontSave();
    }

    public void click_EditAssessment() throws InterruptedException{
        WebdriverWaits.WaitUntilVisible(editAss);
        WebdriverWaits.WaitUntilInvisible(spinner);
        click_custom(editAss);
        validate_text(assType,"Change Assement Type");
    }

    public void click_UpdateBtn() {
        WebdriverWaits.WaitUntilVisible(updateBtn);
        click_custom(updateBtn);
    }

    public void edit_AssessmentType(String assestmentTypeTexts) throws InterruptedException {
        WebdriverWaits.WaitUntilInvisible(spinner);
        WebdriverWaits.WaitUntilVisible(assestmentType);
        click_custom(assestmentType);
        selectDropDownByVisibleText_custom(assestmentType, assestmentTypeTexts);

    }

    public void click_DontSave() {
        WebdriverWaits.WaitUntilVisible(assestmentType);
        WebdriverWaits.WaitUntilVisible(dontSaveAsses);
        click_custom(dontSaveAsses);

    }

    //********* Re-assign appointment page ******//
    public void click_ReAssignBtn() {
        WebdriverWaits.WaitUntilVisible(reAssignbtn);
        click_custom(reAssignbtn);
    }

    public void re_AssignDiag(int chooseDiagnostician) {
        WebdriverWaits.WaitUntilVisible(diag);
        WebdriverWaits.WaitUntilInvisible(spinner);
        clickBtn_custom(diag, "chooseDiagnostician");
        selectDropDownByIndex_custom(diag, chooseDiagnostician, "Choose Diagnostician");
    }

    public void click_ReAssignBn() {
        WebdriverWaits.WaitUntilVisible(rebtn);
        click_custom(rebtn);


    }

    public void click_TestPlan() {
        WebdriverWaits.WaitUntilVisible(testPlan);
        click_custom(testPlan);
    }

    public void select_TestPlan() {
        click_custom(checkBox);
        click_custom(famCheckBox);
        click_custom(nepsyCheckBox);
        click_custom(ndCheckBox);
        click_custom(wmsCheckBox);
        click_custom(bascSelfCheckBox);
        click_custom(cbrsSelfCheckBox);
        click_custom(dlsDyslexiaCheckBox);
    }
    public void click_EditTestPlan(){
        click_custom(editTestPlan);

    }
    public void edit_TestPlan(){
        click_EditTestPlan();
        click_custom(warlCheckBox);
        click_TestPlanSaveButton();
    }

    public void click_TestPlanSaveButton() {
        click_custom(testPlanSaveButton);
    }

    public void click_EditClientBtn() {
        WebdriverWaits.WaitUntilVisible(editClientBtn);
        click_custom(editClientBtn);
    }

    //*********** Edit Client Info **********//
    public void enter_FirstName(String firstName) {
        WebdriverWaits.WaitUntilVisible(editFirstName);
        sendKeys_withClear(editFirstName, firstName);
    }


    public void enter_LastName(String lastName) {
        WebdriverWaits.WaitUntilVisible(editLastName);
        sendKeys_withClear(editLastName, lastName);
    }

    public void enter_ParentName(String parentName) {
        WebdriverWaits.WaitUntilVisible(editParentName);
        sendKeys_withClear(editParentName, parentName);
    }

    public void enter_Date(String birthDate) {
        WebdriverWaits.WaitUntilVisible(editDate);
        sendKeys_withClear(editDate, birthDate);
    }

    public void enter_PhoneNumber(String phoneNuber) {
        WebdriverWaits.WaitUntilVisible(editPhoneNumber);
        sendKeys_withClear(editPhoneNumber, phoneNuber);
    }

    public void enter_CellNumber(String cellNumber) {
        WebdriverWaits.WaitUntilVisible(editCellNumber);
        sendKeys_withClear(editCellNumber, cellNumber);
    }

    public void enter_Email1(String email) {
        WebdriverWaits.WaitUntilVisible(editEmail);
        sendKeys_withClear(editEmail, email);
    }

    public void enter_Email2(String email) {
        WebdriverWaits.WaitUntilVisible(editEmail2);
        sendKeys_withClear(editEmail2, email);
    }

    public void enter_grade(String grade) {
        WebdriverWaits.WaitUntilVisible(editGrade);
        WebdriverWaits.waitForElementClickable(editGrade, 1000);
        click_custom(editGrade);
        selectDropDownByVisibleText_custom(editGrade, grade);
    }

    public void enter_SchoolType(int schoolType) {
        WebdriverWaits.WaitUntilVisible(editSchoolType);
        selectDropDownByIndex_custom(editSchoolType, schoolType);
    }

    public void enter_District(String district) {
        WebdriverWaits.WaitUntilVisible(editDistrict);
        sendKeys_withClear(editDistrict, district);
    }

    public void enter_Reason(String reason) {
        WebdriverWaits.WaitUntilVisible(editReason);
        selectDropDownByVisibleText_custom(editReason, reason);
    }

    public void enter_Address2(String address) {
        WebdriverWaits.WaitUntilVisible(editAddress2);
        sendKeys_withClear(editAddress2, address);
    }

    public void enter_Address1(String address) {
        WebdriverWaits.WaitUntilVisible(editAddress1);
        sendKeys_withClear(editAddress1, address);
    }

    public void enter_City(String city) {
        WebdriverWaits.WaitUntilVisible(editCity);
        sendKeys_withClear(editCity, city);
    }

    public void enter_State(String state) {
        WebdriverWaits.WaitUntilVisible(editCity);
        sendKeys_withClear(editCity, state);
    }

    public void enter_ZipCode(String zipCode) {
        WebdriverWaits.WaitUntilVisible(editZipCode);
        sendKeys_withClear(editZipCode, zipCode);
    }

    public void enter_comment(String additionalComment) {
        WebdriverWaits.WaitUntilVisible(editAdditionalComment);
        sendKeys_custom(editAdditionalComment, additionalComment);
    }

    public String edit_ClientInfo(String firstName, String lastName, String address1, String grade) {
        String fullName = firstName + " " + lastName;
        enter_FirstName(firstName);
        enter_LastName(lastName);
        enter_Address1(address1);
        enter_grade(grade);
        return fullName;

    }

    public void click_UpdateClientBtn() {
        click_custom(editUpdateBtn);

    }

    public void click_CreateFollowUpBtn() {
        WebdriverWaits.waitUntilVisible(followUp);
        click_custom(followUp);
    }

    public void click_FollowUpSlot() {
        WebdriverWaits.waitUntilVisible(followUpSlot);
        click_custom(followUpSlot);

    }

    public void click_FollowUpSlotSaveBtn() {
        WebdriverWaits.waitUntilVisible(slotSaveBtn);
        click_custom(slotSaveBtn);
    }

    public void click_FollowUpSaveBtn() {
        WebdriverWaits.waitUntilVisible(followUpSaveBtn);
        click_custom(followUpSaveBtn);
    }
    public void click_ConfirmFollowUpBtn(){
        WebdriverWaits.waitUntilVisible(confirmBtn);
        click_custom(confirmBtn);
    }
    public void click_BackBtn(){
        WebdriverWaits.WaitUntilInvisible(spinner);
        WebdriverWaits.waitUntilVisible(followUpBackBtn);
        click_custom(followUpBackBtn);

    }
    public void Create_FollowUp() throws InterruptedException {
        click_CreateFollowUpBtn();
        click_FollowUpSlot();
        click_FollowUpSlotSaveBtn();
        click_FollowUpSaveBtn();
        click_ConfirmFollowUpBtn();
        validate_text(validateScheduledFollowUp,"Follow Up Scheduled!!");


    }
}

