package com.AllureReports;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;

public class AllureReportClass {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] captureScreenshot(WebDriver driver, String screenshotName) {
        Long timestamp = Calendar.getInstance().getTimeInMillis();
        String screenshotId = timestamp.toString() + screenshotName;
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static String saveScreenshot(WebDriver driver, String screenshotName) {
        Long timestamp = Calendar.getInstance().getTimeInMillis();
        String screenshotId = timestamp.toString() + screenshotName;
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        // Save the screenshot to a file or any other storage if needed
        // For Allure, saving to file is not necessary as it handles the attachment
        return screenshotId;
    }
}


