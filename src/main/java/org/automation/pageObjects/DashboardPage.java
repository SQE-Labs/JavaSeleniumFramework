package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    public By scheduleAppointment = By.xpath("//li[@id='Schedule Appointment']");


    public void clickScheduleAppointment() throws InterruptedException {
        WebdriverWaits.WaitUntilVisible(scheduleAppointment);
        clickBtn_custom(scheduleAppointment);
    }
}
