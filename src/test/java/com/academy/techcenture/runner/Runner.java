package com.academy.techcenture.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber_reports.html", "json:target/cucumber-report.json", "me.jvt.cucumber.report.PrettyReports:target", "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/academy/techcenture/step_definitions",
        tags = "@regression",
        dryRun = false,
        publish = true
)
public class Runner {

}
