package com.academy.techcenture.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/com/academy/techcenture/features/contact_us_functionality.feature",
        glue = {"com/academy/techcenture/step_definitions"},
        tags = "@test1",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
            monochrome = true

)

public class RegressionTestRunner {


}
