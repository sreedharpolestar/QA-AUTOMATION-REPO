package speedvariance.manage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
/*import Notification_resources.BasePage;
import Notification_resources.LoginPage;*/
//import adminSpeedVariance.AdminSpeedVarianceAlarmSettingsPage;
/*import Notification_resources.BaseTest;*/

import scriptResources.*;

public class AdminSpeedVarianceAlarmSettings extends BaseTest{
	LoginPage loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
	AdminSpeedVarianceAlarmSettingsPage speedVariance_click = new AdminSpeedVarianceAlarmSettingsPage(getDriver());
	
	@BeforeSuite
	public void testSetup() {
		verbose("Starting the Automated Regression test suite....");
		
		setup("Chrome");
		loginPage.login_speed();

	}
	
	@AfterSuite
	public void tearDownTest() throws Throwable {
		waitExplicitly(5);
		tearDown();
	}
	
	@AfterMethod
	public void afterTestMethod(ITestResult testContext) {
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
	 public void ClickOnSpeedVarianceMenu(){
			
			Assert.assertTrue(speedVariance_click.adminSpeedVarianceClick(), "Clicking on SpeedVariance menu");
			
		}
	
	@Test(priority=2)
	 public void verifyVesselsettingsTabtooltip(){
			
			Assert.assertTrue(speedVariance_click.verifyVesselsettingsTabtooltip(), "Verifying the tool-tip");
			
		}
	
	@Test(priority=3)
	public void verifyAverageSpeedDeviationalarmdefinitions(){
		Assert.assertTrue(speedVariance_click.verifyAverageSpeedDeviation(), "Average Speed Deviation alarm definitions");
	}
	
	@Test(priority=4)
	public void verifyAcceralatedSpeedDeviationalarmdefinitions(){
		Assert.assertTrue(speedVariance_click.verifyAccelaratedSpeedDeviation(), "Accelarated Speed Deviation alarm definitions");
	}
	
	@Test(priority=5)
	public void verifySingleSpeedDeviationalarmdefinitions(){
		Assert.assertTrue(speedVariance_click.verifySingleSpeedDeviation(), "Single Speed Deviation alarm definitions");
	}
	
	@Test(priority=6)
	public void verifyNoSpeedDeviationalarmdefinitions(){
		Assert.assertTrue(speedVariance_click.verifyNoPlannedSpeedDeviation(), "NO Speed Deviation alarm definitions");
	}
	
	@Test(priority=7)
	public void verifyOverdueSpeedDeviation(){
		Assert.assertTrue(speedVariance_click.verifyOverdueSpeedDeviation(), "Overdue Speed Deviation alarm definitions");
	}
}
