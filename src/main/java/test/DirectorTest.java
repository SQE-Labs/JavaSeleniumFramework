package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;

import org.automation.pageObjects.DashBoardPanelPage;
import org.automation.pageObjects.DirectorPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;

import static org.automation.utilities.Assertions.validate_text;


public class DirectorTest extends BaseTest {
    public String directorFirstName;
    public String directorEmailAddress;
    public String directorUserName;



    @Test(priority=0,enabled = true,description = "Verify that Director is able to login with valid credentials or not")
    public void login_Director() throws InterruptedException {
        directorFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

    LoginPage login=new LoginPage();
    SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
    login.directorLogin("AU_Hulkx","12345678");
        validate_text(director.dashboardPage, "Dashboard");
       panelPage.clickOn_AppointmentsTab();
        validate_text(director.viewAll, "View All");
        panelPage.clickOn_AvailabilityTab();
        validate_text(director.monthHeader, "December");
        validate_text(director.yearHeader, "2023");
        validate_text(director.dateHeader, "13");
        director.director_Availability();
         panelPage.click_LogOutLink();

    }
}
