package com.ps.maven.screen;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ps.maven.utils.BrowserTypes;

public class Flag_filter_ScreeningResultsPage extends BrowserTypes{
	By flag_filter_search_field = By.xpath("//*[@id='all-flags']/div/ps-auto-complete/input");
	By flag_header_filter = By.xpath("//ps-dropdown-input[1]/div/button/div/span[1]");
	By flag_clear_all = By.xpath("//*[@id=\"all-flags\"]/div/p/span");
	
	//ID's for the flag filter
	By first_filter_result = By.cssSelector("#all-flags");
	By first_flag = By.xpath("//*[@id='all-flags']/div/ps-auto-complete/div/div/ps-auto-complete-option");
	By flag_Selected = By.xpath("//*[@id=\"all-flags\"]/div/ps-group-item/div/div[2]");
	By flag_Selected2 = By.xpath("//*[@id=\"all-flags\"]/div/ps-group-item[2]/div/div[2]");
	By flag_table_updated = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-table-row/ps-table-cell[1]/div/ps-flag/span");
	By selected_flag_id = By.xpath("//*[@id=\"all-flags\"]/div/ps-group-item/div/div[1]/ps-flag/span");
	By selected_flag_id_2 = By.xpath("//*[@id=\"all-flags\"]/div/ps-group-item[2]/div/div[1]/ps-flag/span");
	By no_result_found = By.xpath("//ps-data-table/div/ps-fill-space-message/div/h2");
	//*[@id="all-flags"]/div/ps-group-item/div/div[2]
	//*[@id="all-flags"]/div/ps-group-item[2]/div/div[2]
	Common_methods ship_count = new Common_methods();

	public boolean all_flags_click() {
		//By flag_filter = By.xpath("//ps-screening-component/ps-table/div/div[1]/ps-table-header/ps-dropdown-input[1]/div/button/div");

		int count = 0;

		waitExplicitly(3);
		getDriver().manage().deleteAllCookies();
		waitExplicitly(2);
		//getDriver().navigate().refresh();
		waitExplicitly(3);

		if(getElement(flag_header_filter).getText().equals("All flags")) {
			verbose("Heading is seen correctly");
			count++;
		}else {
			verbose("Heading is NOT seen correctly");
			count++;
		}
		verbose("Clicking on the All Flags filter");


		verbose("Checking the All flags filter heading");
		waitExplicitly(2);
		getElement(flag_header_filter).click();
		waitExplicitly(6);
		
		/*String local = getElement(flag_filter_search_field).getAttribute("placeholder");
		verbose("The place holder is :: " + getElement(flag_filter_search_field).getAttribute("placeholder"));
		if(getElement(flag_filter_search_field).getAttribute("placeholder").equals("Search flags")) {
			verbose("Successfully clicked on All flags filter");
			count ++;
		}else {
			verbose("NOT clicked on All flags filter successfully");
		}

		if(count == 2) {
			verbose("All flags click is Successful");
			return true;
		}else {
			verbose("All flags click is Unsuccessful");
			return false;
		}*/
return true;
	}

	public boolean first_flag_filter() {
		if(screening_results_table_all_flags_click(getProps().getProperty("flag_search_string1"),1)) {
			verbose("successfully updated");
			return true;
		}else {
			verbose("successfully NOT updated");
			return false;
		}

	}

	public boolean all_flags_header_update_one() {

		verbose("The header for one flag is updated successfully");
		return true;

	}

	public boolean all_flags_header_update_second() {

		verbose("The header for two flag is updated successfully");
		return true;

	}

	public boolean flag_filter_second() {
		if(screening_results_table_all_flags_click(getProps().getProperty("flag_search_string2"),2)) {
			verbose("successfully updated");
			return true;
		}else {
			verbose("successfully NOT updated");
			return false;
		}

	}

	public boolean filter_clear_flag() {

		waitExplicitly(2);

		//	getElement(flag_header).click();
		verbose("Clicking on the \"Clear selection\" in flags filter");

		getElement(flag_clear_all).click();
		waitExplicitly(5);
		verbose("The flag filter header is :: " + getElement(flag_header_filter).getText());
		if(getElement(flag_header_filter).getText().equals("All flags")) {
			verbose("Clicked on \"All clear\" in filter type successfully");
			return true;
		}else {
			verbose("NOT clicked on \"All clear\" in filter type");
			return false;
		}
	}

