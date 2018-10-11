package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.CheckBox;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Then;

public class StepDefinition_Checkbox extends BrowserTypes {
	CheckBox screening = new CheckBox();
	
	@Then("^I click on one check box whole row should be highlighted$")
	public void i_click_on_one_check_box_whole_row_should_be_highlighted() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.single_checkbox_click_higlight());
		verbose("***********************************************************");
	}

	@Then("^when I unclick on the checkbox the row should be unselected\\.$")
	public void when_I_unclick_on_the_checkbox_the_row_should_be_unselected() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.single_unclick_checkbox());
		verbose("***********************************************************");
	}

	@Then("^I click on multiple check boxes whole multiple rows should be highlighted$")
	public void i_click_on_multiple_check_boxes_whole_multiple_rows_should_be_highlighted() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.multiple_checkbox_click_higlight());
		verbose("***********************************************************");
	}

	@Then("^when I unclick on the checkboxes the row should be unselected\\.$")
	public void when_I_unclick_on_the_checkboxes_the_row_should_be_unselected() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.multiple_checkbox_unclick());
		verbose("***********************************************************");
	}
	
	
	
}
