package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.automation.utilities.Assertions.validate_text;


public class DirectorTest extends BaseTest {

    @Test(priority = 1, enabled = true, description = "1 Verify Director is able to login with valid credentials")
    public void verify_Login_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        login.director_Login();
        WebdriverWaits.waitUntilVisible(director.directorDashBoardPage);
        validate_text(director.directorDashBoardPage, "Dashboard");

    }

    @Test(priority = 2, enabled = true, description = " 4 Verify that 'Appointments' tab expands, on 'Dashboard' page.")
    public void verify_AppointmentsTabExpands() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_AppointmentsTab();
        validate_text(director.viewAll, "View All");

    }

    @Test(priority = 3, enabled = true, description = "12 and 13 Verify that 'Set Availability' page opens up and Year Picker appear")
    public void validate_SetAppointment_AND_YearPicker() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        DirectorPage director = new DirectorPage();
        panelPage.click_AvailabilityTab();
        validate_text(director.setAvailaibility, "Set Availability");
        validate_text(director.monthHeader, "January"); //TODO
        validate_text(director.yearHeader, "2024");
        panelPage.click_AvailabilityTab();

    }

    @Test(priority = 4, enabled = true, description = "20 and 21 Verify that 'Available' card appears and click on Save button.")
    public void verify_AvailableCards_AND_SaveButtonEnabled() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        DirectorPage director = new DirectorPage();
        panelPage.click_AvailabilityTab();
        director.click_AvailaibleSlot();
        WebdriverWaits.waitUntilVisible(director.validateAvailable);
        validate_text(director.validateAvailable, "Available");
        WebdriverWaits.waitUntilVisible(director.avail_SaveButton);
        validate_text(director.avail_SaveButton, "Save");
        director.click_SaveBtn();

    }


    @Test(priority = 5, enabled = true, description = "24 Verify that '<Date>' popup closes, when director clicks on 'Cancel' button")
    public void verify_Closed_PopUp_OnCancel() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        DirectorPage director = new DirectorPage();
        panelPage.click_AvailabilityTab();
        director.click_DeleteSlot();
        director.click_CancelButton();
        validate_text(director.today, "Today");

    }


    @Test(priority = 6, enabled = true, description = "23 Verify that director is able to delete already available marked slot")
    public void verify_DeleteSlots() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        DirectorPage director = new DirectorPage();
        LoginPage login = new LoginPage();
        director.click_DeleteSlot();
        director.click_DeleteButton();
        //validate_text(director.deletedSlot, " ");
        director.click_SaveBtn();
        Thread.sleep(2000);

    }

    @Test(priority = 7, enabled = true, description = "6 Verify that director is directed to 'Today's Appointments' page")
    public void verify_Today_AppointmentPage() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        AppointmentsPage appointment = new AppointmentsPage();
        panelPage.click_AppointmentsTab();
        appointment.click_Today_AppointmentCard();
        validate_text(appointment.todaysAppointmentTXT, "Today's Appointments");

    }

    @Test(priority = 8, enabled = true, description = "8 Verify that director is directed to 'Today's Appointments' page")
    public void verify_Upcoming_AppointmentPage() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        AppointmentsPage appointment = new AppointmentsPage();
        panelPage.click_AppointmentsTab();
        appointment.click_UpcomingCard();
        validate_text(appointment.upcomingAppointmentTXT, "Upcoming Appointments");

    }

    @Test(priority = 9, enabled = true, description = "13 Verify that search textbox, 'From Date' and 'To Date' date picker appear")
    public void verify_SearchTextBox() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        appointment.click_UpcomingCard();
        appointment.click_Filter();
        String searchPlaceHolder = admin.GetValueAttribute(appointment.searchTextBox, "placeholder");
        String fromDateplaceholder = admin.GetValueAttribute(appointment.fromDateText, "placeholder");
        String toDatePlaceholder = admin.GetValueAttribute(appointment.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
        Assert.assertEquals(searchPlaceHolder, "Type here to search");
    }


    @Test(priority = 10, enabled = true, description = "25 Verify that director gets logged out after clicking 'Log Out' button")
    public void verify_DirectorLogOut() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.click_LogOutLink();
        validate_text(director.signInToYourAccountTxt, "Sign in to your account");

    }

    @Test(priority = 11, enabled = true, description = "14 Verify that relevant records appear after entering valid data in search textbox, on 'Upcoming Appointments' page")
    public void verify_RelevantRecords() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        login.director_Login();
        panelPage.click_AppointmentsTab();
        appointment.click_UpcomingCard();
        appointment.click_Filter();
        appointment.enterSearchText("Josh Volt");
        validate_text(appointment.firstSearchedRecord, "Josh Volt");
    }

    //TODO //After the fix we will added assertions//
    @Test(priority = 12, enabled = true, description = "16 Verify that date picker appears after clicking on calendar icon in 'From Date' field")
    public void verify_FromDatePickerAppear() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
//      login.director_Login();
        panelPage.click_AppointmentsTab();
        appointment.click_UpcomingCard();
        appointment.click_Filter();
        appointment.click_FromDate();
    }

    //TODO //After the fix we will added assertions//
    @Test(priority = 13, enabled = true, description = "21 Verify that date picker appears after clicking on calendar icon in 'To Date' field")
    public void verify_ToDatePickerAppear() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
//      login.director_Login();
        panelPage.click_AppointmentsTab();
        appointment.click_UpcomingCard();
        appointment.click_Filter();
        appointment.click_ToDate();
    }

    @Test(priority = 14, enabled = true, description = "28 Verify that date picker appears after clicking on calendar icon in 'To Date' field")
    public void verify_CSV_GetsDownloaded() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_AppointmentsTab();

    }
}



