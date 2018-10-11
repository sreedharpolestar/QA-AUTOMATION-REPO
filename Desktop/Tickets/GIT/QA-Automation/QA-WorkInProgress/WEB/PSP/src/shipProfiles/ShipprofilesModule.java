package shipProfiles;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectMethods.Account;
import pageObjectMethods.Global;
import scriptResources.*;
import shipProfiles.ShipProfiles_Deleteprofile;
import shipProfiles.ShipProfiles_Editprofile;
import shipProfiles.ShipProfiles_Homepage;
import shipProfiles.ShipProfiles_newprofile;
import testDatas.AccountTestData;
import pageObjectMethods.*;
import testDatas.*;

import org.apache.log4j.Logger;

/*import Notification_resources.BaseTest;
import Notification_resources.LoggingFactory;
import Notification_resources.LoginPage;*/

public class ShipprofilesModule extends BaseTest{

	
	ShipProfiles_Homepage shipProfiles_default = new ShipProfiles_Homepage(getDriver());
	ShipProfiles_Editprofile shipProfiles_edit = new ShipProfiles_Editprofile(getDriver());
	ShipProfiles_Deleteprofile shipProfiles_delete = new ShipProfiles_Deleteprofile(getDriver());
	ShipProfiles_newprofile shipProfiles_new = new ShipProfiles_newprofile(getDriver());
	
	LoginPage loginPage = new LoginPage(getDriver());
	//LoginPage loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
	LoggingFactory log = new LoggingFactory();
	DesiredCapabilities capability = DesiredCapabilities.chrome();
	
	By username = By.id("username");
	
	By password = By.id("password");
	By login_button = By.xpath("//psp-app/ps-login-component/div/div/form/button");
	
	/*@BeforeClass
	public void log4j()
	{
		
		String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
        verbose("initialized log4j configuration");
	
	}*/
	
	@BeforeClass
	public void testSetup() throws Throwable {
		verbose("Starting the Automated Regression test for Ship profiles....");
		setup("Chrome");
		
		loginPage.login_profiles();
		
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public void tearDownTest() throws Throwable {
		waitExplicitly(5);
		tearDown();
	}

	@AfterMethod
	public void afterTestMethod(ITestResult testContext) {
		
		String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\PSP_Automation\\PSP_Automation_Project\\PSP_Automation_Project\\PSP_Automation_Project\\PSP_Automation_Project\\Ericsson\\src\\resources\\log4j.properties";
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
	 public void Navigate_to_profiles(){
		
		Assert.assertTrue(shipProfiles_default.navigateToProfiles());
		
	}
	 
		
	/*@Test(priority=2)
	public void ShipProfilesDefault_sorting(){
		waitExplicitly(1);
		Assert.assertTrue(shipProfiles_default.profilesDefaultsorted());
	}
	
	
	
	@Test(priority=3)
		public void ShipProfiles_sortByname(){
			waitExplicitly(1);
			Assert.assertTrue(shipProfiles_default.sortbyName());
	}
	
	@Test(priority=4)
	public void ShipProfiles_searchProfile(){
		waitExplicitly(1);
		Assert.assertTrue(shipProfiles_default.searchshipProfile());
	}*/
	
	@Test(priority=5)
	public void ShipProfiles_editProfile() throws Exception{
		waitExplicitly(1);
		Assert.assertTrue(shipProfiles_edit.editProfile());
	}
	
	
	@Test(priority=6)
	public void ShipProfiles_sidepanel(){
		waitExplicitly(1);
		Assert.assertTrue(shipProfiles_default.sidepanel());
	}
	
	/*@Test(priority=7)
	public void ShipProfiles_account() {
		
		try {
			Assert.assertTrue(ShipProfiles_newprofile.createNewAccount());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitly(1);
	}*/
	
	/*@Test(priority=7)
	public void newProfile_account()throws Throwable{
		waitExplicitly(1);
		Assert.assertTrue(shipProfiles_new.account());
	}*/
	
	@Test(priority=8)
	public void newProfile()throws Throwable{
		waitExplicitly(1);
		Assert.assertTrue(shipProfiles_new.newProfile());
	}
	
	@Test(priority=9)
	public void verify_Shipiconprofiledropdown()throws Throwable{
		waitExplicitly(1);
		Assert.assertTrue(shipProfiles_new.verify_Shipiconprofiledropdown());
	}
	
	@Test(priority=9)
	public void deleteProfile()throws Throwable{
		waitExplicitly(1);
		Assert.assertTrue(shipProfiles_delete.deleteProfile(null));
	}
	
}
