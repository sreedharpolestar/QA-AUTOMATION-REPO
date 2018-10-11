package notifications;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import scriptResources.*;
	
	
//extending NotificationsPositionsPage class from NotificationsZonesPage, so that we can use all the methods , drivers and element locators from NotificationsZonesPage class.

	public class NotificationsIncident extends NotificationsZonesPage {
		
		public void log4j()
		{
			
			String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\resources\\log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
	        System.out.println("initialized log4j configuration");	
	        Logger log = Logger.getLogger("Logger");
	        
		}
		
		public NotificationsIncident(WebDriver driver) {
			super(driver);
		
		}
		
// Specifying the element locators and string parameters for Incident notifications
		
		By Incident = By.cssSelector("body > psp-app > ps-notifications > ps-notification-create > div > ps-notification-create-type-step > div > div.ps-app-page__content.full-page.have-details.scroll > div.panels > ps-notification-create-type-selector > div > ul > li:nth-child(8) > div.notification-icon.btn-profileType.notification-icon--incident");
		
		
		By notificationsMenu = By.linkText("Notifications");
		By Text_Warning = By.xpath("//div/ps-notification-panel-event/div/div/div/div/label/span");
		By Ship_within_textbox = By.xpath("//div/ps-notification-panel-event/div/div/div/div/label/input[2]");
		By Test_message = By.xpath("//div/ps-notification-panel-event/div/div/div/div/p");
		By Next_Button = By.xpath("//div/ps-accordion-item[1]/div/div[2]/div/div/a[2]");
				
				
		
		public String Warning_Message = "nm of a cyclone *max 1000";
		public String Expected_Text_Message = "(Notifications will be sent for every ship position update, not cyclone data update)";
		public String  Incident_1000_notification = "Incident_Automated_notification_profile_specific_setting";
		public String  Incident_1000_notification_edit = "Incident_Automated_notification_profile_specific_setting_edit";
		
		

		

		public Boolean newNotification_by_Incident_morethan1000() {
			
			Logger log = Logger.getLogger("Logger");
			log.info("Incident notifications script started executing");
			int attempt = 6;
		    
			waitExplicitly(1);
			
			select_event_type("Incident");

			log.info("Creating the Incident notification profile with more than max 1000 nm...");
			
// Entering data more than max 1000 nm value into Ship is within text box
			
			getElement(Ship_within_textbox).sendKeys("1001"); 
			waitExplicitly(2);
			
//Validating the warning test message
			
			String Actual = getElement(Text_Warning).getText();
			
			Assert.assertEquals(Actual, "*max 1000");
			
			
			System.out.println("Warning message is getting displayed as : " + Actual);
			log.info("Incident notification profile is created successfully");
			getElement(notificationsMenu).click();
			return true;
		
		}
			
			
//Creating Incident notification with 1000 nm
		
		public Boolean newNotification_by_Incident_specific_notification() {

			int attempt = 8;
			Logger log = Logger.getLogger("Logger");
			
			By AIS = By.xpath("//div[2]/div/div/label");
			log.info("Creating new Notification profile with Specific Position events");
			
			 
			 
//Incident element locator is calling from NotificationsZonesPage
		
			 select_event_type("Incident");
			 
			 waitExplicitly(1);
			 
//Entering 1000 nm into Ship is within text box
			 
			 getElement(Ship_within_textbox).sendKeys("1000"); 
			 
//Validating the message displayed below under Incident events and sources section
			 
			 String Actual_Message = getElement(Test_message).getText();
			 
			Assert.assertEquals(Actual_Message , Expected_Text_Message);
			
			log.info("message displayed below under Incident events and sources section as " + Actual_Message);
			 
			 		 
		    log.info("All Specific Incident events are selected");
			 
			 
			 log.info("Calling add_recipients method from NotificationsZonesPage");
			 
			add_recipients(); //Calling this add_receiptents method from NotificationsZonesPage
			
			log.info("Recipients details are added");
			
			getElement(name_field).sendKeys(Incident_1000_notification);  

//notifications summary validation steps
//name_field ,  summary_name , recipients_summary_3 and summary_ships element locators are calling from NotificationsZonesPage

	By Incident_events_and_sources = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span[6]");
	verbose("Notifications Summary...");
	verbose("The profile name is..." + getElement(name_field).getText());
	verbose("Name :			" + getElement(summary_name).getText());
	verbose("Ships :		" + getElement(summary_ships).getText());
	waitExplicitly(3);
	
	verbose("Position_events_default :		" + getElement(Incident_events_and_sources).getText());
	verbose("Recipients :	" + getElement(recipients_summary_3).getText());	


	
//saving the profile
	
	waitExplicitly(10);
	verbose("Clicking on save");
	waitExplicitly(3);
	getElement(save_profile).click();        //save_profile element locator is calling from NotificationsZonesPage
	log.info("Profile is saved successfully");
	waitExplicitly(10);
	
//Clicking on Done
	
	verbose("Clicking on Done");
	getElement(done).click();              //done element locator is calling from NotificationsZonesPage
	waitExplicitly(3);
	
// validating whether specific Incident notification profile is created or not
	
	verbose("Get Page header :" + getElement(newNotification_header).getText()); //newNotification_header element locator is calling from NotificationsZonesPage
	if(searchNotificationProfile(Incident_1000_notification).TRUE){              //searchNotificationProfile method is calling from NotificationsZonesPage
		verbose("The Incident notification profile is created successfully");
		log.info("Incident notification profile is created successfully");
		return true;
	}else{
		return false;
	}
	
	
}
		
// Editing the Incident profile which was created in previous test steps
		
		public boolean edit_Incident_default_profile(){
			
			Logger log = Logger.getLogger("Logger");
			verbose("**********Editing the notification profile******");
			if(sidePanel(Incident_1000_notification,Incident_1000_notification_edit)){
				log.info("Incident profile edited successfully");
				return true;
			}else {
				return false;
			}
			
		}

// Delete the Incident profile which was created in previous test steps
		
		public Boolean delete_Incident_default_profile(){
			Logger log = Logger.getLogger("Logger");
			verbose("******Deleting the profile********");
			if(delete_profile(Incident_1000_notification_edit)){
				log.info("Incident profile deleted successfully");
				return true;
			}else {
				return false;
			}		
		}		
			
		}
		
	
