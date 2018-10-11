package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Ship_name_click;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class StepDefinition_Ship_name_click extends BrowserTypes {
	Ship_name_click shipname = new Ship_name_click();
	@Then("^click on the ship name in the first row\\.$")
	public void click_on_the_ship_name_in_the_first_row() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
		verbose("***********************************************************");
		Assert.assertTrue(shipname.first_ship_click());
		verbose("***********************************************************");
	 
	}
	@Then("^validate the year of build for the ship\\.$")
	public void vlaidate_the_year_of_build_for_the_ship() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		verbose("***********************************************************");
		Assert.assertTrue(shipname.year_of_build());
		verbose("***********************************************************");
	    
	}


	
	}
