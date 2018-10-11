package shipProfiles;

import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.support.Color;

//import Notification_resources.BasePage;
//import Notification_resources.LoginPage;

import scriptResources.*;

	/**
	 * @author sreedhar.popuri
	 *
	 */

public class ShipProfiles_Editprofile extends BasePage{
	
	public ShipProfiles_Editprofile(WebDriver driver) {
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
	
	public String Profilename_edit =  "Polestar_profile_edit";
	public String Profilecomment_edit =  "Polestar_comment_edit";
	
	// Navigate to Ship profiles page
	
	public boolean navigateToProfiles() {
		waitExplicitly(2);
		
		getElement(adminsitaration_link).click();
		
		verbose("administration link is clicked ");
		
		waitExplicitly(3);
		
		getElement(adminsitaration_profiles).click();
		
		verbose("Profiles link is clicked ");
		
//Validating the ship profiles Header and sub			
		
		if (getElement(homepage_header).getText().equals(homepage_header_title)) {
			verbose("Logged into Ship profiles page successfully!");
			return true;
		} else {
			return false;
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
		getElement(searchBox).sendKeys(testDatas.Shipprofiles.profile_name);
		waitExplicitly(2);
		if(getElement(search_contains).getText().equals(testDatas.Shipprofiles.profile_name)){
			verbose("Search is successful");	
			return true;
		}else{
			return false; 
		}
	}


	
//Verify user can view existing ship profile
	
	  public boolean shipiconshape_radio_options(){
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
	  
//Clicking on Icon shape & color
	  getElement(sidepanel_iconshape_color).click(); 
	  waitExplicitly(2);
	  
//Validating at least one radio button option is selected from the ship icon shape radio button options
	 By radio_option = By.name("icon");

			List<WebElement> elements = getDriver().findElements(radio_option);
			// apply the for loop to identify/ verify if a radio button is selected or not
			int count = 0;
			int radiobutton_size = elements.size();
			verbose("No of radio button options are : " + radiobutton_size);
	        for(int i=1;i<=radiobutton_size;i++){
	            verbose("attribut value Selected of radio button is : " + elements.get(i).getAttribute("ng-reflect-checked"));
	            // if radio button is selected then value of selected attribute is True else null
	            if (elements.get(i).getAttribute("ng-reflect-checked").equals("null")){
	            	
	            count ++;
	            }
	            break;
	        }
	        
	        if (count <= 9){
	       verbose("Only one radio button option is selected");
	       return true;
	            }
	        else {
	        	verbose("Radio button selection is wrong");
	        	return false;
	        }
	        
	  }      

	  
	  public Boolean editProfile() throws Exception{
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
	  By search_contains = By.xpath("//ul/li/ps-ship-profile-list-details/a/div/div[2]/div[1]/span");
	 
	  By sidepanel_name_comment = By.xpath("//ps-accordion-item[4]/div[2]/div/ps-ship-profile-panel-name/div/div/div[2]/label");
	  By sidepanel_comment_text = By.id("shipProfile_comment");
	  
	  By sidepanel_Iconshape_sessioncircle = By.xpath("//ps-accordion/div/ps-accordion-item[1]/div[1]/h4/ps-accordion-heading/div");
	  By sidepanel_name_sessioncircle = By.xpath("//ps-accordion/div/ps-accordion-item[4]/div[1]/h4/ps-accordion-heading/div");
	  
	  By sidepanel_save = By.xpath("//ps-ship-profile-detailview/aside/form/div/button");
	  
	  By Save_button = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/div/span/button");
	  
	  waitExplicitly(2);

//Selecting the profile from the search results
	 /* getElement(searchBox).sendKeys(name);*/
	  getElement(search_select).click(); 
	  waitExplicitly(2);

	  
//Clicking on Icon shape & color
	  getElement(sidepanel_iconshape_color).click(); 
	  waitExplicitly(2);
	  
	  
	  
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
    
		
//Editing the Name & comment section
		
		  waitExplicitly(2);	
		  getElement(sidepanel_name).click(); 
		  waitExplicitly(2);
		  verbose("Click on Name & Comment...");
		  waitExplicitly(2);
		  
		  getElement(sidepanel_shipProfile_name).clear();
		  getElement(sidepanel_shipProfile_name).sendKeys(testDatas.Shipprofiles.Profile_name_edit);
		  
		  //Editing the comment section
		  
		  
		  getElement(sidepanel_comment_text).clear();
		  getElement(sidepanel_comment_text).sendKeys(Profilecomment_edit);
		  
//Saving the changes
		  verbose("Click on save...");
		 getElement(Save_button).click();
		 waitExplicitly(2);
		 verbose("Profile is saved successfully...");
		 waitExplicitly(3);
		 
//Validating the changes
		 
		//Searching for the edited profile name 
		 getElement(searchBox).click();
		 getElement(searchBox).clear();
			verbose("Typing in the search box....");
			waitExplicitly(3);
			getElement(searchBox).sendKeys(testDatas.Shipprofiles.Profile_name_edit);
			waitExplicitly(2);
			if(getElement(search_contains).getText().equals(testDatas.Shipprofiles.Profile_name_edit)){
				
				waitExplicitly(2);
				verbose("Selecting the profile from the search results");	
				
				getElement(search_select).click(); 
				  waitExplicitly(2);
				  
				  String profile_name_left_edit_actual = getElement(profile_name).getText();
				  verbose("Edited Profile name from the left side panel is:" + profile_name_left_edit_actual);
				  waitExplicitly(2);
				  Assert.assertEquals(profile_name_left_edit_actual, testDatas.Shipprofiles.Profile_name_edit);
				  waitExplicitly(2);
				  String comment_text_edited_left = getElement(comment_text).getText();
				  waitExplicitly(2);
				  verbose("Edited comment text from left side panel is:" +comment_text_edited_left); 
				  Assert.assertEquals(comment_text_edited_left, Profilecomment_edit);
				  waitExplicitly(2);
				  
				  if(profile_name_left_edit_actual == testDatas.Shipprofiles.Profile_name_edit)
				    {
				        verbose("Profile is not edited");
				        return false;
				            }
				        else
				        {
				            verbose("Profile is edited sussessfully");
				            return true;
				        }
			}
			return null;	
			
				 //Validating the profile color
				  
	/*By edited_profile_color = By.xpath("//ps-admin-ship-profile-index/div[2]/div[2]/ul/li[1]/ps-ship-profile-list-details/a/div/div[1]/div");
	
	String edited_profile_color_actual = getElement(edited_profile_color).getAttribute("ng-reflect-class-name");
	
		
	
				  if (selected_random == 1 && edited_profile_color_actual.contains("blue")){
					  verbose("Profile color is edited to Blue");
					  return true;
					  
			}
				  else if(selected_random == 2 && edited_profile_color_actual.contains("purple")){
					  verbose("Profile color is edited to Purple");
					  return true;
					  
			}
				  else if(selected_random == 3 && edited_profile_color_actual.contains("teal")){
					  verbose("Profile color is edited to Teal");
					  return true;
					  
			}
				  
				  else if(selected_random == 4 && edited_profile_color_actual.contains("brown")){
					  verbose("Profile color is edited to Brown");
					  return true;
					  
			}
				  
				  else if(selected_random == 5 && edited_profile_color_actual.contains("black")){
					  verbose("Profile color is edited to Black");
					  return true;
					  
			}
				  
				  else if(selected_random == 6 && edited_profile_color_actual.contains("lightblue")){
					  verbose("Profile color is edited to Lightblue");
					  return true;
					  
			}
				  
				  else if(selected_random == 7 && edited_profile_color_actual.contains("magenta")){
					  verbose("Profile color is edited to Magenta");
					  return true;
					  
			}
				  
				  else if(selected_random == 8 && edited_profile_color_actual.contains("limegreen")){
					  verbose("Profile color is edited to Lime green");
					  return true;
					  
			}
				  
				  else if(selected_random == 9 && edited_profile_color_actual.contains("olive")){
					  verbose("Profile color is edited to Olive");
					  return true;
					  
			}
				  else if(selected_random == 10 && edited_profile_color_actual.contains("gray")){
					  verbose("Profile color is edited to Gray");
					  return true;
					  
			}
				  else{
			return false;}
	  }
			return (Boolean) null;*/
				  
	  }
		public static int randInt(int min, int max) {

			Random rand = new Random();

			int randomNum = rand.nextInt((max - min) + 1) + min;

			return randomNum;
		}

			}

