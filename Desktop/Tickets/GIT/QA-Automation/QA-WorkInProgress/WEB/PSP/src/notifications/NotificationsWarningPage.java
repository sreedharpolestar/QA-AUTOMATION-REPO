package notifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import scriptResources.*;

public class NotificationsWarningPage extends NotificationsZonesPage {
	
	public NotificationsWarningPage(WebDriver driver) {
		super(driver);
	
	}

	By SSASTest_alert = By.xpath("//li[4]/div");
	public String  Warning_specific_notification = "Warning_Automated_notification_profile_specific_setting";
	public String  Warning_specific_notification_edit = "Warning_Automated_notification_profile_specific_setting_edit";
	public String  Warning_default_notification = "Warning_Automated_notification_profile_default_setting";
	public String  Warning_default_notification_edit = "Warning_Automated_notification_profile_default_setting_edit";
	
	public Boolean newNotification_by_Warning_default_notification() {

		int attempt = 7;
	
		waitExplicitly(1);
		
		select_event_type("Warning");

		verbose("Creating the notification profile with default setting...");

		add_recipients();
		//name_and_save();

		getElement(name_field).sendKeys(Warning_default_notification);
		waitExplicitly(2);

		notifications_summary_default(attempt);
		
		//Saving the profile		
				waitExplicitly(3);
				verbose("Clicking on save");
				waitExplicitly(3);
				getElement(save_profile).click();
				waitExplicitly(3);
				
		verbose("Clicking on Done");
		getElement(done).click();
		waitExplicitly(3);
		verbose("Get Page header :" + getElement(newNotification_header).getText());
		if(searchNotificationProfile(Warning_default_notification).TRUE){
			verbose("The notification profile is created successfully");
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean newNotification_by_Warning_specific_notification() {

		int attempt = 8;
		By Transceiver_main_power_down = By.xpath("//div[2]/div/div/label");
		 verbose("Creating new Notification profile with Specific security warning events");
		 //getElement(add_new_event).click(); waitExplicitly(2);
	
		 select_event_type("Warning");
		 
		 waitExplicitly(1);
		 
		 if(getElement(ship_click).isSelected()){ 
			 verbose("Selecting Specific security warning events"); 
			 getElement(specific_zone).click();
			 waitExplicitly(2);			
			 getElement(Transceiver_main_power_down).click();
			 verbose("The specific events selected are : ");
			 verbose(getElement(Transceiver_main_power_down).getText());
			 for(int i = 2 ; i<=6 ;i ++){
				 getElement(By.xpath("//div["+i+"]/label")).click();				 
				 verbose(getElement(By.xpath("//div["+i+"]/label")).getText());
				 
			 }
		 } 
		add_recipients();
		
		getElement(name_field).sendKeys(Warning_specific_notification);  

		waitExplicitly(2);
		 
		notifications_summary_default(attempt);
		
		//Saving the profile		
				waitExplicitly(3);
				verbose("Clicking on save");
				waitExplicitly(3);
				getElement(save_profile).click();
				waitExplicitly(3);
		 
		verbose("Clicking on Done");
		getElement(done).click();
		waitExplicitly(3);
		verbose("Get Page header :" + getElement(newNotification_header).getText());
		if(searchNotificationProfile(Warning_specific_notification).TRUE){
			verbose("Profile is successfully created");
			return true;
		}else{
			return false;
		}

	}
	
	public boolean edit_Warning_default_profile(){
		verbose("**********Editing the notification profile******");
		if(sidePanel(Warning_default_notification,Warning_default_notification_edit)){
			verbose("**********Successfully edited**********");
			return true;
		}else {
			return false;
		}
				
	}

	public Boolean delete_Warning_default_profile(){
		verbose("******Deleting the profile********");
		if(delete_profile(Warning_default_notification_edit)){
			return true;
		}else {
			return false;
		}		
	}

	public boolean edit_Warning_specific_profile(){
		verbose("**********Editing the notification profile******");
		if(sidePanel(Warning_specific_notification,Warning_specific_notification_edit)){
			verbose("**********Successfully edited**********");
			return true;
		}else {
			return false;
		}
				
	}

	public Boolean delete_Warning_specific_profile(){
		verbose("******Deleting the profile********");
		if(delete_profile(Warning_specific_notification_edit)){
			return true;
		}else {
			return false;
		}		
	}
	
}
