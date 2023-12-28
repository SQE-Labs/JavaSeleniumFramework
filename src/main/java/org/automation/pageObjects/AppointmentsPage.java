package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.logger.Log;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;
import static org.automation.utilities.Assertions.validate_text;


public class AppointmentsPage extends BasePage {
    public By appointmentsTab= By.xpath("//a[@data-toggle='collapse' and @href='#Appointments' and contains(@class, '')]");
    public By viewAllTab=By.xpath("//a[text()='View All']");
    public By dashBoardPage=By.xpath("//h3[text()='Dashboard']");
    public By allAppointmentsPage=By.xpath("//h3[text()='All Appointments']");
    public By searchedText=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");

    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField=By.xpath("//input[@id='filterSearch']");
    public By dateFrom=By.xpath("//input[@placeholder='From Date']");
    public By toDate=By.xpath("//input[@placeholder='To Date']");
    public By searchButton=By.xpath("//button[text()='Search']");
    public By exportCSVButton=By.xpath("//button[text()='Export to CSV']");
    public By assessmentDate = By.id("assessmentDate");
    public By viewDetails=By.xpath("//a[text()='View Detail']");

    public By App_Text=By.xpath("//h3");
    public By viewDetailsLink=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(7)");
    public By spinner= By.cssSelector("div.ngx-spinner-overlay");
    public By viewAllActualText= By.xpath("//h3[@class='mb-4 mb-md-0']");
    public By actualSearchedText= By.xpath("(//td[@class='tablewidth'])[1]");
    public By dateElements = By.xpath("//tr/td[3]");
    public By clickOnBox = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[23]");
    public By view_Observation_Button=By.xpath("//a[text()='View Student Observation']");
    public By view_Document_Button=By.xpath("//a[text()='View Documents']");

//
    public By clientFirstName = By.xpath("//input[@placeholder='Client First Name']");
    public By clientLastName = By.xpath("//input[@placeholder='Client Last Name']");
    public By headerResource = By.xpath("//div[@class='header-resource-name']");
    public By dateOfBirth = By.xpath("//input[@placeholder='Date of Birth']");
    public By saveButton = By.xpath("//mbsc-button[text()=' Save ']");
    public By appointmentSaveButtonButton = By.xpath("//a[text()='Save']");
    public By assestmentType = By.id("assestmentType");
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
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By enterAmountField=By.xpath("//input[@placeholder='Enter Amount']");
    public By collectDeposit=By.xpath("//button[text()='Collect Deposit']");
    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public By chooseTestingLocation = By.id("testingLocation");




    public void enterFirstName(String cilentFirstNameText){
        WebdriverWaits.waitUntilVisible(clientFirstName);
        sendKeys_withClear(clientFirstName,cilentFirstNameText);
    }
    public void enterLastName(String cilentLastNameText){
        WebdriverWaits.waitUntilVisible(clientLastName);
        sendKeys_withClear(clientLastName,cilentLastNameText);
    }
    public int getColumnCount() {
        List<WebElement> list = getWebElements(headerResource, "Heders");
        return list.size();
    }

