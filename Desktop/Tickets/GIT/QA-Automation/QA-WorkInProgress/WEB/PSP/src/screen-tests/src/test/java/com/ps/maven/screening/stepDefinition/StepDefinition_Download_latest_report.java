package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Download_Full_report;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;



public class StepDefinition_Download_latest_report extends BrowserTypes {
	
	Download_Full_report download = new Download_Full_report();
	
	
	
	@Then("^Validate the 'Download full report' button in the accordion$")
	public void validate_the_Download_full_report_button_in_the_accordion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(download.validate_Download_button_accordion());
		verbose("***********************************************************");
	}


	@Then("^click on the button$")
	public void click_on_the_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(download.click_download_button());
		verbose("***********************************************************");
		
	}

	@Then("^validate the file in the system$")
	public void validate_the_file_in_the_system() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(download.filename_check());
		verbose("***********************************************************");
		
	}
	
	
	@Then("^click on the download button in the Ship global modal$")
	public void click_on_the_download_button_in_the_Ship_global_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(download.Ship_global_modal_download_button());
		verbose("***********************************************************");
	}

	@Then("^click on the download button in the Port state modal$")
	public void click_on_the_download_button_in_the_Port_state_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(download.Port_state_control_modal_download_button());
		verbose("***********************************************************");
	}
	
	@Then("^click on the download button in the Country sanctions modal$")
	public void click_on_the_download_button_in_the_Country_sanctions_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(download.Country_sanctions_modal_download_button());
		verbose("***********************************************************");
	}
	@Then("^click on the download button in the Ship movement history modal$")
	public void click_on_the_download_button_in_the_Ship_movement_history_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(download.Ship_movement_history_modal_download_button());
		verbose("***********************************************************");
	}
	
	
	@Then("^click on the download button in the Company global sanctions list modal$")
	public void click_on_the_download_button_in_the_Company_global_sanctions_list_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(download.Company_global_sanctions_modal_download_button());
		verbose("***********************************************************");
	}
}
