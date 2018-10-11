package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.ShipTypes_filter_ScreeningResultsPage;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition_ShipType_filter extends BrowserTypes{
	ShipTypes_filter_ScreeningResultsPage screening = new ShipTypes_filter_ScreeningResultsPage();

	@Given("^I click on the ship_types filter then I enter the ship_type to be searched in the field$")
	public void i_click_on_the_ship_types_filter_then_I_enter_the_ship_type_to_be_searched_in_the_field() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.all_ship_type_click());
		verbose("***********************************************************");
	}

	@Then("^the all ship_type header should be updated with `(\\d+) ship type` selected$")
	public void the_all_ship_type_header_should_be_updated_with_ship_type_selected(int arg1) throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.all_ship_type_header_update_one());
		verbose("***********************************************************");
	}

	@Then("^The table should be updated with the search result for ship_type$")
	public void the_table_should_be_updated_with_the_search_result_for_ship_type() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.first_ship_type_filter());
		verbose("***********************************************************");
	}	

	@Then("^I click on the cross mark next to the ship_type filter , the filter should be removed and the table should be updated with all the results$")
	public void i_click_on_the_cross_mark_next_to_the_ship_type_filter_the_filter_should_be_removed_and_the_table_should_be_updated_with_all_the_results() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.clicking_on_cross_ship_type());
		verbose("***********************************************************");
	}


	@Then("^I search for another ship_type then the screening results page should be updated with the ship_type selected$")
	public void i_search_for_another_ship_type_then_the_screening_results_page_should_be_updated_with_the_ship_type_selected() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.ship_type_filter_second());
		verbose("***********************************************************");
	}
	
	@Then("^the all ship_type header should be updated with the `(\\d+) ship types` selected$")
	public void the_all_ship_type_header_should_be_updated_with_the_ship_types_selected(int arg1) throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.all_ship_type_header_update_second());
		verbose("***********************************************************");
	}

	@Then("^click on the clear ship_type selection the table should be updated with all the results$")
	public void click_on_the_clear_ship_type_selection_the_table_should_be_updated_with_all_the_results() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.filter_clear_ship_type());
		verbose("***********************************************************");
	}

}
