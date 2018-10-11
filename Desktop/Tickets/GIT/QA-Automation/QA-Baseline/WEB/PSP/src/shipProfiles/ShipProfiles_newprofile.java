package shipProfiles;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;




import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

/*import Notification_resources.LoginPage;*/

import pageObjectMethods.Account;
import pageObjectMethods.Global;
import pageObjectMethods.ShipswithoutIMOnumber;
import scriptResources.*;
import testDatas.AccountTestData;
import testDatas.ShipsTestDatawithoutIMOnumber;
import testEnviroments.enviroments;
/*import Notification_resources.BasePage;
import Notification_resources.LoginPage;*/
import pageObjectMethods.*;
import testDatas.*;

import org.apache.log4j.Logger;


		/**
		 * @author sreedhar.popuri
		 *
		 */

	public class ShipProfiles_newprofile extends BasePage{
		
		public ShipProfiles_newprofile(WebDriver driver) {
			super(driver);
			
			// TODO Auto-generated constructor stub
		}
		
		
		/*LoginPage loginPage = new LoginPage(getDriver());*/
		
		By adminsitaration_link = By.cssSelector("#header__content-nav > div.application__top-menu > ul > li.admin > a");
		By adminsitaration_profiles = By.cssSelector("#application > div.layout-main > div.layout-list.admin.full > div.layout-application > div.application__content > div > div > div:nth-child(5) > a > div.title");
		By homepage_header = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[1]/h3");
		By homepage_sub_header = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[1]/p");
		By sortby_mostrecently_added = By.xpath("//ps-admin-ship-profile-index/div[2]/div[1]/div[2]/ps-option-dropdown/div/button");
		By sortby_name = By.cssSelector("#option-0");
		By noProfilesfound = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[2]/div");
		
		public String homepage_header_title =  "Profiles";
		public static String ship_created;
		public static String accounName;
		public static String profilename = "automation_profile1";
		public static String comment = "automation_comment1";
		public String homepage_sub_header_title = "View, edit or create a ship profile";
		
		
		public String Profilename_edit =  "Polestar_profile_edit";
		public String Profilecomment_edit =  "Polestar_comment_edit";
		
		
		public boolean account(WebDriver driver) throws Throwable{
			// Click Account text link
			Logger log = Logger.getLogger("Logger");
			// Click Account text link
			Account.accounts_menu(driver).click();
			Thread.sleep(3000);
			log.info("Account text link clicked");

			String accountHeaderText = Account.accounts_text_header(driver).getText();
			Assert.assertEquals(AccountTestData.accounts_text_header, accountHeaderText);
			log.info("Page Header Text is:  " + accountHeaderText);

			// Click new account button
			Account.new_account_button(driver).click();
			log.info("New account button clicked");

			// Click save button accounts
			Global.save_button(driver).click();
			log.info("Save button is clicked");

			// Verify validation messages
			String accountTypeRequired = Account.account_type_is_required_validation_text(driver).getText();
			Assert.assertEquals(AccountTestData.account_type_is_required_validation_text, accountTypeRequired);
			log.info("Account type is required validation message:  " + accountTypeRequired);

			String sapCustomerCodeRequired = Account.sap_customer_code_is_required_validation_text(driver).getText();
			Assert.assertEquals(AccountTestData.sap_customer_code_is_required_validation_text, sapCustomerCodeRequired);
			log.info("SAP customer code is required validation message:  " + sapCustomerCodeRequired);

			String storeAccountNameRequired = Account.account_name_is_required_validation_text(driver).getText();
			Assert.assertEquals(AccountTestData.account_name_is_required_validation_text, storeAccountNameRequired);
			log.info("Account name is required validation message:  " + storeAccountNameRequired);


			// Input test data
			new Select(Account.account_type(driver)).selectByVisibleText(AccountTestData.account_type_Distributor_list);
			log.info(AccountTestData.account_type_Distributor_list + ": Account Type selected");

			Account.sap_customer_code(driver).sendKeys(AccountTestData.sap_customer_code);
			log.info(AccountTestData.sap_customer_code + ": is entered in SAP customer code");

			String accounName = AccountTestData.account_name;
			Account.account_name(driver).sendKeys(accounName);
			log.info(accounName + ": is entered in Account name");

			Account.address_line_1(driver).sendKeys(AccountTestData.address_line_1);
			log.info(AccountTestData.address_line_1 + ": is entered in Address line 1");

			Account.address_line_2(driver).sendKeys(AccountTestData.address_line_2);
			log.info(AccountTestData.address_line_2 + ": is entered in Address line 2");

			Account.town_city(driver).sendKeys(AccountTestData.town_city);
			log.info(AccountTestData.town_city + ": is entered in Town/City");

			Account.post_code(driver).sendKeys(AccountTestData.post_code);
			log.info(AccountTestData.post_code + ": is entered in Post Code");

			Account.state(driver).sendKeys(AccountTestData.state);
			log.info(AccountTestData.state + ": is entered in State");

			Account.country(driver).sendKeys(AccountTestData.country);
			log.info(AccountTestData.country + ": is entered in country");

			Account.fax(driver).sendKeys(AccountTestData.fax);
			log.info(AccountTestData.fax + ": is entered in fax");

			Account.telephone(driver).sendKeys(AccountTestData.telephone);
			log.info(AccountTestData.telephone + ": is entered in telephone");

			//Click save button 
			Global.save_button(driver).click();
			log.info("Save button clicked");
			Thread.sleep(2000);

			//Search for created account
			Global.search_textbox(driver).click();
			Global.search_textbox(driver).sendKeys(accounName);
			log.info(accounName + ": is entered in search box");
			//Global.search_textbox(driver).sendKeys(Keys.ENTER);
			Thread.sleep(2000);

			//Search return created account
			Global.search_result(driver).click();
			Thread.sleep(5000);
			
//Creating a ship under selected account
			
			ShipswithoutIMOnumber.ships_menu(driver).click();
			log.info("Ships menu link clicked");
			Thread.sleep(10000);
			String ShipsHeaderTitle = ShipswithoutIMOnumber.ships_header_title(driver).getText();
			Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ships_text_header, ShipsHeaderTitle);
			log.info("Ships Header Title:  " + ShipsHeaderTitle);

			ShipswithoutIMOnumber.register_ship_button(driver).click();
			log.info("Register ship button clicked");
			Thread.sleep(5000);
			ShipswithoutIMOnumber.ships_without_IMO_number_menu_text(driver).click();
			log.info("Register ship without an IMO number is selected");

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
			Thread.sleep(5000);
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
			Thread.sleep(3000);
			
//Selecting the created account from the list
			
		
			// get all the radio buttons by similar id or xpath and store in List    
			List<WebElement> radioBx= driver.findElements(By.xpath("//div/div/div[2]/div[1]"));
			// This will tell us the number of radio button are present
			int iSize = radioBx.size();
			//This will iterate each link and click on it
			for (int i = 0; i < iSize ; i++){
			// Store the Check Box name to the string variable, using 'Value' attribute
			String sValue = radioBx.get(i).getAttribute("value");
			// Select the Check Box it the value of the Check Box is same what you are looking for
			    if (sValue.equalsIgnoreCase(accounName)){
			     radioBx.get(i).click();
			     // This will take the execution out of for loop
			        break;
			    }
			    
			   }
			
			log.info("The selected account for the ship is: " + accounName );
			
//Clicking on "Next" button
			
			By next_button = By.xpath("//div/div/div[3]/div/div/div/div[2]/button");
			
			getElement(next_button).click();
			
			
			
	
			
			
			

//========================	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*ShipswithoutIMOnumber.ships_without_IMO_number_select_account(driver).click();
			Thread.sleep(5000);
			String ship_account_selected = ShipswithoutIMOnumber.ships_without_IMO_number_account_selected(driver).getText();
			log.info("The account selected is: " + ship_account_selected);
			String fleet_count = ShipswithoutIMOnumber.ships_without_IMO_number_account_fleet_count(driver).getText();
			int fleet_count_int = Integer.parseInt(fleet_count);
			Thread.sleep(2000);

			Global.ship_next(driver).click();
			
			Thread.sleep(10000);

			if( fleet_count_int >= 1 ){
				Thread.sleep(2000);
				String select_ship_fleet_page_Title = Global.ships_page_title(driver).getText();
				Assert.assertEquals(ShipsTestDatawithoutIMOnumber.select_fleet_title, select_ship_fleet_page_Title);
				log.info("The select account page title is: " + select_ship_fleet_page_Title );
				Thread.sleep(2000);

				ShipswithoutIMOnumber.ships_without_IMO_number_select_fleet(driver).click();
				Thread.sleep(10000);

				String select_ship_fleet_selected = ShipswithoutIMOnumber.ships_without_IMO_number_select_fleet_selected(driver).getText();
				log.info("The fleet selected is: " + select_ship_fleet_selected);
				Thread.sleep(2000);

				Global.ship_next(driver).click();
				
				Thread.sleep(10000);
			}*/

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
			
			Thread.sleep(10000);
			ShipswithoutIMOnumber.ships_without_IMO_number_register_transceiver_model_selected(driver).click();
			Thread.sleep(10000);

			//ShipswithoutIMOnumber.ships_without_IMO_number_save(driver).click();

			/*String MMSI_number_required_validation_number = ShipswithoutIMOnumber.ships_without_IMO_number_register_transceiver_MMSI_validation_message(driver).getText();
			Assert.assertEquals(ShipsTestDatawithoutIMOnumber.register_transceiver_MMSI_validation_message, MMSI_number_required_validation_number);
			log.info("The validation message displayed is " + MMSI_number_required_validation_number );
			 */

			Thread.sleep(3000);

			log.info("Clicked on save button on the Register transceiver page");
			ShipswithoutIMOnumber.ships_without_IMO_number_save(driver).click();
			
			Thread.sleep(25000);
			log.info("Navigated back to \"Ships\" page");

			Thread.sleep(30000);
			String ShipsHeaderTitleafterregisteringtheship = ShipswithoutIMOnumber.ships_header_title(driver).getText();
			Assert.assertEquals(ShipsTestDatawithoutIMOnumber.ships_text_header, ShipsHeaderTitleafterregisteringtheship);
			log.info("Ships Header Title:  " + ShipsHeaderTitleafterregisteringtheship);
			Thread.sleep(30000);

			//Viewing the recently created ship
			log.info("Click on the \"Sort by name\" tab");
			ShipswithoutIMOnumber.ships_without_IMO_number_sort_by_name(driver).click();
			
			Thread.sleep(10000);
			log.info("Click on the \"Sort by most recently added\" link");
			ShipswithoutIMOnumber.ships_without_IMO_number_search_most_recently_created_ship(driver).click();
			Thread.sleep(15000);

			log.info("Entered the ship_name in the search field");
			ShipswithoutIMOnumber.ships_without_IMO_number_search_field(driver).sendKeys(ShipsTestDatawithoutIMOnumber.ship_name);
			Thread.sleep(30000);
			return false;
		}
		
	
		
		public Boolean newProfile() throws Exception{
			
			By sidepanel_iconshape_color = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/ps-accordion/div/ps-accordion-item[1]/div[1]/h4/ps-accordion-heading");
			
			By accounts_section = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/ps-accordion/div/ps-accordion-item[2]/div[1]/h4/ps-accordion-heading");
			By account_search = By.id("accountSearch");
			By account_search_result = By.cssSelector("body > psp-app > psp-core > div > ps-admin-component > ps-admin-ship-profiles > ps-admin-ship-profile-index > ps-ship-profile-detailview > aside > form > ps-accordion > div > ps-accordion-item:nth-child(2) > div.ps-accordion-item__body.panel-collapse.collapse.in.ng-tns-c9-7.ng-trigger.ng-trigger-accordionItemState.ps-accordion-item__body--overflow > div > ps-ship-profile-panel-accounts > div > div > div > ps-autocomplete > form > div > div > ul > li > a");
			
			By ships_section = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/ps-accordion/div/ps-accordion-item[3]/div[1]/h4");
			By ships_search = By.cssSelector("#shipFleetSearch");
			By ships_search_result = By.cssSelector("body > psp-app > psp-core > div > ps-admin-component > ps-admin-ship-profiles > ps-admin-ship-profile-index > ps-ship-profile-detailview > aside > form > ps-accordion > div > ps-accordion-item:nth-child(3) > div.ps-accordion-item__body.panel-collapse.collapse.in.ng-tns-c9-8.ng-trigger.ng-trigger-accordionItemState.ps-accordion-item__body--overflow > div > ps-ship-profile-panel-ship > div > div > div > ps-autocomplete > form > div > div > ul > li > a > span");
		
			By name_section = By.xpath("//ps-accordion-item[4]/div[1]/h4/ps-accordion-heading");
		    By name_textbox = By.cssSelector("#shipProfile_name");
		    By comment_textbox = By.cssSelector("#shipProfile_comment");
		    By profilename_search = By.xpath("//ps-admin-ship-profile-index/div[2]/div[1]/div[1]/div/form/ps-searchbox/div/input");
		    By search_contains = By.xpath("//ul/li/ps-ship-profile-list-details/a/div/div[2]/div[1]/span");
		    By profile_name = By.xpath("//ps-admin-ship-profile-index/div[2]/div[2]/ul/li[1]/ps-ship-profile-list-details/a/div/div[2]/div[1]/span");
		    By comment_text = By.xpath("//ul/li[1]/ps-ship-profile-list-details/a/div/div[2]/div[2]/div[2]");
		    By adminsitaration_link = By.cssSelector("#header__content-nav > div.application__top-menu > ul > li.admin > a");
			By adminsitaration_profiles = By.cssSelector("#application > div.layout-main > div.layout-list.admin.full > div.layout-application > div.application__content > div > div > div:nth-child(5) > a > div.title");
			By homepage_header = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[1]/h3");
			By homepage_sub_header = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[1]/p");
			By sortby_mostrecently_added = By.xpath("//ps-admin-ship-profile-index/div[2]/div[1]/div[2]/ps-option-dropdown/div/button");
			By sortby_name = By.cssSelector("#option-0");
			By noProfilesfound = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[2]/div");
			
			By newProfile = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[1]/div[1]/span/a");
		    
		    
           getElement(adminsitaration_link).click();
			
			verbose("administration link is clicked ");
			
			waitExplicitly(3);
			
			getElement(adminsitaration_profiles).click();
			
			verbose("Profiles link is clicked ");
			
//Clicking on nEw profile
			
			getElement(newProfile).click();
			
			verbose("Newprofile link is clicked ");
			
			  waitExplicitly(5);
		
			/*//Clicking on Icon shape & color
			  getElement(sidepanel_iconshape_color).click(); 
			  waitExplicitly(5);*/
			  
			  
			  
		//Selecting the Ship icon shape radio button option randamoly
			 By radio_option = By.name("icon");

					List<WebElement> elements = getDriver().findElements(radio_option);
					Random random = new Random();
				    int index = random.nextInt(elements.size());
				    elements.get(index).click(); 
			        
			  
		//Randomly selecting the Ship icon color
			  
			  int random1 = randInt(1,10);
				verbose("The random number selected is :" + random1);
				
				int selected_random = random1;
				
				if(random1 == 1){
					
					By blue_color = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[1]/ul/li[1]/p");
					
					
					getElement(blue_color).click();
					
					verbose("Blue color profiles is seclected");
				
				}else if(random1 == 2){
					By purple_color = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[1]/ul/li[2]/p");
					getElement(purple_color).click();
					verbose("Purple color profiles is seclected");
					
				}else if(random1 == 3){
					By teal_color = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[1]/ul/li[3]/p");
					getElement(teal_color).click();
					
					verbose("Teal color profiles is seclected");
					
				}else if(random1 == 4){
					
					By brown_color = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[1]/ul/li[4]/p");
					getElement(brown_color).click();
					
					verbose("Brown color profiles is seclected");
				}
				
		else if(random1 == 5){
					
					By black_color = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[1]/ul/li[5]/p");
					getElement(black_color).click();
					
					verbose("Black color profiles is seclected");
				}
				
		else if(random1 == 6){
			
			By lightblue_color = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[1]/ul/li[6]/p");
			getElement(lightblue_color).click();
			
			verbose("Light blue color profiles is seclected");
		}
		else if(random1 == 7){
			
			By magenta_color = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[1]/ul/li[7]/p");
			getElement(magenta_color).click();
			
			verbose("Magenta blue color profiles is seclected");
		}	
				
		else if(random1 == 8){
			
			By limegreen_color = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[1]/ul/li[8]/p");
			getElement(limegreen_color).click();
			
			verbose("Lime green blue color profiles is seclected");
		}	
		else if(random1 == 9){
			
			By olive_color = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[1]/ul/li[9]/p");
			getElement(olive_color).click();
			
			verbose("Olive blue color profiles is seclected");
		}else{		
			By grey_color = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[1]/ul/li[10]/p");
			getElement(grey_color).click();
			
			verbose("Grey color profiles is seclected");
				}
				
//Selecting the Account for the profile
				
		    waitExplicitly(5);
		    
		    verbose("clicking on Accounts section");
		    
		    getElement(accounts_section).click();
		    waitExplicitly(5);
				
			getElement(account_search).sendKeys(testDatas.Shipprofiles.accountName);	
			getElement(account_search_result).click();
			
//Selecting the ship for the profile
			
			waitExplicitly(5);
			
			getElement(ships_section).click();
			
			getElement(ships_search).sendKeys(testDatas.Shipprofiles.Ship_name);
			
			getElement(ships_search_result).click();
			
//Entering name into the profile name text box
			waitExplicitly(5);
			
			getElement(name_section).click();
			waitExplicitly(5);
			getElement(name_textbox).sendKeys(testDatas.Shipprofiles.profile_name);
			
//Entering comment into the comment text box
			
			getElement(comment_textbox).sendKeys(testDatas.Shipprofiles.profile_comment);
			waitExplicitly(5);
			
//Saving the profile
			
			By save = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/div/span/button");
			
			verbose("clicking on save");
			
			getElement(save).click();
			
			waitExplicitly(5);
			
//Searching for the created profile name	
			
			getElement(profilename_search).clear();
			waitExplicitly(5);
			getElement(profilename_search).sendKeys(testDatas.Shipprofiles.profile_name);
			waitExplicitly(5);
			String profilename_actual = getElement(search_contains).getText();
			Assert.assertEquals(profilename_actual, testDatas.Shipprofiles.profile_name);
			verbose("Profile is created successfully");	
			
			
			waitExplicitly(5);
//Validating the created profile
			
					
					getElement(search_contains).click(); 
					  waitExplicitly(2);
					  
					  String profile_name_left_actual = getElement(profile_name).getText();
					  verbose("Created Profile name from the left side panel is:" + profile_name_left_actual);
					  waitExplicitly(2);
					  
					  
					  //Assert.assertEquals(profile_name_left_actual, testDatas.Shipprofiles.profile_name);
					  
					  if(profile_name_left_actual == testDatas.Shipprofiles.profile_name)
					    {
					        verbose("Profile is not created");
					        return false;
					            }
					        else
					        {
					            verbose("Profile is created successfully");
					            return true;
					            
					        }
					  
					  

					  
					  
					
					  
					  /*String comment_text_left = getElement(comment_text).getText();
					  waitExplicitly(2);
					  verbose("comment text from left side panel is:" +comment_text_left); 
					  Assert.assertEquals(comment_text_left, testDatas.Shipprofiles.profile_comment);
					  
					  waitExplicitly(5);*/
				
//Validating the profile color
					  
		/*By selected_profile_color = By.cssSelector("body > psp-app > psp-core > div > ps-admin-component > ps-admin-ship-profiles > ps-admin-ship-profile-index > div.ps-app-page__content.full-page.have-details.breadcrumb-spacing.scroll > div.ps-list__content > ul > li > ps-ship-profile-list-details > a > div > div.ps-ship-profile-list-item__icon");
		
		//String selected_profile_color_actual = getElement(selected_profile_color).getAttribute("ng-reflect-class-name");
		
		String selected_profile_color_actual = getElement(selected_profile_color).getCssValue("color");
		
		verbose(selected_profile_color_actual); 
		
		String[] hexValue = selected_profile_color_actual.replace("rgba(", "").replace(")", "").split(",");
		 
		int hexValue1=Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2=Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3=Integer.parseInt(hexValue[2]);
		 
		String selected_profile_color_actual_final = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		 
			
		verbose(selected_profile_color_actual_final); */
		
					  /*if (selected_random == 1 && selected_profile_color_actual.contains("blue")){
						  verbose("Profile color is selected as Blue");
						  return true;
						  
				}
					  else if(selected_random == 2 && selected_profile_color_actual.contains("purple")){
						  verbose("Profile color is selected as Purple");
						  return true;
						  
				}
					  else if(selected_random == 3 && selected_profile_color_actual.contains("teal")){
						  verbose("Profile color is selected as Teal");
						  return true;
						  
				}
					  
					  else if(selected_random == 4 && selected_profile_color_actual.contains("brown")){
						  verbose("Profile color is selected as Brown");
						  return true;
						  
				}
					  
					  else if(selected_random == 5 && selected_profile_color_actual.contains("black")){
						  verbose("Profile color is selected as Black");
						  return true;
						  
				}
					  
					  else if(selected_random == 6 && selected_profile_color_actual.contains("lightblue")){
						  verbose("Profile color is selected as Lightblue");
						  return true;
						  
				}
					  
					  else if(selected_random == 7 && selected_profile_color_actual.contains("magenta")){
						  verbose("Profile color is selected as Magenta");
						  return true;
						  
				}
					  
					  else if(selected_random == 8 && selected_profile_color_actual.contains("limegreen")){
						  verbose("Profile color is selected as Lime green");
						  return true;
						  
				}
					  
					  else if(selected_random == 9 && selected_profile_color_actual.contains("olive")){
						  verbose("Profile color is selected as Olive");
						  return true;
						  
				}
					  else if(selected_random == 10 && selected_profile_color_actual.contains("gray")){
						  verbose("Profile color is selected as Gray");
						  return true;
						  
				}
					  else{
							return false;}*/
					  
					  
	
					  }
	
