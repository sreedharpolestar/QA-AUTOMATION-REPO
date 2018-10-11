package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Validate_Accordion;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class StepDefinition_Shipname_accordion extends BrowserTypes {
	Validate_Accordion Validateaccordion = new Validate_Accordion();
	
	@Then("^validate all the Latest Screening Results accordion$")
	public void validate_all_the_Latest_Screening_Results_accordion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Validateaccordion.Validate_accordion_Latest_screening_results());
		verbose("***********************************************************");
	    
	}

	@Then("^validate all the Screening History accordion$")
	public void validate_all_the_Screening_History_accordion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Validateaccordion.Validate_accordion_Screening_history());
		verbose("***********************************************************");
	   
	}

	@Then("^validate all the Ship Information accordion$")
	public void validate_all_the_Ship_Information_accordion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Validateaccordion.Validate_accordion_Ship_information());
		verbose("***********************************************************");
	  
	}

	
	
	
	
}
