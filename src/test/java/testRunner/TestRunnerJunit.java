package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { Constants.FEATURE_FILE }, 
		glue = {Constants.GLUE }, 
		tags = "@data1", dryRun = false, 
		monochrome = true, plugin = { "pretty",
				"html:target/CucumberReports/cucumber.html", 
				"junit:target/CucumberReports/report.xml",
				"json:target/CucumberReports/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
// ,"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
}

)
public class TestRunnerJunit {

}
