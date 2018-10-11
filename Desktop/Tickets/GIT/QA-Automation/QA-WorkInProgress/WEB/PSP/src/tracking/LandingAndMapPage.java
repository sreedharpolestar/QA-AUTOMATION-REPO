/**
 * 
 */
package tracking;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//import Notification_resources.BasePage;
//import Notification_resources.LoginPage;

import scriptResources.*;

/**
 * @author sreedhar.popuri
 *
 */
public class LandingAndMapPage extends BasePage {

	public LandingAndMapPage(WebDriver driver) {
		super(driver);

	}

	LoginPage loginPage = new LoginPage(getDriver());

	By pspLogo = By
			.xpath(".//*[@id='application']/div[2]/div[2]/div[1]/div[2]");
	By accountDropDown = By
			.xpath(".//*[@id='header__content-nav']/div[1]/ul/ul/li[2]/a");

	// map tile locations
	By northSeaTile = By
			.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[1]");
	By russiaLine = By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[11]");
	By uSALine = By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[7]");
	By westAafricaLine = By
			.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[6]");
	By iceLandLine = By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[3]");
	// ***

	By menuItemTracking = By
			.xpath("//*[@id='application']/div[2]/div[2]/div[1]/div[1]/div/a[1]");
	By menuItemSSASManagement = By
			.xpath("//*[@id='application']/div[2]/div[2]/div[1]/div[1]/div/a[2]");
	By menuItemRiskInsight = By
			.xpath("//*[@id='application']/div[2]/div[2]/div[1]/div[1]/div/a[3]");
	By menuItemNotifications = By
			.xpath("//*[@id='application']/div[2]/div[2]/div[1]/div[1]/div/a[4]");
	By menuItemReports = By
			.xpath("//*[@id='application']/div[2]/div[2]/div[1]/div[1]/div/a[5]");
	By menuItemArchive = By
			.xpath("//*[@id='application']/div[2]/div[2]/div[1]/div[1]/div/a[6]");
	By firstAccountInTheTrackingList = By
			.xpath("//*[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div/div/a[2]");
	By inputSearchFieldInTrackingMenu = By
			.xpath("//div[@id='application']/div[2]/div[2]/div[2]/div/div/div[3]/form/div/input");
	By firstAccountIetmContainerInTheShipNotInFleetsSearchResultsUsingTrackingMenu = By
			.xpath("//div[2]/div[2]/div/div/div/div/a[2]");
	By firstShipIetmContainerInTheShipNotInFleetsSearchResultsUsingTrackingMenu = By
			.xpath("//div[2]/div[2]/div/div/div/div/a");

	By bottomLeftTile = By
			.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[29]"); // bottom-left
																		// tile
																		// for
																		// pan
																		// the
																		// map
																		// test

	By topRightTile = By
			.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[26]"); // top-right
																		// tile
																		// for
																		// panThemap
																		// test

	By measureButton2 = By.xpath(".//*[@id='map']/div[2]/div[4]/div[2]/a");
	By measureButton = By.xpath(".//*[@id='map']/div[2]/div[4]/div[2]/a");

	// for TID 14_A
	By myAccountToggleButton = By.xpath("//ul/ul/li[2]/a");
	By viewChanger = By.xpath("//li[3]/a");

