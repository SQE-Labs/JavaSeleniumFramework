package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.logger.Log;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import static org.automation.utilities.Assertions.validate_text;


public class AppointmentsPage extends BasePage {
    public By appointmentsTab= By.xpath("//a[text()=' Appointments ']");
    public By viewAllTab=By.xpath("//a[text()='View All']");
    public By dashBoardPage=By.xpath("//h3[text()='Dashboard']");
    public By allAppointmentsPage=By.xpath("//h3[text()='All Appointments']");
    public By searchedText=By.xpath("//td[text()='Hazel Rogers']");
    public By searchByDate=By.xpath("//td[text()='Hazel Rogers']");
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField=By.xpath("//input[@id='filterSearch']");
    public By dateFrom=By.xpath("//input[@placeholder='From Date']");
    public By toDate=By.xpath("//input[@placeholder='To Date']");
    public By searchButton=By.xpath("//button[text()='Search']");
    WebdriverWaits wait=new WebdriverWaits();

    public void click_AppointmentTab(){
        click_custom(appointmentsTab);
    }
    public void click_ViewAllTab(){
        click_custom(viewAllTab);
    }
    public void click_FilterButton(){
        wait.WaitUntilPresent(filterButton);
         click_custom(filterButton);
    }
    public void click_SearchField(String searchFieldText){
        sendKeys_withClear(searchField,searchFieldText);
    }
    public void enter_Dates(String dateFromText,String toDateText) throws InterruptedException {
        click_custom(dateFrom);
        sendKeys_withClear(dateFrom,dateFromText);
    wait.WaitUntilPresent(toDate);
        click_custom(toDate);
        sendKeys_withClear(toDate,toDateText);
        wait.WaitUntilPresent(searchButton);
        click_custom(searchButton);
    }

    public void allAppointmentsPage(String searchFieldText,String dateFromText,String toDateText) throws InterruptedException {
         wait.WaitUntilPresent(dashBoardPage);
     validate_text(dashBoardPage,"Dashboard");
        Log.info("DashBoard page appear after superAdmin logged in");

        wait.WaitUntilPresent(viewAllTab);
        click_AppointmentTab();
        validate_text(viewAllTab,"View All");
        Log.info("View all details tab successfully displayed");
        click_ViewAllTab();
        wait.WaitUntilPresent(allAppointmentsPage);
        validate_text(allAppointmentsPage,"All Appointments");
        Log.info("Successfully All appointments page displayed");
        click_FilterButton();
        wait.WaitUntilPresent(searchByDate);
        enter_Dates(dateFromText, toDateText);
        validate_text(searchByDate,"Hazel Rogers");
        Log.info("Successfully searched created appointment By entering dates");
        getDriver().navigate().refresh();
        click_FilterButton();
        click_SearchField(searchFieldText);
        wait.WaitUntilPresent(searchedText);
        validate_text(searchedText,"Hazel Rogers");
        Log.info("Successfully searched created appointment");
    }
}
