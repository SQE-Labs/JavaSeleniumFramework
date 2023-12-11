package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.Diagnostician;

import org.automation.pageObjects.LoginPage;
import org.automation.utilities.Assertions;

import org.testng.annotations.Test;
import static org.automation.pageObjects.Diagnostician.*;



public class DiagnosticianTest extends BaseTest {
    @Test(priority = 0,enabled = true,description = "Verify that Diagnostician is able to View Today appointment or not")
    public void View_Appointment() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        LoginPage login =new LoginPage();
        login.superAdminLogin();
        diagnostician.today_Appointment("Diognostician doing simple testing");
    }

}
