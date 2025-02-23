package com.crm.step_definitions;


import com.vk.qa.utilities.Driver;
import com.vk.qa.utilities.GeneralWrappers;
import org.openqa.selenium.WebDriver;


public class CommonSteps {
    public static WebDriver driver;
    public CommonSteps() { driver = Driver.getDriver(); }

    GeneralWrappers wrappers = new GeneralWrappers();
//    CRMPage crm = new CRMPage();
//    LoginPage login = new LoginPage();
//
//    @Then("user clicks {string} Menu")
//    public void selectMenu(String MenuName)
//    {
//        if(MenuName.contains("CRM")) {
//            driver.findElement(CRMPage.CRMMenu).click();
//            wrappers.waitForPageLoaded();
//        }
//    }
//
//    @Then("user enter value {string} for field {string}")
//    public void enter_value_in_OpporunityTitle(String value, String FieldName) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
//        crm.enterValueInfield(value,FieldName);
//    }



}
