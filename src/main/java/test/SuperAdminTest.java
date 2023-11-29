package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.Diagnostician;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;
import static org.automation.pageObjects.Diagnostician.*;
import static org.automation.utilities.Assertions.validate_SuccessTXT;

public class SuperAdminTest extends BaseTest {
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
    validate_SuccessTXT(actualText,UserName);
    System.out.println("Successfully SuperAdmin Created diagnostician");
}
    @Test(priority = 1,enabled = true,description = "SuperAdmin is able to search created diagnostician or not")
    public void search_Created_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.search_CreatedDiagnostician(UserName);
        diagnostician.diagnostician_ListPage();
        Thread.sleep(5000);
        validate_SuccessTXT(actualText,UserName);
        System.out.println("Created Diagnostician Displayed In The Diagnostician ListPage");
    }
    @Test(priority = 2,enabled = true,description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.edit_Diagnostician("2456789548");
        validate_SuccessTXT(edited_CellNumber,"(245) 678-9548");
        System.out.println("Successfully Edited the created diagnostician");
    }
    @Test(priority = 3,enabled = false,description = "Verify that Superadmin is able to diable the user or not")
    public void disable_User() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.disable_Diagnostician();
    }
}
