package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class SuperAdmin extends BasePage {
    public By adminLink= By.xpath("//a[text()='Diagnosticians']");
    public By createAdminButton=By.xpath("//button[text()='Create Diagnostician']");
}
