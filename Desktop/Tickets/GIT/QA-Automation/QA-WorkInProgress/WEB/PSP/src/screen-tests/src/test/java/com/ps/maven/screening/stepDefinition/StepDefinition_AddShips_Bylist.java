package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.AddShips_BylistPage;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class StepDefinition_AddShips_Bylist extends BrowserTypes{

	AddShips_BylistPage by_list = new AddShips_BylistPage();

	@Given("^I click on `By list` tab$")
	public void i_click_on_By_list_tab() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_list.add_by_list_tab_click());
		verbose("***********************************************************");
	}

	@Then("^I should be landed in By list page and should see the header$")
	public void i_should_be_landed_in_By_list_page_and_should_see_the_header() throws Throwable {
		//This step is covered in the above module
	}

	@Given("^I click on the text field and copy paste the IMO's$")
	public void i_click_on_the_text_field_and_copy_paste_the_IMO() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_list.text_field());
		verbose("***********************************************************");

	}

	@Then("^`Screen` button should be enabled and number next to should get updated$")
	public void screen_button_should_be_enabled_and_number_next_to_should_get_updated() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_list.Screen_button());
		verbose("***********************************************************");
	}

	@Then("^click on Screen button I should be landed in Screening results page$")
	public void click_on_Screen_button_I_should_be_landed_in_Screening_results_page() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_list.screen_button_click());
		verbose("***********************************************************");
	}

	@Then("^I click on `Cancel` button$")
	public void i_click_on_Cancel_button() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_list.cancel_button());
		verbose("***********************************************************");
	}
	@Given("^check the Refresh button text$")
	public void check_the_Refresh_button_text() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_list.Refresh_button_check());
		verbose("***********************************************************");
	}

	@Then("^check teh number displayed next to Screen button\\.$")
	public void check_teh_number_displayed_next_to_Screen_button() throws Throwable {
		verbose("***********************************************************");
		//Assert.assertTrue(by_list.Refresh_button_pending_ships());
		verbose("***********************************************************");
	}

	@Then("^the Refresh button text should change to pending ships$")
	public void the_Refresh_button_text_should_change_to_pending_ships() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(by_list.Refresh_button_pending_ships());
		verbose("***********************************************************");
	}

}