//Validating the Administration -> Ships -> Ship icon profile dropdown
		  

public Boolean verify_Shipiconprofiledropdown() throws Exception{
			
			By sidepanel_iconshape_color = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/ps-accordion/div/ps-accordion-item[1]/div[1]/h4/ps-accordion-heading");
			
			By accounts_section = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/ps-accordion/div/ps-accordion-item[2]/div[1]/h4/ps-accordion-heading");
			By account_search = By.id("accountSearch");
			By account_search_result = By.cssSelector("body > psp-app > psp-core > div > ps-admin-component > ps-admin-ship-profiles > ps-admin-ship-profile-index > ps-ship-profile-detailview > aside > form > ps-accordion > div > ps-accordion-item:nth-child(2) > div.ps-accordion-item__body.panel-collapse.collapse.in.ng-tns-c9-7.ng-trigger.ng-trigger-accordionItemState.ps-accordion-item__body--overflow > div > ps-ship-profile-panel-accounts > div > div > div > ps-autocomplete > form > div > div > ul > li > a");
			
			By ships_section = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/ps-accordion/div/ps-accordion-item[3]/div[1]/h4");
			By ships_search = By.cssSelector("#shipFleetSearch");
			By ships_search_result = By.cssSelector("body > psp-app > psp-core > div > ps-admin-component > ps-admin-ship-profiles > ps-admin-ship-profile-index > ps-ship-profile-detailview > aside > form > ps-accordion > div > ps-accordion-item:nth-child(3) > div.ps-accordion-item__body.panel-collapse.collapse.in.ng-tns-c9-8.ng-trigger.ng-trigger-accordionItemState.ps-accordion-item__body--overflow > div > ps-ship-profile-panel-ship > div > div > div > ps-autocomplete > form > div > div > ul > li > a > span");
		
			By name_section = By.xpath("//ps-accordion-item[4]/div[1]/h4/ps-accordion-heading");
		    By name_textbox = By.cssSelector("#shipProfile_name");
		    By comment_textbox = By.cssSelector("#shipProfile_comment");
		    By profilename_search = By.xpath("//ps-admin-ship-profile-index/div[2]/div[1]/div[1]/div/form/ps-searchbox/div/input");
		    By search_contains = By.xpath("//ul/li/ps-ship-profile-list-details/a/div/div[2]/div[1]/span");
		    By profile_name = By.xpath("//ps-admin-ship-profile-index/div[2]/div[2]/ul/li[1]/ps-ship-profile-list-details/a/div/div[2]/div[1]/span");
		    By comment_text = By.xpath("//ul/li[1]/ps-ship-profile-list-details/a/div/div[2]/div[2]/div[2]");
		    By adminsitaration_link = By.cssSelector("#header__content-nav > div.application__top-menu > ul > li.admin > a");
		    By ships_link = By.cssSelector("#application > div.layout-main > div.layout-list.admin.full > div.layout-application > div.application__content > div > div > div:nth-child(4) > a > div.title");
		    By search_ship = By.xpath("//ul/li[1]/form/div/div/input");
		    
		    By search_ship_results = By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/a/div");
		    
		    By iconprofile_dropdown = By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/form/div/div[3]/div/div/button/div/div[2]");
		    
			By adminsitaration_profiles = By.cssSelector("#application > div.layout-main > div.layout-list.admin.full > div.layout-application > div.application__content > div > div > div:nth-child(5) > a > div.title");
			By homepage_header = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[1]/h3");
			By homepage_sub_header = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[1]/p");
			By sortby_mostrecently_added = By.xpath("//ps-admin-ship-profile-index/div[2]/div[1]/div[2]/ps-option-dropdown/div/button");
			By sortby_name = By.cssSelector("#option-0");
			By noProfilesfound = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[2]/div");
			
			By newProfile = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[1]/div[1]/span/a");
			
			//Navigating to Admisitration link
			
			getElement(adminsitaration_link).click();
			
			verbose("Administration link is clicked"); 
			  waitExplicitly(5);
			
			
			  
			  
			
			  getElement(ships_link).click();
				verbose("Ships link is clicked"); 
				
				  waitExplicitly(5);
				  
				//Searching for the ship which got ship profile created in above steps
				  
				  getElement(search_ship).click();
				 
					
				  waitExplicitly(2);
				  
				  getElement(search_ship).sendKeys(testDatas.Shipprofiles.Ship_name);
				  
	//selecting the ship from the search results
				  
				  waitExplicitly(5);
				  
				  getElement(search_ship_results).click();
				  
				  verbose("Ship is selected from the search results"); 
				  
	//Validating the Ship icon profile dropdown value
				  
				  waitExplicitly(5);
				  
				//Getting the text from the ship icon profile dropdown
				  
				 String default_profilename = getElement(iconprofile_dropdown).getText();
				 
				 Assert.assertEquals(testDatas.Shipprofiles.Ship_name, default_profilename);
				 verbose("By default 'Ship icon profile dropdown' has current profile applied to the ship "); 
			
			return null;
		    
			
}
							
					  	
						
						public static int randInt(int min, int max) {

							Random rand = new Random();

							int randomNum = rand.nextInt((max - min) + 1) + min;

							return randomNum;
						}

							}
