package com.ps.maven.screen;



import com.opencsv.CSVReader;
import com.ps.maven.utils.BrowserTypes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;

public class AddShips_ByspreadsheetPage extends BrowserTypes{

	By spreadsheet_tab = By.xpath("//ps-screening-component/ps-screening-add/ps-tab-container/header/a[3]");
	By search_field_in_screening_table_page = By.xpath("//span[contains(@class,'input-group-addon')]//following::input");
    String imo_from_spreadsheet;
    By screen_button = By.xpath("//button[contains(@class,'btn btn-primary btn--divided pull-right')]");
    By first_row_IMO_from_table = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row/ps-data-table-cell[3]");
	public boolean spreadsheet_click() {
		By spreadsheet_header = By.xpath("//ps-screening-add/ps-tab-container/div/div/ps-tab[3]/div/ps-screening-add-by-file/div/div/form/label");
		
		getElement(spreadsheet_tab).click();

		waitExplicitly(1);

		if(getElement(spreadsheet_header).getText().equals("Browse for CSV file")) {
			verbose("Landed in By spreadsheet page successfully");
			return true;
		}else {
			verbose("NOT Landed in By spreadsheet page successfully");
			return false;
		}

	}

	public boolean browse_button_click(String link,String file_name){
		By browse_button_click = By.xpath("//ps-tab-container/div/div/ps-tab[3]/div/ps-screening-add-by-file/div/div/form/ps-file-upload/input");
		By file_selected = By.xpath("//ps-screening-component/ps-screening-add/ps-tab-container/div/div/ps-tab[3]/div/ps-screening-add-by-file/div/div/form/ps-file-upload/div[2]/p");
		
		waitExplicitly(2);

		verbose("Clicking on the browse button" + link);
		getElement(browse_button_click).sendKeys(link);
		waitExplicitly(3);	
		if(getElement(file_selected).getText().equals(file_name)){
			verbose("File is selected");
			return true;
		}else{
			verbose("File is NOT selected");
			return false;
		}
	}
	
	public boolean browse_invalid() {
		By validation_message = By.xpath("//ps-screening-component/ps-screening-add/ps-tab-container/div/div/ps-tab[3]/div/ps-screening-add-by-file/div/div/ps-validation-messages/div/div/p");

		int count = 0;
		String invalid_link = System.getProperty("user.dir") + "\\src\\main\\resources\\FileUploadData\\IMO_number_2.xls";
		if(browse_button_click(invalid_link,getProps().getProperty("file_invalid"))) {
			waitExplicitly(1);
			if(getElement(validation_message).getText().equals("Invalid file type. Please upload .csv file only.")) {
			verbose("InValid file is added successfully and a validation message is seen");
			count++;
			}else {
				verbose("InValid file is NOT added successfully and NO validation message is seen");
			}
			count++;
		}else {
			verbose("InValid file is NOT added successfully");			
		}
		
		if(count == 2) {
			verbose("Uploading of invalid file and getting the validation file is working as expected.");
			return true;
		}else {
			verbose("Uploading of invalid file and getting the validation file is NOT working as expected.");
			return false;
		}
	}
	
	public boolean browse_valid() throws Exception {
		String valid_link = System.getProperty("user.dir") + "\\src\\main\\resources\\FileUploadData\\test_IMO.csv";
		if(browse_button_click(valid_link,getProps().getProperty("file_valid"))) {
			 
			verbose("Valid file is added successfully");
			//IMO reading from the CSV file 
			IMO_read_file();
			verbose("IMO to search in the table " + imo_from_spreadsheet);
			waitExplicitly(3);
		
			
			return true;
		}else {
			verbose("valid file is NOT added successfully");
			return false;
		}
	}
	
	private String IMO_read_file() throws Exception {
		// TODO Auto-generated method stub
		 CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\FileUploadData\\test_IMO.csv"));
		 
		 // this will load content into list
		  List<String[]> li=reader.readAll();
		  System.out.println("Total rows which we have is "+li.size());
		            
		 // create Iterator reference
		  Iterator<String[]>i1= li.iterator();
		    
		 // Iterate all values 
		 while(i1.hasNext()){
		     
		 String[] str=i1.next();
		  
		 
		 for(int i=0;i<str.length;i++)
		{
		 
		   System.out.print(" IMO "+str[i]);
		 
		}
		   System.out.println("   ");
		   imo_from_spreadsheet =  str[0];   
			 System.out.println("IMO   " + imo_from_spreadsheet);  
		  
		}
	
		return imo_from_spreadsheet;
		 
	 }
    
 

	public boolean screen_button_not_enabled() {
		By screen_button = By.xpath("//psp-core/div/ps-screening-component/ps-screening-add/footer/button/div");
		waitExplicitly(5);
		verbose("Screen button disabled is :: " + getElement(screen_button).isEnabled());
		if(getElement(screen_button).isEnabled()) {
			verbose("The screen button is not enabled when non-csv file is added");
			return true;
		}else {
			verbose("The screen button is enabled when non-csv file is added");
			return false;
		}
	}
	
	private Object expect(String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean screen_button_enabled() {
		By screen_button = By.xpath("//psp-core/div/ps-screening-component/ps-screening-add/footer/button/div");
		verbose("Screen button enabled is :: " +getElement(screen_button).isEnabled());
		if(getElement(screen_button).isEnabled()) {
			verbose("The screen button is enabled when csv file is added");
			getElement(screen_button).click();
		    waitExplicitly(6);
			verbose("searching for the IMO");
			imo_search_table();
			return true;
		}else {
			verbose("The screen button is enabled when non-csv file is added");
			return false;
		}
	}
	
	
	public boolean imo_search_table() {
		getElement(search_field_in_screening_table_page).clear();
		getElement(search_field_in_screening_table_page).click();
		getElement(search_field_in_screening_table_page).sendKeys(imo_from_spreadsheet);
		waitExplicitly(2);
		String search_IMO = getElement(search_field_in_screening_table_page).getAttribute("value");
		verbose("The search_IMO ::: " + search_IMO);
		waitExplicitly(2);
		String IMO_from_table_after_search =  getElement(first_row_IMO_from_table).getText();
		verbose("The IMO after search   " + IMO_from_table_after_search);
		if(IMO_from_table_after_search.equals(imo_from_spreadsheet))
		{
			verbose("Loading of IMO and search is working fine");
			return true;
		}
		else {
			verbose("Loading of IMO and search NOT working fine");	
		return false;
		}
	}
	
}

