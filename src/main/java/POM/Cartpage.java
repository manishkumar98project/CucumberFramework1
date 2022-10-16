package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {

	WebDriver driver;
	public int noproduct;
	
	@FindAll({
		@FindBy(id ="itemc21212" ),
		@FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[4]/a"),//correct
		@FindBy(xpath = "//a[@class='btn btn-success btn-l4435g']")
	})
	@CacheLookup
	WebElement nav_cartbt;
	
	@FindBy(xpath = "(//*[@id='tbodyid']//a[contains(text(),'Delete')])[1]")
	WebElement deleteP;
	
	@FindBy(xpath = "//*[@id='tbodyid']/tr[1]/td[2]")
	WebElement productname;
	
	public Cartpage(WebDriver d) {
		PageFactory.initElements(d, this);
		driver = d;
	}

	
	public void click_cartbt() throws InterruptedException {
		Thread.sleep(2000);
		nav_cartbt.click();
		System.out.println("++++++ Inside Cart Page +++++++++");
	}
	
	public void print_no_of_product() {
		List<WebElement> numberofselectedproduct = driver.findElements(By.className("success"));
		noproduct=numberofselectedproduct.size();
		System.out.println("No of product= "+noproduct);
	} 
	
	public void delete_product() {
		
		if(noproduct>0) {
			deleteP.click();
			driver.navigate().refresh();
			System.out.println("The product Deleted is= "+productname.getText());
		}
		else {
			System.out.println("====== There is no Product inside Cart ==============");
		}
	}
}
