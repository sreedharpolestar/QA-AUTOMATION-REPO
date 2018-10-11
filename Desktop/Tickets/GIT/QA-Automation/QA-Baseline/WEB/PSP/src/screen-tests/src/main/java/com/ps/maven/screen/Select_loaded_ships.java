package com.ps.maven.screen;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ps.maven.utils.BrowserTypes;

public class Select_loaded_ships extends BrowserTypes {

	Flag_filter_ScreeningResultsPage flag_filter = new Flag_filter_ScreeningResultsPage();
	By flag_header_filter = By.xpath("//ps-dropdown-input[1]/div/button/div/span[1]");
	By top_check_box = By.xpath("//psp-core/div/ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/header/div[1]/input");
	By ship_loaded_count = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-screening-table-totals/div[2]/div[1]/span[1]");
	By ship_selected_count = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-screening-table-totals/div[2]/div[2]/span[1]");
	By ships_loaded = By.xpath("//ps-screening-table/div/div/div[2]/ps-screening-table-totals/div[2]/div[1]/span[1]");
	By selected_xpath = By.xpath("//ps-screening-table-totals/div[2]/div[2]/span[3]");
	By ship_listed_count = By.xpath("//ps-screening-table/div/div/div[2]/ps-screening-table-totals/div[1]/span[1]");	
	By screening_result_header = By.xpath("//ps-table/div/header/h3");
	int ship_selected_count_after_selection_int = 0;
	By Select_all_checkbox = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/header/div[1]/input");
	public boolean top_check_box_click() {

		waitExplicitly(2);

		verbose("Click on the Screen ing results header to find the top_check_box for filters");
		//getElement(screening_result_header).click();

		verbose("Clicking on the top check box");
		waitExplicitly(5);
		getElement(top_check_box).click();
		waitExplicitly(2);
		String ship_selected_count_after_selection = getElement(ship_selected_count).getText();
		verbose("The debug is " + ship_selected_count_after_selection);
		int ship_selected_count_after_selection_int = Integer.parseInt(ship_selected_count_after_selection);
		
		if(ship_selected_count_after_selection_int > 1) {
		//String ship_selected_full_string = getElement(ship_selected_count).getText() + " " + getElement(ships_loaded).getText() + " " + getElement(selected_xpath).getText();
		//verbose("ship_selected_full_string ::" + ship_selected_full_string);
		//verbose("Ship loaded count :::" + getElement(ship_loaded_count).getText());
		//verbose("Ship selected count :::" + getElement(ship_selected_count).getText());
		if(getElement(ship_loaded_count).getText().equals(getElement(ship_selected_count).getText())) {
			verbose("Selected and loaded ships matches");
			return true;
		}else {
			verbose("Selected and loaded ships doesn't matches");
			return false;
		}
		}else {
			String ship_selected_full_string = getElement(ship_selected_count).getText() + " " + getElement(ships_loaded).getText() + " " + getElement(selected_xpath).getText();
			if(getElement(ship_loaded_count).getText().equals(getElement(ship_selected_count).getText()) && ship_selected_full_string.equals(getElement(ship_loaded_count).getText() + " " + "ship selected")) {
				verbose("Selected and loaded ships matches");
				return true;
			}else {
				verbose("Selected and loaded ships doesn't matches");
				return false;
			}
		}

	}

	//This is to check the checkbox
	public boolean check_box() {
		verbose("Checking the checkbox selected");
		if(getElement(top_check_box).isSelected()) {
			verbose("The checkbox is selected");
			return true;
		}else {
			verbose("The checkbox is not selected");
			return false;
		}
	}

	//This is to verify the clear checkbox.
	public boolean clear_check_box() {

		verbose("Clearing the checkbox selected");
		getElement(top_check_box).click();
		waitExplicitly(2);

		if(!getElement(top_check_box).isSelected()) {
			verbose("The checkbox is unselected");
			return true;
		}else {
			verbose("The checkbox is not unselected");
			return false;
		}
	}

