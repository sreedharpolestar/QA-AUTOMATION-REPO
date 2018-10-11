package com.ps.maven.screen;

import org.openqa.selenium.By;

import com.ps.maven.utils.BrowserTypes;

public class BE_testcases extends BrowserTypes {
	
	//By ship_name = By.xpath("//ps-data-table//ps-table-row//a[text()='ADMARINE I']");
		By ship_name = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-table-row/ps-table-cell[2]/div/a");
		By search = By.xpath("//ps-screening-table/div/div/div[1]/ps-screening-filters/ps-searchbox/div/input");
		By checkbox = By.xpath("//ps-screening-component/ps-table/div/div/div[2]/ps-data-table/div/div/ps-table-row/div/input");
		By ship_name_side_panel = By.xpath("//ps-screening-component/ps-screening-table/ps-screening-detail/side-drawer/div/ps-side-drawer-header/div/h4");
	    Highlighter highlighter = new Highlighter();
	  
	public boolean specific_shipname_click(){
	
		getElement(search).click();
		verbose("The Ship to be searched  is : " + getProps().getProperty("Port_state_control"));
		getElement(search).sendKeys(getProps().getProperty("Port_state_control"));	
		
	
	//getElement(search).sendKeys("ADMARINE I");
	waitExplicitly(5);
	
	highlighter.highLight(getElement(ship_name), driver);
	
	getElement(ship_name).click();
	 waitExplicitly(5);
	    if(getElement(ship_name_side_panel).getText().equals(getElement(ship_name).getText())) {
	        verbose("Successfully clicked on the ship link");
	        return true;
	    } else {
	        verbose("NOT clicked on the ship link");
	        return false;
	    }

}

	
}
