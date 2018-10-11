/**
 * 
 */
package tracking;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import scriptResources.*;
import testEnviroments.Log;
//import Notification_resources.LoginPage;
/*import landingPage.LandingAndMapPage;
import landingPage.LandingAndMapPage2;*/
import tracking.*;
//import Notification_resources.BaseTest;
import pageObjectMethods.*;

/**
 * @author sreedhar.popuri
 *
 */


public class LandingPageTest extends BaseTest {
	LandingAndMapPage landingPage = new LandingAndMapPage(getDriver());
	LandingAndMapPage2 landingPage_layer = new LandingAndMapPage2(getDriver());
	LoginPage loginPage = new LoginPage(getDriver());
	
	
	@BeforeClass
	public void testSetup() throws Throwable {
		verbose("Starting the Landing page test....");
		setup("Chrome");
		loginPage.login();
		Thread.sleep(3000);
	}

	@AfterClass
	public void tearDownTest() throws Throwable {
		waitExplicitly(5);
		tearDown();
	}

	@AfterClass
	public void afterClass() throws Exception {
		printEndOfTestClassIdentifierLogs();

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
	@Test(priority=0)
	public void viewMapTest() throws Throwable {
		
		landingPage.clickOnMenuItemTracking();
		/*Assert.assertTrue(landingPage.isMapDisplayedCentre(), "Map is not centred properly!");*/
		
	}
		
		@Test(priority=1)
		public void MapzoomByDoubleClicking() throws Throwable {
			
			landingPage.zoomInTheMapByDoubleClicking();
			Log.info("Users are able to zooming the map by double clicking");
		}
		
		@Test(priority=2)
		public void Changing_View_type() throws Throwable {
			
			landingPage.changeViewType();
			landingPage.changeToNormalView();
			
		}
		
		@Test(priority=3)
		public void MenuItem_Validation() throws Throwable {
			
			landingPage.isMenuItemPresent();		
			
		}
		@Test(priority=4)
		
		
		public void Layertools_options() throws Throwable {
			waitExplicitly(1);
			verbose("Clicking on Layertools icon");
			LandingPage.Layertools_Icon(getDriver()).click();
			verbose("Layertools_Icon clicked");
		}
		//Layer tools header data validation
		@Test(priority=5)
		public Boolean Layertools_header() throws Throwable {
			waitExplicitly(1);
			
			String Heading = LandingPage.Layertools_Header(getDriver()).getText();
			
			verbose("Clicking on Layertools icon");
			if (Heading.equals("Layer Tools")) {
				verbose("Layer tools expanded");
				return true;
			}else {
				error("Layter tools not expanded");
				return false;
			}
		}
		
		//Validating the type of maps like Terrain, Streets ....
		
		@Test(priority=6)
		public Boolean Maptypes_validation() throws Throwable{
				
				int count = 0;
				waitExplicitly(3);
				
				String Terrain_exp = "Terrain";
				String Map1 = LandingPage.Layertools_options_Terrain(getDriver()).getText();
				if (Map1 == Terrain_exp){
					count++;			
				}
				String Streets_exp = "Streets";
				String Map2 = LandingPage.Layertools_options_Streets(getDriver()).getText();
				if (Map2 == Streets_exp){
					count++;			
				}
				waitExplicitly(3);
				String Satellite_exp = "Satellite";
				String Map3 = LandingPage.Layertools_options_Satellite(getDriver()).getText();
				if (Map3 == Satellite_exp){
					count++;			
				}
				waitExplicitly(3);
				String CMap_exp = "C-Map";
				String Map4 = LandingPage.Layertools_options_Cmap(getDriver()).getText();
				if (Map4 == CMap_exp){
					count++;			
				}
				waitExplicitly(3);
				verbose("The Layer tools Map options displayed :" + count);
				verbose("Terrain, Streets, Satellite and C-Map map types are exist");
			
				if (count==4){
					return true;
				} else {
					return false;
				}
			}

		//Checking the Overlays available chequebooks options
		
		@Test(priority=7)
		public Boolean Overlays_validation() throws Throwable{
			
			int i = 0;
			waitExplicitly(3);
			
			if (LandingPage.Layertools_Overlay_Lables_checckbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox is Lables: ");
				i++;	
			}else{
				return false;
			}
			
		waitExplicitly(3);
			
			if (LandingPage.Layertools_Overlay_Latitude_checkbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Latitude");
				i++;	
			}else{
				return false;
			}
		waitExplicitly(3);
			
			if (LandingPage.Layertools_Overlay_Bathymetry_checkbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Bathymetry");
				i++;	
			}else{
				return false;
			}
		waitExplicitly(3);
			
			if (LandingPage.Layertools_Overlay_Cyclones_checkbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Cyclones");
				i++;	
			}else{
				return false;
			}
			waitExplicitly(3);
			
			if (i==4){
				return true;
			} else {
				return false;
			}
		}
		public Boolean meteorological() throws Throwable{
			
			int i = 0;
			waitExplicitly(3);
			
			if (LandingPage.Layertools_MeteorologicalLayers_rangeslider(getDriver()).isDisplayed() == true) {

				verbose("MeteorologicalLayers_rangeslider is displayed ");
			}else{
				return false;
			}
			
		waitExplicitly(3);
			
			if (LandingPage.Layertools_MeteorologicalLayers_Seasurface_checckbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Seasurface");
				i++;	
			}else{
				return false;
			}
		waitExplicitly(3);
			
			if (LandingPage.Layertools_MeteorologicalLayers_Primary_checckbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Primary");
				i++;	
			}else{
				return false;
			}
		waitExplicitly(3);
			
			if (LandingPage.Layertools_MeteorologicalLayers_Primaryandperiod_checckbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Primaryandperiod");
				i++;	
			}else{
				return false;
			}
			
		waitExplicitly(3);
			
			if (LandingPage.Layertools_MeteorologicalLayers_Windwave_checckbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Windwave");
				i++;	
			}else{
				return false;
			}
			
		waitExplicitly(3);
			
			if (LandingPage.Layertools_MeteorologicalLayers_Swell_checckbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Swell");
				i++;	
			}else{
				return false;
			}
			
		waitExplicitly(3);
			
			if (LandingPage.Layertools_MeteorologicalLayers_Windspeed_checckbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Windspeed");
				i++;	
			}else{
				return false;
			}
			
		waitExplicitly(3);
			
			if (LandingPage.Layertools_MeteorologicalLayers_Winddirection_checckbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Winddirection");
				i++;	
			}else{
				return false;
			}
			
		waitExplicitly(3);
			
			if (LandingPage.Layertools_MeteorologicalLayers_Presssure_checckbox(getDriver()).isSelected() == true) {

				verbose("Checked on input checkbox Presssure");
				i++;	
			}else{
				return false;
			}
			waitExplicitly(3);
			
			if (i==8){
				return true;
			} else {
				LandingPage.close(getDriver()).click();
				return false;
			
			}
		}
		@Test(priority=4)
		public void Layertools_options_Validation() throws Throwable {
			
			LandingAndMapPage2.Layertools_options(getDriver());
		}
		@Test(priority=5)
		public void Layertools_header_Validation() throws Throwable {
			
			LandingAndMapPage2.Layertools_header(getDriver());
		}
		
		@Test(priority=6)
		public void Maptypes_validation_Validation() throws Throwable {
			
			LandingAndMapPage2.Maptypes_validation(getDriver());
		}
		/*@Test(priority=7)
		public void Overlays_validation() throws Throwable {
			
			LandingAndMapPage2.Overlays_validation(getDriver());
		}*/
			
			/*landingPage.clickOnToggleButtonForLayerTools();*/
			/*LandingAndMapPage2.Layertools_options(getDriver());
			LandingAndMapPage2.Layertools_header(getDriver());
			LandingAndMapPage2.Maptypes_validation(getDriver());*/
			
			/*landingPage.selectInfoLayersToShowMeteorologicalInfoInDisplayView();
			landingPage.checkIfInfoOverlayElementPresent(0);
			waitExplicitly(20);
			landingPage.checkIfOverlayDataforLat_LongIsPresent();	
			waitExplicitly(20);*/
		}
		

	

