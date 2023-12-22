package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.automation.utilities.Assertions.validate_text;


public class SuperAdminTest extends BaseTest {


    public String directorFirstName;
    public String directorLastName;
    public String directorEmailAddress;
    public String directorUserName;
    public String adminUserName;
    public String adminFirstName;
    public String adminEmailAddress;

public String adminLastName;

public String admin_cell_Number;
    public String dir_Cell_Number;


    LoginPage login = new LoginPage();
    DiagnosticianTest dia=new DiagnosticianTest();
    DirectorTest director=new DirectorTest();


    @Test(priority = 0, enabled = true, description = "Verify that SuperAdmin is able to create Admin or not")
    public void create_Admin() throws InterruptedException {

        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login =new LoginPage();

        //Login by using superAdmin credentials
        login.superAdminLogin();
        AdminPage admin=new AdminPage();
        panelPage.click_On_AdminTab();
        adminFirstName = "AU_Kelv" + RandomStrings.requiredCharacters(2);
        adminLastName = "AU_Pars" + RandomStrings.requiredCharacters(2);
        adminEmailAddress = adminFirstName + "@yopmail.com";
        adminUserName = "AU_Imle" + RandomStrings.requiredCharacters(2);
        admin_cell_Number = RandomStrings.requiredDigits(10);
        WebdriverWaits.waitUntilVisible(admin.dashboardPage );
        validate_text(admin.dashboardPage, "Admins List");

        admin.create_Admin(adminFirstName,adminLastName,  admin_cell_Number, adminEmailAddress, adminUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(admin.succ_Msg );
        validate_text(admin.succ_Msg, "Admin Created Successfully");
    }
    @Test(priority = 1, enabled = true, description = "SuperAdmin is able to search created admin or not")
    public void search_Created_Admin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.clickOn_BackButton();
        admin.search_CreatedAdmin(adminUserName);
        WebdriverWaits.waitUntilVisible(admin.actualText);
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
        WebdriverWaits.waitUntilVisible(admin.enableUser);
        validate_text(admin.enableUser, "Enable User");
    }
    @Test(priority = 4, enabled = true, description = "Verify that Superadmin is able to enable the user or not")
    public void enable_User_In_Admin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        admin.enable_Admin();
        // Enabling the user
        validate_text(admin.Succ_Msg_Upd, "Admin details updated successfully.");

    }
    @Test(priority = 5, enabled = true, description = "Verify Admin is able to login with new password or not")
    public void admin_Relogin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_LogOutLink();
        // Login with Admin new password
        login.re_Login(adminUserName, "12345678");
        WebdriverWaits.waitUntilVisible(admin.dashboard);
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
        WebdriverWaits.waitUntilVisible(admin.userNameText);
        validate_text(admin.userNameText, adminUserName);
    }
    @Test(priority = 7,enabled = true,description = "Verify that superadmin is able create admin with duplicate username or not")
    public void verify_Duplicate_UserName() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        admin.create_Admin(adminFirstName,adminLastName,  admin_cell_Number, adminEmailAddress, adminUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(admin.Error_Msg);
        validate_text(admin.Error_Msg, "An error occurred while creating the admin. Username already exists!");
        panelPage.click_LogOutLink();
    }
    @Test(priority = 8, enabled = true, description = "SuperAdmin is able to create Diagnostician")
    public void create_Diagnostician_By_SuperAdmin() throws InterruptedException {
        //Login by using superAdmin credentials
        login.superAdminLogin();
        dia.create_Diagnostician();
    }

    @Test(priority = 9, enabled = true, description = "SuperAdmin is able to search created diagnostician or not")
    public void search_Created_Diagnostician_In_SuperAdmin() throws InterruptedException {
        dia.search_Created_Diagnostician();
    }

    @Test(priority = 10, enabled = true, description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Diagnostician_By_SuperAdmin() throws InterruptedException {
        dia.edit_Diagnostician();
    }
    @Test(priority = 11, enabled = true, description = "verify that toggle is off or not")
    public void verifying_Toggle_Off_diag_By_SuperAdmin() throws InterruptedException {
        dia.checking_Toggle_Off();
    }
    @Test(priority = 12, enabled = true, description = "Verify that Superadmin is able to diable the user or not")
    public void enable_ToggleOfDia_By_SuperAdmin() throws InterruptedException {
       dia.enable_User();
    }
    @Test(priority = 13, enabled = true, description = "verify that diagnostician is able to edit or not after clicking Dont save button")
    public void verify_Dia_DontSaveBtn() throws InterruptedException {
        dia.verify_Dia_DontSaveBtn();
    }
    @Test(priority = 14, enabled = true, description = "Verify Diagnostician is able to login with new password or not")
    public void diagnostician_Relogin() throws InterruptedException {
       dia.diagnostician_Relogin();
    }

    @Test(priority = 15,enabled = true,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability() throws InterruptedException {
        dia.diagnostician_Availability();
    }
    @Test(priority =17, enabled = true, description = "To verify schedule appointment")
    public void scheduleAppointment_Admin() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();

       // Login as a Admin
       login.adminLogin(adminUserName,"12345678");
        dashboard.clickScheduleAppointment();
    }

    @Test(priority = 18, enabled =true, description = "selecting date for appointment")
    public void appointmentCalenderInAdmin() throws InterruptedException {
        AdminTest admin=new AdminTest();
        admin.appointmentCalender();
    }

    @Test(priority = 19, enabled = true, description = "Filling client details")
    public void fillClientDetails() throws InterruptedException {
        ClientDetailsPage detailPage=new ClientDetailsPage();
        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        detailPage.enteringClientDetails(dia.diagnosticianFirstName,dia.diagnosticianLastName, 2, "19-11-1997",2, dia.dia_Cell_Number,dia.diagnosticianEmailAddress, "Math", "NSW", " Tasmania", " Barkers Creek", "South Australia", "5422", "1200", "1000");
        panelpage.click_LogOutLink();
    }

    @Test(priority = 16, enabled = true, description = "Verify that diagnostician is able to login with old password or not")
    public void verify_Dia_IsAbleToLoginWithOldPassword_InSuperAdmin() throws InterruptedException {
       dia.diagnostician_login_With_OldPassword();
    }

    //DIRECTOR-----------------------------------------------------------------------------------

    @Test(priority = 20, enabled = true, description = "verify that SuperAdmin is able to create Director or not")
    public void create_Directors_In_SuperAdmin() throws InterruptedException {
         director.create_Directors();
    }


    @Test(priority = 21, enabled = true, description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Director_In_SuperAdmin() throws InterruptedException {
        director.edit_Director();
    }
    @Test(priority = 22, enabled = true, description = "verify that superadmin is able to check toggle button is enable or disable")
    public void director_checking_Toggle_Off_InSuperAdmin() throws InterruptedException {
        director.director_checking_Toggle_Off();
    }

    @Test(priority = 23, enabled = true, description = "Verify that Superadmin is able to Enable the user or not")
    public void director_enable_User() throws InterruptedException {
        director.director_enable_User();

    }

    @Test(priority = 24, enabled = true, description = "verify that diagnostician is able to edit or not after clicking dont save button")
    public void verify_Dir_DntSaveBtn() throws InterruptedException {
        director.verify_Dir_DntSaveBtn();
    }
    @Test(priority=25,enabled = true,description = "Verify that Director is able to login with valid credentials or not")
    public void director_Availability() throws InterruptedException {
         director.director_Availability();
    }
    @Test(priority = 26, enabled = true, description = "Verify that diagnostician is able to login with old password or not")
    public void login_With_OldPassword() throws InterruptedException {
        director.login_With_OldPassword();
    }

    @Test(priority = 27, enabled = true, description = "Verify Diagnostician is able to login with new password or not")
    public void director_Relogin_By_SuperAdmin() throws InterruptedException {
        director.director_Relogin();
    }

    @Test(priority = 28, enabled = true, description = "Verify that SuperAdmin is able to view appointments or not")
    public void Appointments_Page() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        LoginPage login = new LoginPage();
        login.adminLogin(adminUserName,"12345678");
        appointment.allAppointmentsPage(dia.diagnosticianFirstName, dia.diagnosticianLastName);
    }


    //*************This testcase also has defect*********************
    @Test(priority = 29, enabled = true, description = "Verify that 'Appointment Details' page opens up on clicking 'View Detail' link")
    public void view_Details_Page() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.clickOn_ViewDetails();
        WebdriverWaits.waitUntilVisible(appointment.App_Text);
        validate_text(appointment.App_Text, "All Appointments" );
//        WebdriverWaits.WaitUntilVisible(appointment.viewStudentObservationButton);
//        validate_text(appointment.viewStudentObservationButton, "View Student Observation");
//        WebdriverWaits.WaitUntilVisible(appointment.viewDocumentsButton);
//        validate_text(appointment.viewDocumentsButton, "View Documents");
    }

    //********After completion of complete appointment this test case will be valid********************

