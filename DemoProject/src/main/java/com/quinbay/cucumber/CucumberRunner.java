package com.quinbay.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/destination/cucumber.json","pretty", "html:target/cucumber/report.html"},
        tags="@E-Shopping",
        glue = {"com.quinbay.cucumber.Steps"},
        features = "src/test/resources/features"
)
public class CucumberRunner {
}