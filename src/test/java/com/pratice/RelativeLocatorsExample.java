package com.pratice;

import com.vk.qa.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class RelativeLocatorsExample {

    @Test
    public void findEleWithRelativeLoc() {

        WebDriver driver = Driver.getDriver();

        By sourceElement = By.xpath("//p[text()='iPhone 12 Mini']");
        By aboveLocator = RelativeLocator.with(By.tagName("p")).above(sourceElement);
        By belowLocator = RelativeLocator.with(By.tagName("p")).below(sourceElement);
        By LeftLocator = RelativeLocator.with(By.tagName("p")).toLeftOf(sourceElement);
        By RightLocator = RelativeLocator.with(By.tagName("p")).toRightOf(sourceElement);
        By NearLocator = RelativeLocator.with(By.tagName("p")).near(sourceElement);

        driver.get("https://bstackdemo.com/");

        System.out.println("Above Locator : "+driver.findElement(aboveLocator).getText());
        System.out.println("below Locator : "+driver.findElement(belowLocator).getText());
        System.out.println("Left Locator : "+driver.findElement(LeftLocator).getText());
        System.out.println("Right Locator : "+driver.findElement(RightLocator).getText());
        System.out.println("Near Locator : "+driver.findElement(NearLocator).getText());


    }

}
