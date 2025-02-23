package com.vk.qa.runners;



import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        glue = "com/vk/qa/step_definitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {

}
