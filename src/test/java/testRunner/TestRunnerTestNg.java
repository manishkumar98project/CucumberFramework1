package testRunner;

import com.google.common.annotations.VisibleForTesting;
import io.cucumber.testng.CucumberOptions;
//import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@VisibleForTesting
@CucumberOptions(
		features = {Constants.FEATURE_FILE},
glue = {Constants.GLUE}, 
tags = "@data1", 
dryRun = false, 
monochrome = true, 
plugin = {"pretty",
		"message:target/CucumberReports/cucumber.txt",
		"html:target/CucumberReports/cucumber.html",
		 "junit:target/CucumberReports/report.xml",
		"json:target/CucumberReports/cucumber.json", 
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
// ,"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
		}
)

public class TestRunnerTestNg extends AbstractTestNGCucumberTests {

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios(){
//		
//		return super.scenarios();
//	}

}
