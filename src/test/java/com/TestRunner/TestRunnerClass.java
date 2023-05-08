package com.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
        features="src/test/java/com/FeatureFile/SwiggyTest.feature",
        glue="com/StepDefinitions",
        plugin= {"pretty", "html:target/cucumber-reports.html"},
        monochrome=true
        
)

public class TestRunnerClass {

	

}
