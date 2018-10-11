package notifications;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//import Notification_resources.BasePage;
//import Notification_resources.LoginPage;

import scriptResources.*;

/**
 * @author shruthi.mukunda
 *
 */
public class NotificationsZonesPage extends BasePage {
	
	LoginPage loginPage = new LoginPage(getDriver());
	
	By change_ship_selection_fleet = By.cssSelector(".btn.btn-default.tool-tip");
	By noprofilefound = By.cssSelector("div.empty-message");
	By change_ship_selection_account = By.cssSelector(".btn.btn-default.tool-tip-nw");
	By change_ship_selection_ship = By.cssSelector(".btn.btn-default.tool-tip-ne");
	By allNotifications = By.xpath("//ps-option-dropdown/div/button");
	By event_type = By.cssSelector("span.notificationType");
	By event_title = By.xpath("//div[2]/div/span");
	By sortByMostRecentlyEdited = By.xpath("//ps-option-dropdown[2]/div/button");
	By sort_type = By.xpath("//ps-option-dropdown[2]/div/button");
	
	By newNotification = By.xpath("//ps-notifications/ps-notification-index/div/div[2]/div[1]/div[1]/span/a");
	By newNotification_header = By.xpath("//h3");
	By help_text_addships = By.xpath("//p");
	By by_ship = By.xpath("(//button[@type='button'])[2]");
	By ship_click = By.xpath("//input");
	By fleet_select = By.xpath("//ps-autocomplete/form/div/div/ul/li[1]/a");
	
	By account_select = By.xpath("//div/ps-autocomplete/form/div/div/ul/li[3]/a");
	By ship_selected = By.xpath("//h5");
	By ship_select = By.xpath("//form/div/div/ul/li/a");
	By fleet = By.xpath("//div[2]/button");
	By tool_tip_ships = By.cssSelector(".hint--top");
	By panel_title = By.xpath("//h4");
	By ship_next = By.xpath("//button[2]");
	By zone = By.xpath("//li/div");
	By specific_zone = By.xpath("//label[2]/input");
	By zone_search = By.xpath("//div/input");
	By all_zone_events = By.xpath("//form/div/div/label/input");
	By specific_zone_event = By.xpath("//form/div/div/label[2]/input");
	By ship_view = By.xpath("//div/div/div/a");
	By ship_view_close = By.xpath("//div/div/div/a");
	By add_new_event = By.xpath("//div[2]/button");
	By specific_zone_JWC = By.xpath("//h4/input");
	By specific_zone_loadline = By.xpath("//div/h4/input");
	By specific_zone_Navarea = By.xpath("//div/h4/input");
	By all_events = By.xpath("//form/div/div/label/input");
	By specific_events = By.xpath("//form/div/div/label[2]/input");
	By specific_events_entry = By.xpath("//div[2]/div/div/label/input");
	By specific_event_entry_text = By.xpath("//div[2]/div/div/label");
	By name_this_notification = By.cssSelector("div.text-muted");
	By done = By.xpath("//button[2]");
	By next = By.xpath("//div/div/a[2]");
	By zoe_receiptent_heading = By.xpath("//ps-accordion/div/ps-accordion-item[2]/div[1]/h4/ps-accordion-heading");
	By zoe_name_heading = By.xpath("//ps-accordion/div/ps-accordion-item[3]/div[1]/h4/ps-accordion-heading");

	By search_result = By.xpath("//div[2]/div[2]/div[2]");
	 By sidePanel_click = By.xpath("//div/span[2]"); 
	public String profile_title_zone_default =  "Zones_Automation_Profile_default_settings";
	public String name_edit1 = "Zones_Automation_Profile_default_settings_edit";
	public String profile_title_zone_specific = "Zones_Automation_Profile_specific_settings";
	public String name_edit2 = "Zones_Automation_Profile_specific_settings_edit";

	
	public NotificationsZonesPage(WebDriver driver) {
		super(driver);
	}
	
	// Notifications page header is present in the landing page
	//TID-45
	public boolean isHeaderPresent() {
		waitExplicitly(1);
		By notificationsMenu = By.linkText("Notifications");
		
		getElement(notificationsMenu).click();
		
		verbose("Notifications menu is clicked ");
		waitExplicitly(3);
		By notificationsHeader = By.cssSelector("h3");
		if (getElement(notificationsHeader).getText().equals("Notifications")) {
			verbose("Logged into Notification successfully!");
			return true;
		} else {
			return false;
		}
	}

	// Notifications landing page
	//TID-47
	public boolean isDefaultValuesPresent() {
		waitExplicitly(1);		
		By date1 = By.xpath("//li[1]/ps-notification-list-details/a/div/div[2]/div[4]/div[2]");

		String newdate1 = getElement(date1).getText();
		verbose("The new date1 is :" + newdate1);
		String datetime1 = newdate1.substring(0, 17);
		By date2 = By.xpath("//li[2]/ps-notification-list-details/a/div/div[2]/div[4]/div[2]");
		String newdate2 = getElement(date2).getText();
		verbose("The new date2 is :" + newdate2);
		String datetime2 = newdate2.substring(0, 17);
		By date3 = By.xpath("//li[3]/ps-notification-list-details/a/div/div[2]/div[4]/div[2]");
		String newdate3 = getElement(date3).getText();
		verbose("The new date3 is :" + newdate3);
		String datetime3 = newdate2.substring(0, 17);
		if (datetime1.compareTo(datetime2)>0 || datetime1.compareTo(datetime3)>0) {
			verbose("Notifications is 'Sort by most recently edited' only");
			return true;
		}else if(datetime1.compareTo(datetime2)<0 || datetime1.compareTo(datetime3)<0){
			verbose("Notifications is not 'Sorted by most recently edited' only");
			return false;
		}else if(noprofilefound.equals("No notification profiles found.")){
			verbose("No notification profiles found.");
			return true;
		}
		else{		
				return false;
		}
		
	}
	//TID-48 below methods
	// Sort the Notifications Index page by Zone
	private Boolean sortByZones() {
		waitExplicitly(1);
		By zone = By.xpath("//ps-option-dropdown/div/ul/li[2]/a");
		verbose("Clicking on AllNotifications");
		getElement(allNotifications).click();
		waitExplicitly(1);
		getElement(zone).click();
		
		if (getElement(event_title).getText().equals("Zone:")) {
			verbose("Notifications is listed by Zones only");
			return true;
		}else {
			error("Notifications is not listed by Zones only");
			return false;
		}
	}

	// Sort the Notifications Index page by SSASRealALERT
	private Boolean sortBySSASRealAlert() {
		waitExplicitly(1);
		By SSASRealAlert = By.xpath("//ps-option-dropdown/div/ul/li[3]/a");
		verbose("Clicking on AllNotifications");
		getElement(allNotifications).click();
		waitExplicitly(1);
		getElement(SSASRealAlert).click();
		if (getElement(event_title).getText().equals("SSAS Alert:")) {
			verbose("Notifications is listed by SSAS Alert only");
			return true;
		} else {
			error("Notifications is not listed by SSAS Alert only");
			return false;
		}
	}

