package com.academy.techcenture.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.academy.techcenture.config.Driver.*;

public class Hooks {

    @Before(order = 1)
    public void setup(Scenario scenario) {
        System.out.println("Scenario name ->" + scenario.getName());
    }

    @After
    public void teardown(Scenario scenario) {
        System.out.println("Scenario failed ->" + scenario.isFailed());
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        closeDriver();

    }
}
