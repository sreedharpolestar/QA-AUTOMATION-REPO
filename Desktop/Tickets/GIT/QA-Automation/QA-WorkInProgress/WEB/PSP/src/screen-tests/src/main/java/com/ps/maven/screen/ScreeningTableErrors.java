package com.ps.maven.screen;

import org.openqa.selenium.By;

import com.ps.maven.utils.BrowserTypes;

public class ScreeningTableErrors extends BrowserTypes{

	AddShips_BylistPage list = new AddShips_BylistPage();
	By screening_error_element = By.xpath("//ps-screening-component/ps-screening-table/div/header/span/ps-screening-errors/ps-dropdown-input/div/button/div/div[2]");
	By imo_text = By.xpath("//*[@id=\"errors\"]/div/ps-data-table/header/div[1]");
	By date_text = By.xpath("//*[@id=\"errors\"]/div/ps-data-table/header/div[2]");
	By Clear_all_text = By.xpath("//*[@id=\"errors\"]/div/ps-data-table/header/div[3]");
	
	public boolean existing_screening_error() {
		verbose("Validating existing screening error element");
		waitExplicitly(1);
		if(screening_error_element()) {
			verbose("Clicking on screening error element");
			if(screening_error_element_validation()) {
				waitExplicitly(1);
				if(screening_error_clear_all()) {
					
				}
			}
		}else {
			verbose("There is no screening element");
			
		}
		return true;
		
	}

	public boolean screening_error_element() {

		logger.info("Checking whether the screening error element is seen when the invalid IMO is entered");
		driver.navigate().refresh();
waitExplicitly(7);
		if(getElement(screening_error_element).isDisplayed()) {
			logger.info("Element is visible");
			return true;			
		}else {
			logger.info("Element is NOT visible");
			return false;
		}
	}	

	public boolean screening_error_element_validation() {

		By screening_error_dropdown_click = By.xpath("//ps-screening-table/div/header/span/ps-screening-errors/ps-dropdown-input/div/button/div/div[3]/span");
				
		waitExplicitly(2);
		verbose("Clicking on the screening_error dropdown");
		getElement(screening_error_dropdown_click).click();

		waitExplicitly(2);

		if(getElement(imo_text).getText().equals("IMO/spreadsheet") && getElement(date_text).getText().equals("Date added (UTC)") && getElement(Clear_all_text).getText().equals("Clear all")) {
			verbose("All the texts are clearly visible");
			return true;
		}else {
			verbose("All the texts are NOT visible");
			return false;
		}
		

	}

	public boolean screening_error_clear_all() {

		verbose("Clicking on the clear all to clear the screening error element");
		waitExplicitly(2);

		getElement(Clear_all_text).click();
		waitExplicitly(2);

		if(!getElement(screening_error_element).isDisplayed()) {
			verbose("Clear all is working successfully");
			return true;
		}else {
			verbose("Clear all is NOT working successfully");
			return false;
		}

	}

	public boolean screening_error_clear_individually() {

		By clear_individual = By.xpath("//*[@id=\"errors\"]/div/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[3]/button/i");
		String error_text = getElement(screening_error_element).getText();
		verbose("The error text is ::: " + error_text);
		
		String[] error_text_number = error_text.split("\\s+");
		verbose("The error count number is ::" + error_text_number[0]);
		int result = Integer.parseInt(error_text_number[0]);
		verbose("The debug: Integer: " + result );

		verbose("Clicking on the individual cross mark");

		getElement(clear_individual).click();
		String result_reduced = result-1 + " " + "screening errors";
		verbose("result_reduced :::: " + result_reduced);
		waitExplicitly(2);
		if(!error_text.equals(result_reduced)) {
			verbose("Successfully clicked on the \"X\" mark");
			return true;	
		}else {
			verbose("NOT clicked on the \"X\" mark");
			return false;
		}
	}

}
