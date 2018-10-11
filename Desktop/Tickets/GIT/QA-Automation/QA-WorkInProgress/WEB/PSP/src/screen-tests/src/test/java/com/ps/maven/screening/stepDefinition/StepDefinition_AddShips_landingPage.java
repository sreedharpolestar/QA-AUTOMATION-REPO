package com.ps.maven.screening.stepDefinition;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import com.ps.maven.screen.AddShips_landing_page;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition_AddShips_landingPage extends BrowserTypes{
	AddShips_landing_page add_ship = new AddShips_landing_page();

	@Given("^I click on `Add ships` button$")
	public void i_click_on_Add_ships_button() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(add_ship.add_ships_button_click());
		verbose("***********************************************************");
	}

	@Then("^I land in `Add ship\\(s\\) to be screened page`$")
	public void i_land_in_Add_ship_s_to_be_screened_page() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(add_ship.add_ships_by_ship_headings());
		verbose("***********************************************************");
	}

	@Then("^I should see the subtext under page heading$")
	public void i_should_see_the_subtext_under_page_heading() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(add_ship.add_ships_by_ship_subtext());
		verbose("***********************************************************");
	}

	@Then("^`Cancel` button should be seen which is enabled$")
	public void cancel_button_should_be_seen_which_is_enabled() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(add_ship.cancel_button());
		verbose("***********************************************************");
	}

	@Then("^`Screen` button which is disabled$")
	public void screen_button_which_is_disabled() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(add_ship.screen_button());
		verbose("***********************************************************");
	}

	@Then("^`By ship` tab higlighted$")
	public void by_ship_tab_higlighted() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(add_ship.by_ship_tab());
		verbose("***********************************************************");

	}


}
