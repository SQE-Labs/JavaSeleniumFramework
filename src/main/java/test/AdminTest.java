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
import java.util.HashSet;
import java.util.List;

import static org.automation.utilities.Assertions.validate_text;

public class AdminTest extends BaseTest {
    String diagnosticianUserName;
    String clientLastName;
    String clientFirstName;
    String clientEmail;
    String clientEmail2;
    String clientCellNumber;
     String directorFirstName;
     String directorLastName;
     String directorEmailAddress;
     String directorUserName;
     String diagnosticianFirstName;
    public String diagnosticianEmailAddress;
    public String diagnosticianLastName;
    public String dia_Cell_Number;


    SuperAdminTest superAdmin=new SuperAdminTest();

    //login
    @Test(priority = -1, enabled = false, description = "1.1 Create Diagnostician by admin")
    public void create_Diagnostician()  {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnosticianFirstName = "AU_Murray" + RandomStrings.requiredCharacters(2);
        diagnosticianLastName = "AU_Luken" + RandomStrings.requiredCharacters(2);
        diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "AU_Jude" + RandomStrings.requiredCharacters(2);
        dia_Cell_Number = RandomStrings.requiredDigits(10);
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        //Login by using superAdmin credentials
        //  login.superAdminLogin();
        panelPage.click_DiagnosticianTab();
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, dia_Cell_Number, diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Successfully SuperAdmin Created diagnostician");

    }


