package functionalTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testDatas.*;
import testEnviroments.*;
import pageObjectMethods.*;
import browserType.*;
import modules.*;

public class FleetsFunctional {
	WebDriver driver = BrowserType.getBrowser("Chrome");
	Logger log = Logger.getLogger("Logger");
	String fleetNameEdit = FleetsTestData.fleets_name_edit;
	
	@Test
	public void createNewFleet() throws Throwable{
	

		driver.get(enviroments.url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		log.info("Web application launched");

		IntegrationTest.login(driver);

		Fleets.fleets_menu(driver).click();
		log.info("Fleets menu link clicked");

		String fleetsHeaderTitle = Fleets.fleets_header_title(driver).getText();
		Assert.assertEquals(FleetsTestData.fleets_text_header, fleetsHeaderTitle);
		log.info("Users Header Title:  " + fleetsHeaderTitle);

		Fleets.new_fleets_button(driver).click();
		log.info("New Fleets button clicked");

		String newFleetsPageTitle = Fleets.new_fleets_page_title(driver).getText();
		Assert.assertEquals(FleetsTestData.new_fleets_page_title, newFleetsPageTitle);
		log.info("Create New Fleet Page Title:  " + newFleetsPageTitle);

		Global.save_button(driver).click();
		log.info("Save button clicked");

		String FleetNameValidation = Fleets.new_fleets_name_required_validation_messgae(driver).getText();
		Assert.assertEquals(FleetsTestData.fleets_name_required_field, FleetNameValidation);
		log.info("Fleet Name Validation Message:  " + FleetNameValidation);

		// Input test data
		String fleetName = FleetsTestData.fleets_name;
		Fleets.new_fleets_name(driver).sendKeys(fleetName);
		log.info(fleetName + ": is entered in Fleet Name");

		Fleets.new_fleets_account(driver).sendKeys(FleetsTestData.fleets_account);
		Thread.sleep(2000);
		Fleets.select_account(driver).click();
		Thread.sleep(2000);
		log.info(FleetsTestData.fleets_account + ": is entered in Fleet Account");

		//Click save button 
		Global.save_button(driver).click();
		log.info("Save button clicked");
		//Thread.sleep(2000);
		
		//Click done button 
		Global.done_button(driver).click();
		log.info("Done button clicked");
		//Thread.sleep(2000);

		//Search for created fleet
		search(fleetName);

		//Search return created fleet
		Global.search_result(driver).click();
		Thread.sleep(2000);
				
		//Verify details used in account creation is the same
		String verifyFleetName = Fleets.new_fleets_name(driver).getAttribute("value");
		Assert.assertEquals(FleetsTestData.fleets_name, verifyFleetName);
		log.info("fleet name is the same as fleet name used in creating new fleet:  " + verifyFleetName);

		String verifyAccountName = Fleets.account(driver).getText();
		//Assert.assertEquals(FleetsTestData.fleets_parent_account, verifyAccountName);
		//Assert.assertNotNull(verifyAccountName);
		Assert.assertEquals(FleetsTestData.fleets_parent_account,verifyAccountName);
		log.info("fleet account name is the same as fleet account name used in creating new fleet:  " + verifyAccountName);
		Thread.sleep(2000);

		//Edit the fleet details
		
		Fleets.new_fleets_name(driver).clear();
		Thread.sleep(2000);
		Fleets.new_fleets_name(driver).sendKeys(fleetNameEdit);
		log.info(fleetNameEdit + ": is entered in Fleet Name");
		

		//Click save button 
		Global.save_button(driver).click();
		log.info("Save button clicked");

		//Verify the fleet name edited is saved
		search(fleetNameEdit);	

		//Search return created fleet
		Global.search_result(driver).click();
		Thread.sleep(2000);
		
		//Verify details used in account creation is the same
		String verifyFleetNameEdit = Fleets.new_fleets_name(driver).getAttribute("value");
		Assert.assertEquals(FleetsTestData.fleets_name_edit, verifyFleetNameEdit);
		log.info("fleet name is the same as fleet name used in creating new fleet:  " + verifyFleetNameEdit);
		Thread.sleep(2000);
		
		//Verify the cancel button
		log.info("Verifying the cancel button");
		Global.Fleets_cancel(driver).click();
		
		//Search for created fleet
		search(fleetNameEdit);

		//Search return created fleet
		Global.search_result(driver).click();
		Thread.sleep(2000);
		
		//Delete the fleet created
		log.info("Clicking on the Delete button");
		Global.deactivate(driver).click();
		Thread.sleep(2000);
		
		//modal_close
		Global.modal_ok(driver).click();
		Thread.sleep(1000);
		search(fleetNameEdit);
		
		//Search return no contact		
		String noFleetFound = Fleets.No_fleet_found(driver).getText();
		Assert.assertEquals(FleetsTestData.no_fleet_found, noFleetFound);
		log.info("Delete is successful");
	}	
	
	private void search(String fleetName) throws InterruptedException {
		Global.search_textbox(driver).click();
		Global.search_textbox(driver).clear();
		Global.search_textbox(driver).sendKeys(fleetName);
		log.info(fleetName + ": is entered in search box");
		//Global.search_textbox(driver).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}

	@AfterTest
	public void tearDown() throws Exception {
		BrowserType.closeAllDriver();
	}

}