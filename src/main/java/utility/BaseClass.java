package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	public static WebDriver driver;
	public static String user = System.getProperty("user.dir");
	public WebDriver setupbrowser() {

//		WebDriverManager.chromedriver().driverVersion("99.0.4844.84").setup();
		System.setProperty("webdriver.chrome.driver", "D:\\BrowserDriverForAll\\LatestDriver\\chromedriver.exe");
		// to seperate the download files directory path
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles"
				+ File.separator + "ChromeFileDownloads");
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", prefs);

		// to open in incognito mode
		option.addArguments("--incognito");
		driver = new ChromeDriver(option);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;

	}

//	public void closebrowser(Scenario so) {

//		try {
//			String screenshotName=so.getName().replaceAll(" ", "_");
//			if(so.isFailed()) {
//				so.log("This is my failure message");
//				TakesScreenshot ts=(TakesScreenshot) driver;
//				byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//				so.attach(screenshot, "image/png", screenshotName);		
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.quit();
//	}
//	
//

	public static String configclass1(String parameter) {
		try {

			Properties prop = new Properties();
			FileInputStream input = new FileInputStream(user + "\\src\\main\\java\\config\\config.properties");
			prop.load(input);
			String param = prop.getProperty(parameter);
			// System.out.println(param);
			return param;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
}