	public boolean verify_the_check_box_applied_with_filter() {
		
		waitExplicitly(5);
		int count = 0;
		verbose("This is to verify the filter selected and clicked on all select checkbox is working correctly");
		//getElement(screening_result_header).click();
		waitExplicitly(3);
		getElement(flag_header_filter).click();
		waitExplicitly(3);
		getElement(Select_all_checkbox).click();
		waitExplicitly(5);
		String ship_selected_count_after_selection = getElement(ship_selected_count).getText();
		verbose("Debug :::::"  + ship_selected_count_after_selection);
		int ship_selected_count_after_selection_int = Integer.parseInt(ship_selected_count_after_selection); 
		
		verbose("ship_selected_count_after_selection_int ::: " + ship_selected_count_after_selection_int);
		
		String ship_listed_count1 = getElement(ship_listed_count).getText();
		int ship_count = Integer.parseInt(ship_listed_count1);

		waitExplicitly(2);
		for(int i = 1 ; i <= ship_count ; i++) {
			String check_box = "//ps-data-table/div/div/ps-table-row["+ i + "]/div/input";
		String check_box_higlight = "//ps-data-table/div/div/ps-table-row[" + i + "]";
			
		if(getElement(By.xpath(check_box_higlight)).getAttribute("class").equals("table-row ng-star-inserted highlight") && getElement(By.xpath(check_box)).isSelected()) {
			waitExplicitly(1);
			count++;
			verbose("The row is selected and higlighted" + i);								
		}else {
			verbose("The row is NOT selected and higlighted" + i);
		}
		}
		verbose("The count of higlighted ships is :::: " + count);
		verbose("The ship_selected_count_after_selection_int is :::: " + ship_selected_count_after_selection_int);
		
		waitExplicitly(2);
		if(count == ship_selected_count_after_selection_int){
			verbose("verify_the_check_box_applied_with_filter is working correctly");
			return true;
		}else {
			verbose("verify_the_check_box_applied_with_filter is NOT working correctly");
			return false;
		}

	}
		
		/*for(int i = 1 ; i <= ship_count ; i++) {

			String xpath_flag_id = "//ps-data-table/div/div[2]/ps-table-row[" + i + "]/ps-table-cell[1]/div/ps-flag/span";
			String check_box_higlight = "//ps-data-table/div/div[1]/div[" + i + "]";

			if(i  < 51) {
			if(existsElement(xpath_flag_id)) {
				if(getElement(By.xpath(check_box_higlight)).getAttribute("class").equals("data-table__checkbox highlight")) {
					waitExplicitly(1);
					count++;
					verbose("The row is selected and higlighted" + i);								
				}else {
					verbose("The row is NOT selected and higlighted" + i);
				}
			}
			}else if(i >= 51){
				waitExplicitly(1);
				verbose("Inside the scroll function");
				EventFiringWebDriver eventfiringWebDriver = new EventFiringWebDriver(driver);
				eventfiringWebDriver.executeScript("document.querySelector('body > psp-app > psp-core > div > ps-screening-component > ps-table > div > div > div.screening-table > ps-data-table > div').scrollTop=1500");
				waitExplicitly(1);
				if(getElement(By.xpath(check_box_higlight)).getAttribute("class").equals("data-table__checkbox highlight")) {
					waitExplicitly(1);
					verbose("The row is selected and higlighted");
					count++;			
				}else {
					verbose("The row is NOT selected and higlighted");
				}
					
			}
			else if(i >= 101){
				waitExplicitly(1);
				verbose("Inside the scroll function");
				EventFiringWebDriver eventfiringWebDriver = new EventFiringWebDriver(driver);
				eventfiringWebDriver.executeScript("document.querySelector('body > psp-app > psp-core > div > ps-screening-component > ps-table > div > div > div.screening-table > ps-data-table > div').scrollTop=1500");
				waitExplicitly(1);
				if(getElement(By.xpath(check_box_higlight)).getAttribute("class").equals("data-table__checkbox highlight")) {
					waitExplicitly(1);
					verbose("The row is selected and higlighted");
					count++;			
				}else {
					verbose("The row is NOT selected and higlighted");
				}
			}
			
		
			if(count == ship_selected_count_after_selection_int) {
				verbose("Found the match exit");
				break;
			}else {
				continue;
			}
		}
		*/
		

	private boolean existsElement(String id) {
		try {
			getElement(By.xpath(id));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}
}
