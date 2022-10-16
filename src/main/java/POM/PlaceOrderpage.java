package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.AlertsHandler;

public class PlaceOrderpage {

	WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy(xpath = "//*[@id='page-wrapper']//button[contains(text(),'Place Order')]")
	WebElement place_orderbt;
	
	@FindBy(xpath = "//*[@id='name']")
	WebElement input_name;
	
	@FindBy(xpath = "//*[@id='country']")
	WebElement input_country;
	
	@FindBy(xpath = "//*[@id='city']")
	WebElement input_city;
	
	@FindBy(xpath = "//*[@id='card']")
	WebElement input_creditcard;
	
	@FindBy(xpath = "//*[@id='month']")
	WebElement input_Cmonth;
	
	@FindBy(xpath = "//*[@id='year']")
	WebElement input_Cyear;
	
	@FindBy(xpath = "//*[@id='orderModal']//button[text()='Purchase']")
	WebElement purchase_bt;
	
	@FindBy(xpath = "//*[@id='orderModal']//button[text()='Close']")
	WebElement close_bt;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement endok_bt;
	
	
	public PlaceOrderpage(WebDriver d) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(d, this);
		driver = d;
	}

	public void click_placeOrder() {
		Cartpage nct=new Cartpage(driver);
		nct.print_no_of_product();
		/*
		 * if(nct.noproduct>0) { place_orderbt.click(); } else {
		 * System.out.println("+++++ First Place Order +++++"); }
		 */
		place_orderbt.click();
		System.out.println("+++++ First Place Order +++++");
	}
	
	public void fill_detail(String name,String country,String city,String card,String month,String year) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(input_name)).click();
		input_name.sendKeys(name);
		input_country.sendKeys(country);
		input_city.sendKeys(city);
		input_creditcard.sendKeys(card);
		input_Cmonth.sendKeys(month);
		input_Cyear.sendKeys(year);
	}
	
	public void click_purchasebt() throws InterruptedException {
		purchase_bt.click();
		AlertsHandler al = new AlertsHandler(driver);
		if(al.isAlertPresent()==true) {
			al.getalertMessage(true);
		}
		System.out.println("Purchase Done");
	}
	
	public void verify_orderis_placed() throws InterruptedException {
		Thread.sleep(1000);
//		WebElement last_message=driver.findElement(By.xpath("//p[@class='lead text-muted']"));
//		wait.until(ExpectedConditions.visibilityOf(last_message));
//		Boolean order=last_message.isDisplayed();
		Boolean order=endok_bt.isDisplayed();
		System.out.println("------------- Order Is Placed -------------");
		if(order==true) {
			endok_bt.click();
			
			System.out.println("--------------Order Is Placed It Will Delivered Soon ------------------");
		}
			
	}
	
	
	
}
