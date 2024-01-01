package test;
import org.automation.base.BaseTest;

import org.automation.pageObjects.*;

import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;
import static org.automation.utilities.Assertions.validate_text;
import static test.AdminTest.diagnosticianUserName;



public class DiagnosticianTest extends BaseTest {


@Test(priority = 0,enabled = true,description = "Login as a diagnostician and verify it is diagnostician dashboard page or not")
public void diagnostician_Login(){
    LoginPage login =new LoginPage();
    login.diagnosticianLogin("Au_HumayTNy","12345678");
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
    @Test(priority = 3,enabled=true,description="Diagnostician is Verifying upcoming appointments")
    public void verify_UpcomingAppointments(){
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.clickOn_AppointmentTab();
        diagnostician.upcoming_Appointments();
        WebdriverWaits.waitUntilVisible(diagnostician.upcomingPageTitle);
        validate_text(diagnostician.upcomingPageTitle, "Upcoming Appointments");

    }


}
