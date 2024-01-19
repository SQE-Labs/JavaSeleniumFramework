package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;

import org.automation.pageObjects.AppointmentsPage;
import org.automation.pageObjects.DashBoardPanelPage;
import org.automation.pageObjects.DirectorPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.bson.assertions.Assertions;
import org.testng.annotations.Test;

import static org.automation.utilities.Assertions.getText_custom;
import static org.automation.utilities.Assertions.validate_text;


public class DirectorTest extends BaseTest {

//    @Test(priority = 23, enabled = false, description = "verify that Director is able to edit or not after clicking dont save button")
//    public void verify_Dir_DntSaveBtn() throws InterruptedException {
//        DirectorPage director = new DirectorPage();
//        DashBoardPanelPage panelPage = new DashBoardPanelPage();
//
//        //    director.not_Edit_Director(directorEmailAddress, "123456", "123456");
//        //  validate_text(director.UserNameGetText, directorUserName);
//        director.click_LogOutLink();
//    }

//    @Test(priority = 24, enabled = false, description = "Verify that Director is able to login with valid credentials or not")
//    public void director_Availability() throws InterruptedException {
//        DashBoardPanelPage panelPage = new DashBoardPanelPage();
//        LoginPage login = new LoginPage();
//        DirectorPage director = new DirectorPage();
//        //login.directorLogin(directorUserName,"12345678");
//        login.directorLogin("roman", "123456");
//        WebdriverWaits.waitUntilVisible(director.dashboardPage);
//        validate_text(director.dashboardPage, "Dashboard");
//        panelPage.clickOn_AppointmentsTab();
//        validate_text(director.viewAll, "View All");
//        panelPage.clickOn_AvailabilityTab();
//        //  validate_text(director.monthHeader, "December");
//        String getMonthHeader = getText_custom(director.monthHeader);
//        // WebdriverWaits.waitUntilVisible(director.monthHeader);
//        validate_text(director.monthHeader, "January");
//
//        //  validate_text(director.yearHeader, "2023");
//        String getYearHeader = getText_custom(director.yearHeader);
//        validate_text(director.yearHeader, "2024");
//
//        String getdate = getText_custom(director.dateHeader);
//        validate_text(director.dateHeader, "18");
//        director.director_Availability();
//        director.click_LogOutLink();
//    }
//
//    @Test(priority = 25, enabled = false, description = "Verify that diagnostician is able to login with old password or not")
//    public void login_With_OldPassword() throws InterruptedException {
//        DirectorPage director = new DirectorPage();
//        DashBoardPanelPage panelPage = new DashBoardPanelPage();
//        LoginPage login = new LoginPage();
//        //Director trying to login with old password
//        //   login.directorLogin(directorUserName, "123456");
//        WebdriverWaits.waitUntilVisible(director.validation_Msg);
//        validate_text(director.validation_Msg, "Username or password is incorrect");
//        //panelPage.click_LogOutLink();
//    }
//
//    @Test(priority = 26, enabled = false, description = "Verify Diagnostician is able to login with new password or not")
//    public void director_Relogin() throws InterruptedException {
//        DirectorPage director = new DirectorPage();
//        DashBoardPanelPage panelPage = new DashBoardPanelPage();
//        LoginPage login = new LoginPage();
//        //Director trying to login with new password
//        //  login.directorLogin(directorUserName, "12345678");
//        WebdriverWaits.waitUntilVisible(director.directorDashBoardPage);
//        validate_text(director.directorDashBoardPage, "Dashboard");
//        panelPage.click_LogOutLink();
//    }

    @Test(priority = 1, enabled = true, description = "Verify Director is able to login with valid credentials")
    public void validLogin() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        //Director is able to login with valid credentials
        login.directorLogin("roman", "123456");
        WebdriverWaits.waitUntilVisible(director.directorDashBoardPage);
        validate_text(director.directorDashBoardPage, "Dashboard");

    }

    @Test(priority = 2, enabled = true, description = "Verify that 'Appointments' tab expands, on 'Dashboard' page.")
    public void validate_AppointmentsTabExpands() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        panelPage.clickOn_AppointmentsTab();
        validate_text(director.viewAll, "View All");

    }

    @Test(priority = 3, enabled = true, description = "Verify that 'Set Availability' page opens up and Year Picker appear")
    public void validate_Set_Appointment_AND_YearPicker() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        DirectorPage director = new DirectorPage();
        //login.directorLogin("roman", "123456");
        panelPage.clickOn_AvailabilityTab();
        validate_text(director.setAvailaibility, "Set Availability");
        validate_text(director.monthHeader, "January");
        validate_text(director.yearHeader, "2024");
    }

    @Test(priority = 4, enabled = true, description = "Verify that 'Available' card appears and click on Save button.")
    public void validate_AvailableCards_AND_SaveButton() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        DirectorPage director = new DirectorPage();
        panelPage.clickOn_AvailabilityTab();
        director.clickOn_AvailaibleSlot();
        WebdriverWaits.waitUntilVisible(director.validateAvailable);
        validate_text(director.validateAvailable, "Available");

        WebdriverWaits.waitUntilVisible(director.avail_SaveButton);
        validate_text(director.avail_SaveButton, "Save");
        director.clickOn_SaveBtn();


    }
}