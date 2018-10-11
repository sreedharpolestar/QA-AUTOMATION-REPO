package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.ps.maven.screen.LandingPage;
import com.ps.maven.screen.Flag_filter_ScreeningResultsPage;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition_Flag_Filter extends BrowserTypes{
	WebDriver driver = null;
	LandingPage landing = new LandingPage();
	Flag_filter_ScreeningResultsPage screening = new Flag_filter_ScreeningResultsPage();
	
	@Given("^I click on the flags filter then I enter the flag to be searched in the field$")
	public void i_click_on_the_flags_filter_then_I_enter_the_flag_to_be_searched_in_the_field() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.all_flags_click());
		verbose("***********************************************************");
	}

	@Then("^the all flags header should be updated with the number of flags selected$")
	public void the_all_flags_header_should_be_updated_with_the_number_of_flags_selected() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.all_flags_header_update_one());
		verbose("***********************************************************");
	}


	@Then("^The table should be updated with the search result for flag$")
	public void the_table_should_be_updated_with_the_search_result_for_flag() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.first_flag_filter());
		verbose("***********************************************************");
	}

	@Then("^I click on the cross mark next to the flag filter , the filter should be removed and the table should be updated with all the results$")
	public void i_click_on_the_cross_mark_next_to_the_flag_filter_the_filter_should_be_removed_and_the_table_should_be_updated_with_all_the_results() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.clicking_on_cross_flag());
		verbose("***********************************************************");
	}

	@Then("^I search for another flag type then the screening results page should be updated with the flag type selected$")
	public void i_search_for_another_flag_type_then_the_screening_results_page_should_be_updated_with_the_flag_type_selected() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.flag_filter_second());
		verbose("***********************************************************");
	}
	
	
	@Then("^the all flags header should be updated with the (\\d+) flags selected$")
	public void the_all_flags_header_should_be_updated_with_the_flags_selected(int arg1) throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.all_flags_header_update_second());
		verbose("***********************************************************");
	}

	@Then("^click on the clear flag selection the table should be updated with all the results$")
	public void click_on_the_clear_flag_selection_the_table_should_be_updated_with_all_the_results() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.filter_clear_flag());
		verbose("***********************************************************");
	}
	
}