	// for TID_14_B
	By toggleButtonForLayerTools = By
			.xpath(".//*[@id='map']/div[2]/div[4]/div[3]/a");
	By inputCheckboxLabels = By.xpath("(//input[@type='checkbox'])[401]");
	By inputCheckboxLatLongOverlay = By
			.xpath("(//input[@type='checkbox'])[402]");
	By inputCheckboxBathmetry = By.xpath("(//input[@type='checkbox'])[403]");
	By inputCheckboxCyclones = By.xpath("(//input[@type='checkbox'])[404]");
	By inputCheckboxSeaSurfaceTemperature = By
			.xpath("(//input[@type='checkbox'])[405]");
	By inputCheckboxPrimaryWave = By.xpath("(//input[@type='checkbox'])[406]");
	By inputCheckboxprimaryWavesMeanPeriod = By
			.xpath("(//input[@type='checkbox'])[407]");
	By inputCheckboxWindWave = By.xpath("(//input[@type='checkbox'])[408]");
	By inputCheckboxSwellWave = By.xpath("(//input[@type='checkbox'])[409]");
	By inputCheckboxWindSpeed = By.xpath("(//input[@type='checkbox'])[410]");
	By inputCheckboxWindDirection = By
			.xpath("(//input[@type='checkbox'])[411]");
	By inputCheckboxPressureReducedToMSL = By
			.xpath("(//input[@type='checkbox'])[412]");

	By ClosebuttonForLayerTools = By.xpath("(//a[contains(text(),'×')])[2]");

	public Boolean isLoggedIn() {
		waitExplicitly(1);

		if (getElement(pspLogo).isDisplayed() == true) {

			verbose("Logged on to the PS Platform successfully!");
			return true;

		} else {
			error("Account dropdown list box is not present. Assuming Login failed. ");

			return false;

		}
	}

	public Boolean isMapDisplayedCentre() {

		clickOnMenuItemTracking();
		
		waitExplicitly(5);
		
		Point point = getTheCoordinatesOfElement(northSeaTile);
		// Browsing from the UK office, the North sea tile is almost on the
		// centre position
		// Therefore using it. This could be any other element that could
		// validate the loading position of the map can also be used.

		verbose("X and Y coordinates of the" + point.toString() + " tile is "
				+ point.x + " and " + point.y);

		if (point.x == 962 && point.y == 329) { // x and y values 962 & 329 are
												// for Chrome browser at the
												// time of writing this code.
			// above verbose will tell the exact point info in the logs.
			// A pass scenario for a different browser, will have different
			// values you can replace with the 962 & 351

			verbose("Map is centred");
			return true;

		} else {
			error("Map is not centered");
			return false;

		}
	}

	// TID-02
	private String changePassword(String currentPassword, String newPassword) {

		waitExplicitly(1);
		getElement(By.cssSelector("span.glyphicon.glyphicon-user")).click();// xpath(".//*[@id='header__content-nav']/div[1]/ul/ul/li[2]/a")).click();
		// gave locator for the account drop down menu
		getElement(By.xpath("//a[contains(text(),'Reset password')]")).click();
		// gave locator for the reset password in the drop down menu
		waitExplicitly(1);
		getElement(By.cssSelector("input[name='old_password']")).clear(); // xpath("form/div[1]/input")).clear();
		getElement(By.cssSelector("input[name='old_password']")).sendKeys(
				currentPassword);
		getElement(By.cssSelector("input[name='new_password']")).sendKeys(
				newPassword);
		// gave locator for the new password input field
		getElement(By.cssSelector("input[name='repeat_new_password']"))
				.sendKeys(newPassword);
		// gave locator for the confirm password input field
		getElement(By.xpath("//button[@type='submit']")).click();
		// gave locator for Continue buton
		// waitExplicitly(2);

		String textSuccess = getElement(
				By.xpath("/html/body/div[4]/div/div/div/div[1]/h4")).getText();

		getElement(By.xpath("html/body/div[4]/div/div/div/div[3]/button"))
				.click();

		waitExplicitly(1);

		return textSuccess;
	}

