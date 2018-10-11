package zones;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

//import Notification_resources.BasePage;

import scriptResources.*;

public class ManageZonesPage extends BasePage {
	private static int numberOfPolygonNodes;
	private static String dataResourcePath = "C://Users//sreedhar.popuri//workspace//selenium//PSP_Automation//PSP_Automation_Project//PSP_Automation_Project//PSP_Automation_Project//PSP_Automation_Project//src//test//resources//data//";
	private static String dataFileName = "Book1.xlsx";
	
	

	public static XSSFCell cell;

	public ManageZonesPage(WebDriver driver) {
		super(driver);

	}

	// 1. Create zone
	// 2. Edit zone
	// 3. Search zone
	// 4. View zone
	// 5. Hide zones
	// 6. Delete zones

	// By Objects for creating a zone

	// the Zones icon on right side of screen
	By zonesIcon = By.xpath("//div[4]/a");
	// zones sidebar
	By zonesSidebar = By.xpath(".//*[@id='map']/div[2]/div[1]/a");
	By createOrEditZonesButton = By.xpath("//div[@id='my-zones']/button");
	By createZoneButton = By.xpath("//div[2]/div/div/div/div[2]/button");
	By nameInputField = By.xpath("//input[@id='form__item__properties.name']");
	By descriptionInputField = By.xpath("//textarea");
	By selectShareLevel = By.name("properties.share_level");
	By selectShareLevelDefaultOption = By.xpath("//select[@id='form__item__properties_share_level']/option[1]");
	By selectShareLevelCreatorOnlyOption = By.xpath("//select[@id='form__item__properties_share_level']/option[2]");
	By selectShareLevelAllUsersInAccountOption = By.xpath("//select[@id='form__item__properties_share_level']/option[3]");
	By selectShareLevelAllusersPlusSubAccountsOption = By.xpath("//select[@id='form__item__properties_share_level']/option[4]");
	By zoneGeometryType = By.xpath("//*[@id='form__item__geometry_type']");
	By zoneGeometryOptionDefault = By.xpath("//*[@id='form__item__geometry_type']/option[1]");
	By zoneGeometryOptionCircularZone = By.xpath("//*[@id='form__item__geometry_type']/option[2]");
	By zoneGeometryOptionPolygonZone = By.xpath("//*[@id='form__item__geometry_type']/option[3]");
	By zoneGeometryOptionRectangularZone = By.xpath("//*[@id='form__item__geometry_type']/option[4]");
	By inputLatDegrees = By.xpath("//input[@name='form__item__lat-degrees']");
	By inputLatMinutes = By.xpath("//input[@name='form__item__lat-minutes']");
	By inputLatSeconds = By.xpath("//input[@name='form__item__lat-seconds']");
	By hemisphereLatSelectBox = By.xpath("(//select[@name='form__item__lat-hemisphere'])[1]");
	By hemisphereSelectOptionSouth = By.xpath("//option[@value='S']");
	By hemisphereSelectOptionNorth = By.xpath("//option[@value='N']");

	By inputLngDegrees = By.xpath("//input[@name='form__item__lng-degrees']");
	By inputLngMinutes = By.xpath("//input[@name='form__item__lng-minutes']");
	By inputLngSeconds = By.xpath("//input[@name='form__item__lng-seconds']");
	By hemisphereLngSelectBox = By.xpath("(//select[@name='form__item__lng-hemisphere'])[1]");
	By hemisphereSelectOptionWest = By.xpath("//option[@value='W']");
	By hemisphereSelectOptionEast = By.xpath("//option[@value='E']");

	By inputGeometryRadius = By.xpath(".//*[@id='form__item__geometry.radius']");

	By submitButton = By.cssSelector("#application > div.layout-main > div.layout-list > div.layout-application > div.application__content > div > div.ps__footer > div > div > div.pull-right > button.btn.btn-primary.submit");
	
