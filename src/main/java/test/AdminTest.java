package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;

import static org.automation.utilities.Assertions.validate_SelectedOption;
import static org.automation.utilities.Assertions.validate_text;
import static org.testng.Assert.assertEquals;

public class AdminTest extends BaseTest {
    String diagnosticianUserName;
    String clientLastName;
    String directorFirstName;
    String directorUserName;
    String dirCellNumber;

    String directorEmailAddress;
    String directorLastName;

    String clientFirstName;
    String clientEmail;
    String clientEmail2;
    String clientCellNumber;
     String diagnosticianFirstName;
     String diagnosticianLastName;
     String diagnosticianEmailAddress;



    @Test(priority = 0, enabled = true, description = "Create diagnostician by admin")
    public void create_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        LoginPage login = new LoginPage();
        login.adminLogin("Allen","123456");
        // Create diagnostician
        diagnosticianFirstName = "Diagnostician"+ RandomStrings.requiredCharacters(3);
        diagnosticianLastName = "AU_smith"+ RandomStrings.requiredCharacters(3);
        diagnosticianUserName= "Diagnostician" + RandomStrings.requiredCharacters(5);
        diagnosticianEmailAddress = diagnosticianFirstName+ "10@yopmail.com";
        String diagnosticianPhoneNumber = RandomStrings.requiredDigits(10);
        diagnostician.create_Diagnostician(diagnosticianFirstName,diagnosticianLastName,diagnosticianPhoneNumber,diagnosticianEmailAddress,diagnosticianUserName,"123456","123456");
        WebdriverWaits.WaitUntilVisible(diagnostician.actualText);
        //validate Diagnostician
        validate_text(diagnostician.actualText,diagnosticianUserName);

    }
    @Test(priority = 1,enabled = true,description = "Set availability for diagnostician by admin")
    public void diagnostician_Availability() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        DashBoardPanelPage logout = new DashBoardPanelPage();
        logout.click_LogOutLink();
        schedule.login_As_Diagnostician(diagnosticianUserName,"123456");
        schedule.checking_Availability();
        schedule.cancel_Availability();
        schedule.deleting_Availability();
    }

    @Test(priority = 2, enabled = true, description = "Creating Director from admin" )
    public void create_Director() throws InterruptedException {
        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        login.adminLogin("Allen","123456");
        directorFirstName = "AU_Elser" + RandomStrings.requiredCharacters(2);
        directorLastName = "AU_Brien" + RandomStrings.requiredCharacters(2);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "AU_retta" + RandomStrings.requiredCharacters(2);
        dirCellNumber=RandomStrings.requiredDigits(10);
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        panelPage.click_DirectorTab();
        director.create_Director(directorFirstName, directorLastName, dirCellNumber, directorEmailAddress, directorUserName, "123456", "123456");
        panelpage.click_LogOutLink();

    }


    @Test(priority=3 ,enabled = true,description = "Set availability for director by admin.")
    public void director_Availability() throws InterruptedException {
        LoginPage login=new LoginPage();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        login.directorLogin(directorUserName,"123456");
        DirectorPage director=new DirectorPage();
        WebdriverWaits.waitUntilVisible(director.dashboardPage);
        validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        validate_text(director.viewAll, "View All");
        panelPage.clickOn_AvailabilityTab();
        director.director_Availability();
        panelPage.click_LogOutLink();

    }



    @Test(priority = 4, enabled = true, description = "Appointment scheduled by admin for a client")
    public void schedule_Appointment() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        login.adminLogin("Allen", "123456");
        dashboard.clickScheduleAppointment();
        validate_text(dashboard.actualText,"Create Appointment");

    }

    @Test(priority = 5, enabled = true, description = "Selecting Date and Assessment type for appointment by admin.")
    public void appointment_Calender() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.scheduleAppointment(1);
        schedule.appointmentDateSelecting(1);
        schedule.clickOnSaveButton();
    }

    @Test(priority = 6, enabled = true, description = "Filling client details by admin.")
     public void fill_ClientDetails() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        clientFirstName=RandomStrings.requiredCharacters(6);
        clientLastName=RandomStrings.requiredCharacters(6);
        clientCellNumber=RandomStrings.requiredDigits(10);
        clientEmail=clientFirstName+ "@yopmail.com";
        clientEmail2= clientFirstName+"101@yopmail.com";
        schedule.enteringClientDetails( clientFirstName, clientLastName, 1,"19-11-2000",1, "7654436788", clientEmail, "Other","New York","Texas","30052" ,"1000","900");



    }
    //********************** Create Follow Up For Client ***********************//
    @Test(priority = 7, enabled = true, description = "Creat follow up for client by admin")
    public void Create_FollowUp() throws InterruptedException{
      AdminPage followUp= new AdminPage();
        followUp.Create_FollowUp();
        followUp.click_BackBtn();
    }
    //******************** Functionality for Edit Assessment Pop Up and Test Plan **************//
    @Test(priority = 8, enabled = true, description = "Verify Edit Assessment type button .")
    public void edit_AssessmentTypePopUp()throws InterruptedException{
        AdminPage editType = new AdminPage();
        editType.click_EditAssessment();
    }
    @Test(priority = 9, enabled = true, description = "Verify Edit Assessment type button .")
    public void edit_AssessmentType() throws InterruptedException{
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType("IQ");
        editType.click_UpdateBtn();
        WebdriverWaits.WaitUntilVisible(editType.clientAsses);
        validate_text(editType.clientAsses,"IQ");

    }
    @Test(priority = 10, enabled = true, description = "Verify Test plan button on <Client> details page.")
    public void verify_TestPlanBtn()  throws InterruptedException{
        AdminPage testPlan = new AdminPage();
        WebdriverWaits.WaitUntilInvisible(testPlan.spinner);
        testPlan.click_TestPlan();
        validate_text(testPlan.testPlanText,"Please choose tests.");
    }
    @Test(priority = 11, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public  void plan_Test() throws InterruptedException{
        AdminPage testPlan = new AdminPage();
        testPlan.select_TestPlan();
        testPlan.click_TestPlanSaveButton();
        WebdriverWaits.WaitUntilVisible(testPlan.validateCheckBox);
        validate_text(testPlan.validateCheckBox,"WJ Achievement");
    }
    @Test(priority = 12, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public void dont_SaveAssessmentType() throws InterruptedException{
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType("GT");
        editType.click_DontSave();
        validate_text(editType.clientAsses,"IQ");
    }
    @Test(priority = 13, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public void edit_Testplan() throws InterruptedException{
        AdminPage testPlan = new AdminPage();
        testPlan.edit_TestPlan();
        validate_text(testPlan.actualEditTest,"WRAML");

    }
    @Test(priority = 14, enabled = true, description = "Verify Edit client Details button client page.")
    public void verify_EditClientBtn() throws InterruptedException{
        AdminPage EditClient = new AdminPage();
        EditClient.click_EditClientBtn();
        WebdriverWaits.WaitUntilVisible(EditClient.editCllientActualText);
        validate_text(EditClient.editCllientActualText,"Edit Client Info");
    }
    @Test(priority = 15, enabled = true, description = "Verify Edit client details popup client page.")
    public void verify_UpdateBtn() throws InterruptedException{
        AdminPage editClient= new AdminPage();
        editClient.edit_ClientInfo("Zoi","Smith","401 Broadway E eastate g","College");
        editClient. click_UpdateClientBtn();
        WebdriverWaits.WaitUntilVisible(editClient.actualTextClient);
        validate_text(editClient.actualTextClient,"College");

    }

    @Test(priority = 16, enabled = true, description = "Verify All Appointment page.")
    public void verify_AllAppointmentsPage() throws InterruptedException {
        AppointmentsPage appPage= new AppointmentsPage();
        appPage.View_AllAppointmentsPage();
        validate_text(appPage.viewAllActualText,"All Appointments");

    }
    @Test(priority = 17, enabled = true, description = "Verify search textbox")
    public void search_CreatedAppointment() throws InterruptedException{
        AppointmentsPage appPage= new AppointmentsPage();
        appPage.click_FilterButton();
        appPage.click_SearchField(clientFirstName+" "+ clientLastName);
    }
    @Test(priority = 18, enabled = true, description = "Verify search fromDate and toDate")
    public void verify_FromAndToDate() throws InterruptedException{
        AppointmentsPage appPage= new AppointmentsPage();
        ActionEngine engine;
        engine = new ActionEngine();
        String toDate= DateGenerator.getCurrentDate();
        String FromDate= DateGenerator.getDateWithDays("yyyy-MM-dd",-2);
        appPage.enter_Dates(FromDate,toDate);
        WebdriverWaits.WaitUntilVisible(appPage.dateElements);
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
    //************************ Edit Diagnostician *********************//
    @Test(priority = 19,enabled = true, description = "Search created diagnostician by admin")
    public void search_Diagnostician() throws InterruptedException{
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.click_DiagnosticianLink();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        validate_text(diagnostician.actualText, diagnosticianUserName);

    }
    @Test(priority = 20,enabled = true, description = "Edit created diagnostician by admin")
    public void Edit_Diagnostician() throws InterruptedException{
        Diagnostician diagnostician = new Diagnostician();
        // Edit Diagnostician
        String diagnosticianUpdatedEmail= diagnosticianFirstName + "10@yopmail.com";
        diagnostician.edit_Diagnostician(diagnosticianUpdatedEmail,"1234567","1234567");
        WebdriverWaits.WaitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
    }
    @Test(priority = 21,enabled = true, description = "Enable created diagnostician by admin")
    public void Enable_CreateDiagnostician()throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        //Enable disabled Diagnostician
        diagnostician.enable_DiagnosticianUser();
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        System.out.println("Diagnostician details updated successfully.");
    }


    @Test(priority = 22,enabled = true, description = "Verify Don't save button diagnostician by admin")
    public void verify_Dnt_SaveButton() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        String diagnosticianPhoneNumber= RandomStrings.requiredDigits(10);
        String diagnosticianUpdatedEmail= diagnosticianFirstName + "10@yopmail.com";
        diagnostician.verify_DontSave(diagnosticianPhoneNumber,diagnosticianUpdatedEmail,"1234567","1234567");
        validate_text(diagnostician.actualText,diagnosticianUserName);
    }
    //******************* Edit Director ***************//


    @Test(priority = 23, enabled = true, description = "Creating Director from admin" )
    public void edit_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.click_DirectorTab();
        directorEmailAddress = directorFirstName + "010@yopmail.com";
        director.edit_Director(directorEmailAddress,"12345678","12345678");
        validate_text(director.edit_SuccMsg,"Director details updated successfully.");

    }

    @Test(priority = 24, enabled = true, description = "Enable toggle button Director from admin" )
    public void director_Enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enable_Director();
        validate_text(director.edit_SuccMsg,"Director details updated successfully.");
        System.out.println("Successfully Edited the created director");
    }

    @Test(priority = 25,enabled = true,description="verify that director is able to edit or not after clicking dont save button")
    public void Verify_DntSave_Button() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        String  directorEmailAddressUpdated = directorFirstName + "101@yopmail.com";
        director.not_Edit_Director(directorEmailAddressUpdated,"123456","123456");
        WebdriverWaits.WaitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);

    }
    //**************** Verify export Csv button **************//

    @Test(priority = 27, enabled = true, description = "Verify admin is able to download csv file or not")
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
