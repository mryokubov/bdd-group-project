package com.academy.techcenture.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/com/academy/techcenture/features/contact_us_functionality.feature",
        glue = {"com/academy/techcenture/step_definitions"},
        tags = {"@regression"}
)
public class Runner {

}
