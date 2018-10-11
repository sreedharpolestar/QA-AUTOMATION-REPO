package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Screening_export_list;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class StepDefinition_Screening_export_list extends BrowserTypes {
	Screening_export_list export_list = new Screening_export_list();
	
	
	
	@Then("^click on the Export list button\\.$")
	public void click_on_the_Export_list_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(export_list.export_list());
		verbose("***********************************************************");
	    
	}
	
	@Then("^click on the Export button which also has the number of ships selected next to it$")
	public void click_on_the_Export_button_which_also_has_the_number_of_ships_selected_next_to_it() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(export_list.export_list__selected_ships());
		verbose("***********************************************************");
	}

	
}
