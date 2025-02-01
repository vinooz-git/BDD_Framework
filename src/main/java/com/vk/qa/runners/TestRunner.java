package com.vk.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {
        "html:target/cucumber-reports.html"
    },
    features = "src/main/resources/features",
    glue = "com/vk/qa/step_definitions",
    dryRun = false,
    tags = "@Smoke"

)
public class TestRunner {



}