    @Test(priority = 0, enabled = true, description = "1.1 Create duplicate  Diagnostician by admin")
    public void create_Duplicate_Diagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, dia_Cell_Number, diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.validationMsg);
        validate_text(diagnostician.validationMsg, "An error occurred while creating the user. Username already exists!");
    }

     @Test(priority = 1,enabled = false,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability() throws InterruptedException {
        DiagnosticianTest dia=new DiagnosticianTest();
         DiagnosticianPage diagnostician = new DiagnosticianPage();

         //  login.diagnosticianLogin(Superadmin.diagnosticianUserName,"12345678");
         diagnostician.checking_Availability();
         diagnostician.cancel_Availability();
         diagnostician.deleting_Availability();
    }


    @Test(priority = 3, enabled = true, description = "selecting date for appointment")
    public void appointmentCalender() throws InterruptedException {
        LoginTest login = new LoginTest();
        AppointmentsPage schedule = new  AppointmentsPage();
        // login.ValidLogin();
        schedule.scheduleAppointment("Plano");
        schedule.appointmentDateSelecting(2);
    }

    @Test(priority = 4, enabled = false, description = "Filling client details")
     public void fillClientDetails() throws InterruptedException {
         AppointmentsPage schedule = new   AppointmentsPage();
        clientFirstName=RandomStrings.requiredCharacters(6);
        clientLastName=RandomStrings.requiredCharacters(6);
        clientCellNumber=RandomStrings.requiredDigits(10);
        clientEmail=clientFirstName+ "@yopmail.com";
        clientEmail2= clientFirstName+"101@yopmail.com";
        schedule.fill_clientDetailsSection( clientFirstName, clientLastName, 2, "19-11-1997", 2, clientCellNumber, clientEmail, "Math", "NSW", " Tasmania", " Barkers Creek", "South Australia", "5422", "1200", "1000");
       // validate_text(schedule.actualText,"Appointment Scheduled!!");
    }
    @Test(priority = 5, enabled = false, description = "Verify View client details button on Schedule Appointment popup")
    public void verifyViewDetails() throws InterruptedException{
      //  ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
      //  schedule.clickOnviewLink();
        String expectedName = clientFirstName+" "+clientLastName;
    //    validate_text(schedule.fullName,expectedName);

    }

    @Test(priority = 0, enabled = true, description = "Verify All Appointment page.")
    public void verify_AllAppointmentsPage() throws InterruptedException {
        LoginPage login = new LoginPage();
        AppointmentsPage appPage= new AppointmentsPage();
        login.adminLogin("Allen", "123456");
        appPage.click_AppointmentTab();
        appPage.click_ViewAllTab();
        validate_text(appPage.viewAllActualText,"All Appointments");

    }
    @Test(priority = 1, enabled = false, description = "Verify search textbox")
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
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        appPage.exportCSV_Button();

        String downloadFile=panelPage.getDownloadFileName();
        Assert.assertTrue(panelPage.isFileDownloaded(downloadFile));
    }

    @Test(priority = 2, enabled = false, description = "Verify search fromDate and toDate")
    public void verify_FromAndToDate() throws InterruptedException{
        AppointmentsPage appPage= new AppointmentsPage();
        ActionEngine engine;
        engine = new ActionEngine();
        String toDate= DateGenerator.getCurrentDate();
        String FromDate= DateGenerator.getDateWithDays("yyyy-MM-dd",-2);
        appPage.enter_Dates(FromDate,toDate);
        WebdriverWaits.waitUntilVisible(appPage.dateElements);
        List<WebElement> my_list = engine.getWebElements(appPage.dateElements);
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
    @Test(priority = 1, enabled = true, description = "Verify view details button.")
    public void verify_ViewDetails()  throws InterruptedException {
      //  ScheduleAppointmentPage viewDetail= new ScheduleAppointmentPage();
      //  viewDetail.click_ViewDetails();

    }
    @Test(priority = 2, enabled = true, description = "Verify Edit Assessment type button .")
    public void validate_AssessmentTypePopUp()throws InterruptedException{
        AdminPage editType = new AdminPage();
        editType.click_EditAssessment();
        validate_text(editType.assType,"Change Assement Type");

    }
    @Test(priority = 3, enabled = true, description = "Verify Edit Assessment type button .")
    public void edit_AssessmentType() throws InterruptedException{
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType(" Sibling/Re-evaluation");
        editType.click_UpdateBtn();
        validate_text(editType.clientAsses,"Sibling/Re-evaluation ");

    }
    @Test(priority = 4, enabled = true, description = "Verify Don't save button on change assessment type .")

    public void verify_DontSave() throws InterruptedException{
        AdminPage editType = new AdminPage();
        WebdriverWaits.waitForSpinner();
        editType.edit_AssessmentType("GT");
        editType.click_DontSave();
        validate_text(editType.clientAsses," Sibling/Re-evaluation ");

    }




    @Test(priority = 6, enabled = false, description = "creating TestPlan for the created appointment")
    public void testPlanFor_scheduled_Appointment() throws InterruptedException {
      //  ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
      //  schedule.creatingTestPlanForTheAppointment();
    }



    //****************Creating directors by Admin**************//

    @Test(priority = 0, enabled = false, description = "Creating Director from admin" )
    public void create_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        LoginPage login =new LoginPage();
        login.adminLogin("Allen", "123456");
        directorFirstName = "AU_Zoi"+ RandomStrings.requiredCharacters(1);
        directorLastName = "AU_Kama"+ RandomStrings.requiredCharacters(1);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "AU_Zpi" + RandomStrings.requiredCharacters(3);
        String directorPhoneNumber = RandomStrings.requiredDigits(10);
        director.create_Director(directorFirstName,directorLastName, directorPhoneNumber, directorEmailAddress,directorUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.actualText);
        validate_text(director.actualText,directorUserName);

    }
    // ******************Editing the director*************//
    @Test(priority = 1, enabled = false, description = "Editing Director from admin" )
    public void edit_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        directorEmailAddress = directorFirstName + "010@yopmail.com";
        director.edit_Director(directorEmailAddress,"12345678","12345678");
        WebdriverWaits.waitUntilVisible(director.edit_SuccMsg);
        validate_text(director.edit_SuccMsg,"Director details updated successfully.");
        System.out.println("Successfully Edited the created director");


    }

    @Test(priority = 2, enabled = false, description = "Checking Whether toggle is off or not" )
    public void director_Checking_Toggle_Off() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.cheking_DisableUser();
        WebdriverWaits.waitUntilVisible(director.enableUser);
        validate_text(director.enableUser, "Enable User");

    }
    @Test(priority = 3, enabled = false, description = "Enable toggle button Director from admin" )
    public void director_Enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enable_Director();
        validate_text(director.edit_SuccMsg,"Director details updated successfully.");
    }

    @Test(priority = 4,enabled = false,description="verify that director is able to edit or not after clicking dont save button")
    public void Verify_DntSave_Button() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        String  directorEmailAddressUpdated = directorFirstName + "101@yopmail.com";
        director.not_Edit_Director(directorEmailAddressUpdated,"123456","123456");
        WebdriverWaits.waitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);

    }
    @Test(priority = 5, enabled = false, description = "Creating Director from admin" )
    public void director_Relogin() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.Relogin_With_newPassword(directorUserName, "12345678");
        WebdriverWaits.waitForSpinner();
        WebdriverWaits.waitUntilVisible(director.directorDashBoardPage);
        validate_text(director.directorDashBoardPage, "Dashboard");
    }
    //**************Creating Diagnostician****************///

    @Test(priority = 1,enabled = false, description = "Edit created diagnostician by admin")
    public void Edit_Diagnostician() throws InterruptedException{
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        // Edit Diagnostician
        String diagnosticianUpdatedEmail= diagnosticianFirstName + "10@yopmail.com";
        diagnostician.edit_Diagnostician(diagnosticianUpdatedEmail,"1234567","1234567");

    }
    @Test(priority = 2,enabled = false, description = "Enable created diagnostician by admin")
    public void Enable_CreateDiagnostician()throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        //Enable disabled Diagnostician
        diagnostician.enable_DiagnosticianUser();
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
    }

    @Test(priority = 3,enabled = false, description = "Search created diagnostician by admin")
    public void search_Diagnostician() throws InterruptedException{
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);

    }
    @Test(priority = 4,enabled = false, description = "Verify Don't save button diagnostician by admin")
    public void verify_Dnt_SaveButton() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        String diagnosticianPhoneNumber= RandomStrings.requiredDigits(10);
        String diagnosticianUpdatedEmail= diagnosticianFirstName + "10@yopmail.com";
        diagnostician.verify_DontSave(diagnosticianPhoneNumber,diagnosticianUpdatedEmail,"1234567","1234567");
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText,diagnosticianUserName);
    }
    @Test(priority = 5,enabled = false, description = "Diagnostician Relogin")
    public void diagnostician_Relogin() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        LoginPage login=new LoginPage();
        login.directorLogin(directorUserName, "12345678");
       // WebdriverWaits.WaitUntilInvisible(diagnostician.spinner);
        WebdriverWaits.waitUntilVisible(diagnostician.diagnosticianDashBoardPage);
        validate_text(diagnostician.diagnosticianDashBoardPage, "Dashboard");
    }
