package com.crm.step_definitions.Anh;

import com.vk.qa.utilities.ConfigurationReader;
import com.vk.qa.utilities.Driver;
import com.vk.qa.utilities.ProjectConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import com.crm.pages.LoginPage;

import java.awt.*;

public class LoginAnhSteps {
    LoginPage login = new LoginPage();
    ProjectConstants constants = new ProjectConstants();
    @Given("User navigate to Login Page for Admin")
    public void user_navigate_to_login_page_for_admin() {
        String url = ConfigurationReader.getProperty("CRM_URL");
        Driver.getDriver().get(url);
    }
    @When("user enter email {string} password {string}")
    public void user_enter_email_password(String uName, String Psswd) {
        login.entersCRMCredentials(uName,Psswd);
    }
    @When("click Login button")
    public void click_login_button() {
        login.clickLoginButton();
    }
    @Then("user is redirected to the Anh Dashboard page")
    public void user_is_redirected_to_the_dashboard_page() {
        login.verifyTitlePage(constants.Anh_DashboardTitle);
    }

    @Then("User verifies error message")
    public void user_sees_error_message() {
        login.verifyErrorMsgForWrongCred();
    }

    @When("user logs in CRM")
    public void login_CRM()
    {
        String userName = ConfigurationReader.getProperty("CRM_UserName");
        String Password = ConfigurationReader.getProperty("CRM_Pasword");
        login.loginCRM(userName,Password);
        Allure.step("Login Successfull");
        Allure.step("Logged in User : "+userName);

    }
    @Then("User upload file {string}")
    public void user_upload_file(String filePath) throws InterruptedException, AWTException {
        login.uploadFile(filePath);
    }

}
