package speedvariance.manage;

import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import scriptResources.*;

/*import Notification_resources.BasePage;
import Notification_resources.LoginPage;*/
/*import adminSpeedVariance.AdminSpeedVarianceAlarmSettingsPage;
import Notification_resources.BaseTest;
import Script_Resources.*;
import adminSpeedVariance.AdminSpeedVarianceAlarmSettingsPage;
import adminSpeedVariance.AdminSpeedVarianceVesselSettingsPage;*/

public class AdminSpeedVarianceVesselSettings extends BaseTest{
	/*LoginPage loginPage = PageFactory.initElements(getDriver(), LoginPage.class);*/
	LoginPage loginPage = new LoginPage(getDriver());
	AdminSpeedVarianceAlarmSettingsPage speedVariance_click = new AdminSpeedVarianceAlarmSettingsPage(getDriver());
	AdminSpeedVarianceVesselSettingsPage vesselSetting_page = new AdminSpeedVarianceVesselSettingsPage(getDriver());

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
	public void ClickOnVesselSettingsMenu(){

		Assert.assertTrue(vesselSetting_page.verifyVesselSettingsbuttton(), "Clicking on VesselSettings menu");

	}

	@Test(priority=3)
	public void ClickOnSupervisionFilter(){

		Assert.assertTrue(vesselSetting_page.verifyAllSupervisionFilter(), "Clicking on Supervision Filter");

	}

	@Test(priority=4)
	public void verifySubAccountFilter(){

		Assert.assertTrue(vesselSetting_page.verifySubAccountFilter(), "Clicking on SubAccount Filter");

	}
	
	
	@Test(priority=5)
	public void verifyAllFleetsFilter(){

		Assert.assertTrue(vesselSetting_page.verifyAllFleetsFilter(), "Clicking on Fleet Filter");

	}
	
	
	@Test(priority=6)
	public void verifySearchBox(){			
		Assert.assertTrue(vesselSetting_page.verifySearchBox(), "Verifying the Search box");

	}
	
	@Test(priority=7)
	public void verifyTableSortDefaultbyLastEdited() throws ParseException{

		Assert.assertTrue(vesselSetting_page.verifyTableSortDefaultbyLastEdited(), "Verifying the default column sort is by Last Edited");

	}
	
	
	@Test(priority=8)
	public void verifyEditedBysorting(){

		Assert.assertTrue(vesselSetting_page.verifyEditedBysorting(), "Verifying the Edited By is working as expected");

	}
	
	@Test(priority=9)
	public void verifySubAccountSorting(){

		Assert.assertTrue(vesselSetting_page.verifySubAccountSorting(), "Verifying the SubAccount Column sorting");

	}
	
	@Test(priority=10)
	public void verifyFleetSort(){

		Assert.assertTrue(vesselSetting_page.verifyFleetSort(), "Verifying the Filter Column sorting");

	}
	@Test(priority=11)
	public void verifySortByShipName(){

		Assert.assertTrue(vesselSetting_page.verifySortByShipName(), "Verifying the Ship name Column sorting");

	}
	@Test(priority=12)
	public void verifysortbyIMO(){

		Assert.assertTrue(vesselSetting_page.verifysortbyIMO(), "Verifying the IMO Column sorting");

	}
	
	@Test(priority=13)
	public void verifyApplyandCancelButton_Supervision(){

		Assert.assertTrue(vesselSetting_page.verifyApplyandCancelButton_Supervision(), "Verifying the Apply and Cancel button Supervision");

	}
	/*
	@Test(priority=14)
	public void verifyColumnsortPlannedSpeed(){

		Assert.assertTrue(vesselSetting_page.verifyColumnsortPlannedSpeed(), "Verifying the verifyColumnsortPlannedSpeed");

	}*/
	

}
