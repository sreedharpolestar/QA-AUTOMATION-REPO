package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Flag_filter_ScreeningResultsPage;
import com.ps.maven.screen.Select_loaded_ships;
import com.ps.maven.screen.ShipTypes_filter_ScreeningResultsPage;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition_Select_Loaded_ships extends BrowserTypes{

	Select_loaded_ships screening = new Select_loaded_ships();
	Flag_filter_ScreeningResultsPage flag_filter = new Flag_filter_ScreeningResultsPage();
	ShipTypes_filter_ScreeningResultsPage ship_type_filter = new ShipTypes_filter_ScreeningResultsPage();
	
	@Given("^I click on the check at the top should select all the ships which are loaded$")
	public void i_click_on_the_check_at_the_top_should_select_all_the_ships_which_are_loaded() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.top_check_box_click());
		verbose("***********************************************************");
	}

	@Then("^the checkbox should a tick mark$")
	public void the_checkbox_should_a_tick_mark() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.check_box());
		verbose("***********************************************************");
	}

	@Then("^when I clear on the check box all the selections should be cleared$")
	public void when_I_clear_on_the_check_box_all_the_selections_should_be_cleared() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.clear_check_box());
		verbose("***********************************************************");
	}
	
	@Given("^I select a flag filter$")
	public void i_select_a_flag_filter() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(flag_filter.all_flags_click());
		Assert.assertTrue(flag_filter.first_flag_filter());
		verbose("***********************************************************");
	}

	@Then("^I click on the checkbox at the top$")
	public void i_click_on_the_checkbox_at_the_top() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.top_check_box_click());
		verbose("***********************************************************");
	}

	@Then("^I click on clear_flag_filter selection$")
	public void i_click_on_clear_flag_filter_selection() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(flag_filter.all_flags_click());
		Assert.assertTrue(flag_filter.clicking_on_clear_all_flag());
		verbose("***********************************************************");   
	}
	
	@Then("^I select a flag filter and search for the same flag_type string$")
	public void i_select_a_flag_filter_and_search_for_the_same_flag_type_string() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(flag_filter.all_flags_click());
		Assert.assertTrue(flag_filter.first_flag_filter());
		verbose("***********************************************************");
	}

	@Then("^only the ships which were loaded with the filter should be selected$")
	public void only_the_ships_which_were_loaded_with_the_filter_should_be_selected() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.verify_the_check_box_applied_with_filter());
		verbose("***********************************************************");
	}
	
	@Given("^I select a ship_type filter$")
	public void i_select_a_ship_type_filter() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(ship_type_filter.all_ship_type_click());
		Assert.assertTrue(ship_type_filter.first_ship_type_filter());
		verbose("***********************************************************");
	}

	@Then("^I click on clear_ship_type_filter selection$")
	public void i_click_on_clear_ship_type_filter_selection() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(ship_type_filter.all_ship_type_click());
		Assert.assertTrue(ship_type_filter.clicking_on_clear_all_ship_type());
		verbose("***********************************************************");   
	}
	
	@Then("^I select a ship_type filter and search for the same ship_type string$")
	public void i_select_a_ship_type_filter_and_search_for_the_same_ship_type_string() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(ship_type_filter.all_ship_type_click());
		Assert.assertTrue(ship_type_filter.first_ship_type_filter());
		verbose("***********************************************************");
	}

}
