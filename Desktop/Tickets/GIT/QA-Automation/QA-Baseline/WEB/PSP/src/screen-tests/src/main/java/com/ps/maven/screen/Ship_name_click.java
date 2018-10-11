package com.ps.maven.screen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Wait;

import com.ps.maven.utils.BrowserTypes;

public class Ship_name_click extends BrowserTypes {
	
	ScreeningResultsDeclinePage checkbox = new ScreeningResultsDeclinePage();
	By ship_name_xpath = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[2]/a");
	By ship_name_side_panel = By.xpath("//*[contains(@class,'side-drawer__title')]");
	By flag_title_hover = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row/ps-data-table-cell[1]/ps-flag/span");
	
	Highlighter highlight = new Highlighter();
    By year_of_build_title = By.xpath("//*[contains(@class,'side-drawer__title')]//following::td[5]");
	By Year_of_build = By.xpath("//*[contains(@class,'side-drawer__title')]//following::td[6]");
    By age_of_ship = By.xpath("//*[contains(@class,'side-drawer__title')]//following::td[6]//span");
    public static String shipname = null;
  
	public boolean first_ship_click() throws InterruptedException{	
		 waitExplicitly(5);
		Actions action = new Actions(driver);
		
		//WebElement we = getElement(flag_title_hover);
		waitExplicitly(3);
		verbose("Going to click on the first ship flag");
		waitExplicitly(5);
		action.moveToElement(getElement(flag_title_hover)).build().perform();
		waitExplicitly(3);
		String Flag_title = getElement(flag_title_hover).getAttribute("title");
		verbose("The flag title is " + Flag_title); 
		verbose("Highlighting the ship to be clicked on the application");
	    highlight.highLight(getElement(ship_name_xpath), driver);
        waitExplicitly(3);
        verbose("The ship name clicked on is :: " + getElement(ship_name_xpath).getText());
        shipname = getElement(ship_name_xpath).getText();
        verbose("Clicking on the Ship name");
        waitExplicitly(2);
        getElement(ship_name_xpath).click();
        waitExplicitly(3);
        /*verbose (" The name is  " + getElement(ship_name_side_panel).getText());
        waitExplicitly(4);
	    if(getElement(ship_name_side_panel).getText().equals(getElement(ship_name_xpath).getText())) {
	        verbose("Successfully clicked on the ship link");
	        return true;
	    } else {
	        verbose("NOT clicked on the ship link");
	        return false;
	    }*/
	
        return true;
	
		
	}


	public boolean year_of_build() {
		// TODO Auto-generated method stub
		
waitExplicitly(3);
		
		if(getElement(year_of_build_title).getText().equals("Year of build:"))
				{
			verbose("The year of build title is correct");
				}
		else {
			verbose("The year of build title is incorrect:::::::::::");
		}
		waitExplicitly(5);
		verbose("The year of build for the ship as it is : "  +  getElement(Year_of_build).getText());
		waitExplicitly(2);
	String year_of_build_local = getElement(Year_of_build).getText();
	waitExplicitly(2);
	String year_of_build_local1 = year_of_build_local.substring(0,5);
	waitExplicitly(2);
	
		verbose("The year of build for the ship is : "  +  year_of_build_local1);
		
		String local1 = getElement(Year_of_build).getCssValue("color");
		String hex = Color.fromString(local1).asHex();
		//verbose("The year of build for the ship is : "  +  hex );
			if (hex.equals("#333333"))
		{
			verbose("The year of build is of correct color :::::: black");
		}
			else {
				verbose("The year of build is of incorrect color::::::");
		}
			verbose("The age of build for the ship is : "  +  getElement(age_of_ship).getText());
			waitExplicitly(1);
			String local3 = getElement(age_of_ship).getText();
			waitExplicitly(1);
			String local4 = local3.substring(1, 2);
		
			waitExplicitly(1);
	
			int age  = Integer.parseInt(local4);
			//int age = Integer.valueOf(local4);  ==== valueof is same as ParseInt
		//verbose("The debug is: " +  age);
			
			waitExplicitly(2);
			String local2 = getElement(age_of_ship).getCssValue("color");
			String hex1 = Color.fromString(local2).asHex();
			
			verbose("The age of ship is :::::: "  +  age);
			
			if((age >=0 && age <=14 && hex1.equals("#6fb84e")) || (age >=15 && age <=24 && hex1.equals("#e7b03a")) || (age >=25 && hex1.equals("#b12607"))) {
			verbose(" The age of the ship is displayed in correct color");	
			
			}
			else {
				verbose("The age of the ship is not displayed in incorrect color:::::::::::::::::::::::::::::::::");
				
			}
			
			return true;
		
	}

}



// ===================================================================

		

		
		/*waitExplicitly(3);
		
		String first_row_Ship_name_in_the_table = getElement(first_ship_in_the_table).getText();
		verbose("first_row_Ship_name_in_the_table ::: " + first_row_Ship_name_in_the_table);
		String IMO_in_first_ship_row = getElement(IMO_value_first_ship).getText();
		verbose("IMO of the ship ::: " + IMO_in_first_ship_row);
		verbose("Cicking on the first ship");
		waitExplicitly(8);
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		//driver.navigate().refresh();
		//waitExplicitly(6);
		
		verbose("Clicking on the ship name");
		getElement(first_ship_in_the_table).click();
		verbose("clicked on the ship");
		waitExplicitly(8);
	
		
		String attr = getElement(Left_Panel_ship_name).getAttribute("class");
		verbose("The attribute is :" + attr);
		
		if(attr.equals("side-drawer__title"))
		
		{
			verbose("Left panel opened for the ship");
			verbose("Clicking on ship name successful");
			return true;
			
		}
		else{
			verbose("left panel did not open");
			return false;
		}
		
	}
	
		
		
		String IMO_in_left_panel = getElement(IMO_value_left_panel).getText();
		verbose("IMO of the ship in the left panel::"+ IMO_in_left_panel);
		String IMO_in_left_panel = getElement(IMO_value_left_panel).getText();
		verbose("IMO of the ship in the left panel::"+ IMO_in_left_panel);
		waitExplicitly(5);
		var elem = getElement(By.xpath("//ps-data-table/div/div/ps-table-row[2]/ps-table-cell[2]/div/a");
	driver.actions().mouseMove(elem).click();
	
		
	//getElement(Latest_Screening_Results_accordion).click();
			//verbose("clicked on the Latest_Screening_results accordion");
		
		waitExplicitly(4);
		getElement(first_ship_in_the_table).click();
		waitExplicitly(2);
		String Ship_name_in_the_left_panel = getElement(Left_Panel_ship_name).getText();
		verbose("Ship_name_in_the_left_panel ::: " + Ship_name_in_the_left_panel);
		String IMO_in_left_panel = getElement(IMO_value_left_panel).getText();
		String IMO_in_first_ship_row = getElement(IMO_value_first_ship).getText();
		if(IMO_in_first_ship_row == IMO_in_left_panel && first_row_Ship_name_in_the_table == Ship_name_in_the_left_panel)
		{
			verbose("Clicking on ship name is correct and successful");
			return true;
		}
		else
		{
			verbose("Clicking on ship name not successful");
			return false;
		}
		
		
*/




	



