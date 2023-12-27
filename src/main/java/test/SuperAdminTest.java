package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.automation.utilities.Assertions.validate_text;


public class SuperAdminTest extends BaseTest {

    public String diagnosticianUserName;
    public String diagnosticianFirstName;
    public String diagnosticianEmailAddress;
    public String directorFirstName;
    public String directorLastName;
    public String directorEmailAddress;
    public String directorUserName;
    public String adminUserName;
    public String adminFirstName;
    public String adminEmailAddress;
public String adminLastName;
public String diagnosticianLastName;

    LoginPage login = new LoginPage();


    @Test(priority = 0, enabled = true, description = "Verify that SuperAdmin is able to create Admin or not")
    public void create_Admin() throws InterruptedException {
        adminFirstName = "AU_Zane" + RandomStrings.requiredCharacters(2);
         adminLastName = "AU_Geake" + RandomStrings.requiredCharacters(2);
        adminEmailAddress = adminFirstName + "@yopmail.com";
        adminUserName = "AU_Snack" + RandomStrings.requiredCharacters(2);
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login =new LoginPage();

        //Login by using superAdmin credentials
        login.superAdminLogin();
        AdminPage admin=new AdminPage();
        panelPage.click_On_AdminTab();
        WebdriverWaits.WaitUntilVisible(admin.dashboardPage );
        validate_text(admin.dashboardPage, "Admins List");

        admin.create_Admin(adminFirstName,adminLastName, "8564234568", adminEmailAddress, adminUserName, "123456", "123456");
        WebdriverWaits.WaitUntilVisible(admin.succ_Msg );
        validate_text(admin.succ_Msg, "Admin Created Successfully");
    }
    @Test(priority = 1, enabled = true, description = "SuperAdmin is able to search created admin or not")
    public void search_Created_Admin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.clickOn_BackButton();
        admin.search_CreatedAdmin(adminUserName);
        WebdriverWaits.WaitUntilVisible(admin.actualText);
        validate_text(admin.actualText, adminUserName);
        Log.info("Created Diagnostician Displayed In The Diagnostician ListPage");
    }

    @Test(priority = 2, enabled = true, description = "Super admin is able to edit the created admin or not")
    public void edit_Admin() throws InterruptedException {
        String adminEmailAddress1 = adminFirstName + "12@yopmail.com";
        AdminPage admin = new AdminPage();
        //In Edit-Diagnostician password also changed
        admin.edit_Admin(adminEmailAddress1, "12345678", "12345678");

        validate_text(admin.Succ_Msg_Upd, "Successfully Edited the created Admin");
    }
    @Test(priority = 3, enabled = true, description = "verify that toggle is off or not")
    public void checking_Toggle_OffIn_Admin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        //checking user is disable or not
        admin.cheking_DisableUser();
        WebdriverWaits.WaitUntilVisible(admin.enableUser);
        validate_text(admin.enableUser, "Enable User");
    }
    @Test(priority = 4, enabled = true, description = "Verify that Superadmin is able to enable the user or not")
    public void enable_User_In_Admin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        admin.enable_Admin();
        // Enabling the user
        validate_text(admin.Succ_Msg_Upd, "Diagnostician details updated successfully.");

    }
    @Test(priority = 5, enabled = true, description = "Verify Admin is able to login with new password or not")
    public void admin_Relogin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_LogOutLink();
        // Login with Admin new password
        login.re_Login(adminUserName, "12345678");
        WebdriverWaits.WaitUntilVisible(admin.dashboard);
        validate_text(admin.dashboard, "Dashboard");
    }
    @Test(priority = 6, enabled = true, description = "verify that diagnostician is able to edit or not after clicking Dont save button")
    public void verify_Adm_DontSaveBtn() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_LogOutLink();
        // Login with Admin new password
        login.superAdminLogin();
        panelPage.click_On_AdminTab();
        admin.verify_DontSave(adminEmailAddress, "123456", "123456");
        WebdriverWaits.WaitUntilVisible(admin.userNameText);
        validate_text(admin.userNameText, adminUserName);
    }
    @Test(priority = 7,enabled = true,description = "Verify that superadmin is able create admin with duplicate username or not")
    public void Verify_Duplicate_UserName() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        admin.create_Admin(adminFirstName,adminLastName, "8564234568", adminEmailAddress, adminUserName, "123456", "123456");
        WebdriverWaits.WaitUntilVisible(admin.Error_Msg);
        validate_text(admin.Error_Msg, "An error occurred while creating the admin. Error: Username is already exist!");
        panelPage.clickOn_BackButton();
    }
    @Test(priority = 8, enabled = true, description = "SuperAdmin is able to create Diagnostician")
    public void create_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnosticianFirstName = "AU_Nate" + RandomStrings.requiredCharacters(2);
         diagnosticianLastName = "AU_Connor" + RandomStrings.requiredCharacters(2);
        diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "AU_Wints" + RandomStrings.requiredCharacters(2);
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        //Login by using superAdmin credentials
       // login.superAdminLogin();
        panelPage.click_DiagnosticianTab();
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, "8564234568", diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.WaitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Successfully SuperAdmin Created diagnostician");
       // diagnostician.Verify_Duplicate_Diagnostician(diagnosticianFirstName, diagnosticianLastName, "8564234568", diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.WaitUntilVisible(diagnostician.validationMsg);
        validate_text(diagnostician.validationMsg, "Duplicate UserName value not accepted");
        panelPage.clickOn_BackButton();
    }

    @Test(priority = 9, enabled = true, description = "SuperAdmin is able to search created diagnostician or not")
    public void search_Created_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.clickOn_BackButton();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        WebdriverWaits.WaitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Created Diagnostician Displayed In The Diagnostician ListPage");
    }

    @Test(priority = 10, enabled = true, description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Diagnostician() throws InterruptedException {
        String diagnosticianEmailAddress1 = diagnosticianFirstName + "12@yopmail.com";
        Diagnostician diagnostician = new Diagnostician();
        //In Edit-Diagnostician password also changed
       // diagnostician.edit_Diagnostician(diagnosticianEmailAddress1, "12345678", "12345678");
        WebdriverWaits.WaitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        Log.info("Successfully Edited the created diagnostician");
    }

    @Test(priority = 12, enabled = true, description = "Verify that Superadmin is able to diable the user or not")
    public void enable_User() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        diagnostician.enable_DiagnosticianUser();
        // Enabling the user
        WebdriverWaits.WaitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        Log.info("Successfully Edited the created diagnostician");
       // panelPage.click_LogOutLink();
    }
    @Test(priority = 13, enabled = true, description = "verify that diagnostician is able to edit or not after clicking Dont save button")
    public void verify_Dia_DontSaveBtn() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.verify_DontSave("5659865589", diagnosticianEmailAddress, "123456", "123456");
        validate_text(diagnostician.UserNameGetText, diagnosticianUserName);
    }
    @Test(priority = 14, enabled = true, description = "Verify Diagnostician is able to login with new password or not")
    public void diagnostician_Relogin() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_LogOutLink();
        // Login with Diagnostician new password
        login.diagnosticianLogin(diagnosticianUserName, "12345678");
        WebdriverWaits.WaitUntilVisible(diagnostician.diagnosticianDashBoardPage);
        validate_text(diagnostician.diagnosticianDashBoardPage, "Dashboard");
    }

    @Test(priority = 15,enabled = true,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        AdminTest admin=new AdminTest();
        SuperAdminTest Superadmin = new SuperAdminTest();
      //  login.diagnosticianLogin(Superadmin.diagnosticianUserName,"12345678");
        schedule.checking_Availability();
        schedule.cancel_Availability();
        schedule.deleting_Availability();
    }
    @Test(priority =16, enabled = true, description = "To verify schedule appointment")
    public void scheduleAppointment_Admin() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        //login.validLogin();
        Thread.sleep(5000);
        login.adminLogin(adminUserName,"12345678");
        Thread.sleep(5000);
        dashboard.clickScheduleAppointment();
        Thread.sleep(5000);
    }

    @Test(priority = 17, enabled = true, description = "selecting date for appointment")
    public void appointmentCalender() throws InterruptedException {
        LoginTest login = new LoginTest();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();

        // login.ValidLogin();
        schedule.scheduleAppointment(3);
        schedule.appointmentDateSelecting(2);
    }

    @Test(priority = 18, enabled = true, description = "Filling client details")
    public void fillClientDetails() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        SuperAdminTest Superadmin = new SuperAdminTest();
       // schedule.enteringClientDetails( diagnosticianFirstName,diagnosticianLastName, 2, "19-11-1997",2, "4567892658",diagnosticianEmailAddress, "Math", "NSW", " Tasmania", " Barkers Creek", "South Australia", "5422", "1200", "1000");

    }

    @Test(priority = 15, enabled = false, description = "Verify that diagnostician is able to login with old password or not")
    public void diagnostician_login_With_OldPassword() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_LogOutLink();
        // Logging with Old password to get validation message.
        login.diagnosticianLogin(diagnosticianUserName,"123456");
        WebdriverWaits.WaitUntilVisible(diagnostician.validation_Msg);
        validate_text(diagnostician.validation_Msg, "Username or password is incorrect");
    }

    //DIRECTOR-----------------------------------------------------------------------------------

    @Test(priority = 19, enabled = true, description = "verify that SuperAdmin is able to create Director or not")
    public void create_Directors() throws InterruptedException {

        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        panelPage.click_LogOutLink();
        //Login with super Admin credentials
        login.superAdminLogin();//login
        panelPage.click_DirectorTab();
        director.create_Director(directorFirstName, directorLastName, "5236458965", directorEmailAddress, directorUserName, "123456", "123456");
        validate_text(director.directorListPage, "Directors List");
        director.Verify_Duplicate_Director(directorFirstName, directorLastName, "8564234568", directorEmailAddress, directorUserName, "123456", "123456");
        //validate_text(director.validationMsg, "Duplicate UserName value not accepted");
        // panelPage.clickOn_BackButton();
    }
    @Test(priority=20,enabled = true,description = "Verify that Director is able to login with valid credentials or not")
    public void director_Availability() throws InterruptedException {
        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
      //  login.directorLogin("AU_Hulkx","12345678");
        validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        validate_text(director.viewAll, "View All");
        panelPage.clickOn_AvailabilityTab();
        validate_text(director.monthHeader, "December");
        validate_text(director.yearHeader, "2023");
        validate_text(director.dateHeader, "13");
        //director.director_Availability();
        panelPage.click_LogOutLink();

    }

    @Test(priority = 21, enabled = true, description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Director() throws InterruptedException {
        String directorEmailAddress1 = directorFirstName + "12@yopmail.com";
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.clickOn_BackButton();
        //director changing the password.
        director.edit_Director(directorEmailAddress1, "12345678", "12345678");
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        Log.info("Successfully Edited the created director");
    }
    @Test(priority = 22, enabled = true, description = "verify that superadmin is able to check toggle button is enable or disable")
    public void director_checking_Toggle_Off() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.cheking_DisableUser();
        validate_text(director.enableUser, "Enable User");
    }


    @Test(priority = 25, enabled = true, description = "Verify Diagnostician is able to login with new password or not")
    public void director_Relogin() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        //Director trying to login with new password
        login.re_Login(directorUserName, "12345678");
        validate_text(director.directorDashBoardPage, "Dashboard");
        panelPage.click_LogOutLink();
    }

    @Test(priority = 26, enabled = true, description = "Verify that diagnostician is able to login with old password or not")
    public void login_With_OldPassword() throws InterruptedException {
        DirectorPage director = new DirectorPage();
       DashBoardPanelPage panelPage=new DashBoardPanelPage();
        //Director trying to login with old password
        login.directorLogin(directorUserName, "123456");
        validate_text(director.validation_Msg, "Username or password is incorrect");

        panelPage.click_LogOutLink();
    }




    @Test(priority = 30, enabled = true, description = "Verify that CSV file gets downloaded after clicking 'Export to CSV' button, on 'All Appointments' page")
    public void download_CSV_File() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        appointment.exportCSV_Button();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
    }

    //**********************SuperAdmin is viewing Payments page********************
    @Test(priority = 31, enabled = true, description = "Verify that superAdmin is able to view payment page or not")
    public void view_Payments_Page() throws InterruptedException {
        WebdriverWaits wait = new WebdriverWaits();
        PaymentPage payment = new PaymentPage();
        wait.Back_To_Page();
        payment.clickOn_PaymentTab();
        WebdriverWaits.WaitUntilVisible(payment.paymentListPage);
        validate_text(payment.paymentListPage, "Payments List");
    }

    @Test(priority = 32, enabled = true, description = "Verify that superAdmin is able to search perticular payment or not")
    public void search_Payment() throws InterruptedException {
        PaymentPage payment = new PaymentPage();
        payment.click_filterButton();
        payment.enterInSearchField("Guard");
        WebdriverWaits.WaitUntilVisible(payment.cust_Name);
        validate_text(payment.cust_Name, "Guard Bittle");
    }

    @Test(priority = 33, enabled = true, description = "Verify admin is able to download csv file or not")
    public void download_ExportCSV_File() throws InterruptedException {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        WebdriverWaits wait = new WebdriverWaits();
        panelpage.clickOn_ExportCSVButton();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
        wait.Back_To_Page();
        panelpage.click_LogOutLink();
    }
}



