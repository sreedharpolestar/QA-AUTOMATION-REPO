package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Latest_Screening_Results;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class StepDefinition_Latest_Screening_results extends BrowserTypes {
	Latest_Screening_Results Latestscreening = new Latest_Screening_Results();
	

	@Then("^Validate Port State Control history check$")
	public void validate_Port_State_Control_history_check() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Latestscreening.Port_state_control_history_check());
		verbose("***********************************************************");
	    
	}

	/*@Then("^verify the result$")
	public void verify_the_result() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Latestscreening.Port_state_control_history_check_result());
		verbose("***********************************************************");
	    
	}*/

	@Then("^Validate Ship movement history check$")
	public void validate_Ship_movement_history_check() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Latestscreening.Ship_movement_history_check());
		verbose("***********************************************************");
	    
	}

	@Then("^Validate Country sanctions check$")
	public void validate_Country_sanctions_check() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Latestscreening.Country_sanctions_check());
		verbose("***********************************************************");
	  
	}

	@Then("^Validate Company global sanctions list check$")
	public void validate_Company_global_sanctions_list_check() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Latestscreening.Company_global_sanctions_list_check());
		verbose("***********************************************************");
	  
	}

	@Then("^Validate  Ship global sanctions list check$")
	public void validate_Ship_global_sanctions_list_check() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Latestscreening.Ship_global_sanctions_list_check());
		verbose("***********************************************************");
	    
	}

	@Then("^Validate  Last updated and Date$")
	public void validate_Last_updated_and_Date() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Latestscreening.Last_updated_and_Date());
		verbose("***********************************************************");
	    
	}
	
	


}
