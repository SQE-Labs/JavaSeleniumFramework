package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

import static org.automation.utilities.Assertions.validate_text;

public class AdminTest extends BaseTest {
    public String diagnosticianUserName;
   public  String  diagnosticianFirstName;
   public  String diagnosticianLastName;
   public String diagnosticianEmailAddress;

   public String directorFirstName;

    public String directorUserName;

    @Test(priority=0,enabled=false,description = "Create Diagnosticians")
    public void create_Diagnosticians() throws InterruptedException {
        LoginPage login = new LoginPage();
        Diagnostician diagnostician = new Diagnostician();
        login.validLogin();
         diagnosticianFirstName = "josh" + RandomStrings.requiredCharacters(2);
        diagnosticianLastName = "englis" + RandomStrings.requiredCharacters(2);
        diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "marsh" + RandomStrings.requiredCharacters(2);
        diagnostician.create_Diagnostician(diagnosticianFirstName,diagnosticianLastName,"8564234568",diagnosticianEmailAddress,diagnosticianUserName,"123456","123456");
    }
    @Test(priority = 1,enabled = false,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.login_As_Diagnostician(diagnosticianUserName,"123456");
        schedule.checking_Availability();
        schedule.cancel_Availability();
        schedule.deleting_Availability();
    }
    @Test(priority = 2, enabled = false, description = "To verify schedule appointment")
    public void scheduleAppointment_Admin() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        //login.validLogin();
        Thread.sleep(5000);
        schedule.login_As_Diagnostician("addy","123456");
        Thread.sleep(5000);
        dashboard.clickScheduleAppointment();
        Thread.sleep(5000);
    }

    @Test(priority = 3, enabled = false, description = "selecting date for appointment")
    public void appointmentCalender() throws InterruptedException {
        LoginTest login = new LoginTest();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        // login.ValidLogin();
        schedule.scheduleAppointment("Plano");
        schedule.appointmentDateSelecting(2);
    }

    @Test(priority = 4, enabled = false, description = "Filling client details")
    public void fillClientDetails() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.enteringClientDetails( diagnosticianFirstName, diagnosticianLastName, 2, "19-11-1997",2, "4567892658", diagnosticianEmailAddress, "Math", "NSW", " Tasmania", " Barkers Creek", "South Australia", "5422", "1200", "1000");
    }

    @Test(priority = 5, enabled = false, description = "filter and viewing created appointment in detail")
    public void filter_Created_Appointment() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.search_ScheduledAppointment(diagnosticianFirstName);
    }

    @Test(priority = 6, enabled = false, description = "creating TestPlan for the created appointment")
    public void testPlanFor_scheduled_Appointment() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.creatingTestPlanForTheAppointment();
    }



    //****************Creating directors by Admin**************//
    @Test(priority = 0, enabled = true, description = "Creating Director from admin" )
    public void create_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        LoginPage login =new LoginPage();
        login.validLogin();
        String directorFirstName = "AU_Zoya"+ RandomStrings.requiredCharacters(1);
        String directorLastName = "AU_Kamath"+ RandomStrings.requiredCharacters(1);
        String emailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "AU_Maxi" + RandomStrings.requiredCharacters(1);
        String directorPhoneNumber = RandomStrings.requiredDigits(10);
       director.create_Director(directorFirstName,directorLastName, directorPhoneNumber, emailAddress,directorUserName, "123456", "123456");
        WebdriverWaits.WaitUntilVisible(director.actualText);
        validate_text(director.actualText,directorUserName);
        Log.info("Created Director Displayed In The Director ListPage");
    }
    // ******************Editing the director*************//
    @Test(priority = 1, enabled = true, description = "Creating Director from admin" )
    public void edit_Director() throws InterruptedException {
        LoginPage login =new LoginPage();
        DirectorPage director = new DirectorPage();
      //  login.validLogin();
        String directorEmailAddressUpdate = directorFirstName + "01@yopmail.com";
        director.edit_Director(directorEmailAddressUpdate,"12345678","12345678");
        WebdriverWaits.WaitUntilVisible(director.edit_SuccMsg);
        validate_text(director.edit_SuccMsg,"Director details updated successfully.");

        System.out.println("Successfully Edited the created director");
    }

    @Test(priority = 2, enabled = true, description = "Checking Whether toggle is off or not" )
    public void director_Checking_Toggle_Off() throws InterruptedException {
        DirectorPage director = new DirectorPage();
      //  LoginPage login =new LoginPage();
        //login.validLogin();
        director.cheking_DisableUser();
        WebdriverWaits.WaitUntilVisible(director.enableUser);
        validate_text(director.enableUser, "Enable User");

    }
    @Test(priority = 3, enabled = true, description = "Enable toggle button Director from admin" )
    public void director_Enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enable_Director();
        validate_text(director.edit_SuccMsg,"Director details updated successfully.");
        System.out.println("Successfully Edited the created director");
    }
    @Test(priority = 4,enabled = true,description="verify that director is able to edit or not after clicking dont save button")
    public void Verify_DntSave_Button() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        //LoginPage login =new LoginPage();
       // login.validLogin();
       String  directorEmailAddressUpdated = directorFirstName + "101@yopmail.com";
        director.not_Edit_Director(directorEmailAddressUpdated,"123456","123456");
        WebdriverWaits.WaitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);

    }




}
