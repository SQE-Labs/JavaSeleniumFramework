package test;
import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;
import static org.automation.utilities.Assertions.validate_text;


public class DiagnosticianTest extends BaseTest {
    public String diagnosticianUserName;


    @Test(priority = 15,enabled = true,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        //  login.diagnosticianLogin(Superadmin.diagnosticianUserName,"12345678");
        diagnostician.checking_Availability();
        diagnostician.cancel_Availability();
        diagnostician.deleting_Availability();
    }
    @Test(priority =16, enabled = true, description = "To verify schedule appointment")
    public void scheduleAppointment_Admin() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
     SuperAdminTest admin=new SuperAdminTest();
        login.adminLogin(admin.adminUserName,"12345678");
        dashboard.clickScheduleAppointment();
    }

    @Test(priority = 17, enabled =true, description = "selecting date for appointment")
    public void appointmentCalender() throws InterruptedException {
        LoginPage login = new LoginPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashboardPage dashboard = new DashboardPage();
        //dashboard.clickScheduleAppointment();
        diagnostician.createAppointment("Plano");
        diagnostician.appointmentDateSelecting(2);
    }



    @Test(priority = 15, enabled = true, description = "Verify that diagnostician is able to login with old password or not")
    public void diagnostician_login_With_OldPassword() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        LoginPage login=new LoginPage();
        //  panelPage.click_LogOutLink();
        // Logging with Old password to get validation message.
        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        panelpage.click_LogOutLink();
        login.diagnosticianLogin(diagnosticianUserName,"123456");
        WebdriverWaits.waitUntilVisible(diagnostician.validation_Msg);
        validate_text(diagnostician.validation_Msg, "Username or password is incorrect");
    }

//    @Test(priority = 1,enabled=true,description="Verify that diagnostician is able to set availability or not")
//    public void set_Availability() throws InterruptedException {
//
//        DashBoardPanelPage panelpage=new DashBoardPanelPage();
//        Diagnostician diagnostician = new Diagnostician();
//        LoginPage login=new LoginPage();
//        AdminTest admin=new AdminTest();
//        SuperAdminTest Superadmin = new SuperAdminTest();
//        login.diagnosticianLogin(diagnosticianUserName,"123456");
//
//        diagnostician.checking_Availability();
//        WebdriverWaits.waitUntilVisible(diagnostician.availableSlotText);
//        validate_text(diagnostician.availableSlotText, "Available");
//
//
//        diagnostician.cancel_Availability();
//        diagnostician.deleting_Availability();
//        WebdriverWaits.waitUntilVisible(diagnostician.signUpTitleText);
//        validate_text(diagnostician. signUpTitleText, "Sign in to your account");
//
//    }
//    @Test(priority = 2,enabled = false,description = "Verify that Diagnostician is able to View Today appointment or not")
//    public void View_Appointment1() throws InterruptedException {
//        Diagnostician diagnostician=new Diagnostician();
//        LoginPage login =new LoginPage();
//      //  login.superAdminLogin();
//        diagnostician.today_Appointment("Diognostician doing simple testing");
//        diagnostician.clickOn_BackButton();
//        WebdriverWaits.waitUntilVisible(diagnostician.appointmentDetail);
//        validate_text(diagnostician.appointmentDetail, "Krillin Dash Details");
//    }
}
