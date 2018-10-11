package shipProfiles;


	import java.util.Random;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

//import Notification_resources.BasePage;
//import Notification_resources.LoginPage;

import scriptResources.*;

	/**
	 * @author sreedhar.popuri
	 *
	 */
	public class ShipProfiles_Homepage extends BasePage {
		
		public ShipProfiles_Homepage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
		LoginPage loginPage = new LoginPage(getDriver());
		
		By adminsitaration_link = By.cssSelector("#header__content-nav > div.application__top-menu > ul > li.admin > a");
		By adminsitaration_profiles = By.cssSelector("#application > div.layout-main > div.layout-list.admin.full > div.layout-application > div.application__content > div > div > div:nth-child(5) > a > div.title");
		
		By homepage_header = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[1]/h3");
		By homepage_sub_header = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[1]/p");
		By sortby_mostrecently_added = By.xpath("//ps-admin-ship-profile-index/div[2]/div[1]/div[2]/ps-option-dropdown/div/button");
		By sortby_name = By.cssSelector("#option-0");
		By noProfilesfound = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[2]/div");
		
		public String homepage_header_title =  "Profiles";
		public String homepage_sub_header_title = "View, edit or create a ship profile";
		
		// Navigate to Ship profiles page
		
		public boolean navigateToProfiles() {
			waitExplicitly(2);
			
			getElement(adminsitaration_link).click();
			
			verbose("administration link is clicked ");
			
			waitExplicitly(3);
			
			getElement(adminsitaration_profiles).click();
			
			verbose("Profiles link is clicked ");
			
// Validating the ship profiles Header and sub			
			
			if (getElement(homepage_header).getText().equals(homepage_header_title)) {
				verbose("Logged into Ship profiles page successfully!");
				return true;
			} else {
				return false;
			}
		}

// Validating the default values present on the ship profiles page
	
		public boolean profilesDefaultsorted() {
			waitExplicitly(1);		
			By date1 = By.xpath("//ul/li[1]/ps-ship-profile-list-details/a/div/div[2]/div[3]/div[2]");		
			String newdate1 = getElement(date1).getText();
			verbose("The new date1 is :" + newdate1);
			String datetime1 = newdate1.substring(0, 17);
			verbose("datetime1 is:" + datetime1);
			By date2 = By.xpath("//ul/li[2]/ps-ship-profile-list-details/a/div/div[2]/div[3]/div[2]");
			String newdate2 = getElement(date2).getText();
			verbose("The new date2 is :" + newdate2);
			String datetime2 = newdate2.substring(0, 17);
			verbose("datetime2 is:" + datetime2);
			By date3 = By.xpath("//ul/li[3]/ps-ship-profile-list-details/a/div/div[2]/div[3]/div[2]");
			String newdate3 = getElement(date3).getText();
			verbose("The new date3 is :" + newdate3);
			String datetime3 = newdate3.substring(0, 17);
			verbose("datetime3 is:" + datetime3);
			if (datetime1.compareTo(datetime2)>0 || datetime2.compareTo(datetime3)>0) {
				verbose("Ship profiles are 'Sort by most recently added' by default");
				return true;
			}else if(datetime1.compareTo(datetime2)<0 || datetime2.compareTo(datetime3)<0){
				verbose("Ship profiles are not 'Sort by most recently added' by default");
				return false;
			}else if(noProfilesfound.equals("No profiles found.")){
				verbose("No ship profiles found.");
				return true;
			}
			else{		
					return false;
			}
			
		}
		
// Validating the Sort by name
		
		public Boolean sortbyName() {
			waitExplicitly(1);
			By first_name = By.xpath("//ul/li[1]/ps-ship-profile-list-details/a/div/div[2]/div[1]/span");
			By second_name = By.xpath("//ul/li[2]/ps-ship-profile-list-details/a/div/div[2]/div[1]/span");
			
			waitExplicitly(1);
			verbose("Clicking on sorting drop down");
			getElement(sortby_mostrecently_added).click();
			waitExplicitly(1);
			getElement(sortby_name).click();
			verbose("Selecting Sort by name from the drop down");
			String first_name_text = getElement(first_name).getText();
			
			String second_name_text = getElement(second_name).getText();
		
			int compare = first_name_text.compareToIgnoreCase(second_name_text);
			if (compare < 0) {
				verbose("Ship profiles are sorted by Name");
				return true;
			}else if(compare > 0){
				return false;
			}else{
				return true;
			}
		}
		
//Search Ship profiles
		
		public Boolean searchshipProfile() {
			waitExplicitly(1);
			String name = "Pole Star account Profile";
			By searchBox = By.xpath("//ps-searchbox/div/input");		
			By search_contains = By.xpath("//ul/li/ps-ship-profile-list-details/a/div/div[2]/div[1]/span");
			waitExplicitly(2);
			getElement(searchBox).clear();
			waitExplicitly(2);
			getElement(searchBox).click();
			verbose("Typing in the search box....");
			waitExplicitly(3);
			getElement(searchBox).sendKeys(name);
			waitExplicitly(2);
			if(getElement(search_contains).getText().equals(name)){
				verbose("Search is successful");	
				return true;
			}else{
				return false; 
			}
		}

	
	
		
//Verify user can view existing ship profile
		
		  public boolean sidepanel(){
			  String name = "Pole Star account Profile";
			  By searchBox = By.xpath("//ps-searchbox/div/input");	
			
		  
		  By search_select = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[2]/ul/li[1]/ps-ship-profile-list-details/a");
		  By profile_name = By.xpath("//ps-admin-ship-profile-index/div[2]/div[2]/ul/li[1]/ps-ship-profile-list-details/a/div/div[2]/div[1]/span");
		  By Shipicon_color_leftpanel = By.xpath("//ps-admin-component/div/div/ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[2]/ul/li/ps-ship-profile-list-details/a/div/div[1]/div");
		  
		  
		  
		  By comment_text = By.xpath("//ul/li[1]/ps-ship-profile-list-details/a/div/div[2]/div[2]/div[2]");
		  By sidepanel_title = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/h4");
		  By sidepanel_iconshape_color = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/ps-accordion/div/ps-accordion-item[1]/div[1]/h4/ps-accordion-heading");
	      By sidepanel_ship_icon_shape = By.xpath("//ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/ps-accordion/div/ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[1]/h4");
		  By sidepanel_ship_icon_color = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/ps-accordion/div/ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/h4");
		  By sidepanel_ship_icon_color_option = By.xpath("//div[1]/ul/li[1]/div");	
		  By priview_map = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[2]");	
		  By priview_map_iconshappe_color = By.xpath("//ps-admin-component/div/div/ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/ps-accordion/div/ps-accordion-item[1]/div[2]/div/ps-ship-profile-panel-icons/div/div/div[2]/div[2]/div/svg");
		  


		  By sidepanel_accounts = By.xpath("//ps-accordion-item[2]/div[1]/h4/ps-accordion-heading");
		  By sidepanel_accounts_title = By.xpath("//div[2]/div/ps-ship-profile-panel-accounts/div/label");
		  By sidepanel_accounts_sub_title = By.xpath("//div[2]/div/ps-ship-profile-panel-accounts/div/p");
		  By sidepanel_accounts_search_title = By.xpath("//div[2]/div/ps-ship-profile-panel-accounts/div/div/div/ps-autocomplete/form/div/label");
		  By sidepanel_account_delete_x = By.xpath("//div[2]/div/ps-ship-profile-panel-accounts/div/div/ul/li/button/span");
		  By sidepanel_ships = By.xpath("//ps-accordion-item[3]/div[1]/h4/ps-accordion-heading");
		  By sidepanel_ships_title = By.xpath("//ps-accordion-item[3]/div[2]/div/ps-ship-profile-panel-ship/div/label");
		  By sidepanel_ships_sub_title = By.xpath("//ps-accordion-item[3]/div[2]/div/ps-ship-profile-panel-ship/div/p");
		  By sidepanel_ships_search_title = By.xpath("//ps-ship-profile-panel-ship/div/div/div/ps-autocomplete/form/div/label");
		  By sidepanel_ships_search_text = By.id("shipFleetSearch");
		  By sidepanel_name = By.xpath("//ps-accordion/div/ps-accordion-item[4]/div[1]/h4/ps-accordion-heading");
		  By sidepanel_name_title = By.xpath("//ps-ship-profile-panel-name/div/div/div[1]/label");
		  By sidepanel_name_sub_title = By.xpath("//ps-ship-profile-panel-name/div/div/div[1]/div");
		  By sidepanel_shipProfile_name = By.cssSelector(" #shipProfile_name");
		 
		  By sidepanel_name_comment = By.xpath("//ps-accordion-item[4]/div[2]/div/ps-ship-profile-panel-name/div/div/div[2]/label");
		  By sidepanel_comment_text = By.id("shipProfile_comment");
		  
		  By sidepanel_Iconshape_sessioncircle = By.xpath("//ps-accordion/div/ps-accordion-item[1]/div[1]/h4/ps-accordion-heading/div");
		  By sidepanel_name_sessioncircle = By.xpath("//ps-accordion/div/ps-accordion-item[4]/div[1]/h4/ps-accordion-heading/div");
		  
		  By sidepanel_save = By.xpath("//ps-ship-profile-detailview/aside/form/div/button");
		  waitExplicitly(2);
	
//Selecting the profile from the search results
		 /* getElement(searchBox).sendKeys(name);*/
		  getElement(search_select).click(); 
		  waitExplicitly(2);
//Getting the ship icon & color for the profile
		  String Profile_color_actual = getElement(Shipicon_color_leftpanel).getCssValue("color");
		  verbose("Profile color is : " + Profile_color_actual);
		  String hex = Color.fromString(Profile_color_actual).asHex();
		  verbose("Profile color of hex is : " + hex);
		  System.out.println(hex);
//validating the right side panel header title
		  String sidepanel_title_actual = getElement(sidepanel_title).getText();
		  Assert.assertEquals(sidepanel_title_actual, "Edit Profile");
		  logger.info("User can see Edit profile upon slecting the profile from the list");
		  waitExplicitly(2);
//Clicking on Icon shape & color
		  getElement(sidepanel_iconshape_color).click(); 
		  waitExplicitly(2);
//Validating the Ship icon shape
		  String sidepanel_ship_icon_shape_actual = getElement(sidepanel_ship_icon_shape).getText();
		  Assert.assertEquals(sidepanel_ship_icon_shape_actual, "Ship icon shape:");
		  logger.info("User can see the Ship icon shapes under 'Icon shape & color' section");
		  waitExplicitly(2);
//Validating the Ship icon color
		  
		  for(int i=1; i<=10; i++){
				String ship_icon_color_option_path= "//div[1]/ul/li[" + i +  "]/div";

				By ship_icon_color_option_path_for= By.xpath(ship_icon_color_option_path);

	                       String sidepanel_color = getElement(ship_icon_color_option_path_for).getCssValue("color");
	                       String class_name_contains = "selected";
	                    
	                        String class_name = getElement(ship_icon_color_option_path_for).getAttribute("class");
				if(sidepanel_color.equals(Profile_color_actual) && class_name.contains(class_name_contains)){

					verbose("Icon color & shape matches");
	                                return true;

				}else{
					i++;
					break;

				}

			}
		  waitExplicitly(2);
//Validating the preview map
	
		  /*String previewmap_iconshapecolor_actual = getElement(priview_map_iconshappe_color).getCssValue("color");
		  Assert.assertEquals(Profile_color_actual, previewmap_iconshapecolor_actual);
		  logger.info("Ship profile icon & shape is matches with preview map");*/
		  
//Validating the Accounts section
		  
		  getElement(sidepanel_accounts).click(); 
		  verbose("Click on Accounts...");
		  waitExplicitly(2);
		  String sidepanel_accounts_title_actual = getElement(sidepanel_accounts_title).getText();
		  Assert.assertEquals(sidepanel_accounts_title_actual, "Add Accounts to this profile.");
		  waitExplicitly(2);
		  verbose("The Accounts section tilte is getting displayed as : " + sidepanel_accounts_title_actual);
		  waitExplicitly(2);
		  String sidepanel_accounts_sub_title_actual = getElement(sidepanel_accounts_sub_title).getText();
		  waitExplicitly(2);
		  Assert.assertEquals(sidepanel_accounts_sub_title_actual, "Profiles applied to ships take precedence over profiles applied to accounts.");
		  waitExplicitly(2);
		  verbose("The Accounts section sub_tilte is getting displayed as : " + sidepanel_accounts_sub_title_actual); 
		  waitExplicitly(2);
		  String sidepanel_accounts_search_title_actual = getElement(sidepanel_accounts_search_title).getText();
		  waitExplicitly(2);
		  Assert.assertEquals(sidepanel_accounts_search_title_actual, "Search for account(s):");
		  waitExplicitly(2);
		  verbose("The Accounts section searech is getting displayed as : " + sidepanel_accounts_search_title_actual); 
		  waitExplicitly(2);
		  waitExplicitly(2);
//Validating the Ships section
		  
		  getElement(sidepanel_ships).click(); 
		  waitExplicitly(2);
		  verbose("Click on Ships...");
		  String sidepanel_ships_title_actual = getElement(sidepanel_ships_title).getText();
		  waitExplicitly(2);
		  Assert.assertEquals(sidepanel_ships_title_actual, "Add ships to this profile.");
		  waitExplicitly(2);
		  verbose("The Ships section tilte is getting displayed as : " + sidepanel_ships_title_actual); 
		  waitExplicitly(2);
		  String sidepanel_ships_sub_title_actual = getElement(sidepanel_ships_sub_title).getText();
		  waitExplicitly(2);
		  Assert.assertEquals(sidepanel_ships_sub_title_actual, "Profiles applied to ships take precedence over profiles applied to accounts.");
		  waitExplicitly(2);
		  verbose("The Shipss section sub_tilte is getting displayed as : " + sidepanel_ships_sub_title_actual); 
		  waitExplicitly(2);
		  String sidepanel_ships_search_title_actual = getElement(sidepanel_ships_search_title).getText();
		  waitExplicitly(2);
		  Assert.assertEquals(sidepanel_ships_search_title_actual, "Search for ships:");
		  waitExplicitly(2);
		  verbose("The Ships section searech is getting displayed as : " + sidepanel_ships_search_title_actual); 
		  waitExplicitly(2);
		  String sidepanel_ships_search_text_actual = getElement(sidepanel_ships_search_text).getText();
		  waitExplicitly(2);
		  /*Assert.assertEquals(sidepanel_ships_search_text_actual, "Ship IMO number, ship name or fleet name");*/
		  waitExplicitly(2);
		  verbose("The Ships section searech text is getting displayed as : " + sidepanel_ships_search_text_actual); 
		  waitExplicitly(2);
//Validating the Name & Comment section
		  
		  getElement(sidepanel_name).click(); 
		  waitExplicitly(2);
		  verbose("Click on Name & Comment...");
		  waitExplicitly(2);
		  String sidepanel_name_title_actual = getElement(sidepanel_name_title).getText();
		  waitExplicitly(2);
		  Assert.assertEquals(sidepanel_name_title_actual, "Name this profile: *");
		  waitExplicitly(2);
		  verbose("The Name & comment section tilte is getting displayed as : " + sidepanel_name_title_actual); 
		  waitExplicitly(2);
		  String sidepanel_name_sub_title_actual = getElement(sidepanel_name_sub_title).getText();
		  waitExplicitly(2);
		  Assert.assertEquals(sidepanel_name_sub_title_actual, "Give the profile a unique name so that you can easily find, apply, or edit it later");
		  waitExplicitly(2);
		  verbose("The Name & Comment section sub_tilte is getting displayed as : " + sidepanel_name_sub_title_actual); 
		  waitExplicitly(2);
		  String profile_name_left_actual = getElement(profile_name).getText();
		  verbose("Profile name from the left side panel is:" + profile_name_left_actual);
		  waitExplicitly(2);
		  String profile_name_right_actual = getElement(sidepanel_shipProfile_name).getAttribute("ng-reflect-model");
		  verbose("Profile name from the right side panel is:" + profile_name_right_actual);
		  waitExplicitly(2);
		  Assert.assertEquals(profile_name_left_actual, profile_name_right_actual);
		  waitExplicitly(2);
		  verbose("Profile name is matches"); 
		  String sidepanel_name_comment_actual = getElement(sidepanel_name_comment).getText();
		  waitExplicitly(2);
		  Assert.assertEquals(sidepanel_name_comment_actual, "Comment:");
		  verbose("User can enter commants into Comment text box"); 
		  String comment_text_left = getElement(comment_text).getText();
		  waitExplicitly(2);
		  verbose("comment text from left side panel is:" +comment_text_left); 
		  String comment_text_right = getElement(sidepanel_comment_text).getAttribute("ng-reflect-model");
		  verbose("comment text from right side panel is:" +comment_text_right); 
		  Assert.assertEquals(comment_text_left, comment_text_right);
		  waitExplicitly(2);
		  verbose("User can see the existing comments for the selected profile"); 
		  waitExplicitly(2);
		  
		  
//Validating the Session complete sections for both mandatory sections - Icon shape & color 	  
		  
		  
		  getElement(sidepanel_iconshape_color).click();
		  
		  verbose("Icon shape & color expanded");
		  waitExplicitly(2);	
		  
		 /* By recipientdelete = By.xpath("//ps-notification-panel-recipients/ul/li/button/span");
		  verbose(" found receipt delete");
		
		  getElement(recipientdelete).click();
		  
		  verbose("receipt delete clicked");*/
		  
		  Actions action = new Actions(getDriver());
		  WebElement tool_tip = getElement(sidepanel_Iconshape_sessioncircle);
		  action.moveToElement(tool_tip).build().perform();
		  String tool_tip_text = tool_tip.getAttribute("data-tooltip");
		  
		  verbose("The tool-tip is: " + tool_tip_text);
		  Assert.assertEquals(tool_tip_text, "Section complete");
		  
			  verbose("Icon shape & color session is complete by default, i.e expected");
		  
		  
//Validating the Session complete sections for both mandatory sections - Name & comment		  
		  
		  waitExplicitly(2);
		  
		  getElement(sidepanel_name).click();
		  
		  verbose("Name & comment section is expanded");
		  waitExplicitly(2);	
		  
		 /* By recipientdelete = By.xpath("//ps-notification-panel-recipients/ul/li/button/span");
		  verbose(" found receipt delete");
		
		  getElement(recipientdelete).click();
		  
		  verbose("receipt delete clicked");*/
		  
		  Actions action1 = new Actions(getDriver());
		  WebElement tool_tip1 = getElement(sidepanel_name_sessioncircle);
		  action1.moveToElement(tool_tip1).build().perform();
		  String tool_tip_text1 = tool_tip1.getAttribute("data-tooltip");
		  
		  verbose("The tool-tip is: " + tool_tip_text1);
		  
		  Assert.assertEquals(tool_tip_text1, "Section complete");
		  
		  verbose("Icon shape & color session is complete by default, i.e expected");
	 
		  
		  
//Validating the Session incomplete sections for both mandatory sections - Name & comment		  
		  
		  waitExplicitly(2);	

		 /* By recipientdelete = By.xpath("//ps-notification-panel-recipients/ul/li/button/span");
		  verbose(" found receipt delete");
		
		  getElement(recipientdelete).click();
		  
		  verbose("receipt delete clicked");*/
		  
		  //removing the profile name from the Name this profile text field
          getElement(sidepanel_iconshape_color).click();
		  
		  verbose("Icon shape & color expanded");
		  waitExplicitly(2);	
		  
          getElement(sidepanel_name).click();
		  
		  verbose("Name & comment section is expanded");
		  waitExplicitly(2);
		  
		  getElement(sidepanel_shipProfile_name).click();
		  waitExplicitly(2);
		  
		  getElement(sidepanel_shipProfile_name).clear();
		  waitExplicitly(3);	
		  
		  getElement(sidepanel_shipProfile_name).sendKeys("12");
		  getElement(sidepanel_comment_text).click();
		  
		  By warning_char_length = By.xpath("//div/ps-accordion-item[4]/div[2]/div/ps-ship-profile-panel-name/div/div/div[1]/p");
		  
		  String warning_char_length_actual = getElement(warning_char_length).getText();
		   
		  Assert.assertEquals(warning_char_length_actual, "Chose between 3 and 40 characters");
		  
		  verbose("If profile name is less than 3 charcters then a warning message is getting displayed as: " + warning_char_length_actual);
		  waitExplicitly(3);	
		  
		  Actions action2 = new Actions(getDriver());
		  WebElement tool_tip2 = getElement(sidepanel_name_sessioncircle);
		  action2.moveToElement(tool_tip2).build().perform();
		  String tool_tip_text2 = tool_tip2.getAttribute("data-tooltip");
		  
		  verbose("The tool-tip is: " + tool_tip_text2);
		  
		  if(tool_tip_text2.equals("Section complete") && getElement(sidepanel_save).isEnabled())
			  {
			  verbose("Name & comment session is showing as seeeion complete, even if the mandatory data is missing, i.e failed");
		  return false;
		  
		  }else{
			  verbose("Name & comment session is incomplete if the mandatory data is missing, i.e expected");
			  return true; 
			    
		  }
		  
		  }	  	

	}

