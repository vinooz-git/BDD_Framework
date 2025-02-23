package com.vk.qa.pages.upgenix;

import com.vk.qa.utilities.Driver;
import com.vk.qa.utilities.GeneralWrappers;
import com.vk.qa.utilities.ProjectConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPage {
    private static WebDriver driver;
    public LoginPage()
    {
        driver = Driver.getDriver();
    }

    //Login
    private By inputEmail    =  By.name("login");
    private By inputPassword =  By.name("password");
    private By button        =  By.xpath("//button[.='Log in']");
    private By HomePage      =  By.xpath("//div[@data-channel-id='channel_inbox']");
    private By errorMsglabel =  By.xpath("//p[starts-with(@class, 'alert'   )]");

   //Logout
    private By popUpButton   = By.className("o_user_menu");
    private By logOutButton  = By.xpath("//a[.='Log out']");
    private By warningMess   = By.xpath("//div[@class= 'o_dialog_warning modal-body']");


    GeneralWrappers wrappers = new GeneralWrappers();

    public void entersCRMCredentials(String UserName, String Password)
    {
        driver.findElement(inputEmail).sendKeys(UserName);
        driver.findElement(inputPassword).sendKeys(Password);
    }
    public void clickLoginButton() { driver.findElement(button).click(); }

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
    }

    public void verifyErrorMsgForWrongCred()
    {
        String errorMsg = driver.findElement(errorMsglabel).getText();
        Assert.assertEquals(errorMsg,ProjectConstants.invalidCreds,"Error Message is not Matched");

    }
}
