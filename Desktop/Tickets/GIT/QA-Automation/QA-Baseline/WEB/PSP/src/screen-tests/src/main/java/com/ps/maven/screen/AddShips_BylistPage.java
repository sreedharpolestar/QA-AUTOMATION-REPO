package com.ps.maven.screen;

import org.openqa.selenium.By;

import com.ps.maven.utils.BrowserTypes;

public class AddShips_BylistPage extends BrowserTypes{
	
	By add_by_list = By.xpath("//ps-screening-component/ps-screening-add/ps-tab-container/header/a[2]");
	By screen_button = By.xpath("//ps-screening-component/ps-screening-add/footer/button/div[2]");
	int invalid_imo_count = 0;
	By Refresh_button = By.xpath("//ps-screening-table/div/header/span/ps-screening-pending/button/div[1]/span");
	By ships_pending_button = By.xpath("//ps-screening-table/div/header/span/ps-screening-pending/button/div[2]/span");
	
	AddShips_landing_page landing = new AddShips_landing_page();
	ScreeningResultsPage header = new ScreeningResultsPage();
	Common_methods screen  = new Common_methods();
	
	public boolean add_by_list_tab_click() {

		By add_by_list_heading = By.xpath("//psp-core/div/ps-screening-component/ps-screening-add/ps-tab-container/div/div/ps-tab[2]/div/ps-screening-add-by-list/div/div/form/label");
		waitExplicitly(2);

		getElement(add_by_list).click();
verbose("debug");
		if(getElement(add_by_list_heading).getText().equals("Type or paste list of IMO numbers separated by commas")) {
			verbose("Successfully clicked on Add By list link");
			return true;			
		}else {
			verbose("Clicking on Add By list link Failed");
			return false;
		}

	}

	public boolean text_field() {
		By text_field_click = By.xpath("//ps-screening-add/ps-tab-container/div/div/ps-tab[2]/div/ps-screening-add-by-list/div/div/form/textarea");

		waitExplicitly(4);

		getElement(text_field_click).click();
		waitExplicitly(1);

		verbose("The imo_list is : " + getProps().getProperty("imo_list"));
		getElement(text_field_click).sendKeys(getProps().getProperty("imo_list"));
		waitExplicitly(3);

		if(getElement(text_field_click).getAttribute("value").equals(getProps().getProperty("imo_list"))) {
			verbose("IMO list is pasted successfully");
			return true;
		}else {
			verbose("IMO list is NOT pasted successfully");
			return false;
		}

	}
	
	public boolean text_field_invalid_imo() {
		By text_field_click = By.cssSelector("textarea.form-control");

		waitExplicitly(4);

		getElement(text_field_click).click();
		waitExplicitly(1);
		
		String[] count = getProps().getProperty("invalid_imo_list").split(",");
		int invalid_imo_count = count.length;

		verbose("invalid_imo_count ::: " + invalid_imo_count);
		verbose("The imo_list is : " + getProps().getProperty("invalid_imo_list"));
		getElement(text_field_click).sendKeys(getProps().getProperty("invalid_imo_list"));
		waitExplicitly(3);

		if(getElement(text_field_click).getAttribute("value").equals(getProps().getProperty("invalid_imo_list"))) {
			verbose("IMO list is pasted successfully");
			return true;
		}else {
			verbose("IMO list is NOT pasted successfully");
			return false;
		}
		
	}

	public boolean Screen_button() {
	
		By imo_count = By.xpath("//psp-core/div/ps-screening-component/ps-screening-add/footer/button/div[1]");
		int count = 0;
		
		String  imoString = getProps().getProperty("imo_list");
		int itemCount = imoString.split(",").length;
		verbose("Count from property file is ::: " + itemCount);
		String imo_property_count = Integer.toString(itemCount);

		verbose("The count next to screen button is :: " + getElement(imo_count).getText());

		waitExplicitly(3);
		if(getElement(imo_count).getText().equals(imo_property_count)) {
			verbose("The count next to screen button is updated correctly");
			count++;
		}else {
			verbose("The count next to screen button is NOT updated correctly");
		}

		if(getElement(screen_button).isEnabled()) {
			verbose("The screen button is enabled");
			count++;
		}else {
			verbose("The screen button is  not enabled");
		}

		if(count == 2) {
			verbose("Screen button on the By list page is updated as per the requirement");
			return true;
		}else {
			verbose("Screen button on the By list page is NOT updated as per the requirement");
			return false;
		}
	}
	
	public boolean screen_button_click() {
		
		getElement(screen_button).click();
		
		waitExplicitly(2);
		
		if(getElement(screen.screening_results_page_header).getText().equals("Screening results")) {
			verbose("Screen button was successfully pressed and is landed in Screening results page");
			return true;
		}else {
			verbose("Screen button was NOT successfully pressed and is NOT landed in Screening results page");
			return false;
		}	
		
	}
	
	public boolean cancel_button() {
		if(landing.cancel_button() && header.screening_link()) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean Refresh_button_check() {
		
		boolean local = getElement(Refresh_button).isDisplayed();
		verbose("The Refresh button is displayed " + local);
	verbose("The button text is " + getElement(Refresh_button).getText());
	if(getElement(Refresh_button).getText().equals("Refresh"))
	{
		verbose("The Refresh button is displayed");
		return true;
	}
	else {
		verbose("The Refresh button is NOT  displayed");
		return false;
	}

	}
	public boolean Refresh_button_pending_ships() {
		
		boolean local = getElement(ships_pending_button).isDisplayed();
		verbose("The Refresh button displays now as Ships Pending  " + local);
	verbose("The button text is " + getElement(ships_pending_button).getText());
	if(getElement(ships_pending_button).getText().equals("Ships pending"))
	{
		verbose("The Ships are going to be added to the screening table");
		return true;
	}
	else
		verbose("The Ships not yet to the screening table page.");
		return false;
	
	}

}

