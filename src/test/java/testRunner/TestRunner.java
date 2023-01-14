package testRunner;
//This is my test runner class

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={".//Features//Feature1.feature",".//Features//Feature2.feature"},
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
	//	tags="@regression",
		plugin= {"pretty","html:test-output/report.html","rerun:failed_Scenario//failedScenario.txt"}
		)
public class TestRunner {

}