	By zonesSidebarCloseButton = By.xpath("//a[contains(text(),'×')]");

	public Boolean isSidebarShowing() {

		if (getElements(zonesSidebar).size() > 0) {

			return true;

		} else {

			return false;
		}
	}

	/*
	 * private void enterCoordinatesForRectOrPolyZonesDEC(String zs, String
	 * sheetName) throws Exception { try {
	 * 
	 * DataFormatter formatter = new DataFormatter();
	 * 
	 * XSSFSheet excelWSheet = setDataFileExcel().getSheet(sheetName);
	 * numberOfPolygonNodes = excelWSheet.getPhysicalNumberOfRows();
	 * verbose(excelWSheet.getLastRowNum() + " is the last row on the sheet");
	 * verbose(Integer.toString(numberOfPolygonNodes));
	 * 
	 * int rowNum = numberOfPolygonNodes; // this is the number of nodes in //
	 * the polygon too. // this info is taken from the datafile
	 * verbose("row count..." + rowNum);
	 * 
	 * int colNum = 2; // 0-1 columns
	 * 
	 * getElement(By.xpath("//form/div/div[5]/div[2]/div[1]/button")).click();
	 * verbose("DEC button for Circular zone shape has been clicked");
	 * 
	 * verbose("Number of rows...." + numberOfPolygonNodes);
	 * 
	 * for (int i = 0; i < rowNum; i++) { for (int j = 0; j < colNum; j++) {
	 * 
	 * if (j < 1) { String fullXpath = null; String cellData =
	 * formatter.formatCellValue(excelWSheet.getRow(i).getCell(j)); if (j < 1) {
	 * 
	 * if (i == 0) {
	 * 
	 * fullXpath = "//form/div/div[5]/div[2]/div[2]/div/input"; } else {
	 * fullXpath = "//form/div/div[" + (i + 5) + "]/div/div[2]/div/input"; }
	 * getElement(By.xpath(fullXpath)).sendKeys(cellData); }
	 * 
	 * j++;
	 * 
	 * }
	 * 
	 * if (j > 0) { String cellData = null; cellData =
	 * formatter.formatCellValue(excelWSheet.getRow(i).getCell(j));
	 * 
	 * verbose("entering Lat coordinates for DEC Polygon shape on row number ... "
	 * + i + j);
	 * 
	 * String fullXpath = null; if (i == 0) {
	 * 
	 * fullXpath = "//form/div/div[5]/div[2]/div[3]/div/input";
	 * 
	 * } else {
	 * 
	 * fullXpath = "//form/div/div[" + (i + 5) + "]/div/div[3]/div/input";
	 * 
	 * }
	 * 
	 * getElement(By.xpath(fullXpath)).sendKeys(cellData);
	 * 
	 * j++; }
	 * 
	 * } }
	 * 
	 * setDataFileExcel().close(); } catch (Exception e) {
	 * 
	 * throw (e); }
	 * 
	 * }
	 * 
	 * public void enterCoordinatesForAllZoneShapesDEC(String zs, String opMode)
	 * throws Throwable {
	 * 
	 * String sheetName = null; if (zs.equals("Polygon")) { sheetName =
	 * "PolygonDEC"; // XSSFSheet excelWSheet =
	 * setDataFileExcel().getSheet(sheetName); // numberOfPolygonNodes =
	 * excelWSheet.getPhysicalNumberOfRows(); //
	 * verbose(excelWSheet.getLastRowNum() + " is the last row on the //
	 * sheet"); // verbose(Integer.toString(numberOfPolygonNodes)); for (int i =
	 * 1; i < numberOfPolygonNodes; i++) {
	 * verbose("Clicking on the plus button for number of polygon modes.... ");
	 * getElement(By.xpath("//form/div/div[5]/div[2]/div[4]/button[2]")).click()
	 * ;
	 * 
	 * } //enterCoordinatesForRectOrPolyZonesDEC(zs, sheetName, opMode);
	 * 
	 * } else if (zs.equals("Rectangular")) {
	 * 
	 * sheetName = "RectangleDEC"; //enterCoordinatesForRectOrPolyZonesDEC(zs,
	 * sheetName); } else {
	 * 
	 * sheetName = "CircularDEC";
	 * //enterCoordinatesForCircularZonesDEC(sheetName); } }
	 * 
	 * private void enterCoordinatesForCircularZonesDEC(String sheetName, String
	 * opMode) {
	 * 
	 * verbose("entering the circular zone dec for coordinates");
	 * 
	 * XSSFSheet excelWSheet = setDataFileExcel(opMode).getSheet(sheetName);
	 * DataFormatter formatter = new DataFormatter();
	 * 
	 * if (getElement(By.xpath("//div[2]/div/button")).getText() == "DEC") {
	 * getElement(By.xpath("//div[2]/div/button")).click();
	 * verbose("DEC button for Circular zone shape has been clicked"); } else {
	 * 
	 * String latSectionXpathTails[] = new String[] { "lat", "lng" };
	 * 
	 * for (String latXpathTails : latSectionXpathTails) {
	 * 
	 * String cellData = null;
	 * 
	 * if (latXpathTails == "lat") { cellData =
	 * formatter.formatCellValue(excelWSheet.getRow(0).getCell(0));
	 * waitForVisibility(getElement(By.xpath("//input[@name='form__item__lat']")
	 * )); verbose("waiting for element visibility");
	 * 
	 * getElement(By.xpath("//input[@name='form__item__lat']")).clear();
	 * getElement(By.xpath("//input[@name='form__item__lat']")).sendKeys(
	 * cellData); verbose("entered latitude value"); } else { cellData =
	 * formatter.formatCellValue(excelWSheet.getRow(0).getCell(1));
	 * getElement(By.xpath("//input[@name='form__item__lng']")).clear();
	 * getElement(By.xpath("//input[@name='form__item__lng']")).sendKeys(
	 * cellData); verbose("entered longitude value"); }
	 * 
	 * }
	 * 
	 * waitExplicitly(1);
	 * 
	 * String circleRadius =
	 * formatter.formatCellValue(excelWSheet.getRow(0).getCell(2));
	 * verbose(excelWSheet + "is the name of the excel sheet");
	 * waitExplicitly(1);
	 * getElement(inputGeometryRadius).sendKeys(circleRadius); }
	 * 
	 * }
	 */
	private void enterCoordinatesForCircularZonesDMS(String sheetName, String opMode) {

		XSSFSheet excelWSheet = setDataFileExcel(opMode, dataResourcePath, dataFileName).getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();

		String latSectionXpathTails[] = new String[] { "lat-degrees", "lat-minutes", "lat-seconds" };
		for (String latXpathTails : latSectionXpathTails) {

			String fullXpath = "//input[@name='form__item__" + latXpathTails + "']";
			String cellData = null;

			if (latXpathTails == "lat-degrees") {
				cellData = formatter.formatCellValue(excelWSheet.getRow(0).getCell(0));
				getElement(By.xpath(fullXpath)).clear();
				getElement(By.xpath(fullXpath)).sendKeys(cellData);
			} else if (latXpathTails == "lat-minutes") {
				cellData = formatter.formatCellValue(excelWSheet.getRow(0).getCell(1));
				getElement(By.xpath(fullXpath)).clear();
				getElement(By.xpath(fullXpath)).sendKeys(cellData);
			} else if (latXpathTails == "lat-seconds") {
				cellData = formatter.formatCellValue(excelWSheet.getRow(0).getCell(2));
				getElement(By.xpath(fullXpath)).clear();
				getElement(By.xpath(fullXpath)).sendKeys(cellData);

			}
		}
		waitExplicitly(1);
		getElement(hemisphereLatSelectBox).click();
		getElement(By.xpath("//option[@value='" + formatter.formatCellValue(excelWSheet.getRow(0).getCell(3)) + "']"))
				.click();

		waitExplicitly(1);
		String lngSectionXpathTails[] = new String[] { "lng-degrees", "lng-minutes", "lng-seconds" };
		for (String lngXpathTails : lngSectionXpathTails) {

			String fullXpath = "//input[@name='form__item__" + lngXpathTails + "']";
			String cellData = null;

			if (lngXpathTails == "lng-degrees") {
				cellData = formatter.formatCellValue(excelWSheet.getRow(0).getCell(4));
				getElement(By.xpath(fullXpath)).clear();
				getElement(By.xpath(fullXpath)).sendKeys(cellData);
			} else if (lngXpathTails == "lng-minutes") {
				cellData = formatter.formatCellValue(excelWSheet.getRow(0).getCell(5));
				getElement(By.xpath(fullXpath)).clear();
				getElement(By.xpath(fullXpath)).sendKeys(cellData);
			} else if (lngXpathTails == "lng-seconds") {
				cellData = formatter.formatCellValue(excelWSheet.getRow(0).getCell(6));
				getElement(By.xpath(fullXpath)).clear();
				getElement(By.xpath(fullXpath)).sendKeys(cellData);

			}
		}
		waitExplicitly(1);
		getElement(hemisphereLngSelectBox).click();
		getElement(By.xpath("//option[@value='" + formatter.formatCellValue(excelWSheet.getRow(0).getCell(7)) + "']"))
				.click();

		// String circleRadius =
		// formatter.formatCellValue(excelWSheet.getRow(0).getCell(8));
		// giving different radius each time, rather than same radius from the
		// excel sheet
		int foo = getRandomNumber(150000);
		String circleRadius = Integer.toString(foo);

		getElement(inputGeometryRadius).clear();
		getElement(inputGeometryRadius).sendKeys(circleRadius);

	}

