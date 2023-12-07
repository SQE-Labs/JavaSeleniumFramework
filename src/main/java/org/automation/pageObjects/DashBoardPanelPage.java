package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class DashBoardPanelPage extends BasePage {
    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public By directorsTab= By.xpath("//li[@id='Directors']");
    public By diagnosticianLink = By.xpath("//a[text()='Diagnosticians']");
    public By adminButton=By.xpath("//a[text()='Admins']");
    public By paymentButton=By.xpath("//a[text()='Payments']");
    public By backButton=By.xpath("//button[text()='Back']");

    public void click_LogOutLink() {
        WebdriverWaits.WaitUntilVisible(logOutLink);
        click_custom(logOutLink);
    }

    public void click_DirectorTab()     {
        WebdriverWaits.WaitUntilVisible(directorsTab);
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));
        click_custom(directorsTab);
    }

    public void click_DiagnosticianTab() {
        WebdriverWaits.WaitUntilVisible(diagnosticianLink);
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));
        click_custom(diagnosticianLink);
    }
    public void click_On_AdminButton(){
        WebdriverWaits.WaitUntilVisible(adminButton);
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));
        click_custom(adminButton);
    }
    public void click_On_PaymentButton(){
        WebdriverWaits.WaitUntilVisible(paymentButton);
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));
        click_custom(paymentButton);
    }
    public void clickOn_BackButton(){
        WebdriverWaits.WaitUntilVisible(backButton);
        click_custom(backButton);
    }
}
