package com.crm.runners;



import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "com/crm/step_definitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {

}
