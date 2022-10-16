package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.AlertsHandler;

public class Contactspage {
	WebDriver driver;
	
	
	@FindAll({
		@FindBy(id ="itemc21212" ),
		@FindBy(xpath = "//*[@id=\"navbarExample\"]//a[text()='Contact']"),//correct
		@FindBy(xpath = "//a[@class='btn btn-success btn-l443534g']")
	})
	WebElement nav_contactsbt;
	
	@FindBy(xpath = "//*[@id=\"recipient-email\"]")
	WebElement input_email;
	
	@FindBy(xpath = "//*[@id=\"recipient-name\"]")
	WebElement input_name;
	
	@FindBy(xpath = "//*[@id=\"message-text\"]")
	WebElement input_message;
	
	@FindAll({
		@FindBy(id ="itemc21212" ),
		@FindBy(xpath = "//div[@class='modal-footer']//button[text()='Send message']"),//correct
		@FindBy(xpath = "//a[@class='btn btn-success btn-l443534g']")
	})
	WebElement con_send_messagebt;
	
	public Contactspage(WebDriver d) {
		PageFactory.initElements(d, this);
		driver = d;
	}

	
	public void click_nav_contacts() {
		nav_contactsbt.click();
	}
	
	public void fill_email(String e) {
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOf(input_name));
		input_email.sendKeys(e);
	}
	public void fill_name(String n) {
		
		input_name.sendKeys(n);
	}
	public void fill_message(String m) {
		input_message.sendKeys(m);
	}
	public void click_send_message() throws InterruptedException {
		con_send_messagebt.click();
		AlertsHandler al=new AlertsHandler(driver);
		Boolean at=al.isAlertPresent();
		System.out.println("Alert is present= "+at);
		if(at=true) {
			al.getalertMessage(at);	
		}
		System.out.println("Done");
	}
	
	
}