	public boolean hasResetPassword() {
		String defaultTestPassword = getProps().getProperty("password");
		String newPassword = "Goldstar-2";
		String resetSuccessText = changePassword(defaultTestPassword,
				newPassword);

		if (resetSuccessText == "Success") {
			// re-login with the new credentials
			verbose("Change password popup menu title text: "
					+ resetSuccessText);
			getElement(By.xpath("//form/div[1]/input")).click();
			getElement(By.xpath("//form/div[1]/input")).clear();
			getElement(By.xpath("//form/div[1]/input")).sendKeys(newPassword);

			getElement(By.xpath("//form/div[2]/input")).click();
			getElement(By.xpath("//form/div[2]/input")).clear();
			getElement(By.xpath("//form/div[2]/input")).sendKeys(newPassword);

			getElement(By.xpath("form/button")).click();
			// ----
			waitExplicitly(1);

			if (isLoggedIn() == true) {
				verbose("Re-logged in with the changed password");
				verbose("Changing the password back the the default password for tests");
				changePassword(newPassword, defaultTestPassword);
				return true;
			} else {
				error("Login with changed password fails!!");

				return false;
			}
		} else {
			verbose("Reset success message was " + resetSuccessText);
			return false;
		}

	}

	// error("Password reset success message did not appear!!!");
	// return false;
	// }

	// end - tid-02
	// tid-03

	public boolean hasLoggedout() {

		getElement(By.xpath("accountDropDown")).click();
		getElement(
				By.xpath(".//*[@id='header__content-nav']/div[1]/ul/ul/li[2]/ul/li[4]/a"))
				.click();

		waitExplicitly(1);

		if (getElement(By.xpath("form/h3")).getText() == "Login") {
			verbose("Logout test passed");
			loginPage.login();
			verbose("Logged in again for further tests");
			return true;
		} else {
			error("logout failed");
			return false;
		}
	}

	public Boolean isPageZoomedInKeyBoardActioned(Boolean zoomIn) {
		getDriver().navigate().refresh();

		verbose("Zooming using the keyboard keys");

		actionZoomIn(zoomIn);
		Point point = getTheCoordinatesOfElement(northSeaTile);
		// new x coordinates of an element would be less than that of it's
		// original value for x coordinates
		if (point.x < 962) { // only checking with the northSeaTile for now.
			verbose("end of zooming using the keyboard keys");
			verbose("X and Y coordinates of the" + northSeaTile.toString()
					+ " tile is " + point.x + " and " + point.y);

			return true;
		} else {
			verbose("end of zooming using the keyboard keys");
			verbose("X and Y coordinates of the" + northSeaTile.toString()
					+ " tile is " + point.x + " and " + point.y);

			return false;
		}
	}

