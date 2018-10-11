package com.ps.maven.screening.stepDefinition;

import org.testng.Assert;

import com.ps.maven.screen.AddShips_ByShipPage;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition_AddShips_ByShip extends BrowserTypes {
	AddShips_ByShipPage by_ship = new AddShips_ByShipPage();

	@Given("^I click on search field and enter the text$")
	public void i_click_on_search_field_and_enter_the_text() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_ship.search_field_click());
		verbose("***********************************************************");
	}

	@Then("^I should see the search results updated and I click on the first search result$")
	public void i_should_see_the_search_results_updated_and_I_click_on_the_first_search_result() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_ship.search_results_and_select());
		verbose("***********************************************************");
	}

	@Then("^Selected ship should be updated successfully and the number next to screen button is updated$")
	public void selected_ship_should_be_updated_successfully_and_the_number_next_to_screen_button_is_updated() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_ship.click_and_select_ship());
		verbose("***********************************************************");
	}

	@Given("^I select mutiple ships from the search results$")
	public void i_select_mutiple_ships_from_the_search_results() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_ship.selecting_multiple_ships());
		verbose("***********************************************************");
	}

	@Then("^Selected ship should be updated successfully and the number next to screen button is updated to the ship num selected$")
	public void selected_ship_should_be_updated_successfully_and_the_number_next_to_screen_button_is_updated_to_the_ship_num_selected() throws Throwable {
		verbose("***********************************************************");
		//Covered in the above step
		verbose("***********************************************************");
	}

	@Given("^I click on the `X` mark next to the ship name then ship should be deselected$")
	public void i_click_on_the_X_mark_next_to_the_ship_name_then_ship_should_be_deselected() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_ship.clicking_on_cross_ship_type());
		verbose("***********************************************************");
	}

	@Then("^Screen button should be disabled and the count next should disappear$")
	public void screen_button_should_be_disabled_and_the_count_next_should_disappear() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_ship.screen_button_disabled());
		verbose("***********************************************************");
	}
}
