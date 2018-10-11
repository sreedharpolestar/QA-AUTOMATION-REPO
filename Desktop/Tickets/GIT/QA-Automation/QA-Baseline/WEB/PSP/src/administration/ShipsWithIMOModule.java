package administration;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjectMethods.ShipsIMOnumber;
import pageObjectMethods.ShipswithoutIMOnumber;
import scriptResources.BrowserType;
import testDatas.ShipsTestDatawithoutIMOnumber;
import testDatas.ShipswithIMOnumberTestData;
import testEnviroments.enviroments;

public class ShipsWithIMOModule {
	
	/*@BeforeClass
	public void log4j()
	{
		
		String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\PoleStar_Sanitypack\\PpoleStar_Regression\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
        System.out.println("initialized log4j configuration");	
	}
*/

	@Test
	public static void CreateShipswithIMOnumber(WebDriver driver) throws Throwable {

		/*WebDriver driver = BrowserType.getBrowser("Chrome");*/
		Logger log = Logger.getLogger("Logger");
		
		/*driver.get(enviroments.url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		log.info("Web application launched");
		
		// Login to the Application
		IntegrationTest.login(driver);
		Thread.sleep(3000);*/
		
		// Click Ships text link
		ShipsIMOnumber.ships_menu(driver).click();
		Thread.sleep(15000);
		log.info("Ships menu link clicked");
		
		String shipHeaderTitle = ShipsIMOnumber.ships_header_title(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.ships_text_header, shipHeaderTitle);
		log.info("Ships Header Title:  " + shipHeaderTitle);
				
		//Create a ship with IMO number
		ShipsIMOnumber.new_register_ship(driver).click();
		log.info("New Register ship button clicked");
		Thread.sleep(15000);
		
		String registershipHeaderTitle = ShipsIMOnumber.register_ship_header(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.register_ship_header, registershipHeaderTitle);
		Thread.sleep(3000);
		log.info("Register ship Header Title:  " + registershipHeaderTitle);
		
		// Click with IMo number
		ShipsIMOnumber.with_IMO_number(driver).click();
		log.info("With imo number link clicked");
		
		Thread.sleep(15000);
		
		// Search for ship
		String enter_search_for_ship_link = ShipswithIMOnumberTestData.enter_search_for_ship_link;
		ShipsIMOnumber.enter_search_for_ship_link(driver).sendKeys(enter_search_for_ship_link);
		log.info(enter_search_for_ship_link + ": is Entered Ship name");
		Thread.sleep(20000);
		
		ShipsIMOnumber.select_ship_IMO_number(driver).click();
		log.info("Waiting for Ship details");
		Thread.sleep(20000);
		
		String  shipNameTitle = ShipsIMOnumber.verify_ship_name(driver).getText();
		/*Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_name, shipNameTitle);*/
		log.info("Ship Name is displayed: " + shipNameTitle);
		
		String  shipImonumber = ShipsIMOnumber.verify_ship_IMO_number(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_imo, shipImonumber);
		log.info("Ship Imo Number is displayed: " + shipImonumber);
		Thread.sleep(15000);
		
		String shipType = ShipsIMOnumber.verify_ship_type(driver).getText();
		/*Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_type, shipType);*/
		log.info("Ship Type is displayed: " + shipType);
		Thread.sleep(15000);
		
		String registeredOwner = ShipsIMOnumber.verify_registered_owner(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_registered_owner, registeredOwner);
		log.info("Registered Owner is displayed: " + registeredOwner);
		Thread.sleep(2000);
		
		String shipManager = ShipsIMOnumber.verify_ship_manager(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_manager, shipManager);
		log.info("Ship Manager is displayed: " + shipManager);
		Thread.sleep(2000);
		
		String shipOperator = ShipsIMOnumber.verify_ship_operator(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_operator, shipOperator);
		log.info("Ship Operator is displayed: " + shipOperator);
		Thread.sleep(2000);
		
		/*String shipFlag = ShipsIMOnumber.verify_ship_flag(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_flag, shipFlag);
		log.info("Ship Flag is displayed: " + shipFlag);*/
		
		/*String shipMmsi = ShipsIMOnumber.verify_mmsi(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_mmsi, shipMmsi);
		log.info("Ship MMSI number is displayed: " + shipMmsi);
		Thread.sleep(2000);*/
		
		String callSign = ShipsIMOnumber.verify_call_sign(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_call_sign, callSign);
		log.info("Ship Call Sign is displayed: " + callSign);
		
		String portOfRegistry = ShipsIMOnumber.port_of_registry(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.port_of_registry, portOfRegistry);
		log.info("Ship Port of Registry is displayed: " + portOfRegistry);
		Thread.sleep(2000);
		
		String classificationSociety = ShipsIMOnumber.classification_society(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.classification_society, classificationSociety);
		log.info("Ship Classification Society is displayed: " + classificationSociety);
		Thread.sleep(2000);
		
		String stateCode5 = ShipsIMOnumber.stat_code_5(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.stat_code_5, stateCode5);
		log.info("Ship State Code 5 is displayed: " + stateCode5);
		Thread.sleep(2000);
		
		String deadWeight = ShipsIMOnumber.deadweight(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.deadweight, deadWeight);
		log.info("Ship Deadweight is displayed: " + deadWeight);
		Thread.sleep(2000);
		
		String displacementShip = ShipsIMOnumber.displacement(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.displacement, displacementShip);
		log.info("Ship Displacement is displayed: " + displacementShip);
		Thread.sleep(2000);
		
		String grossTonnage = ShipsIMOnumber.gross_tonnage(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.gross_tonnage, grossTonnage);
		log.info("Ship Gross tonnage is displayed: " + grossTonnage);
		Thread.sleep(2000);
		
		String lengthOverall = ShipsIMOnumber.length_of_overall(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.length_of_overall, lengthOverall);
		log.info("Ship Length overall is displayed: " + lengthOverall);
		Thread.sleep(2000);
		
		String shipBreadth = ShipsIMOnumber.breadth(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.breadth, shipBreadth);
		log.info("Ship Breadth is displayed: " + shipBreadth);
		Thread.sleep(2000);
		
		String shipDepth = ShipsIMOnumber.depth(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.depth, shipDepth);
		log.info("Ship Depth is displayed: " + shipDepth);
		Thread.sleep(2000);
		
		String shipDraught = ShipsIMOnumber.draught(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.draught, shipDraught);
		log.info("Ship Draught is displayed: " + shipDraught);
		Thread.sleep(2000);
		
		String ShipBuilder = ShipsIMOnumber.ship_builder(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.ship_builder, ShipBuilder);
		log.info("Ship Ship builder is displayed: " + ShipBuilder);
		Thread.sleep(2000);
		
		String countryOfBuild = ShipsIMOnumber.country_of_build(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.country_of_build, countryOfBuild);
		log.info("Ship Country of build is displayed: " + countryOfBuild);
		Thread.sleep(2000);
		
		String yearOfBuild = ShipsIMOnumber.year_of_build(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.year_of_build, yearOfBuild);
		log.info("Ship Year of build is displayed: " + yearOfBuild);
		Thread.sleep(2000);
		
		ShipsIMOnumber.Search_for_ship_next(driver).click();
		log.info("navigating to Account page");
		Thread.sleep(15000);
		
		String selectAccountName = ShipsIMOnumber.verify_account_name(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_account_name, selectAccountName);
		log.info("Verify the account Title : " + selectAccountName);
		
		ShipsIMOnumber.click_on_first_account(driver).click();
		
		Thread.sleep(15000);
		
		String parentAccountName = ShipsIMOnumber.verify_parent_account_name(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_parent_account_name, parentAccountName);
		log.info("Verify the account Title : " + parentAccountName);
		
		ShipsIMOnumber.Search_for_ship_next(driver).click();
		
		log.info("Navigating to Select fleet page");
		Thread.sleep(15000);
		String shipFleet = ShipsIMOnumber.select_fleet(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_register_fleet, shipFleet);
		log.info("We are in Select fleet Page : " + shipFleet);
		
		ShipsIMOnumber.fleet_name(driver).click();
		Thread.sleep(15000);
		
	String fleetname = ShipsIMOnumber.fleet_name(driver).getText();
	
	log.info("Selected fleet is : " + fleetname);
		
		ShipsIMOnumber.Search_for_ship_next(driver).click();
		Thread.sleep(15000);
		
		log.info("Navigating to Register Transceiver");
		
		String shipRegisterTransceiver = ShipsIMOnumber.verify_register_transceive(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_register_transceiver, shipRegisterTransceiver);
		log.info("We are in Transceiver Page : " + shipRegisterTransceiver);
		
		ShipsIMOnumber.ships_with_IMO_number_register_transceiver_model(driver).click();
		Thread.sleep(15000);
		ShipsIMOnumber.ships_with_IMO_number_register_transceiver_model_selected(driver).click();
		
		//Registering transceiver and saving the details
		
		String shipname = ShipsIMOnumber.ship_name(driver).getText();
		log.info("registered ship name is :" + shipname);
		
		//Selecting the transceiver from the drop down
		
		WebElement mySelectElement = ShipsIMOnumber.transceiver(driver);
		
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByVisibleText("Ericsson - Ericsson Globecomm");

		log.info("selected transceiver is : " + mySelectElement);
		
		ShipsIMOnumber.transceiver_save(driver).click();
		Thread.sleep(15000);
		log.info("transceiver details are saved");
		
		
		//Verifying whether ship is registered or not
		
		log.info("verifying the ship registered or not");
		
		String shipname_entered = "ALEXANDER B";
		
		//Clicking on drop-down
		Thread.sleep(3000);
		String ShipsHeaderTitleafterregisteringtheship = ShipswithoutIMOnumber.ships_header_title(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ships_text_header, ShipsHeaderTitleafterregisteringtheship);
		log.info("Ships Header Title:  " + ShipsHeaderTitleafterregisteringtheship);
		Thread.sleep(3000);

		//Viewing the recently created ship
		log.info("Click on the \"Sort by name\" tab");
		ShipswithoutIMOnumber.ships_without_IMO_number_sort_by_name(driver).click();
		Thread.sleep(15000);
		log.info("Click on the \"Sort by most recently added\" link");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_most_recently_created_ship(driver).click();
		Thread.sleep(15000);

		log.info("Entered the ship_name in the search field");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).sendKeys(shipNameTitle);
		Thread.sleep(15000);

