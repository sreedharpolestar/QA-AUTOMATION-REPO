/**
 * 
 */
/**
 * @author collins.obasuyi
 *
 */
package administration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectMethods.*;
import testDatas.*;
import testEnviroments.enviroments;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class FleetModule {
	
	@Test
	public static void fleet(WebDriver driver) throws Throwable{

		Logger log = Logger.getLogger("Logger");
		// Click contact text link
		String fleetNameEdit = FleetsTestData.fleets_name_edit;
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
		Global.search_textbox(driver).click();
		Global.search_textbox(driver).clear();
		Global.search_textbox(driver).sendKeys(fleetName);
		log.info(fleetName + ": is entered in search box");
		//Global.search_textbox(driver).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

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
		Global.search_textbox(driver).click();
		Global.search_textbox(driver).clear();
		Waitexplicitely(10);
		Global.search_textbox(driver).sendKeys(fleetNameEdit);
		log.info(fleetNameEdit + ": is entered in search box");
		//Global.search_textbox(driver).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		//Search return created fleet
		Global.search_result(driver).click();
		Waitexplicitely(10);
		Thread.sleep(2000);
		
		//Verify details used in account creation is the same
		String verifyFleetNameEdit = Fleets.new_fleets_name(driver).getAttribute("value");
		Waitexplicitely(10);
		log.info(verifyFleetNameEdit);
		Waitexplicitely(10);
		Assert.assertEquals(FleetsTestData.fleets_name_edit, verifyFleetNameEdit);
		log.info("fleet name is the same as fleet name used in creating new fleet:  " + verifyFleetNameEdit);
		Thread.sleep(2000);
		
		//Verify the cancel button
		log.info("Verifying the cancel button");
		Global.Fleets_cancel(driver).click();
		
		//Search for created fleet
		Global.search_textbox(driver).click();
		Global.search_textbox(driver).clear();
		Global.search_textbox(driver).sendKeys(fleetNameEdit);
		Waitexplicitely(10);
		Global.search_textbox(driver).clear();
		Global.search_textbox(driver).sendKeys(fleetNameEdit);
		log.info(fleetNameEdit + ": is entered in search box");
		
		//Global.search_textbox(driver).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		//Search return created fleet
		Global.search_result(driver).click();
		Thread.sleep(2000);
		
		//Delete the fleet created
		log.info("Clicking on the Delete button");
		Global.deactivate(driver).click();
		Thread.sleep(1000);
		
		//modal_close
		Global.modal_ok(driver).click();
		
		Global.search_textbox(driver).click();
		Global.search_textbox(driver).clear();
		Global.search_textbox(driver).sendKeys(fleetNameEdit);
		log.info(fleetNameEdit + ": is entered in search box");
		//Global.search_textbox(driver).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Search return no contact		
		String noFleetFound = Fleets.No_fleet_found(driver).getText();
		Assert.assertEquals(FleetsTestData.no_fleet_found, noFleetFound);
		log.info("Delete is successful");
	}

	/**
	 * @param i
	 */
	private static void Waitexplicitely(int i) {
		// TODO Auto-generated method stub
		
	}	
		
	}












