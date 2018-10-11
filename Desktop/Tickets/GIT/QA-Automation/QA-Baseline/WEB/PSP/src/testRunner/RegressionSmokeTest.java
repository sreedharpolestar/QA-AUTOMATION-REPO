package testRunner;

import helpFAQ.FaqPageTest;

import java.util.concurrent.TimeUnit;

import notifications.TestNotificationsHome;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import administration.AccountModule;
import administration.ContactModule;
import administration.FleetModule;
import administration.LoginModule;
import reports.ReportsPage;
import scriptResources.*;
import testEnviroments.*;
import pageObjectMethods.Login;

public class RegressionSmokeTest {
	
	DesiredCapabilities capability = DesiredCapabilities.chrome();
	
	public static WebDriver driver = BrowserType.getBrowser("Chrome");
	
	@BeforeClass
	public void log4j()
	{
		
		String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\PoleStar_Sanitypack\\PpoleStar_Regression\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
        System.out.println("initialized log4j configuration");	
	}

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
	public void faqTest() throws Throwable {
		
		Logger log = Logger.getLogger("Logger");
		log.info("*********launched Faq Test**************");

		FaqPageTest.checkIfHelpFAQAvailable(driver);
		log.info("****************Faq is completed************");
		Thread.sleep(3000);
	}

	@Test(priority = 3)
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

	@Test(priority = 5)
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
	}

	/*@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void ShipsWithIMOModule() throws Throwable {

		Logger log = Logger.getLogger("Logger");
		log.info("**********launched ShipsWitIMONumber Test************");

		// Click Administration text link
		Login.administration_menu_link(driver).click();
		Thread.sleep(3000);
		log.info("Administration text clicked");

		// ShipsWithoutIMONumber
		ShipsWithIMOModule.CreateShipswithIMOnumber(driver);
		log.info("****************ShipsWithIMOModule is completed************");
		Thread.sleep(3000);
	}
	*/
	
	@Test(priority = 8)
	public void NotificationsHome() throws Throwable {
		
		Logger log = Logger.getLogger("Logger");
		log.info("**********launched Notofications Zones page Test and completed************");
		Thread.sleep(3000);
	}
	@Test(priority = 9)
	public void ShipwithoutIMO() throws Throwable {
		
		Logger log = Logger.getLogger("Logger");
		log.info("**********shipswithoutIMO page Test and completed************");
		Thread.sleep(3000);
	}
	@Test(priority = 10)
	public void ShipwithIMO() throws Throwable {
		
		Logger log = Logger.getLogger("Logger");
		log.info("**********shipswitIMO page Test and completed************");
		Thread.sleep(3000);
	}
	
	@Test(priority = 6)
	public void users() throws Throwable {

		Logger log = Logger.getLogger("Logger");
		log.info("**********launched Contact Test**************");

		// Click Administration text link
		Login.administration_menu_link(driver).click();
		Thread.sleep(3000);
		log.info("Administration text clicked");

		// Contact
		/*UsersModule.user(driver);*/
		log.info("****************Users is completed************");
		Thread.sleep(3000);
	}
	
	@Test(priority = 7)
	public void TestNotificationsHome() throws Throwable {

		Logger log = Logger.getLogger("Logger");
		log.info("**********launched Notifications module Test**************");
		Thread.sleep(3000);
	}
	
	/*@Test(priority = 8)
	public void reports() throws Throwable {

		Logger log = Logger.getLogger("Logger");
		log.info("**********launched reports module Test**************");
		
		ReportsPage.reports(driver);
		Thread.sleep(3000);
	}
	
	@Test(priority = 9)
	public void shipReport() throws Throwable {

		Logger log = Logger.getLogger("Logger");
		log.info("**********launched reports module Test**************");
		
		ReportsPage.shipReport(driver);
	}
	
	@Test(priority = 10)
	public void dragAndDrop() throws Throwable {

		Logger log = Logger.getLogger("Logger");
		log.info("**********launched drag and drop Test**************");
		
		ReportsPage.dragAndDrop(driver);
	}*/
	
	@AfterClass
	public void tearDown() throws Exception {
		BrowserType.closeAllDriver();
	}

}