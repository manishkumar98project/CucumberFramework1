package step_Definitions;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.Loginpage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.BaseClass;

public class Hooks extends BaseClass {

//	WebDriver driver;

	@Before
	public void browser_is_open(Scenario scenario) {
		setupbrowser();
		System.out.println(scenario.getName()+"= "+scenario.getSourceTagNames());
	}

	@After
	public void teardown(){
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws Exception {
		if(scenario.isFailed())
		{
		File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(sourcePath.toString());
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		}
		System.out.println("-------------------------------------------------------");
		
	}


}
