package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    public By scheduleAppointment = By.xpath("//li[@id='Schedule Appointment']");
    public By spinner= By.cssSelector("div.ngx-spinner-overlay");
    public By actualText= By.xpath("//h3[text()='Create Appointment']");

    public void clickScheduleAppointment() throws InterruptedException {
        WebdriverWaits.WaitUntilVisible(scheduleAppointment);
        WebdriverWaits.WaitUntilInvisible(spinner);
        clickBtn_custom(scheduleAppointment);


    }
}
