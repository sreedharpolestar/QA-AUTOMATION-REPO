package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Screening_Rescreen;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition_Screening_Rescreen extends BrowserTypes{
	Screening_Rescreen rescreen = new Screening_Rescreen();
	
	
	@Given("^I select a ship clicking on the checkbox and the `Rescreen` button should be enabled$")
	public void i_select_a_ship_clicking_on_the_checkbox_and_the_Rescreen_button_should_be_enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(rescreen.select_a_ship());
		verbose("***********************************************************");
	}

	
	
	@Then("^number next to the Rescreen should be updated to `(\\d+)` next to it$")
	public void number_next_to_the_Rescreen_should_be_updated_to_next_to_it(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(rescreen.number_check());
		verbose("***********************************************************");
	}

	@Then("^click on the `Rescreen` button, a modal should be seen with `CANCEL` and `Rescreen` buttons$")
	public void click_on_the_Rescreen_button_a_modal_should_be_seen_with_CANCEL_and_Rescreen_buttons() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(rescreen.rescreen_click());
		verbose("***********************************************************");
	}

	@When("^I click on `Rescreen` button$")
	public void i_click_on_Rescreen_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(rescreen.rescreen_modal_click());
		verbose("***********************************************************"); 
	}
	@Then("^Validate the pop up for header and message$")
	public void validate_the_pop_up_for_header_and_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(rescreen.validate_pop_up_1_ship());
		verbose("***********************************************************"); 
	}

	@Then("^the ship current result should be in pending status$")
	public void the_ship_current_result_should_be_in_pending_status() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(rescreen.Screening_1_ship_check());
		verbose("***********************************************************");   
	 
	}

	/*@Then("^the number next in the modal should be total number of shipsin the screening table\\.$")
	public void the_number_next_in_the_modal_should_be_total_number_of_shipsin_the_screening_table() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(rescreen.number_check_table());
		verbose("***********************************************************");   
	}*/
	@When("^I click on `Cancel` on the rescreen the ship should still be selected$")
	public void i_click_on_Cancel_on_the_rescreen_the_ship_should_still_be_selected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(rescreen.rescreen_modal_cancel_click());
		verbose("***********************************************************");   
	}
	@Then("^validate the pop up$")
	public void validate_the_pop_up() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(rescreen.validate_popup_without_ship_selection());
		verbose("***********************************************************"); 
	}

	@Then("^click cancel in the pop up$")
	public void click_cancel_in_the_pop_up() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(rescreen.click_cancel());
		verbose("***********************************************************"); 
		
	}
	@Given("^I select a 2 ships by clicking on the checkbox and the `Rescreen` button should be enabled$")
	public void i_select_a_ships_by_clicking_on_the_checkbox_and_the_Rescreen_button_should_be_enabled(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	}


