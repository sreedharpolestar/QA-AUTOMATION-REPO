package functionalTest;

import java.util.concurrent.TimeUnit;

import modules.IntegrationTest;

import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjectMethods.ShipsIMOnumber;
import testDatas.ShipswithIMOnumberTestData;
import testEnviroments.enviroments;
import browserType.BrowserType;

public class ShipswithIMOnumberFunctional {

	@Test
	public void CreateShipswithIMOnumber() throws Throwable {

		WebDriver driver = BrowserType.getBrowser("Chrome");
		Logger log = Logger.getLogger("Logger");
		
		driver.get(enviroments.url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		log.info("Web application launched");
		
		// Login to the Application
		IntegrationTest.login(driver);
		Thread.sleep(3000);
		
		// Click Ships text link
		ShipsIMOnumber.ships_menu(driver).click();
		Thread.sleep(1000);
		log.info("Ships menu link clicked");
		
		String shipHeaderTitle = ShipsIMOnumber.ships_header_title(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.ships_text_header, shipHeaderTitle);
		log.info("Ships Header Title:  " + shipHeaderTitle);
				
		//Create a ship with IMO number
		ShipsIMOnumber.new_register_ship(driver).click();
		log.info("New Register ship button clicked");
		Thread.sleep(3000);
		
		String registershipHeaderTitle = ShipsIMOnumber.register_ship_header(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.register_ship_header, registershipHeaderTitle);
		Thread.sleep(3000);
		log.info("Register ship Header Title:  " + registershipHeaderTitle);
		
		// Click with IMo number
		ShipsIMOnumber.with_IMO_number(driver).click();
		log.info("With imo number link clicked");
		
		Thread.sleep(3000);
		
		// Search for ship
		String enter_search_for_ship_link = ShipswithIMOnumberTestData.enter_search_for_ship_link;
		ShipsIMOnumber.enter_search_for_ship_link(driver).sendKeys(enter_search_for_ship_link);
		log.info(enter_search_for_ship_link + ": is Entered Ship name");
		Thread.sleep(3000);
		
		ShipsIMOnumber.select_ship_IMO_number(driver).click();
		log.info("Waiting for Ship details");
		
		String  shipNameTitle = ShipsIMOnumber.verify_ship_name(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_name, shipNameTitle);
		log.info("Ship Name is displayed: " + shipNameTitle);
		
		String  shipImonumber = ShipsIMOnumber.verify_ship_IMO_number(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_imo, shipImonumber);
		log.info("Ship Imo Number is displayed: " + shipImonumber);
		Thread.sleep(2000);
		
		String shipType = ShipsIMOnumber.verify_ship_type(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_type, shipType);
		log.info("Ship Type is displayed: " + shipType);
		Thread.sleep(2000);
		
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
		Thread.sleep(3000);
		
		String selectAccountName = ShipsIMOnumber.verify_account_name(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_account_name, selectAccountName);
		log.info("Verify the account Title : " + selectAccountName);
		
		ShipsIMOnumber.click_on_first_account(driver).click();
		
		String parentAccountName = ShipsIMOnumber.verify_parent_account_name(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_parent_account_name, parentAccountName);
		log.info("Verify the account Title : " + parentAccountName);
		
		ShipsIMOnumber.Search_for_ship_next(driver).click();
		log.info("Navigating to Register Transceiver");
		
		String shipRegisterTransceiver = ShipsIMOnumber.verify_register_transceive(driver).getText();
		Assert.assertEquals(ShipswithIMOnumberTestData.verify_ship_register_transceiver, shipRegisterTransceiver);
		log.info("We are in Transceiver Page : " + shipRegisterTransceiver);
		
		ShipsIMOnumber.ships_with_IMO_number_register_transceiver_model(driver).click();
		ShipsIMOnumber.ships_with_IMO_number_register_transceiver_model_selected(driver).click();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		//BrowserType.closeAllDriver();
	}

}
