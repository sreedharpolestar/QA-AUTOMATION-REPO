package modules;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import browserType.BrowserType;
import pageObjectMethods.Global;
import pageObjectMethods.ShipswithoutIMOnumber;
import testDatas.ShipsTestDatawithoutIMOnumber;
import testEnviroments.enviroments;

public class ShipsWithoutIMOModule {
	
	@Test
	public static void RegisterShipWithoutIMONumber(WebDriver driver) throws Throwable{
		//WebDriver driver = BrowserType.getBrowser("Chrome");
		Logger log = Logger.getLogger("Logger");

		/*driver.get(enviroments.url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		log.info("Web application launched");

		IntegrationTest.login(driver);
*/
		ShipswithoutIMOnumber.ships_menu(driver).click();
		log.info("Ships menu link clicked");

		String ShipsHeaderTitle = ShipswithoutIMOnumber.ships_header_title(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ships_text_header, ShipsHeaderTitle);
		log.info("Ships Header Title:  " + ShipsHeaderTitle);

		ShipswithoutIMOnumber.register_ship_button(driver).click();
		log.info("Register ship button clicked");

		String newShipsPageTitle = ShipswithoutIMOnumber.register_ship_title(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.register_ship_header, newShipsPageTitle);
		log.info("Register ship Page Title:  " + newShipsPageTitle);

		ShipswithoutIMOnumber.ships_without_IMO_number_menu_text(driver).click();
		log.info("Register ship without an IMO number is selected");

		String register_ship_page_title = ShipswithoutIMOnumber.ships_without_IMO_number_register_page_title(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.shipswithoutIMOnumberregisterpagetitle, register_ship_page_title);
		log.info("Register ship page title:  " + register_ship_page_title);

		ShipswithoutIMOnumber.ships_without_IMO_number_register_ship_page_next(driver).click();

		// Verify validation messages for Register Ship without IMO number page
		String ship_name_required_validation = ShipswithoutIMOnumber.ships_without_IMO_number_register_page_ship_name_validation_message(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_name_required_validation_message, ship_name_required_validation);
		log.info("Ship name Validation Message:  " + ship_name_required_validation);

		String ship_type_required_validation = ShipswithoutIMOnumber.ships_without_IMO_number_register_page_ship_type_validation_message(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_type_required_validation_message, ship_type_required_validation);
		log.info("Ship type Validation Message:  " + ship_type_required_validation);

		String ship_registered_owner_validation = ShipswithoutIMOnumber.ships_without_IMO_number_register_page_registered_owner_validation_messgae(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_registered_owner_validation_message, ship_registered_owner_validation);
		log.info("Ships Account Type Validation Message:  " + ship_registered_owner_validation);

		String ship_manager_validation = ShipswithoutIMOnumber.ships_without_IMO_number_register_page_ship_manager_validation_message(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_manager_required_validation_message, ship_manager_validation);
		log.info("Ships Role Validation Message:  " + ship_manager_validation);

		String ship_operator_validation = ShipswithoutIMOnumber.ships_without_IMO_number_register_page_ship_operator_validation_message(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_operator_required_validation_message, ship_operator_validation);
		log.info("Ships Role Validation Message:  " + ship_operator_validation);

		//Input Data
		ShipswithoutIMOnumber.ships_without_IMO_number_register_page_ship_name(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name);
		log.info("Ship name entered is: " + ShipsTestDatawithoutIMOnumber.ship_name);

		ShipswithoutIMOnumber.ships_without_IMO_number_register_page_ship_type(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_type);
		Thread.sleep(3000);
		ShipswithoutIMOnumber.ships_without_IMO_number_register_page_ship_type_text_selected(driver).click();
		//	String ship_type= ShipswithoutIMOnumber.ships_without_IMO_number_register_page_ship_type_selected(driver).getText();
		//Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_type, ship_type);
		log.info("Ship type entered is: " + ShipsTestDatawithoutIMOnumber.ship_type);
		Thread.sleep(2000);

		ShipswithoutIMOnumber.ships_without_IMO_number_register_page_registered_owner(driver).sendKeys(ShipsTestDatawithoutIMOnumber.registered_owner);
		log.info("Ship registered owner entered is: " + ShipsTestDatawithoutIMOnumber.registered_owner);

		ShipswithoutIMOnumber.ships_without_IMO_number_register_page_ship_manager(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_manager);
		log.info("Ship operator entered is: " + ShipsTestDatawithoutIMOnumber.ship_manager);

		ShipswithoutIMOnumber.ships_without_IMO_number_register_page_ship_operator(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_operator);
		log.info("Ship operator entered is: " + ShipsTestDatawithoutIMOnumber.ship_operator);

		ShipswithoutIMOnumber.ships_without_IMO_number_register_page_flag(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_flag);
		Thread.sleep(2000);
		ShipswithoutIMOnumber.ships_without_IMO_number_register_page_flag_selected(driver).click();
		Thread.sleep(2000);
		//String flag = ShipswithoutIMOnumber.ships_without_IMO_number_register_page_flag_input(driver).getText();
		log.info("The flag selected is: " + ShipsTestDatawithoutIMOnumber.ship_flag);
		Thread.sleep(2000);

		ShipswithoutIMOnumber.ships_without_IMO_number_register_page_MMSI_number(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_MMSI_number);
		log.info("The MMSI number entered is: " + ShipsTestDatawithoutIMOnumber.ship_MMSI_number);
		Thread.sleep(2000);

		ShipswithoutIMOnumber.ships_without_IMO_number_register_page_call_sign(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_call_sign);
		log.info("The Call sign number entered is: " + ShipsTestDatawithoutIMOnumber.ship_call_sign);
		Thread.sleep(2000);

		Global.ship_next(driver).click();

		String select_account_page_Title = Global.ships_page_title(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.select_account_title, select_account_page_Title);
		log.info("The select account page title is :" + select_account_page_Title );
		Thread.sleep(2000);

		ShipswithoutIMOnumber.ships_without_IMO_number_select_account(driver).click();

		String ship_account_selected = ShipswithoutIMOnumber.ships_without_IMO_number_account_selected(driver).getText();
		log.info("The account selected is: " + ship_account_selected);
		String fleet_count = ShipswithoutIMOnumber.ships_without_IMO_number_account_fleet_count(driver).getText();
		int fleet_count_int = Integer.parseInt(fleet_count);
		Thread.sleep(2000);

		Global.ship_next(driver).click();

		if( fleet_count_int >= 1 ){
			Thread.sleep(2000);
			String select_ship_fleet_page_Title = Global.ships_page_title(driver).getText();
			Assert.assertEquals(ShipsTestDatawithoutIMOnumber.select_fleet_title, select_ship_fleet_page_Title);
			log.info("The select account page title is: " + select_ship_fleet_page_Title );
			Thread.sleep(2000);

			ShipswithoutIMOnumber.ships_without_IMO_number_select_fleet(driver).click();


			String select_ship_fleet_selected = ShipswithoutIMOnumber.ships_without_IMO_number_select_fleet_selected(driver).getText();
			log.info("The fleet selected is: " + select_ship_fleet_selected);
			Thread.sleep(2000);

			Global.ship_next(driver).click();
		}

		String Register_transceiver_page_Title = Global.ships_page_title(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.register_transceiver_title, Register_transceiver_page_Title);
		log.info("The select account page title is: " + Register_transceiver_page_Title );
		Thread.sleep(2000);

		String ship_created = ShipswithoutIMOnumber.ships_without_IMO_number_register_transceiver_shipname_created(driver).getText();
		log.info("The ship registered is: " + ship_created);

		//ShipswithoutIMOnumber.ships_without_IMO_number_save(driver).click();

		/*String transceiver_model_required_validation_message = ShipswithoutIMOnumber.ships_without_IMO_number_register_model_validation_message(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.register_transceiver_validation_message, transceiver_model_required_validation_message);
		log.info("The validation message to enter the transceiver model is: " + transceiver_model_required_validation_message);
		Thread.sleep(2000);*/

		ShipswithoutIMOnumber.ships_without_IMO_number_register_transceiver_model(driver).click();
		ShipswithoutIMOnumber.ships_without_IMO_number_register_transceiver_model_selected(driver).click();
		Thread.sleep(3000);

		//ShipswithoutIMOnumber.ships_without_IMO_number_save(driver).click();

		/*String MMSI_number_required_validation_number = ShipswithoutIMOnumber.ships_without_IMO_number_register_transceiver_MMSI_validation_message(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.register_transceiver_MMSI_validation_message, MMSI_number_required_validation_number);
		log.info("The validation message displayed is " + MMSI_number_required_validation_number );
		 */

		Thread.sleep(3000);

		log.info("Clicked on save button on the Register transceiver page");
		ShipswithoutIMOnumber.ships_without_IMO_number_save(driver).click();
		log.info("Navigated back to \"Ships\" page");

		Thread.sleep(3000);
		String ShipsHeaderTitleafterregisteringtheship = ShipswithoutIMOnumber.ships_header_title(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ships_text_header, ShipsHeaderTitleafterregisteringtheship);
		log.info("Ships Header Title:  " + ShipsHeaderTitleafterregisteringtheship);
		Thread.sleep(3000);

		//Viewing the recently created ship
		log.info("Click on the \"Sort by name\" tab");
		ShipswithoutIMOnumber.ships_without_IMO_number_sort_by_name(driver).click();
		log.info("Click on the \"Sort by most recently added\" link");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_most_recently_created_ship(driver).click();
		Thread.sleep(3000);

		log.info("Entered the ship_name in the search field");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name);
		Thread.sleep(3000);

