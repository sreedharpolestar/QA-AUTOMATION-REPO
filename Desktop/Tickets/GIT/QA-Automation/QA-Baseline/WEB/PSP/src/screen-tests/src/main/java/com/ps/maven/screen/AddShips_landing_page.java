package com.ps.maven.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.ps.maven.utils.BrowserTypes;


public class AddShips_landing_page extends BrowserTypes{
	
	Common_methods screen = new Common_methods();
	//By add_ships_button = By.xpath("//ps-screening-component/div/ps-table/div/div[1]/div/a/div[2]");
	By add_ships_page_heading = By.xpath("//ps-screening-component/ps-screening-add/header/h3");
	
	public boolean add_ships_button_click() {
		int count = 0;
		waitExplicitly(4);

		if(getElement(screen.add_ships_button).getText().equals("Add ships")) {
			verbose("\"Add ships\" text value is correctly seen");
			count ++;
		}else {
			verbose("\"Add ships\" text value is NOT seen correctly");
		}

		waitExplicitly(2);
		verbose("clicking on the \"Add Ships\" button");
		getElement(screen.add_ships_button).click();

		if(getElement(add_ships_page_heading).getText().equals("Add ship(s) to be screened")) {
			verbose("Successfully landed in \"Add ships\" page");
			count ++;
		}else {
			verbose("\"Add ships\" button click is NOT working");
		}

		if(count == 2) {
			verbose("add_ships_button_click() is working correctly");
			return true;
		}else {
			verbose("add_ships_button_click() is working correctly");
			return false;
		}
	}


	public boolean add_ships_by_ship_headings() {
		waitExplicitly(2);

		if(getElement(add_ships_page_heading).getText().equals("Add ship(s) to be screened")) {
			verbose("\"Add ship(s) to be screened\" is seen correctly and successfully landed in Add ships page");
			return true;
		}else {
			verbose("\"Add ship(s) to be screened\" is NOT seen correctly");
			return false;
		}
	}
	
	public boolean add_ships_by_ship_subtext() {
		waitExplicitly(2);
		By add_ships_subtext = By.xpath("//ps-screening-component/ps-screening-add/header/p");
	
		if(getElement(add_ships_subtext).getText().equals("Add ship(s) to be screened by search, typed list or spreadsheet upload")) {
			verbose("Subtext in Add ship(s) page is seen correctly");
			return true;
		}else {
			verbose("Subtext in Add ship(s) page is NOT seen correctly");
			return false;
		}
	}
	
	public boolean cancel_button() {
		waitExplicitly(2);
		By cancel_button = By.xpath("//ps-screening-component/ps-screening-add/footer/a");
		
		if(getElement(cancel_button).isDisplayed() && getElement(cancel_button).getText().equals("Cancel")) {
			verbose("Cancel button is seen");
			return true;
		}else {
			verbose("Cancel button is NOT seen");
			return false;
		}
	}
	
	public boolean screen_button() {
		waitExplicitly(2);
		
		By screen_button = By.xpath("//ps-screening-component/ps-screening-add/footer/button/div[2]");
		/* 
		if(getElement(screen_button).getAttribute("class").equals("disabled")) {
			verbose("Screen button is disabled");
		}else {
			verbose("Screen button is not disabled");
		}
		 */
		if(getElement(screen_button).getText().equals("Screen")) {
			verbose("Screen button is seen");
			return true;
		}else {
			verbose("Screen button is NOT seen");
			return false;
		}
	}
	
	public boolean by_ship_tab() {
		waitExplicitly(2);
		
		By by_ship_tab = By.xpath("//ps-screening-component/ps-screening-add/ps-tab-container/header/a[1]");
		String hex = hex(by_ship_tab);		
	
		if(getElement(by_ship_tab).getText().equals("By ship") && getElement(by_ship_tab).isDisplayed() && hex.equals("#445a71")) {
			verbose("By ship tab is seen and is higlighted.");
			return true;
		} else {
			verbose("By ship tab is seen and is NOT higlighted");
			return false;
		}
	}


	public String hex(By supervision){
		waitExplicitly(3);
		String color = getElement(supervision).getCssValue("background-color");		
		String hex = Color.fromString(color).asHex();
		return hex;
	}
}
