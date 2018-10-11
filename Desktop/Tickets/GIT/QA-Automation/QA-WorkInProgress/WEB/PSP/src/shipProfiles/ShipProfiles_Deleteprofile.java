package shipProfiles;

import java.awt.Robot;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import Notification_resources.BasePage;
//import Notification_resources.LoginPage;

import scriptResources.*;
import shipProfiles.ShipProfiles_Editprofile;

public class ShipProfiles_Deleteprofile extends BasePage{
	
		
		public ShipProfiles_Deleteprofile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		LoginPage loginPage = new LoginPage(getDriver());
		
		 public Boolean deleteProfile(WebDriver driver) throws Exception{
			 
			 By searchBox = By.xpath("//ps-searchbox/div/input");	
				
			  
			  By search_select = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[2]/ul/li[1]/ps-ship-profile-list-details/a");
			  
			  
			  By profiles_link = By.xpath("//psp-core/div/ps-admin-component/ng-component/div/div/div/ul/li[5]/a");
			  
			  By delete = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/ps-ship-profile-detailview/aside/form/div/a[1]");
			  
	
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
    
    
    By noprofile_found = By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[2]/div");
    
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
	  
	  ////Navigating to Profiles
	  
	  
	  verbose("Naqvigating to the profiles page"); 
	  
	  getElement(profiles_link).click();
	  
	  waitExplicitly(5);
	  
	  //Entering the ship name into search box
	  
	  getElement(searchBox).click();
	  
	  getElement(searchBox).sendKeys(testDatas.Shipprofiles.Profile_name_edit);
	  
	  waitExplicitly(5);
	  
	 //Selecting the ship from the search results 
	  
getElement(search_select).click();
	  
	  waitExplicitly(5);
	  
//Deleting the profile
	  
getElement(delete).click();
	  
	  waitExplicitly(5);  
	  
	  Alert alert_test = driver.switchTo().alert();

	  alert_test.accept();
	
	  
	  waitExplicitly(5); 
	  
//Validating whether profile is deleted or not
	  
getElement(searchBox).click();

getElement(searchBox).clear();
	  
	  getElement(searchBox).sendKeys(testDatas.Shipprofiles.Profile_name_edit);
	  
	  waitExplicitly(5); 
	  
	  String norpfofiles_message = getElement(noprofile_found).getText();
	  
	  Assert.assertEquals(norpfofiles_message, "No profiles found.");
	  waitExplicitly(2);
	  
	  
	  verbose("Profile is deleted sussessfully"); 
	  
	return null;
	

}
}