package test;

import org.automation.base.BaseTest;
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
     String diagnosticianLastName;
     String diagnosticianEmailAddress;

    @Test(priority = 0, enabled = false, description = "Create Diagnostician by admin")
    public void create_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DiagnosticianTest dia=new DiagnosticianTest();
        dia.create_Diagnostician();
    }




     @Test(priority = 1,enabled = false,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        DiagnosticianTest dia=new DiagnosticianTest();
        LoginPage login=new LoginPage();
        login.adminLogin("Allen","123456");
        //AdminTest admin=new AdminTest();
       // SuperAdminTest Superadmin = new SuperAdminTest();
        //login.diagnosticianLogin(Superadmin.diagnosticianUserName,"12345678");
        DashBoardPanelPage logout = new DashBoardPanelPage();
        schedule.login_As_Diagnostician(dia.diagnosticianUserName,"123456");
        schedule.checking_Availability();
        schedule.cancel_Availability();
        schedule.deleting_Availability();
    }
    @Test(priority = 2, enabled = false, description = "To verify schedule appointment")
    public void scheduleAppointment_Admin() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
       //login.validLogin("Allen", "123456");
        dashboard.clickScheduleAppointment();
        Thread.sleep(5000);
    }

    @Test(priority = 3, enabled = true, description = "selecting date for appointment")
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
        clientFirstName=RandomStrings.requiredCharacters(6);
        clientLastName=RandomStrings.requiredCharacters(6);
        clientCellNumber=RandomStrings.requiredDigits(10);
        clientEmail=clientFirstName+ "@yopmail.com";
        clientEmail2= clientFirstName+"101@yopmail.com";
        schedule.enteringClientDetails( clientFirstName, clientLastName, 2,"19-11-2000",1, "7654436788", clientEmail, "Other",clientEmail2,"New York","Texas","190001" ,"1000","1000");
        validate_text(schedule.actualText,"Appointment Scheduled!!");



    }
    @Test(priority = 5, enabled = false, description = "Verify View client details button on Schedule Appointment popup")
    public void verifyViewDetails() throws InterruptedException{
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.clickOnviewLink();
        String expectedName = clientFirstName+" "+clientLastName;
        validate_text(schedule.fullName,expectedName);

    }

    @Test(priority = 0, enabled = true, description = "Verify All Appointment page.")
    public void verify_AllAppointmentsPage() throws InterruptedException {
        LoginPage login = new LoginPage();
        AppointmentsPage appPage= new AppointmentsPage();
        login.adminLogin("Allen", "123456");
        appPage.View_AllAppointmentsPage();
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
        ScheduleAppointmentPage viewDetail= new ScheduleAppointmentPage();
        viewDetail.click_ViewDetails();

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
        WebdriverWaits.WaitUntilInvisible(editType.spinner);
        editType.edit_AssessmentType("GT");
        editType.click_DontSave();
        validate_text(editType.clientAsses," Sibling/Re-evaluation ");

    }




    @Test(priority = 6, enabled = false, description = "creating TestPlan for the created appointment")
    public void testPlanFor_scheduled_Appointment() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.creatingTestPlanForTheAppointment();
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
    @Test(priority = 1, enabled = false, description = "Creating Director from admin" )
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
        System.out.println("Successfully Edited the created director");
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
        WebdriverWaits.WaitUntilInvisible(director.spinner);
        WebdriverWaits.waitUntilVisible(director.directorDashBoardPage);
        validate_text(director.directorDashBoardPage, "Dashboard");
    }
    //**************Creating Diagnostician****************///

    @Test(priority = 1,enabled = false, description = "Edit created diagnostician by admin")
    public void Edit_Diagnostician() throws InterruptedException{
        Diagnostician diagnostician = new Diagnostician();
        // Edit Diagnostician
        String diagnosticianPhoneNumber = RandomStrings.requiredDigits(10);
        String diagnosticianUpdatedEmail= diagnosticianFirstName + "10@yopmail.com";
        diagnostician.edit_Diagnostician(diagnosticianUpdatedEmail,"1234567","1234567");

    }
    @Test(priority = 2,enabled = false, description = "Enable created diagnostician by admin")
    public void Enable_CreateDiagnostician()throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        //Enable disabled Diagnostician
        diagnostician.enable_DiagnosticianUser();
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        System.out.println("Diagnostician details updated successfully.");
    }

    @Test(priority = 3,enabled = false, description = "Search created diagnostician by admin")
    public void search_Diagnostician() throws InterruptedException{
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);

    }
    @Test(priority = 4,enabled = false, description = "Verify Don't save button diagnostician by admin")
    public void verify_Dnt_SaveButton() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        String diagnosticianPhoneNumber= RandomStrings.requiredDigits(10);
        String diagnosticianUpdatedEmail= diagnosticianFirstName + "10@yopmail.com";
        diagnostician.verify_DontSave(diagnosticianPhoneNumber,diagnosticianUpdatedEmail,"1234567","1234567");
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText,diagnosticianUserName);
    }
    @Test(priority = 5,enabled = false, description = "Diagnostician Relogin")
    public void diagnostician_Relogin() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        LoginPage login=new LoginPage();
        login.directorLogin(directorUserName, "12345678");
       // WebdriverWaits.WaitUntilInvisible(diagnostician.spinner);
        WebdriverWaits.waitUntilVisible(diagnostician.diagnosticianDashBoardPage);
        validate_text(diagnostician.diagnosticianDashBoardPage, "Dashboard");
    }
















}
