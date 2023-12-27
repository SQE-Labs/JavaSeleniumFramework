package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.*;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;
import static org.automation.utilities.Assertions.validate_text;


public class ScheduleAppointmentPage extends BasePage {

    public By chooseTestingLocation = By.id("testingLocation");
    public By assessmentDate = By.id("assessmentDate");
    public By chooseSlot = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[1]");
    public By assessmentTime = By.id("assessmentTime");
    public By assestmentType = By.id("assestmentType");
    public By assestmentTypeText=By.xpath("//option[text()=' Adult ADHD Only ']");
    public By clientFirstName = By.xpath("//input[@formcontrolname='studentFirstName']");
    public By clientLastName = By.xpath("//input[@formcontrolname='studentLastName']");
    public By dateOfBirth = By.xpath("//input[@placeholder='Date of Birth']");
    public By grade = By.id("schoolType");
    public By parentName= By.xpath("//input[@formcontrolname='parentName']");
    public By schType = By.xpath("//select[@formcontrolname='schoolType']");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By phoneNumber = By.xpath("//input[@placeholder='Phone Number (Optional)']");
    public By emailAddress = By.xpath("//input[@placeholder='Email Address']");
    public By reasonForCall = By.id("reasonForCall");
    public By address1 = By.xpath("//input[@formcontrolname='address1']");
    public By address2 = By.xpath("//input[@formcontrolname='address2']");
    public By city = By.xpath("//input[@placeholder='City (Optional)']");
    public By state = By.xpath("//input[@placeholder='State (Optional)']");
    public By zipCode = By.xpath("//input[@placeholder='Zip Code (Optional)']");
    public By continueToDeposit = By.id("intakeFormSubmit");
    public By testAmount=By.xpath("//input[@placeholder='Test Amount']");
    public By headerResource = By.xpath("//div[@class='header-resource-name']");
    //(//div[@class='mbsc-flex ng-star-inserted'])[1]
    public By selectingtoday=By.xpath("//div[@class='mbsc-ios mbsc-ltr mbsc-schedule-header-day mbsc-selected ng-star-inserted']");
    public By clickOnBox = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-ios-dark mbsc-schedule-item ng-star-inserted'])[34]");
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

    public By userNameField=By.xpath("//input[@placeholder='Username']");
    public By passwordField=By.xpath("//input[@placeholder='Password']");

    public By loginButton=By.xpath("//button[text()=' Log In ']");

    //********CHECKING AVAILABILITY******************
    public By totalSlots=By.xpath("//div[@class='mbsc-timeline-events']");
    public By availability=By.xpath("//a[text()='Availability']");
    public By slot=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[9]");
    public By slot1=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[10]");
    public By slot2=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[11]");
    public By slot3=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[12]");
    //public By slot4=By.xpath("(//div[@class='mbsc-flex mbsc-flex-1-1 mbsc-timeline-slot ng-star-inserted'])[9]");
    public By diagnosticianSaveButton=By.xpath("//button[text()='Save']");
    public By todayLink=By.xpath("//mbsc-button[text()=' Today ']");
    public By delete=By.xpath("//mbsc-button[text()=' Delete ']");
    public By cancel=By.xpath("//mbsc-button[text()=' Cancel ']");
    public By logOutLink=By.xpath("//a[text()='Log Out']");
    public By spinner= By.cssSelector("div.ngx-spinner-overlay");
    public By actualText=By.xpath("//h4[text()='Appointment Scheduled!!']");
    public By goBack = By.xpath("//a[text()='Go Back']");
    public By appDetails= By.xpath("(//h5[text()='Appointment Details '])[1]");
    public By editAss = By.xpath("//a[@text()='Edit Assessment Type']");
    public By getSearch = By.xpath("(//td[@class='tablewidth'])[1]");
    public By viewDetailsClient= By.xpath("(//a[text()='View Detail'])[16]");


