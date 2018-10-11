package com.ps.maven.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import com.ps.maven.utils.BrowserTypes;

public class Latest_Screening_Results extends BrowserTypes{
	By Port_state_control_history_check = By.xpath("//div[contains(@class,'latest-row')][6]//a");
	By Port_state_control_history_check_result = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[6]/ps-screening-severity/p");
    By Port_state_control_history_check_title_in_modal = By.xpath("//ps-modal/div[1]/div/div/ps-detail-check-port/div[1]/ps-check-modal-header/h4[1]");
	By Port_state_control_history_check_modal_result_title = By.xpath("//ps-modal/div[1]/div/div/ps-detail-check-port/div[1]/ps-check-modal-header/h4[2]");
    Ship_name_click shipname = new Ship_name_click();
    By ship_name_xpath = By.xpath("//ps-data-table/div/div/ps-table-row[1]/ps-table-cell[2]/div");
    By ship_last_updated = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[7]");
	By Last_updated_title_sidepanel = By.xpath("//ps-accordion/div/ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[1]/p[1]");
    By Ship_last_updated_date_sidepanel = By.xpath("//ps-accordion/div/ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[1]/p[2]");
    By Ship_movement_history_check = By.xpath("//ps-accordion/div/ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[5]/a");
    By Ship_movement_result = By.xpath("//ps-accordion/div/ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[5]/ps-screening-severity/p");
    By Country_sanctions_check = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[4]/a");
    By Country_sanctions_check_result = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[4]/ps-screening-severity/p");
    By Company_global_sanctions_list_check = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[3]/a");
    By Company_global_sanctions_list_check_result = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[3]/ps-screening-severity/p");
    By Ship_global_sanctions_list_check = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[2]/a");
    By Ship_global_sanctions_list_check_result = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[2]/ps-screening-severity/p"); 		
    
    
	public boolean Ship_global_sanctions_list_check()
	{
		waitExplicitly(5);
		String local = getElement(Ship_global_sanctions_list_check).getText();
		verbose("The field present is : " + local);
		if(local.equals("Ship global sanctions list check"))
		{
			verbose("The Ship global sanctions list check link is present under Latest screening results");
			
		}
		else
		{
			verbose("The Ship global sanctions list check link is not present under Latest screening results");
			
		}
String local1 =  getElement(Ship_global_sanctions_list_check_result).getText();
		
		verbose("The result of Ship global sanctions list check is :" + local1);
		if(local1.equals("Warning") || local1.equals("OK") || local1.equals("Critical"))
		{
			verbose("The result as expected : " + local1);
			return true;
		}
		else {
			verbose("The result not as expected");
			return false;
			
		}
	}


	public boolean Company_global_sanctions_list_check()

	{
		waitExplicitly(5);
		String local = getElement(Company_global_sanctions_list_check).getText();
		verbose("The field present is : " + local);
		if(local.equals("Company global sanctions list check"))
		{
			verbose("The Company global sanctions list check link is present under Latest screening results");
		}
		else
		{
			verbose("The Company global sanctions list check link is not present under Latest screening results");
		}
String local1 =  getElement(Company_global_sanctions_list_check_result).getText();
		
		verbose("The result of Company global sanctions list check is :" + local1);
		if(local1.equals("Warning") || local1.equals("OK") || local1.equals("Critical"))
		{
			verbose("The result as expected : " + local1);
			return true;
		}
		else {
			verbose("The result not as expected");
			return false;
			
		}
	}
	
	public boolean Country_sanctions_check()

	{
		waitExplicitly(5);
		String local = getElement(Country_sanctions_check).getText();
		verbose("The field present is : " + local);
		if(local.equals("Country sanctions check"))
		{
			verbose("The Country sanctions check link is present under Latest screening results");
		}
		else
		{
			verbose("The Country sanctions check link is not present under Latest screening results");
		}
String local1 =  getElement(Country_sanctions_check_result).getText();
		
		verbose("The result of Country_sanctions_check_result is :" + local1);
		if(local1.equals("Warning") || local1.equals("OK") || local1.equals("Critical"))
		{
			verbose("The result as expected : " + local1);
			return true;
		}
		else {
			verbose("The result not as expected");
			return false;
			
		}
		
	}
	
	public boolean Ship_movement_history_check()

	{
		waitExplicitly(5);
		String local = getElement(Ship_movement_history_check).getText();
		verbose("The field present is : " + local);
		if(local.equals("Ship movement history check"))
		{
			verbose("The Ship movement history check link is present under Latest screening results");
		}
		else
		{
			verbose("The Ship movement history check link is not present under Latest screening results");
		}
String local1 =  getElement(Ship_movement_result).getText();
		
		verbose("The result of Ship movement history check is :" + local1);
		if(local1.equals("Warning") || local1.equals("OK") || local1.equals("Critical"))
		{
			verbose("The result as expected : " + local1);
			return true;
		}
		else {
			verbose("The result not as expected");
			return false;
			
		}
		
	}
	
	public boolean Port_state_control_history_check()

	{
		
		String local =  getElement(Port_state_control_history_check).getText();
		verbose("The text of the link is :" + local);
		if(local.equals("Port state control history check"))
		{
			verbose("Port state control history check link is present under Latest Screening results");
			
		}
		else {
			verbose("Port state control history check link is not present under Latest Screening results");
			
		}

	
		String local1 =  getElement(Port_state_control_history_check_result).getText();
		
		verbose("The result of Port state control history check is :" + local1);
		if(local1.equals("Warning") || local1.equals("OK") || local1.equals("Critical"))
		{
			verbose("The result as expected : " + local1);
			return true;
		}
		else {
			verbose("The result not as expected");
			return false;
			
		}
	}
	
	public boolean Last_updated_and_Date(){
		waitExplicitly(5);
		
		String Lastupdated_of_ship = getElement(ship_last_updated).getText();
		verbose("The last updated of the ship : " + Lastupdated_of_ship);
		String UTC = "UTC";
		String Last_updatedofship_withUTC = Lastupdated_of_ship +" " + UTC;
		waitExplicitly(5);
		verbose("The last updated of the ship with UTC :  " + Last_updatedofship_withUTC );
		String local = getElement(Last_updated_title_sidepanel).getText();
		verbose("The title of the field is :  " + local);
		
		if(local.equals("Last updated:"))
		{
			verbose("The title Last updated in the side panel is present correctly");
		}
		else{
			verbose("The title Last updated in the side panel is not present correctly");
		}
		
		waitExplicitly(3);
		
		String Last_updated_date_panel = getElement(Ship_last_updated_date_sidepanel).getText();
		verbose("The date in the side panel :  " + Last_updated_date_panel);
		
		if(Last_updated_date_panel.equals(Last_updatedofship_withUTC))
		{
			verbose("The last updated date matches between side panel and the screening result");
			return true;
		}
		else{
			verbose("The last updated date does not match between side panel and the screening result");
			return false;
		}
		
	
	}




		
	}


