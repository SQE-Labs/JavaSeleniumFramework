package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.automation.utilities.Assertions.validate_text;


public class DiagnosticianPage extends BasePage {
    public By diagnosticianLink = By.xpath("//a[text()='Diagnosticians']");
    public By createDiagnostician = By.xpath("//button[text()='Create Diagnostician']");
    public By loginLoading=By.cssSelector("div.ngx-spinner-overlay");
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
    public By validationMsg=By.xpath("//div[@class='alert alert-danger ng-star-inserted']");

    public  By actualText = By.xpath("(//td)[2]");
    public By backButton = By.xpath("//button[text()='Back']");
    public  By diagnosticianDashBoardPage = By.xpath("//h3[text()='Dashboard']");
    public By back_Button=By.xpath("//a[text()='Back']");



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
    public  By edit_Succ_Msg = By.xpath("//div[@class='alert alert-success ng-star-inserted']");
    public  By UserNameGetText=By.xpath("(//td)[2]");
    public  By enableUser=By.xpath("//label[text()='Enable User']");
    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton=By.xpath("//a[text()='Don’t Save']");

    //**************DIAGNOSTICIAN LOOGING IN WITH NEW PASSWORD*************

    public By userNameField = By.xpath("//input[@placeholder='Username']");
    public By PasswordField = By.xpath("//input[@placeholder='Password']");
    public By login = By.id("loginFormSubmit");
    public  By validation_Msg=By.xpath("//p[@class='text-danger']");

    //*****************Verify diagnostician is viewing appointments page***************

    public By today_appointments=By.xpath("(//h6[@class='card-heading'])[1]");
    public By view_DetailApp=By.xpath("//a[text()='View Details']");
    public By start_Assesment=By.xpath("//a[text()='Start Assessment']");
    public By no_Payment=By.xpath("//a[text()='No Payment']");
    public By bouncing_Leg=By.xpath("(//div[@class='custom-control custom-checkbox'])[1]");
    public By humming=By.xpath("(//div[@class='custom-control custom-checkbox'])[5]");
    public By playing_with_pencil=By.xpath("(//div[@class='custom-control custom-checkbox'])[8]");
    public By difficulty_Sitting=By.xpath("(//div[@class='custom-control custom-checkbox'])[14]");
    public By Playing_with_hair=By.xpath("(//div[@class='custom-control custom-checkbox'])[13]");
    public By excessive_Talking=By.xpath("(//div[@class='custom-control custom-checkbox'])[16]");
    public By summary=By.xpath("//textarea[@class='custom-input border border-danger ng-untouched ng-pristine ng-valid']");
    public By dashboard=By.xpath("//h3[text()='Dashboard']");
    public By appointmentUserName=By.xpath("//h3[text()=' Randy Walker ']");
    public By appointmentsTab= By.xpath("//a[text()=' Appointments ']");
    public By viewAllTab=By.xpath("(//a)[3]");
    public By appointmentDetail=By.xpath("//h3[text()='Krillin Dash Details']");
    public By paymentDetails=By.xpath("//h4[text()='Payment Details']");
    public By userAssesment=By.xpath("//h3[text()='Krillin Dash Assessment']");
    public By availableSlotText=By.xpath("(//div[text()='Available'])[4]");
    public By disableButton=By.xpath("//div[@class='actions']/button[@class='theme-button grey pointer-disable float-md-right']");
    public By enableSaveButton=By.xpath("//button[@class='theme-button float-md-right green']");
    public By shiftText=By.xpath("//div[text()='Afternoon Shift']");
    public By signUpTitleText=By.xpath("//h3");

//*****************Set Availability for diagnostician ****************

