package com.crm.pages;

import com.vk.qa.utilities.AllureListeners;
import com.vk.qa.utilities.Driver;
import com.vk.qa.utilities.GeneralWrappers;
import com.vk.qa.utilities.ProjectConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;


public class LoginPage {
    private static WebDriver driver;
    public LoginPage()
    {
        driver = Driver.getDriver();
    }

    //Login
    private By inputEmail    =  By.name("email");
    private By inputPassword =  By.name("password");
    private By button        =  By.xpath("//button['Login']");
    private By HomePage      =  By.xpath("//span[text()='Dashboard']");
    private By errorMsglabel =  By.xpath("//span[text()='Invalid login credentials']");

    //Logout
    private By popUpButton   = By.className("o_user_menu");
    private By logOutButton  = By.xpath("//a[.='Log out']");
    private By warningMess   = By.xpath("//div[@class= 'o_dialog_warning modal-body']");
    public By uploadFileBtn = By.linkText("Upload New File");
    public By browseBtn = By.xpath("//button[text()='Browse']");


    GeneralWrappers wrappers = new GeneralWrappers();
    AllureListeners allureListeners = new AllureListeners();
    public void entersCRMCredentials(String UserName, String Password)
    {
        driver.findElement(inputEmail).sendKeys(UserName);
        driver.findElement(inputPassword).sendKeys(Password);
        Allure.step("Logged in User : "+UserName);
    }
    public void clickLoginButton() {
        driver.findElement(button).click();

    }

    public LoginPage loginCRM(String UserName, String Password)
    {
        driver.findElement(inputEmail).sendKeys(UserName);
        driver.findElement(inputPassword).sendKeys(Password);
        driver.findElement(button).click();
        return new LoginPage();
    }

    public void verifyTitlePage(String PageTitle)
    {
        wrappers.waitForVisibilityOfElement(HomePage);
        Assert.assertEquals(driver.getTitle(),PageTitle,"Titles of the website does not match");
        Allure.link("Dashboard Page",driver.getCurrentUrl());
        allureListeners.addPageScreenshotinReport();
    }

    public void verifyErrorMsgForWrongCred()
    {
        String errorMsg = driver.findElement(errorMsglabel).getText();
        Assert.assertEquals(errorMsg, ProjectConstants.invalidCredsAnh,"Error Message is not Matched");

    }

    public void uploadFile(String filePath) throws InterruptedException, AWTException {
        //String file = "";
        driver.findElement(uploadFileBtn).click();
        wrappers.waitForVisibilityOfElement(browseBtn);
        WebElement ele = driver.findElement(browseBtn);
        ele.click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        ele.sendKeys(filePath);
        ele.sendKeys(Keys.TAB);
        ele.sendKeys(Keys.TAB);
        ele.sendKeys(Keys.ENTER);

    }

}