    public void click_LogOutLink(){
        click_custom(logOutLink);
    }
    public static By getCanceledXPAth(String ClientName) {
        return By.xpath("//td[contains(text(),'"+ClientName+"')]//parent::tr//span[contains(text(),'Canceled')]");
    }

    public void selectAssessmentDate() {
        WebdriverWaits.WaitUntilInvisible(spinner);
        clickBtn_custom(assessmentDate);
    }

    public void  selectTestinglocation(int chooseLocationText) {
        WebdriverWaits.WaitUntilVisible(chooseTestingLocation);
        WebdriverWaits.WaitUntilInvisible(spinner);
        clickBtn_custom(chooseTestingLocation, "ChooseLocation");
        selectDropDownByIndex_custom(chooseTestingLocation,chooseLocationText,"ChooseLocation");

    }

    public void selectDateFrom(String chooseDateFromText) {
        clickBtn_custom(dateFrom, "chooseDateFromTxt");
        selectDropDownByVisibleText_custom(dateFrom,"chooseDateFromTxt");

    }

    public void selectDateTo(String chooseDateToText) {
        clickBtn_custom(dateTo, "chooseDateToTxt");
        selectDropDownByVisibleText_custom(dateFrom,"chooseDateToText");

    }

    public void click_CancelAppointmentBtn() throws InterruptedException {
        Thread.sleep(3000);
        scrollIntoView(cancelAppointment);
        click_custom(cancelAppointment);
    }

    public void click_YesCancelBtn() throws InterruptedException {
        Thread.sleep(5000);
//        click_custom(cancelRadioBtn);
//        Thread.sleep(3000);
        click_custom(yesCancelBtn);
    }
    public void click_ViewDetails() throws InterruptedException{
        WebdriverWaits.WaitUntilVisible(viewDetailsClient);
        click_custom(viewDetailsClient);
    }




    public void createAppointment(int chooseLocationText) throws InterruptedException {
        selectTestinglocation(chooseLocationText);
    }

    public int getColumnCount() {
        List<WebElement> list = getWebElements(headerResource, "Heders");
        return list.size();
    }


   // public void clickOnColumn() {
    //    click_custom(clickOnBox);
        //   return expLocatorPos;
  //  }

    public void clickOnSaveButton() {
      //  click_custom(afternoonToggleButton);
        click_custom(saveButton);
    }

    public void enter_SearchText(String searchText) {
        sendKeys_withClear(filterSearch,searchText);    }


    public void clickOnAppSaveButton() {
        WebdriverWaits.WaitUntilVisible(appointmentSaveButtonButton);
        click_custom(appointmentSaveButtonButton);
    }


    public void click_ViewAllOption() throws InterruptedException {
        Thread.sleep(3000);
        click_custom(viewAll);
    }

    public void click_FilterBtn() throws InterruptedException {
        Thread.sleep(10000);
        scrollIntoView(filters);
        Thread.sleep(2000);
        click_custom(filters);
    }


    public void click_AppointmentsSubtab() throws InterruptedException {
        Thread.sleep(5000);
        click_custom(appointmentsSubTab);
    }

    public void click_ViewDetailLink() throws InterruptedException {
        click_custom(viewDetailLink);
    }

    public  void getTotalColumnCount() {
        int colCount = getColumnCount();
        int expLocatorPos = (colCount - 1) * 7 + 1;
        System.out.println(expLocatorPos);
        selectAssessmentDate();
        WebdriverWaits.WaitUntilVisible(clickOnBox);
        click_custom(clickOnBox);
    }

