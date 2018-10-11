
package com.ps.maven.screen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.ps.maven.screen.*;

import com.ps.maven.utils.BrowserTypes;

public class Screening_export_list extends BrowserTypes{
	
	ScreeningResultsDeclinePage checkbox = new ScreeningResultsDeclinePage();
	Ship_name_click shipclick = new Ship_name_click();
	String downloadPath = "C:/Users/kanchana.krishna/Downloads/";
	
	//"C:/Users/" + System.getProperty("user.name") + "/Downloads/";
	//String home = System.getProperty("user.home");
	//String downloadPath = new File(home+"/Downloads/");
	//private static String downloadPath = "Downloads";
	
	By export_list = By.xpath("//button[contains(.,'Export')]");
	By export_list_after_selecting_ships = By.xpath("//button[contains(.,'Export')]//child::div[2]");
	By row_higlight1 = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/div/input");
	//ps-data-table-row[contains(@class,'ps-font-m all-visible side-padding-m min-height-m ng-star-inserted highlight')]
	public boolean export_list() throws IOException{
		
		waitExplicitly(2);
		String exportlist = getElement(export_list).getText();
		verbose("The export button text is  : " + exportlist);
		Assert.assertEquals(exportlist, "Export list");
		
		if(getElement(export_list).isEnabled())
		{
			verbose("Export List button is enabled so going to click on it");
			getElement(export_list).click();
			waitExplicitly(10);
		String file = "screening-list-";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		verbose("Today's date is : " + (dtf.format(localDate)));
			String fileName = file + (dtf.format(localDate));
			verbose("The file name is " + fileName);
			Assert.assertTrue(isFileDownloaded(downloadPath,fileName));
			verbose("The file is downloaded");
			
			return true;
		}



		
		else {
			verbose("The Export List button is not enabled");
			return false;
		
		}
	}
		public boolean export_list__selected_ships(){
			
			waitExplicitly(2);
			String no_of_ships_next_to_the_export_button = getElement(export_list).getText();
			verbose("The number of ships selected and the number next to the export list button is :  " + no_of_ships_next_to_the_export_button);
			
			String no_of_ships_next_to_the_export_button1 = getElement(export_list).getText();
			verbose("The number of ships selected and the number next to the export list button is :  " + no_of_ships_next_to_the_export_button1);
			
			
			if(getElement(export_list_after_selecting_ships).isEnabled())
			{
				verbose("Export List button is enabled so going to click on it");
				String local = getElement(export_list_after_selecting_ships).getText();
				verbose("The button text is : " + local);
			
				Assert.assertEquals(local, "Export");
				getElement(export_list).click();
				return true;
			}
			
			else {
				verbose("The Export List button is not enabled");
				return false;
			
			}
	
	}

	
		public boolean isFileDownloaded(String downloadPath, String fileName) {
			boolean flag = false;
		    File dir = new File(downloadPath);
		    verbose("the path ::: " + downloadPath);
		    verbose("The file name :::" + fileName);
		    File[] dir_contents = dir.listFiles();
		  	    
		    for (int i = 0; i < dir_contents.length; i++) {
		    	verbose("The length is :::" + dir_contents.length);
		    	//verbose("Actual File name is " + dir_contents[i].getName());
		        if (dir_contents[i].getName().contains(fileName))
		            return flag=true;
		        
		            }
		    

		    return flag;
		}	
	
	
	
}