	private Boolean checkIfZoneExists(String zoneShape) {

		waitExplicitly(2);
		int a = getElements(By.partialLinkText(zoneShape)).size();

		if (a > 0) {
			return true;
		} else {
			return false;
		}
	}
	private void drawPolygon(){
		
	}

	private void deleteZones(String zoneShape) {
		waitExplicitly(2);
		if (checkIfZoneExists(zoneShape) == true) {
			int a = getElements(By.partialLinkText(zoneShape)).size();
			for (int i = 1; i <= a; i++) {
				clickOnIt(By.partialLinkText(zoneShape));
				verbose("deleting zone with keyword '" + zoneShape + "' " + i + " of " + a + "...");
				waitExplicitly(1);
				getElement(By.xpath("//button[@name='delete']")).click();
				waitExplicitly(1);
				getElement(By.xpath("//div[3]/button[2]")).click();
			}
		} else {
			verbose("No Zones with the keyword " + zoneShape + " is found for me to delete...");
		}
		waitExplicitly(1);
	}

	private String selectShareLevel(String shareLevel) {

		waitExplicitly(1);
		getElement(selectShareLevel).click();
		verbose("Share level option clicked");

		String xpathHead = "//select[@id='form__item__properties_share_level']/option[";
		String xpathTummy = null;
		String xpathTail = "]";

		if (shareLevel == "Creator") {
			xpathTummy = "2";
		} else if (shareLevel == "Users") {
			xpathTummy = "3";
		} else {
			xpathTummy = "4";
		}

		String xpathSnake = xpathHead + xpathTummy + xpathTail;
		return xpathSnake;

	}