//    @Test(priority = 29, enabled = false, description = "Verify that superAdmin is able to view ClientObservation Page or not")
//    public void view_ClientObservation_Page() throws InterruptedException {
//        AppointmentsPage appointment = new AppointmentsPage();
//        appointment.view_ClientObservation_Page();
//    }

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
        ActionEngine action=new ActionEngine();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        action.Back_To_Page();
        panelpage.click_LogOutLink();

        login.superAdminLogin();
        payment.clickOn_PaymentTab();
        WebdriverWaits.waitUntilVisible(payment.paymentListPage);
        validate_text(payment.paymentListPage, "Payments");
    }

    @Test(priority = 32, enabled = true, description = "Verify that superAdmin is able to search perticular payment or not")
    public void search_Payment() throws InterruptedException {
        PaymentPage payment = new PaymentPage();
        payment.click_filterButton();
        payment.enterInSearchField(dia.diagnosticianFirstName);
        WebdriverWaits.waitUntilVisible(payment.cust_Name);
        validate_text( payment.cust_Name,dia.diagnosticianFirstName+' '+dia.diagnosticianLastName );
    }

    @Test(priority = 33, enabled = true, description = "Verify admin is able to download csv file or not")
    public void download_ExportCSV_File() throws InterruptedException {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        WebdriverWaits wait = new WebdriverWaits();
        ActionEngine action=new ActionEngine();
        panelpage.clickOn_ExportCSVButton();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
        action.Back_To_Page();
        panelpage.click_LogOutLink();
    }
    @Test(priority = 34,enabled = true,description = "SuperAdmin is able to disable the diagnostician")
     public void disablediagnostician(){
     LoginPage login=new LoginPage();
     login.superAdminLogin();
     Diagnostician diagnostician=new Diagnostician();
     DashBoardPanelPage panelPage=new DashBoardPanelPage();
     panelPage.click_DiagnosticianTab();

     diagnostician.off_ToggleButton();
     diagnostician.click_UpdateButton();
 }
}



