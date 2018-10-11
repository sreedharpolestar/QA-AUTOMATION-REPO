/**
 * 
 */
package tracking;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

//import Notification_resources.BasePage;
import pageObjectMethods.*;
import scriptResources.*;

/**
 * @author sreedhar.popuri
 *
 */
public class LandingAndMapPage2 extends BasePage {
	
	Logger log = Logger.getLogger("Logger");

	public LandingAndMapPage2(WebDriver driver) {
		super(driver);

	}

	By toggleButtonForLayerTools = By.xpath(".//*[@id='map']/div[2]/div[4]/div[3]/a");
	By measureButton = By.xpath(".//*[@id='map']/div[2]/div[4]/div[2]/a");
	By northSeaTile = By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[1]");

	By closeButtonForLayerTools = By.xpath(".//*[@id='map']/div[2]/div[2]/a");

	By shipLabelOverlay = By.xpath(".//*[@id='map']/div[1]/div[2]/div[3]/div[2]");
	By bathmetryDataOverlay = By.xpath("//*[@id='map']/div[1]/div[1]/div[2]/div[2]/img[1]");
	By cycloneOverlays = By.xpath(".//*[@id='map']/div[1]/div[2]/div[3]/div");

	By firstItemInTheSearchList = By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div/div/div/a[1]");

	By labelsOverlaysCheckbox = By.xpath(".//*[@id='overlay-layers']/div/div[1]/label/input");
	By latlngOverlayCheckbox = By.xpath(".//*[@id='overlay-layers']/div/div[2]/label/input");
	By bathmetryCheckbox = By.xpath(".//*[@id='overlay-layers']/div/div[3]/label/input");
	By cycloneCheckbox = By.xpath(".//*[@id='overlay-layers']/div/div[4]/label/input");

	// Meteological layers

