package com.ps.maven.screen;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ps.maven.utils.BrowserTypes;

public class ShipTypes_filter_ScreeningResultsPage extends BrowserTypes{

	//By ship_count = By.xpath("//ps-screening-component/ps-table/div/div/div[2]/ps-table-totals/div[1]/span[1]");	
	By ship_type_header = By.xpath("//ps-dropdown-input[2]/div/button/div/span[1]");	
	By ship_type_search_field = By.xpath("//*[@id=\"all-ships\"]/div/ps-auto-complete/input");	
	By ship_type_clear_all = By.xpath("//*[@id=\"all-ships\"]/div/p/span");

	Common_methods ship_count = new Common_methods();

	public boolean first_ship_type_filter() {
		if(screening_results_table_all_ship_type_click(getProps().getProperty("ship_type_search_string1"),1)) {
			/*if(getElement(flag_header_filter).getText().equals("1 flag")) {
			all_flags_header_update_one();
		}*/
			verbose("First ship_type is successfully updated");
			return true;
		}else {
			verbose("First ship_type is NOT updated successfully");
			return false;
		}

	}

	public boolean all_ship_type_click() {
		By ship_type = By.xpath("//ps-dropdown-input[2]/div/button/div/span[1]");
		int count = 0;
		waitExplicitly(2);
		
		getDriver().manage().deleteAllCookies();
		waitExplicitly(2);
		//getDriver().navigate().refresh();
		//waitExplicitly(3);
		if(getElement(ship_type).getText().equals("All ship types")) {
			verbose("Heading is seen correctly");
			count++;
		}else {
			verbose("Heading is NOT seen correctly");
			count++;
		}
		verbose("Clicking on the Ship type filter");


		verbose("Checking the ship_types filter heading");
		waitExplicitly(2);
		getElement(ship_type).click();
		waitExplicitly(3);
		verbose("The place holder is :: " + getElement(ship_type_search_field).getAttribute("placeholder"));
		if(getElement(ship_type_search_field).getAttribute("placeholder").equals("Search ships")) {
			verbose("Successfully clicked on All ship types filter");
			count ++;
		}else {
			verbose("NOT clicked on All ship types filter successfully");
		}

		if(count == 2) {
			verbose("all_ships_click is Successful");
			return true;
		}else {
			verbose("all_ships_click is Unsuccessful");
			return false;
		}

	}

	public boolean all_ship_type_header_update_one() {

		verbose("The header for one ship_type is updated successfully");
		return true;

	}

	public boolean all_ship_type_header_update_second() {

		verbose("The header for two ship_type is updated successfully");
		return true;

	}

	public boolean ship_type_filter_second() {
		verbose("Calling the second ship_type filter updation");
		if(screening_results_table_all_ship_type_click(getProps().getProperty("ship_type_search_string2"),2)) {
			verbose("Second ship_type is successfully updated");
			return true;
		}else {
			verbose("Second ship_type is NOT updated successfully");
			return false;
		}

	}

	public boolean filter_clear_ship_type() {

		waitExplicitly(2);


		verbose("Clicking on the \"Clear selection\" in ship_types filter");

		waitExplicitly(1);
		getElement(ship_type_clear_all).click();
		waitExplicitly(1);
		if(getElement(ship_type_header).getText().equals("All ship types")) {
			verbose("Clicked on \"All clear\" in filter type successfully");
			return true;
		}else {
			verbose("NOT clicked on \"All clear\" in filter type");
			return false;
		}

	}

