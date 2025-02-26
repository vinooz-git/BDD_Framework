package com.crm.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/rerun.txt"
        },
        features = "@target/rerun.txt",
        glue = "com/crm/step_definitions",
        dryRun = false
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {

        @DataProvider(parallel = false)
        @Override
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