    public void selectGradeType(int gradeType){
        selectDropDownByIndex_custom(grade,gradeType);
    }
    public void selectSchoolType(int schoolTypeOption) throws InterruptedException {
        // click_custom(SchoolType);
        selectDropDownByIndex_custom(SchoolType,schoolTypeOption);
    }
    public void enterCellNumber(String cellNumberText){
        WebdriverWaits.waitUntilVisible(cellNumber);
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
    public  void getTotalColumnCount() {
        int colCount = getColumnCount();
        int expLocatorPos = (colCount - 1) * 7 + 1;
        System.out.println(expLocatorPos);
        WebdriverWaits.waitUntilVisible(clickOnBox);
        click_custom(clickOnBox);
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
    public void click_LogOutLink() {
        refresh_Page();
        WebdriverWaits.waitUntilVisible(logOutLink);
        WebdriverWaits.waitForSpinner();
        click_custom(logOutLink);

    }

    public void enterTestAmount(String testAmountText){
        WebdriverWaits.waitUntilVisible(testAmount);
        sendKeys_withClear(testAmount,testAmountText);
    }
    public void clickOnContinueToDepositButton(){
        click_custom(continueToDeposit);
    }
    public void enterInDateField(String dateOfBirthText) throws InterruptedException {
        click_custom(dateOfBirth);
        WebdriverWaits.waitUntilVisible(dateOfBirth);
        sendKeys_withClear(dateOfBirth,dateOfBirthText);
    }
    public void clickOnSaveButton() {
        //  click_custom(afternoonToggleButton);
        click_custom(saveButton);
    }
    public void clickOnAppSaveButton() {
        WebdriverWaits.waitUntilVisible(appointmentSaveButtonButton);
        click_custom(appointmentSaveButtonButton);
    }
    public void clickOnAssesmentType(int assestmentTypeTexts){
        WebdriverWaits.waitUntilVisible(assestmentType);
        click_custom(assestmentType);
        selectDropDownByIndex_custom(assestmentType,assestmentTypeTexts);
    }
    public void selectTestinglocation(String chooseLocationText) {
        WebdriverWaits.waitUntilVisible(chooseTestingLocation);
        clickBtn_custom(chooseTestingLocation, "ChooseLocation");
        selectDropDownByVisibleText_custom(chooseTestingLocation, chooseLocationText, "ChooseLocation");
    }
    public void selectAssessmentDate() {
        WebdriverWaits.waitUntilVisible(assessmentDate);
        WebdriverWaits.waitForSpinner();
        clickBtn_custom(assessmentDate);
    }
    public void enterAmount(String enterAmountText) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(enterAmountField);
        WebdriverWaits.waitForSpinner();
        click_custom(enterAmountField);
        sendKeys_withClear(enterAmountField,enterAmountText);
    }
    public void clickOnCollectDepositButton(){
        WebdriverWaits.waitUntilVisible(collectDeposit);
        WebdriverWaits.waitForSpinner();
        click_custom(collectDeposit);
    }
    public void clickOnViewDetailsButton(){
        WebdriverWaits.waitUntilVisible(viewDetails);
        WebdriverWaits.waitForSpinner();
        click_custom(viewDetails);
    }

    public void fill_clientDetailsSection(String CustomerFirstName, String CustomerLastName, int gradeType, String dateOfBirthText,int schoolTypeOption, String cellNumber , String EmailAddress, String reasonForCallText, String address1Text, String address2Text, String cityText, String stateText, String zipCodeText, String testAmountText, String enterAmountText) throws InterruptedException {
        enterFirstName(CustomerFirstName);
        enterLastName(CustomerLastName);
        enterInDateField(dateOfBirthText);
        selectGradeType(gradeType);
        selectSchoolType(schoolTypeOption);
        Thread.sleep(3000);
        enterCellNumber(cellNumber);
        enterEmialAddress(EmailAddress);
        reasonForCallDropDown(reasonForCallText);
        enterTestAmount(testAmountText);
        clickOnContinueToDepositButton();
        enterAmount(enterAmountText);
        clickOnCollectDepositButton();
        clickOnViewDetailsButton();
    }
    public void click_AppointmentTab(){
        WebdriverWaits.waitUntilVisible(appointmentsTab);
        WebdriverWaits.waitUntilInvisible(spinner);
        click_custom(appointmentsTab);
    }
    public void appointmentDateSelecting(int Type) throws InterruptedException {
        Thread.sleep(5000);
        getTotalColumnCount();
        Thread.sleep(3000);
        clickOnSaveButton();
        Thread.sleep(3000);
        clickOnAppSaveButton();
        Thread.sleep(3000);
        clickOnAssesmentType(Type);
    }
    public void click_ViewAllTab(){
        WebdriverWaits.waitUntilVisible(viewAllTab);
        click_custom(viewAllTab);
    }
    public void click_FilterButton(){
         click_custom(filterButton);
    }
    public void clickOn_ExportCSVButton(){
        WebdriverWaits.waitUntilVisible(exportCSVButton);
        click_custom(exportCSVButton);
    }
    public void scheduleAppointment(String chooseLocationText) throws InterruptedException {
        selectTestinglocation(chooseLocationText);
        selectAssessmentDate();
    }
    public void click_SearchField(String searchFieldText){
        WebdriverWaits.waitUntilVisible(searchField);
        sendKeys_withClear(searchField,searchFieldText);
    }
    public void enter_Dates(String dateFromText,String toDateText) throws InterruptedException {
        click_custom(dateFrom);
        sendKeys_withClear(dateFrom,dateFromText);
        click_custom(toDate);
        sendKeys_withClear(toDate,toDateText);
        click_custom(searchButton);
    }
    public void clickOn_ViewDetails(){
        WebdriverWaits.waitUntilVisible(viewDetailsLink);
        click_custom(viewDetailsLink);
    }

    public void view_allAppointmentsPage(String diagnosticianFirstName,String  diagnosticianLastName)   {
         validate_text(dashBoardPage,"Dashboard");

         click_AppointmentTab();
        validate_text(viewAllTab,"View All");
        Log.info("View all details tab successfully displayed");

        click_ViewAllTab();
        WebdriverWaits.waitUntilVisible(allAppointmentsPage);
        validate_text(allAppointmentsPage,"All Appointments");

        click_FilterButton();
        click_SearchField(diagnosticianFirstName);
        WebdriverWaits.waitUntilVisible(searchedText);
        validate_text(searchedText, diagnosticianFirstName+' '+diagnosticianLastName);

    }
    public void exportCSV_Button(){

        clickOn_ExportCSVButton();
    }




}
