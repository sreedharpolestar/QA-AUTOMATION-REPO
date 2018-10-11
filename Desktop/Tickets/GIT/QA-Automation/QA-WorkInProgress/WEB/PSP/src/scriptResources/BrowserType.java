package scriptResources;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserType {
 
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	DesiredCapabilities capability = DesiredCapabilities.chrome();
 
	/*
	 * Factory method for getting browsers
	 */

	public static WebDriver getBrowser(String browserName) {
		
		WebDriver driver = null;
 
		switch (browserName) {
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {
				System.setProperty("webdriver.firefox.bin", "C:\\Users\\sreedhar.popuri\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
				driver = new FirefoxDriver();
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize(); 
				drivers.put("Firefox", driver);
			}
			break;
		case "IE":
			driver = drivers.get("IE");
			if (driver == null) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Selenium\\IEDriverServer.exe");
				
				
				driver = new InternetExplorerDriver();
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize(); 
				drivers.put("IE", driver);
			}
			break;
		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {
				
				
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\sreedhar.popuri\\workspace\\chromedriver.exe");	
				
				
				driver = new ChromeDriver();
				driver.manage().window().maximize(); 
				drivers.put("Chrome", driver);
			}
			break;
		}
		return driver;
	}
 
	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
}