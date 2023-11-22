package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.ScheduleAppointmentTest;

import java.util.*;

import static test.ScheduleAppointmentTest.CustomerFirstName;
import static test.ScheduleAppointmentTest.CustomerLastName;

public class ScheduleAppointmentPage extends BasePage {

    public By chooseTestingLocation = By.id("testingLocation");
    public By assessmentDate = By.id("assessmentDate");
    public By chooseSlot = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[1]");
    public By assessmentTime = By.id("assessmentTime");
    public By assestmentType = By.id("assestmentType");
    public By assestmentTypeText=By.xpath("//option[text()=' Adult ADHD Only ']");
    public By clientFirstName = By.xpath("//input[@placeholder='Client First Name']");
    public By clientLastName = By.xpath("//input[@placeholder='Client Last Name']");
    public By dateOfBirth = By.xpath("(//input[@class='ng-untouched ng-pristine ng-invalid'])[1]");
    public By grade = By.xpath("(//select[@class='ng-untouched ng-pristine ng-invalid'])[1]");
    public By schoolType = By.xpath("(//select[@class='ng-untouched ng-pristine ng-invalid'])[2]");
    public By SchoolType=By.xpath("(//select[@id='schoolType'])[2]");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
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
    public By clickOnBox = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[1]");
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




    public static By getCanceledXPAth(String ClientName) {
        return By.xpath("//td[contains(text(),'"+ClientName+"')]//parent::tr//span[contains(text(),'Canceled')]");
    }

    public void selectAssessmentDate() {
        clickBtn_custom(assessmentDate);
    }

    public void selectTestinglocation(String chooseLocationText) {
        clickBtn_custom(chooseTestingLocation, "ChooseLocation");
        selectDropDownByVisibleText_custom(chooseTestingLocation, chooseLocationText, "ChooseLocation");

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




    public void createAppointment(String chooseLocationText) throws InterruptedException {
        selectTestinglocation(chooseLocationText);
        Thread.sleep(7000);
        selectAssessmentDate();
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

        click_custom(clickOnBox);
    }

    public void clickOnAssesmentType(int assestmentTypeTexts){
        click_custom(assestmentType);
        selectDropDownByIndex_custom(assestmentType,assestmentTypeTexts);
    }
    public void enterFirstName(String cilentFirstNameText){
        sendKeys_withClear(clientFirstName,cilentFirstNameText);
    }
    public void enterLastName(String cilentLastNameText){
        sendKeys_withClear(clientLastName,cilentLastNameText);
    }
    public void selectGradeType(int gradeType){
        selectDropDownByIndex_custom(grade,gradeType);
    }
    public void selectSchoolType(int schoolTypeOption) throws InterruptedException {
       // click_custom(SchoolType);
        Thread.sleep(2000);
        selectDropDownByIndex_custom(SchoolType,schoolTypeOption);
    }
    public void enterCellNumber(String cellNumberText){
        sendKeys_withClear(cellNumber,cellNumberText);
    }
    public void enterPhoneNumber(String phoneNumberText){
        sendKeys_withClear(phoneNumber,phoneNumberText);
    }
    public void enterEmialAddress(String emailAddressText){
        sendKeys_withClear(emailAddress,emailAddressText);
    }
    public void reasonForCallDropDown(String reasonForCallText){
        selectDropDownByVisibleText_custom(reasonForCall,reasonForCallText);
    }
    public void enterAdress1(String address1Text){
        sendKeys_withClear(address1,address1Text);
    }
    public void enterAdress2(String address2Text){
        sendKeys_withClear(address2,address2Text);
    }
    public void enterCity(String cityText){
        sendKeys_withClear(city,cityText);
    }
    public void enterState(String stateText){
        sendKeys_withClear(state,stateText);
    }
    public void enterZipCode(String zipCodeText){
        sendKeys_withClear(zipCode,zipCodeText);
    }

    public void enterTestAmount(String testAmountText){
        sendKeys_withClear(testAmount,testAmountText);
    }
    public void clickOnContinueToDepositButton(){
        click_custom(continueToDeposit);
    }
    public void enterInDateField(String dateOfBirthText) throws InterruptedException {
        click_custom(dateOfBirth);
        Thread.sleep(2000);
        sendKeys_withClear(dateOfBirth,dateOfBirthText);
    }
    public void enterAmount(String enterAmountText) throws InterruptedException {
        Thread.sleep(3000);
        sendKeys_withClear(enterAmountField,enterAmountText);
    }
    public void clickOnCollectDepositButton(){
        click_custom(collectDeposit);
    }
    public void clickOnViewDetailsButton(){

        click_custom(viewDetails);
    }
    public void enterInsearchBox(String CustomerFirstName )
    {
        sendKeys_withClear(searchBox,CustomerFirstName);
    }
    public void clickOnviewLink(){
        click_custom(viewlink);
    }
    public void clickOnFilterbutton(){
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





    //================///////////=========================
    public void scheduleAppointment(String testingLocation) throws InterruptedException {
        createAppointment(testingLocation);
    }

        public void appointmentDateSelecting(int Type) throws InterruptedException {
        Thread.sleep(5000);
                getTotalColumnCount();
                Thread.sleep(3000);
                //  schedule.clickOnColumn();
                clickOnSaveButton();
                clickOnAppSaveButton();
            clickOnAssesmentType(Type);
        }
        public String enteringClientDetails(String CustomerFirstName, String CustomerLastName, int gradeType, String dateOfBirthText,int schoolTypeOption, String cellNumber , String EmailAddress, String reasonForCallText, String address1Text, String address2Text, String cityText, String stateText, String zipCodeText, String testAmountText, String enterAmountText) throws InterruptedException {
            enterFirstName(CustomerFirstName);
            enterLastName(CustomerLastName);
            Thread.sleep(2000);
            enterInDateField( dateOfBirthText);
            selectGradeType(gradeType);
            selectSchoolType(schoolTypeOption);
            enterCellNumber(cellNumber);
           // enterPhoneNumber( phoneNumberText);
            enterEmialAddress(EmailAddress);
            reasonForCallDropDown(reasonForCallText);
            enterAdress1(address1Text);
            enterAdress2(address2Text);
            enterCity( cityText);
            enterState(stateText);
            enterZipCode(zipCodeText);
            enterTestAmount(testAmountText);
            clickOnContinueToDepositButton();
            Thread.sleep(4000);
            enterAmount(enterAmountText);
            clickOnCollectDepositButton();
            Thread.sleep(8000);
            clickOnViewDetailsButton();
            return CustomerFirstName;
        }


        public void search_ScheduledAppointment (String CustomerFirstName) throws InterruptedException {
            clickOnviewLink();
            Thread.sleep(4000);
            clickOnFilterbutton();
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
    }





