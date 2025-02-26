package com.pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class PracticeTest {
    @Test
    public void test()
    {

        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://cms.anhtester.com/login");
        WebElement ele = driver.findElement(By.id("email"));

        //JavascriptExecutor js = (JavascriptExecutor) driver.executeScript("arguments[0].value='Selenium';",ele);
        //JavascriptExecutor js = (JavascriptExecutor) driver.executeScript("document.getElementById('email').value='new value';",ele);

        Actions action = new Actions(driver);
        action.moveToElement(ele).contextClick().perform();



    }
}
