package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Screening_checks_modal;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class StepDefinition_Screening_checks_modal extends BrowserTypes {
	
	Screening_checks_modal chk_modal = new Screening_checks_modal();
	
	
	@Then("^click on the Ship global sanctions list check link$")
	public void click_on_the_Ship_global_sanctions_list_check_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(chk_modal.Ship_global_sanctions_list_link_click());
		verbose("***********************************************************");
	  
	}

	@Then("^validate the Ship global sanctions list check modal$")
	public void validate_the_Ship_global_sanctions_list_check_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(chk_modal.Ship_global_sanctions_list_modal());
		verbose("***********************************************************");
	   
	}
	
	@Then("^click on the Port State Control history check link$")
	public void click_on_the_Port_State_Control_history_check_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(chk_modal.Port_state_link_click());
		verbose("***********************************************************");
	    
	}

	@Then("^validate the modal$")
	public void validate_the_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(chk_modal.port_state_modal());
		verbose("***********************************************************");
	    
	}
	@Then("^click on the Country sanctions check link$")
	public void click_on_the_Country_sanctions_check_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(chk_modal.country_sanctions_check_link_click());
		verbose("***********************************************************");
	}

	@Then("^validate the Country sanctions check link modal$")
	public void validate_the_Country_sanctions_check_link_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(chk_modal.country_sanctions_check_modal());
		verbose("***********************************************************");
	}
	
	@Then("^click on the Ship movement history check link$")
	public void click_on_the_Ship_movement_history_check_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(chk_modal.ship_movement_history_click());
		verbose("***********************************************************");
	}

	@Then("^validate the Ship movement history check modal$")
	public void validate_the_Ship_movement_history_check_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(chk_modal.ship_movement_history_check_modal());
		verbose("***********************************************************");
	}
	@Then("^click on the Company global sanctions list check link$")
	public void click_on_the_Company_global_sanctions_list_check_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(chk_modal.company_global_sanctions_check_click());
		verbose("***********************************************************");
	}
	

	@Then("^validate the Company global sanctions list check  modal$")
	public void validate_the_Company_global_sanctions_list_check_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(chk_modal.company_global_sanctions_modal());
		verbose("***********************************************************");
	}
	

}
