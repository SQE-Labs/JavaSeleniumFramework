package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;

import org.automation.pageObjects.DashBoardPanelPage;
import org.automation.pageObjects.Diagnostician;
import org.automation.pageObjects.DirectorPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

import static org.automation.utilities.Assertions.validate_text;


public class DirectorTest extends BaseTest {
    public String directorFirstName;
    public String directorEmailAddress;
    public String directorUserName;
    public String directorLastName;
    public String dir_Cell_Number;
    @Test(priority = 19, enabled = true, description = "verify that SuperAdmin is able to create Director or not")
    public void create_Directors() throws InterruptedException {
        directorFirstName = "AU_Elsie" + RandomStrings.requiredCharacters(1);
        directorLastName = "AU_Brien" + RandomStrings.requiredCharacters(1);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "AU_retta" + RandomStrings.requiredCharacters(1);
        dir_Cell_Number=RandomStrings.requiredDigits(10);
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        LoginPage login = new LoginPage();

        //Login with super Admin credentials
        login.superAdminLogin();//login
        panelPage.click_DirectorTab();
        director.create_Director(directorFirstName, directorLastName, dir_Cell_Number, directorEmailAddress, directorUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.directorListPage);
        validate_text(director.directorListPage, "Directors List");
        director.Verify_Duplicate_Director(directorFirstName, directorLastName, dir_Cell_Number, directorEmailAddress, directorUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director. validationMsg);
        validate_text(director.validationMsg, "An error occurred while creating the admin. Username already exists!");
        panelPage.clickOn_BackButton();
        //panelPage.click_LogOutLink();
    }


    @Test(priority = 20, enabled = true, description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Director() throws InterruptedException {
        String directorEmailAddress1 = directorFirstName + "12@yopmail.com";
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        // login.superAdminLogin();
        //panelPage.clickOn_BackButton();
        //director changing the password.
        //  panelPage.edit_Director();
        director.edit_Director(directorEmailAddress1, "12345678", "12345678");
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        Log.info("Successfully Edited the created director");
    }
    @Test(priority = 21, enabled = true, description = "verify that superadmin is able to check toggle button is enable or disable")
    public void director_checking_Toggle_Off() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.cheking_DisableUser();
        WebdriverWaits.waitUntilVisible(director.enableUser);
        validate_text(director.enableUser, "Enable User");
    }

    @Test(priority = 22, enabled = true, description = "Verify that Superadmin is able to Enable the user or not")
    public void director_enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        director.enable_Director();
        WebdriverWaits.waitUntilVisible(director.edit_SuccMsg);
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        Log.info("Successfully Edited the created director");

    }

    @Test(priority = 23, enabled = true, description = "verify that diagnostician is able to edit or not after clicking dont save button")
    public void verify_Dir_DntSaveBtn() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        director.not_Edit_Director(directorEmailAddress, "123456", "123456");
        validate_text(director.UserNameGetText, directorUserName);
        director.click_LogOutLink();
    }
    @Test(priority=24,enabled = true,description = "Verify that Director is able to login with valid credentials or not")
    public void director_Availability() throws InterruptedException {
        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.adminLogin(directorUserName,"12345678");
        WebdriverWaits.waitUntilVisible(director.dashboardPage);
        validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        validate_text(director.viewAll, "View All");
        panelPage.clickOn_AvailabilityTab();
        validate_text(director.monthHeader, "December");
        validate_text(director.yearHeader, "2023");
        validate_text(director.dateHeader, "20");
        director.director_Availability();
        director.click_LogOutLink();
    }
    @Test(priority = 25, enabled = true, description = "Verify that diagnostician is able to login with old password or not")
    public void login_With_OldPassword() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        //Director trying to login with old password
        login.directorLogin(directorUserName, "123456");
        WebdriverWaits.waitUntilVisible(director.validation_Msg);
        validate_text(director.validation_Msg, "Username or password is incorrect");
        //panelPage.click_LogOutLink();
    }

    @Test(priority = 26, enabled = true, description = "Verify Diagnostician is able to login with new password or not")
    public void director_Relogin() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        //Director trying to login with new password
        login.directorLogin(directorUserName, "12345678");
        WebdriverWaits.waitUntilVisible(director.directorDashBoardPage);
        validate_text(director.directorDashBoardPage, "Dashboard");
        panelPage.click_LogOutLink();
    }
}
