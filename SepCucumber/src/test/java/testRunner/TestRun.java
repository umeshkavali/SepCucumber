package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        		features = { "src/test/java/features" }, glue = { "stepDefinitions" },
				plugin = { "pretty","json:target/cucumber-reports/report.json",
							"html:target/cucumber-reports/report.html" }, 
				dryRun = false, monochrome = true, publish = true)



public class TestRun 
{

}
