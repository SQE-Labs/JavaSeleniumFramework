package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.logger.Log;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import java.io.File;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;
import static org.automation.utilities.Assertions.validate_text;


public class AppointmentsPage extends BasePage {
    public By appointmentsTab= By.xpath("//a[@data-toggle='collapse' and @href='#Appointments' and contains(@class, '')]");
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
    public By exportCSVButton=By.xpath("//button[text()='Export to CSV']");
    public By viewDetails=By.xpath("//td[text()='Hazel Rogers']/../td[6]/a");
    public By App_Text=By.xpath("//h3");
    public By spinner= By.cssSelector("div.ngx-spinner-overlay");
    public By viewAllActualText= By.xpath("//h3[@class='mb-4 mb-md-0']");
    public By actualSearchedText= By.xpath("(//td[@class='tablewidth'])[1]");
    public By dateElements = By.xpath("//tr/td[3]");
    WebdriverWaits wait=new WebdriverWaits();

    public void click_AppointmentTab(){
        WebdriverWaits.WaitUntilVisible(appointmentsTab);
        WebdriverWaits.WaitUntilInvisible(spinner);
        click_custom(appointmentsTab);
    }
    public void click_ViewAllTab(){
        WebdriverWaits.WaitUntilVisible(viewAllTab);
        click_custom(viewAllTab);
    }
    public void click_FilterButton(){
        wait.WaitUntilVisible(filterButton);
         click_custom(filterButton);
    }
    public void clickOn_ExportCSVButton(){
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("ngx-spinner-overlay"));
        WebdriverWaits.WaitUntilVisible(exportCSVButton);
        click_custom(exportCSVButton);
    }
    public void click_SearchField(String searchFieldText){
        WebdriverWaits.WaitUntilVisible(searchField);
        sendKeys_withClear(searchField,searchFieldText);
    }
    public void enter_Dates(String dateFromText,String toDateText) throws InterruptedException {
        click_custom(dateFrom);
        sendKeys_withClear(dateFrom,dateFromText);
    wait. WaitUntilVisible(toDate);
        click_custom(toDate);
        sendKeys_withClear(toDate,toDateText);
        wait.WaitUntilVisible(searchButton);
        click_custom(searchButton);
    }
    public void clickOn_ViewDetails(){
        click_custom(viewDetails);
    }

    public void allAppointmentsPage(String searchFieldText,String dateFromText,String toDateText) throws InterruptedException {
         WebdriverWaits.WaitUntilVisible(dashBoardPage);
         validate_text(dashBoardPage,"Dashboard");
         click_AppointmentTab();
        validate_text(viewAllTab,"View All");
        Log.info("View all details tab successfully displayed");
        click_ViewAllTab();
        WebdriverWaits.WaitUntilVisible(allAppointmentsPage);
        validate_text(allAppointmentsPage,"All Appointments");
        click_FilterButton();
        WebdriverWaits.WaitUntilVisible(searchByDate);
        enter_Dates(dateFromText, toDateText);
        validate_text(searchByDate,"Hazel Rogers");
        Log.info("Successfully searched created appointment By entering dates");
        getDriver().navigate().refresh();
        click_FilterButton();
        click_SearchField(searchFieldText);
        WebdriverWaits.WaitUntilVisible(searchedText);
        validate_text(searchedText,"Hazel Rogers");
        Log.info("Successfully searched created appointment");
    }
    public void exportCSV_Button(){
        //click_AppointmentTab();
        //click_ViewAllTab();
        clickOn_ExportCSVButton();
    }
    public boolean isFileDownloaded(String fileName) throws InterruptedException {
        Thread.sleep(10000);
        String home = System.getProperty("user.home");
        String file_with_location = home + "/Downloads/" + fileName;
        File file = new File(file_with_location.trim());
        String fileTest = file.getName();
        if (file.exists() && file.length() != 0) {
            System.out.println(file_with_location + " is present with size greater than 0 ");
            extentTest.log(PASS, file_with_location + " is present  with size greater than 0");
            return true;
        } else {
            System.out.println(file_with_location + " is not present");
            extentTest.log(FAIL, file_with_location + " is not  present ");

            return false;
        }
    }
    public String validateDownloadedFile() {
        getDriver().navigate().to("chrome://downloads/");
        ChromeDownloads download = new ChromeDownloads();
        String downloadedFile = download.getFileName();
        System.out.println(downloadedFile);
        return downloadedFile;
    }
    public void View_AllAppointmentsPage(){
        click_AppointmentTab();
        click_ViewAllTab();
    }



}
