package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;

import org.automation.pageObjects.DashBoardPanelPage;
import org.automation.pageObjects.DirectorPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.bson.assertions.Assertions;
import org.testng.annotations.Test;

import static org.automation.utilities.Assertions.*;
import static org.automation.utilities.Assertions.validate_text_withTrim;


public class DirectorTest extends BaseTest {

    @Test(priority = 23, enabled = true, description = "verify that Director is able to edit or not after clicking dont save button")
    public void verify_Dir_DntSaveBtn() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
    //    director.not_Edit_Director(directorEmailAddress, "123456", "123456");
      //  validate_text(director.UserNameGetText, directorUserName);
        director.click_LogOutLink();
    }
    @Test(priority = 27, enabled = false, description = "3.1, Verify that Director is able to login with valid credentials or not")
    public void director_Availability() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        DirectorPage director = new DirectorPage();
      //  login.directorLogin(directorUserName, "12345678");
        WebdriverWaits.waitUntilVisible(director.dashboardPage);
        validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        validate_text(director.viewAll, "View All");
        panelPage.clickOn_AvailabilityTab();

        String month1=getText_custom(director.monthHeader);
        validate_text_withTrim(director.monthHeader, month1);

        String year=getText_custom(director.yearHeader);
        validate_text_withTrim(director.yearHeader, year);

        String date=getText_custom(director.dateHeader);
        validate_text_withTrim(director.dateHeader, date);

        director.clickOn_YearHeader();
        WebdriverWaits.waitUntilVisible(director.yearsCalender);
        validate_text(director.yearsCalender, "2023 - 2034");

        validate_text(director.hihglihgtedYear, "2023");
        director.clickOn_YearHeader();
        director.clickOn_availableBox();

        validate_text(director.availableText, "Available");
        director.clickOn_SaveButton();
        director.click_LogOutLink();
    }

    @Test(priority = 25, enabled = true, description = "Verify that diagnostician is able to login with old password or not")
    public void login_With_OldPassword() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        //Director trying to login with old password
     //   login.directorLogin(directorUserName, "123456");
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
      //  login.directorLogin(directorUserName, "12345678");
        WebdriverWaits.waitUntilVisible(director.directorDashBoardPage);
        validate_text(director.directorDashBoardPage, "Dashboard");
        panelPage.click_LogOutLink();
    }
}