	public boolean  screening_results_table_all_ship_type_click(String ship_type_search,int num) {
		By first_filter_result = By.cssSelector("#all-ships");
		//By first_ship_type = By.cssSelector("#all-ships > div > ps-auto-complete > div > div > ps-auto-complete-option:nth-child(1)");
		By selected_ship_type_in_table = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[4]");
		By selected_ship_type1_as_filter = By.xpath("//*[@id=\"all-ships\"]/div/ps-group-item/div/div[2]");
		By selected_ship_type2_as_filter = By.xpath("//*[@id=\"all-ships\"]/div/ps-group-item[2]/div/div[2]");
		By no_result_found = By.xpath("//ps-data-table/div/ps-fill-space-message/div/h2");
		int search_result = 0;
		//*[@id="all-ships"]/div/ps-auto-complete/div/div/ps-auto-complete-option[1]
		By first_ship_type = By.xpath("//*[@id=\"all-ships\"]/div/ps-auto-complete/div/div/ps-auto-complete-option[1]");
		
		
		waitExplicitly(1);
	
		verbose("Entering the search string in the field ::" + ship_type_search);
		getElement(ship_type_search_field).sendKeys(ship_type_search);
		waitExplicitly(4);		

		List<WebElement> ship_type = getElements(first_filter_result);

		int count = 0;
		int final_count = 0;
		int internal_count = 0;
		int first_ship_type_selected = 0;
		int second_ship_type_selected = 0;
		
		//This is to verify the search string for the ship_type filter contains the string entered for searching
		for(WebElement obj : ship_type) {
			String str  = obj.getText();
			verbose("The ship_type list is :: " + obj.getText()) ;
			String[] result = str.split("\n");
			search_result =  result.length;
			verbose("The number of search results found are :: " + search_result);
			if(num == 1 ) {
				for(int i = 0 ; i < search_result ; i++) { 
					verbose("The ship_type is :: " + result[i] + " " + i);

					if(result[i].toLowerCase().contains(ship_type_search)) {
						verbose("The search strings matches");
						count++;
					}else {
						verbose("The search strings doesn't matches");

					}

				}
				verbose("The count of the ship_types filter for first filter listed is :: " + count);
				if(count == search_result) {
					verbose("ship_type filter search is working correctly for the first filter");
					final_count++;
				}else {
					verbose("ship_type filter search is NOT working correctly for the second filter");
				}
			}else {
				for(int i = 1 ; i < search_result-1 ; i++) { 
					verbose("The ship_type is :: " + result[i] + " " + i);

					if(result[i].toLowerCase().contains(ship_type_search)) {
						verbose("The search strings matches");
						count++;
					}else {
						verbose("The search strings doesn't matches");

					}

				}

				verbose("The count of the ship_types filter for the second filter listed is :: " + count);
				if(count == search_result-2) {
					verbose("ship_type filter search is working correctly for the second filter");
					final_count++;
				}else {
					verbose("ship_type filter search is NOT working correctly for the second filter");
				}
			}

		}

		verbose("Clicking on the first selection from the search results");
		waitExplicitly(4);
		String first_ship_type_clicked = getElement(first_ship_type).getText();
		verbose("The first ship_type clicked on is :: " + first_ship_type_clicked);
		getElement(first_ship_type).click();
		//waitExplicitly(6);
		
		waitExplicitly(4);
		if(num == 1) {
			verbose("Verifying the ship_type filter for the single ship_type selected");
			verbose("The first ship_type selected is :::: " + getElement(selected_ship_type1_as_filter).getText());

			waitExplicitly(3);
			//This is to verify the flag filter is selected successfully within the flag filter window
			if(getElement(selected_ship_type1_as_filter).getText().equals(first_ship_type_clicked)) {
				verbose("The ship_type is selected successfully");
				waitExplicitly(3);
				if(getElement(ship_type_header).getText().equals("1 ship type")) {
					verbose("The ship_type header is updated successfully :: " + getElement(ship_type_header).getText());
					all_ship_type_header_update_one();
				}else {
					verbose("The ship_type header is NOT updated successfully");
				}
				final_count++;
			}else {
				verbose("The ship_type is NOT selected");
			}
		}else {
			verbose("Verifying the ship_type filter for the second ship_type selected");

			//verbose("The second ship_type selected is ::: " + getElement(first_ship_type).getText());
			waitExplicitly(4);
			verbose("The ship_type selected is :: " + getElement(selected_ship_type2_as_filter).getText());
			//This is to verify the flag filter is selected successfully within the flag filter window
			if(getElement(selected_ship_type2_as_filter).getText().equals(first_ship_type_clicked)) {
				verbose("The ship_type is selected successfully");
				if(getElement(ship_type_header).getText().equals("2 ship types")) {
					verbose("The ship_type header is updated successfully :: " + getElement(ship_type_header).getText() );
					all_ship_type_header_update_second();
				}else {
					verbose("The ship_type header is NOT updated successfully");
				}
				final_count++;
			}else {
				verbose("The ship_type is NOT selected");
			}
		}

		waitExplicitly(3);


		verbose("The below if conditions is to verify the screening results page is updated with the filter selected.");
		if(ship_count.ship_count() == 1) {
			if(getElement(selected_ship_type1_as_filter).getText().equals(getElement(selected_ship_type_in_table).getText()) || getElement(selected_ship_type2_as_filter).getText().equals(getElement(selected_ship_type_in_table).getText())) {
				verbose("The table is updated with the ship_type filter selected ::: " + getElement(selected_ship_type_in_table).getText());
				final_count++;
			}else {
				verbose("The table is NOT updated with the ship_type filter selected");

			}
		}else if(ship_count.ship_count() > 1){
			for(int i = 1; i <= ship_count.ship_count() ; i++) {
				
				String xpath = "//ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[4]";
			
				if(getElement(By.xpath(xpath)).getText().equals(getElement(selected_ship_type1_as_filter).getText())){
					verbose("Match found :: " + i + " " + getElement(By.xpath(xpath)).getAttribute("class") );
					first_ship_type_selected++;
					//internal_count++;
				}else if(getElement(By.xpath(xpath)).getText().equals(getElement(selected_ship_type2_as_filter).getText())){
					verbose("Match found :: " + i + " " + getElement(By.xpath(xpath)).getText() );
					second_ship_type_selected++;
				}else {
					verbose("No match found");
				}
			}
			if((first_ship_type_selected + second_ship_type_selected ) == ship_count.ship_count()) {
				verbose("The table is updated with the ship_type filter selected");
				final_count++;
			}else {
				verbose("The table is NOT updated with the ship_type filter selected");
			}
		}else {
			if(getElement(no_result_found).getText().equals("No results found.")) {
				verbose("There are no results found for the filter in the table");
				final_count++;
			}
		}

		if(final_count == 3) {
			verbose("Searching and selecting ship is working correctly");
			return true;
		}else {
			verbose("Searching and selecting ship is NOT working correctly");
			return false;
		}

	}	


