package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Screening_Past_reports;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class StepDefinition_Screening_Past_reports extends BrowserTypes {
	Screening_Past_reports PastReports = new Screening_Past_reports();
	
	@Then("^validate the Screening History table in the accordion$")
	public void validate_the_Screening_History_table_in_the_accordion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(PastReports.Validate_screening_history_table());
		verbose("***********************************************************");
	}

	@Then("^click on Download button\\.$")
	public void click_on_Download_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(PastReports.Screening_history_download_btton_click());
		verbose("***********************************************************");
	}

	
	@Then("^check whether the file is downloaded$")
	public void check_whether_the_file_is_downloaded() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(PastReports.check_file_downloaded());
		verbose("***********************************************************");
	}
}
