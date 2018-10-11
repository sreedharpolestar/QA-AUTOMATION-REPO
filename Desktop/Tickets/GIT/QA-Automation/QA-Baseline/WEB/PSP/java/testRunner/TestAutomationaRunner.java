package testRunner;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testDatas.*;
import testEnviroments.*;
import pageObjectMethods.*;
import browserType.*;
import modules.*;

public class TestAutomationaRunner {

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
		
		//

	}

	@AfterTest
	public void tearDown() throws Exception {
		BrowserType.closeAllDriver();
	}

}