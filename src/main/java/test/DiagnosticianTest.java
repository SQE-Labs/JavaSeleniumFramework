package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.Diagnostician;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;
import static org.automation.pageObjects.Diagnostician.*;
import static org.automation.utilities.Assertions.validate_SuccessTXT;
import static test.SuperAdminTest.*;


public class DiagnosticianTest extends BaseTest {
    public static String CustomerFirstName;
    public static String CustomerLastName;
    public static String EmailAddress;
    public static String UserName;
    @Test(priority = 0, enabled = true,description = "SuperAdmin is able to create Diagnostician")
    public void create_Diagnostician() throws InterruptedException {
        CustomerFirstName = "Michel" + RandomStrings.requiredCharacters(2);
        CustomerLastName = "Marsh" + RandomStrings.requiredCharacters(2);
        EmailAddress = CustomerFirstName + "@yopmail.com";
        UserName = "Brodie" + RandomStrings.requiredCharacters(2);
        LoginPage login = new LoginPage();
        login.validLogin();
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.create_Diagnostician(CustomerFirstName, CustomerLastName, "8564234568", EmailAddress, UserName, "123456", "123456");
        Thread.sleep(5000);
        //   validate_SuccessTXT(actualText,UserName);
    }
    @Test(priority = 1,enabled = true,description = "SuperAdmin is able to search created diagnostician or not")
    public void search_Created_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.diagnostician_ListPage();
        diagnostician.search_CreatedDiagnostician(UserName);
        validate_SuccessTXT(actualText,UserName);
        System.out.println("Successfully searched created diagnostician");
    }

    @Test(priority = 2,enabled = true,description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Diagnostician() throws InterruptedException {
        diagnosticianEmailAddress1 = CustomerFirstName + "12@yopmail.com";
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
        diagnostician.not_Edit_Diagnostician("5659865589",EmailAddress,"123456","123456");
    }
    @Test(priority = 5,enabled = false,description="Verify Diagnostician is able to login with new password or not")
    public void diagnostician_Relogin() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.Relogin_With_newPassword(UserName,"12345678");
    }
    @Test(priority = 6,enabled = false,description = "Verify that diagnostician is able to login with old password or not")
    public void login_With_OldPassword() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.Relogin_With_OldPassword(UserName,"123456");
    }

}
