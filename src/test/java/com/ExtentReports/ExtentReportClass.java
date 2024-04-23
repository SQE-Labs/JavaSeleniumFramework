package com.ExtentReports;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {
	
	public static ExtentReports getReportObject() {
		{
		String path = System.getProperty("user.dir") + "/test-output/Reports/ExtentReportResult.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Reports");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shubham");
		return extent;
	   }
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) {
		Long l = Calendar.getInstance().getTimeInMillis();
		String screenshotId = l.toString() + screenshotName;
		String Path = System.getProperty("user.dir") + "/test-output/Reports/";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imgPath = Path + screenshotId + ".png";
		File dest = new File(imgPath);
		try {
			FileUtils.copyFile(screenshot, dest);
		} catch (IOException e) {
			e.printStackTrace();
		  }

		String ImagePath = "./" + screenshotId + ".png";
		return ImagePath;
	}

}
