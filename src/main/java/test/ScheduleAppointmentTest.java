package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.DashboardPage;
import org.automation.pageObjects.ScheduleAppointmentPage;
import org.testng.annotations.Test;

public class ScheduleAppointmentTest extends BaseTest {

    @Test(priority = 1, enabled = true, description = "To verify schedule appointment")
    public void scheduleAppointment_Admin() throws InterruptedException {
        LoginTest login = new LoginTest();
        DashboardPage dashboard = new DashboardPage();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        login.ValidLogin();
        Thread.sleep(10000);
        dashboard.clickScheduleAppointment();
        Thread.sleep(5000);
    }

     @Test(priority = 2,enabled = true,description = "selecting date for appointment")
    public void appointmentCalender() throws InterruptedException {
        LoginTest login = new LoginTest();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
      //  login.ValidLogin();
        schedule.scheduleAppointment("Plano");
        schedule.appointmentDateSelecting(2);
    }
    @Test(priority = 3,enabled = false,description = "Filling client details")
    public void fillClientDetails(){

    }

    @Test(priority = 4,enabled = true,description = "selecting date for appointment")
    public void cancelAppointment() throws InterruptedException {
        LoginTest login = new LoginTest();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        login.ValidLogin();
        schedule.cancel_Appointment("jui");


    }
}

