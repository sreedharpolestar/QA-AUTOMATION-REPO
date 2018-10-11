package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.AddShips_BylistPage;
import com.ps.maven.screen.ScreeningTableErrors;

import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition_ScreeningErrors extends BrowserTypes{
	
	AddShips_BylistPage by_list = new AddShips_BylistPage();
	ScreeningTableErrors by_error = new ScreeningTableErrors();
	
	@Given("^If the screening error element is visible then click on the error element and clear all errors$")
	public void if_the_screening_error_element_is_visible_then_click_on_the_error_element_and_clear_all_errors() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_error.existing_screening_error());
		verbose("***********************************************************");
	}
	
	@Given("^I click on the text field and copy paste the invalid IMO's$")
	public void i_click_on_the_text_field_and_copy_paste_the_invalid_IMO_s() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_list.text_field_invalid_imo());
		verbose("***********************************************************");
	}

	@Then("^On the screening results page screening_errors tab should be seen$")
	public void on_the_screening_results_page_screening_errors_tab_should_be_seen() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_error.screening_error_element());
		verbose("***********************************************************");
	}

	@Given("^I click on the screening_errors element I should see the fields$")
	public void i_click_on_the_screening_errors_element_I_should_see_the_fields() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_error.screening_error_element_validation());
		verbose("***********************************************************");
	}
	
	@Then("^I can also click on `Clear all` to clear all the invalid IMO list$")
	public void i_can_also_click_on_Clear_all_to_clear_all_the_invalid_IMO_list() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_error.screening_error_clear_all());
		verbose("***********************************************************");
	}

	@Then("^I can click on individual invalid IMO's to clear the list$")
	public void i_can_click_on_individual_invalid_IMO_s_to_clear_the_list() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_error.screening_error_clear_individually());
		verbose("***********************************************************");
	}
	
	@Then("^the count next to the screening error should decrement$")
	public void the_count_next_to_the_screening_error_should_decrement() throws Throwable {
		verbose("***********************************************************");
		//Covered in the above step
		verbose("***********************************************************");
	}
	
	
}
