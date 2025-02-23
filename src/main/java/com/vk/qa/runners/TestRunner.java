package com.vk.qa.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
    plugin = {
        "html:target/cucumber-reports.html",
            "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    features = "src/test/resources/",
    glue = "com/vk/qa/step_definitions",
    dryRun = false,
    tags = "@AhnRegression"

)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
