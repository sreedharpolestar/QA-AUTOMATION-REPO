package notifications;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import scriptResources.*;

public class NotificationsAMVER extends NotificationsZonesPage {
	
	public void log4j()
	{
		
		String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
        System.out.println("initialized log4j configuration");	
        Logger log = Logger.getLogger("Logger");
        
	}
	
	public NotificationsAMVER(WebDriver driver) {
		super(driver);
	
	}
	
// Specifying the element locators and creating string parameters for AMVER notifications
	
	/*By AMVER = By.cssSelector("body > psp-app > ps-notifications > ps-notification-create > div > ps-notification-create-type-step > div > div.ps-app-page__content.full-page.have-details.scroll > div.panels > ps-notification-create-type-selector > div > ul > li:nth-child(9) > div.notification-icon.btn-profileType.notification-icon--amver");*/
	By Next_button = By.xpath("//div/div[2]/div/div/a[2]");
	By Name_text_field = By.cssSelector("#notification_name");
	By Name_header = By.xpath("//ps-notification-detailview/aside/form/ps-accordion/div/ps-accordion-item[2]/div[1]/h4/ps-accordion-heading");
	
	
	

	public String  AMVER_specific_notification = "AMVER_Automated_notification_profile_specific_setting";
	public String  AMVER_specific_notification_edit = "AMVER_Automated_notification_profile_specific_setting_edit";
	public String  AMVER_default_notification = "AMVER_Automated_notification_profile_default_setting";
	public String  AMVER_default_notification_edit = "AMVER_Automated_notification_profile_default_setting_edit";
	public Boolean newNotification_by_AMVER_default_notification() {
		
		Logger log = Logger.getLogger("Logger");
		log.info("AMVER notifications script started executing");
		int attempt = 6;
	    
		waitExplicitly(1);
		
		select_event_type("AMVER");

		log.info("Creating the notification profile with default setting...");
		
		waitExplicitly(2);
        getElement(Name_header).click();
        
//Entering the notification name into text field
        
		getElement(Name_text_field).sendKeys(AMVER_default_notification); 
		waitExplicitly(2);
		
//notifications summary validation steps
//name_field ,  summary_name , recipients_summary_3 and summary_ships element locators are calling from NotificationsZonesPage
		
		log.info("Specifying the object locators to validate actual with expected value");
	
		By AMVER_sources = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span");

		verbose("Notifications Summary...");
		verbose("The profile name is..." + getElement(name_field).getText());
		verbose("Name :			" + getElement(summary_name).getText());
		verbose("Ships :		" + getElement(summary_ships).getText());
		waitExplicitly(3);
		
		verbose("Position_events_default :		" + getElement(AMVER_sources).getText());
		verbose("Recipients :	" + getElement(recipients_summary_3).getText());	

		
		
//saving the profile - save_profile element is calling from NotificationsZonesPage
		
		waitExplicitly(10);
		verbose("Clicking on save");
		log.info("Details are saved successfully");
		waitExplicitly(3);
		getElement(save_profile).click();
		waitExplicitly(10);
		
//
		
		verbose("Clicking on Done");
		
//Clicking on Done and validating the AMVER profile is created or not - newNotification_header element and searchNotificationProfile method is calling from NotificationsZonesPage
		
log.info("Validating the AMVER default profile is created or not");
		
		getElement(done).click();
		waitExplicitly(3);
		verbose("Get Page header :" + getElement(newNotification_header).getText());
		if(searchNotificationProfile(AMVER_default_notification).TRUE){
			log.info("The notification profile is created successfully");
			return true;
		}else{
			return false;
		}
		
		
	}
	
