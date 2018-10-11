package speedvariance.manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

/*import Notification_resources.BasePage;
import Notification_resources.LoginPage;*/

import scriptResources.*;

public class AdminSpeedVarianceVesselSettingsPage extends BasePage {


	public AdminSpeedVarianceVesselSettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	LoginPage loginPage = new LoginPage(getDriver());
	By vessel_settings_button = By.xpath("//ps-speed-variance/div/div/div[2]/a");
	By table = By.xpath("//ps-vessel-settings/div/div[4]/table/tbody");
	By ship_total_count = By.xpath("//ps-vessel-settings/div/div[3]");
	By alarm_settings = By.xpath("//ps-speed-variance/div/div/div[1]/a");


	JavascriptExecutor je = (JavascriptExecutor) getDriver();
	//This is to verify the Vessel button is clicked and successfully landed in Vessel settings page
	public boolean verifyVesselSettingsbuttton(){
		int count = 0;
		By vesselsettings_heading = By.xpath("//ps-speed-variance/div/ps-vessel-settings/div/h3");
		By vesselSettings_subtitle = By.xpath("//ps-speed-variance/div/ps-vessel-settings/div/div[1]");
		getElement(vessel_settings_button).click();
		waitExplicitly(2);
		if(getElement(vesselsettings_heading).getText().equals("Ship Settings")){
			verbose("Vessel settings page is selected successfully");
			count++;
		}else{
			verbose("Vessel settings page is NOT selected successfully");
		}

		waitExplicitly(2);

		if(getElement(vesselSettings_subtitle).getText().equals("Set the planned speed for your vessels and toggle on/off supervision")){
			verbose(" The subtitle under \"Ship Settings\" page is working correctly");
			count++;
		}else{
			verbose(" The subtitle under \"Ship Settings\" page is NOT working correctly");
		}

		waitExplicitly(1);

		if(count == 2){
			return true;
		}else
			return false;
	}

	//This module is check the tool-tip when changing the tabs
	public boolean verifyVesselsettingsTabtooltip(){
		By changetab_tooltip = By.xpath("//ps-vessel-settings/div/div[2]/div[1]/ps-dropdown-input[1]/div/button");
		waitExplicitly(3);
		Actions action = new Actions(getDriver());
		WebElement tool_tip = getElement(changetab_tooltip);
		action.moveToElement(tool_tip).build().perform();
		String tool_tip_text = tool_tip.getAttribute("data-tooltip");

		verbose("The tool-tip is: " + tool_tip_text);

		if(tool_tip_text.equals("Performing this action will clear unapplied changes")){
			return true;
		}
		return false;
	}

	//This is to verify the Supervision Filter
	public boolean verifyAllSupervisionFilter(){
		int count = 0;
		int inner_count_ON = 0;
		int inner_count_OFF = 0;

		//By changetab_tooltip = By.xpath("//ps-vessel-settings/div/div[2]/div[1]/ps-option-dropdown");
		By allSupervision = By.xpath("//ps-vessel-settings/div/div[2]/div[1]/ps-option-dropdown/div/button/span[1]");
		By supervisionON = By.xpath("//*[@id=\"option-0\"]"); 
		By supervisionOFF = By.xpath("//*[@id=\"option-1\"]");
		By supervisionAll_back = By.xpath("//*[@id=\"option-2\"]");

		waitExplicitly(2);
		if(getElement(allSupervision).getText().equals("All Supervision")){
			verbose("The /* All Supervision /* filter is seen");
			count ++;
		}else {
			verbose("The /* All Supervision /* filter is NOT seen");
		}

		waitExplicitly(1);
		getElement(allSupervision).click();

		//This is to verify the dropdown list under Supervision
		if(getElement(supervisionON).getText().equals("Supervision On") && getElement(supervisionOFF).getText().equals("Supervision Off")){
			verbose("The Supervision ON and OFF menus are seen");
			count++;
		}else{
			verbose("The Supervision ON and OFF menus are NOT seen");
		}

		//This is  to move the page  down to get the total count of the ship to check ON
		waitExplicitly(3);
		getElement(supervisionON).click();
		waitExplicitly(3);
		//getElement(table).sendKeys(Keys.PAGE_DOWN);
		String ship_count = getElement(ship_total_count).getText();
		verbose("The ship count is ---- " + ship_count);
		int ship_count_only = Integer.parseInt(ship_count.substring(0,ship_count.indexOf(" ")));
		verbose("The ship count is ---- " + ship_count_only);
		//This is to verify selecting Supervision ON lists only ships with Supervision ON
		for(int i=1; i<=ship_count_only; i++){
			waitExplicitly(5);
			String full_part = "//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i +  "]/div/ps-table-cell[5]/div/ps-toggle-button/div/label/span";
			By second_element = By.xpath(full_part);
			String hex = hex(second_element);
			if(hex.equals("#08ef4a")){
				verbose("Supervision On is seen" + i);
				inner_count_ON++; // This is to get the count of ships on which the supervision is ON
			}else{
				verbose("Supervision On is NOT seen" + i);
				inner_count_ON--;
			}
		}
		if(inner_count_ON == ship_count_only){
			count ++;			
		}

