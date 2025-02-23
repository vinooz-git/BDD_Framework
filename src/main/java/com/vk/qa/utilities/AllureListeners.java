package com.vk.qa.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AllureListeners {
    private static WebDriver driver;
    public AllureListeners()
    {
        driver = Driver.getDriver();
    }

    public static void addPageScreenshotinReport()
    {
        Allure.addAttachment(UUID.randomUUID().toString(),new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }
    public static void addElementScreenshotinReport(WebElement ele)
    {
        Allure.addAttachment(UUID.randomUUID().toString(),new ByteArrayInputStream(ele.getScreenshotAs(OutputType.BYTES)));
    }

}