	public boolean clicking_on_cross_ship_type() {
		By cross_mark = By.xpath("//*[@id=\"all-ships\"]/div/ps-group-item/div/button/i");
		
		String ship_count1 = getElement(ship_count.ship_count).getText();
		int ship_count_only = Integer.parseInt(ship_count1);
		verbose("Ship count only is :: " + ship_count_only );
		waitExplicitly(2);

		verbose("Clicking on the \"X\" mark");

		getElement(cross_mark).click();

		//getDriver().navigate().refresh();
		waitExplicitly(4);
		verbose("THe ship count is :: " + ship_count.ship_count());

		waitExplicitly(2);
		if(ship_count_only != ship_count.ship_count()) {
			verbose("Clicked on the Cross mark successfully");
			return true;
		}else {
			verbose("NOT clicked on the Cross mark successfully");
			return false;
		}

	}
	
	public boolean clicking_on_clear_all_ship_type() {
		By clear_all = By.xpath("//*[@id=\"all-ships\"]/div/p/span");
		
		String ship_count1 = getElement(ship_count.ship_count).getText();
		int ship_count_only = Integer.parseInt(ship_count1);
		verbose("Ship count only is :: " + ship_count_only );
		waitExplicitly(2);

		verbose("Clicking on the \"clear all\"");

		getElement(clear_all).click();

		//getDriver().navigate().refresh();
		waitExplicitly(4);
		verbose("THe ship count is :: " + ship_count.ship_count());

		waitExplicitly(2);
		if(ship_count_only != ship_count.ship_count()) {
			verbose("Clicked on the \"clear selections\" successfully");
			return true;
		}else {
			verbose("NOT clicked on the \"clear selections\" successfully");
			return false;
		}

	}


}
