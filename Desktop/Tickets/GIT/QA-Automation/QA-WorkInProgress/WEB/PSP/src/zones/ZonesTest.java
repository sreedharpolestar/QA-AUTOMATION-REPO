package zones;

import notifications.NotificationsSSASAlertPage;
import notifications.NotificationsSSASTestAlertPage;
import notifications.NotificationsWarningPage;
import notifications.NotificationsZonesPage;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import Notification_resources.LoginPage;




import scriptResources.*;
//import Notification_resources.BaseTest;
import testEnviroments.enviroments;
//import Notification_resources.LoginPage;
//import Notification_resources.BaseTest;
//import Notification_resources.BasePage;
//import Notification_resources.LoggingFactory;
import zones.ManageZonesPage;

public class ZonesTest extends BaseTest {
	ManageZonesPage manageZonesPage = new ManageZonesPage(getDriver());
	LoginPage loginPage=new LoginPage(getDriver());
	
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
	@BeforeClass
	//@Parameters("browser")
	public void beforeClass() throws Exception {
		
		setup("Chrome");
		loginPage.login();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDownTest() throws Throwable {
		waitExplicitly(5);
		tearDown();
	}
	@AfterMethod
	public void afterClass() throws Exception {
		printEndOfTestClassIdentifierLogs();
		
	}
	
	/*@AfterSuite
    public void validation ()
    {
		System.out.println("Test cases are passed");
    }*/
	
	
	@Test(priority=1)
	public void createAndDeleteAllTypeOfZones_TID_15_A() throws Throwable{
		manageZonesPage.createZonesDMS();
	}
	
	@Test(priority=2)
	public void createAndDeleteCircularZones_TID_15_B_1() throws Throwable{
		manageZonesPage.createZones("Circular", "DMS");
	}
	@Test(priority=3)
	public void createAndDeletePolygonZones_TID_15_B_2() throws Throwable{
		manageZonesPage.createZones("Polygon", "DMS");
	}
	@Test(priority=4)
	public void createAndDeleteRectangularZones_TID_15_B_3() throws Throwable{
		manageZonesPage.createZones("Rectangular", "DMS");
	}
	
	@Test(priority=5)
	public void editRectangularZones_TID_15_C_1() throws Throwable{
		manageZonesPage.editZones("Rectangular");
	}
	@Test(priority=6)
	public void editRectangularZones_TID_15_C_2() throws Throwable{
		manageZonesPage.editZones("Circular");
	}
	@Test(priority=7)
	public void editRectangularZones_TID_15_C_3() throws Throwable{
		manageZonesPage.editZones("Polygon");
	}
	
}
