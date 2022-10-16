package utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class AlertsHandler {

	WebDriver driver;

	public AlertsHandler(WebDriver d) {

		
		this.driver=d;
	}

	public void getalertMessage(Boolean at) {

		try {
		
			if(at==true) {
				Alert alert = driver.switchTo().alert(); // switch to alert
				String alertMessage= alert.getText(); // capture alert message
				System.out.println("AlertMessage= "+alertMessage); // Print Alert Message
				Thread.sleep(4000);
				alert.accept();
				System.out.println("++Alert is Accepted++");
			}else {
				System.out.println("No Alert is found");
			}
//			Assert.fail("AlertMessage= "+alertMessage); // Print Alert Message

		} catch (NoAlertPresentException r) {
			// TODO Auto-generated catch block
			
			System.out.println("No alert exception");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public boolean isAlertPresent() throws InterruptedException
	{
		try
		{
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(2000);
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex)
		{
			return false;
		} // catch
		
	} // isAlertPresent()
	

}