    public void clickOnAssesmentType(int assestmentTypeTexts){
        WebdriverWaits.WaitUntilVisible(assestmentType);
        WebdriverWaits.WaitUntilInvisible(spinner);
        WebdriverWaits.WaitForElementInteractable(assestmentType);
        click_custom(assestmentType);
        selectDropDownByIndex_custom(assestmentType,assestmentTypeTexts);
    }
    public void enter_FirstName(String firstName){
        WebdriverWaits.WaitUntilVisible(clientFirstName);
        sendKeys_withClear(clientFirstName,firstName);
    }
    public void enter_LastName(String lastName){
        WebdriverWaits.WaitUntilVisible(clientLastName);
        sendKeys_withClear(clientLastName,lastName);
    }
    public void select_GradeType(int gradeType){
        selectDropDownByIndex_custom(grade,gradeType);
    }
    public void select_SchoolType(int schoolType){
        selectDropDownByIndex_custom(schType,schoolType);
    }
    public void enter_CellNumber(String cellNumb){
        sendKeys_custom(cellNumber,cellNumb);
    }
    public void enterPhoneNumber(String phoneNumberText){
        sendKeys_withClear(phoneNumber,phoneNumberText);
    }
    public void enter_EmialAddress(String email){
        sendKeys_withClear(emailAddress,email);
    }
    public void select_reasonForCall(String callReason){
        selectDropDownByVisibleText_custom(reasonForCall,callReason);
    }
    public void enterAdress1(String address1Text){
        sendKeys_withClear(address1,address1Text);
    }
    public void enterAdress2(String address2Text){
        sendKeys_withClear(address2,address2Text);
    }
    public void enter_City(String cityText){
        sendKeys_withClear(city,cityText);
    }
    public void enter_State(String stateText){
        sendKeys_withClear(state,stateText);
    }
    public void enter_ZipCode(String zipCodeText){
        sendKeys_withClear(zipCode,zipCodeText);
    }

    public void enter_TestAmount(String testAmt){
        WebdriverWaits.WaitUntilVisible(testAmount);
        sendKeys_custom(testAmount,testAmt);
    }
    public void clickOnContinueToDepositButton(){
        click_custom(continueToDeposit);
    }
    public void enter_BirthDate(String dateBirth) throws InterruptedException {
        WebdriverWaits.WaitUntilVisible(dateOfBirth);
        click_custom(dateOfBirth);
        WebdriverWaits.WaitUntilVisible(dateOfBirth);
        sendKeys_withClear(dateOfBirth,dateBirth);
    }
    public void enter_Amount(String enterAmt) throws InterruptedException {
        WebdriverWaits.WaitUntilInvisible(enterAmountField);
        WebdriverWaits.WaitUntilVisible(enterAmountField);
        click_custom(enterAmountField);
        sendKeys_withClear(enterAmountField,enterAmt);
    }
    public void clickOnCollectDepositButton(){
        click_custom(collectDeposit);
    }
    public void clickOnViewDetailsButton(){
        WebdriverWaits.WaitUntilInvisible(viewDetails);
       WebdriverWaits.WaitUntilVisible(viewDetails);
        click_custom(viewDetails);
    }
    public void enterInsearchBox(String CustomerFirstName )
    {    WebdriverWaits.WaitUntilVisible(searchBox);
        sendKeys_withClear(searchBox,CustomerFirstName);
    }
    public void clickOnviewLink(){
        WebdriverWaits.WaitUntilVisible(viewDetails);
        click_custom(viewDetails);
    }
    public void clickOnFilterbutton(){
        WebdriverWaits.WaitUntilVisible(filter);
        click_custom(filter);
    }

    //******************Adding TestPlan for the Appointment**************

    public void click_TestPlanButton() throws InterruptedException {
        Thread.sleep(3000);
        scrollIntoView(testPlan);
        click_custom(testPlan);
    }
    public void clickOnCheckBox(){
//        List<WebElement> list = getWebElements(checkBox, "Heders");
//        ArrayList checkboxes=new ArrayList();
//        for(WebElement checkbox: list){
//            checkboxes.add(checkbox);
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
        sendKeys_withClear(userNameField,CustomerFirstName);
    }
    public void enter_Password(String PasswordText){
        sendKeys_withClear(passwordField,PasswordText);
    }

