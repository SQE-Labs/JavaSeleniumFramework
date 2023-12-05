package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

import static org.automation.pageObjects.Diagnostician.edit_Succ_Msg;
import static org.automation.utilities.Assertions.validate_SuccessTXT;

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

    public void click_AppointmentTab(){
        click_custom(appointmentsTab);
    }
    public void click_ViewAllTab(){
        click_custom(viewAllTab);
    }
    public void click_FilterButton(){
         click_custom(filterButton);
    }
    public void click_SearchField(String searchFieldText){
        sendKeys_withClear(searchField,searchFieldText);
    }
    public void enter_Dates(String dateFromText,String toDateText) throws InterruptedException {
        click_custom(dateFrom);
        sendKeys_withClear(dateFrom,dateFromText);
        Thread.sleep(4000);
        click_custom(toDate);
        sendKeys_withClear(toDate,toDateText);
        Thread.sleep(4000);
        click_custom(searchButton);
    }

    public void allAppointmentsPage(String searchFieldText,String dateFromText,String toDateText) throws InterruptedException {
        Thread.sleep(10000);
        validate_SuccessTXT(dashBoardPage,"Dashboard");
        System.out.println("DashBoard page appear after superAdmin logged in");
        click_AppointmentTab();
        validate_SuccessTXT(viewAllTab,"View All");
        System.out.println("View all details tab successfully displayed");
        click_ViewAllTab();
        Thread.sleep(6000);
        validate_SuccessTXT(allAppointmentsPage,"All Appointments");
        System.out.println("Successfully All appointments page displayed");
        click_FilterButton();
        Thread.sleep(4000);
        enter_Dates(dateFromText, toDateText);
        validate_SuccessTXT(searchByDate,"Hazel Rogers");
        System.out.println("Successfully searched created appointment By entering dates");
        getDriver().navigate().refresh();
        Thread.sleep(6000);
        click_FilterButton();
        click_SearchField(searchFieldText);
        Thread.sleep(4000);
        validate_SuccessTXT(searchedText,"Hazel Rogers");
        System.out.println("Successfully searched created appointment");
    }
}