	By panelBodyForMeteologicalLayers = By.xpath(".//*[@id='meteorological-layers']/div");
	By downArrowForMeteologicalPanel = By.xpath(".//*[@id='meteorological-layers-section']/div[1]/div");
By globeViewButton = By.xpath("//a[contains(text(),'Zoom min')]");
	By firstDataOverlay = By.xpath("//*[@id='map']/div[1]/div[1]/div[2]/div[2]/img[1]");
	// firstDataOverlay will be visible when any checkbox is checked first,
	// second data overlay will be added if a second checkbox is checked with
	// the first one checked too
	// this test is testing the overlays one by one
	// Therefore the first dataoverlay is used for all data layers to validate
	// if there are more than one checkbox is checked, the xpath for the second
	// layer will be as follows
	/*
	 * xpath for second data overlay-
	 * //*[@id='map']/div[1]/div[1]/div[3]/div[2]/img[1] xpath for third data
	 * overlay - //*[@id='map']/div[1]/div[1]/div[4]/div[2]/img[1] and so on
	 */
	By primaryWaveOverlays = By.xpath("//*[@id='map']/div[1]/div[1]/div[2]/div[2]/img[1]");
	By seaSurfaceTempCheckbox = By.xpath("(//input[@type='checkbox'])[407]");
	By primaryWaveCheckbox = By.xpath("(//input[@type='checkbox'])[408]");
	By primaryWavesMeanPeriod = By.xpath("(//input[@type='checkbox'])[409]");
	By windWave = By.xpath("(//input[@type='checkbox'])[410]");
	By swellWave = By.xpath("(//input[@type='checkbox'])[411]");
	By windSpeed = By.xpath("(//input[@type='checkbox'])[412]");
	By windDirection = By.xpath("(//input[@type='checkbox'])[413]");
	By pressureReducedToMSL = By.xpath("(//input[@type='checkbox'])[414]");
	
	
	//Clicking on the Layyer tools icon
	@Test
	public static void Layertools_options(WebDriver driver) throws Throwable {
		verbose("Clicking on Layertools icon");
		LandingPage.Layertools_Icon(driver).click();
		verbose("Layertools_Icon clicked");
	}
	
	
	//Layer tools header data validation
	@Test
	public static Boolean Layertools_header(WebDriver driver) throws Throwable {
		
		String Heading = LandingPage.Layertools_Header(driver).getText();
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
	@Test
public static Boolean Maptypes_validation(WebDriver driver) throws Throwable{
		
		int count = 0;
		
		String Terrain_exp = "Terrain";
		String Map1 = LandingPage.Layertools_options_Terrain(driver).getText();
		if (Map1 == Terrain_exp){
			count++;			
		}
		String Streets_exp = "Streets";
		String Map2 = LandingPage.Layertools_options_Streets(driver).getText();
		if (Map2 == Streets_exp){
			count++;			
		}

		String Satellite_exp = "Satellite";
		String Map3 = LandingPage.Layertools_options_Satellite(driver).getText();
		if (Map3 == Satellite_exp){
			count++;			
		}

		String CMap_exp = "C-Map";
		String Map4 = LandingPage.Layertools_options_Cmap(driver).getText();
		if (Map4 == CMap_exp){
			count++;			
		}

		verbose("The Layer tools Map options displayed :" + count);
		verbose("Terrain, Streets, Satellite and C-Map map types are exist");
	
		if (count==4){
			return true;
		} else {
			return false;
		}
	}

//Checking the Overlays available chequebooks options
	@Test
public static Boolean Overlays_validation(WebDriver driver) throws Throwable{
	
	int i = 0;
	
	
	if (LandingPage.Layertools_Overlay_Lables_checckbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox is Lables: ");
		i++;	
	}else{
		return false;
	}
	

	
	if (LandingPage.Layertools_Overlay_Latitude_checkbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Latitude");
		i++;	
	}else{
		return false;
	}

	
	if (LandingPage.Layertools_Overlay_Bathymetry_checkbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Bathymetry");
		i++;	
	}else{
		return false;
	}

	
	if (LandingPage.Layertools_Overlay_Cyclones_checkbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Cyclones");
		i++;	
	}else{
		return false;
	}
	
	
	if (i==4){
		return true;
	} else {
		return false;
	}
}
	
@Test
public static Boolean meteorological(WebDriver driver) throws Throwable{
	
	int i = 0;

	
	if (LandingPage.Layertools_MeteorologicalLayers_rangeslider(driver).isDisplayed() == true) {

		verbose("MeteorologicalLayers_rangeslider is displayed ");
	}else{
		return false;
	}
	

	
	if (LandingPage.Layertools_MeteorologicalLayers_Seasurface_checckbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Seasurface");
		i++;	
	}else{
		return false;
	}

	
	if (LandingPage.Layertools_MeteorologicalLayers_Primary_checckbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Primary");
		i++;	
	}else{
		return false;
	}

	
	if (LandingPage.Layertools_MeteorologicalLayers_Primaryandperiod_checckbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Primaryandperiod");
		i++;	
	}else{
		return false;
	}
	

	
	if (LandingPage.Layertools_MeteorologicalLayers_Windwave_checckbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Windwave");
		i++;	
	}else{
		return false;
	}
	

	
	if (LandingPage.Layertools_MeteorologicalLayers_Swell_checckbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Swell");
		i++;	
	}else{
		return false;
	}
	

	
	if (LandingPage.Layertools_MeteorologicalLayers_Windspeed_checckbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Windspeed");
		i++;	
	}else{
		return false;
	}
	

	
	if (LandingPage.Layertools_MeteorologicalLayers_Winddirection_checckbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Winddirection");
		i++;	
	}else{
		return false;
	}
	

	
	if (LandingPage.Layertools_MeteorologicalLayers_Presssure_checckbox(driver).isSelected() == true) {

		verbose("Checked on input checkbox Presssure");
		i++;	
	}else{
		return false;
	}

	
	if (i==8){
		return true;
	} else {
		LandingPage.close(driver).click();
		return false;
	
	}
}

	public void clickOnToggleButtonForLayerTools() {
		getElement(globeViewButton).click();
		getElement(toggleButtonForLayerTools).click();
		waitExplicitly(1);
	}

	private void select(By locator) {
		clickOnToggleButtonForLayerTools();

		if (getElement(locator).isSelected() != true) {
			getElement(locator).click();
		}

	}

	private void unselect(By locator) {
		refreshThePage();
		waitExplicitly(1);
		clickOnToggleButtonForLayerTools();

		if (getElement(locator).isSelected() == true) {

			getElement(locator).click();

		}
		getElement(closeButtonForLayerTools).click();

	}

	private void makeMeteologicalPanelPresent() {
		clickOnToggleButtonForLayerTools();

		if (getElements(panelBodyForMeteologicalLayers).size() == 0) {
			verbose("Meteological checkbox panel is hidden. Clicking on the down arrow to open it.");
			getElement(downArrowForMeteologicalPanel).click();
		} else {
			verbose("Meteological checkbox panel is visible. Not necessary to click on the down arrow.");
		}
	}

	public Boolean checkMeteologicalLayerData(String s) {
		int i=0;
		if(s.equalsIgnoreCase("Sea Surface")){
			i=407;
		}if(s.equalsIgnoreCase("Primary Wave1")){
			i=408;
		}
		if(s.equalsIgnoreCase("Primary waves mean period")){
			i=409;
		}
		if(s.equalsIgnoreCase("Wind wave")){
			i=410;
		}
		if(s.equalsIgnoreCase("Swell wave")){
			i=411;
		}
		if(s.equalsIgnoreCase("Wind speed")){
			i=412;
		}
		if(s.equalsIgnoreCase("Wind direction")){
			i=413;
		}
		if(s.equalsIgnoreCase("Pressure reduced to msl")){
			i=414;
		}
		return checkMeteologicalOverlays(s, i);

	}

	private Boolean checkMeteologicalOverlays(String s, int i) {

		// int i is passed in to build the xpath for the checkboxes in the
		// Meteological panel.
		// if at all, you want to change the way of locating them checkboxes,
		// then, the int i in the method signature should be replaced with
		// string s, or by locator etc
		// it is currently very stable runing this way. chnge only if the
		// indexes for the checkboxes changed as the PSP grows on

		waitExplicitly(1);
		Boolean boo = false;
		By checkbox = By.xpath("(//input[@type='checkbox'])[" + i+"]");

		makeMeteologicalPanelPresent();

		if (getElements(firstDataOverlay).size() == 1) {
			verbose(s + " overlays are present already!");
			verbose("Rechecking by unselecting and selecting the " + s + "Sea Surface temperature checkbox.");
			unselect(checkbox);
		} else {
			verbose(s + " overlays are NOT presented now. Continuing with the test..");
		}
		clickOnToggleButtonForLayerTools();
		select(checkbox);

		if (getElements(firstDataOverlay).size() > 0) {
			boo = true;
			verbose(s + " overlays are present now!");
		} else {
			error(s + " overlays are not rendered in the map!!");
		}

		unselect(checkbox);
		return boo;
	}

	public Boolean checkCycloneOverlays() {
		waitExplicitly(1);
		Boolean boo = false;

		if (getElements(bathmetryDataOverlay).size() == 1) {
			verbose("Cyclone overlays are present already!");
			verbose("Rechecking by unselecting and selecting the cyclones checkbox.");
			unselect(cycloneCheckbox);
		} else {
			verbose("Cyclone overlays are NOT presented now. Continuing with the test..");
		}

		select(cycloneCheckbox);

		if (getElements(cycloneOverlays).size() > 0) {
			boo = true;
			verbose("Cyclone overlays are present now!");
		} else {
			error("Cyclone overlays are not visible OR there are no cyclones in the world at present");
		}
		unselect(cycloneCheckbox);
		return boo;
	}

	public Boolean checkBathMetryOverlays() {
		waitExplicitly(1);
		Boolean boo = false;

		if (getElements(bathmetryDataOverlay).size() == 1) {
			verbose("Bathmetry overlays are present already!");
			verbose("Rechecking by unselecting and selecting the bathmetry checkbox.");
			unselect(bathmetryCheckbox);
		} else {
			verbose("Bathmetry overlays are NOT presented now. Continuing with the test..");
		}

		select(bathmetryCheckbox);
		if (getElements(bathmetryDataOverlay).size() == 1) {
			boo = true;
			verbose("Bathmetry overlays are present now!");
		}
		unselect(bathmetryCheckbox);
		return boo;

	}

	public Boolean checkLatLngOverlays() {
		waitExplicitly(1);
		Boolean boo0 = false;
		Boolean boo1 = false;
		Boolean boo2 = false;

		select(latlngOverlayCheckbox);

		refreshThePage();
		waitExplicitly(1);

		// just clicking somewhere on the map so the Lat-Lng overlay should
		// appear

		clickOnIt(measureButton);

		hoverOver(northSeaTile);

		clickOnIt(measureButton);
		waitExplicitly(1);

		boo1 = isDataRendered(By.xpath("//div[@id='map']/div[2]/div[6]/div[2]/table/tbody/tr/td[1]"));
		boo2 = isDataRendered(By.xpath("//div[@id='map']/div[2]/div[6]/div[2]/table/tbody/tr/td[2]"));

		verbose("Latitude overlay data rendered? " + boo1 + "\n Longitude overlay data rendered? " + boo2);

		if (boo1 == true && boo2 == true) {
			boo0 = true;
		}

		unselect(latlngOverlayCheckbox);

		return boo0;
	}

	public Boolean checkLabelsOverlays() {
		waitExplicitly(1);
		Boolean boo0 = false;
		getElement(By.linkText("Tracking")).click();

		int count = getElements(By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div/div/div/a")).size();

		String usefulXpath = null;
		for (int i = 2; i < count; i++) {
			String shipCount = getElement(
					By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div/div/div/a[" + i + "]/div/div[4]/div[4]/h5"))
							.getText();
			int k = Integer.parseInt(shipCount);
			if (k > 0) {
				usefulXpath = "//div[2]/div[2]/div[2]/div[2]/div/div/div/div/a[" + i + "]/div/div[4]/div[4]/h5";
				i = count;
			}
		}
		getElement(By.xpath(usefulXpath)).click();

		getElement(firstItemInTheSearchList).click();
		waitExplicitly(1);

		select(labelsOverlaysCheckbox);

		Boolean boo2 = isDataRendered(shipLabelOverlay);
		verbose("Labels Displayed on the map? " + boo2);

		unselect(labelsOverlaysCheckbox);

		if (boo2 == true) {
			boo0 = true;
		}
		return boo0;

	}
}


