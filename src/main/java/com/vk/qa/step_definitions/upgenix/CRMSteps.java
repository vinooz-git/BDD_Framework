package com.vk.qa.step_definitions.upgenix;

import com.vk.qa.pages.upgenix.CRMPage;
import com.vk.qa.step_definitions.CommonSteps;
import com.vk.qa.utilities.Driver;
import com.vk.qa.utilities.ProjectConstants;
import org.openqa.selenium.WebDriver;

public class CRMSteps {
public static WebDriver driver;
public CRMSteps()
{
    driver = Driver.getDriver();
}
    CRMPage crmPage = new CRMPage();
    ProjectConstants constants = new ProjectConstants();
    CommonSteps commonSteps = new CommonSteps();




}