	// Sort the Notifications Index page by SSASTestALERT
	private Boolean sortBySSASTestAlert() {
		waitExplicitly(1);
		By SSASRealAlert = By.xpath("//ps-option-dropdown/div/ul/li[4]/a");
		verbose("Clicking on AllNotifications");
		getElement(allNotifications).click();
		waitExplicitly(1);
		getElement(SSASRealAlert).click();
		if (getElement(event_title).getText().equals("SSAS Test Alert:")) {
			verbose("Notifications is listed by SSAS Test Alert only");
			return true;
		}else if(getElement(noprofilefound).getText().equals("No notification profiles found.")) {
			verbose("No Notification profiles found");
			return true;
		}else{
			error("Notifications is not listed by SSAS Test Alert only");
			return false;
		}
	}

	// Sort the Notifications Index page by Warning
	private Boolean sortByWarning() {
		waitExplicitly(1);
		//String profile = null;
		By Warning = By.xpath("//div/ul/li[5]/a");		
		verbose("Clicking on AllNotifications");
		getElement(allNotifications).click();
		waitExplicitly(1);
		getElement(Warning).click();
		verbose("Clicking on Warnings");
		String noprofile = getElement(noprofilefound).getText();
		verbose("The profile not found string is :" + noprofile);
		
		if (getElement(event_title).getText().equals("Warning:"))  {
			verbose("Notifications is listed by Warning only");
			return true;
		}else if(getElement(noprofilefound).getText().equals("No notification profiles found.")) {
			verbose("No Notification profiles found");
			return true;
		}else{
			error("Notifications is not listed by Warning only");
			return false;
		}
	}

	// Sort the Notifications Index page by Position
	private Boolean sortByPosition() {
		waitExplicitly(1);
		By Position = By.xpath("//div/ul/li[6]/a");
		verbose("Clicking on AllNotifications");
		getElement(allNotifications).click();
		waitExplicitly(1);
		getElement(Position).click();
		if (getElement(event_title).getText().equals("Position:")) {
			verbose("Notifications is listed by Position only");
			return true;
		}else{
			error("Notifications is not listed by Position only");
			return false;
		}
	}

	// Sort the Notifications Index page by OverduePosition
	private Boolean sortByOverduePosition() {
		waitExplicitly(1);
		By OverduePosition = By.xpath("//div/ul/li[7]/a");
		verbose("Clicking on AllNotifications");
		getElement(allNotifications).click();
		waitExplicitly(1);
		getElement(OverduePosition).click();
		if (getElement(event_title).getText().equals("Overdue Position:")) {
			verbose("Notifications is listed by Overdue Position only");
			return true;
		}else{
			error("Notifications is not listed by Overdue position only");
			return false;
		}
	}
	
	//Sort the Notifications Index page by Scheduled Report
	private Boolean sortByScheduledReport() {
		waitExplicitly(1);
		By ScheduledReport = By.xpath("//div/ul/li[8]/a");
		
		//*[@id="option-7"]
		verbose("Clicking on AllNotifications");
		getElement(allNotifications).click();
		waitExplicitly(1);
		getElement(ScheduledReport).click();
		if (getElement(event_title).getText().equals("Scheduled Report:")) {
			verbose("Notifications is listed by Scheduled Report only");
			return true;
		}else{
			error("Notifications is not listed by Scheduled Report only");
			return false;
		}
	}
	
	//Sort the Notifications Index page by Scheduled Report
	private Boolean sortByIncident() {
		waitExplicitly(1);
		By Incident = By.xpath("//div/ul/li[9]/a");
		verbose("Clicking on AllNotifications");
		getElement(allNotifications).click();
		waitExplicitly(1);
		getElement(Incident).click();
		if (getElement(event_title).getText().equals("Incident:")) {
			verbose("Notifications is listed by Incident only");
			return true;
		}else{
			error("Notifications is not listed by Incident only");
			return false;
		}
	}
	
	//Sort the Notifications Index page by Scheduled Report
	private Boolean sortByAmver() {
		waitExplicitly(1);
		By Amver = By.xpath("//div/ul/li[10]/a");
		verbose("Clicking on AllNotifications");
		getElement(allNotifications).click();
		waitExplicitly(1);
		getElement(Amver).click();
		if (getElement(event_title).getText().equals("AMVER:")) {
			verbose("Notifications is listed by AMVER: only");
			return true;
		}else{
			error("Notifications is not listed by AMVER: only");
			return false;
		}
	}
	
	//Sort the Notifications Index page by Scheduled Report
	private Boolean sortBySSRS() {
		waitExplicitly(1);
		By SSRS = By.xpath("//li[11]/a");
		verbose("Clicking on AllNotifications");
		getElement(allNotifications).click();
		waitExplicitly(1);
		getElement(SSRS).click();
		if (getElement(event_title).getText().equals("SSRS:")) {
			verbose("Notifications is listed by SSRS: only");
			return true;
		}else{
			error("Notifications is not listed by SSRS: only");
			return false;
		}
	}

	public Boolean areEventsSortedCorrectly(){
		
		int count = 0;
		waitExplicitly(3);
		if (sortByZones()==true){
			count++;			
		}
		waitExplicitly(3);
		if (sortBySSASRealAlert()==true){
			count++;
		}
		waitExplicitly(3);
		if (sortBySSASTestAlert()==true){
			count++;
		}
		waitExplicitly(3);
		if (sortByWarning()==true){
			count++;
		}
		waitExplicitly(3);
		if (sortByPosition()==true){
			count++;
		}
		waitExplicitly(3);
		if (sortByOverduePosition()==true){
			count++;
		}
		waitExplicitly(3);
		if (sortByScheduledReport()==true){
			count++;
		}
		waitExplicitly(3);
		if (sortByIncident()==true){
			count++;
		}
		waitExplicitly(3);
		if (sortByAmver()==true){
			count++;
		}
		waitExplicitly(3);
		if (sortBySSRS()==true){
			count++;
		}
		waitExplicitly(3);
		verbose("The count in sort by events is :" + count);
	
		if (count==10){
			return true;
		} else {
			return false;
		}
	}
// end of TID-48
	
	
	// Sort the Notification Index page "by name"
	public Boolean sortByName() {
		waitExplicitly(1);
		By sortByName = By.xpath("//ps-option-dropdown[2]/div/ul/li/a");
		By first_name = By.xpath("//div/span[2]");
		By second_name = By.xpath("//li[2]/ps-notification-list-details/a/div/div[2]/div/span[2]");
		
		getElement(sortByMostRecentlyEdited).click();
		waitExplicitly(1);
		getElement(sortByName).click();
		String first_name_text = getElement(first_name).getText();
		
		String second_name_text = getElement(second_name).getText();
	
		int compare = first_name_text.compareToIgnoreCase(second_name_text);
		if (compare < 0) {
			verbose("The page is sort by Name");
			return true;
		}else if(compare > 0){
			return false;
		}else{
			return true;
		}
	}

