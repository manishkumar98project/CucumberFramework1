package POM;

import java.time.Duration;
import java.util.List;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.is;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.AlertsHandler;

public class SelectProductPage{

	WebDriver driver;
	String productname;

	@FindAll({
		@FindBy(id ="nameofuser123" ),
		@FindBy(xpath ="//*[@id='nameofuser']"),//correct
		@FindBy(xpath = "//*[@id='logout223']")
	})
	WebElement get_username;

	@FindAll({
		@FindBy(id ="nava123" ),
		@FindBy(xpath ="//*[@id='nava']"),//correct
		@FindBy(xpath = "//*[@id='logout243']")
	})
	WebElement marketname;

	@FindAll({
		@FindBy(id ="logout2123" ),
		@FindBy(xpath ="//*[@id='logout2']"),//correct
		@FindBy(xpath = "//*[@id='logout2123']")
	})
	WebElement logout;

	@FindAll({
		@FindBy(id ="logout2123" ),
		@FindBy(xpath ="//div[@class='list-group']/a[contains(text(),'Phones')]"),//correct
		@FindBy(xpath = "//a[contains(text(),'Phones')]")//correct
	})
	WebElement click_on_phone_categorie;

	@FindAll({
		@FindBy(id ="logout2123" ),
		@FindBy(xpath ="//div[@class='list-group']/a[contains(text(),'Laptop12')]"),
		@FindBy(xpath = "//a[contains(text(),'Laptop')]")//correct
	})
	WebElement click_on_laptop_categorie;

	@FindAll({
		@FindBy(id ="itemc" ),
		@FindBy(xpath ="//div[@class='list-group']/a[contains(text(),'Laptop12')]"),
		@FindBy(xpath = "//a[contains(text(),'Monitors')]")//correct
	})
	WebElement click_on_monitor_categorie;

	@FindBy(xpath = "//*[@id='tbodyid']/h2")
	WebElement get_product_name;

	@FindBy(xpath = "//*[@id='tbodyid']/h3")
	WebElement get_product_price;

	@FindBy(xpath = "//*[@id='more-information']/p")
	WebElement get_product_desc;

	@FindAll({
		@FindBy(id ="itemc2112" ),
		@FindBy(xpath = "//div[@id='tbodyid']/div[2]/div/a[contains(text(),'Add to cart')]"),//correct
		@FindBy(xpath = "//a[@class='btn btn-success btn-lg']")//correct
	})
	WebElement click_addtocart;

	@FindAll({
		@FindBy(xpath = "//*[@id=\"nava\"]"),
		@FindBy(xpath = "//div[@id='navbarExample']//a[contains(text(),'Home')]")
		
	})
	WebElement nav_homebt;

	@FindAll({
		@FindBy(id ="itemc21212" ),
		@FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[4]/a"),//correct
		@FindBy(xpath = "//a[@class='btn btn-success btn-l4435g']")
	})
	WebElement nav_cartbt;

	
	
	
	public SelectProductPage(WebDriver d) {
		PageFactory.initElements(d, this);
		driver = d;
	}


	public void click_nav_Home() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(nav_homebt));
		nav_homebt.click();
		System.out.println("Navigated to Home Page");
	}
	public void validate_sucessfull_login() {
		logout.isDisplayed();
		System.out.println("Username:=" + get_username.getText());
		System.out.println("Storename="+marketname.getText());
	}

	public void click_categories(String categorie) {

		if(categorie.equalsIgnoreCase("Mobile")) {

			click_on_phone_categorie.click();
		}
		else if (categorie.equalsIgnoreCase("Laptop")) {

			click_on_laptop_categorie.click();
		}
		else if (categorie.equalsIgnoreCase("Monitor")) {

			click_on_monitor_categorie.click();
		}


	}

	public void click_at_product(String productName) throws InterruptedException {
		productname = productName;
		Thread.sleep(1000);
		WebElement product=driver.findElement(By.xpath("//div[@id='tbodyid']//h4[@class='card-title']/a[contains(text(),'"+productName+"')]"));
		product.click();
	}

	public void product_detail() {
		System.out.println("NAME OF PRODUCT= "+get_product_name.getText());	
		System.out.println("PRICE= "+get_product_price.getText());	
		System.out.println("DESCRIPTION= "+get_product_desc.getText());	
	}

	public void validate_selected_pt() {
		String name=get_product_name.getText();
		
		
//		assertThat(productname, equalTo(name));
//		Assert.assertEquals(productname, get_product_name.getText());
		System.out.println("Assert done");
	}

	public void click_Add_to_cart() throws InterruptedException {
		click_addtocart.click();
		AlertsHandler al = new AlertsHandler(driver);
		if(al.isAlertPresent()==true) {
			al.getalertMessage(true);
		}
		System.out.println("Done");

	}

	public void check_product_at_cart() {
		nav_cartbt.click();
		List<WebElement> numberofselectedproduct = driver.findElements(By.className("success"));
		System.out.println("No of product= "+numberofselectedproduct.size());
	}
}


