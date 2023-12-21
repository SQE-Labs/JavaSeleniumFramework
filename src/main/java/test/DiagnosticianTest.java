package test;
import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.DashBoardPanelPage;
import org.automation.pageObjects.Diagnostician;
import org.automation.pageObjects.LoginPage;
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
         login.superAdminLogin();
        panelPage.click_DiagnosticianTab();
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, dia_Cell_Number, diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Successfully SuperAdmin Created diagnostician");
        diagnostician.Verify_Duplicate_Diagnostician(diagnosticianFirstName, diagnosticianLastName, "8564234568",diagnosticianEmailAddress,diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.validationMsg);
        validate_text(diagnostician.validationMsg, "An error occurred while creating the user. Username already exists!");
        panelPage.click_LogOutLink();
    }
    @Test(priority = 1,enabled=true,description="Verify that diagnostician is able to set availability or not")
    public void set_Availability() throws InterruptedException {

        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        Diagnostician diagnostician = new Diagnostician();
        LoginPage login=new LoginPage();
        AdminTest admin=new AdminTest();
        SuperAdminTest Superadmin = new SuperAdminTest();
        login.diagnosticianLogin(diagnosticianUserName,"123456");

        diagnostician.checking_Availability();
        WebdriverWaits.waitUntilVisible(diagnostician.availableSlotText);
        validate_text(diagnostician.availableSlotText, "Available");


        diagnostician.cancel_Availability();
        diagnostician.deleting_Availability();
        WebdriverWaits.waitUntilVisible(diagnostician.signUpTitleText);
        validate_text(diagnostician. signUpTitleText, "Sign in to your account");

    }
    @Test(priority = 2,enabled = false,description = "Verify that Diagnostician is able to View Today appointment or not")
    public void View_Appointment1() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        LoginPage login =new LoginPage();
      //  login.superAdminLogin();
        diagnostician.today_Appointment("Diognostician doing simple testing");
        diagnostician.clickOn_BackButton();
        WebdriverWaits.waitUntilVisible(diagnostician.appointmentDetail);
        validate_text(diagnostician.appointmentDetail, "Krillin Dash Details");
    }
}