	// Sort the Notification Index page "Sort by Notification Type"
	public Boolean sortByNotificationType() {
		waitExplicitly(1);
		By sortByNotificationType = By.xpath("//ps-option-dropdown[2]/div/ul/li[2]/a");
	
		getElement(sortByMostRecentlyEdited).click();
		waitExplicitly(1);
		getElement(sortByNotificationType).click();
		if (getElement(sort_type).getText().equals("Sort by Notification Type")) {
			verbose("Notifications is 'sort by notification type' only");
			return true;
		}else{
			return false;
		}
	}

	// Sort the Notification Index page "Sort by most recently added"
	public Boolean sortByMostRecentlyAdded() throws Exception {
		waitExplicitly(1);
		By sortByMostRecentlyAdded = By.xpath("//ps-option-dropdown[2]/div/ul/li[3]/a");

		getElement(sortByMostRecentlyEdited).click();
		
		waitExplicitly(1);
		getElement(sortByMostRecentlyAdded).click();
		By date1 = By.xpath("//div[4]/div[2]");
		String newdate1 = getElement(date1).getText();
		verbose("The new date1 is :" + newdate1);
		String datetime1 = newdate1.substring(0, 17);
		By date2 = By.xpath("//li[2]/ps-notification-list-details/a/div/div[2]/div[4]/div[2]");
		String newdate2 = getElement(date2).getText();
		verbose("The new date2 is :" + newdate2);
		String datetime2 = newdate2.substring(0, 17);
		if (datetime1.compareTo(datetime2)>0) {
			verbose("Notifications is 'Sort by most recently added' only");
			return true;
		}else{
			return false;
		}
	}
	
	// Search for the notification profile
	public Boolean searchNotificationProfile(String name) {
		waitExplicitly(1);
		By searchBox = By.xpath("//input");
		
		By search_contains = By.xpath("//div/span[2]");
		By no_notifications = By.xpath("//div[2]/div[2]/div[2]");
		waitExplicitly(2);
		getElement(searchBox).clear();
		waitExplicitly(2);
		getElement(searchBox).click();
		verbose("Typing in the search box....");
		waitExplicitly(5);
		getElement(searchBox).sendKeys(name);
		waitExplicitly(5);
		if(getElement(search_contains).getText().equals(name)){
			verbose("Search is successful");	
			return true;
		}else{
			return false; 
		}
	}
	
	public void deleteexistingNotificationProfile(String name) {
		waitExplicitly(1);
		
		String existingnotificationname = "Automation";
		By searchBox = By.xpath("//input");	
		By delete_button = By.xpath("//ps-notification-index/div/ps-notification-detailview/aside/form/div/a[1]");
		By search_contains = By.xpath("//div/span[2]");
		By no_notifications = By.xpath("//div[2]/div[2]/div[2]");
		waitExplicitly(2);
		getElement(searchBox).clear();
		waitExplicitly(2);
		getElement(searchBox).click();
		verbose("Typing the existing notifications created through automation scripts in the search box....");
		waitExplicitly(3);
		getElement(searchBox).sendKeys(existingnotificationname);
		waitExplicitly(2);
							
		if(getElement(search_contains).getText().contains(name)){
			  getElement(sidePanel_click).click();
			  waitExplicitly(3);
			  getElement(delete_button).click();
			  waitExplicitly(3);
			verbose("Existing Notifications created through aution is deleted");	
			getElement(searchBox).clear();
			getElement(searchBox).click();
			getElement(searchBox).sendKeys(existingnotificationname);
			if(getElement(search_contains).getText().contains(name)){
				getElement(sidePanel_click).click();
				  waitExplicitly(2);
				  getElement(delete_button).click();
				  waitExplicitly(3);
				verbose("Existing Notifications created through aution is deleted");
				if(getElement(search_contains).getText().contains(name)){
					getElement(sidePanel_click).click();
					  waitExplicitly(2);
					  getElement(delete_button).click();
					  waitExplicitly(3);
					verbose("Existing Notifications created through aution is deleted");
		}else{
			verbose("No notification profiles found");	
		}
	}
	}
	}
	 //Viewing the existing notification profile ;
	  public boolean sidePanel(String name,String name_edit){
	  searchNotificationProfile(name);
	  By section_incomplete = By.xpath("//ps-notification-detailview/aside/form/ps-accordion/div/ps-accordion-item[3]/div[1]/h4/ps-accordion-heading/div");
	
	  
	  By sidePanel_ship =  By.xpath("//ps-accordion-heading"); 
	  By search_box = By.xpath("//form/div/input");
	  By sidePanel_shipname =  By.xpath("//h5"); 
 
	  By save_button =  By.xpath("//form/div/button"); 
	  By event_type =  By.xpath("//ps-notification-detailview/aside/form/ps-accordion/div/ps-accordion-item[2]/div[1]/h4/ps-accordion-heading"); 
	  By side_panel_ship_click = By.xpath("//form/div/input");
	  By all_event_selected =  By.xpath("//label/input"); 
	  By specific_event1 =  By.xpath("//div[2]/div/div/label"); 
	  By specific_event2 =  By.xpath("//div[2]/label/input"); 
	  By specific_event3 =  By.xpath("//div[3]/label/input"); 
	  By specific_event4 =  By.xpath("//div[4]/label/input"); 
	  By specific_event5 =  By.xpath("//div[5]/label/input"); 
	  By recipient_sidepanel = By.xpath("//ps-accordion/div/ps-accordion-item[3]/div[1]/h4/ps-accordion-heading");
	  By recipient_textbox = By.xpath("//div/div/div/input");
	  By recipient_delete = By.xpath("//ul/li/button/span");

	  getElement(sidePanel_click).click(); 
	  verbose("Click on ships...");
	  getElement(sidePanel_ship).click(); 
	  verbose("The ship name entered is: " + getElement(sidePanel_shipname).getText()); 
	  int random = randInt(1,3);
	  verbose("The random number selected is :" + random);
		waitExplicitly(3);
		if(random == 1){
			waitExplicitly(2);
			select_ship("hon",side_panel_ship_click);
		}else if(random == 2){
			waitExplicitly(2);
			select_fleet("FLEE",side_panel_ship_click);
		}else{
			waitExplicitly(2);
			select_account("pole",side_panel_ship_click);
		}

	  verbose("Clicking on the Event type"); 
	  waitExplicitly(2);
	  getElement(event_type).click(); 
	  if(getElement(event_type).getText().equals("Position events")){
		  waitExplicitly(1); 
		  if(getElement(all_event_selected).isSelected()){
			  	waitExplicitly(1); 
		  		verbose("All position events is selected"); }
		  else{
			  	verbose("Specific position events is selected");
			  	if(getElement(specific_event1).isSelected()){ 
			  		getElement(specific_event1).click();
			  		verbose("AIS is unselected");
			  	}else if(getElement(specific_event2).isSelected()){ 
			  		verbose("DSAS is selected"); 
			  	}else if(getElement(specific_event3).isSelected()){
			  		getElement(specific_event3).click();
			  		verbose("Skywave is unselected"); 
			  	}else if(getElement(specific_event4).isSelected()){ 
			  		verbose("Globalstar is selected"); 
			  	}else { 
			  		verbose("SATC is selected"); 
			  	} 
		  	}
	  	}

	  if (getElement(event_type).getText().equals("SSAS Test Alert events")){
	  		waitExplicitly(1);
	  			if(getElement(all_event_selected).isSelected()){ 
	  				waitExplicitly(1);
	  				verbose("All test alert events selected"); 
	  			}else{ 
	  				verbose("Specific test alert events selected"); 
	  				if(getElement(specific_event2).isSelected()){
	  					getElement(specific_event2).click();
	  				} else if(getElement(specific_event1).isSelected()){
	  					verbose("Initiated is selected");
	  				}else if(getElement(specific_event3).isSelected()){
	  					getElement(specific_event3).click();
				  		verbose("Reset is unselected"); 
				  	}else if(getElement(specific_event4).isSelected()){ 
				  		verbose("Reset Failed is selected"); 
				  	}else { 
				  		verbose("Mode is selected"); 
				  	} 
	  				
	  			}
	  	}
	  
	  if(getElement(event_type).getText().equals("Zone events")){
	  		waitExplicitly(3);
	  			if(getElement(all_event_selected).isSelected()){
	  				waitExplicitly(3);
	  				verbose("All zone events selected"); 
	  			}else{ 
	  				verbose("Specific zone events selected"); 
	  				if(getElement(specific_event1).isSelected()){ 
				  		verbose("Entry is selected");
				  	}else if(getElement(specific_event2).isSelected()){ 
				  		verbose("Exit is selected"); 
				  	}else if(getElement(specific_event3).isSelected()){
				  		getElement(specific_event3).click();
				  		verbose("Entry time changed is unselected"); 
				  	}else if(getElement(specific_event4).isSelected()){ 
				  		verbose("Exit time changed  is selected"); 
				  	}else if(getElement(specific_event5).isSelected()){ 
				  		verbose("Entry then exit is selected"); 
				  	} else { 
				  		verbose("Exit then re-enter is selected"); 
				  	}
	  			}
	  	}
getElement(recipient_sidepanel).click();
	  
	  verbose("receipt expanded");
	  waitExplicitly(2);	
	  
	  By recipientdelete = By.xpath("//ps-accordion-item[3]/div[2]/div/ps-notification-panel-recipients/ul/li/button");
	  
	  
	  verbose("found receipt delete");
	
	  getElement(recipientdelete).click();
	  
	  verbose("receipt delete clicked");
	  
	  Actions action = new Actions(getDriver());
	  WebElement tool_tip = getElement(section_incomplete);
	  action.moveToElement(tool_tip).build().perform();
	  String tool_tip_text = tool_tip.getAttribute("data-tooltip");
	  
	  verbose("The tool-tip is: " + tool_tip_text);
	  
	  if(tool_tip_text.equals("Section incomplete")){
		  select_recipient("shr", 1,recipient_textbox );
	  }
	  waitExplicitly(2);
	  getElement(name_save).click();
	  getElement(name_field).clear();
	  waitExplicitly(2);
	  getElement(name_field).sendKeys(name_edit);
	  waitExplicitly(2);
	  getElement(save_button).click();
	  waitExplicitly(2);
	  
	  return true;
	 
	 /* verbose("Closing the side panel using the cancel button");
	  getElement(cancel_button).click();*/ 
	  }
	  
	  
	  //Below sidePanel_AMVER method is for editing AMVER notification profiles
	  
