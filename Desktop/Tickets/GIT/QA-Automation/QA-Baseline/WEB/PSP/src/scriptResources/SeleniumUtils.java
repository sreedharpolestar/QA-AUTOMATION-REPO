package scriptResources;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import io.github.bonigarcia.wdm.MarionetteDriverManager;

public class SeleniumUtils extends LoggingFactory {
	private static String binaryPath;
	private static WebDriver driver;
	public String chromedriverPath = getProps().getProperty("chromedriverPath");

	public SeleniumUtils() {
		binaryPath = getProps().getProperty("binaryPath");

		verbose("Selenium Utils class instanciated");
	}

	protected void setDriver(String browser) {

		
		if (browser.equalsIgnoreCase("Firefox")) {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setEnableNativeEvents(true);
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Chrome")) {
			
			/*getDriver().get(getProps().getProperty("chromedriverPath"));*/
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sreedhar.popuri\\Desktop\\Family passport\\chromedriver_win32(2)\\chromedriver.exe");	
			
			
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", binaryPath + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			error("Browser type is unknown. terminating the tests for >>>>>>>" + browser);
			System.exit(1);

		}

		verbose("Launching " + browser + " browser for tests..");
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public void waitExplicitly(int seconds) {

		try {

			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

}
