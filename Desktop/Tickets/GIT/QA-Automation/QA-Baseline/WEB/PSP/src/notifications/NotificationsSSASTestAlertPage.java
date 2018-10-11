package notifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import scriptResources.*;

public class NotificationsSSASTestAlertPage extends NotificationsZonesPage {

	public NotificationsSSASTestAlertPage(WebDriver driver) {
		super(driver);
		
	}
	By SSASTest_alert = By.xpath("//li[3]/div");
	public String  SSAS_Test_specific_notification = "SSAS_Test_Alert_Automated_notification_profile_specific_setting";
	public String  SSAS_Test_specific_notification_edit = "SSAS_Test_Alert_Automated_notification_profile_specific_setting_edit";
	public String  SSAS_Test_default_notification = "SSAS_Test_Alert_Automated_notification_profile_default_setting";
	public String  SSAS_Test_default_notification_edit = "SSAS_Test_Alert_Automated_notification_profile_default_setting_edit";
	
	public Boolean newNotification_by_SSASTestAlert_default() {

		int attempt = 5;
	
		waitExplicitly(1);
		
		select_event_type("SSASTest_alert");

		verbose("Creating the notification profile with default setting...");

		add_recipients();
		//name_and_save();

		getElement(name_field).sendKeys(SSAS_Test_default_notification);
		waitExplicitly(2);

		/*notifications_summary_default(attempt);*/
		
		//notifications summary validation steps
		//name_field ,  summary_name , recipients_summary_3 and summary_ships element locators are calling from NotificationsZonesPage

			By SSASTEST_Alert_events_details = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span");
			verbose("Notifications Summary...");
			verbose("The profile name is..." + getElement(name_field).getText());
			verbose("Name :			" + getElement(summary_name).getText());
			verbose("Ships :		" + getElement(summary_ships).getText());
			waitExplicitly(3);
			
			verbose("SSASTEST_Alert_events_details :		" + getElement(SSASTEST_Alert_events_details).getText());
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
		if(searchNotificationProfile(SSAS_Test_default_notification).TRUE){
			verbose("The notification profile is created successfully");
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean newNotification_by_SSASTestAlert_specific() {

		int attempt = 6;
		By alert_initiated = By.xpath("//div[2]/div/div/label");
		 verbose("Creating new Notification profile with Specific alert events");
		 //getElement(add_new_event).click(); waitExplicitly(2);
	
		 select_event_type("SSASTest_alert");
		 
		 waitExplicitly(1);
		 
		 if(getElement(ship_click).isSelected()){ 
			 verbose("Selecting Specific alert events"); 
			 getElement(specific_zone).click();
			 waitExplicitly(2);			
			 getElement(alert_initiated).click();
			 verbose("The specific events selected are : ");
			 verbose(getElement(alert_initiated).getText());
			 for(int i = 2 ; i<=5 ;i ++){
				 getElement(By.xpath("//div["+i+"]/label")).click();
				 waitExplicitly(1);
				 verbose(getElement(By.xpath("//div["+i+"]/label")).getText());
			 }
		 } 
		add_recipients();
		
		getElement(name_field).sendKeys(SSAS_Test_specific_notification);  

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
		if(searchNotificationProfile(SSAS_Test_specific_notification).TRUE){
			verbose("Profile is successfully created");
			return true;
		}else{
			return false;
		}

	}
	
	public boolean edit_SSASTestAlert_default_profile(){
		verbose("**********Editing the notification profile******");
		if(sidePanel(SSAS_Test_default_notification,SSAS_Test_default_notification_edit)){
			verbose("**********Successfully edited**********");
			return true;
		}else {
			return false;
		}
				
	}

	public Boolean delete_SSASTestAlert_default_profile(){
		verbose("******Deleting the profile********");
		if(delete_profile(SSAS_Test_default_notification_edit)){
			return true;
		}else {
			return false;
		}		
	}

	public boolean edit_SSASTestAlert_specific_profile(){
		verbose("**********Editing the notification profile******");
		if(sidePanel(SSAS_Test_specific_notification,SSAS_Test_specific_notification_edit)){
			verbose("**********Successfully edited**********");
			return true;
		}else {
			return false;
		}
				
	}

	public Boolean delete_SSASTestAlert_specific_profile(){
		verbose("******Deleting the profile********");
		if(delete_profile(SSAS_Test_specific_notification_edit)){
			return true;
		}else {
			return false;
		}		
	}
	
}
