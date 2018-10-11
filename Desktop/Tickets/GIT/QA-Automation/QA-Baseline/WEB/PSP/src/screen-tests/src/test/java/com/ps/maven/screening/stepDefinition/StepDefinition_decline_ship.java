package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.ScreeningResultsDeclinePage;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition_decline_ship extends BrowserTypes {
	ScreeningResultsDeclinePage screening = new ScreeningResultsDeclinePage();

	@Given("^I select a ship clicking on the checkbox and the decline button should be enabled$")
	public void i_select_a_ship_clicking_on_the_checkbox_and_the_decline_button_should_be_enabled() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.select_a_ship());
		verbose("***********************************************************");
	}

	@Then("^the number next to the decline should be updated to `(\\d+)` next to it$")
	public void the_number_next_to_the_decline_should_be_updated_to_next_to_it(int arg1) throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.decline_number_one());
		verbose("***********************************************************");
	}

	@Then("^click on the Decline button, a modal should be seen with `CANCEL` and `DECLINE` buttons$")
	public void click_on_the_Decline_button_a_modal_should_be_seen_with_CANCEL_and_DECLINE_buttons() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.decline_modal_click_message_one_ship());
		verbose("***********************************************************");
	}

	@When("^I click on `Cancel` the ship should still be selected$")
	public void i_click_on_Cancel_the_ship_should_still_be_selected() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.decline_cancel_button_one_ship());
		verbose("***********************************************************");
	}

	@Then("^I click on `Decline` ship should be deleted and the ship count has to be reduced by one$")
	public void i_click_on_Decline_ship_should_be_deleted_and_the_ship_count_has_to_be_reduced_by_one() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.decline_button());
		verbose("***********************************************************");
	}

	@Given("^I select two ships clicking on the checkbox and the decline button should be enabled$")
	public void i_select_two_ships_clicking_on_the_checkbox_and_the_decline_button_should_be_enabled() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.select_multiple_ships());
		verbose("***********************************************************");
	}

	@Then("^the number next to the decline should be updated to two next to it$")
	public void the_number_next_to_the_decline_should_be_updated_to_two_next_to_it() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.decline_number_two());
		verbose("***********************************************************");
	}

	@Then("^click on the Decline button, a modal should be seen with `CANCEL` and `DECLINE` buttons with heading and message changed$")
	public void click_on_the_Decline_button_a_modal_should_be_seen_with_CANCEL_and_DECLINE_buttons_with_heading_and_message_changed() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.decline_modal_click_message_more_ships());
		verbose("***********************************************************");
	}

	@When("^I click on `Cancel` the ships should still be selected$")
	public void i_click_on_Cancel_the_ships_should_still_be_selected() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.decline_cancel_button_two_ships());
		verbose("***********************************************************");
	}

	@When("^when I click on `Decline` ships should be deleted and the ship count has to be reduced by two$")
	public void when_I_click_on_Decline_ships_should_be_deleted_and_the_ship_count_has_to_be_reduced_by_two() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.decline_button());
		verbose("***********************************************************");
	}

}
