package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {
    String diagnosticianUserName;
    String  diagnosticianFirstName;
    String diagnosticianEmailAddress;
    String diagnosticianLastName;
    @Test(priority=0,enabled=false,description = "Create Diagnosticians")
    public void create_Diagnosticians() throws InterruptedException {
        LoginPage login = new LoginPage();
        Diagnostician diagnostician = new Diagnostician();
        login.validLogin("Addy","123456");
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
    public void filter_CreatedAppointment() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.search_ScheduledAppointment(diagnosticianFirstName);
    }

    @Test(priority = 6, enabled = false, description = "creating TestPlan for the created appointment")
    public void testPlanFor_scheduled_Appointment() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.creatingTestPlanForTheAppointment();
    }

}