	  public boolean sidePanel_AMVER(String name,String name_edit){
		  searchNotificationProfile(name);
		  By section_incomplete = By.xpath("//ps-accordion-item[3]/div[1]/h4/ps-accordion-heading/div");
		
		  
		  By sidePanel_ship =  By.xpath("//ps-accordion-heading"); 
		  By search_box = By.xpath("//form/div/input");
		  By sidePanel_shipname =  By.xpath("//h5"); 
	 
		  By save_button =  By.xpath("//form/div/button"); 
		  By event_type =  By.xpath("//ps-accordion/div/ps-accordion-item[2]/div[1]/h4/ps-accordion-heading"); 
		  
		  By side_panel_ship_click = By.xpath("//form/div/input");
		  By all_event_selected =  By.xpath("//label/input"); 
		  By specific_event1 =  By.xpath("//div[2]/div/div/label"); 
		  By specific_event2 =  By.xpath("//div[2]/label/input"); 
		  By specific_event3 =  By.xpath("//div[3]/label/input"); 
		  By specific_event4 =  By.xpath("//div[4]/label/input"); 
		  By specific_event5 =  By.xpath("//div[5]/label/input"); 
		  By recipient_sidepanel = By.xpath("//ps-accordion-item[3]/div/div/h4/ps-accordion-heading");
		  By recipient_textbox = By.xpath("//div/div/div/input");
		  By recipient_delete = By.xpath("//ul/li/button/span");

		  getElement(sidePanel_click).click(); 
		  verbose("Click on ships...");
		  getElement(sidePanel_ship).click(); 
		  verbose("The ship name entered is: " + getElement(sidePanel_shipname).getText()); 
		  int random = randInt(1,3);
		  verbose("The random number selected is :" + random);
			waitExplicitly(3);
			if(random == 1){
				waitExplicitly(2);
				select_ship("hon",side_panel_ship_click);
			}else if(random == 2){
				waitExplicitly(2);
				select_fleet("FLEE",side_panel_ship_click);
			}else{
				waitExplicitly(2);
				select_account("pole",side_panel_ship_click);
			}

		  verbose("Clicking on the Event type"); 
		  waitExplicitly(2);
		  getElement(event_type).click(); 
		  if(getElement(event_type).getText().equals("Position events")){
			  waitExplicitly(1); 
			  if(getElement(all_event_selected).isSelected()){
				  	waitExplicitly(1); 
			  		verbose("All position events is selected"); }
			  else{
				  	verbose("Specific position events is selected");
				  	if(getElement(specific_event1).isSelected()){ 
				  		getElement(specific_event1).click();
				  		verbose("AIS is unselected");
				  	}else if(getElement(specific_event2).isSelected()){ 
				  		verbose("DSAS is selected"); 
				  	}else if(getElement(specific_event3).isSelected()){
				  		getElement(specific_event3).click();
				  		verbose("Skywave is unselected"); 
				  	}else if(getElement(specific_event4).isSelected()){ 
				  		verbose("Globalstar is selected"); 
				  	}else { 
				  		verbose("SATC is selected"); 
				  	} 
			  	}
		  	}

		  if (getElement(event_type).getText().equals("SSAS Test Alert events")){
		  		waitExplicitly(1);
		  			if(getElement(all_event_selected).isSelected()){ 
		  				waitExplicitly(1);
		  				verbose("All test alert events selected"); 
		  			}else{ 
		  				verbose("Specific test alert events selected"); 
		  				if(getElement(specific_event2).isSelected()){
		  					getElement(specific_event2).click();
		  				} else if(getElement(specific_event1).isSelected()){
		  					verbose("Initiated is selected");
		  				}else if(getElement(specific_event3).isSelected()){
		  					getElement(specific_event3).click();
					  		verbose("Reset is unselected"); 
					  	}else if(getElement(specific_event4).isSelected()){ 
					  		verbose("Reset Failed is selected"); 
					  	}else { 
					  		verbose("Mode is selected"); 
					  	} 
		  				
		  			}
		  	}
		  
		  if(getElement(event_type).getText().equals("Zone events")){
		  		waitExplicitly(3);
		  			if(getElement(all_event_selected).isSelected()){
		  				waitExplicitly(3);
		  				verbose("All zone events selected"); 
		  			}else{ 
		  				verbose("Specific zone events selected"); 
		  				if(getElement(specific_event1).isSelected()){ 
					  		verbose("Entry is selected");
					  	}else if(getElement(specific_event2).isSelected()){ 
					  		verbose("Exit is selected"); 
					  	}else if(getElement(specific_event3).isSelected()){
					  		getElement(specific_event3).click();
					  		verbose("Entry time changed is unselected"); 
					  	}else if(getElement(specific_event4).isSelected()){ 
					  		verbose("Exit time changed  is selected"); 
					  	}else if(getElement(specific_event5).isSelected()){ 
					  		verbose("Entry then exit is selected"); 
					  	} else { 
					  		verbose("Exit then re-enter is selected"); 
					  	}
		  			}
		  	}
		  
		 /* getElement(recipient_sidepanel).click();
		  waitExplicitly(2);	
		
		  getElement(recipient_delete).click();
		  
		  Actions action = new Actions(getDriver());
		  WebElement tool_tip = getElement(section_incomplete);
		  action.moveToElement(tool_tip).build().perform();
		  String tool_tip_text = tool_tip.getAttribute("data-tooltip");
		  
		  verbose("The tool-tip is: " + tool_tip_text);
		  
		  if(tool_tip_text.equals("Section incomplete")){
			  select_recipient("shr", 1,recipient_textbox );
		  }*/
		  waitExplicitly(4);
		  /*getElement(name_save).click();*/
		  getElement(name_field).clear();
		  waitExplicitly(2);
		  getElement(name_field).sendKeys(name_edit);
		  waitExplicitly(4);
		  getElement(save_button).click();
		  waitExplicitly(2);
		  
		  return true;
		 
		 /* verbose("Closing the side panel using the cancel button");
		  getElement(cancel_button).click();*/ 
		  }
	 
//Below sidePanel_SSRS method is for editing AMVER notification profiles
	  
