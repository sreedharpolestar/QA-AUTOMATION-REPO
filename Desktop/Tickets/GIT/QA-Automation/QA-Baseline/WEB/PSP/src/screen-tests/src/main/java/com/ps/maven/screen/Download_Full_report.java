package com.ps.maven.screen;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.ps.maven.utils.BrowserTypes;

public class Download_Full_report extends BrowserTypes {
	By Download_button_accordion = By.xpath("//*[@id=\"latestHistory\"]/div[2]/div/ps-screening-detail-latest-history/div/button/span");
	By first_ship_name = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[2]/a");
	String downloadPath = "C:/Users/kanchana.krishna/Downloads/";
	By Company_global_sanctions_Download_button = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[3]/button[2]/span");
	By Latest_Screening_results = By.xpath("//div/div/ps-accordion/div/ps-accordion-item[1]/div[1]/h4/div");
	Screening_checks_modal modal = new Screening_checks_modal();
	
	public boolean validate_Download_button_accordion() {
		getElement(Latest_Screening_results).click();
		waitExplicitly(2);
		String button_title = getElement(Download_button_accordion).getText();
		waitExplicitly(2);
		verbose("debug:" + button_title);
		if(button_title.equals("Download full report")) {
			verbose("Download button is displayed correctly in Latest Screening results accordion");
			return true;
		}
		else {
			verbose("Download button is NOT :::: displayed correctly in Latest Screening results accordion:::::::::::::::::");
			return false;
		}
	}
	
	public boolean click_download_button() {
		waitExplicitly(3);
		getElement(Download_button_accordion).click();
		return true;
	
		
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



	public boolean filename_check() {
		String shipname_uppercase = getElement(first_ship_name).getText();
		String shipname = shipname_uppercase.toLowerCase();
		
	String local = "_latest_";

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
	verbose("Today's date is : " + (dtf.format(localDate)));
	String fileName = shipname.replace(" ", "-") + local + (dtf.format(localDate))+"";
	verbose("The fileName is " + fileName);
	waitExplicitly(8);
	if(getElement(Download_button_accordion).isDisplayed())
	{
	waitExplicitly(2);	
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

	public boolean Ship_global_modal_download_button() {
		waitExplicitly(1);
		getElement(modal.Ship_global_sanctions_modal_download_button).click();
		String button_status = getElement(Download_button_accordion).getText(); 
		verbose("The button title changes to ::::" + button_status );
			if(button_status.equals("Downloading…")){
				verbose("Successfully clicked on the Download button in Ship global sanctions MODAL");
				return true;
			}
			else {
				verbose("NOT successfully clicked on Download button in Ship global sanctions modal");
				return false;
			}
		
		
	}

	public boolean Port_state_control_modal_download_button() {
		waitExplicitly(1);
		getElement(modal.port_state_modal_download_button).click();
		String button_status = getElement(Download_button_accordion).getText(); 
		verbose("The button title changes to ::::" + button_status );
			if(button_status.equals("Downloading…")){
				verbose("Successfully clicked on the Download button in Port state control MODAL");
				return true;
			}
			else {
				verbose("NOT successfully clicked on Download button in Port State control  modal");
				return false;
			}
		
		
	}
	
	public boolean Country_sanctions_modal_download_button() {
		waitExplicitly(1);
		getElement(modal.Country_sanctions_modal_Download_button).click();
		String button_status = getElement(Download_button_accordion).getText(); 
		verbose("The button title changes to ::::" + button_status );
			if(button_status.equals("Downloading…")){
				verbose("Successfully clicked on the Download button in Country sanctions modal");
				return true;
			}
			else {
				verbose("NOT successfully clicked on Download button in Country sanctions  modal");
				return false;
			}
		
		
	}
	
	
	public boolean Company_global_sanctions_modal_download_button() {
		waitExplicitly(2);
		getElement(Company_global_sanctions_Download_button).click();
		String button_status = getElement(Download_button_accordion).getText(); 
		verbose("The button title changes to ::::" + button_status );
			if(button_status.equals("Downloading…")){
				verbose("Successfully clicked on the Download button in Company global sanctions modal");
				return true;
			}
			else {
				verbose("NOT successfully clicked on Download button in Company global sanctions modal");
				return false;
			}
		
		
	}
	

	public boolean Ship_movement_history_modal_download_button() {
		waitExplicitly(1);
		getElement(modal.Ship_movement_modal_download_button).click();
		String button_status = getElement(Download_button_accordion).getText(); 
		verbose("The button title changes to ::::" + button_status );
			if(button_status.equals("Downloading…")){
				verbose("Successfully clicked on the Download button in Ship movement history modal");
				return true;
			}
			else {
				verbose("NOT successfully clicked on Download button in Ship movement history  modal");
				return false;
			}
		
		
	}

}

