package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class ClientDetailsPage extends BasePage {



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
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By enterAmountField=By.xpath("//input[@placeholder='Enter Amount']");
    public By collectDeposit=By.xpath("//button[text()='Collect Deposit']");
    public By viewDetails=By.xpath("//a[text()='View Detail']");




    public void enterFirstName(String cilentFirstNameText){

        sendKeys_withClear(clientFirstName,cilentFirstNameText);
    }
    public void enterLastName(String cilentLastNameText){
        WebdriverWaits.waitUntilVisible(clientLastName);
        sendKeys_withClear(clientLastName,cilentLastNameText);
    }
    public void selectGradeType(int gradeType){
        selectDropDownByIndex_custom(grade,gradeType);
    }
    public void selectSchoolType(int schoolTypeOption) throws InterruptedException {
        // click_custom(SchoolType);
        WebdriverWaits.waitUntilVisible(SchoolType);
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
    public void enterAmount(String enterAmountText) throws InterruptedException {
        WebdriverWaits.WaitUntilInvisible(enterAmountField);
        WebdriverWaits.waitUntilVisible(enterAmountField);
        click_custom(enterAmountField);
        sendKeys_withClear(enterAmountField,enterAmountText);
    }
    public void clickOnCollectDepositButton(){
        click_custom(collectDeposit);
    }
    public void clickOnViewDetailsButton(){
        WebdriverWaits.WaitUntilInvisible(viewDetails);

        click_custom(viewDetails);
    }
    public void enteringClientDetails(String CustomerFirstName, String CustomerLastName, int gradeType, String dateOfBirthText,int schoolTypeOption, String cellNumber , String EmailAddress, String reasonForCallText, String address1Text, String address2Text, String cityText, String stateText, String zipCodeText, String testAmountText, String enterAmountText) throws InterruptedException {
        enterFirstName(CustomerFirstName);
        enterLastName(CustomerLastName);

        enterInDateField( dateOfBirthText);
        selectGradeType(gradeType);
        selectSchoolType(schoolTypeOption);

        enterCellNumber(cellNumber);
        // enterPhoneNumber( phoneNumberText);
        enterEmialAddress(EmailAddress);
        reasonForCallDropDown(reasonForCallText);
//            enterAdress1(address1Text);
//            enterAdress2(address2Text);
//            enterCity( cityText);
//            enterState(stateText);
//            enterZipCode(zipCodeText);
        enterTestAmount(testAmountText);
        clickOnContinueToDepositButton();

        enterAmount(enterAmountText);
        clickOnCollectDepositButton();

        clickOnViewDetailsButton();

    }

}