    public By chooseTestingLocation = By.id("testingLocation");
    public By assessmentDate = By.xpath("//input[@placeholder='Assessment Date']");
    public By chooseSlot = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[1]");
    public By assessmentTime = By.id("assessmentTime");
    public By assestmentType = By.xpath("//select[@id='assestmentType']");
    public By assestmentTypeText=By.xpath("//option[text()=' Adult ADHD Only ']");
    public By clientFirstName = By.xpath("//input[@placeholder='Client First Name']");
    public By clientLastName = By.xpath("//input[@placeholder='Client Last Name']");
    public By dateOfBirth = By.xpath("//input[@placeholder='Date of Birth']");
    public By grade = By.xpath("(//select[@id='schoolType'])[1]");
    public By schoolType = By.xpath("(//select[@class='ng-untouched ng-pristine ng-invalid'])[2]");
    public By SchoolType=By.xpath("(//select[@id='schoolType'])[2]");
 //   public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By phoneNumber = By.xpath("(//input[@class='p-inputtext p-component p-element p-inputmask'])[2]");
    public By emailAddress = By.xpath("//input[@placeholder='Email Address']");
    public By reasonForCall = By.id("reasonForCall");
    public By address1 = By.xpath("//input[@placeholder='Address 1']");
    public By address2 = By.xpath("//input[@placeholder='Address 2']");
    public By city = By.xpath("//input[@placeholder='City']");
    public By state = By.xpath("//input[@placeholder='State']");
    public By zipCode = By.xpath("//input[@placeholder='Zip Code']");
    public By continueToDeposit = By.id("intakeFormSubmit");
    public By testAmount=By.xpath("//input[@placeholder='Test Amount']");
    public By headerResource = By.xpath("//div[@class='header-resource-name']");
    //(//div[@class='mbsc-flex ng-star-inserted'])[1]
    public By selectingtoday=By.xpath("//div[@class='mbsc-ios mbsc-ltr mbsc-schedule-header-day mbsc-selected ng-star-inserted']");
    public By clickOnBox = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[29]");
    public By saveButton = By.xpath("//mbsc-button[text()=' Save ']");
    public By appointmentSaveButtonButton = By.xpath("//a[text()='Save']");
    public By totalBoxes=By.xpath("//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted']");
    public By afternoonToggleButton=By.xpath("//mbsc-button[text()='Afternoon']");

    public By appointmentsSubTab = By.xpath("(//div/ul[@class='ng-star-inserted'][3])");
    public By viewAll = By.xpath("//*[@id=\"Appointments\"]/li[1]/a");
    public By filters = By.xpath("//a[@class='theme-button grey ml-auto mr-3']");
    public By filterSearch = By.id("filterSearch");
    public By dateFrom = By.xpath("(//input[@class='ng-untouched ng-pristine ng-valid'])[1]");
    public By dateTo = By.xpath("(//input[@class='ng-untouched ng-pristine ng-valid'])[2]");
    public By search = By.xpath("//*[@id='dateRangeFilter']");
    public By viewDetailLink = By.xpath("//*[@id=\"appointmentTable\"]/tbody/tr[103]/td[7]/a");
    public By cancelAppointment = By.xpath("//button[@class='theme-button danger m-2 ng-star-inserted']");
    public By yesCancelBtn = By.xpath("//button[@class='theme-button danger mx-2 ng-star-inserted']");


    public By enterAmountField=By.xpath("//input[@placeholder='Enter Amount']");
    public By collectDeposit=By.xpath("//button[text()='Collect Deposit']");
    public By viewDetails=By.xpath("//a[text()='View Detail']");
    public By searchBox=By.xpath("//input[@placeholder='Type here to search']");
    public By viewlink=By.xpath("//a[text()='View All']");
    public By filter=By.xpath("//a[text()='Filter']");
    public By cancelRadioBtn = By.xpath("//*[@id=\"noShowAppt\"]");

    //****************Adding TestPlan for the appointment****************

    public By testPlan=By.xpath("//button[text()=' Test Plan ']");
    public By checkBox=By.xpath("//label[text()='WJ Achievement']/..");
    public By famCheckBox=By.xpath("//label[text()='FAM']/..");
    public By nepsyCheckBox=By.xpath("//label[text()='NEPSY']/..");
    public By ndCheckBox=By.xpath("//label[text()='ND']/..");
    public By wmsCheckBox=By.xpath("//label[text()='WMS']/..");

    public By bascSelfCheckBox=By.xpath("//label[text()='BASC Self']/..");
    public By cbrsSelfCheckBox=By.xpath("//label[text()='CBRS Self']/..");
    public By dlsDyslexiaCheckBox=By.xpath("//label[text()='DLS Dyslexia']/..");
    public By testPlanSaveButton=By.xpath("//button[text()='Save']");

    //+++++++++++++++CREATE DIAGNOSTICS++++++++++++++


    public By passwordField=By.xpath("//input[@placeholder='Password']");

    public By loginButton=By.xpath("//button[text()=' Log In ']");

    //********CHECKING AVAILABILITY******************
    public By totalSlots=By.xpath("//div[@class='mbsc-timeline-events']");
    public By availability=By.xpath("//a[text()='Availability']");
    //public By slot=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[1]");
    public By slot1=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[2]");
   // public By slot2=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[3]");
    public By slot3=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[4]");
    public By slot4=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[9]");
    public By slot5=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[10]");
    public By slot6=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[11]");
    public By slot7=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[12]");
   // public By slot8=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[13]");
   // public By slot9=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[14]");
    public By slot10=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[5]");
    public By slot11=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[6]");
    public By slot12=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[7]");
    public By slot13=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[8]");
    public By diagnosticianSaveButton=By.xpath("//button[text()='Save']");
    public By todayLink=By.xpath("//mbsc-button[text()=' Today ']");
    public By delete=By.xpath("//mbsc-button[text()=' Delete ']");
    public By cancel=By.xpath("//mbsc-button[text()=' Cancel ']");
    public By logOutLink=By.xpath("//a[text()='Log Out']");








