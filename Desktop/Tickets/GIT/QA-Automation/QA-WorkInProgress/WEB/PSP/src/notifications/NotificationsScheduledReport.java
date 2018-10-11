package notifications;




import org.testng.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import scriptResources.*;
	
	
//extending NotificationsScheduledReport class from NotificationsZonesPage, so that we can use all the methods , drivers and element locators from NotificationsZonesPage class.

	public class NotificationsScheduledReport extends NotificationsZonesPage {
		
		public void log4j()
		{
			
			String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\resources\\log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
	        System.out.println("initialized log4j configuration");	
	        Logger log = Logger.getLogger("Logger");
	        
		}
		
		public NotificationsScheduledReport(WebDriver driver) {
			super(driver);
		
		}
		
// Specifying the element locators and creating string parameters for NotificationsScheduledReport
		
		By ScheduledReport = By.xpath("//li[8]/div");
		By notificationsMenu = By.linkText("Notifications");
		public String  Report_specific_notification = "Report_Automated_notification_profile_specific_setting";
		public String  Report_specific_notification_edit = "Report_Automated_notification_profile_specific_setting_edit";
		public String  Report_default_notification = "Report_Automated_notification_profile_default_setting";
		public String  Report_default_notification_edit = "Report_Automated_notification_profile_default_setting_edit";
		
		public boolean newNotification_by_Report_default_notification() {
		
			
			Logger log = Logger.getLogger("Logger");
			log.info("Scheduled report notifications script started executing");
		    
			waitExplicitly(5);
			select_event_type("ScheduledReport");

			log.info("Creating the Report notification profile with default setting...");
			
			log.info("Calling add_recipients method from NotificationsZonesPage");

			add_recipients(); //Calling this add_receiptents method from NotificationsZonesPage


			getElement(name_field).sendKeys(Report_default_notification); 
			waitExplicitly(2);
			
//notifications summary validation steps
//name_field ,  summary_name , recipients_summary_3 and summary_ships element locators are calling from NotificationsZonesPage
			
			log.info("Specifying the object locators to validate actual with expected value");
	
			verbose("Notifications Summary...");
			verbose("The profile name is..." + getElement(name_field).getText());
			verbose("Name :			" + getElement(summary_name).getText());
			verbose("Ships :		" + getElement(summary_ships).getText());
			waitExplicitly(3);
			verbose("Recipients :	" + getElement(recipients_Report_default).getText());	

			
//Below steps covers - Should not save the profile as Scheduled report events are not selected.
			
		      Actions action = new Actions(getDriver());
			  WebElement tooltip = getElement(save_profile);    //save_profile element locator is calling from NotificationsZonesPage
			  action.moveToElement(tooltip).build().perform();
			  String tooltip_text = tooltip.getAttribute("data-tooltip");
			  
			  log.info("The tool-tip is: " + tooltip_text);
			  
			  if(tooltip_text.equals("Complete all steps before saving")){
				  log.info("Unable to save as Scheduled report event is not selected, so it's working fine.");

//Clicking on the Notifications menu, to create a new Notification for Scheduled Report by selecting Scheduled report events
				  
				  getElement(notificationsMenu).click();
				  return true;				  
				}else{
					return false;
				}		  
			  }
		
		

		
//Creating ScheduledRepoert notification with specific event types
		
		public Boolean newNotification_by_Report_specific_notification() {

	
			Logger log = Logger.getLogger("Logger");
			
//Object locator for Scheduled Report events - > DSAS monthly battery report check box
			
			By Scheduled_Report_Event = By.xpath("//input[@type='checkbox']");
			
			log.info("Creating new Notification profile with Specific Report events");
			
			 
//ScheduledReport element locator is calling from NotificationsZonesPage
		
			 select_event_type("ScheduledReport");
			 
			 waitExplicitly(1);
			 
//selecting the specific Scheduled Report events
			 
			     getElement(Scheduled_Report_Event).isEnabled();
				
				 getElement(Scheduled_Report_Event).click();
				 verbose("The specific events selected are : ");
				 verbose(getElement(Scheduled_Report_Event).getText());
				
				 log.info("DSAS monthly battery report is selected");
				 
//Validating the message after selecting the DSAS monthly battery report down
				 
				 By DSAS_Event_message = By.xpath("//div/ps-notification-panel-event/div/div/div/div/div/div");
				 String DSAS_Expected_message = "(Notification will only send for ships with DSAS)";
				 
            String Actual_message = getElement(DSAS_Event_message).getText();
            Assert.assertEquals(Actual_message, DSAS_Expected_message);
		
			 log.info("Calling add_recipients method from NotificationsZonesPage");
			 
			add_recipients(); //Calling this add_receiptents method from NotificationsZonesPage
			
			log.info("Recipients details are added");
			
			getElement(name_field).sendKeys(Report_specific_notification);  

//notifications summary validation steps
//name_field ,  summary_name , recipients_Report_specific and summary_ships element locators are calling from NotificationsZonesPage

	By Scheduled_Report_events = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span");

	verbose("Notifications Summary...");
	verbose("The profile name is..." + getElement(name_field).getText());
	verbose("Name :			" + getElement(summary_name).getText());
	verbose("Ships :		" + getElement(summary_ships).getText());
	waitExplicitly(3);
	
	verbose("Position_events_default :		" + getElement(Scheduled_Report_events).getText());
	verbose("Recipients :	" + getElement(recipients_Report_specific).getText());	

	
	
//saving the profile
	
	waitExplicitly(3);
	verbose("Clicking on save");
	waitExplicitly(3);
	getElement(save_profile).click();          //save_profile element locator is calling from NotificationsZonesPage
	log.info("Profile is saved successfully");
	waitExplicitly(3);
	
//Clicking on Done and validating whether specific Position notification profile is created or not
	
	verbose("Clicking on Done");
	getElement(done).click();      //done element locator is calling from NotificationsZonesPage
	waitExplicitly(3);
	
	verbose("Get Page header :" + getElement(newNotification_header).getText());   //newNotification_header locator is calling from NotificationsZonesPage
	if(searchNotificationProfile(Report_specific_notification).TRUE){              //searchNotificationProfile method is calling from NotificationsZonesPage
		verbose("The specific Report notification profile is created successfully");
		log.info("Specific Report notification profile is created successfully");
		return true;
	}else{
		return false;
	}
	
	
}
		

// Editing the Report specific profile which was created in previous test steps
		
		public boolean edit_Report_specific_profile(){
			Logger log = Logger.getLogger("Logger");
			verbose("**********Editing the notification profile******");
			if(sidePanel(Report_specific_notification,Report_specific_notification_edit)){    //sidePanel method is calling from NotificationsZonesPage
				log.info("Specific Report profile edited successfully");
				return true;
			}else {
				return false;
			}
					
		}
		
// Deleting the Report default profile which was created in previous test steps

		public Boolean delete_Report_specific_profile(){
			Logger log = Logger.getLogger("Logger");
			verbose("******Deleting the profile********");
			if(delete_profile(Report_specific_notification_edit)){                    //delete_profile method is calling from NotificationsZonesPage
				log.info("Specific Report profile deleted successfully");
				return true;
			}else {
				return false;
			}
			
			
		}
		
	}
	
