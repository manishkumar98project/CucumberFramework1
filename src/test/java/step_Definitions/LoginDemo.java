package step_Definitions;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.Loginpage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.BaseClass;

public class LoginDemo extends BaseClass {
	// WebDriver driver;
	String url = "https://www.demoblaze.com/index.html";

	WebDriverWait wt;
	Loginpage login;

//	@Before
//	public void browser_is_open() {
////		driver=setupbrowser();
//		setupbrowser();
//	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to(url);
		System.out.println("WebSite= " + url);
		System.out.println("Title=" + driver.getTitle());
	}

	@When("^user enter (.*) and (.*) and (.*)$") // (.*) means any things or value can accept
	public void user_enter_user_name_and_password(String username, String password, String type) throws Exception {
		login = new Loginpage(driver);
		wt = new WebDriverWait(driver, Duration.ofSeconds(30));
		login.click_loginbt();
		login.enter_username_password(username, password);
		login.click_loginsubmit();

		if (type.equals("invalid")) {
			System.out.println("Invalid Username Or Password");
		}

	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() throws Exception {
		Thread.sleep(2000);
		login.validate_user(driver);
		

	}

	@Given("navigated to home page")
	public void navigated_to_home_page() {
		login.click_nav_Home() ;
	}
//	@After
//	public void teardown(){
//		driver.quit();
//	}
//
//	@AfterStep
//	public void addScreenshot(Scenario scenario) throws Exception {
//		if(scenario.isFailed()) {
//			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
//			scenario.attach(fileContent, "image/png", "image");
//		}
//		System.out.println("--ScreenShot AfterStep--");
//
//	}

}
