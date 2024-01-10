package test;
import org.automation.base.BaseTest;

import org.automation.pageObjects.*;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;

import static org.automation.utilities.Assertions.validate_text;



public class DiagnosticianTest extends BaseTest {


@Test(priority = 0,enabled = true,description = "Login as a diagnostician and verify it is diagnostician dashboard page or not")
public void diagnostician_Login(){
    LoginPage login =new LoginPage();
    AdminTest test=new AdminTest();
    login.diagnosticianLogin("Au_HumayqvC","123456");
    DiagnosticianPage diagnostician = new DiagnosticianPage();
    WebdriverWaits.waitUntilVisible(diagnostician.dashboard);
    validate_text(diagnostician.dashboard, "Dashboard");
}
    @Test(priority = 1,enabled = true,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability()  {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.set_Availability();
        diagnostician.cancel_Availability();
        diagnostician.deleting_Availability();
    }
    @Test(priority = 2,enabled=true,description="Diagnostician is Verifying upcoming appointments")
    public void verify_UpcomingAppointments(){
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.clickOn_AppointmentTab();
        diagnostician.clickOn_upcomingTab();
        WebdriverWaits.waitUntilVisible(diagnostician.upcomingPageTitle);
        validate_text(diagnostician.upcomingPageTitle, "Upcoming Appointments");
    }
    @Test(priority = 4,enabled = true,description = "Verify diagnostician is able to download csv file or not")
    public void download_CSV_File() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        Thread.sleep(5000);
        WebdriverWaits.waitForSpinner();
       // diagnostician.clickOn_upcomingTab();
        appointment.clickOn_ExportCSVButton();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
    }
    @Test(priority = 4,enabled = false,description = "Verify diagnostian client details page")
    public void verify_ClientDetailsPage(){
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        AdminTest test=new AdminTest();
        diagnostician.view_ClientDetail(test.clientLastName);
        WebdriverWaits.waitUntilVisible(diagnostician.clientDetailText );
        validate_text(diagnostician. clientDetailText, test.clientFirstName+' '+test.clientLastName+' '+"Details");
    }
    @Test(priority = 3,enabled=true,description = "Diagnostician is verifying  that relevant records appear after selecting valid range of date, on 'Upcoming Appointments' page.")
    public void verify_FromAndTodate() throws InterruptedException {
        AppointmentsPage appPage= new AppointmentsPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        ActionEngine action=new ActionEngine();
       // action.navigate_Back();

        WebdriverWaits.waitForSpinner();
       // diagnostician.clickOn_upcomingTab();
        diagnostician.click_filterButton();
        ActionEngine engine;
        engine = new ActionEngine();
        String toDate= DateGenerator.getCurrentDate();
        String FromDate= DateGenerator.getDateWithDays("dd-MM-yyyy",-2);
        appPage.enter_Dates(FromDate,toDate);
        WebdriverWaits.waitUntilVisible(appPage.dateElements);
        List<WebElement> my_list = engine.getWebElements(appPage.dateElements);
        HashSet<WebElement> dateSet = new HashSet<>(my_list);

        LocalDate toDateLocal= LocalDate.parse(toDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fromDateLocal= LocalDate.parse(FromDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        boolean result = true;
        for (WebElement i:dateSet){
            String date =i.getText();
            LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMM dd,yyyy"));
            System.out.println(inputDate);

            if( !(DateGenerator.isDateWithinRange(fromDateLocal,toDateLocal,inputDate))){
                result=false;
                break;
            }
        }
        Assert.assertTrue(result);
    }


    }

