package modules;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testEnviroments.*;
import browserType.*;
import pageObjectMethods.Login;

public class RegressionSmokeTest {

	public static WebDriver driver = BrowserType.getBrowser("Chrome");

	@Test(priority = 0)
	public void login() throws Throwable {
		Logger log = Logger.getLogger("Logger");
		driver.get(enviroments.url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		log.info("Web application launched");

		// Login
		LoginModule.login(driver);
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void account() throws Throwable {

		Logger log = Logger.getLogger("Logger");
		log.info("*********launched Account Test**************");

		// Click Administration text link
		Login.administration_menu_link(driver).click();
		Thread.sleep(3000);
		log.info("Administration text clicked");

		// Account
		AccountModule.account(driver);
		log.info("****************Account is completed************");
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void contact() throws Throwable {

		Logger log = Logger.getLogger("Logger");
		log.info("**********launched Contact Test**************");

		// Click Administration text link
		Login.administration_menu_link(driver).click();
		Thread.sleep(3000);
		log.info("Administration text clicked");

		// Contact
		ContactModule.contact(driver);
		log.info("****************Contact is completed************");
		Thread.sleep(3000);
	}

	/*@Test(priority = 3)
	public void fleet() throws Throwable {

		Logger log = Logger.getLogger("Logger");
		log.info("***********launched fleet Test***********");

		// Click Administration text link
		Login.administration_menu_link(driver).click();
		Thread.sleep(3000);
		log.info("Administration text clicked");

		// Fleet
		FleetModule.fleet(driver);
		log.info("****************Fleet is completed************");
		Thread.sleep(3000);
	}*/

	@Test(priority = 2)
	public void ShipsWithoutIMOModule() throws Throwable {

		Logger log = Logger.getLogger("Logger");
		log.info("**********launched ShipsWithoutIMONumber Test************");

		// Click Administration text link
		Login.administration_menu_link(driver).click();
		Thread.sleep(3000);
		log.info("Administration text clicked");

		// ShipsWithoutIMONumber
		ShipsWithoutIMOModule.RegisterShipWithoutIMONumber(driver);
		log.info("****************ShipsWithoutIMOModule is completed************");
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		BrowserType.closeAllDriver();
	}

}