//logout testcase
    //************Appointments page******************

    //to-do
    @Test(priority = 28, enabled = true, description = "2.1 Verify that SuperAdmin is able to view appointments or not")
    public void Appointments_Page()   {
        AppointmentsPage appointment = new AppointmentsPage();
        LoginPage login = new LoginPage();
       // login.adminLogin(adminUserName, "12345678");
        appointment.view_allAppointmentsPage(diagnosticianFirstName, diagnosticianLastName);
    }


    //*************This testcase also has defect*********************
    @Test(priority = 29, enabled = true, description = "2.5, 2.7 Verify that 'Appointment Details' page opens up on clicking 'View Detail' link")
    public void view_Details_Page()   {
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.clickOn_ViewDetails();
        WebdriverWaits.waitForSpinner();
        WebdriverWaits.waitUntilVisible(appointment.App_Text);
        validate_text(appointment.App_Text, diagnosticianFirstName +' '+diagnosticianLastName+' '+"Details");
        appointment.click_ViewAllTab();

//        WebdriverWaits.WaitUntilVisible(appointment.viewStudentObservationButton);
//        validate_text(appointment.viewStudentObservationButton, "View Student Observation");
//        WebdriverWaits.WaitUntilVisible(appointment.viewDocumentsButton);
//        validate_text(appointment.viewDocumentsButton, "View Documents");
    }

    //********After completion of complete appointment this test case will be valid********************

    @Test(priority = 29, enabled = false, description = "Verify that superAdmin is able to view ClientObservation Page or not")
    public void view_ClientObservation_Page()  {
        AppointmentsPage appointment = new AppointmentsPage();
        // appointment.view_ClientObservation_Page();
    }

    @Test(priority = 30, enabled = true, description = "2.6 Verify that CSV file gets downloaded after clicking 'Export to CSV' button, on 'All Appointments' page")
    public void download_CSV_File() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        WebdriverWaits.waitForSpinner();
        appointment.exportCSV_Button();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
    }

    //**********************SuperAdmin is viewing Payments page********************
    @Test(priority = 31, enabled = true, description = "6.1, Verify that superAdmin is able to view payment page or not")
    public void view_Payments_Page()  {
        PaymentPage payment = new PaymentPage();
        ActionEngine action = new ActionEngine();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        action.navigate_Back();
        panelpage.click_LogOutLink();

        login.superAdminLogin();
        payment.clickOn_PaymentTab();
        WebdriverWaits.waitUntilVisible(payment.paymentListPage);
        validate_text(payment.paymentListPage, "Payments");
    }

    @Test(priority = 32, enabled = true, description = "6.2, 6.3,  Verify that superAdmin is able to search perticular payment or not")
    public void search_Payment()   {
        PaymentPage payment = new PaymentPage();
        payment.click_filterButton();
        payment.enterInSearchField(diagnosticianFirstName);
        WebdriverWaits.waitUntilVisible(payment.cust_Name);
        validate_text(payment.cust_Name, diagnosticianFirstName +' '+diagnosticianLastName);
    }

    @Test(priority = 33, enabled = true, description = "6.5 Verify admin is able to download csv file or not")
    public void download_ExportCSV_File() throws InterruptedException {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        ActionEngine action = new ActionEngine();
        panelpage.clickOn_ExportCSVButton();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
        action.navigate_Back();
        panelpage.click_LogOutLink();
    }


    @Test(priority = 17, enabled = true, description = "To verify schedule appointment for admin by superadmin")
    public void scheduleAppointment_Admin()   {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();

        // Login as a Admin
      //  login.adminLogin(adminUserName, "12345678");
        dashboard.clickScheduleAppointment();
    }

    @Test(priority = 18, enabled = true, description = "selecting date for appointment by superadmin")
    public void appointmentCalenderInAdmin() throws InterruptedException {
        AppointmentsPage schedule = new AppointmentsPage();
        // login.ValidLogin();
        schedule.scheduleAppointment("Austin");
        schedule.appointmentDateSelecting(2);

    }


    @Test(priority =20, enabled = true, description = "admin logout")
    public void logoutAdmin() throws InterruptedException {
        AppointmentsPage page = new AppointmentsPage();
        page.click_LogOutLink();

    }











}