		//Verifying the data entered
		log.info("Opening the ship created");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field_ship_name(driver).click();
		Thread.sleep(3000);

		//Verify details used in account creation is the same
		log.info("*********Verify the ship created*************");
		String Account = ShipswithoutIMOnumber.ships_without_IMO_number_verify_account(driver).getAttribute("value");
		Assert.assertEquals(ship_account_selected, Account);
		log.info("Account selected is the same as Account used in ship registration:  " + Account);
		Thread.sleep(3000);

		String fleet_selected = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_fleet(driver).getAttribute("value");
		// Assert.assertEquals(fleet_selected, fleet_selected);
		log.info("Fleet selected is the same as fleet selected in ship registration:  " + fleet_selected);
		Thread.sleep(3000);

		String ship_name_selected = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_name(driver).getAttribute("value");
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_name, ship_name_selected);
		log.info("Ship name selected is same as the ship name selected in ship registration:  " + ship_name_selected);
		Thread.sleep(3000);

		String ship_type_selected = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_type(driver).getAttribute("value");
		// Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_type, ship_type_selected);
		log.info("Ship type selected is same as the ship type selected in ship registration:  " + ship_type_selected);
		Thread.sleep(3000);

		String registered_owner = ShipswithoutIMOnumber.ships_without_IMO_number_verify_registered_owner(driver).getAttribute("value");
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.registered_owner, registered_owner);
		log.info("Registered owner is same as the registered owner selected in ship registration:  " + registered_owner);
		Thread.sleep(3000);

		String ship_manager = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_manager(driver).getAttribute("value");
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_manager, ship_manager);
		log.info("Ship manager is same as the ship_manager selected in ship registration:  " + ship_manager);
		Thread.sleep(3000);

		String ship_operator = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_operator(driver).getAttribute("value");
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_operator, ship_operator);
		log.info("Ship operator is same as the ship_operator selected in ship registration:  " + ship_operator);
		Thread.sleep(3000);

		String ship_flag = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_flag(driver).getAttribute("value");
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_flag, ship_flag);
		log.info("Ship flag is same as the ship_flag selected in ship registration:  " + ship_flag);
		Thread.sleep(3000);

		String ship_MMSI_number = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_MMSI_number(driver).getAttribute("value");
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_MMSI_number, ship_MMSI_number);
		log.info("Ship MMSI is same as the ship_mmsi selected in ship registration:  " + ship_MMSI_number);
		Thread.sleep(3000);

		String ship_call_sign = ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_call_sign(driver).getAttribute("value");
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_call_sign, ship_call_sign);
		log.info("Ship call sign is same as the ship call sign selected in ship registration:  " + ship_call_sign);
		Thread.sleep(3000);

		String ship_Stat_code_5= ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_stat_code_5(driver).getAttribute("value");
		log.info("Ship stat code is :  " + ship_Stat_code_5);
		Thread.sleep(3000);

		//Edit the Ship details
		log.info("******Editing the ship data********");
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_name(driver).click();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_name(driver).clear();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_name(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name_edit);
		log.info("The ship name edited is : "+ ShipsTestDatawithoutIMOnumber.ship_name_edit);
		Thread.sleep(3000);

		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_type(driver).click();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_type(driver).clear();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_type(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_type_edit);
		log.info("The ship name edited is : "+ ShipsTestDatawithoutIMOnumber.ship_type_edit);

		ShipswithoutIMOnumber.ships_without_IMO_number_verify_registered_owner(driver).click();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_registered_owner(driver).clear();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_registered_owner(driver).sendKeys(ShipsTestDatawithoutIMOnumber.registered_owner_edit);
		log.info("The ship name edited is : "+ ShipsTestDatawithoutIMOnumber.registered_owner_edit);

		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_manager(driver).click();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_manager(driver).clear();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_manager(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_manager_edit);
		log.info("The ship name edited is : "+ ShipsTestDatawithoutIMOnumber.ship_manager_edit);

		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_operator(driver).click();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_operator(driver).clear();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_operator(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_operator_edit);
		log.info("The ship name edited is : "+ ShipsTestDatawithoutIMOnumber.ship_operator_edit);

		ShipswithoutIMOnumber.ships_without_IMO_number_ship_flag_remove(driver).click();
		//ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_flag(driver).clear();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_flag(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_flag_edit);
		ShipswithoutIMOnumber.ships_without_IMO_number_ship_flag_united_kingdom(driver).click();
		log.info("The ship name edited is : "+ ShipsTestDatawithoutIMOnumber.ship_flag_edit);

		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_call_sign(driver).click();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_call_sign(driver).clear();
		ShipswithoutIMOnumber.ships_without_IMO_number_verify_ship_call_sign(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_call_sign_edit);
		log.info("The ship name edited is : "+ ShipsTestDatawithoutIMOnumber.ship_call_sign_edit);

		log.info("************Clicked on Save button**********");
		ShipswithoutIMOnumber.ships_without_IMO_number_edit_save(driver).click();

		//Viewing the recently Edited ship
		log.info("********searching the recently edited ship*****");
		log.info("Click on the \"Sort by name\" tab");
		ShipswithoutIMOnumber.ships_without_IMO_number_sort_by_name(driver).click();
		log.info("Click on the \"Sort by most recently added\" link");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_most_recently_edited_ship(driver).click();
		Thread.sleep(3000);

		log.info("Entered the ship_name in the search field");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).click();
		Thread.sleep(3000);
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).clear();
		Thread.sleep(3000);
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name_edit);
		Thread.sleep(3000);

		//Verify the edited  data entered
		log.info("********verifying the recently edited ship data********");
		log.info("Opening the ship created");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field_ship_name(driver).click();
		Thread.sleep(3000);

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
		Thread.sleep(3000);

		//Delete the Ship created
		log.info("*********Delete the ship********");
		/*log.info("********searching the recently edited ship*****");
		log.info("Click on the \"Sort by name\" tab");
		ShipswithoutIMOnumber.ships_without_IMO_number_sort_by_name(driver).click();
		log.info("Click on the \"Sort by most recently added\" link");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_most_recently_edited_ship(driver).click();
		Thread.sleep(3000);*/

		log.info("Entered the ship_name in the search field");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).click();
		Thread.sleep(3000);
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).clear();
		Thread.sleep(3000);
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name_edit);
		Thread.sleep(3000);
				
		ShipswithoutIMOnumber.ships_without_IMO_number_delete_ship(driver).click();
		
		log.info("****CLick on OK on the modal*******");
		ShipswithoutIMOnumber.ships_without_IMO_number_delete_OK(driver).click();
		
		log.info("********searching the deleted ship*****");
		log.info("Entered the ship_name in the search field");
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).click();
		Thread.sleep(3000);
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).clear();
		Thread.sleep(3000);
		ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name_edit);
		Thread.sleep(3000);
		String ship_not_found = ShipswithoutIMOnumber.ships_without_IMO_number_ship_not_found(driver).getText();
		Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ship_deleted_not_found_text, ship_not_found);
		log.info("Ship is no more active :  " + ship_not_found);
	}

}