	  public boolean sidePanel_SSRS(String name,String name_edit){
		  searchNotificationProfile(name);
		  
		  By sidePanel_ship =  By.xpath("//ps-accordion-heading"); 
		  By search_box = By.xpath("//form/div/input");
		  By sidePanel_shipname =  By.xpath("//h5"); 
	 
		  By save_button =  By.xpath("//form/div/button"); 
		  By event_type =  By.xpath("//ps-accordion-item[2]/div/div/h4/ps-accordion-heading"); 
		  By side_panel_ship_click = By.xpath("//form/div/input");
		  By all_event_selected =  By.xpath("//label/input"); 
		  By specific_event1 =  By.xpath("//div[2]/div/div/label"); 
		  By specific_event2 =  By.xpath("//div[2]/label/input"); 
		  By specific_event3 =  By.xpath("//div[3]/label/input"); 
		  By specific_event4 =  By.xpath("//div[4]/label/input"); 
		  By specific_event5 =  By.xpath("//div[5]/label/input"); 
		  By recipient_sidepanel = By.xpath("//ps-accordion-item[3]/div/div/h4/ps-accordion-heading");
		  By recipient_textbox = By.xpath("//div/div/div/input");
		  By recipient_delete = By.xpath("//li/button");

		  getElement(sidePanel_click).click(); 
		  verbose("Click on ships...");
		  getElement(sidePanel_ship).click(); 
		  verbose("The ship name entered is: " + getElement(sidePanel_shipname).getText()); 
		  int random = randInt(1,3);
		  verbose("The random number selected is :" + random);
			waitExplicitly(3);
			if(random == 1){
				waitExplicitly(2);
				select_ship("hon",side_panel_ship_click);
			}else if(random == 2){
				waitExplicitly(2);
				select_fleet("FLEE",side_panel_ship_click);
			}else{
				waitExplicitly(2);
				select_account("pole",side_panel_ship_click);
			}

		  /*verbose("Clicking on the Event type"); 
		  waitExplicitly(2);
		  getElement(event_type).click(); 
		  if(getElement(event_type).getText().equals("Position events")){
			  waitExplicitly(1); 
			  if(getElement(all_event_selected).isSelected()){
				  	waitExplicitly(1); 
			  		verbose("All position events is selected"); }
			  else{
				  	verbose("Specific position events is selected");
				  	if(getElement(specific_event1).isSelected()){ 
				  		getElement(specific_event1).click();
				  		verbose("AIS is unselected");
				  	}else if(getElement(specific_event2).isSelected()){ 
				  		verbose("DSAS is selected"); 
				  	}else if(getElement(specific_event3).isSelected()){
				  		getElement(specific_event3).click();
				  		verbose("Skywave is unselected"); 
				  	}else if(getElement(specific_event4).isSelected()){ 
				  		verbose("Globalstar is selected"); 
				  	}else { 
				  		verbose("SATC is selected"); 
				  	} 
			  	}
		  	}

		  if (getElement(event_type).getText().equals("SSAS Test Alert events")){
		  		waitExplicitly(1);
		  			if(getElement(all_event_selected).isSelected()){ 
		  				waitExplicitly(1);
		  				verbose("All test alert events selected"); 
		  			}else{ 
		  				verbose("Specific test alert events selected"); 
		  				if(getElement(specific_event2).isSelected()){
		  					getElement(specific_event2).click();
		  				} else if(getElement(specific_event1).isSelected()){
		  					verbose("Initiated is selected");
		  				}else if(getElement(specific_event3).isSelected()){
		  					getElement(specific_event3).click();
					  		verbose("Reset is unselected"); 
					  	}else if(getElement(specific_event4).isSelected()){ 
					  		verbose("Reset Failed is selected"); 
					  	}else { 
					  		verbose("Mode is selected"); 
					  	} 
		  				
		  			}
		  	}
		  
		  if(getElement(event_type).getText().equals("Zone events")){
		  		waitExplicitly(3);
		  			if(getElement(all_event_selected).isSelected()){
		  				waitExplicitly(3);
		  				verbose("All zone events selected"); 
		  			}else{ 
		  				verbose("Specific zone events selected"); 
		  				if(getElement(specific_event1).isSelected()){ 
					  		verbose("Entry is selected");
					  	}else if(getElement(specific_event2).isSelected()){ 
					  		verbose("Exit is selected"); 
					  	}else if(getElement(specific_event3).isSelected()){
					  		getElement(specific_event3).click();
					  		verbose("Entry time changed is unselected"); 
					  	}else if(getElement(specific_event4).isSelected()){ 
					  		verbose("Exit time changed  is selected"); 
					  	}else if(getElement(specific_event5).isSelected()){ 
					  		verbose("Entry then exit is selected"); 
					  	} else { 
					  		verbose("Exit then re-enter is selected"); 
					  	}
		  			}
		  	}*/
		  
		  /*getElement(recipient_sidepanel).click();
		  waitExplicitly(2);	
		
		  getElement(recipient_delete).click();
		  
		  Actions action = new Actions(getDriver());
		  WebElement tool_tip = getElement(section_incomplete);
		  action.moveToElement(tool_tip).build().perform();
		  String tool_tip_text = tool_tip.getAttribute("data-tooltip");
		  
		  verbose("The tool-tip is: " + tool_tip_text);
		  
		  if(tool_tip_text.equals("Section incomplete")){
			  select_recipient("shr", 1,recipient_textbox );
		  }*/
		  waitExplicitly(2);
		  /*getElement(name_save).click();*/
		  getElement(name_field).clear();
		  waitExplicitly(2);
		  getElement(name_field).sendKeys(name_edit);
		  waitExplicitly(2);
		  getElement(save_button).click();
		  waitExplicitly(2);
		  
		  return true;
		 
		 /* verbose("Closing the side panel using the cancel button");
		  getElement(cancel_button).click();*/ 
		  }
	  
