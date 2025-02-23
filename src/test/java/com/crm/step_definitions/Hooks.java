package com.crm.step_definitions;

import com.vk.qa.utilities.AllureListeners;
import com.vk.qa.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    AllureListeners allureListeners = new AllureListeners();

    @After
    public void teardownScenario(Scenario scenario){
        if(scenario.isFailed())
        {
            allureListeners.addPageScreenshotinReport();
        }

        Driver.closeDriver();
    }

}
