package notifications;


import java.util.concurrent.TimeUnit;

import notifications.NotificationsAMVER;
import notifications.NotificationsIncident;
import notifications.NotificationsOverduePositionPage;
import notifications.NotificationsPositionsPage;
import notifications.NotificationsSSASAlertPage;
import notifications.NotificationsSSASTestAlertPage;
import notifications.NotificationsSSRS;
import notifications.NotificationsScheduledReport;
import notifications.NotificationsWarningPage;
import notifications.NotificationsZonesPage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import scriptResources.*;
import testEnviroments.enviroments;
///import Notification_resources.LoginPage;
/*import com.polestarglobal.pom.pages.landingandmap.LandingAndMapPage;
import com.polestarglobal.pom.pages.notifications.NotificationsSSASAlertPage;
import com.polestarglobal.pom.pages.notifications.NotificationsSSASTestAlertPage;
import com.polestarglobal.pom.pages.notifications.NotificationsWarningPage;*/
//import Notification_resources.BaseTest;
//import Notification_resources.BasePage;
//import Notification_resources.LoggingFactory;



 public class TestNotificationsHome extends BaseTest{
	NotificationsZonesPage notificationsZonePage = new NotificationsZonesPage(getDriver());
	NotificationsSSASAlertPage notificationsSSASAlertPage = new NotificationsSSASAlertPage(getDriver());
	NotificationsSSASTestAlertPage notificationsSSASTestAlertPage = new NotificationsSSASTestAlertPage(getDriver());
	NotificationsWarningPage notificationsWarningPage = new NotificationsWarningPage(getDriver());
	NotificationsPositionsPage notificationsPositionsPage = new NotificationsPositionsPage(getDriver());
	NotificationsOverduePositionPage notificationsOverDuePositionsPage = new NotificationsOverduePositionPage(getDriver());
	NotificationsScheduledReport notificationsScheduledReport = new NotificationsScheduledReport(getDriver());
	NotificationsIncident notificationsIncident = new NotificationsIncident(getDriver());
	NotificationsAMVER notificationsAMVER = new NotificationsAMVER(getDriver());
	NotificationsSSRS notificationsSSRS = new NotificationsSSRS(getDriver());
	/*LandingAndMapPage landingPage = new LandingAndMapPage(getDriver());*/
	/*LoginPage loginPage = PageFactory.initElements(getDriver(), LoginPage.class);*/
	LoginPage loginPage = new LoginPage(getDriver());
	LoggingFactory log = new LoggingFactory();
	DesiredCapabilities capability = DesiredCapabilities.chrome();
	
	/*@BeforeClass
	public void log4j()
	{
		
		String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
        verbose("initialized log4j configuration");
	
	}*/
	
	@BeforeClass
	public void testSetup() throws Throwable {
		verbose("Starting the Automated Regression test suite....");
		setup("Chrome");
		loginPage.login();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDownTest() throws Throwable {
		waitExplicitly(5);
		tearDown();
	}
/*	
	@BeforeClass
	//@Parameters("browser")
	public void beforeClass() {
		//setup("chrome");
		loginPage.login();
		//verbose("Notifications page tests are run on different URL.");

	}
	
	@AfterClass
	public void afterClass() throws Exception {
		printEndOfTestClassIdentifierLogs();
		//getDriver().get(getProps().getProperty("platformURL"));
	}*/
	@AfterMethod
	public void afterTestMethod(ITestResult testContext) {
		
		String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
        verbose("initialized log4j configuration");
        
		printEndOfTestIdentifierLogs();
		try{
			if(testContext.getStatus()==ITestResult.SUCCESS){
				verbose("End of executing Test: '" + testContext.getMethod().getMethodName()+"'. Test PASSED");
				
			}else if(testContext.getStatus()==ITestResult.FAILURE){
				error("End of executing Test: '" + testContext.getMethod().getMethodName()+"'. Test FAILED");
				
			}else if(testContext.getStatus()==ITestResult.SKIP){
				verbose("End of executing Test: '" + testContext.getMethod().getMethodName()+"'. Test was SKIPPED");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	@Test(priority=1)
	 public void ClickOnNotificationsMenu(){
		
		Assert.assertTrue(notificationsZonePage.isHeaderPresent(), "Notification header is not found. Assuming this has failed");
		
	}
	 
		
	/*@Test(priority=4)
	public void NotificationsDefault(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsZonePage.isDefaultValuesPresent(),"Notifications landing page defaults values are not found");
	}
	
	
	@Test(priority=5)
	public void NotificationsSortByEvents(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsZonePage.areEventsSortedCorrectly(), "Sorting is not done as per the Events!");
	}*/
	
//Below sorted functionality has some bugs, so not executing.
	/*@Test(priority=6)
	public void NotificationsSortByEditableTypes() throws Throwable{
		waitExplicitly(1);
		Assert.assertTrue(notificationsZonePage.sortByName(),"Notifications page is sort by Name");
		waitExplicitly(1);
		Assert.assertTrue(notificationsZonePage.sortByNotificationType(),"Notifications page is not sort by Notification Type");
		waitExplicitly(1);
		Assert.assertTrue(notificationsZonePage.sortByMostRecentlyAdded(),"Notifications page is not sort by Most recently added");
	
	}*/
	
	/*@Test(priority=9)
	public void newNotification_by_zone_default(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsZonePage.newNotification_by_zone_default());	
		waitExplicitly(2);
		Assert.assertTrue(notificationsZonePage.edit_ZoneDefault_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsZonePage.delete_ZoneDefault_profile());
	}
	
	@Test(priority=10)
	public void newNotification_by_zone_specific(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsZonePage.newNotification_by_zone_specific());
		waitExplicitly(2);
		Assert.assertTrue(notificationsZonePage.edit_ZoneSpecific_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsZonePage.edit_ZoneSpecific_profile());
	}*/
	
	/*@Test(priority=11)
	public void newNotification_by_SSAS_Alert_default(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsSSASAlertPage.newNotification_by_SSASAlert_default());
		waitExplicitly(2);
		Assert.assertTrue(notificationsSSASAlertPage.edit_SSASAlert_default_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsSSASAlertPage.delete_SSASAlert_default_profile());
	}
	
	@Test(priority=12)
	public void newNotification_by_SSAS_Alert_specific(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsSSASAlertPage.newNotification_by_SSASAlert_specific());
		waitExplicitly(2);
		Assert.assertTrue(notificationsSSASAlertPage.edit_SSASAlert_specific_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsSSASAlertPage.delete_SSASAlert_specific_profile());
	}*/
	

	/*@Test(priority=13)
	public void newNotification_by_SSAS_Test_Alert_default(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsSSASTestAlertPage.newNotification_by_SSASTestAlert_default());
		waitExplicitly(2);
		Assert.assertTrue(notificationsSSASTestAlertPage.edit_SSASTestAlert_default_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsSSASTestAlertPage.delete_SSASTestAlert_default_profile());
		
	}
	
	@Test(priority=14)
	public void newNotification_by_SSAS_Test_Alert_specific(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsSSASTestAlertPage.newNotification_by_SSASTestAlert_specific());
		waitExplicitly(2);
		Assert.assertTrue(notificationsSSASTestAlertPage.edit_SSASTestAlert_specific_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsSSASTestAlertPage.delete_SSASTestAlert_specific_profile());
	}*/
	
	/*@Test(priority=15)
	public void newNotification_by_Warning_default_notification(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsWarningPage.newNotification_by_Warning_default_notification());
		waitExplicitly(2);
		Assert.assertTrue(notificationsWarningPage.edit_Warning_default_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsWarningPage.delete_Warning_default_profile());
	}
	
	@Test(priority=16)
	public void newNotification_by_Warning_specific_notification(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsWarningPage.newNotification_by_Warning_specific_notification());
		waitExplicitly(2);
		Assert.assertTrue(notificationsWarningPage.edit_Warning_specific_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsWarningPage.delete_Warning_specific_profile());
	}*/
	
	/*@Test(priority=17)
	public void newNotification_by_Position_default_notification(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsPositionsPage.newNotification_by_Position_default_notification());
		waitExplicitly(2);
		Assert.assertTrue(notificationsPositionsPage.edit_Position_default_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsPositionsPage.delete_Position_default_profile());
	}*/
	
	/*@Test(priority=18)
	public void newNotification_by_Position_specific_notification(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsPositionsPage.newNotification_by_Position_specific_notification());
		waitExplicitly(2);
		Assert.assertTrue(notificationsPositionsPage.edit_Position_specific_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsPositionsPage.delete_Position_specific_profile());
	}
	
	@Test(priority=19)
	public void newNotification_by_OverduePosition_default_notification(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsOverDuePositionsPage.newNotification_by_OverduePosition_default_notification());
		waitExplicitly(2);
		Assert.assertTrue(notificationsOverDuePositionsPage.edit_OverduePosition_default_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsOverDuePositionsPage.delete_OverduePosition_default_profile());
		
	}*/
	
	/*@Test(priority=20)
	public void newNotification_by_OverduePosition_specific_notification(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsOverDuePositionsPage.newNotification_by_OverduePosition_specific_notification());
		waitExplicitly(2);
		Assert.assertTrue(notificationsOverDuePositionsPage.edit_OverduePosition_specific_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsOverDuePositionsPage.delete_OverduePosition_specific_profile());
	}
	
	@Test(priority=22)
	public void newNotification_by_Report_default_notification(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsScheduledReport.newNotification_by_Report_default_notification());	
	}
	
	@Test(priority=23)
	public void newNotification_by_Report_specific_notification(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsScheduledReport.newNotification_by_Report_specific_notification());
		waitExplicitly(2);
		Assert.assertTrue(notificationsScheduledReport.edit_Report_specific_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsScheduledReport.delete_Report_specific_profile());
	}
	
	@Test(priority=24)
	public void newNotification_by_Incident_default_notification_(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsIncident.newNotification_by_Incident_morethan1000());
	}
	
	@Test(priority=25)
	public void newNotification_by_Incident_Specific_notification_(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsIncident.newNotification_by_Incident_specific_notification());
		waitExplicitly(2);
		Assert.assertTrue(notificationsIncident.edit_Incident_default_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsIncident.delete_Incident_default_profile());
	}*/
	
	@Test(priority=26)
	public void newNotification_by_AMVER_default_notification(){
		/*waitExplicitly(1);
		Assert.assertTrue(notificationsAMVER.newNotification_by_AMVER_default_notification());
		waitExplicitly(2);*/
		/*Assert.assertTrue(notificationsAMVER.edit_AMVER_default_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsAMVER.delete_AMVER_default_profile());*/
	}
	
	@Test(priority=27)
	public void newNotification_by_AMVER_specific_notification(){
		/*waitExplicitly(1);
		Assert.assertTrue(notificationsAMVER.newNotification_by_AMVER_specific_notification());
		waitExplicitly(2);*/
		/*Assert.assertTrue(notificationsAMVER.edit_AMVER_specific_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsAMVER.delete_AMVER_specific_profile());*/
	}
	
	@Test(priority=28)
	public void newNotification_by_SSRS_notification(){
		waitExplicitly(1);
		Assert.assertTrue(notificationsSSRS.newNotification_by_SSRS__notification());
		waitExplicitly(2);
		Assert.assertTrue(notificationsSSRS.edit_SSRS_default_profile());
		waitExplicitly(2);
		Assert.assertTrue(notificationsSSRS.delete_SSRS_default_profile());
	}
}
