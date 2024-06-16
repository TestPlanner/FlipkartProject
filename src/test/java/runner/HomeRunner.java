package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src\\test\\resources\\appfeatures"},
		glue = {"steps","apphooks"},
		//dryRun = true,
	    publish = true,
		plugin = {"pretty", "html:target/cucumber-reports/reports.html"},
		tags = "@filter"
		
		)
public class HomeRunner extends AbstractTestNGCucumberTests{

	//use for parallel execution of scenarios
//	@Override 
//	@DataProvider (parallel=true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	};
}
