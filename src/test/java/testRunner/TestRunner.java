package testRunner;
//This is my test runner class

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features={".//Features//Feature1.feature",".//Features//Feature2.feature"},
	
		features={".//Features//InputMethods.feature"},
		glue="stepDefinitions",
		dryRun=true,
		monochrome=true,
		//tags="@so",
	//	tags="@so and @datatable",      //And
	//	tags="@so or @datatable",     //OR
	//    tags = "not @so and not @datatable",	//not
	//    tags ="@so and not @datatable",     //not
	
    	plugin= {"pretty","html:test-output/report.html","rerun:failed_Scenario//failedScenario.txt"}
		)
public class TestRunner {

// tags of cucumber4
	   //	tags={"~@so","~@datatable"},		//Not
	//	tags={"@so,@datatable"},             //OR
//	    tags={"@so","@datatable"},             //And
	//	tags={"@so","~@datatable"},		//So but not datable
}
