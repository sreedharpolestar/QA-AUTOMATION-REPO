package notifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import scriptResources.*;

public class NotificationsSSASAlertPage extends NotificationsZonesPage {
	public String  name_this_notification1 = "SSASAlert_Automated_notification_profile_specific_setting";
	public String  name_this_notification_edit1 = "SSASAlert_Automated_notification_profile_specific_setting_edit";
	public String  name_this_notification = "SSASAlert_Automated_notification_profile_default_setting";
	public String  name_this_notification_edit = "SSASAlert_Automated_notification_profile_default_setting_edit";

	public NotificationsSSASAlertPage(WebDriver driver) {
		super(driver);
	}

	public Boolean newNotification_by_SSASAlert_default() {
		int attempt = 3;
		
		By recipient_textbox = By.xpath("//div/input");

		
		waitExplicitly(1);
		
		select_event_type("SSAS_alert");
		waitExplicitly(2);

		verbose("Creating the notification profile with default setting...");
		add_recipients();
		//name_and_save();

		getElement(name_field).sendKeys(name_this_notification);
		//verbose("Section..." + getElement(name_this_notification).getText());
		waitExplicitly(2);

		notifications_summary_default(attempt);
		
		//Saving the profile		
			waitExplicitly(10);
			verbose("Clicking on save");
			waitExplicitly(3);
			getElement(save_profile).click();
			waitExplicitly(3);
				
		verbose("Clicking on Done");
		getElement(done).click();
		waitExplicitly(3);
		verbose("Get Page header :" + getElement(newNotification_header).getText());
		if(searchNotificationProfile(name_this_notification).TRUE){
			verbose("Profile is created successfully");
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean newNotification_by_SSASAlert_specific() {
		
		int attempt = 4;

		By recipient_textbox2 = By.xpath("//div/div/div/input");
		By alert_initiated = By.xpath("//div[2]/div/div/label");
		 verbose("Creating new Notification profile with Specific alert events");
		select_event_type("SSAS_alert");
		
		 waitExplicitly(1);
		 
		 if(getElement(ship_click).isSelected()){ 
			 verbose("Selecting Specific alert events"); 
			 getElement(specific_zone).click();
			 waitExplicitly(2);
			 getElement(alert_initiated).click();
			 verbose(getElement(alert_initiated).getText() + " : is selected");
			
			 for(int i = 2 ; i<=4 ;i ++){
				 getElement(By.xpath("//div["+i+"]/label")).click();
				 verbose((getElement(By.xpath("//div["+i+"]/label")).getText()));
			 }
			
		 } 
		 
		 add_recipients();
		 
		 getElement(name_field).sendKeys(name_this_notification1);  

		waitExplicitly(2);
		 
	/*	notifications_summary_default(attempt);*/
		
		//notifications summary validation steps
		//name_field ,  summary_name , recipients_summary_3 and summary_ships element locators are calling from NotificationsZonesPage

			By SSAS_Alert_events_details = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span[2]");
			verbose("The profile name is..." + getElement(name_field).getText());
			verbose("Name :			" + getElement(summary_name).getText());
			verbose("Ships :		" + getElement(summary_ships).getText());
			waitExplicitly(3);
			
			verbose("SSAS_Alert_events__default :		" + getElement(SSAS_Alert_events_details).getText());
			verbose("Recipients :	" + getElement(recipients_summary_3).getText());	

		
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
		if(searchNotificationProfile(name_this_notification1).TRUE){
			verbose("Profile is successfully created");
			return true;
		}else{
			return false;
		}

	}
	

	public boolean edit_SSASAlert_default_profile(){
		verbose("**********Editing the notification profile******");
		if(sidePanel(name_this_notification,name_this_notification_edit)){
			verbose("**********Successfully edited**********");
			return true;
		}else {
			return false;
		}
				
	}

	public Boolean delete_SSASAlert_default_profile(){
		verbose("******Deleting the profile********");
		if(delete_profile(name_this_notification_edit)){
			return true;
		}else {
			return false;
		}		
	}
	

	public boolean edit_SSASAlert_specific_profile(){
		verbose("**********Editing the notification profile******");
		if(sidePanel(name_this_notification1,name_this_notification_edit1)){
			verbose("**********Successfully edited**********");
			return true;
		}else {
			return false;
		}
				
	}

	public Boolean delete_SSASAlert_specific_profile(){
		verbose("******Deleting the profile********");
		if(delete_profile(name_this_notification_edit1)){
			return true;
		}else {
			return false;
		}		
	}
}