    public void click_createDiagnosticianButton() {
        WebdriverWaits.waitForSpinner();
        click_custom(createDiagnostician);
    }

    public void enter_diagnostician_FirstName(String CustomerFirstName)  {
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



    public void click_Back_Button() {
        click_custom(backButton);
    }


    //*************search created diagnostician***************

    public void click_filterButton() {
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitUntilInvisible(loginLoading);
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

    //**********Diagnostician is viewing appointments************
    public void clickOn_Today_Appointment(){
        WebdriverWaits.waitUntilInvisible(loginLoading);
        click_custom(appointmentsTab);
        click_custom(viewAllTab);

    }
    public void clickOn_ViewDetail(){
        click_custom(view_DetailApp);
    }
    public void clickOn_StartAssesment(){
        scrollIntoView(start_Assesment);
        click_custom(start_Assesment);
    }
    public void clickOn_NoPaymentButton(){
        click_custom(no_Payment);
    }
    public void clickOn_CheckBox(){

        click_custom(bouncing_Leg);

        click_custom(humming);

        click_custom(playing_with_pencil);

        click_custom(difficulty_Sitting);

        click_custom(Playing_with_hair);

        click_custom(excessive_Talking);
    }
    public void writing_Summary(String summaryText){
        scrollIntoView(summary);
        WebdriverWaits.waitUntilVisible(summary);
        sendKeys_withClear(summary,summaryText);
    }
    public void clickOn_BackButton(){
        scrolltoUp();
        WebdriverWaits.waitUntilVisible(back_Button);
        click_custom(back_Button);
    }





    public void create_Diagnostician(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName, String PasswordText, String RePassword)  {
        WebdriverWaits.waitForSpinner();
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
    }
    public void Verify_Duplicate_Diagnostician(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName,String PasswordText,String RePassword)  {
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
    }


    public void diagnostician_ListPage()  {
        click_createDiagnosticianButton();
        click_Back_Button();
    }

    public void search_CreatedDiagnostician(String UserName)  {
        click_filterButton();
        enterInSearchField(UserName);
    }

    public void edit_Diagnostician( String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText)  {
        click_On_EditButton();
       // enter_CellNumber(cellNumberText);
        enter_Diagnostician_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }

    public void cheking_DisableUser()  {
        click_On_EditButton();
        clickOn_DontSave();
        click_On_EditButton();
        clickOn_DontSave();
    }
    public void disable_Diagnostician(){
        click_On_EditButton();
        off_ToggleButton();
    }
    public void enable_DiagnosticianUser()  {
        click_On_EditButton();
        off_ToggleButton();
        click_UpdateButton();

    }
    public void verify_DontSave(String cellNumberText, String EmailAddress1, String passwordTextFieldText,String confirmPasswordFieldText)  {
        click_On_EditButton();
        enter_CellNumber(cellNumberText);
        enter_Diagnostician_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        clickOn_DontSave();
    }
    //****************Diagnostician is checking todays appointments**************







    public void selectAssessmentDate() {
        WebdriverWaits.waitUntilVisible(assessmentDate);
        //  WebdriverWaits.moveToElement(assessmentDate);
        click_custom(assessmentDate);
    }

    public void selectTestinglocation(String chooseLocationText) {
        clickBtn_custom(chooseTestingLocation, "ChooseLocation");
        selectDropDownByVisibleText_custom(chooseTestingLocation,chooseLocationText);

    }

    public void selectDateFrom(String chooseDateFromText) {
        clickBtn_custom(dateFrom, "chooseDateFromTxt");
        selectDropDownByVisibleText_custom(dateFrom,"chooseDateFromTxt");

    }

    public void selectDateTo(String chooseDateToText) {
        clickBtn_custom(dateTo, "chooseDateToTxt");
        selectDropDownByVisibleText_custom(dateFrom,"chooseDateToText");

    }

    public void click_CancelAppointmentBtn()  {

        scrollIntoView(cancelAppointment);
        click_custom(cancelAppointment);
    }

    public void click_YesCancelBtn()  {
        WebdriverWaits.waitUntilVisible(yesCancelBtn);
        click_custom(yesCancelBtn);
    }




    public void createAppointment(String chooseLocationText)  {
        selectTestinglocation(chooseLocationText);
        selectAssessmentDate();
    }

    public int getColumnCount() {
        List<WebElement> list = getWebElements(headerResource, "Heders");
        return list.size();
    }

    public void clickOnSaveButton() {
        //  click_custom(afternoonToggleButton);
        click_custom(saveButton);
    }

    public void enter_SearchText(String searchText) {
        sendKeys_withClear(filterSearch,searchText);    }


    public void clickOnAppSaveButton() {

        click_custom(appointmentSaveButtonButton);
    }


    public void click_ViewAllOption()  {

        click_custom(viewAll);
    }

    public void click_FilterBtn() {
        scrollIntoView(filters);
        click_custom(filters);
    }


    public void click_AppointmentsSubtab() {

        click_custom(appointmentsSubTab);
    }

    public void click_ViewDetailLink()  {
        click_custom(viewDetailLink);
    }

    public  void getTotalColumnCount() {
        int colCount = getColumnCount();
        int expLocatorPos = (colCount - 1) * 7 + 1;
        System.out.println(expLocatorPos);

        click_custom(clickOnBox);
    }

    public void clickOnAssesmentType(int assestmentTypeTexts){

        click_custom(assestmentType);
        selectDropDownByIndex_custom(assestmentType,assestmentTypeTexts);
    }

    public void enterInsearchBox(String CustomerFirstName )
    {
        WebdriverWaits.waitUntilVisible(searchBox);
        sendKeys_withClear(searchBox,CustomerFirstName);
    }
    public void clickOnviewLink(){
        click_custom(viewlink);
    }
    public void clickOnFilterbutton(){

        click_custom(filter);
    }

    //******************Adding TestPlan for the Appointment**************

    public void click_TestPlanButton()  {
        WebdriverWaits.waitUntilVisible(testPlan);
        scrollIntoView(testPlan);
        click_custom(testPlan);
    }
    public void clickOnCheckBox(){
        click_custom(checkBox);
        click_custom(famCheckBox);
        click_custom(nepsyCheckBox);
        click_custom(ndCheckBox);
        click_custom(wmsCheckBox );
        click_custom(bascSelfCheckBox);
        click_custom(cbrsSelfCheckBox );
        click_custom(dlsDyslexiaCheckBox);
    }
    public void clickOnTestPlanSaveButton(){
        click_custom(testPlanSaveButton);
    }

//******************Logging as diagnostician************

    public void enter_UserName(String CustomerFirstName){
        WebdriverWaits.waitUntilVisible(userNameField);
        sendKeys_withClear(userNameField,CustomerFirstName);
    }
    public void enter_Password(String PasswordText){
        sendKeys_withClear(passwordField,PasswordText);
    }

    public void click_LoginButton( ){
        click_custom(loginButton );
    }

    //******************checking availability*************
    public void click_On_Availablity()  {
        click_custom(availability);
        validate_text(disableButton, "Save");
    }
    public void click_On_Slot()  {
        
        // use logic??
        click_custom(slot3);
        click_custom(slot4);
        click_custom(slot5);
        click_custom(slot6);
        click_custom(slot7);
        click_custom(slot10);
        click_custom(slot11);
        click_custom(slot12);
        click_custom(slot13);

        WebdriverWaits.waitUntilVisible(enableSaveButton);
        validate_text(enableSaveButton, "Save");

        click_custom(diagnosticianSaveButton);
        // click_custom(logOutLink);
    }
    public void click_TodayLink(){
        click_custom(todayLink);
    }

    public void click_On_Delete(){

        click_custom(delete);
    }
    public void checking_Availability()  {
        click_On_Availablity();
        click_On_Slot();
    }















    //================///////////=========================


    public void appointmentDateSelecting(int Type)  {
        getTotalColumnCount();
        //  schedule.clickOnColumn();
        clickOnSaveButton();

        clickOnAppSaveButton();

        clickOnAssesmentType(Type);
    }



    public void search_ScheduledAppointment (String CustomerFirstName)  {
        clickOnviewLink();

        clickOnFilterbutton();

        enterInsearchBox(CustomerFirstName);
        click_ViewDetailLink();
//           click_CancelAppointmentBtn();
//            click_YesCancelBtn();
//            Thread.sleep(4000);
    }

    public void creatingTestPlanForTheAppointment ()  {
        click_TestPlanButton();
        clickOnCheckBox();
        clickOnTestPlanSaveButton();
    }


    public void login_As_Diagnostician(String UserName,String PasswordText)  {

        enter_UserName(UserName);
        enter_Password(PasswordText);
        click_LoginButton( );
    }

    public void deleting_Availability()  {
        click_custom(slot7);
        WebdriverWaits.waitUntilVisible(enableSaveButton);
        validate_text(enableSaveButton, "Save");

        click_On_Delete();
        WebdriverWaits.waitForElementInteractable(diagnosticianSaveButton);
        click_custom(diagnosticianSaveButton);

    }
    public void cancel_Availability()  {
        click_custom(slot7);
        String getText=getText_custom(shiftText);
        WebdriverWaits.waitUntilVisible(shiftText);
        validate_text( shiftText, getText);
        WebdriverWaits.waitUntilVisible(cancel);
        click_custom(cancel);
        click_custom(diagnosticianSaveButton);
    }

}

