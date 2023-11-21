package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ScheduleAppointmentPage extends BasePage {

    public By chooseTestingLocation = By.id("testingLocation");
    public By assessmentDate = By.id("assessmentDate");
    public By chooseSlot = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[1]");
    public By assessmentTime = By.id("assessmentTime");
    public By assestmentType = By.id("assestmentType");
    public By assestmentTypeText=By.xpath("//option[text()=' Adult ADHD Only ']");
    public By cilentFirstName = By.xpath("//div[@class='col-md-3'][5]");
    public By cilentLastName = By.xpath("(//input[@class='ng-untouched ng-pristine ng-invalid'])[2]");
    public By dateOfBirth = By.xpath("(//input[@class='ng-untouched ng-pristine ng-invalid'])[3]");
    public By grade = By.xpath("(//select[@class='ng-untouched ng-pristine ng-invalid'])[1]");
    public By schoolType = By.xpath("(//select[@class='ng-untouched ng-pristine ng-invalid'])[2]");
    public By cellNumber = By.xpath("(//input[@class='p-inputtext p-component p-element p-inputmask'])[1]");
    public By phoneNumber = By.xpath("(//input[@class='p-inputtext p-component p-element p-inputmask'])[2]");
    public By emailAddress = By.xpath("//input[@type='email'])[1]");
    public By reasonForCall = By.id("reasonForCall");
    public By address1 = By.xpath("//input[@class='ng-untouched ng-pristine ng-valid'])[5]");
    public By address2 = By.xpath("//input[@class='ng-untouched ng-pristine ng-valid'])[6]");
    public By city = By.xpath("//input[@class='ng-untouched ng-pristine ng-valid'])[7]");
    public By state = By.xpath("//input[@class='ng-untouched ng-pristine ng-valid'])[8]");
    public By zipCode = By.xpath("//input[@class='ng-untouched ng-pristine ng-valid'])[9]");
    public By continueToDeposit = By.id("intakeFormSubmit");
    public By headerResource = By.xpath("//div[@class='header-resource-name']");
    //(//div[@class='mbsc-flex ng-star-inserted'])[1]
    public By selectingtoday=By.xpath("//div[@class='mbsc-ios mbsc-ltr mbsc-schedule-header-day mbsc-selected ng-star-inserted']");
    public By clickOnBox = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[1]");
    public By saveButton = By.xpath("//mbsc-button[text()=' Save ']");
    public By appointmentSaveButtonButton = By.xpath("//a[text()='Save']");
    public By totalBoxes=By.xpath("//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted']");
    public By afternoonToggleButton=By.xpath("//mbsc-button[text()='Afternoon']");

    public void selectAssessmentDate() {
        // clickBtn_custom(assessmentDate,"Select Assessment Date");

        clickBtn_custom(assessmentDate);

    }

    public void selectTestinglocation(String chooseLocationText) {
        clickBtn_custom(chooseTestingLocation, "ChooseLocation");
        selectDropDownByVisibleText_custom(chooseTestingLocation, chooseLocationText, "ChooseLocation");

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
        click_custom(afternoonToggleButton);
        click_custom(saveButton);
    }

    public void clickOnAppSaveButton() {
        click_custom(appointmentSaveButtonButton);
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
        sendKeys_withClear(cilentFirstName,cilentFirstNameText);
    }
    public void enterLastName(String cilentLastNameText){
        sendKeys_withClear(cilentLastName,cilentLastNameText);
    }
    public void clickOnDateOfBirthField(){
        click_custom(dateOfBirth);
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
        public void enteringClientDetails(String firstName,String lastName){
            enterFirstName(firstName);
            enterLastName(lastName);
            clickOnDateOfBirthField();
        }
    }