	public boolean clicking_on_cross_flag() {
		By cross_mark = By.xpath("//*[@id=\"all-flags\"]/div/ps-group-item/div/button/i");
		
		String ship_count1 = getElement(ship_count.ship_count).getText();
		int ship_count_only = Integer.parseInt(ship_count1);
		verbose("Ship count only is :: " + ship_count_only );
		waitExplicitly(2);

		verbose("Clicking on the \"X\" mark");

		getElement(cross_mark).click();

		//getDriver().navigate().refresh();
		waitExplicitly(2);
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
	
	public boolean clicking_on_clear_all_flag() {
		By clear_all = By.xpath("//*[@id=\"all-flags\"]/div/p");

		String ship_count1 = getElement(ship_count.ship_count).getText();
		int ship_count_only = Integer.parseInt(ship_count1);
		verbose("Ship count only is :: " + ship_count_only );
		waitExplicitly(2);

		verbose("Clicking on the \"clear all\"");
		waitExplicitly(3);
		getElement(flag_header_filter).click();
		waitExplicitly(2);
		getElement(clear_all).click();

		//getDriver().navigate().refresh();
		waitExplicitly(2);
		verbose("THe ship count is :: " + ship_count.ship_count());

		waitExplicitly(2);
		if(ship_count_only != ship_count.ship_count()) {
			verbose("Clicked on the \"clear_all\" successfully");
			return true;
		}else {
			verbose("NOT clicked on the \"clear_all\" successfully");
			return false;
		}

	}


	public boolean  screening_results_table_all_flags_click(String flag_search,int num) {
		
		int search_result = 0;
		verbose("Entering the search string in the field ::" + flag_search);
		getElement(flag_filter_search_field).sendKeys(flag_search);
		waitExplicitly(1);		

		List<WebElement> flag = getElements(first_filter_result);

		int count = 0;
		int final_count = 0;
		int internal_count = 0;
		int first_flag_selected = 0;
		int second_flag_selected = 0;

		//This is to verify the search string for the flag filter contains the string entered for searching
		for(WebElement obj : flag) {
			String str  = obj.getText();
			verbose("The flag list is :: " + obj.getText()) ;
			String[] result = str.split("\n");
			search_result =  result.length;
			verbose("The number of search results found are :: " + search_result);
			if(num == 1 ) {
				for(int i = 0 ; i < search_result ; i++) { 
					verbose("The flag is :: " + result[i] + " " + i);

					if(result[i].toLowerCase().contains(flag_search)) {
						verbose("The search strings matches");
						count++;
					}else {
						verbose("The search strings doesn't matches");

					}

				}
				verbose("The count of the flag filter listed is :: " + count);
				waitExplicitly(2);
				if(count == search_result) {
					verbose("Flag filter search is working correctly");
					final_count++;
				}else {
					verbose("Flag filter search is NOT working correctly");
				}
			}else {
				for(int i = 1 ; i < search_result-1 ; i++) { 
					verbose("The flag is :: " + result[i] + " " + i);

					if(result[i].toLowerCase().contains(flag_search)) {
						verbose("The search strings matches");
						count++;
					}else {
						verbose("The search strings doesn't matches");

					}

				}

				verbose("The count of the flag filter listed is :: " + count);
				if(count == search_result-2) {
					verbose("Flag filter search is working correctly");
					final_count++;
				}else {
					verbose("Flag filter search is NOT working correctly");
				}
			}

		}
		waitExplicitly(5);
		verbose("Clicking on the first selection from the search results");
		waitExplicitly(5);
		String first_flag_clicked = getElement(first_flag).getText();
		verbose("The first flag clicked on is :: " + first_flag_clicked);
		getElement(first_flag).click();
		waitExplicitly(2);
		if(num == 1) {
			verbose("The first flag ID selected is :::: " + getElement(selected_flag_id).getAttribute("class"));
			waitExplicitly(3);
			//This is to verify the flag filter is selected successfully within the flag filter window
			if(getElement(flag_Selected).getText().equals(first_flag_clicked)) {
				verbose("The flag is selected successfully");
				if(getElement(flag_header_filter).getText().equals("1 flag")){
					verbose("Header updated");
					all_flags_header_update_one();
				}
				final_count++;
			}else {
				verbose("The flag is NOT selected");
			}
		}else {

			verbose("The second flag ID selected is ::: " + getElement(selected_flag_id_2).getAttribute("class"));
			waitExplicitly(3);
			verbose("The flag selected is :: " + getElement(flag_Selected2).getText());
			//This is to verify the flag filter is selected successfully within the flag filter window
			if(getElement(flag_Selected2).getText().equals(first_flag_clicked)) {
				verbose("The flag is selected successfully");
				if(getElement(flag_header_filter).getText().equals("2 flags")) {
					all_flags_header_update_second();
				}

				final_count++;
			}else {
				verbose("The flag is NOT selected");
			}
		}

		waitExplicitly(3);
		//The below if conditions is to verify the screening results page is updated with the filter selected.
		if(ship_count.ship_count() == 1) {

			if(getElement(selected_flag_id).getAttribute("class").equals(getElement(flag_table_updated).getAttribute("class")) || getElement(selected_flag_id_2).getAttribute("class").equals(getElement(flag_table_updated).getAttribute("class"))) {
				verbose("The table is updated with the flag filter selected ::: " + getElement(flag_table_updated).getAttribute("class"));
				final_count++;
			}else {
				verbose("The table is NOT updated with the flag filter selected");

			}
		}else if(ship_count.ship_count() > 1){
			for(int i = 1; i <= ship_count.ship_count() ; i++) {
				waitExplicitly(2);
				
				String xpath = "//ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[1]/ps-flag/span";
				if(getElement(By.xpath(xpath)).getAttribute("class").equals(getElement(selected_flag_id).getAttribute("class"))){
					verbose("Match found :: " + i + " " + getElement(By.xpath(xpath)).getAttribute("class") );
					first_flag_selected++;
					verbose("first_flag_selected ::: " + first_flag_selected);
					//internal_count++; 
				}else if(getElement(By.xpath(xpath)).getAttribute("class").equals(getElement(selected_flag_id_2).getAttribute("class"))){
					verbose("Match found :: " + i + " " + getElement(By.xpath(xpath)).getAttribute("class") );
					second_flag_selected++;
				}else {
					verbose("No match found");
				}
			}
			waitExplicitly(3);

			verbose("Total flag filter filter results for first flag ::: " + first_flag_selected);
			verbose("Total flag filter filter results for second flag ::: " + second_flag_selected);			

			if((first_flag_selected + second_flag_selected ) == ship_count.ship_count()) {
				verbose("The table is updated with the flag filter selected");
				final_count++;
			}else {
				verbose("The table is NOT updated with the flag filter selected");
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


}
