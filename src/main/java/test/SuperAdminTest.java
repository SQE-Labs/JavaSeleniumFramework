package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.Diagnostician;
import org.automation.pageObjects.DirectorPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;
import static org.automation.pageObjects.Diagnostician.*;
import static org.automation.utilities.Assertions.validate_SuccessTXT;
import static test.DirectorTest.*;

public class SuperAdminTest extends BaseTest {
    public static String diagnosticianFirstName;
    public static String diagnosticianLastName;
    public static String diagnosticianEmailAddress;
    public static String diagnosticianEmailAddress1;
    public static String diagnosticianUserName;
    @Test(priority = 0, enabled = true,description = "SuperAdmin is able to create Diagnostician")
    public void create_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnosticianFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        diagnosticianLastName = "Ward" + RandomStrings.requiredCharacters(2);
        diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "Riley" + RandomStrings.requiredCharacters(2);
    LoginPage login = new LoginPage();
    login.validLogin();
    diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, "8564234568", diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
    Thread.sleep(5000);
    validate_SuccessTXT(actualText,diagnosticianUserName);
    System.out.println("Successfully SuperAdmin Created diagnostician");
}
    @Test(priority = 1,enabled = true,description = "SuperAdmin is able to search created diagnostician or not")
    public void search_Created_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        diagnostician.diagnostician_ListPage();
        Thread.sleep(5000);
        validate_SuccessTXT(actualText,diagnosticianUserName);
        System.out.println("Created Diagnostician Displayed In The Diagnostician ListPage");
    }
    @Test(priority = 2,enabled = true,description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Diagnostician() throws InterruptedException {
        diagnosticianEmailAddress1 = diagnosticianFirstName + "12@yopmail.com";
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.edit_Diagnostician("2456789548",diagnosticianEmailAddress1,"12345678","12345678");
        validate_SuccessTXT(edit_Succ_Msg,"Diagnostician details updated successfully.");
        System.out.println("Successfully Edited the created diagnostician");
    }
    @Test(priority = 3,enabled = true,description = "Verify that Superadmin is able to diable the user or not")
    public void enable_User() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.enable_DiagnosticianUser();
        validate_SuccessTXT(edit_Succ_Msg,"Diagnostician details updated successfully.");
        System.out.println("Successfully Edited the created diagnostician");
    }
    @Test(priority = 4,enabled = true,description="verify that diagnostician is able to edit or not after clicking dont save button")
    public void notEditing_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.not_Edit_Diagnostician("5659865589",diagnosticianEmailAddress,"123456","123456");
    }
    @Test(priority = 5,enabled = true,description="Verify Diagnostician is able to login with new password or not")
    public void diagnostician_Relogin() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.Relogin_With_newPassword(diagnosticianUserName,"12345678");
    }
    @Test(priority = 6,enabled = true,description = "Verify that diagnostician is able to login with old password or not")
    public void login_With_OldPassword() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.Relogin_With_OldPassword(diagnosticianUserName,"123456");
        validate_SuccessTXT(validation_Msg,"Username or password is incorrect");
    }
    @Test(priority = 7,enabled = true,description = "verify that SuperAdmin is able to create Director or not")
    public void create_Directors() throws InterruptedException {
        DirectorPage director=new DirectorPage();
        directorFirstName = "director_Beau" + RandomStrings.requiredCharacters(2);
        directorLastName = "director_Ward" + RandomStrings.requiredCharacters(2);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "director_Riley" + RandomStrings.requiredCharacters(2);
        LoginPage login =new LoginPage();
        getDriver().navigate().refresh();
        login.validLogin();
        director.create_Director(directorFirstName,directorLastName,"5236458965",directorEmailAddress,directorUserName,"123456","123456");
    }
}
