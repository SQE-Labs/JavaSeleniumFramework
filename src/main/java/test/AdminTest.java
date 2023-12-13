package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.automation.utilities.Assertions.validate_text;

public class AdminTest extends BaseTest {
    public String diagnosticianUserName;
   public  String  diagnosticianFirstName;
   public  String diagnosticianLastName;
   public String diagnosticianEmailAddress;

   public String directorLastName;

   public String directorEmailAddress;
   public String directorFirstName;

    public String directorUserName;
    public String clientFirstName;
    public String clientLastName;
    public  String clientCellNumber;
    public String clientEmail;



    @Test(priority=0,enabled=false,description = "Create Diagnosticians by admin")
    public void create_Diagnosticians() throws InterruptedException {
        // Login as 'Admin'.
        LoginPage login = new LoginPage();
        DashBoardPanelPage logout = new DashBoardPanelPage();
        Diagnostician diagnostician = new Diagnostician();
        login.validLogin("Allen", "123456");
        diagnosticianFirstName = "AU_josh" + RandomStrings.requiredCharacters(2);
        diagnosticianLastName = "AU_englis" + RandomStrings.requiredCharacters(2);
        diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "marsh" + RandomStrings.requiredCharacters(2);
        diagnostician.create_Diagnostician(diagnosticianFirstName,diagnosticianLastName,"8564234568",diagnosticianEmailAddress,diagnosticianUserName,"123456","123456");
        logout.click_LogOutLink();
    }
    @Test(priority = 1,enabled = false ,description = "Diagnostician setting availability")
    public void diagnostician_Availability() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        DashBoardPanelPage logout = new DashBoardPanelPage();
        schedule.login_As_Diagnostician(diagnosticianUserName,"123456");
        schedule.checking_Availability();
        schedule.cancel_Availability();
        schedule.deleting_Availability();
        logout.click_LogOutLink();
    }
    @Test(priority = 2, enabled = false, description = "To verify schedule appointment")
    public void scheduleAppointment_Admin() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
       login.validLogin("Allen", "123456");
        dashboard.clickScheduleAppointment();
    }

    @Test(priority = 3, enabled = false, description = "selecting date for appointment")
    public void appointmentCalender() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.scheduleAppointment("Woodlands");
        schedule.appointmentDateSelecting(2);
    }

    @Test(priority = 4, enabled = false, description = "Filling client details")
     public void fillClientDetails() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        clientFirstName=RandomStrings.requiredCharacters(6);
        clientLastName=RandomStrings.requiredCharacters(6);
        //clientCellNumber=RandomStrings.requiredDigits(10);
        clientEmail=clientFirstName+ "@yopmail.com";
        schedule.enteringClientDetails( clientFirstName, clientLastName, 2, "19-11-2000",1 , "7654436788", clientEmail, "Other", "1000", "1000");
        validate_text(schedule.actualText,"Appointment Scheduled!!");



    }
    @Test(priority = 5, enabled = false, description = "Verify View client details button on Schedule Appointment popup")
    public void verifyViewDetails() throws InterruptedException{
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.clickOnviewLink();
        String expectedName = clientFirstName+" "+clientLastName;
        validate_text(schedule.fullName,expectedName);

    }

    @Test(priority = 0, enabled = true, description = "Verify All Appointment page.")
    public void verify_AllAppointmentsPage() throws InterruptedException {
        LoginPage login = new LoginPage();
        AppointmentsPage appPage= new AppointmentsPage();
        login.validLogin("Allen", "123456");
        appPage.View_AllAppointmentsPage();
        validate_text(appPage.viewAllActualText,"All Appointments");

    }
    @Test(priority = 1, enabled = true, description = "Verify search textbox")
    public void filter_CreatedAppointment() throws InterruptedException{
        AppointmentsPage appPage= new AppointmentsPage();
        appPage.click_FilterButton();
        //appPage.click_SearchField("Bebe Rexa");
       // WebdriverWaits.WaitUntilVisible(appPage.actualSearchedText);
       // validate_text(appPage.actualSearchedText,"Bebe Rexa");

    }
    @Test(priority = 2, enabled = false, description = "Verify CSV file gets exported")
    public void verify_ExportCsvbtn() throws InterruptedException{
        AppointmentsPage appPage= new AppointmentsPage();
        appPage.exportCSV_Button();
    }
    @Test(priority = 3, enabled = false, description = "Validate file is downloaded")
    public void validate_DownloadedFile() throws InterruptedException{
        AppointmentsPage appPage= new AppointmentsPage();
        appPage.validateDownloadedFile();

    }
    @Test(priority = 4, enabled = false, description = "Validate file is downloaded")
    public void is_Downloaded() throws InterruptedException{
        AppointmentsPage appPage= new AppointmentsPage();
        appPage.validateDownloadedFile();
    }
    @Test(priority = 2, enabled = true, description = "Verify search fromDate and toDate")
    public void verify_FromAndToDate() throws InterruptedException{
        AppointmentsPage appPage= new AppointmentsPage();
        ActionEngine engine=new ActionEngine();
        String toDate= DateGenerator.getCurrentDate();
        String FromDate= DateGenerator.getDateWithDays("yyyy-MM-dd",-2);
        appPage.enter_Dates(FromDate,toDate);
        WebdriverWaits.WaitUntilVisible(appPage.dateElements);
        List <WebElement> my_list = engine.getWebElements(appPage.dateElements);
        HashSet<WebElement> dateSet = new HashSet<>(my_list);

        LocalDate toDateLocal= LocalDate.parse(toDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate fromDateLocal= LocalDate.parse(FromDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        boolean result = true;
                for (WebElement i:dateSet){
            String date =i.getText();
            LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            System.out.println(inputDate);
            if( !(DateGenerator.isDateWithinRange(fromDateLocal,toDateLocal,inputDate))){
               result=false;
                break;
            }
        }

        Assert.assertTrue(result);






    }



    @Test(priority = 6, enabled = false, description = "creating TestPlan for the created appointment")
    public void testPlanFor_scheduled_Appointment() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.creatingTestPlanForTheAppointment();
    }



    //****************Creating directors by Admin**************//

    @Test(priority = 0, enabled = false, description = "Creating Director from admin" )
    public void create_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        LoginPage login =new LoginPage();
        login.validLogin("Allen", "123456");
        directorFirstName = "AU_Zoi"+ RandomStrings.requiredCharacters(1);
        directorLastName = "AU_Kama"+ RandomStrings.requiredCharacters(1);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "AU_Zpi" + RandomStrings.requiredCharacters(3);
        String directorPhoneNumber = RandomStrings.requiredDigits(10);
        director.create_Director(directorFirstName,directorLastName, directorPhoneNumber, directorEmailAddress,directorUserName, "123456", "123456");
        WebdriverWaits.WaitUntilVisible(director.actualText);
        validate_text(director.actualText,directorUserName);
        Log.info("Created Director Displayed In The Director ListPage");
    }
    // ******************Editing the director*************//
    @Test(priority = 1, enabled = false, description = "Creating Director from admin" )
    public void edit_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        directorEmailAddress = directorFirstName + "010@yopmail.com";
        director.edit_Director(directorEmailAddress,"12345678","12345678");
        WebdriverWaits.WaitUntilVisible(director.edit_SuccMsg);
        validate_text(director.edit_SuccMsg,"Director details updated successfully.");
        System.out.println("Successfully Edited the created director");


    }

    @Test(priority = 2, enabled = false, description = "Checking Whether toggle is off or not" )
    public void director_Checking_Toggle_Off() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.cheking_DisableUser();
        WebdriverWaits.WaitUntilVisible(director.enableUser);
        validate_text(director.enableUser, "Enable User");

    }
    @Test(priority = 3, enabled = false, description = "Enable toggle button Director from admin" )
    public void director_Enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enable_Director();
        validate_text(director.edit_SuccMsg,"Director details updated successfully.");
        System.out.println("Successfully Edited the created director");
    }

    @Test(priority = 4,enabled = false,description="verify that director is able to edit or not after clicking dont save button")
    public void Verify_DntSave_Button() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        String  directorEmailAddressUpdated = directorFirstName + "101@yopmail.com";
        director.not_Edit_Director(directorEmailAddressUpdated,"123456","123456");
        WebdriverWaits.WaitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);

    }
    @Test(priority = 5, enabled = false, description = "Creating Director from admin" )
    public void director_Relogin() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.Relogin_With_newPassword(directorUserName, "12345678");
        WebdriverWaits.WaitUntilInvisible(director.spinner);
        WebdriverWaits.WaitUntilVisible(director.directorDashBoardPage);
        validate_text(director.directorDashBoardPage, "Dashboard");
    }
    //**************Creating Diagnostician****************///
    @Test(priority = 0, enabled = false, description = "Create Diagnostician by admin")
    public void create_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        // Login as 'Admin'
        LoginPage login =new LoginPage();
        login.validLogin("Allen", "123456");
        // Create diagnostician
        diagnosticianFirstName = "AU_Zoi"+ RandomStrings.requiredCharacters(1);
        diagnosticianLastName = "AU_smith"+ RandomStrings.requiredCharacters(1);
        diagnosticianUserName= "AU_s" + RandomStrings.requiredCharacters(3);
        diagnosticianEmailAddress = diagnosticianFirstName+ "10@yopmail.com";
        String diagnosticianPhoneNumber = RandomStrings.requiredDigits(10);
        diagnostician.create_Diagnostician(diagnosticianFirstName,diagnosticianLastName,diagnosticianPhoneNumber,diagnosticianEmailAddress,diagnosticianUserName,"123456","123456");
        WebdriverWaits.WaitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText,diagnosticianUserName);
    }
    @Test(priority = 1,enabled = false, description = "Edit created diagnostician by admin")
    public void Edit_Diagnostician() throws InterruptedException{
        Diagnostician diagnostician = new Diagnostician();
        // Edit Diagnostician
        String diagnosticianPhoneNumber = RandomStrings.requiredDigits(10);
        String diagnosticianUpdatedEmail= diagnosticianFirstName + "10@yopmail.com";
        diagnostician.edit_Diagnostician(diagnosticianPhoneNumber,diagnosticianUpdatedEmail,"1234567","1234567");

    }
    @Test(priority = 2,enabled = false, description = "Enable created diagnostician by admin")
    public void Enable_CreateDiagnostician()throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        //Enable disabled Diagnostician
        diagnostician.enable_DiagnosticianUser();
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        System.out.println("Diagnostician details updated successfully.");
    }

    @Test(priority = 3,enabled = false, description = "Search created diagnostician by admin")
    public void search_Diagnostician() throws InterruptedException{
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        WebdriverWaits.WaitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Created Diagnostician Displayed In The Diagnostician ListPage");
    }
    @Test(priority = 4,enabled = false, description = "Verify Don't save button diagnostician by admin")
    public void verify_Dnt_SaveButton() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        String diagnosticianPhoneNumber= RandomStrings.requiredDigits(10);
        String diagnosticianUpdatedEmail= diagnosticianFirstName + "10@yopmail.com";
        diagnostician.verify_DontSave(diagnosticianPhoneNumber,diagnosticianUpdatedEmail,"1234567","1234567");
        WebdriverWaits.WaitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText,diagnosticianUserName);
    }
    @Test(priority = 5,enabled = false, description = "Diagnostician Relogin")
    public void diagnostician_Relogin() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.Relogin_With_newPassword(directorUserName, "12345678");
        WebdriverWaits.WaitUntilInvisible(diagnostician.spinner);
        WebdriverWaits.WaitUntilVisible(diagnostician.diagnosticianDashBoardPage);
        validate_text(diagnostician.diagnosticianDashBoardPage, "Dashboard");
    }
















}
