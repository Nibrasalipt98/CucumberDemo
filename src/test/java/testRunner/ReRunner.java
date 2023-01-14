package testRunner;
//This is my test runner class

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="@failed_Scenario//failedScenario.txt",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
	plugin= "pretty"
		)
public class ReRunner {

}
