package scriptResources;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaseTest extends SeleniumUtils {

	private static String implecitWaitTime;
	private static String explicitWaitTime;

	public BaseTest() {
		
		setWaitTimes(getProps().getProperty("implecitWaitTime"), getProps().getProperty("explicitWaitTime"));
verbose("Base test class instanciated");
	}

	private static void setWaitTimes(String implecitWaitTime, String explicitWaitTime) {
		
		BaseTest.implecitWaitTime = implecitWaitTime; 
		BaseTest.explicitWaitTime = explicitWaitTime;

	}
	
	public static String getImplicitWaitTime(){
		return BaseTest.implecitWaitTime;
	}
	
	public static String getExlicitWaitTime(){
		return BaseTest.explicitWaitTime;
	}
	public void printEndOfTestIdentifierLogs(){
		verbose("********************************************************");
		verbose("********************************************************");
		verbose("******************************************************** END of Test Method **");
	}
	public void printEndOfTestClassIdentifierLogs(){
		verbose("********************************************************");
		verbose("********************************************************");
		verbose("******************************************************** END of Test Class **");
	}
	

	public void setup(String browser) {
		verbose("Entered in the setup method for >>   "+browser);
		
		setDriver(browser);
		
		WebDriver driver = getDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(getProps().getProperty("platformURL"));
		driver.manage().window().maximize();
		
	}
	
	public static void tearDown() throws InterruptedException{
		if (getDriver() != null){
			verbose("Tearing down the test setup...");
			getDriver().quit();
			
		}
	}
	
	
}
