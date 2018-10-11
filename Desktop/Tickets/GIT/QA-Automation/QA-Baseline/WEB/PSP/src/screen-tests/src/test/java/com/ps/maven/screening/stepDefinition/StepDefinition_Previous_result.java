package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Previous_results;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class StepDefinition_Previous_result extends BrowserTypes {
	
	Previous_results previous_results = new Previous_results();
	
	@Then("^check the last updated date of the ship$")
	public void check_the_last_updated_date_of_the_ship() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(previous_results.check_last_updated_before_rescreening());
		verbose("***********************************************************");
	}

	@Then("^hover over the current result of the ship to find the previous result\\.$")
	public void hover_over_the_current_result_of_the_ship_to_find_the_previous_result() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(previous_results.hover_current_result_first_ship());
		verbose("***********************************************************");
	}

	@Then("^validate the previous result$")
	public void validate_the_previous_result() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(previous_results.validate_previous_result());
		verbose("***********************************************************");
	}


}
