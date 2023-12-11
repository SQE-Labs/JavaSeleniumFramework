package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;

import org.automation.pageObjects.DirectorPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;




public class DirectorTest extends BaseTest {
    public String directorFirstName;
    public String directorEmailAddress;
    public String directorUserName;
@Test(priority = 0,enabled = true,description = "verify that SuperAdmin is able to create Director or not")
    public void create_Directors() throws InterruptedException {
        DirectorPage director=new DirectorPage();
       LoginPage login =new LoginPage();
    directorFirstName = "Beau" + RandomStrings.requiredCharacters(2);
    String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
    directorEmailAddress = directorFirstName + "@yopmail.com";
    directorUserName = "Riley" + RandomStrings.requiredCharacters(2);
        login.superAdminLogin();
        director.create_Director(directorFirstName,directorLastName,"5236458965",directorEmailAddress, directorUserName,"123456","123456");
        Thread.sleep(3000);
    Assertions.validate_text(director.actualText,directorUserName);
    Log.info("Successfully SuperAdmin Created director");
    }
    @Test(priority = 1,enabled = true,description = "SuperAdmin is able to search created diagnostician or not")
    public void search_Created_director() throws InterruptedException {
        DirectorPage director=new DirectorPage();
        director.search_CreatedDirector(directorUserName);
        Thread.sleep(5000);
        Assertions.validate_text(director.actualText, directorUserName);
        Log.info("Created Director Displayed In The Director ListPage");
    }
    @Test(priority = 2,enabled = true,description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Director() throws InterruptedException {
        String directorEmailAddress1 = directorFirstName + "12@yopmail.com";
        DirectorPage director=new DirectorPage();
        director.edit_Director(directorEmailAddress1,"12345678","12345678");
        Assertions.validate_text(director.edit_SuccMsg,"Director details updated successfully.");
        Log.info("Successfully Edited the created director");
    }
    @Test(priority = 3,enabled = true,description = "verify that toggole is off or not")
    public void checking_Toggle_Off() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.cheking_DisableUser();
        Assertions.validate_text(director.enableUser, "Enable User");
    }
    @Test(priority = 4,enabled = true,description = "Verify that Superadmin is able to diable the user or not")
    public void enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enable_Director();
        Assertions.validate_text(director.edit_SuccMsg,"Director details updated successfully.");
       Log.info("Successfully Edited the created director");
    }
    @Test(priority = 5,enabled = true,description="verify that diagnostician is able to edit or not after clicking dont save button")
    public void not_Creating_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.not_Edit_Director("5659865589",directorEmailAddress,"123456","123456");
        Assertions.validate_text(director.UserNameGetText,directorUserName);
    }
    @Test(priority = 6,enabled = true,description="Verify Diagnostician is able to login with new password or not")
    public void director_Relogin() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.Relogin_With_newPassword(directorUserName,"12345678");
        Thread.sleep(10000);
        Assertions.validate_text(director.directorDashBoardPage,"Dashboard");
    }
    @Test(priority = 7,enabled = true,description = "Verify that diagnostician is able to login with old password or not")
    public void login_With_OldPassword() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.directorRelogin_With_OldPassword(directorUserName,"123456");
        Assertions.validate_text(director.validation_Msg,"Username or password is incorrect");
    }
}
