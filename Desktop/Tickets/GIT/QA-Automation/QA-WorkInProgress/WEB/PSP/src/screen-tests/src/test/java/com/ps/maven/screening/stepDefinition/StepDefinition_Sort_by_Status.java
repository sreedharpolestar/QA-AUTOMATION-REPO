package com.ps.maven.screening.stepDefinition;

import static org.junit.Assert.assertTrue;

import org.testng.Assert;

import com.ps.maven.screen.Sort_by_status;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class StepDefinition_Sort_by_Status extends BrowserTypes{
	
	Sort_by_status sort = new Sort_by_status();
	
	@Then("^check whether the status column is present$")
	public void check_whether_the_status_column_is_present() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
	    Assert.assertTrue(sort.header_check());
	    verbose("***********************************************************");
	}

	@Then("^sort Status column in ascending order$")
	public void sort_Status_column_in_ascending_order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
	    Assert.assertTrue(sort.ascending_check());
	    verbose("***********************************************************");
	}

	@Then("^click on the status column$")
	public void click_on_the_status_column() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
	    Assert.assertTrue(sort.descending_order());
	    verbose("***********************************************************");
	}

	@Then("^the status column should be sorted in descendng order$")
	public void the_status_column_should_be_sorted_in_descendng_order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
