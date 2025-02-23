package com.vk.qa.pages.upgenix;

import com.vk.qa.step_definitions.CommonSteps;
import com.vk.qa.utilities.Driver;
import com.vk.qa.utilities.GeneralWrappers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CRMPage {
private WebDriver driver;

public CRMPage()
{
    driver = Driver.getDriver();
}

    public static By CRMMenu = By.xpath("//span[contains(text(),'CRM')]");
    public static By CreateBtn = By.xpath("//button[contains(text(),'Create')]");
    public static By OpporunityTitle() { return By.xpath("//input[@placeholder='e.g. Customer Deal']"); }
    public static By Customer = By.className("o_input_dropdown");
    public static By ExpectedRevenue = By.name("planned_revenue");
    public static By PriorityHigh() { return By.xpath("//table[@class='o_group o_inner_group o_group_col_6']//a[@title='High']"); }


    GeneralWrappers wrappers  = new GeneralWrappers();
    CommonSteps commonSteps = new CommonSteps();

public By getLocator(String ele) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    CRMPage crm = new CRMPage();
    Class<?> crmObj = crm.getClass();
    Method method = crmObj.getMethod(ele,By.class);
    return (By)method.invoke(crmObj,ele);

}

  public void enterValueInfield(String eleValue, String elementName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
      driver.findElement(getLocator(elementName)).clear();
      driver.findElement(getLocator(elementName)).sendKeys(eleValue);

  }


}