	  public boolean delete_profile(String profile){
		  searchNotificationProfile(profile);
		  By cancel_button = By.xpath("//a[2]"); 
		  By delete_button = By.xpath("//ps-notification-index/div/ps-notification-detailview/aside/form/div/a[1]");

		  By no_notifications = By.xpath("//ps-notifications/ps-notification-index/div/div[2]/div[2]/div");
		  getElement(sidePanel_click).click();
		  waitExplicitly(5);
		  //getElement(name_save).click();
		  waitExplicitly(5);
		  getElement(delete_button).click();
		  waitExplicitly(5);
		  if(getElement(no_notifications).getText().equals("No notification profiles found.")){
				verbose("Delete is successful");
				return true;
			}
			else{
				return false; 
			}
		 
	  }
	
	// Creating a new notification profile
	public Boolean newNotification_by_zone_default() {

		waitExplicitly(1);
		
	    select_event_type("Zone");

		verbose("Creating the notification profile with default setting...");

		add_recipients();
		
		//name_and_save();

		getElement(name_field).sendKeys(profile_title_zone_default);
		verbose("Section..." + getElement(name_this_notification).getText());
		waitExplicitly(2);

		notifications_summary_default(1);
		
		waitExplicitly(3);
		verbose("Clicking on save");
		waitExplicitly(3);
		getElement(save_profile).click();
		waitExplicitly(3);
		
		verbose("Clicking on Done");
		getElement(done).click();
		waitExplicitly(3);
		verbose("Get Page header :" + getElement(newNotification_header).getText());
		if(searchNotificationProfile(profile_title_zone_default).TRUE){
			verbose("Notification profile is successfully created");
			return true;
		}else{
			return false;
		}
	}
	
	public void add_recipients(){
		int count = 1;
		int zones_default = 1;
		verbose("Selecting the recipients :");
		getElement(zoe_receiptent_heading).click();
		/*getElement(next).click();*/
		waitExplicitly(2);
		By recipient_textbox = By.xpath("//ps-recipient-search/form/div/div/div/input");
		select_recipient("sree",count,recipient_textbox);
/*		count++;
		select_recipient("raj",count,recipient_textbox);
		count++;
		select_recipient("aru",count,recipient_textbox);*/
		waitExplicitly(2);
		getElement(zoe_name_heading).click();
		/*getElement(next).click();*/
	}
	
	public Boolean newNotification_by_zone_specific() {
		int attempt = 2;
		By recipient_textbox2 = By.xpath("//div/div/div/input");
		 verbose("Creating new Notification profile with zones Specific events and Specific zones");
		 //getElement(add_new_event).click(); waitExplicitly(2);

		 select_event_type("Zone");
		 
		 if(getElement(ship_click).isSelected()){ 
			 verbose("Selecting Specific zones"); 
			 getElement(specific_zone).click();
		 waitExplicitly(2); 
		 verbose("Clicking on Zones search box and searching for the Zone type");
		 getElement(zone_search).click();
		 verbose("Typing 'India' in the search field..." );
		 getElement(zone_search).sendKeys("india");//'I' needs to be upper case when the defect is fixed. 
		 getElement(specific_zone_JWC).click();
		 getElement(specific_zone_loadline).click();
		 getElement(specific_zone_Navarea).click(); }
	
		 if(getElement(all_events).isSelected()){ 
			 verbose("Selecting Specific events"); 
			 getElement(specific_events).click();
		 getElement(specific_events_entry).click(); 
		 verbose("The event selected is : " +getElement(specific_event_entry_text).getText()); 
		 for(int i = 2 ; i <= 6 ; i++){ 
			 getElement(By.xpath("//div[" + i + "]/label/input")).click();
			 verbose("The event selected is : " + getElement(By.xpath("//div[" + i + "]/label")).getText()); 
			 }
		 } 
		 add_recipients();
		 
		 getElement(name_field).sendKeys(profile_title_zone_specific);  

		 waitExplicitly(2);
		 
		 notifications_summary_default(attempt);
		 
		 waitExplicitly(3);
			verbose("Clicking on save");
			waitExplicitly(3);
			getElement(save_profile).click();
			waitExplicitly(3);
		 
		verbose("Clicking on Done");
		getElement(done).click();
		waitExplicitly(3);
		verbose("Get Page header :" + getElement(newNotification_header).getText());
		if(searchNotificationProfile(profile_title_zone_specific).TRUE){
			verbose("Profile is successfully created");
			return true;
		}else{
			return false;
		}

	}

	public void click_onNewnotification(){
		verbose("Clicking on new notification");
		getElement(newNotification).click();
		if (getElement(newNotification_header).getText().equals("New notification: Add ships")) {
			verbose("User is in ---" + getElement(newNotification_header).getText());
			verbose("Help text ---" + getElement(help_text_addships).getText());
		}
	}
	
