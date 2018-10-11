package com.ps.maven.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;

import com.ps.maven.utils.BrowserTypes;

public class Previous_results extends BrowserTypes{
	
	public static String previous_date = null; 
	public static String First_last_updated_date = null;
	public static String First_last_updated_with_UTC = null;
	public static String Ship_name = null;
	ScreeningResultsPageColumnSorting last_updated = new ScreeningResultsPageColumnSorting();
	By Last_updated_first_ship = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row/ps-data-table-cell[7]");
	Ship_name_click ship = new Ship_name_click();
	By Previous_result_title_on_hover = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row/ps-data-table-cell[6]/div/div");
	By Previous_result_on_hover = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row/ps-data-table-cell[6]/div/div/span[2]");
	By previous_result_date = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row/ps-data-table-cell[6]/div/div/span[3]");
	By current_result_first_ship = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[5]/ps-screening-severity/p");
	By first_ship_in_table = By.xpath("//psp-core/div/ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[2]/a");
	By search_field = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[1]/ps-screening-filters/ps-searchbox/div/input");
	By Current_result_hover = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[6]");

    String Last_updated_second_time;
    String Ship_name2;
   /* static String Last_updated_first;
    		 String Last_updated = First_Last_updated2;
    		ArrayList <String> list;*/
    
	
	public boolean hover_current_result_first_ship() {
		
		verbose("Going to hover over the ship to check the previous result of the ship ");
		getElement(search_field).click();
		waitExplicitly(5);
		getElement(search_field).sendKeys(Ship_name2);
		waitExplicitly(10);
		Actions action = new Actions(driver);
		action.moveToElement(getElement(Current_result_hover)).build().perform();
		
		verbose("The previous result is ::::" + getElement(Previous_result_title_on_hover).getText());
		
		verbose("The previous result is ::::" + getElement(Previous_result_on_hover).getText());
		verbose("The previous result is ::::" + getElement(previous_result_date).getText());
		
 previous_date = getElement(previous_result_date).getText();
	
		waitExplicitly(2);
		verbose("Going to validate the previous result");
		//verbose("The debug is " + First_Last_updated2);
		
		return true;
	   
		
	}
	


	public String Ship_name(String Ship_name) {
		
		verbose("First ship in the table::::" + getElement(first_ship_in_table).getText());
		String Ship_name1 = getElement(first_ship_in_table).getText();
		return Ship_name1;
		
	}
	public boolean local() {
		String Last_updated_second_time = check_last_updated1_execution();
		verbose("Last updated date after rescreen:::::::::::::::::::::::::::::::" + Last_updated_second_time);
		if(!Last_updated_second_time.isEmpty()) {
        	verbose("The date is displayed correctly");
        	return true;
        }
        else {
        	verbose("The date NOT displayed correctly");
        	return false;
        }


}
	
	public String check_last_updated1_execution() {
		Ship_name2 = Ship_name(Ship_name);
        
		/*verbose("First ship in the table::::" + getElement(first_ship_in_table).getText());
		String Ship_name = getElement(first_ship_in_table).getText();*/
        //list = new ArrayList<String>();
        
	    String Last_updated = getElement(Last_updated_first_ship).getText();
		verbose("The last updated date for the first ship: " + Last_updated);
		return Last_updated;
		
		
	}
	public boolean check_last_updated_before_rescreening() {
		waitExplicitly(5);
		
		First_last_updated_date	= check_last_updated1_execution();
		verbose("The date BEFORE rescreen :::::::::::::::::::::" + First_last_updated_date);
		String UTC = "UTC";
		 First_last_updated_with_UTC  = First_last_updated_date +" " + UTC;
	        if(!First_last_updated_date.isEmpty()) {
	        	verbose("The date is displayed correctly");
	        	return true;
	        }
	        else {
	        	verbose("The date NOT displayed correctly");
	        	return false;
	        }
			
		}

	public boolean validate_previous_result() {
		local();
		
		 verbose("Getting both the values to compare now::::::::::::::::::::::::::");
		 verbose("The date BEFORE rescreen :::::::::::::::::::::" + First_last_updated_with_UTC);
		 verbose("The date in Previous result::::::::::::" + previous_date);
		
	/*System.out.println(list.get(0));
	System.out.println(list.get(1));*/

	        if(First_last_updated_with_UTC.equalsIgnoreCase(previous_date)) {
	        	verbose("The Previous result matched and validated : CORRECT ");
	        	return true;
	        }
	        else {
	        	verbose("Previous Result NOT correct:::::::::::::::::::::::::::");
	        	return false;
	        }
			
		}
	
	
}