	private String selectZoneShape(String zoneShape) {

		waitExplicitly(1);
		getElement(zoneGeometryType).click();
		verbose (" Sselecting zoneGeometryType");
		verbose("Select shapes clicked");

		String xpathHead = "//*[@id='form__item__geometry_type']/option[";
		String xpathTummy = null;
		String xpathTail = "]";

		if (zoneShape == "Circular") {
			xpathTummy = "2";
		} else if (zoneShape == "Polygon") {
			xpathTummy = "3";
		} else {
			xpathTummy = "4";
		}

		String xpathSnake = xpathHead + xpathTummy + xpathTail;
		return xpathSnake;

	}

	// This Data feeder- not utilized
	@SuppressWarnings("resource")
	public static void setExcelFile() throws Exception {

		String Path = null;

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);

			verbose("Excel workbook assgined " + ExcelWBook);

		} catch (Exception e) {

			verbose("in the catch");
			throw (e);
		}

	}

	
	private XSSFWorkbook setDataFileExcel(String opMode, String dataResourcePath, String dataFileName) {
		String path = null;
		dataResourcePath = "C://Users//sreedhar.popuri//workspace//selenium//PSP_Automation//PSP_Automation_Project//PSP_Automation_Project//PSP_Automation_Project//PSP_Automation_Project//src//test//resources//data//";				
		dataFileName = "Book1.xlsx";
		

		if (opMode.equalsIgnoreCase("Edit")) {
			path = getProps().getProperty("dataResourcePath") + getProps().getProperty("editedDataFileName");
		} else {

			path = getProps().getProperty("dataResourcePath") + getProps().getProperty("dataFileName");
		}

		try {
			 

			FileInputStream excelFile = new FileInputStream(path);
			XSSFWorkbook excelWBook = new XSSFWorkbook(excelFile);
			// XSSFSheet excelWSheet = excelWBook.getSheet(sheetName);
			// numberOfPolygonNodes = excelWSheet.getPhysicalNumberOfRows();
			// verbose(excelWSheet.getLastRowNum() + " is the last row on the
			// sheet");
			// verbose(Integer.toString(numberOfPolygonNodes));

			return excelWBook;

		} catch (Exception e) {

			error("excel data file wasn't set....");
			e.printStackTrace();

			return null;
		}

	}

	// Data feeder- not utilized
	// public void getCellData(int rowNum, int ColNum) {
	// Cell = ExcelWSheet.getRow(rowNum).getCell(ColNum);
	// String CellData = Cell.getStringCellValue();
	// }

	public void enterCoordinatesForAllZoneShapesDMS(String zs, String opMode) throws Throwable {

		String sheetName = null;
		if (zs.equals("Polygon")) {
			sheetName = "Polygon";
		
			FileInputStream file = new FileInputStream(new File("C://Users//sreedhar.popuri//workspace//selenium//Jenkins//Automation_Jenkins//src//test//resources//data//"));
		  XSSFWorkbook excelWBook = new XSSFWorkbook(file);
		  XSSFSheet excelWSheet = excelWBook.getSheet(sheetName);
		  
		  numberOfPolygonNodes = excelWSheet.getPhysicalNumberOfRows();
		 
		  if (opMode.equalsIgnoreCase("Create")) {
				for (int i = 1; i < numberOfPolygonNodes; i++) {
					verbose("Creating the extra node .. " + i);

					(new Actions(getDriver())).click(getElement(By.xpath("//form/div/div[5]/div[2]/div[4]/button[2]")))
							.build().perform();
				}
			}
			enterCoordinatesForRectOrPolyZonesDMS(zs, sheetName, opMode);

		} else if (zs.equals("Rectangular")) {

			sheetName = "Rectangle";
			enterCoordinatesForRectOrPolyZonesDMS(zs, sheetName, opMode);
		} else {

			sheetName = "Circular";
			enterCoordinatesForCircularZonesDMS(sheetName, opMode);
		}
	}
		
	private void enterCoordinatesForRectOrPolyZonesDMS(String zs, String sheetName, String opMode) throws Exception {
		try {

			DataFormatter formatter = new DataFormatter();

			XSSFSheet excelWSheet = setDataFileExcel(opMode, dataResourcePath, dataFileName).getSheet(sheetName);
			numberOfPolygonNodes = excelWSheet.getPhysicalNumberOfRows();
			verbose(excelWSheet.getLastRowNum() + " is the last row on the excel data sheet");
			

			int rowNum = numberOfPolygonNodes; // this is the number of nodes in
												// the polygon too.
			// this info is taken from the datafile
			

			int colNum = 8; // 0-7 columns

			String xpathHead = "//form/div/div[5]/div[2]/div[";
			String xpathTail = "]/div[";
			String xpathTailTip = "]/input";

			for (int i = 0; i < rowNum; i++) {
				for (int j = 0; j < colNum; j++) {

					while (j < 3) {

						String cellData = null;

						cellData = formatter.formatCellValue(excelWSheet.getRow(i).getCell(j));
						String k = "2";
						String s = null;
						if (j == 0) {
							s = "Degrees";
						} else if (j == 1) {
							s = "Minutes";
						} else {
							s = "Seconds";
						}

						String fullXpath = null;
						if (i == 0) {

							fullXpath = xpathHead + k + xpathTail + (j + 1) + xpathTailTip;

						} else if (i > 8) {

							error("************************************************************");
							error("************************************************************");
							error("I think you have edited the datasheet for creating or editing the zones.\n Please refer the guide to use automation framework \n section for TID_15_B_x");
							error("************************************************************");
							error("************************************************************");
							error("Continuing the tests with work around");

							i = 3;
							xpathHead = "//form/div/div[";
							String xpathNewSection = "]/div/div[";
							fullXpath = xpathHead + (i + 5) + xpathNewSection + k + xpathTail + (j + 1) + xpathTailTip;

						} else {

							xpathHead = "//form/div/div[";
							String xpathNewSection = "]/div/div[";
							fullXpath = xpathHead + (i + 5) + xpathNewSection + k + xpathTail + (j + 1) + xpathTailTip;

						}
						getElement(By.xpath(fullXpath)).clear();
						getElement(By.xpath(fullXpath)).sendKeys(cellData);
						verbose("Entered " + cellData + " for " + s + " coordinates for the node number " + (i + 1)
								+ " latitude ..for " + zs + " shape.");
						j++;
					}

					if (j == 3) {
						// not implemented for hemisphere either directions
						waitExplicitly(1);
						int k = i + 5;
						By hemisLatSelectBox = By.xpath("//form/div/div[" + k + "]/div/div[2]/select");
						getElement(hemisLatSelectBox).click();
						waitExplicitly(1);
						getElement(By.xpath("//form/div/div[" + k + "]/div/div[2]/select/option[@value='"
								+ formatter.formatCellValue(excelWSheet.getRow(i).getCell(j)) + "']")).click();
						verbose("Entered Latitude hemisphere value '"
								+ formatter.formatCellValue(excelWSheet.getRow(i).getCell(j)) + "' for node " + (i + 1)
								+ " for " + zs + " shape.");
						j++;

					}

					while (j > 3 && j < 7) {
						String cellData = null;
						cellData = formatter.formatCellValue(excelWSheet.getRow(i).getCell(j));
						String k = "3";
						String s = null;

						if (j == 0) {

							s = "Degrees";

						} else if (j == 1) {

							s = "Minutes";

						} else {

							s = "Seconds";

						}

						verbose("Entered " + cellData + " for " + s + " coordinates for the node number " + (i + 1)
								+ " latitude ..for " + zs + " shape.");

						String fullXpath = null;
						if (i == 0) {

							fullXpath = xpathHead + k + xpathTail + (j - 3) + xpathTailTip;

						} else {

							xpathHead = "//form/div/div[";
							String xpathNewSection = "]/div/div[";
							fullXpath = xpathHead + (i + 5) + xpathNewSection + k + xpathTail + (j - 3) + xpathTailTip;

						}

						getElement(By.xpath(fullXpath)).clear();
						getElement(By.xpath(fullXpath)).sendKeys(cellData);

						j++;

					}

					if (j == 7) {
						By hemisLngSelectBox = null;
						By hemiLngOption = null;

						waitExplicitly(1);
						int k = i + 5;
						if (i == 0) {
							hemisLngSelectBox = By.cssSelector(
									"form > div > div:nth-child(5) > div.form-row.clearfix > div:nth-child(3) > select");
							hemiLngOption = By.cssSelector(
									"form > div > div:nth-child(5) > div.form-row.clearfix > div:nth-child(3) > select > option[value='"
											+ formatter.formatCellValue(excelWSheet.getRow(i).getCell(j)) + "']");
						} else {
							hemisLngSelectBox = By.cssSelector(
									"form > div > div:nth-child(" + k + ") > div > div:nth-child(3) > select");
							hemiLngOption = By.cssSelector("form > div > div:nth-child(" + k
									+ ") > div > div:nth-child(3) > select > option[value='"
									+ formatter.formatCellValue(excelWSheet.getRow(i).getCell(j)) + "']");
						}
						getElement(hemisLngSelectBox).click();
						waitExplicitly(1);
						// getElement(By.xpath("//form/div/div["+k+"]/div/div[2]/select/option[@value='"
						// +
						// formatter.formatCellValue(excelWSheet.getRow(i).getCell(j))
						// + "']")).click();

						getElement(hemiLngOption).click();
						verbose("Entered Longitude hemisphere value '"
								+ formatter.formatCellValue(excelWSheet.getRow(i).getCell(j)) + "' for node " + (i + 1)
								+ " for " + zs + " shape.");
						j++;

					}

				}

			}
			setDataFileExcel(opMode, dataResourcePath, dataFileName).close();
		} catch (Exception e) {

			throw (e);
		}

	}

	public void editZones(String zoneShape) throws Throwable {
		// getDriver().get(getProps().getProperty("platformURL"));
		waitExplicitly(2);
		getElement(zonesIcon).click();
		verbose("zones Icon was clicked");
		waitExplicitly(2);
		getElement(createOrEditZonesButton).click();
		verbose("create or edit zones was clicked");
		refreshThePage();

		String sharePermissionLevels[] = new String[] { "AllUsers", "Creator", "Users" };
		for (String shareLevel : sharePermissionLevels) {

			waitExplicitly(1);
			int count = getElements(By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/a")).size();
			int b = 0;
			String neededXpath = null;
			while (b < 1) {
				for (int i = 1; i <= count; i++) {
					String s = getElement(By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/a[" + i + "]/div/div"))
							.getText();
					if (s.contains(zoneShape)) {
						neededXpath = "//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/a[" + i + "]/div/div";
						i = count;
						b = 1;
					} else if (i == count) {
						error("There are no '"+zoneShape+ "' zones to edit. Run the createZones() test first. Aborting this test. ");
						b = 1;
					}

				}

			}

			getElement(By.xpath(neededXpath)).click();
			verbose(zoneShape + " was clicked for editing.");
			waitExplicitly(1);

			getElement(nameInputField).click();
			verbose("Zone name Input field was clicked");
			getElement(nameInputField).clear();
			verbose("Zone name Input field data was cleared");

			getElement(nameInputField).sendKeys(zoneShape + " " + shareLevel + " Test Zone Edited");

			waitExplicitly(1);
			// getElement(descriptionInputField).click();
			// verbose("description field clicked");
			//
			// getElement(descriptionInputField).clear();
			// getElement(descriptionInputField).sendKeys(
			String value = "Creating the '" + zoneShape + "' test zone.. Edited";
			sendKeysEffectively(descriptionInputField, value);
			waitExplicitly(1);
			getElement(By.xpath(selectShareLevel(shareLevel))).click();
			verbose(" Share level has been edited...");

			waitExplicitly(1);
			getElement(By.xpath(selectZoneShape(zoneShape))).click();
			verbose(zoneShape + " zone shape has been edited");

			enterCoordinatesForAllZoneShapesDMS(zoneShape, "Edit");
			waitExplicitly(1);

			getElement(submitButton).click();

			waitExplicitly(1);

			refreshThePage();
			verbose("checking if the zone was created successfully... " + checkIfZoneExists(zoneShape));
		}
	}

	private void createNewZone(String zoneShape, String shareLevel, String cType) throws Throwable {
		// getDriver().get(getProps().getProperty("platformURL"));
		deleteZones(zoneShape);
		waitExplicitly(1);
		getElement(createZoneButton).click();
		verbose("create Zones Button was clicked");
		waitExplicitly(1);
		getElement(nameInputField).click();
		verbose("Zone name Input field was clicked");
		waitExplicitly(1);
		getElement(nameInputField).sendKeys(zoneShape + " " + cType + " " + shareLevel + " Test Zone");

		waitExplicitly(1);
		// getElement(descriptionInputField).click();
		// verbose("description field clicked");
		//
		// getElement(descriptionInputField).clear();
		// getElement(descriptionInputField).sendKeys(
		String value = "Creating the '" + zoneShape + " " + cType + "' test zone..";
		sendKeysEffectively(descriptionInputField, value);
		waitExplicitly(1);

		getElement(By.xpath(selectShareLevel(shareLevel))).click();
		verbose(shareLevel + " share level was selected");

		waitExplicitly(1);
		getElement(By.xpath(selectZoneShape(zoneShape))).click();
		waitExplicitly(20);
		verbose(zoneShape + " zone shape was selected");
		By DMS_option = By.cssSelector("#application > div.layout-main > div.layout-list > div.layout-application > div.application__content > div > div.panel.panel-default > div > form > div > div.form-group.coordinate.coordinates > div.form-row.clearfix > div.form-switch.pull-left.clearfix > button");
		
		waitExplicitly(10);
		//getElement(DMS_option).click();
		enterCoordinatesForAllZoneShapesDMS(zoneShape, "Create");
		
		

		if (cType == "DMS") {
			enterCoordinatesForAllZoneShapesDMS(zoneShape, "Create");
			waitExplicitly(1);
			
		} else {
			// enterCoordinatesForAllZoneShapesDEC(zoneShape);
			waitExplicitly(10);
			
		}
		getElement(submitButton).click();
		
		waitExplicitly(1);

		refreshThePage();
		verbose("checking if the zone was created successfully... " + checkIfZoneExists(zoneShape));

	}

	private void createZones(String cType) throws Throwable {
		waitExplicitly(2);
		getElement(zonesIcon).click();
		verbose("zones Icon was clicked");
		waitExplicitly(2);
		getElement(createOrEditZonesButton).click();
		verbose("create or edit zones was clicked");
		refreshThePage();

		String zoneShapes[] = new String[] { "Polygon", "Rectangular", "Circular" };
		for (String zS : zoneShapes) {

			String sharePermissionLevels[] = new String[] { "Creator", "Users", "AllUsers" };
			for (String shareLevel : sharePermissionLevels) {

				createNewZone(zS, shareLevel, cType);
			}
		}

	}

	public void createZones(String zS, String cType) throws Throwable {
		waitExplicitly(2);
		getElement(zonesIcon).click();
		verbose("zones Icon was clicked");
		waitExplicitly(2);
		getElement(createOrEditZonesButton).click();
		verbose("create or edit zones was clicked");
		refreshThePage();

		String sharePermissionLevels[] = new String[] { "Creator", "Users", "AllUsers" };
		for (String shareLevel : sharePermissionLevels) {

			createNewZone(zS, shareLevel, cType);
		}

	}

	public void createZonesDMS() throws Throwable {
		createZones("DMS");
	}

	public void createZonesDEC() throws Throwable {

		createZones("DEC");
	}

}
