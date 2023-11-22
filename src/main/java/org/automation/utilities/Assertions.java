package org.automation.utilities;

import org.automation.elements.Element;
import org.automation.logger.Log;
import org.openqa.selenium.By;
 
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

import static org.automation.base.BaseTest.extentTest;

public class Assertions {
    static WebdriverWaits wait=new WebdriverWaits();
    public static void assertEquals(String actual, String expected) {

        try {
            Assert.assertEquals(actual, expected);
            extentTest.log(PASS, "Assertion passed , Value is : " + actual);
        } catch (AssertionError e) {
            Log.info("excpetion in assertEquals method");
            extentTest.log(FAIL, "Assertion failed => " + "Actual Value : '" + actual + "' | Expected Value : '" + expected + "'");
        }
    }
    public static String getText_custom(By path) {
        String text = "";
        try {

            Element element = new Element("", path);
            text = element.getText();
            Log.info("Text for " + path + " is " + text);
            extentTest.log(PASS, "Text retrieved is: " + text);
            return text;
        } catch (Exception e) {
            extentTest.log(FAIL, "Unable to get text due to exception : \n" + e);

        }
        return text;
    }

    public static void validate_SuccessTXT(By element, String expected) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        String actual = Assertions.getText_custom(element);
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();
    }


}