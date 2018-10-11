package notifications;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import scriptResources.*;

//extending NotificationsSSRS class from NotificationsZonesPage, so that we can use all the methods , drivers and element locators from NotificationsZonesPage class.


public class NotificationsSSRS extends NotificationsZonesPage {
	
	public void log4j()
	{
		
		String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
        System.out.println("initialized log4j configuration");	
        Logger log = Logger.getLogger("Logger");
        
	}
	
	public NotificationsSSRS(WebDriver driver) {
		super(driver);
	
	}
	
// Specifying the element locators and creating string parameters for SSRS notifications
	
	By SSRS = By.xpath("//div/ul/li[10]/div[1]");
	
	By SSRS_name_field = By.cssSelector("#notification_name");
	
	public String  SSRS_notification = "SSRS Notification";
	public String  SSRS_notification_edit = "SSRS Notification_edit";
	
	public Boolean newNotification_by_SSRS__notification() {
		
		Logger log = Logger.getLogger("Logger");
		log.info("SSRS notifications script started executing");
		int attempt = 6;
	    
		waitExplicitly(1);
		
		select_event_type("SSRS");

		log.info("Creating the notification profile for SSRS...");


		getElement(SSRS_name_field).sendKeys(SSRS_notification); 
		waitExplicitly(2);
		
//notifications summary validation steps
//name_field ,  summary_name , recipients_summary_3 and summary_ships element locators are calling from NotificationsZonesPage
		
		log.info("Specifying the object locators to validate actual with expected value");
	
		By SSRS_sources = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span[4]");
		
		verbose("Notifications Summary...");
		verbose("The profile name is..." + getElement(name_field).getText());
		verbose("Name :			" + getElement(summary_name).getText());
		verbose("Ships :		" + getElement(summary_ships).getText());
		waitExplicitly(3);
		
		verbose("Position_events_default :		" + getElement(SSRS_sources).getText());
		verbose("Recipients :	" + getElement(recipients_summary_3).getText());	

		
		
//saving the profile
		
		waitExplicitly(3);
		verbose("Clicking on save");
		log.info("Details are saved successfully");
		waitExplicitly(3);
		getElement(save_profile).click();            //save_profile element locator is calling from NotificationsZonesPage
		waitExplicitly(3);
		
//Clicking on Done and Validating the Position default profile is created or not
		
		verbose("Clicking on Done");
		log.info("Validating the SSRS profile is created or not");
		
		getElement(done).click();                   //done element locator is calling from NotificationsZonesPage
		waitExplicitly(3);
		verbose("Get Page header :" + getElement(newNotification_header).getText());  //newNotification_header element locator is calling from NotificationsZonesPage
		if(searchNotificationProfile(SSRS_notification).TRUE){                        //searchNotificationProfile method is calling from NotificationsZonesPage
			log.info("The notification profile is created successfully");
			return true;
		}else{
			return false;
		}
		
		
	}
	
	
// Editing the SSRS profile which was created in previous test steps
	
	public boolean edit_SSRS_default_profile(){
		
		Logger log = Logger.getLogger("Logger");
		verbose("**********Editing the notification profile******");
		if(sidePanel_SSRS(SSRS_notification,SSRS_notification_edit)){   //sidePanel_SSRS method is calling from NotificationsZonesPage
			log.info("SSRS profile edited successfully");
			return true;
		}else {
			return false;
		}
		
	}

// Deleting the SSRS profile which was created in previous test steps
	
	public Boolean delete_SSRS_default_profile(){
		Logger log = Logger.getLogger("Logger");
		verbose("******Deleting the profile********");
		if(delete_profile(SSRS_notification_edit)){                   //delete_profile method is calling from NotificationsZonesPage
			log.info("SSRS profile deleted successfully");
			return true;
		}else {
			return false;
		}		
	}		
	}
	
