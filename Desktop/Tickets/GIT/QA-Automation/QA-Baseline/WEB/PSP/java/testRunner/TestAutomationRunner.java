package testRunner;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testEnviroments.*;
import browserType.*;
import modules.*;

public class TestAutomationRunner {

	@Test
	public void createNewAccount() throws Throwable{
		WebDriver driver = BrowserType.getBrowser("Chrome");
		Logger log = Logger.getLogger("Logger");

		driver.get(enviroments.url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		log.info("Web application launched");

		// Login
		IntegrationTest.login(driver);

		// Create an account
		IntegrationTest.account(driver);

	}

	@AfterTest
	public void tearDown() throws Exception {
		BrowserType.closeAllDriver();
	}

}