    public void click_LoginButton( ){
        click_custom(loginButton );
    }

//******************checking availability*************
    public void click_On_Availablity(){
        WebdriverWaits.WaitUntilVisible(availability);
        WebdriverWaits.WaitUntilInvisible(spinner);
        click_custom(availability);
    }
    public void click_On_Slot() throws InterruptedException {
            WebdriverWaits.WaitUntilVisible(slot);
            click_custom(slot);
        //scrollIntoHorizontally(slot1);
            click_custom(slot1);
            click_custom(slot2);
            //click_custom(slot4);
            click_custom(slot3);
            click_custom(diagnosticianSaveButton);
           // click_custom(logOutLink);
    }
    public void click_TodayLink(){
        click_custom(todayLink);
    }

    public void click_On_Delete(){
        click_custom(delete);
    }
    public void click_GoBack(){
        WebdriverWaits.WaitUntilVisible(goBack);
        click_custom(goBack);
    }





    //================///////////=========================
    public void scheduleAppointment(int testingLocation) throws InterruptedException {
        createAppointment(testingLocation);
    }

        public void appointmentDateSelecting(int Type) throws InterruptedException {
                getTotalColumnCount();
                clickOnSaveButton();
                clickOnAppSaveButton();
               clickOnAssesmentType(Type);
        }
        public String enteringClientDetails(String firstName, String lastName, int gradeType, String dateOfBirth,int schoolType, String cellNumber , String EmailAddress, String reasonForCall, String city, String state, String zipCode,String testAmt,String enterAmountText) throws InterruptedException {
            enter_FirstName(firstName);
            enter_LastName(lastName);
            enter_BirthDate(dateOfBirth);
            select_GradeType(gradeType);
            select_SchoolType(schoolType);
            Thread.sleep(2000);
            enter_CellNumber(cellNumber);
            enter_EmialAddress(EmailAddress);
            select_reasonForCall(reasonForCall);
            enter_City( city);
            enter_State(state);
            enter_ZipCode(zipCode);
            enter_TestAmount(testAmt);
            clickOnContinueToDepositButton();
            enter_Amount(enterAmountText);
            clickOnCollectDepositButton();
            WebdriverWaits.WaitUntilVisible(actualText);
            validate_text(actualText,"Appointment Scheduled!!");
            clickOnViewDetailsButton();
            return firstName;
        }


        public void search_ScheduledAppointment (String CustomerFirstName) throws InterruptedException {
            clickOnviewLink();
            Thread.sleep(4000);
            clickOnFilterbutton();
            Thread.sleep(3000);
            enterInsearchBox(CustomerFirstName);
            click_ViewDetailLink();
//           click_CancelAppointmentBtn();
//            click_YesCancelBtn();
//            Thread.sleep(4000);
        }

        public void creatingTestPlanForTheAppointment () throws InterruptedException {
            click_TestPlanButton();
            clickOnCheckBox();
            clickOnTestPlanSaveButton();
        }


        public void login_As_Diagnostician(String UserName,String PasswordText) throws InterruptedException {
        Thread.sleep(8000);
            enter_UserName(UserName);
            enter_Password(PasswordText);
            click_LoginButton( );
        }
        public void checking_Availability() throws InterruptedException {
        Thread.sleep(2000);
            click_On_Availablity();
            Thread.sleep(4000);
            click_On_Slot();
        }
        public void deleting_Availability() throws InterruptedException {
            click_custom(slot1);
            Thread.sleep(3000);
            click_On_Delete();
            click_custom(diagnosticianSaveButton);
          //  click_custom(logOutLink);
        }
        public void cancel_Availability() throws InterruptedException {
        click_custom(slot2);
        Thread.sleep(3000);
        click_custom(cancel);
            click_custom(diagnosticianSaveButton);
            click_custom(logOutLink);
        }



    }