		//Verifying the data entered
		log.info("Opening the ship created");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field_ship_name(driver).click();
		Thread.sleep(15000);

		//Verify details used in account creation is the same
		log.info("*********Verify the ship created*************");
		String account_name = ShipsIMOnumber.account(driver).getText();
		Assert.assertEquals(account_name, "0. Sara's Pugwash Lines");
		log.info("Account selected is the same as Account used in ship registration:  " + selectAccountName);
		
		ShipsIMOnumber.recentlyadded_dropdown(driver).click();
		
		
		//selecting the option-recently added from drop-down
		ShipsIMOnumber.recentlyadded_select(driver).click();
	
		
		//selecting the first displayed ship
		ShipsIMOnumber.ship_select(driver).click();
		
		
		//Validating the ship details
		
		String registered_ship = ShipsIMOnumber.regidtered_ship(driver).getText();
		Assert.assertEquals(shipNameTitle, registered_ship);
		log.info("Ship registered with IMO successfully and the ship name is : " + registered_ship);
		//Below lines of code for editing and deleting, shipswithoutIMOnumber methods are using as functionality is same in-terms of editing and deleting the ships.
		
				//Edit the Ship details
						log.info("******Editing the ship data********");
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_name(driver).click();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_name(driver).clear();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_name(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name_edit);
						log.info("The ship name edited is : "+ ShipswithIMOnumberTestData.ship_name_edit);
						Thread.sleep(3000);

						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_type(driver).click();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_type(driver).clear();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_type(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_type_edit);
						log.info("The ship name edited is : "+ ShipswithIMOnumberTestData.ship_type_edit);

