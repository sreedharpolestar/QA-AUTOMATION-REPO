package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.ps.maven.screen.LandingPage;
import com.ps.maven.screen.ScreeningResultsPage;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition_ScreeningResultsPage extends BrowserTypes{
	WebDriver driver = null;
	LandingPage landing = new LandingPage();
	ScreeningResultsPage screening = new ScreeningResultsPage();


	@Given("^I login to devtest application with valid username and password$")
	public void i_login_to_devtest_application_with_valid_username_and_password() throws Throwable {
		verbose("***********************************************************");
		landing.url_navigation();
		landing.login();
		Assert.assertTrue(landing.isLoggedIn());
		verbose("***********************************************************");
	}

/*@When("^I click on Notifications menu and then I click on Screening menu$")
	public void i_click_on_Notifications_menu_and_then_I_click_on_Screening_menu() throws Throwable {
		verbose("***********************************************************");
		screening.notifications_click();
		verbose("***********************************************************");
	}*/

	@Then("^I should be landed in Screening results page$")
	public void i_should_be_landed_in_Screening_results_page() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.screening_link());
		verbose("***********************************************************");
	}

	@Given("^I enter three string characters in the search field$")
	public void i_enter_three_string_characters_in_the_search_field() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.search_three_char());
		verbose("***********************************************************");
	}

	@Then("^the table has to update with the results for the characters entered$")
	public void the_table_has_to_update_with_the_results_for_the_characters_entered() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.updated_screening_results_table_with_string_in_sequence());
		verbose("***********************************************************");
	}

	@When("^I click on cross mark in the search field string should be cleared$")
	public void i_click_on_cross_mark_in_the_search_field_string_should_be_cleared() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.search_cross_mark());	  
		verbose("***********************************************************");
	}

	@Then("^I enter a number in the search field$")
	public void i_enter_a_number_in_the_search_field() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.search_three_numbers());	   
		verbose("***********************************************************");
	}

	@Then("^the screening results table should be updated to return the results with that number$")
	public void the_screening_results_table_should_be_updated_to_return_the_results_with_that_number() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.updated_screening_results_table_with_number_in_sequence());
		verbose("***********************************************************");

	}

	@Then("^agin I click on cross mark the table should be updated with all the results$")
	public void agin_I_click_on_cross_mark_the_table_should_be_updated_with_all_the_results() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.search_cross_mark());	
		verbose("***********************************************************");
	}



	



}
