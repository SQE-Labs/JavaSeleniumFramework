package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    DiagnosticianTest dia = new DiagnosticianTest();
    @Test(priority = 1,enabled = true,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability() throws InterruptedException {

        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        AdminTest admin=new AdminTest();
        SuperAdminTest Superadmin = new SuperAdminTest();
        login.diagnosticianLogin(dia.diagnosticianUserName,"12345678");
        diagnostician.checking_Availability();
        diagnostician.cancel_Availability();
        diagnostician.deleting_Availability();
    }
    @Test(priority = 2, enabled = true, description = "To verify schedule appointment")
    public void scheduleAppointment_Admin() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        Diagnostician diagnostician = new Diagnostician();
        //login.validLogin();
        Thread.sleep(5000);
        diagnostician.login_As_Diagnostician("addy","123456");
        Thread.sleep(5000);
        dashboard.clickScheduleAppointment();
        Thread.sleep(5000);
    }

    @Test(priority = 3, enabled = true, description = "selecting date for appointment")
    public void appointmentCalender() throws InterruptedException {
        LoginTest login = new LoginTest();
        Diagnostician diagnostician = new Diagnostician();

        // login.ValidLogin();
        diagnostician.createAppointment("Plano");
        diagnostician.appointmentDateSelecting(2);
    }

    @Test(priority = 4, enabled = true, description = "Filling client details")
    public void fillClientDetails() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        SuperAdminTest Superadmin = new SuperAdminTest();
        diagnostician.enteringClientDetails( dia.diagnosticianFirstName, dia.diagnosticianLastName, 2, "19-11-1997",2, "4567892658", dia.diagnosticianEmailAddress, "Math", "NSW", " Tasmania", " Barkers Creek", "South Australia", "5422", "1200", "1000");
    }

    @Test(priority = 5, enabled = true, description = "filter and viewing created appointment in detail")
    public void filter_CreatedAppointment() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        SuperAdminTest Superadmin = new SuperAdminTest();
        diagnostician.search_ScheduledAppointment(dia.diagnosticianFirstName);
    }

    @Test(priority = 6, enabled = true, description = "creating TestPlan for the created appointment")
    public void testPlanFor_scheduled_Appointment() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.creatingTestPlanForTheAppointment();
    }

}