		//This is  to move the page  down to get the total count of the ship to check OFF
		waitExplicitly(3);
		getElement(allSupervision).click();
		waitExplicitly(3);
		getElement(supervisionOFF).click();
		waitExplicitly(3);
		String ship_count_off = getElement(ship_total_count).getText();
		verbose("The ship count is ---- " + ship_count_off);
		int ship_count_off_only = Integer.parseInt(ship_count_off.substring(0,ship_count_off.indexOf(" ")));
		verbose("The ship count is ---- " + ship_count_off_only);
		//This is to verify selecting Supervision ON lists only ships with Supervision OFF
		for(int i=1; i<=ship_count_off_only; i++){
			waitExplicitly(2);
			String full_part = "//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i +  "]/div/ps-table-cell[5]/div/ps-toggle-button/div/label/span";
			By second_element = By.xpath(full_part);
			String hex = hex(second_element);
			if(hex.equals("#cccccc")){
				verbose("Supervision OFF is seen" + i);
				inner_count_OFF++; // This is to get the count of ships on which the supervision is OFF
			}else{
				verbose("Supervision OFF is NOT seen" + i);
				inner_count_OFF--;
			}
		}
		if(inner_count_OFF == ship_count_off_only){
			count ++;			
		}
		//This is to put back the Supervision ALL back
		waitExplicitly(5);
		getElement(allSupervision).click();
		waitExplicitly(2);
		getElement(supervisionAll_back).click();
		waitExplicitly(3);

		if(count == 4){
			return true;
		}else{
			return false;
		}
	}

	public boolean verifySearchBox(){
		By search_field = By.xpath("//ps-vessel-settings/div/div[2]/div[2]/ps-searchbox/div/input");
		By no_result_found = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/div");
		By first_IMO_result = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[1]/div/ps-table-cell[3]/div");
		By first_ship_result = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[1]/div/ps-table-cell[2]/div");
		int count = 0;

		//This is to verify the search for the correct match is working


		verbose("Entering the text \"Ship3\" in the search box");
		getElement(search_field).sendKeys("Ship3");
		waitExplicitly(7);
		verbose("The ship found is " + getElement(first_ship_result).getText());
		if(getElement(first_ship_result).getText().equals("Ship3")){
			waitExplicitly(2);
			verbose("The Ship name search result is working as expected");
			count++;
		}else {
			verbose("Search for ship is  not working");

		}

		waitExplicitly(3);
		waitExplicitly(2);
		getElement(search_field).clear();
		//This is to verify the "No element found" message
		getElement(search_field).sendKeys("12123124");
		waitExplicitly(3);
		if(getElement(no_result_found).getText().equals("No results found.")){
			waitExplicitly(3);
			verbose("No matching results found message is working fine");
			count++;
		}

		//This is to verify user can search for the IMO number
		getElement(search_field).clear();
		waitExplicitly(1);
		getElement(search_field).sendKeys("9064396");
		waitExplicitly(3);
		if(getElement(first_IMO_result).getText().equals("9064396")){
			waitExplicitly(3);
			verbose("The IMO search result is working as expected");
			count++;
		}else if(getElement(no_result_found).getText().equals("No results found.")){
			verbose("No matching results found message is working fine");

		}

		getElement(search_field).clear();
		getDriver().navigate().refresh();

		verbose("Count is " + count);
		if(count == 3){
			return true;
		}else{
			return false;
		}

	}

	public boolean verifySubAccountFilter(){
		By all_sub_accounts = By.xpath("//ps-vessel-settings/div/div[2]/div[1]/ps-dropdown-input[1]/div/button/div/span[1]");
		By sub_account_label = By.xpath("//ps-account-search/div/div/div/ps-autocomplete/form/div/label");
		By account_search = By.xpath("//*[@id=\"accountName\"]");
		By search_click = By.xpath("//*[@id=\"subAccountDropdown\"]/div/ps-account-search/div/div/div/ps-autocomplete/form/div/div/ul/li/a/span");
		By ship_total_count = By.xpath("//ps-vessel-settings/div/div[3]");
		By clear_selection = By.xpath("//*[@id=\"subAccountDropdown\"]/div/span/small");
		By selection_remove = By.xpath("//ps-account-search/div/div/ul/li/button/span");
		int count = 0;
		int inner_count = 0;

		//This is to verify the subaccount filter is heading is proper
		if(getElement(all_sub_accounts).getText().equals("All sub accounts")){
			verbose("The sub account filter header is seen successfully");
			count ++;
			verbose("The count is : " + count);
		}else {
			verbose("The sub account filter header is NOT seen successfully");
		}

		//This is to verify the sub account filter label
		waitExplicitly(1);
		getElement(all_sub_accounts).click();
		waitExplicitly(2);
		if(getElement(sub_account_label).getText().equals("Search for an account")){
			verbose("The sub account label is seen correctly");
			count++;
			verbose("The count is : " + count);
		}else{
			verbose("The sub account label is NOT seen correctly");
		}

		//This is verify the sub account search is working fine
		getElement(account_search).click();
		waitExplicitly(2);
		getElement(account_search).sendKeys("kkk1");
		waitExplicitly(2);
		getElement(search_click).click();
		waitExplicitly(3);
		//This is to verify the All sub accounts header is changed
		if(getElement(all_sub_accounts).getText().equals("1 sub account(s)")){
			verbose("the All sub accounts header is changed to the \"1 sub account(s)\"");
			count++;
			verbose("The count is : " + count);
		}else{
			verbose("the All sub accounts header is NOT changed to the \"1 sub account(s)\"");
		}
		waitExplicitly(4);
		String search_result_ship_count = getElement(ship_total_count).getText(); // This is the total number of the ships returned after search
		verbose("Ship count after search is ----- " + search_result_ship_count);
		waitExplicitly(2);
		int ship_count_only = Integer.parseInt(search_result_ship_count.substring(0,search_result_ship_count.indexOf(" ")));
		verbose("The ship count is ---- " + ship_count_only);
		
		//This is to verify the search results in the table is working fine
		for (int i = 1; i <= ship_count_only ; i++){
			waitExplicitly(4);
			
			String full_part = "//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i +  "]/div/ps-table-cell[8]/div";
			By second_element = By.xpath(full_part);

			if(getElement(second_element).isDisplayed() && getElement(second_element).getText().equals("kkk1")){
				verbose("The search is successful " + i);
				inner_count++;
			}else{
				verbose("Search is  NOT working " + i);
			}
		}
		//This is to get the count whether the test case is working fine.
		if(inner_count == ship_count_only){
			verbose("All the search results working fine");
			count ++;
			verbose("The count is : " + count);
		}
		waitExplicitly(5);


		//This is check the \"Clear selection\" or clicking on \"X\" next to the selected ship depending on the random number
		int random = randInt(1,2);
		verbose("The random number is -- " + random);
		if(random == 1){
			verbose("Clicking on the clear all selection");
			getElement(clear_selection).click();

			waitExplicitly(5);
			String ship_count_total = getElement(ship_total_count).getText();
			verbose("Total ship count after search cleared is ----- " + ship_count_total);

			if(!search_result_ship_count.equals(ship_count_total)){
				verbose("Clicking on Clear all selection is working successfully");
				count++;
				verbose("The count is : " + count);
			}else{
				verbose("Clicking on Clear all selection is NOT working successfully");
			}
		}else if(random == 2){
			//This is to verify the selected filter is closed and all the ships are updated
			verbose("The \"X\" is seen next to the search selection");
			getElement(selection_remove).click(); // This is to click on the \"X\" mark and remove the selection
			verbose("Clicked on \"X\" seen next to the search selection");
			waitExplicitly(5);

			String ship_count_total = getElement(ship_total_count).getText();
			verbose("Total ship count after search cleared is ----- " + ship_count_total);

			if(!search_result_ship_count.equals(ship_count_total)){
				verbose("Clicking on \"X\" mark and remove the selection is working successfully");
				count++;
				verbose("The count is : " + count);
			}else{
				verbose("Clicking on \"X\" mark and remove the selection is NOT working successfully");
			}
		}

		if(count == 5){
			return true;
		}else{
			return false;
		}
	}

	public boolean verifyAllFleetsFilter(){
		By all_fleets = By.xpath("//ps-vessel-settings/div/div[2]/div[1]/ps-dropdown-input[2]/div/button/div/span[1]");
		By fleets_label = By.xpath("//ps-fleet-search/div/div/div/ps-autocomplete/form/div/label");
		By fleets_search = By.xpath("//*[@id=\"fleetName\"]");
		By search_click = By.xpath("//*[@id=\"fleetDropdown\"]/div/ps-fleet-search/div/div/div/ps-autocomplete/form/div/div/ul/li/a");		
		By clear_selection = By.xpath("//div[@id='fleetDropdown']/div/span");
		By selection_remove = By.xpath("//ps-fleet-search/div/div/ul/li/button/span");

		int count = 0;
		int inner_count = 0;

		//This is to verify the Fleets filter is heading is proper
		if(getElement(all_fleets).getText().equals("All fleets")){
			verbose("The Fleet filter header is seen successfully");
			count ++;
		}else {
			verbose("The Fleet filter header is NOT seen successfully");
		}

		//This is to verify the sub account filter label
		waitExplicitly(1);
		getElement(all_fleets).click();
		waitExplicitly(2);
		if(getElement(fleets_label).getText().equals("Search for fleet(s)")){
			verbose("The Fleet label is seen correctly");
			count++;			
		}else{
			verbose("The Fleet label is NOT seen correctly");
		}

		//This is verify the sub account search is working fine
		getElement(fleets_search).click();
		waitExplicitly(2);
		getElement(fleets_search).sendKeys("TestFleet1");
		waitExplicitly(2);
		getElement(search_click).click();
		waitExplicitly(5);
		//This is to verify the All Fleets header is changed
		if(getElement(all_fleets).getText().equals("1 fleet(s)")){
			verbose("The Fleets header header is changed to the \"1 fleet(s)\"");
			count++;
		}else{
			verbose("The Fleets header header is NOT changed to the \"1 fleet(s)\"");
		}
		String search_result_ship_count = getElement(ship_total_count).getText(); // This is the total number of the ships returned after search
		verbose("Ship count after search is ----- " + search_result_ship_count);
		waitExplicitly(5);
		int ship_count_only = Integer.parseInt(search_result_ship_count.substring(0,search_result_ship_count.indexOf(" ")));
		verbose("The ship count is ---- " + ship_count_only);
		//This is to verify the search results in the table is working fine
		for (int i = 1; i <= ship_count_only ; i++){
			waitExplicitly(4);			
			String full_part = "//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i + "]/div/ps-table-cell[9]/div";
			By second_element = By.xpath(full_part);
			verbose("The second element is :" + getElement(second_element).getText());

			if(getElement(second_element).isDisplayed() && getElement(second_element).getText().equals("TestFleet1")){
				verbose("The search is successful " + i);
				inner_count++;
			}else{
				verbose("Search is  NOT working " + i);
			}
		}
		//This is to get the count whether the test case is working fine.
		if(inner_count == ship_count_only){
			verbose("All the search results working fine");
			count ++;
		}
		waitExplicitly(5);

		//This is check the \"Clear selection\" or clicking on \"X\" next to the selected ship depending on the random number
		int random = randInt(1,2);
		verbose("The random number is -- " + random);
		if(random == 1){
			verbose("Clicking on the clear all selection");
			getElement(clear_selection).click();

			waitExplicitly(5);
			String ship_count_total = getElement(ship_total_count).getText();
			verbose("Total ship count after search cleared is ----- " + ship_count_total);

			if(!search_result_ship_count.equals(ship_count_total)){
				verbose("Clicking on Clear all selection is working successfully");
				count++;				
			}else{
				verbose("Clicking on Clear all selection is NOT working successfully");
			}
		}else if(random == 2){
			//This is to verify the selected filter is closed and all the ships are updated
			verbose("The \"X\" is seen next to the search selection");
			waitExplicitly(5);
			getElement(selection_remove).click(); // This is to click on the \"X\" mark and remove the selection
			verbose("Clicked on \"X\" seen next to the search selection");
			waitExplicitly(3);

			String ship_count_total = getElement(ship_total_count).getText();
			verbose("Total ship count after search cleared is ----- " + ship_count_total);

			if(!search_result_ship_count.equals(ship_count_total)){
				verbose("Clicking on \"X\" mark and remove the selection is working successfully");
				count++;
			}else{
				verbose("Clicking on \"X\" mark and remove the selection is NOT working successfully");
			}
		}

		if(count == 5){
			return true;
		}else{
			return false;
		}
	}


	public boolean verifyTableSortDefaultbyLastEdited() throws ParseException{
		int count = 0;
		By last_edited = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[1]/div/div[6]");
		By first_date = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[1]/div/ps-table-cell[6]/div");
		//int ship_count_only = 13;
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm");
		getDriver().navigate().refresh();
		waitExplicitly(10);
		//This is to verify whether the column heading which is sorted is in BOLD
		String fontWeight = getElement(last_edited).getCssValue("font-weight");			
		boolean isBold = "bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) >= 700;
		if(isBold){
			verbose("The \"Last Edited\" column is selected by default and is Higlighted");
			count++;
		}else{
			verbose("The \"Last Edited\" column is NOT selected by default and is NOT Higlighted");		
		}

		//This is to verify the column is sorted by Last edited
		String ship_count = getElement(ship_total_count).getText();
		verbose("The ship count is --- " + ship_count);
		int ship_count_only = Integer.parseInt(ship_count.substring(0,ship_count.indexOf(" ")));
		verbose("The attribute value of first element is --- " + getElement(first_date).getText());


		int i = 1;
		int j = 0;
		int k = 0;
		int internal_count = 0;

		for(;i<ship_count_only;i++){
			String full_part = "//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i +  "]/div/ps-table-cell[6]/div";
			By full_path = By.xpath(full_part);

			if(getElement(full_path).getText().equals("n/a")){

				verbose("\"n/a\" is seen " + i);
				k++;

			}else{
				k++;
				break;

			}

		}

		waitExplicitly(3);


		String first_valid_date = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i +  "]/div/ps-table-cell[6]/div")).getText();
		//String first_valid_date_without_UTC = first_valid_date.substring(0, 17);
		//verbose("The first_valid_date_without_UTC is " + first_valid_date_without_UTC);

		Date first = sdf.parse(first_valid_date);

		for(j=i+1 ; j <= ship_count_only ; j++){
			String second_date = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + j +  "]/div/ps-table-cell[6]/div")).getText();
			//waitExplicitly(3);
			//String second_date_without_UTC = second_date.substring(0, 17);

			//verbose("The second_date_without_UTC is " + second_date_without_UTC);

			Date second = sdf.parse(second_date);
			waitExplicitly(3);

			//if(first_valid_date_without_UTC.compareToIgnoreCase(second_date) > 0 || first_valid_date_without_UTC.compareToIgnoreCase(second_date) == 0){
			if(first.compareTo(second) > 0 || first.compareTo(second) ==0 ){
				//waitExplicitly(3);
				verbose(first + " is greater than " + second); 
				internal_count++;
			}else{
				verbose("Sorting is not correct");

			}
		}

		if(internal_count == ship_count_only-k){ // As there will be ships less than the number of n/a and -1 because that is the compared data
			count++;
		}else{
			verbose("Sorting has went wrong");
		}

		getElement(last_edited).click();
		waitExplicitly(4);

		int internal_count1 =0;

		if(getElement(last_edited).getAttribute("ng-reflect-class-name").equals("header-cell sort-false modified undefined")){
			String first_date_asce = getElement(first_date).getText();
			//String first_date_asce_without_UTC = first_date_asce.substring(0, 17);

			verbose("The first_valid_date_without_UTC is " + first_date_asce);

			Date first_asce = sdf.parse(first_date_asce);

			for(int a=2; a<= ship_count_only;a++){
				String second_date_desc = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + a + "]/div/ps-table-cell[6]/div")).getText();
				//String second_date_desc_without_UTC = second_date_desc.substring(0, 17);

				//verbose("The second_date_desc_without_UTC is " + second_date_desc_without_UTC);
				if(second_date_desc.equals("n/a")){
					internal_count1++;
					continue;
				}else{
					Date second_asce = sdf.parse(second_date_desc);

					if(first_asce.compareTo(second_asce) < 0 || first_asce.compareTo(second_asce) ==0 ){
						verbose(first_date_asce + " is smaller " + second_date_desc);
						internal_count1++;
					}else{				
						verbose("Sorting in ascending order is not working as expected");
					}
				}
			}

			if(internal_count1 == ship_count_only-1){
				verbose("Sorting in Ascending order is correct");
				count++;
			}else{
				verbose("Sorting in Ascending order is Incorrect");
			}
		}
		if(count == 3){
			return true;
		}else{
			return false;
		}


	}

	public boolean verifyColumnsortPlannedSpeed(){
		By planned_speed_heading = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[1]/div/div[4]");
		//By first_planned_speed = By.cssSelector("#input__speed-891");
		int count =0;

		String ship_count = getElement(ship_total_count).getText();
		verbose("The ship count is --- " + ship_count);
		int ship_count_only = Integer.parseInt(ship_count.substring(0,ship_count.indexOf(" ")));
		String attr = getElement(planned_speed_heading).getAttribute("ng-reflect-class-name");
		verbose("The attr is " + attr);

		getElement(planned_speed_heading).click();
		waitExplicitly(5);

		waitExplicitly(5);
		if(getElement(planned_speed_heading).getAttribute("ng-reflect-class-name").equals("header-cell sort-false planned_speed flex-width-m")){
			String first_planned_speed = getElement(By.xpath("//ps-table-cell[4]/div/input")).getText();
			verbose("The first planned speed is  " + first_planned_speed);
			for(int i = 2 ; i <= ship_count_only; i++){
				String second_speed = "//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i + "]/div/ps-table-cell[4]/div/input";
				String second_planned_speed = getElement(By.xpath(second_speed)).getText();

				verbose("The second planned speed is " + second_planned_speed);

				if(first_planned_speed.compareTo(second_planned_speed) > 0 || first_planned_speed.compareTo(second_planned_speed) == 0 ){
					verbose(first_planned_speed + " is smaller than " + second_planned_speed);
					verbose("The sorting is working correctly");	
					count++;
				}
			}
		}

		if(count == ship_count_only-1){
			verbose("Sorted in ascending");
			return true;

		}else{
			verbose("NOT sorted in ascending");
			return false;
		}

	}


	public boolean verifyEditedBysorting(){
		By edited_by_heading = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[1]/div/div[7]");
		By first_name = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[1]/div/ps-table-cell[7]/div");
		int count = 0;
		int internal_count=0;

		//int ship_count_only =13;

		getDriver().navigate().refresh();
		waitExplicitly(4);
		String ship_count = getElement(ship_total_count).getText();
		verbose("The ship count is --- " + ship_count);
		int ship_count_only = Integer.parseInt(ship_count.substring(0,ship_count.indexOf(" ")));


		getElement(edited_by_heading).click();
		waitExplicitly(5);

		String attr = getElement(edited_by_heading).getAttribute("ng-reflect-class-name");
		verbose("The attr is " + attr);

		if(attr.equals("header-cell sort-false modified_by_name undefined")){
			String first_name1 = getElement(first_name).getText();
			verbose("The first name is  " + first_name1);

			for(int i=2; i <= ship_count_only; i++){
				String second_name = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i + "]/div/ps-table-cell[7]/div")).getText();
				verbose("The second name is : " + second_name);
				waitExplicitly(2);
				if(second_name.equals("n/a")){
					count++;
					continue;
				}else if(first_name1.compareToIgnoreCase(second_name) < 0 || first_name1.compareToIgnoreCase(second_name) == 0){
					verbose("Sorted in ascending order");
					count++;

				}else{
					verbose("Not sorted");
					break;
				}
			}			

		}
		if(count == ship_count_only-1){
			verbose("Sorted correctly");
			internal_count++;
		}
		else{
			verbose("Sorting went wrong");

		}

		int count1=0;
		int i=1;
		int k=0;
		waitExplicitly(2);
		getElement(edited_by_heading).click();
		waitExplicitly(5);

		String attr1 = getElement(edited_by_heading).getAttribute("ng-reflect-class-name");
		verbose("The attr is " + attr1);

		if(attr1.equals("header-cell sort-true modified_by_name undefined")){


			for(;i<ship_count_only;i++){
				String full_part = "//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i +  "]/div/ps-table-cell[7]/div";
				By full_path = By.xpath(full_part);

				if(getElement(full_path).getText().equals("n/a")){

					verbose("\"n/a\" is seen " + i);
					k++;

				}else{
					k++;
					break;

				}

			}

			String first_valid_name = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i +  "]/div/ps-table-cell[7]/div")).getText();
			verbose("The first_valid_date is " + first_valid_name + i );

			for(int j=i+1; j <= ship_count_only; j++){
				String second_name = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + j + "]/div/ps-table-cell[7]/div")).getText();
				verbose("The second name is : " + second_name);
				waitExplicitly(2);
				if(first_valid_name.compareToIgnoreCase(second_name) > 0 || first_valid_name.compareToIgnoreCase(second_name) == 0){

					count1++;
					verbose("Sorted in descending order count1 :" + count1);

				}else{
					verbose("Not sorted");
					break;
				}
			}			

		}


		waitExplicitly(2);
		if(count1 == ship_count_only-k){

			internal_count++;
			verbose("Sorted correctly internalcount: " + internal_count);
		}
		else{

			internal_count--;
			verbose("Sorting went wrong internalcount: " + internal_count);
		}


		if(internal_count == 2 ){
			verbose("Editted By column sorting is working as expected");
			return true;
		}else{
			verbose("Editted By column sorting is NOT working as expected");
			return false;
		}

	}


	public boolean verifySubAccountSorting(){
		By subAccount_header = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[1]/div/div[8]");

		int k = 0;
		int i = 1;
		int count = 0;
		int internal_count = 0;
		int ship_count_only = 13;

		/*String ship_count = getElement(ship_total_count).getText();
		verbose("The ship count is --- " + ship_count);
		int ship_count_only = Integer.parseInt(ship_count.substring(0,ship_count.indexOf(" ")));*/

		getElement(subAccount_header).click();
		waitExplicitly(2);

		if(getElement(subAccount_header).getAttribute("ng-reflect-class-name").equals("header-cell sort-false account_name undefined")){
			for(;i<=ship_count_only; i++){
				if(getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i + "]/div/ps-table-cell[8]/div")).getText().equals("n/a")){
					verbose("\"n/a\" is seen : " + i);
					k++;
				}else{
					k++;
					break;
				}
			}

			String first_element = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i + "]/div/ps-table-cell[8]/div")).getText();
			verbose("The first element is :" + first_element);
			waitExplicitly(2);

			for(int j=i+1;j<=ship_count_only;j++){
				String second_element = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + j + "]/div/ps-table-cell[8]/div")).getText();
				verbose("The second element is " + second_element);

				if(first_element.compareTo(second_element) < 0 ||  first_element.compareTo(second_element) == 0){
					verbose(first_element + " is greater " + second_element);
					count++;
				}else{
					verbose("Sorting went wrong");
				}
			}

		}

		if( count == ship_count_only -k ){
			internal_count++;
			verbose("Sorting went correctly");

		}else{
			verbose("Sorting was not correct for all the elements");
		}


		waitExplicitly(3);
		getElement(subAccount_header).click();
		int count1 =0;
		int j=1;

		if(getElement(subAccount_header).getAttribute("ng-reflect-class-name").equals("header-cell sort-true account_name undefined")){

			String first_name1 = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + j + "]/div/ps-table-cell[8]/div")).getText();
			verbose("The first name is  " + first_name1);

			for(int a=j+1; a<=ship_count_only; a++){
				waitExplicitly(2);
				String second_name = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + a + "]/div/ps-table-cell[8]/div")).getText();
				verbose("The second name is : " + second_name);
				waitExplicitly(2);
				if(second_name.equals("n/a")){
					count1++;
					continue;
				}else if(first_name1.compareTo(second_name) > 0 || first_name1.compareTo(second_name) == 0){
					verbose("Sorted in ascending order");
					count1 ++;

				}else{
					verbose("Not sorted");
					break;
				}
			}		

		}

		if(count1 == ship_count_only-1){
			verbose("All sorted as descending order");
			internal_count++;
		}else{
			verbose("Not sorted correctly");

		}

		if(internal_count == 2){
			return true;
		}else{
			return false;
		}
	}



	public boolean verifyFleetSort(){
		By fleet_header = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[1]/div/div[9]");
		int count = 0;
		int internal_count=0;
		//int ship_count_only=13;

		getDriver().navigate().refresh();
		waitExplicitly(2);

		String ship_count = getElement(ship_total_count).getText();
		verbose("The ship count is --- " + ship_count);
		int ship_count_only = Integer.parseInt(ship_count.substring(0,ship_count.indexOf(" ")));
		 

		getElement(fleet_header).click();

		if(getElement(fleet_header).getAttribute("ng-reflect-class-name").equals("header-cell sort-false fleet_name undefined")){
			String first_fleet = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[1]/div/ps-table-cell[9]/div")).getText();
			verbose("The first_fleet is :" + first_fleet);

			if(!first_fleet.equals("n/a")){
				for(int i=2; i<=ship_count_only;i++){
					waitExplicitly(5);
					String second_fleet = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i + "]/div/ps-table-cell[9]/div")).getText();
					verbose("The second_fleet is : " + second_fleet);

					if(first_fleet.compareTo(second_fleet) < 0 || first_fleet.compareTo(second_fleet) == 0){
						verbose(first_fleet + " is seen before " + second_fleet);
						count++;
					}else if(second_fleet.equals("n/a")){
						count++;
						continue;
					}else{
						verbose("Sorting didnt go well");
					}

				}
			}else{
				verbose("Not sorted correctly");
			}

		}

		if(count == ship_count_only-1){
			verbose("Sorting ASCENDING completed successfully");
			internal_count++;
		}else{
			verbose("Sorting wasn't successfull");
			//return false;
		}

		int a = 1 ;
		int k = 0; // This is for calculation
		int count1 = 0;
		getElement(fleet_header).click();
		waitExplicitly(3);

		for(; a <= ship_count_only ;a++){
			if(getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + a + "]/div/ps-table-cell[9]/div")).getText().equals("n/a")){
				verbose("\"n/a\" is seen :" + a);	
				k++;
			}else{
				k++;
				break;
			}
		}

		String first_fleet1 = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + a + "]/div/ps-table-cell[9]/div")).getText();
		verbose("The first_fleet for descending order :" + first_fleet1);
		for(int j = a+1 ; j <= ship_count_only; j++){
			String second_fleet1 = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + j + "]/div/ps-table-cell[9]/div")).getText();
			verbose("The second element for descending order is :" + second_fleet1);

			if(first_fleet1.compareTo(second_fleet1) > 0 || first_fleet1.compareTo(second_fleet1) == 0){
				verbose("Sorting in descending is done correctly");
				count1++;
			} else{
				verbose("Sorting went wrong");
			}

		}

		if(count1 == ship_count_only-k){
			verbose("Sorting DESCENDING completed successfully");
			internal_count++;
		}else{
			verbose("Sorting is not correct");
		}

		if(internal_count == 2){
			verbose("Fleet sorting working successfully");
			return true;
		}else{
			verbose("Fleet sorting is  not successfull");
			return false;
		}
	}


	public boolean verifySortByShipName(){
		By ship_name_header = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[1]/div/div[2]");
		int count = 0;
		int count1 = 0;
		int internal_count=0;
	//	int ship_count_only = 13;

		getDriver().navigate().refresh();
		waitExplicitly(2);

		String ship_count = getElement(ship_total_count).getText();
		verbose("The ship count is --- " + ship_count);
		int ship_count_only = Integer.parseInt(ship_count.substring(0,ship_count.indexOf(" ")));
		 
		getElement(ship_name_header).click();

		String first_ship = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[1]/div/ps-table-cell[2]/div")).getText();

		verbose("The first element is :" + first_ship);

		for(int i = 2; i<=ship_count_only; i++){
			waitExplicitly(5);
			String second_ship = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i + "]/div/ps-table-cell[2]/div")).getText();
			verbose("The second ship is : " + second_ship);

			if(first_ship.compareToIgnoreCase(second_ship) < 0 || first_ship.compareToIgnoreCase(second_ship) == 0){
				verbose("Ascending sorting is correct");
				count++;
			}else{
				verbose("Sorting is INCORRECT");
			}

		}

		if(count == ship_count_only-1){
			verbose("ASCENDING sorting was successful");
			internal_count++;
		}else{
			verbose("ASCENDING sorting was NOT successful");

		}

		getElement(ship_name_header).click();
		waitExplicitly(2);
		String first_ship1 = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[1]/div/ps-table-cell[2]/div")).getText();
		verbose("The first ship in descending order is " + first_ship1);

		for(int j=2 ; j<=ship_count_only ; j++){
			String second_ship1 = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + j + "]/div/ps-table-cell[2]/div")).getText();
			verbose("The second ship is : " + second_ship1);

			waitExplicitly(3);
			if(first_ship1.compareToIgnoreCase(second_ship1) > 0 || first_ship1.compareToIgnoreCase(second_ship1) == 0){
				verbose("Descending sorting is correct");
				count1++;
			}else{
				verbose("Sorting is INCORRECT");
			}

		}

		if(count1 == ship_count_only-1){
			verbose("Descending sorting is correct");
			internal_count++;
		}else{
			verbose("Descending sorting is incorrect");
		}


		if(internal_count == 2){
			verbose("SORTING WORKS AS EXPECTED");
			return true;
		}else{
			verbose("SORTING DOESN'T WORKS AS EXPECTED");
			return false;
		}
	}


	public boolean verifysortbyIMO(){
		By IMO_header = By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[1]/div/div[3]");
		int count =0;
		//int ship_count_only = 13;
		int internal_count = 0;

		getDriver().navigate().refresh();
		waitExplicitly(3);

		String ship_count = getElement(ship_total_count).getText();
		verbose("The ship count is --- " + ship_count);
		int ship_count_only = Integer.parseInt(ship_count.substring(0,ship_count.indexOf(" ")));

		getElement(IMO_header).click();
		waitExplicitly(2);

		if(getElement(IMO_header).getAttribute("ng-reflect-class-name").equals("header-cell sort-false imo_number undefined")){
			String first_IMO = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[1]/div/ps-table-cell[3]/div")).getText();
			verbose("The first IMO is " + first_IMO);
			for(int i=2;i<=ship_count_only;i++){
				waitExplicitly(5);
				String second_IMO = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + i + "]/div/ps-table-cell[3]/div")).getText();
				verbose("Second IMO is " + second_IMO);

				if(first_IMO.compareTo(second_IMO)<0 || first_IMO.compareTo(second_IMO) == 0){
					verbose( first_IMO + " is smaller than " + second_IMO);
					count++;
				}else if(second_IMO.equals("n/a")){
					count++;
					continue;
				}else{
					verbose("Sorting is not correct");
				}
			}
			if(count == ship_count_only-1){
				verbose("Ascending order sorting is working fine for IMO");
				internal_count ++;
			}else{
				verbose("Ascending order sorting is NOT working fine for IMO");

			}
		}else{
			verbose("Ascending sorting icon is not working");
		}



		int k = 0;
		int j=1;
		int count1 = 0;
		getElement(IMO_header).click();
		waitExplicitly(3);

		if(getElement(IMO_header).getAttribute("ng-reflect-class-name").equals("header-cell sort-true imo_number undefined")){	
			for(; j<=ship_count_only;j++)
				if(getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + j + "]/div/ps-table-cell[3]/div")).getText().equals("n/a")){
					verbose("\"n/a\" is seen " + j);
					k++;
				}else{
					k++;
					break;
				}

			String first_imo_desc = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + j + "]/div/ps-table-cell[3]/div")).getText();
			verbose("The first IMO in desc is :" + first_imo_desc);

			for(int a = j+1 ; a <= ship_count_only ; a++){
				String second_imo_desc = getElement(By.xpath("//ps-vessel-settings/div/div[4]/ps-data-table/div/div[2]/ps-table-row[" + a + "]/div/ps-table-cell[3]/div")).getText();
				verbose("The second IMO in desc is " + second_imo_desc);

				if(first_imo_desc.compareTo(second_imo_desc) > 0 || first_imo_desc.compareTo(second_imo_desc) == 0){
					verbose(first_imo_desc + " is greater " + second_imo_desc);
					count1++;
				}else{
					verbose("Sorting is not correct");
				}
			}
			if(count1 == ship_count_only-k){
				verbose(" Descending order sorting is working fine for IMO");
				internal_count++;
			}else{
				verbose("Sorting in descending was  not successfull");
			}
		}




		if(internal_count == 2){
			verbose("Sorting is working fine for IMO");
			return true;
		}else{
			verbose("Sorting is NOT working fine for IMO");
			return false;
		}
	}


	public boolean verifyApplyandCancelButton_Supervision(){
		By first_ship = By.xpath("//ps-table-cell[2]/div");
		By supervision_button = By.xpath("//ps-data-table/div/div[2]/ps-table-row[1]/div/ps-table-cell[5]/div/ps-toggle-button/div/label");
		By apply_button = By.xpath("//ps-speed-variance/div/ps-vessel-settings/div/div[5]/button[2]");
		By cancel_button = By.xpath("//ps-speed-variance/div/ps-vessel-settings/div/div[5]/button[1]");
		int count = 0;

		//getDriver().navigate().refresh();
		waitExplicitly(3);

		/*String backgroundcolor = getElement(supervision_button).getCssValue("color");
		verbose("The background-color is :" + backgroundcolor);*/
		/*
		String color = getElement(supervision_button).getCssValue("background-color");
		System.out.println(color);
		String hex = Color.fromString(color).asHex();
		System.out.println(hex);*/

		String hex = hex(supervision_button);

		if(hex.equals("#08ef4a")){
			verbose("The supervision button is ON clicking on OFF");
			waitExplicitly(3);
			getElement(supervision_button).click();

			waitExplicitly(3);
			String hex1 = hex(supervision_button);

			if(hex1.equals("#cccccc")){
				verbose("Toggle button is turned OFF successfully");
			}else{
				verbose("Toggle button is NOT turned OFF");
			}

			if(getElement(apply_button).isEnabled() && getElement(cancel_button).isEnabled()){
				verbose("Apply and Cancel buttons are enabled");

				int random = randInt(1,2);

				waitExplicitly(2);

				if(random == 1){
					verbose("Clicking on Apply button");
					getElement(apply_button).click();

					waitExplicitly(3);
					String hex2 = hex(supervision_button);

					if(hex2.equals("#cccccc")){
						verbose("Apply is working fine");
						count++;
					}else{
						verbose("Apply is NOT working fine");
					}
				}else{
					verbose("Clicking on Cancel button");
					getElement(cancel_button).click();

					waitExplicitly(3);
					String hex2 = hex(supervision_button);

					if(hex2.equals("#08ef4a")){
						verbose("Cancel is working fine");
						count++;
					}else{
						verbose("Cancel is NOT working fine");
					}
				}
			}else{
				verbose("Apply and Cancel button are NOT enabled");
			}
		}else{
			verbose("The supervision button is OFF clicking on ON");
			getElement(supervision_button).click();

			waitExplicitly(3);
			String hex2 = hex(supervision_button);

			if(hex2.equals("#08ef4a")){
				verbose("Toggle button is turned ON successfully");
			}else{
				verbose("Toggle button is NOT turned ON");
			}

			if(getElement(apply_button).isEnabled() && getElement(cancel_button).isEnabled()){
				verbose("Apply and Cancel buttons are enabled");

				int random = randInt(1,2);

				waitExplicitly(2);

				if(random == 1){
					verbose("Clicking on Apply button");
					getElement(apply_button).click();

					waitExplicitly(3);
					String hex3 = hex(supervision_button);

					if(hex3.equals("#08ef4a")){
						verbose("Apply is working fine");
						count++;
					}else{
						verbose("Apply is NOT working fine");
					}
				}else{
					verbose("Clicking on Cancel button");
					getElement(cancel_button).click();

					waitExplicitly(3);
					String hex3 = hex(supervision_button);

					if(hex3.equals("#cccccc")){
						verbose("Cancel is working fine");
						count++;
					}else{
						verbose("Cancel is NOT working fine");
					}
				}
			}else{
				verbose("Apply and Cancel button are NOT enabled");
			}
		}

		if(count == 1){
			verbose("Supervision ON/OFF is working as expected");
			return true;
		}else{
			verbose("Supervision ON/OFF is NOT working as expected");
			return false;
		}


	}

	public String hex(By supervision){
		waitExplicitly(3);
		String color = getElement(supervision).getCssValue("background-color");		
		String hex = Color.fromString(color).asHex();
		System.out.println(hex);
		return hex;
	}


	public static int randInt(int min, int max) {

		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}