						ShipswithoutIMOnumber.ships_without_IMO_number_verify_registered_owner(driver).click();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_registered_owner(driver).clear();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_registered_owner(driver).sendKeys(ShipsTestDatawithoutIMOnumber.registered_owner_edit);
						log.info("The ship name edited is : "+ ShipswithIMOnumberTestData.registered_owner_edit);

						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_manager(driver).click();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_manager(driver).clear();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_manager(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_manager_edit);
						log.info("The ship name edited is : "+ ShipswithIMOnumberTestData.ship_manager_edit);

						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_operator(driver).click();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_operator(driver).clear();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_operator(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_operator_edit);
						log.info("The ship name edited is : "+ ShipswithIMOnumberTestData.ship_operator_edit);
						
						Thread.sleep(10000);

						//ShipswithoutIMOnumber.ships_without_IMO_number_ship_flag_remove(driver).click();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_flag(driver).clear();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_flag(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_flag_edit);
						Thread.sleep(10000);
						ShipswithoutIMOnumber.ships_without_IMO_number_ship_flag_united_kingdom(driver).click();
						log.info("The ship name edited is : "+ ShipswithIMOnumberTestData.ship_flag_edit);
						Thread.sleep(10000);
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_call_sign(driver).click();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_call_sign(driver).clear();
						ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_call_sign(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_call_sign_edit);
						log.info("The ship name edited is : "+ ShipswithIMOnumberTestData.ship_call_sign_edit);

						log.info("************Clicked on Save button**********");
						ShipswithoutIMOnumber.ships_without_IMO_number_edit_save(driver).click();

