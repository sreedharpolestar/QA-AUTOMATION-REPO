package com.ps.maven.screen;

import org.apache.logging.log4j.core.pattern.IntegerPatternConverter;
import org.openqa.selenium.By;

import com.ps.maven.utils.BrowserTypes;

public class AddShips_ByShipPage extends BrowserTypes{
	
	By ship_search_field = By.xpath("//ps-screening-component/ps-screening-add/ps-tab-container/div/div/ps-tab[1]/div/ps-screening-add-by-ships/div/div/ps-auto-complete/input");
	By first_ship = By.xpath("//ps-screening-component/ps-screening-add/ps-tab-container/div/div/ps-tab[1]/div/ps-screening-add-by-ships/div/div/ps-auto-complete/div/div/ps-auto-complete-option[1]");
	By ship_selected = By.xpath("//ps-tab-container/div/div/ps-tab[1]/div/ps-screening-add-by-ships/div/div/div/ps-group-item/div/div[2]");
	By screen_button_number = By.xpath("//psp-core/div/ps-screening-component/ps-screening-add/footer/button/div[1]");
	
	By screen_button = By.xpath("//ps-screening-component/ps-add/footer/button");
	
	public boolean search_field_click() {
		//This is to verify the search click and enter string

		verbose("Clicking on the search field");
		getElement(ship_search_field).click();

		waitExplicitly(2);

		getElement(ship_search_field).sendKeys(getProps().getProperty("ship_search_byship_1"));

		verbose("The string entered is :: " + getElement(ship_search_field).getAttribute("value"));
		if(getElement(ship_search_field).getAttribute("value").equals(getProps().getProperty("ship_search_byship_1"))) {
			verbose("Clicked on the search field and the element is entered successfully");
			return true;
		}else {
			verbose("NOT Clicked on the search field and the element is entered successfully");
			return false;
		}

	}

	public boolean search_results_and_select() {
		
		int count = 0;
		
		//getElement(ship_search_field).sendKeys(getProps().getProperty("ship_search_byship_1"));
		waitExplicitly(3);
		verbose("The first ship found is :: " + getElement(first_ship).getText());
		for(int i = 1; i<=2 ; i++) {
			String xpath = "//ps-screening-component/ps-screening-add/ps-tab-container/div/div/ps-tab[1]/div/ps-screening-add-by-ships/div/div/ps-auto-complete/div/div/ps-auto-complete-option[" + i +"]";
			
			if(getElement(By.xpath(xpath)).getText().toLowerCase().contains(getProps().getProperty("ship_search_byship_1"))) {
				verbose( getElement(By.xpath(xpath)).getText() + " the results contains the search string " + "\"" + getProps().getProperty("ship_search_byship_1") + "\"");
		
				count++;
			}else {
				verbose("No match found");
			}			
		}
		if(count == 2) {
			verbose("The search result verification is successfully performed");
			return true;
		}else {
			verbose("The search result verification is NOT successfully performed");
			return false;
		}
		
	}
	
	public boolean click_and_select_ship() {

		verbose("Clicking on the first selection from the search results");
		waitExplicitly(3);
		getElement(first_ship).click();
		String first_ship_clicked = getElement(first_ship).getText();
		//String[] ship_trim = first_ship_clicked.split("\\(");
		verbose("The first ship clicked on is :: " + first_ship_clicked);
		verbose("The first ship Selected is :: " + getElement(ship_selected).getText());
		
		if(getElement(screen_button_number).getText().equals("1")) {
			verbose("The ship clicked is successfully selected");
			return true;
		}else {
			verbose("The ship clicked is NOT successfully selected");
			return false;
		}
		
		
	}
	
	public boolean selecting_multiple_ships() {
		int count = 0;
		verbose("Entering the second string for selecting mutiple ships");
		
		for(int i = 1; i<=4 ; i++) {
			
			getElement(ship_search_field).sendKeys(getProps().getProperty("ship_search_byship_mutiple_" + i + ""));
			waitExplicitly(3);
			verbose("The first ship found is :: " + getElement(first_ship).getText());
			
			String xpath = "//ps-add-by-ships/div/div/ps-auto-complete/div/div/ps-auto-complete-option[" + i + "]";

			if(getElement(By.xpath(xpath)).getText().toLowerCase().contains(getProps().getProperty("ship_search_byship_mutiple_" + i + ""))) {
				waitExplicitly(2);
				verbose( getElement(By.xpath(xpath)).getText() + " the results contains the search string " + "\"" + getProps().getProperty("ship_search_byship_mutiple_" + i + "") + "\"");
				waitExplicitly(4);
				getElement(By.xpath(xpath)).click();
				waitExplicitly(1);
				count++;
			}else {
				verbose("No match found");
			}								
		}
		verbose("Count next to Screen button is :: " + getElement(screen_button_number).getText());
		
		if(count == 4 && getElement(screen_button_number).getText().equals(Integer.toString(count))) {
			verbose("ships are added successfully");
			return true;
		}else {
			verbose("Ships are not added successfully");
			return false;
		}
	}
	
	public boolean clicking_on_cross_ship_type() {
		By cross_mark = By.xpath("//ps-add-by-ships/div/div/div/ps-group-item/div/button/i");
		By ship_list = By.xpath("//ps-screening-component/ps-add/ps-tab-container/div/div/ps-tab[1]/div/ps-add-by-ships/div/div/div");
	
		/*String ship_count1 = getElement(screen_button_number).getText();
		int ship_count_only = Integer.parseInt(ship_count1.substring(0,ship_count1.indexOf(" ")));*/
	//	verbose("Ship count only is :: " + ship_count_only );
		waitExplicitly(3);
		
		verbose("Clicking on the \"X\" mark");
		
		 getElement(cross_mark).click();
		 
		 waitExplicitly(2);
		 verbose("The attribute is :: " + getElement(ship_list).getText());
		 if(getElement(ship_list).getText().equals("")) {
			 verbose("Successfully clicked on the \"X\" mark");
			 return true;
		 }else {
			 verbose("Successfully NOT clicked on the \"X\" mark");
			 return false;
		 }
		 		
	}
	
	public boolean screen_button_disabled() {
		getDriver().navigate().refresh();
		 waitExplicitly(4);
		 verbose("The ship count is :: " + getElement(screen_button_number).getText());
		 
		 verbose("The return value for screen button is :: " + getElement(screen_button).isEnabled());
		 waitExplicitly(2);
		if(getElement(screen_button_number).getText().equals("0") && !getElement(screen_button).isEnabled()) {
			verbose("Clicked on the Cross mark successfully");
			return true;
		}else {
			verbose("NOT clicked on the Cross mark successfully");
			return false;
		}
		
		
	}
}