	public Boolean newNotification_by_AMVER_specific_notification() {

		int attempt = 7;
		Logger log = Logger.getLogger("Logger");
		
//DSAS object locator is from Specific notifications event section
		
		By DSAS = By.xpath("//form/div[2]/div/div[1]/label");
		
		log.info("Creating new Notification profile with Specific AMVER events");
	
		 select_event_type("AMVER");
		 
		 waitExplicitly(1);
		 
//selecting the specific AMVER events
		 
		 if(getElement(ship_click).isSelected()){  //ship_click element locator is calling from NotificationsZonesPage
			 verbose("Selecting Specific AMVER events"); 
			 getElement(specific_zone).click();    //specific_zone element locator is calling from NotificationsZonesPage
			 waitExplicitly(2);			
			 getElement(DSAS).click();
			 verbose("The specific events selected are : ");
			 verbose(getElement(DSAS).getText());
			 for(int i = 2 ; i<=5 ;i ++){
				 getElement(By.xpath("//div["+i+"]/label")).click();				 
				 verbose(getElement(By.xpath("//div["+i+"]/label")).getText());
				
				 
			 }
			 
			 log.info("All Specific AMVER eevents are selected");
		 } 
		 
		 getElement(Next_button).click();
		
//Entering the notification name into text filed, hence name_field locator is calling from NotificationsZones class
		 
		getElement(Name_text_field).sendKeys(AMVER_specific_notification);  

//notifications summary validation steps
//name_field ,  summary_name , recipients_summary_3 and summary_ships element locators are calling from NotificationsZonesPage

 By AMVER_sources = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span");

 verbose("Notifications Summary...");
 verbose("The profile name is..." + getElement(name_field).getText());
 verbose("Name :			" + getElement(summary_name).getText());
 verbose("Ships :		" + getElement(summary_ships).getText());
 waitExplicitly(3);

 verbose("Position_events_default :		" + getElement(AMVER_sources).getText());
 verbose("Recipients :	" + getElement(recipients_summary_3).getText());	


//saving the profile

 waitExplicitly(10);
 verbose("Clicking on save");
 waitExplicitly(10);
 getElement(save_profile).click();  //save_profile element locator is calling from NotificationsZonesPage
 log.info("Profile is saved successfully");
 waitExplicitly(10);

//Clicking on Done

verbose("Clicking on Done");
getElement(done).click();          //done element locator is calling from NotificationsZonesPage
waitExplicitly(3);

// validating whether specific AMVER notification profile is created or not

verbose("Get Page header :" + getElement(newNotification_header).getText()); //newNotification_header element locator is calling from NotificationsZonesPage
if(searchNotificationProfile(AMVER_specific_notification).TRUE){             //searchNotificationProfile element locator is calling from NotificationsZonesPage
	verbose("The specific AMVER notification profile is created successfully");
	log.info("Specific AMVER notification profile is created successfully");
	return true;
}else{
	return false;
}


}
	
// Editing the AMVER default profile which was created in previous test steps
	
	public boolean edit_AMVER_default_profile(){
		
		Logger log = Logger.getLogger("Logger");
		verbose("**********Editing the notification profile******");
		if(sidePanel_AMVER(AMVER_default_notification,AMVER_default_notification_edit)){  //sidePanel_AMVER method is calling from NotificationsZonesPage
			log.info("Default AMVER profile edited successfully");
			return true;
		}else {
			return false;
		}
		
	}

// Deleting the AMVER default profile which was created in previous test steps
	
	public Boolean delete_AMVER_default_profile(){
		Logger log = Logger.getLogger("Logger");
		verbose("******Deleting the profile********");
		if(delete_profile(AMVER_default_notification_edit)){               //delete_profile method is calling from NotificationsZonesPage
			log.info("Default AMVER profile deleted successfully");
			return true;
		}else {
			return false;
		}		
	}

// Editing the AMVER specific profile which was created in previous test steps
	
	public boolean edit_AMVER_specific_profile(){
		Logger log = Logger.getLogger("Logger");
		verbose("**********Editing the notification profile******");
		if(sidePanel_AMVER(AMVER_specific_notification,AMVER_specific_notification_edit)){  //sidePanel_AMVER method is calling from NotificationsZonesPage
			log.info("Specific AMVER profile edited successfully");
			return true;
		}else {
			return false;
		}
				
	}
	
// Deleting the AMVER default profile which was created in previous test steps

	public Boolean delete_AMVER_specific_profile(){
		Logger log = Logger.getLogger("Logger");
		verbose("******Deleting the profile********");
		if(delete_profile(AMVER_specific_notification_edit)){                  //delete_profile method is calling from NotificationsZonesPage
			log.info("Specific AMVER profile deleted successfully");
			return true;
		}else {
			return false;
		}
		
		
	}
	
}
