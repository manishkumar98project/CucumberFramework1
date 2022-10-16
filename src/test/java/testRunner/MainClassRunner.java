package testRunner;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.cucumber.core.cli.Main;

public class MainClassRunner {

	public static WebDriver driver;
@Test
@Parameters({"featurefileName","tags"})
//	public static void main(String args[]) throws Throwable {
	public static void runner1(String featureN,String tags)  {
		try {
			Main.main(new String[] {

					"-g", "step_Definitions",

					"src/test/resources/Features/"+featureN,

					"-t", tags,
//					"@data2",

					"-p", "pretty", 
					"-p", "html:target/CucumberReports/cucumber.html", 
					"-p","json:target/CucumberReports/cucumber.json", 
					"-p","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

					"-m" 
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Main method exception : " + e);
		}
	}
}
