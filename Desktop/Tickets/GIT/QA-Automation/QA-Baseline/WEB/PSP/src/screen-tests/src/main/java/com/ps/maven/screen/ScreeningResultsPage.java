

package com.ps.maven.screen;



import org.openqa.selenium.By;


import com.ps.maven.utils.BrowserTypes;

public class ScreeningResultsPage extends BrowserTypes {
	
	By notifications_link = By.xpath("//*[@id=\"application\"]/div[2]/div[2]/div[1]/div[1]/div/a[4]/span");
	By screening_link = By.xpath("//psp-app/psp-core/div/secondary-nav/ul/li[3]/a");
	By screening_page_title = By.xpath("//psp-app/psp-core/div/ps-screening-component/ps-screening-table/div/header/h3");
	By search_field = By.xpath("//ps-screening-filters/ps-searchbox/div/input");
	
	Common_methods ship_count = new Common_methods();
		
	public void notifications_click(){
		getDriver().manage().deleteAllCookies();
		waitExplicitly(2);
		waitExplicitly(1);
		getElement(notifications_link).click();
		waitExplicitly(2);
	}

	public boolean screening_link(){
		waitExplicitly(6);
		verbose("Going to click on Screening Menu");
		getElement(screening_link).click();
		waitExplicitly(4);

		if(getElement(screening_page_title).getText().equals("Screening results")){
			verbose("*****Successfully landed in screening results page*****");
			return true;
		} else {
			verbose("*****Couldn't land in screening results page*****");
			return false;
		}
	}

	public boolean search_three_char(){

		getDriver().manage().deleteAllCookies();
		waitExplicitly(2);
		getDriver().navigate().refresh();
		waitExplicitly(1);
		
		waitExplicitly(2);
		getElement(search_field).sendKeys(getProps().getProperty("search_ship_txt"));

		waitExplicitly(2);
		String search_ship_string = getElement(search_field).getAttribute("value");
		verbose("The search_ship_string ::: " + search_ship_string);

		waitExplicitly(2); 
		if(search_ship_string.equals(getProps().getProperty("search_ship_txt"))){
			verbose("Search string is entered successfully");
			return true;
		}else{
			verbose("Search string is NOT entered successfully");
			return false;
		}

	}
	
	

	public boolean updated_screening_results_table_with_string_in_sequence(){
		int internal_count1 = 0;
		By first_singleelement = By.xpath("//ps-data-table/div/div/ps-table-row/ps-table-cell[2]/div/a");
		
		waitExplicitly(2);
		getElement(search_field).clear();
		getElement(search_field).sendKeys(getProps().getProperty("search_ship_txt"));
		waitExplicitly(3);
		
		if(ship_count.ship_count() != 1) {
			verbose("Inside the if loop when the ship count is NOT equal to 1");
			for(int i=1; i<=ship_count.ship_count(); i++){
				waitExplicitly(1);
				//html/body/psp-app/psp-core/div/ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[2]/a
				if(getElement(By.xpath("//ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[2]/a")).getText().contains(getProps().getProperty("search_ship_txt"))){
					waitExplicitly(1);
					verbose("Search for ship_element is working fine");
					internal_count1++;
				}else{
					verbose("Search for ship element is NOT working correctly");
				}
			}
		}else if(ship_count.ship_count() == 1){
			verbose("Inside the if loop when the ship count is equal to 1");
			verbose("The ship returned is : " + getElement(first_singleelement).getText());
			if(getElement(first_singleelement).getText().contains(getProps().getProperty("search_ship_txt"))){
				waitExplicitly(1);
				verbose("Search for ship_element is working fine");
				internal_count1++;
			}else{
				verbose("Search for ship element is NOT working correctly");
			}
		}else {
			verbose("No results found");
		}

		verbose("The internal count is : " + internal_count1);
		if(internal_count1 == ship_count.ship_count()){
			verbose("*****Ship name search is working correctly*****");
			return true;
		}else{
			verbose("*****Ship name search is NOT working correctly*****");
			return false;
		}


	}

	public boolean search_three_numbers(){
		getDriver().navigate().refresh();

		waitExplicitly(3);

		getElement(search_field).clear();
		waitExplicitly(2);
		getElement(search_field).sendKeys(getProps().getProperty("search_IMO"));

		waitExplicitly(2);
		String search_IMO = getElement(search_field).getAttribute("value");
		verbose("The search_IMO ::: " + search_IMO);

		if(search_IMO.equals(getProps().getProperty("search_IMO"))){
			verbose("Search number is entered successfully");
			return true;
		}else{
			verbose("Search number is NOT entered successfully");
			return false;
		}				
	}

	public boolean updated_screening_results_table_with_number_in_sequence(){
		int internal_count = 0;
		By first_singleelement = By.xpath("//ps-data-table/div/div/ps-table-row[1]/ps-table-cell[3]/div");
		
		//getElement(search_field).sendKeys(getProps().getProperty("search_IMO"));
		waitExplicitly(2);

		if(ship_count.ship_count() != 1) {
			for(int i=1; i<=ship_count.ship_count(); i++){
				
				if(getElement(By.xpath("//ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[3]")).getText().contains(getProps().getProperty("search_IMO"))){
					verbose("Search for ship_element is working fine");
					internal_count++;
				}else{
					verbose("Search for ship element is NOT working correctly");
				}
			}
		}else if(ship_count.ship_count() == 1) {
			if(getElement(first_singleelement).getText().contains(getProps().getProperty("search_IMO"))) {
				verbose("Search for ship_element is working fine");
				internal_count++;
			}else{
				verbose("Search for ship element is NOT working correctly");
			}
		}else {
			verbose("No results found");

		}

		if(internal_count == ship_count.ship_count()){
			verbose("Ship IMO number search is working correctly");
			return true;
		}else{
			verbose("Ship IMO number is NOT working correctly");
			return false;
		}
	}

	public boolean search_cross_mark(){
		By search_field_cross_mark = By.xpath("//ps-screening-filters/ps-searchbox/div/span[2]/i");
		
		String total_ship_count = getElement(ship_count.ship_count).getText();		
		int ship_count_only = Integer.parseInt(total_ship_count);
		verbose("Ship count is :: " +  ship_count_only);

		waitExplicitly(2);
		verbose("Clicking on the cross mark");

		getElement(search_field_cross_mark).click();

		waitExplicitly(2);

		verbose("Ship count is from ship_count():: " + ship_count.ship_count());
		if(getElement(search_field).getAttribute("value").equals("")){
			verbose("Search field is cleared");
			return true;
		}else{
			verbose("Search is  NOT cleared");
			return false;
		}
	}

	
	
}
