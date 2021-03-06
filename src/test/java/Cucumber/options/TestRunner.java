package Cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features", plugin="json:target/jsonReports/cucumber-reports.json.json", glue= {"StepDefinition"})
public class TestRunner {

}
