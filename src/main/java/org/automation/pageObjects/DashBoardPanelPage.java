package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class DashBoardPanelPage extends BasePage {
    public By logOutLink = By.xpath("//a[text()='Log Out']");

    public void click_LogOutLink() {
        WebdriverWaits.WaitUntilVisible(logOutLink);
        click_custom(logOutLink);
    }




}