	public void select_ship(String ship,By ship_click){
	/*
		Actions action = new Actions(getDriver());
		WebElement tool_tip = getElement(change_ship_selection_ship);
		action.moveToElement(tool_tip).build().perform();
		String tool_tip_text = tool_tip.getAttribute("data-tooltip");
		verbose("The tool-tip in select_ship is : " + tool_tip_text);*/
		getElement(by_ship).click();
		verbose("Panel title before ships are added :" + getElement(panel_title).getText());
		getElement(ship_click).click();

		getElement(ship_click).sendKeys(ship);
		getElement(ship_select).click();
		verbose("Ship selected is :" + getElement(ship_selected).getText());
		verbose("Panel title after ships are added :" + getElement(panel_title).getText());
		
	}
	
	public void select_fleet(String fleet,By ship_click){
		By fleet_click = By.xpath("//div[2]/button");
		/*Actions action = new Actions(getDriver());
		WebElement tool_tip = getElement(change_ship_selection_fleet);
		action.moveToElement(tool_tip).build().perform();
		String tool_tip_text = tool_tip.getAttribute("data-tooltip");
		verbose("The tool-tip in select_ship is : " + tool_tip_text);*/
		
		getElement(fleet_click).click();
		verbose("Panel title before fleets are added :" + getElement(panel_title).getText());
		getElement(ship_click).click();
		getElement(ship_click).sendKeys(fleet);
		getElement(fleet_select).click();
		verbose("Fleet selected is :" + getElement(ship_selected).getText());
		verbose("Panel title after Fleet is added :" + getElement(panel_title).getText());
		/*Actions action = new Actions(getDriver());
		action.moveToElement(getElement(ship_click)).build().perform();
		verbose("The tool-tip is: " + getElement(tool_tip_ships).getText());*/

	}
	
	public void select_account(String fleet,By ship_click){
		By account_click = By.xpath("//div[3]/button");
		/*Actions action = new Actions(getDriver());
		WebElement tool_tip = getElement(change_ship_selection_account);
		action.moveToElement(tool_tip).build().perform();
		String tool_tip_text = tool_tip.getAttribute("data-tooltip");
		verbose("The tool-tip in select_ship is : " + tool_tip_text);
		*/
		getElement(account_click).click();
		verbose("Panel title before fleets are added :" + getElement(panel_title).getText());
		getElement(ship_click).click();
		getElement(ship_click).sendKeys(fleet);
		getElement(account_select).click();
		verbose("Fleet selected is :" + getElement(ship_selected).getText());
		verbose("Panel title after Fleet is added :" + getElement(panel_title).getText());
		/*Actions action = new Actions(getDriver());
		action.moveToElement(getElement(ship_click)).build().perform();
		verbose("The tool-tip is: " + getElement(tool_tip_ships).getText());*/

	}
	
	public void select_recipient(String name, int count, By recipient_textbox) {
		By recipients = By.xpath("//ps-accordion-item[2]/div/div/h4/a");		
		By recipient_select = By.xpath("//strong");
		By format_click = By.xpath("//div/span[1]/ps-multiselect-dropdown");
		By html_format = By.xpath("//div/span[1]/ps-multiselect-dropdown/div/ul/li[3]/a/label");
		By xml_format = By.xpath("//div/span[1]/ps-multiselect-dropdown/div/ul/li[5]/a/label");
		By recipient_add = By.xpath("//span[2]/button");
	
		//getElement(recipients).click();
		waitExplicitly(1);
	
		if (count == 1) {
			getElement(recipient_textbox).sendKeys(name);
			waitExplicitly(2);
		
		} else if(count == 2) {
		getElement(recipient_textbox).sendKeys(name);
		waitExplicitly(2);
		
		}else{
			getElement(recipient_textbox).sendKeys(name);
			waitExplicitly(2);
			
		}		
	
		verbose("recipient selected is :" + getElement(recipient_select).getText());
		getElement(recipient_select).click();
		waitExplicitly(2);
		verbose("Select the format");
		getElement(format_click).isEnabled();
		verbose("Selecting HTML Email format");
		waitExplicitly(3);
		getElement(html_format).click();
		//getElement(xml_format).click();
		waitExplicitly(3);
		verbose("Click on Add");
		getElement(recipient_add).click();
	}

	/*public void name_and_save() {
		By name_save = By.xpath("//ps-accordion-item[3]/div/div/h4/a");
		By name_this_notification_text = By.xpath("//ps-notification-panel-name/div/div/div/div");
		
		//verbose("Section..." + getElement(name_this_notification).getText());
		verbose("Click on Name&Save");
		//getElement(name_save).click();
		verbose("Section..." + getElement(name_this_notification_text).getText());
	}*/

