package test;
import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;
import static org.automation.utilities.Assertions.validate_text;


public class DiagnosticianTest extends BaseTest {
    public String diagnosticianUserName;
    public String diagnosticianFirstName;
    public String diagnosticianEmailAddress;
    public String diagnosticianLastName;
    public String dia_Cell_Number;


    @Test(priority = 0,enabled = true,description = "Verify that Diagnostician is able to View Today appointment or not")
    public void create_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnosticianFirstName = "AU_Ivy" + RandomStrings.requiredCharacters(2);
        diagnosticianLastName = "AU_Camp" + RandomStrings.requiredCharacters(2);
        diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "AU_Elsie" + RandomStrings.requiredCharacters(2);
        dia_Cell_Number = RandomStrings.requiredDigits(10);
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login =new LoginPage();
        //Login by using superAdmin credentials
       //  login.superAdminLogin();
        panelPage.click_DiagnosticianTab();
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, dia_Cell_Number, diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Successfully SuperAdmin Created diagnostician");

        diagnostician.Verify_Duplicate_Diagnostician(diagnosticianFirstName, diagnosticianLastName, "8564234568",diagnosticianEmailAddress,diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.validationMsg);
        validate_text(diagnostician.validationMsg, "An error occurred while creating the user. Username already exists!");
        //panelPage.click_LogOutLink();
    }

    @Test(priority = 9, enabled = true, description = "SuperAdmin is able to search created diagnostician or not")
    public void search_Created_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.clickOn_BackButton();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Created Diagnostician Displayed In The Diagnostician ListPage");
    }

    @Test(priority = 10, enabled = true, description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Diagnostician() throws InterruptedException {
        String diagnosticianEmailAddress1 = diagnosticianFirstName + "12@yopmail.com";
        Diagnostician diagnostician = new Diagnostician();
        //In Edit-Diagnostician password also changed
        diagnostician.edit_Diagnostician(diagnosticianEmailAddress1, "12345678", "12345678");
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        Log.info("Successfully Edited the created diagnostician");
    }
    @Test(priority = 11, enabled = true, description = "verify that toggle is off or not")
    public void checking_Toggle_Off() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        //checking user is disable or not
        diagnostician.cheking_DisableUser();
        WebdriverWaits.waitUntilVisible(diagnostician.enableUser);
        validate_text(diagnostician.enableUser, "Enable User");
    }
    @Test(priority = 12, enabled = true, description = "Verify that Superadmin is able to diable the user or not")
    public void enable_User() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        diagnostician.enable_DiagnosticianUser();
        // Enabling the user
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        Log.info("Successfully Edited the created diagnostician");
        // panelPage.click_LogOutLink();
    }
    @Test(priority = 13, enabled = true, description = "verify that diagnostician is able to edit or not after clicking Dont save button")
    public void verify_Dia_DontSaveBtn() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.verify_DontSave("5659865589",diagnosticianEmailAddress, "123456", "123456");
        validate_text(diagnostician.UserNameGetText,diagnosticianUserName);
    }
    @Test(priority = 14, enabled = true, description = "Verify Diagnostician is able to login with new password or not")
    public void diagnostician_Relogin() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        panelPage.click_LogOutLink();
        // Login with Diagnostician new password
        login.diagnosticianLogin(diagnosticianUserName, "12345678");
        WebdriverWaits.waitUntilVisible(diagnostician.diagnosticianDashBoardPage);
        validate_text(diagnostician.diagnosticianDashBoardPage, "Dashboard");
    }

    @Test(priority = 15,enabled = true,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        AdminTest admin=new AdminTest();
        SuperAdminTest Superadmin = new SuperAdminTest();
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

//
        login.adminLogin(admin.adminUserName,"12345678");
        dashboard.clickScheduleAppointment();
    }

    @Test(priority = 17, enabled =true, description = "selecting date for appointment")
    public void appointmentCalender() throws InterruptedException {
        LoginPage login = new LoginPage();
        Diagnostician diagnostician = new Diagnostician();
        DashboardPage dashboard = new DashboardPage();
        //dashboard.clickScheduleAppointment();
        diagnostician.createAppointment("Plano");
        diagnostician.appointmentDateSelecting(2);
    }



    @Test(priority = 15, enabled = true, description = "Verify that diagnostician is able to login with old password or not")
    public void diagnostician_login_With_OldPassword() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        //  panelPage.click_LogOutLink();
        // Logging with Old password to get validation message.
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
