package testRunner;

import io.cucumber.testng.*;

@CucumberOptions(features = "@target/rerun.txt" // Cucumber picks the failed scenarios from this file
		, glue = { "step_Definitions" }, tags = "@tag3", 
		monochrome = true, 
		plugin = { "pretty",
				"junit:target/JunitReports/report.xml", "json:target/JsonReports/report.json",
				"html:target/HtmlReports/report.html"

		}, dryRun = false)

public class TestRunnerFails {

}
