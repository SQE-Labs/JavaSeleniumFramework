package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    public By scheduleAppointment = By.xpath("//li[@id='Schedule Appointment']");


    public void clickScheduleAppointment() throws InterruptedException {
        Thread.sleep(3000);
        clickBtn_custom(scheduleAppointment);
    }
}
