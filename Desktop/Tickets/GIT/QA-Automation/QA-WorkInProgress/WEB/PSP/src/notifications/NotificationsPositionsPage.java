package notifications;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import scriptResources.*;
	
	
//extending NotificationsPositionsPage class from NotificationsZonesPage, so that we can use all the methods , drivers and element locators from NotificationsZonesPage class.

	public class NotificationsPositionsPage extends NotificationsZonesPage {
		
		public void log4j()
		{
			
			String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\resources\\log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
	        System.out.println("initialized log4j configuration");	
	        Logger log = Logger.getLogger("Logger");
	        
		}
		
		public NotificationsPositionsPage(WebDriver driver) {
			super(driver);
		
		}
		
// Specifying the element locators and creating string parameters for Position notifications
		
		By Position = By.xpath("//li[5]/div");
		public String  Position_specific_notification = "Position_Automated_notification_profile_specific_setting";
		public String  Position_specific_notification_edit = "Position_Automated_notification_profile_specific_setting_edit";
		public String  Position_default_notification = "Position_Automated_notification_profile_default_setting";
		public String  Position_default_notification_edit = "Position_Automated_notification_profile_default_setting_edit";
		
		public Boolean newNotification_by_Position_default_notification() {
			
			Logger log = Logger.getLogger("Logger");
			log.info("Position notifications script started executing");
			int attempt = 6;
		    
			waitExplicitly(1);
			
			select_event_type("Position");

			log.info("Creating the notification profile with default setting...");
			
			log.info("Calling add_recipients method from NotificationsZonesPage");

			add_recipients(); //Calling this add_receiptents method from NotificationsZonesPage


			getElement(name_field).sendKeys(Position_default_notification); 
			waitExplicitly(2);
			
//notifications summary validation steps
//name_field ,  summary_name , recipients_summary_3 and summary_ships element locators are calling from NotificationsZonesPage
			
			log.info("Specifying the object locators to validate actual with expected value");
		
			By Position_Alert_events = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span");
			verbose("Notifications Summary...");
			verbose("The profile name is..." + getElement(name_field).getText());
			verbose("Name :			" + getElement(summary_name).getText());
			verbose("Ships :		" + getElement(summary_ships).getText());
			waitExplicitly(3);
			
			verbose("Position_events_default :		" + getElement(Position_Alert_events).getText());
			verbose("Recipients :	" + getElement(recipients_summary_3).getText());	

			
//saving the profile
			
		waitExplicitly(10);
		verbose("Clicking on save");
		log.info("Details are saved successfully");
		waitExplicitly(3);
		getElement(save_profile).click();       //save_profile element locator is calling from NotificationsZonesPage
		waitExplicitly(10);
			
//Clicking on Done and Validating the Position default profile is created or not
			
			verbose("Clicking on Done");
			
			log.info("Validating the Position default profile is created or not");
			
			getElement(done).click();               //done element locator is calling from NotificationsZonesPage
			waitExplicitly(3);
			verbose("Get Page header :" + getElement(newNotification_header).getText());
			if(searchNotificationProfile(Position_default_notification).TRUE){       //searchNotificationProfile method is calling from NotificationsZonesPage
				log.info("The notification profile is created successfully");
				return true;
			}else{
				return false;
			}
			
			
		}
		
		
//Creating a Position notification with specific event types
		
		public Boolean newNotification_by_Position_specific_notification() {

			int attempt = 8;
			Logger log = Logger.getLogger("Logger");
			
			By AIS = By.xpath("//div[2]/div/div/label");
			log.info("Creating new Notification profile with Specific Position events");
			
			 
//Position element locator is calling from NotificationsZonesPage
		
			 select_event_type("Position");
			 
			 waitExplicitly(1);
			 
			 //selecting the specific position events
			 
			 if(getElement(ship_click).isSelected()){ 
				 verbose("Selecting Specific Position events"); 
				 getElement(specific_zone).click();
				 waitExplicitly(2);			
				 getElement(AIS).click();
				 verbose("The specific events selected are : ");
				 verbose(getElement(AIS).getText());
				 for(int i = 2 ; i<=6 ;i ++){
					 getElement(By.xpath("//div["+i+"]/label")).click();				 
					 verbose(getElement(By.xpath("//div["+i+"]/label")).getText());
					
					 
				 }
				 
				 log.info("All Specific Position eevents are selected");
			 } 
			 
			 log.info("Calling add_recipients method from NotificationsZonesPage");
			 
			add_recipients(); //Calling this add_receiptents method from NotificationsZonesPage
			
			log.info("Recipients details are added");
			
			getElement(name_field).sendKeys(Position_specific_notification);  

//notifications summary validation steps
//name_field ,  summary_name , recipients_summary_3 and summary_ships element locators are calling from NotificationsZonesPage

	By Position_Alert_events = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span");
	verbose("Notifications Summary...");
	verbose("The profile name is..." + getElement(name_field).getText());
	verbose("Name :			" + getElement(summary_name).getText());
	verbose("Ships :		" + getElement(summary_ships).getText());
	waitExplicitly(3);
	
	verbose("Position_events_default :		" + getElement(Position_Alert_events).getText());
	verbose("Recipients :	" + getElement(recipients_summary_3).getText());	

	
	
//saving the profile
	
	waitExplicitly(10);
	verbose("Clicking on save");
	waitExplicitly(3);
	getElement(save_profile).click();         //save_profile element locator is calling from NotificationsZonesPage
	log.info("Profile is saved successfully");
	waitExplicitly(10);
	
//Clicking on Done and validating whether specific Position notification profile is created or not
	
	verbose("Clicking on Done");
	getElement(done).click();                //done element locator is calling from NotificationsZonesPage
	waitExplicitly(3);
	
	verbose("Get Page header :" + getElement(newNotification_header).getText());      //newNotification_header element locator is calling from NotificationsZonesPage
	if(searchNotificationProfile(Position_specific_notification).TRUE){               //searchNotificationProfile method calling from NotificationsZonesPage
		verbose("The specific position notification profile is created successfully");
		log.info("Specific position notification profile is created successfully");
		return true;
	}else{
		return false;
	}
	
	
}
		
// Editing the Position default profile which was created in previous test steps
		
		public boolean edit_Position_default_profile(){
			
			Logger log = Logger.getLogger("Logger");
			verbose("**********Editing the notification profile******");
			if(sidePanel(Position_default_notification,Position_default_notification_edit)){  //sidePanel method is calling from NotificationsZonesPage
				log.info("Default Position profile edited successfully");
				return true;
			}else {
				return false;
			}
			
		}

// Deleting the Position default profile which was created in previous test steps
		
		public Boolean delete_Position_default_profile(){
			Logger log = Logger.getLogger("Logger");
			verbose("******Deleting the profile********");
			if(delete_profile(Position_default_notification_edit)){
				log.info("Default Position profile deleted successfully");
				return true;
			}else {
				return false;
			}		
		}

// Editing the Position specific profile which was created in previous test steps
		
		public boolean edit_Position_specific_profile(){
			Logger log = Logger.getLogger("Logger");
			verbose("**********Editing the notification profile******");
			if(sidePanel(Position_specific_notification,Position_specific_notification_edit)){    //sidePanel method is calling from NotificationsZonesPage
				log.info("Specific Position profile edited successfully");
				return true;
			}else {
				return false;
			}
					
		}
		
// Deleting the Position default profile which was created in previous test steps

		public Boolean delete_Position_specific_profile(){
			Logger log = Logger.getLogger("Logger");
			verbose("******Deleting the profile********");
			if(delete_profile(Position_specific_notification_edit)){
				log.info("Specific Position profile deleted successfully");
				return true;
			}else {
				return false;
			}
			
			
		}
		
	}
