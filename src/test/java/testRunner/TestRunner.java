package testRunner;
//This is my test runner class

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features={".//Features//Feature1.feature",".//Features//Feature2.feature"},
	
		features={".//Features//InputMethods.feature"},
		glue="stepDefinitions",
		dryRun=true,
		monochrome=true,
	//	tags={"~@so","~@datatable"},		//Not
	//	tags={"@so,@datatable"},             //OR
//	    tags={"@so","@datatable"},             //And
	//	tags={"@so","~@datatable"},		//So but not datable
    	plugin= {"pretty","html:test-output/report.html","rerun:failed_Scenario//failedScenario.txt"}
		)
public class TestRunner {

}
