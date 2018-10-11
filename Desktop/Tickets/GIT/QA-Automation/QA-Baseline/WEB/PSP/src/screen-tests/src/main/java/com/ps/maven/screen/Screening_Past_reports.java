package com.ps.maven.screen;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ps.maven.utils.BrowserTypes;

public class Screening_Past_reports extends BrowserTypes {
	By screening_history_Created_UTC_title = By.xpath("//ps-screening-detail-history/ps-data-table/header/div[1]/span");
	By screening_history_Result_title = By.xpath("//ps-screening-detail-history/ps-data-table/header/div[2]/span");
	By screening_history_Report_title = By.xpath("//ps-screening-detail-history/ps-data-table/header/div[3]/span");
	By Screening_history_Download_button = By.xpath("//div/ps-screening-detail-history/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[3]/a");
	String downloadPath = "C:/Users/kanchana.krishna/Downloads/";
	By first_ship_name = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[2]/a");
	
	
	
	
	public boolean Validate_screening_history_table() {
		// TODO Auto-generated method stub
		verbose("Going to validate the table headers under SCreening history accodion");
		verbose("The table title is ::" + getElement(screening_history_Created_UTC_title).getText());
		verbose("The table title is ::" + getElement(screening_history_Result_title).getText());
		verbose("The table title is ::" + getElement(screening_history_Report_title).getText());
		
		if((getElement(screening_history_Created_UTC_title).getText().equals("Created (UTC)")) && (getElement(screening_history_Result_title).getText().equals("Result"))
				&&(getElement(screening_history_Report_title).getText().equals("Report"))){
			verbose("The table title displayed correctly");
			return true;
			
		}
		else {
			verbose("The table title NOT displayed correctly");
			return false;
			
		}

	}

	public boolean Screening_history_download_btton_click() {
		// TODO Auto-generated method stub
		verbose("Going to click on first download button under the screening history");
	 getElement(Screening_history_Download_button).click();
	 verbose("The text of the button changes to  :::::" + getElement(Screening_history_Download_button).getText());
	if(getElement(Screening_history_Download_button).getText().equals("Downloading…")) {
		verbose("The download button is clicked correctly");
		return true;
	}
	else {
		verbose("The download button NOT  clicked correctly:::::::::");
		return false;
	}
		
	}

	public boolean check_file_downloaded() {
		waitExplicitly(16);
		String shipname_uppercase = getElement(first_ship_name).getText();
		String shipname = shipname_uppercase.toLowerCase();
		String local = "_history_";

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		verbose("Today's date is : " + (dtf.format(localDate)));
		String fileName = shipname.replaceAll(" ", "-") + local + (dtf.format(localDate))+"";
		verbose("The fileName is " + fileName);
		waitExplicitly(8);
		if(getElement(Screening_history_Download_button).isDisplayed())
		{
		waitExplicitly(2);	
		verbose("Going to check the downloaded file");
	    Assert.assertTrue(isFileDownloaded(downloadPath,fileName));
	    
	    waitExplicitly(2);
		verbose("The file is downloaded");
		return true;
		}
		else {
			verbose("The file is not downloaded");
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
	    	//verbose("The file is :::::" + dir_contents[i].getName());
	    	//verbose("Actual File name is " + dir_contents[i].getName());
	    	if(dir_contents[i].getName().contains(fileName)) {
	    	      flag=true;
	    	     }
	    	    }
	    	    return flag;
	    	}
	
	
	
	
}