	public void zoomInTheMapByDoubleClicking() {
		// to zoom the map using different actions
		// to zoom by doubleclicking on map

		getDriver().navigate().refresh();
		verbose("Zooming in using the double clicking action");

		Point point = getTheCoordinatesOfElement(By
				.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[1]"));
		verbose("Before zoomin double click zoom in : " + point.x + " & "
				+ point.y);
		int count = 0;
		while (count < 3) {

			actionZoomIn(By
					.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[1]")); // for
																				// double
																				// clicking
			waitExplicitly(1);
			count++;
		}

		verbose("After 3 double click zoom in : " + point.x + " & " + point.y);
		verbose("end of zooming in by double clickinig ");

	}

	public void clickOnMenuItemTracking() {

		waitExplicitly(1);
		getElement(By.partialLinkText("Tracking")).click();

	}

	public void clickOnSpecificItemWithPartialText(String partialText) {
		// getting the partial name of the test account from the datasource
		// properties
		// file

		getElement(By.partialLinkText(getTestData().getProperty(partialText)))
				.click();

		verbose("Item with the keyword '"
				+ getTestData().getProperty(partialText) + "' has been clicked");

	}

	public void goToShipInfoSummary() {

	}

	// following is overloaded to test if the second tranceiver is listed
	// separately in the ship info
	public void goToShipInfoSummary(Boolean isMoreThanOneTransceiver) {
		if (isMoreThanOneTransceiver == true) {

			waitExplicitly(1);
			clickOnSpecificItemWithPartialText("testPSPAccountPartialText");

			waitExplicitly(1);
			clickOnSpecificItemWithPartialText("testPSPTestFleetPartialText");

			waitExplicitly(1);
			clickOnSpecificItemWithPartialText("testPSPTestShipPartialText");
		} else {
			goToShipInfoSummary();
		}

	}

	public void clickOnShipReportTabs(String partialText) {
		// String tabMenuName=null;

		String fullXpath = xpathBuilderForShipMenuTabItems(partialText);

		verbose("Clicking on tab name "
				+ getElement(By.xpath(fullXpath)).getText());

		getElement(By.xpath(fullXpath)).click();

	}

	public Boolean isTransceiverNumberPresent() {

		String fullXpath = "//div[contains(@class,'ship__transceiver')]//tr[4]/td";
		// appending the rest of the xpath for the transceiver number td

		getElement(By.xpath(fullXpath));

		if (getElement(By.xpath(fullXpath)).getText() != null) {

			verbose("Transceiver Number: "
					+ getElement(By.xpath(fullXpath)).getText().toString());
			return true;

		} else {

			return false;

		}
	}

	// Some ships have more than one transceivers
	// Third tab from the top is always a transceiver.
	// If there is a second or ++ tranceivers present,
	// they will be listed 4th, 5th ect tabs

	private Boolean isMoreThanOneTranceiverPresent() {
		clickOnShipReportTabs("JRC");
		String transOne = getDriver()
				.findElement(By.xpath(".//div[3]//tr[4]/th")).getText()
				.toString();
		verbose(transOne);
		clickOnShipReportTabs("AIS generic");
		String transTwo = getDriver()
				.findElement(By.xpath(".//div[4]//tr[4]/th")).getText()
				.toString();
		verbose(transTwo);

		if (transOne == transTwo) {
			return true;
		} else {
			return false;
		}
	}

	private String xpathBuilderForShipMenuTabItems(String partialText) {

		String frontPartXpath = "//div[contains(@class,'ship__";
		String endPartXpath = null;

		if (partialText != "range") {

			endPartXpath = "')]/div/h4";

		} else {

			endPartXpath = "')]//div/h4";
			partialText = "slider";
		}
		String fullXpath = frontPartXpath + partialText + endPartXpath;

		return fullXpath;
	}

	public Boolean isMMSINumberPresent() {

		waitExplicitly(1);

		WebElement MMSINumber = getDriver().findElement(
				By.xpath(".//div[2]/div/table/tbody/tr[1]/td"));

		verbose("Ship MMSI number is "
				+ getDriver()
						.findElement(
								By.xpath(".//div[2]/div/table/tbody/tr[@class='ship mmsi']/td"))
						.getText().toString());

		if (MMSINumber.getText() != null) {

			return true;

		} else {

			return false;
		}

	}

	// calling all the necessary methods in one method
	public Boolean isShipInfoPresent() {

		clickOnMenuItemTracking();

		int count = getElements(By.xpath("//div[2]/div[2]/div/div/div/div/a"))
				.size();
		Boolean bool = false;

		if (count > 2) {
			verbose("There are more than 2 results in the accounts list.");
			int count2 = 0;
			String usefulXpath = null;
			int shipCount = 0;

			while (count2 < 1) {

				for (int i = 2; i <= count + 1; i++) {

					String xpathShipCountCell = "//div[2]/div[2]/div/div/div/div/a["
							+ i + "]/div/div[4]/div[4]/h5";
					String xpathFleetCountCell = "//div[2]/div[2]/div/div/div/div/a["
							+ i + "]/div/div[4]/div[2]/h5";

					int valueOfShipCounter = Integer.parseInt(getElement(
							By.xpath(xpathShipCountCell)).getText());
					int valueOfFleetNumber = Integer.parseInt(getElement(
							By.xpath(xpathFleetCountCell)).getText());

					if (valueOfShipCounter > 0 && valueOfFleetNumber == 0) {
						usefulXpath = "//div[2]/div[2]/div/div/div/div/a[" + i
								+ "]/div/div[4]/div[4]/h5";
						shipCount = Integer.parseInt(getElement(
								By.xpath(usefulXpath)).getText());
						verbose("clicking on the account '"
								+ getElement(
										By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div/div/div/a["
												+ i + "]/div/div[1]/div/h4"))
										.getText() + "'.");
						getElement(By.xpath(usefulXpath)).click();
						verbose("Clicking on the first sub account named as '"
								+ getElement(
										By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div/div/div/a[2]/div/div[1]/div/h4"))
										.getText());
						getElement(
								By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div/div/div/a[2]/div"))
								.click();
						waitExplicitly(1);

						verbose("Clicking on the Ship name "
								+ getElement(
										By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div/div/div/a[1]/div/div[1]/div/h4"))
										.getText());
						getElement(
								By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div/div/div/a[1]"))
								.click();

						waitExplicitly(1);

						verbose("Clicking on the Ship information tab");
						getElement(By.partialLinkText("Ship")).click();
						waitExplicitly(1);

						String mMSINumber = getElement(
								By.xpath("//div[2]/div[2]/div/table/tbody/tr[1]/td"))
								.getText();
						if (!mMSINumber.isEmpty()) {

							verbose("MMSI number is present>>> " + mMSINumber);
							i = count + 1;
							count2 = 1;
							verbose("Clicking on the Ship information tab");
							getElement(By.partialLinkText("Ship")).click();
							bool = true;

						} else {

							error("Ship MMSI number is NOT rendered");
							i = count + 1;
							count2 = 1;
							verbose("Clicking on the Ship information tab");
							getElement(By.partialLinkText("Ship")).click();

						}

					}

				}

			}
		}

		return bool;
	}

	public Boolean isTransceiverDataPresent() {
		clickOnMenuItemTracking();
		int rowCount = 0;
		Boolean boo = false;
		String titleCheck = null;

		if (isShipInfoPresent() == true) {
			waitExplicitly(1);
			titleCheck = getElement(By.xpath("//div[4]/div/h4/div/div"))
					.getText();
			if (titleCheck.contains("Weather")) {
				verbose("There is only one transceiver fitted for this vesel.");
			} else {
				verbose("There are more than one transceivers fitted to this vesel.");
			}
			getElement(By.xpath(".//div[3]//h4/div/div")).click();
			verbose("Clicked on Tranceiver info tab");
			verbose("Transceiver details \n"
					+ getElement(By.xpath("//div[3]/div[2]/div/table"))
							.getText());
			rowCount = (getElements(
					By.xpath("//div[3]/div[2]/div/table/tbody/tr")).size() - 1); // actual
																					// number
																					// of
																					// data
																					// rows
																					// =
																					// rowCount-1;

			int passCount = 0;
			for (int i = 1; i < rowCount; i++) {
				if (getElement(
						By.xpath("//div[3]/div[2]/div/table/tbody/tr[" + i
								+ "]/td")).getText() != null) {
					passCount++;
				}

			}
			if (passCount == 9) {
				verbose("All the rows for tranceiver data contain data.");
				boo = true;
			} else {
				error("Some rows for tranceiver data are missing");
			}

		}
		clickOnMenuItemTracking();
		return boo;
	}

	// if there was a second transceiver present, it would be in the tab after
	// the generic transceiver.
	// Otherwise that tab will be Weather info

	// anyway this method was not called anywhere. codes embedded in
	// isTranscerverDataPresent()
	private Boolean isMoreThanOneTransceiverPresent() {
		clickOnMenuItemTracking();
		String titleCheck = null;
		if (isShipInfoPresent() == true) {

			titleCheck = getElement(By.xpath("//div[4]/div/h4/div/div"))
					.getText();
			if (titleCheck.contains("Weather")) {
				return false;
			}
		}

		return true;
	}

	// 07-09-2016- document section - Test ID-15 Method below

	public Boolean isSearchedShipNotInFleetsFoundUsingTrackingMenu(
			String shipName) {

		String searchShipKey = getTestData().getProperty(
				"searchShipsInFleetNameStartsWith");
		// verbose(searchShipKey+ " Read the ship name key word from property
		// file");
		verbose(searchShipKey + "Search ship key is found");
		clickOnMenuItemTracking();
		verbose("Tracking menu has been entered");
		getElement(inputSearchFieldInTrackingMenu).click();
		verbose(" Search field has been clicked");
		getElement(inputSearchFieldInTrackingMenu).clear();
		verbose(" Search field has been cleared");
		getElement(inputSearchFieldInTrackingMenu).sendKeys(shipName);
		verbose(shipName + " has been entered");
		waitExplicitly(3);
		getElement(
				firstAccountIetmContainerInTheShipNotInFleetsSearchResultsUsingTrackingMenu)
				.click();

		String shipSearchFirstItem = getElement(
				By.xpath("//div[@id='application']/div[2]/div[2]/div[2]/div[2]//h4"))
				.getText().toString();

		verbose("ship name is; " + shipName);
		verbose("sub string is: " + shipSearchFirstItem.substring(0, 3));
		if (shipName.substring(0, 3) == "440") {
			verbose("Test passes");
			return true;

		} else {
			return false;
		}

	}

	/*
	 * public Boolean isSearchedShipInFleetFoundUsingTrackingMenu(String
	 * shipName){}
	 */// TODO // blocked by a bug to raise

	// TID_09_B

	public Boolean panTheMap() {
		(new Actions(getDriver())).dragAndDrop(getElement(bottomLeftTile),
				getElement(topRightTile)).perform();
		Boolean boo1 = isMapDisplayedCentre();
		waitExplicitly(2);
		getDriver().navigate().refresh();
		waitExplicitly(2);
		(new Actions(getDriver())).dragAndDrop(getElement(topRightTile),
				getElement(bottomLeftTile)).perform();
		Boolean boo2 = isMapDisplayedCentre();

		if (boo1 == false && boo2 == false) {
			return true;
		} else {
			verbose("pan the map test failed");
			return false;

		}

	}

	public String measureDistanceBetweenTwoKnownPointsInTheMap() {

		By aPoint1 = By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[1]");
		By aPoint2 = By
				.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[11]");
		By aPoint3 = By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[7]");
		By aPoint4 = By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[6]");
		By aPoint5 = By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[3]");

		By globeViewButton = By.xpath("//a[contains(text(),'Zoom min')]");
		By measureButton = By.xpath(".//*[@id='map']/div[2]/div[4]/div[2]/a");

		By toolTipNM = By
				.xpath(".//*[@id='map']/div[1]/div[2]/div[3]/div/div[@class ='leaflet-measure-tooltip-total']");
		// click on the globe view button

		getElement(globeViewButton).click();

		// click on measure tool button

		getElement(measureButton).click();

		for (int i = 1; i < 3; i++) {

			(new Actions(getDriver()))
					.click(getElement(By
							.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img["
									+ i + "]"))).perform();
			verbose("Clicking on a point at the location.. "
					+ getElement(
							By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img["
									+ i + "]")).getLocation());

			waitExplicitly(1);
		}

		(new Actions(getDriver()))
				.click(getElement(By
						.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[6]")))
				.perform();
		verbose("Clicking on a point at the location.. "
				+ getElement(
						By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[6]"))
						.getLocation());
		waitExplicitly(1);

		(new Actions(getDriver()))
				.click(getElement(By
						.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[10]")))
				.perform();
		verbose("Clicking on a point at the location.. "
				+ getElement(
						By.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[10]"))
						.getLocation());
		waitExplicitly(1);
		// double click

		(new Actions(getDriver()))
				.doubleClick(
						getElement(By
								.xpath("//*[@id='map']/div[1]/div[1]/div/div[2]/img[10]")))
				.perform();
		verbose("double clicked on on the last point to check the distance");

		// read the tooltip text and validate the nm

		waitExplicitly(1);
		String foo = getElement(
				By.xpath(".//*[@id='map']/div[1]/div[2]/div[3]/div[4]/div[1]"))
				.getText().toString();

		verbose(" Reading the tooltip>> total distance in nm: " + foo);
		verbose("Reading the tooltip>> local distance in nm: "
				+ (getElement(By
						.xpath(".//*[@id='map']/div[1]/div[2]/div[3]/div[4]/div[2]"))
						.getText()));
		getElement(measureButton).click();

		return (foo);

	}

	// TID_14_A
	public void changeViewType() {

		waitExplicitly(2);
		getElement(myAccountToggleButton).click();

		waitExplicitly(1);
		getElement(viewChanger).click();
		verbose("changed view type");

	}

	// TID_14_A
	public void changeToNormalView() {
		// getDriver().get(getProps().getProperty("platformURL"));
		waitExplicitly(2);
		getElement(myAccountToggleButton).click();
		waitExplicitly(1);
		if (getElement(viewChanger).getText().contains("Normal view") == true) {

			clickOnIt(viewChanger);
		} else {

			getElement(myAccountToggleButton).click();
		}
		verbose("changed to normal view");

	}

	// TID_14_A
	public Boolean isMenuItemPresent() {
		waitExplicitly(2);
		verbose("checking if menu item is present");
		if (getElements((By.partialLinkText("Tracking"))).size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	// TID_14_B

	private void closeTheLayerTools() {

		getElement(ClosebuttonForLayerTools).click();
		waitExplicitly(1);
	}

	public void clickOnToggleButtonForLayerTools() {
		getElement(toggleButtonForLayerTools).click();
		waitExplicitly(1);
	}

	// TID_14_B
	public void selectInfoLayersToShowMeteorologicalInfoInDisplayView() {
		// selecting all the layers here

		/*clickOnToggleButtonForLayerTools();*/

		// 401 up to 412 are the input checkbox ids in their xpath.
		// Keep an eye on them if this test fails you may need to check if they
		// the IDs / names in the future

		for (int i = 401; i < 413; i++) {
			if (getElement(By.xpath("(//input[@type='checkbox'])[" + i + "]"))
					.isSelected() == false) {

				getElement(By.xpath("(//input[@type='checkbox'])[" + i + "]"))
						.click();

				verbose("Checked on input checkbox ID: " + i);

			} else {

				getElement(By.xpath("(//input[@type='checkbox'])[" + i + "]"))
						.click();
				waitExplicitly(1);
				verbose("is element present for " + i + " :"
						+ checkIfInfoOverlayElementPresent(i));

				getElement(By.xpath("(//input[@type='checkbox'])[" + i + "]"))
						.click();

			}
			waitExplicitly(1);
			verbose("is element present for " + i + " :"
					+ checkIfInfoOverlayElementPresent(i));
		}

	}

	// TID_14_B
	public Boolean checkIfInfoOverlayElementPresent(int i) {

		if (i == 401) {
			if (getElements(
					By.xpath("//div[@class='map__container leaflet-container leaflet-fade-anim marisk_labels ship_labels']"))
					.size() > 0) {
				Boolean boo = true;

				verbose("Is Labels  rendered: " + boo);
				return boo;
			} else {
				return false;
			}
		} else if (i == 402) {

			if (getElements(
					By.xpath("//*[@id='map']/div[2]/div[6]/div[@class='leaflet-control-mouseposition leaflet-control']"))
					.size() > 0) {
				Boolean boo = true;
				verbose("Is Lat-Long table overlay  rendered: " + boo);
				return boo;
			} else {
				return false;
			}

		} else if (i == 404) {

			if (getElements(By.xpath("//*[@id='map']/div[1]/div[2]/div[3]/div"))
					.size() > 0) {
				Boolean boo = true;
				verbose("is Cyclones overlay  rendered: " + boo);
				return boo;
			} else {
				return false;
			}
		} else if (i == 403) {
			if (getElements(
					By.xpath("//*[@id='map']/div[1]/div[1]/div[@style='z-index: 7;']"))
					.size() > 0) {
				Boolean boo = true;
				verbose("Is Bathmetry overlay present :" + boo);
				return boo;
			} else {
				return false;
			}

		} else if (i == 405) {
			waitExplicitly(1);
			if (getElements(
					By.xpath("//*[@id='map']/div[1]/div[1]/div[@style='z-index: 9;']"))
					.size() > 0) {
				Boolean boo = true;
				verbose("Is Sea surface temperature overlay present :" + boo);
				return boo;
			} else {
				return false;
			}
		} else if (i == 406) {
			if (getElements(
					By.xpath("//*[@id='map']/div[1]/div[1]/div[@style='z-index: 10;']"))
					.size() > 0) {
				Boolean boo = true;
				verbose("Is Primary wave overlay present :" + boo);
				return boo;
			} else {
				return false;
			}
		} else if (i == 407) {
			if (getElements(
					By.xpath("//*[@id='map']/div[1]/div[1]/div[@style='z-index: 11;']"))
					.size() > 0) {
				Boolean boo = true;
				verbose("Is Primary waves mean period overlay present :" + boo);
				return boo;
			} else {
				return false;
			}
		} else if (i == 408) {
			if (getElements(
					By.xpath("//*[@id='map']/div[1]/div[1]/div[@style='z-index: 12;']"))
					.size() > 0) {
				Boolean boo = true;
				verbose("Is Wind wave overlay present :" + boo);
				return boo;
			} else {
				return false;
			}
		} else if (i == 409) {
			if (getElements(
					By.xpath("//*[@id='map']/div[1]/div[1]/div[@style='z-index: 13;']"))
					.size() > 0) {
				Boolean boo = true;
				verbose("Is Swell wave overlay present :" + boo);
				return boo;
			} else {
				return false;
			}
		} else if (i == 410) {
			if (getElements(
					By.xpath("//*[@id='map']/div[1]/div[1]/div[@style='z-index: 14;']"))
					.size() > 0) {
				Boolean boo = true;
				verbose("Is Wind speed overlay present :" + boo);
				return boo;
			} else {
				return false;
			}
		} else if (i == 411) {
			if (getElements(
					By.xpath("//*[@id='map']/div[1]/div[1]/div[@style='z-index: 15;']"))
					.size() > 0) {
				Boolean boo = true;
				verbose("Is Wind direction overlay present :" + boo);
				return boo;
			} else {
				return false;
			}
		} else if (i == 412) {
			if (getElements(
					By.xpath("//*[@id='map']/div[1]/div[1]/div[@style='z-index: 16;']"))
					.size() > 0) {
				Boolean boo = true;
				verbose("Is Wind pressure reduced to MSL overlay present :"
						+ boo);
				return boo;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// TID_14_B
	public Boolean checkIfOverlayDataforLat_LongIsPresent() {

		final Map<String, String> classnameMap = new HashMap<String, String>();
		classnameMap
				.put("Labels",
						"map__container leaflet-container leaflet-fade-anim marisk_labels ship_labels");
		classnameMap.put("Lat_Long",
				"leaflet-control-mouseposition leaflet-control");

		classnameMap
				.put("Cyclones",
						"leaflet-marker-icon icon-cyclone actual northern leaflet-zoom-animated leaflet-clickable");

		if (getElements(
				By.xpath("//div[@class='map__container leaflet-container leaflet-fade-anim marisk_labels ship_labels']"))
				.size() > 0) {

			// xpath here has a unique class name that will be visible only
			// after the check box for 'Labels' is checked.

			return true;
		} else {
			return false;
		}

	}

}
