package com.ps.maven.screen;

import org.openqa.selenium.By;

import com.ps.maven.utils.BrowserTypes;

public class Common_methods extends BrowserTypes{
	By add_ships_button = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[1]/ps-screening-filters/form/a/div[2]");
	By ship_count = By.xpath("//ps-screening-table/div/div/div[2]/ps-screening-totals/div[1]/span[1]");	
	
	
	By screening_results_page_header = By.xpath("//ps-screening-component/ps-screening-table/div/header/h3");
	
	public int ship_count() {
		String ship_count1 = getElement(ship_count).getText();
		
		//int ship_count_only = Integer.parseInt(ship_count1.substring(0,ship_count1.indexOf(" ")));
		int ship_count_only = Integer.parseInt(ship_count1);
		verbose("Debug Ship count is :: " +  ship_count_only);
	//	verbose("ship_count_only count is :: " +  ship_count_only);
		if(ship_count_only > 49){
			ship_count_only = 49;
			return ship_count_only;
		}else{
			return ship_count_only;
		}

	}
	
}