						//Viewing the recently Edited ship
						log.info("********searching the recently edited ship*****");
						log.info("Click on the \"Sort by name\" tab");
						Thread.sleep(15000);
						ShipswithoutIMOnumber.ships_without_IMO_number_sort_by_name(driver).click();
						Thread.sleep(15000);
						log.info("Click on the \"Sort by most recently added\" link");
						Thread.sleep(15000);
						ShipswithoutIMOnumber.ships_without_IMO_number_search_most_recently_edited_ship(driver).click();
						Thread.sleep(15000);

						log.info("Entered the ship_name in the search field");
						ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).click();
						Thread.sleep(15000);
						ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).clear();
						Thread.sleep(15000);
						ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name_edit);
						Thread.sleep(15000);

						//Verify the edited  data entered
						log.info("********verifying the recently edited ship data********");
						log.info("Opening the ship created");
						ShipswithoutIMOnumber.ships_without_IMO_number_search_field_ship_name(driver).click();
						Thread.sleep(15000);

						String ship_name_edit = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_name(driver).getAttribute("value");
						log.info("Ship name selected is same as the ship name selected in ship registration:  " + ship_name_edit);
						Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_name_edit, ship_name_edit);
						log.info("Ship name selected is same as the ship name selected in ship registration:  " + ship_name_edit);
						Thread.sleep(3000);

						String ship_type_selected_edited = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_type(driver).getAttribute("value");
						//Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_type_edit, ship_type_selected);
						log.info("Ship type selected is same as the ship type selected in ship registration:  " + ship_type_selected_edited);
						Thread.sleep(3000);

						String registered_owner_edit = ShipswithoutIMOnumber.ships_without_IMO_number_verify_registered_owner(driver).getAttribute("value");
						Assert.assertEquals(ShipsTestDatawithoutIMOnumber.registered_owner_edit, registered_owner_edit);
						log.info("Registered owner is same as the registered owner selected in ship registration:  " + registered_owner_edit);
						Thread.sleep(3000);

						String ship_manager_edit = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_manager(driver).getAttribute("value");
						Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_manager_edit, ship_manager_edit);
						log.info("Ship manager is same as the ship_manager selected in ship registration:  " + ship_manager_edit);
						Thread.sleep(3000);

						String ship_operator_edit = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_operator(driver).getAttribute("value");
						Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_operator_edit, ship_operator_edit);
						log.info("Ship operator is same as the ship_operator selected in ship registration:  " + ship_operator_edit);
						Thread.sleep(3000);

						String ship_flag_edit = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_flag(driver).getAttribute("value");
						Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_flag_edit, ship_flag_edit);
						log.info("Ship flag is same as the ship_flag selected in ship registration:  " + ship_flag_edit);
						Thread.sleep(3000);

						String ship_call_sign_edit = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_call_sign(driver).getAttribute("value");
						Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_call_sign_edit, ship_call_sign_edit);
						log.info("Ship call sign is same as the ship call sign selected in ship registration:  " + ship_call_sign_edit);
						Thread.sleep(10000);

						//Delete the Ship created
						log.info("*********Delete the ship********");
						log.info("********searching the recently edited ship*****");
						log.info("Click on the \"Sort by name\" tab");
						ShipswithoutIMOnumber.ships_without_IMO_number_sort_by_name(driver).click();
						log.info("Click on the \"Sort by most recently added\" link");
						ShipswithoutIMOnumber.ships_without_IMO_number_search_most_recently_edited_ship(driver).click();
						Thread.sleep(3000);

						log.info("Entered the ship_name in the search field");
						ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).click();
						Thread.sleep(10000);
						ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).clear();
						Thread.sleep(10000);
						ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name_edit);
						Thread.sleep(10000);
								
						ShipswithoutIMOnumber.ships_without_IMO_number_delete_ship(driver).click();
						Thread.sleep(15000);
						log.info("****CLick on OK on the modal*******");
						ShipswithoutIMOnumber.ships_without_IMO_number_delete_OK(driver).click();
						
						Thread.sleep(15000);
						
						log.info("********searching the deleted ship*****");
						log.info("Entered the ship_name in the search field");
						ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).click();
						Thread.sleep(15000);
						ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).clear();
						Thread.sleep(15000);
						ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name_edit);
						Thread.sleep(15000);
						String ship_not_found = ShipswithoutIMOnumber.ships_without_IMO_number_ship_not_found(driver).getText();
						Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_deleted_not_found_text, ship_not_found);
						log.info("Ship is no more active :  " + ship_not_found);
					}
			
			
			@AfterTest
			public void tearDown() throws Exception {
				//BrowserType.closeAllDriver();
			}

		}
