package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.AlertsHandler;

public class Loginpage{

	WebDriver driver;
	AlertsHandler al;

	@FindBy(xpath = "//*[@id='login2']")
	WebElement login;

	@FindBy(xpath = "//*[@id='loginusername']")
	WebElement un;

	@FindBy(xpath="//*[@id='loginpassword']")
	WebElement pass;

	@FindBy(xpath="//*[@class='modal-footer']//button[contains(text(),'Log in')]")
	WebElement sumbitloginbutton;

	@FindBy(xpath="//*[@id='nava']")
	WebElement marketname;

	@FindBy(xpath="//*[@id='nameofuser']")
	WebElement get_username;

	@FindAll({
		@FindBy(xpath = "//*[@id=\"nava\"]"),
		@FindBy(xpath = "//div[@id='navbarExample']//a[contains(text(),'Home')]")
		
	})
	WebElement nav_homebt;
	
	public Loginpage(WebDriver d) {
		PageFactory.initElements(d, this);
		driver = d;
	}

	public void click_loginbt() {
		login.click();
	}

	public void enter_username_password(String u,String p) {
		un.sendKeys(u);
		pass.sendKeys(p);
	}

	public void click_loginsubmit() throws Exception {
		sumbitloginbutton.click();
		al=new AlertsHandler(driver);
		Boolean at=al.isAlertPresent();
		System.out.println("Alert is present= "+at);
		if(at=true) {
			al.getalertMessage(at);	
		}
		System.out.println("Done");
		

	}

	public SelectProductPage validate_user(WebDriver driver) throws Exception {

		System.out.println("Username:=" + get_username.getText());
		System.out.println("Storename="+marketname.getText());
		return new SelectProductPage(driver);
	}
	
	public void click_nav_Home() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(nav_homebt));
		nav_homebt.click();
		System.out.println("Navigated to Home Page");
	}


}
