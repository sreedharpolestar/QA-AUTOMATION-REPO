package notifications;

import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import scriptResources.*;
	
	
//extending NotificationsPositionsPage class from NotificationsZonesPage, so that we can use all the methods , drivers and element locators from NotificationsZonesPage class.

	public class NotificationsOverduePositionPage extends NotificationsZonesPage {
		
		public void log4j()
		{
			
			String log4jConfPath = "C:\\Users\\sreedhar.popuri\\workspace\\selenium\\Jenkins\\Automation_Jenkins\\resources\\log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
	        System.out.println("initialized log4j configuration");	
	        Logger log = Logger.getLogger("Logger");
	        
		}
		
		public NotificationsOverduePositionPage(WebDriver driver) {
			super(driver);
		
		}
		
// Specifying the element locators and creating string parameters for Overdue Position notifications
		
		By Overdue_Position = By.xpath("//li[6]/div");
		By Chooseminimumdelay = By.xpath("//div/ps-option-dropdown/div/button");		
		public String  OverduePosition_specific_notification = "Overdue Position_Automated_notification_profile_specific_setting";
		public String  OverduePosition_specific_notification_edit = "Overdue Position_Automated_notification_profile_specific_setting_edit";
		public String  OverduePosition_default_notification = "Overdue Position_Automated_notification_profile_default_setting";
		public String  OverduePosition_default_notification_edit = "Overdue Position_Automated_notification_profile_default_setting_edit";
		
		public Boolean newNotification_by_OverduePosition_default_notification() {
			
			Logger log = Logger.getLogger("Logger");
			log.info("Overdue Position notifications script started executing");
			int attempt = 6;
		    
			waitExplicitly(1);
			
			select_event_type("Overdue_Position");

			log.info("Creating the notification profile with default setting...");

			getElement(Chooseminimumdelay).isEnabled();
	
			log.info("Calling add_recipients method from NotificationsZonesPage");
		

			add_recipients(); //Calling this add_receiptents method from NotificationsZonesPage


			getElement(name_field).sendKeys(OverduePosition_default_notification); 
			waitExplicitly(2);
			
//notifications summary validation steps
//name_field ,  summary_name , recipients_Overdue_Position and summary_ships element locators are calling from NotificationsZonesPage
			
			log.info("Specifying the object locators to validate actual with expected value");
			
			String Overdue_Position_default_Expected = "All";
			String Overdue_Threshold_default_Expected = "1 hours";
			String Overdue_Recipients_Expected = "sreedhar popuri";
		
		
			By Overdue_Position_events  = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span");
			By Overdue_threshold = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[4]/div[2]");
			

			
			verbose("Notifications Summary...");
			verbose("The profile name is..." + getElement(name_field).getText());
//			verbose("Name :			" + getElement(summary_name).getText());
			verbose("Ships :		" + getElement(summary_ships).getText());
			waitExplicitly(3);
			
			verbose("Overdue_Position_events_default :		" + getElement(Overdue_Position_events).getText());
			String Overdue_Position_default_Actual = getElement(Overdue_Position_events).getText();
			Assert.assertEquals(Overdue_Position_default_Actual, Overdue_Position_default_Expected);
			log.info("The Overdue Position default is updated correct");
					
			verbose("Overdue_Position_threshold_default :	" + getElement(Overdue_threshold).getText());
			String Overdue_Threshold_default_Actual = getElement(Overdue_threshold).getText();
			Assert.assertEquals(Overdue_Threshold_default_Actual, Overdue_Threshold_default_Expected);
			log.info("The Overdue threshold default is updated correct");
			
			verbose("Recipients :	" + getElement(recipients_Overdue_Position).getText());	
			String Overdue_Recipients_Actual = getElement(recipients_Overdue_Position).getText();
			Assert.assertEquals(Overdue_Recipients_Actual, Overdue_Recipients_Expected);
			log.info("The Overdue Recipients default is updated correct");


			
			
//saving the profile
			
			waitExplicitly(10);
			verbose("Clicking on save");
			log.info("Details are saved successfully");
			waitExplicitly(3);
			getElement(save_profile).click();     //save_profile element locator is calling from NotificationsZonesPage
			waitExplicitly(10);
			
//Clicking on Done and Validating the Overdue Position default profile is created or not
			
			verbose("Clicking on Done");
			
			log.info("Validating the Overdue Position default profile is created or not");
			
			getElement(done).click();
			waitExplicitly(3);
			verbose("Get Page header :" + getElement(newNotification_header).getText());
			if(searchNotificationProfile(OverduePosition_default_notification).TRUE){
				log.info("The notification profile is created successfully");
				return true;
			}else{
				return false;
			}
			
			
		}
		
		
//Creating Overdue Position notification with specific values
		
		public Boolean newNotification_by_OverduePosition_specific_notification() {

			int attempt = 8;
			Logger log = Logger.getLogger("Logger");
			
			By Choose_minimum_delay =By.cssSelector("body > psp-app > psp-core > div > ps-notifications > ps-notification-create > ps-notification-create-type-step > div > ps-notification-detailview > aside > form > ps-accordion > div > ps-accordion-item:nth-child(1) > div.ps-accordion-item__body.panel-collapse.collapse.in.ng-tns-c9-7.ng-trigger.ng-trigger-accordionItemState.ps-accordion-item__body--overflow > div > ps-notification-panel-event > div > div > div.form-group > div > ps-option-dropdown > div > button");
			
			By delay_time1 = By.cssSelector("#option-1");
			By delay_time2 = By.cssSelector("#option-2");
			By delay_time3 = By.cssSelector("#option-3");
			By delay_time4 = By.cssSelector("#option-4");
			By delay_time5 = By.cssSelector("#option-5");
			By delay_time6 = By.cssSelector("#option-6");
			
			By AIS = By.xpath("//div[2]/div/div[1]/label");
			
     		log.info("Creating new Notification profile with Specific OverduePosition events");
			
	
			 
//Overdue_Position element locator is calling from NotificationsZonesPage
		
			 select_event_type("Overdue_Position");
			 
			 waitExplicitly(1);
			 
//selecting the specific Overdue position events
			 		 
			 getElement(Choose_minimum_delay).isSelected();
			 
			 /*String[] exp = {"2 hours", "4 hours", "8 hours", "12 hours", "24 hours", "48 hours"}; 
			 
			 WebElement dropdown = getElement(Choose_minimum_delay);  
			         Select select = new Select(dropdown);  

			         List<WebElement> options = select.getOptions();
			         loop:  
			         for(WebElement we:options)  
			         {  
			          for (int i=0; i<exp.length; i++){
			              if (we.getText().equals(exp[i])){
			              System.out.println("Matched");
			              break loop;
			              } 
			           }
			         }  */
			       
			 getElement(Choose_minimum_delay).click();
			 getElement(delay_time1).click();
			 
			 if(getElement(ship_click).isSelected()){ 
				 verbose("Selecting Specific OverduePosition events"); 
				 getElement(specific_zone).click();
				 waitExplicitly(2);			
				 getElement(AIS).click();
				 verbose("The specific events selected are : ");
				 verbose(getElement(AIS).getText());
				 for(int i = 2 ; i<=6 ;i ++){
					 getElement(By.xpath("//div["+i+"]/label")).click();				 
					 verbose(getElement(By.xpath("//div["+i+"]/label")).getText());
					
					 
				 }
				 
				 log.info("All Specific OverduePosition eevents are selected");
			 } 
			 
			 log.info("Calling add_recipients method from NotificationsZonesPage");
			 
			add_recipients(); //Calling this add_receiptents method from NotificationsZonesPage
			
			log.info("Recipients details are added");
			
			getElement(name_field).sendKeys(OverduePosition_specific_notification);  

//notifications summary validation steps
//name_field ,  summary_name , recipients_Overdue_Position and summary_ships element locators are calling from NotificationsZonesPage

	By OverduePosition_Sources = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span[3]");
	By Overdue_threshold = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[4]/div[2]");	
	

	verbose("Notifications Summary...");
	verbose("The profile name is..." + getElement(name_field).getText());
	verbose("Name :			" + getElement(summary_name).getText());
	verbose("Ships :		" + getElement(summary_ships).getText());
	waitExplicitly(3);
	
	verbose("Overdue_Position_events_specific :		" + getElement(OverduePosition_Sources).getText());
	verbose("Overdue_Position_threshold_specific :	" + getElement(Overdue_threshold).getText());
	verbose("Recipients :	" + getElement(recipients_Overdue_Position).getText());	

	
	
//saving the profile
	
	waitExplicitly(10);
	verbose("Clicking on save");
	waitExplicitly(3);
	getElement(save_profile).click();                  //save_profile element locator is calling from NotificationsZonesPage
	log.info("Profile is saved successfully");
	waitExplicitly(10);
	
//Clicking on Done and validating whether specific Overdue Position notification profile is created or not
	
	verbose("Clicking on Done");
	getElement(done).click();                         //done element locator is calling from NotificationsZonesPage
	waitExplicitly(3);
	
	
	verbose("Get Page header :" + getElement(newNotification_header).getText());
	if(searchNotificationProfile(OverduePosition_specific_notification).TRUE){           //searchNotificationProfile method is calling from NotificationsZonesPage
		verbose("The specific Overdueposition notification profile is created successfully");
		log.info("Specific Overdueposition notification profile is created successfully");
		return true;
	}else{
		return false;
	}
	
	
}
		
// Editing the OverduePosition default profile which was created in previous test steps
		
		public boolean edit_OverduePosition_default_profile(){
			
			Logger log = Logger.getLogger("Logger");
			verbose("**********Editing the notification profile******");
			if(sidePanel(OverduePosition_default_notification,OverduePosition_default_notification_edit)){
				log.info("Default OverduePosition profile edited successfully");
				return true;
			}else {
				return false;
			}
			
		}

// Deleting the Default OverduePosition profile which was created in previous test steps
		
		public Boolean delete_OverduePosition_default_profile(){
			Logger log = Logger.getLogger("Logger");
			verbose("******Deleting the profile********");
			if(delete_profile(OverduePosition_default_notification_edit)){
				log.info("Default OverduePosition profile deleted successfully");
				return true;
			}else {
				return false;
			}		
		}

// Editing the OverduePosition specific profile which was created in previous test steps
		
		public boolean edit_OverduePosition_specific_profile(){
			Logger log = Logger.getLogger("Logger");
			verbose("**********Editing the notification profile******");
			if(sidePanel(OverduePosition_specific_notification,OverduePosition_specific_notification_edit)){
				log.info("Specific OverduePosition profile edited successfully");
				return true;
			}else {
				return false;
			}
					
		}
		
// Deleting the OverduePosition default profile which was created in previous test steps

		public Boolean delete_OverduePosition_specific_profile(){
			Logger log = Logger.getLogger("Logger");
			verbose("******Deleting the profile********");
			if(delete_profile(OverduePosition_specific_notification_edit)){
				log.info("Specific OverduePosition profile deleted successfully");
				return true;
			}else {
				return false;
			}
			
			
		}
		
	}