	public void notifications_summary_default(int events) {
		By zones_all = By.xpath("//div/div/div[2]/div/div[4]");
		By zones_specific = By.xpath("//div[4]/div[2]/span/span");
		By SSAS_Alert_events = By.xpath("//div[3]/div[2]/span/span");
		By Position_Alert_events = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span");
		verbose("Notifications Summary...");
		verbose("The profile name is..." + getElement(name_field).getText());
		verbose("Name :			" + getElement(summary_name).getText());
		verbose("Ships :		" + getElement(summary_ships).getText());
		waitExplicitly(3);
		switch(events){
		case 1:			
			verbose("Zone events :	" + getElement(zone_events).getText());
			verbose("Zones :		" + getElement(zones_all).getText());
			verbose("Recipients :	" + getElement(recipients_summary).getText());
			break;
		case 2:			
			verbose("Zone events :	" + getElement(zone_events).getText());
			verbose("Zones :		" + getElement(zones_specific).getText());
			verbose("Recipients :	" + getElement(recipients_summary).getText());
			break;
		case 3:
			verbose("SSAS_Alert_events_default :		" + getElement(SSAS_Alert_events).getText());
			verbose("Recipients :	" + getElement(recipients_summary_3).getText());
			break;
		case 4:
			verbose("SSAS_Alert_events_specific :		" );			
			verbose("SSAS_Alert_events_specific :		" + getElement(SSAS_Alert_events).getText());	
				for(int i = 2; i <= 4; i++){				
				verbose(getElement(By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[3]/div[2]/span/span[1][ " + i + "]")).getText());
				
				
				
				}
				
			verbose("Recipients :	" + getElement(recipients_summary_3).getText());
			break;
		case 5:
			verbose("SSASTest_Alert_events_default :		" + getElement(SSAS_Alert_events).getText());
			verbose("Recipients :	" + getElement(recipients_summary_3).getText());
			break;
		case 6:
			verbose("SSASTest_Alert_events_specific :		" + getElement(SSAS_Alert_events).getText());					
			/*for(int i = 2; i <= 4; i++){
				verbose(getElement(By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[1]/div[2][ " + i + "]")).getText());
				
			}*/
			verbose(getElement(By.xpath("//span[5]")).getText());
			
			verbose("Recipients :	" + getElement(recipients_summary_3).getText());
			break;
		case 7:
			verbose("Warning events: " + getElement(SSAS_Alert_events).getText());
			verbose("Recipients :	" + getElement(recipients_summary_3).getText());
			break;
		case 8:
			verbose("Warning events: " );
			if(getElement(SSAS_Alert_events).isDisplayed()){
				getElement(SSAS_Alert_events).getText();
			}
			for(int i = 2; i <= 4; i++){				
				
					verbose(getElement(By.xpath("//span/span[ "+ i + "]")).getText());
				
			}
			
				verbose(getElement(By.xpath("//span[5]")).getText());
			
			
				verbose(getElement(By.xpath("//span[6]")).getText());
				
			verbose("Recipients :	" + getElement(recipients_summary_3).getText());
			break;
	case 9:
		verbose("Position_events_default :		" + getElement(Position_Alert_events).getText());
		verbose("Recipients :	" + getElement(recipients_summary_3).getText());
		break;
	case 10:			
		verbose("Position_events_default_specific :		" + getElement(Position_Alert_events).getText());	
			for(int i = 2; i <= 4; i++){				
			verbose(getElement(By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[1]/div[2][ "+ i + "]")).getText());	
				
			}
		
			verbose("Recipients :	" + getElement(recipients_summary_3).getText());
		
		waitExplicitly(3);
		verbose("Clicking on save");
		waitExplicitly(3);
		getElement(save_profile).click();
		waitExplicitly(3);
	}
	}
	public boolean edit_ZoneDefault_profile(){
		verbose("**********Editing the notification profile******");
		if(sidePanel(profile_title_zone_default,name_edit1)){
			verbose("**********Successfully edited**********");
			return true;
		}else {
			return false;
		}
				
	}

	public Boolean delete_ZoneDefault_profile(){
		verbose("******Deleting the profile********");
		if(delete_profile(name_edit1)){
			return true;
		}else {
			return false;
		}		
	}
	
	public boolean edit_ZoneSpecific_profile(){
		verbose("**********Editing the notification profile******");
		if(sidePanel(profile_title_zone_specific,name_edit2)){
			verbose("**********Successfully edited**********");
			return true;
		}else {
			return false;
		}
				
	}

	public Boolean delete_ZoneSpecific_profile(){
		verbose("******Deleting the profile********");
		if(delete_profile(name_edit2)){
			return true;
		}else {
			return false;
		}		
	}
	
	public static int randInt(int min, int max) {
	    
	    Random rand = new Random();
    
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

	public void select_event_type(String Event){
		// By specific_events_exit = By.xpath("//div[2]/label/input");
		By SSASTest_alert = By.xpath("//li[3]/div");
		By SSAS_alert = By.xpath("//li[2]/div");
		By Warning = By.xpath("//li[4]/div");
		By Position = By.xpath("//li[5]/div");
		By Overdue_Position = By.xpath("//li[6]/div");
		By ScheduledReport = By.xpath("//li[7]/div");
		By Incident = By.xpath("//li[8]/div");
		By AMVER = By.xpath("//li[9]/div");
		By SSRS = By.xpath("//li[10]/div");
		click_onNewnotification();		

		waitExplicitly(1);

		int random = randInt(1,3);
		verbose("The random number selected is :" + random);
		
		if(random == 1){
			select_ship("QAT",ship_click);
		}else if(random == 2){
			select_fleet("FLEE",ship_click);
		}else{
			select_account("pole",ship_click);
		}

		verbose("Cliking on next page...");
		getElement(ship_next).click();

		if (getElement(newNotification_header).getText().equals("New notification: Notification types")) {
			verbose("User is in Notification types page: " + getElement(newNotification_header).getText());
			verbose("Help text ---" + getElement(help_text_addships).getText());
		}
		waitExplicitly(2);
		verbose("Panel title in the notifications type page:" + getElement(panel_title).getText());
		verbose("View the ship added...");
		getElement(ship_view).click();
		waitExplicitly(2);
		verbose("The ship added for notification profile is...: " + getElement(ship_selected).getText());
		verbose("Closing the ship_view...");
		getElement(ship_view_close).click();
		waitExplicitly(2);
		
		if(Event.equals("SSASTest_alert")){
			verbose("Selecting the 'SSASTest_alert' notification type");
			getElement(SSASTest_alert).click();
			waitExplicitly(2);
		}else if(Event.equals("SSAS_alert")){
			verbose("Selecting the 'SSAS_alert' notification type");
			getElement(SSAS_alert).click();
			waitExplicitly(2);
		}else if(Event.equals("Zone")){
			verbose("Selecting the 'Zones' notification type");
			getElement(zone).click();
			waitExplicitly(2);
		}else if(Event.equals("Warning")){
			verbose("Selecting the 'Warning' notification type");
			getElement(Warning).click();
			waitExplicitly(2);
		}else if(Event.equals("Position")){
			verbose("Selecting the 'Position' notification type");
			getElement(Position).click();
			waitExplicitly(2);
		}else if(Event.equals("Overdue_Position")){
			verbose("Selecting the 'Overdue_Position' notification type");
			getElement(Overdue_Position).click();
			waitExplicitly(2);
		}else if(Event.equals("ScheduledReport")){
			verbose("Selecting the 'ScheduledReport' notification type");
			getElement(ScheduledReport).click();
			waitExplicitly(2);
		}else if(Event.equals("Incident")){
			verbose("Selecting the 'Incident' notification type");
			getElement(Incident).click();
			waitExplicitly(2);
		}else if(Event.equals("AMVER")){
				verbose("Selecting the 'AMVER' notification type");
				getElement(AMVER).click();
				waitExplicitly(2);
		}else {
			verbose("Selecting the 'SSRS' notification type");
			getElement(SSRS).click();
			waitExplicitly(2);
		}
}
	By zone_events = By.xpath("//div[3]/div[2]/span/span");
	By zones_summary = By.xpath("//div[4]/div[2]/span/span");
	By recipients_summary = By.xpath("//div[5]/div[2]/span/span");
	By recipients_summary_3 = By.xpath("//div[4]/div[2]/span/span");
	By recipients_Report_default = By.xpath("//div[3]/div[2]/span/span");
	By recipients_Report_specific = By.xpath("//div[4]/div[2]/span/span");
	By recipients_Overdue_Position = By.xpath("//div/ps-notification-panel-name/div/div/div[2]/div/div[5]/div[2]/span/span");
	By save_profile = By.xpath("//form/div/button");
	By searchBox = By.xpath("//input[@type='text']");
	By name_field = By.id("notification_name");
	By notification_summary = By.xpath("//div[2]/label");
	By summary_name = By.xpath("//div/div/div[2]/div/div/div[2]");
	By summary_ships = By.xpath("//span/span");
	By name_save = By.xpath("//ps-notification-detailview/aside/form/ps-accordion/div/ps-accordion-item[4]/div[1]/h4/ps-accordion-heading");


	// sub-menus under sortByMostRecentlyEdited

	By sortByMostRecentlyAdded = By.linkText("Sort by most recently added");

}

