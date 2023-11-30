package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.DirectorPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;

public class DirectorTest extends BaseTest {
    public static String directorFirstName;
    public static String directorLastName;
    public static String directorEmailAddress;
    public static String directorUserName;
@Test(priority = 0,enabled = true,description = "verify that SuperAdmin is able to create Director or not")
    public void create_Directors() throws InterruptedException {
        DirectorPage director=new DirectorPage();
    LoginPage login =new LoginPage();
    login.validLogin();
        director.create_Director(directorFirstName,directorLastName,"5236458965",directorEmailAddress, directorUserName,"123456","123456");
    }


}
