package com.vk.qa.step_definitions.upgenix;


import com.vk.qa.pages.upgenix.LoginPage;
import com.vk.qa.utilities.ConfigurationReader;
import com.vk.qa.utilities.Driver;
import com.vk.qa.utilities.ProjectConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAndLogoutSteps {
 LoginPage loginPage = new LoginPage();
 ProjectConstants constants = new ProjectConstants();
    @Given("Setup the Testing Environment")
    public void user_is_on_the_upgenix_login_page() {
        String url = ConfigurationReader.getProperty("CRM_URL");
        Driver.getDriver().get(url);
    }

    @When("User enters {string} and password {string}")
    public void user_enters_and_password(String email, String passwd) {
        loginPage.entersCRMCredentials(email,passwd);
    }
    @When("User clicks login button")
    public void user_clicks_login_button() {
       loginPage.clickLoginButton();
    }
    @Then("user is redirected to the Dashboard page")
    public void user_is_redirected_to_the_dashboard_page() {
        loginPage.verifyTitlePage(constants.DashboardTitle);
    }
    @Then("User verify error message")
    public void user_sees_error_message() {
        loginPage.verifyErrorMsgForWrongCred();
    }

}
