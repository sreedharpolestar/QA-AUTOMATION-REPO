package com.ps.maven.screening.stepDefinition;

import com.ps.maven.utils.BrowserTypes;
import com.ps.maven.screen.AddShips_BylistPage;
import com.ps.maven.screen.AddShips_ByspreadsheetPage;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class StepDefinition_AddShipsBySpreadsheet extends BrowserTypes {
	


		AddShips_ByspreadsheetPage by_sheet = new AddShips_ByspreadsheetPage();
		AddShips_BylistPage by_list = new AddShips_BylistPage();

		@Given("^I click on `By spreadsheet` tab$")
		public void i_click_on_By_spreadsheet_tab() throws Throwable {
			verbose("***********************************************************");
			Assert.assertTrue(by_sheet.spreadsheet_click());
			verbose("***********************************************************");
		}

		@Then("^I should be landed in By spreadsheet page and should see the header$")
		public void i_should_be_landed_in_By_spreadsheet_page_and_should_see_the_header() throws Throwable {
			//This is covered in the above module
		}

		@Given("^I click on browse button$")
		public void i_click_on_browse_button() throws Throwable {

		}

		@Then("^search and upload the file$")
		public void search_and_upload_the_file() throws Throwable {
			verbose("***********************************************************");
			Assert.assertTrue(by_sheet.browse_valid());
			verbose("***********************************************************");
		}

		@Then("^the file should be listed and verify the text in the search field$")
		public void the_file_should_be_listed_and_verify_the_text_in_the_search_field() throws Throwable {
			//This is covered in above module
		}

		@Then("^verify the screen button is enabled and click$")
		public void verify_the_screen_button_is_enabled_and_click() throws Throwable {
			verbose("***********************************************************");
			Assert.assertTrue(by_sheet.screen_button_enabled());
			verbose("***********************************************************");
		}

		@Then("^search and upload the invalid format file$")
		public void search_and_upload_the_invalid_format_file() throws Throwable {
			verbose("***********************************************************");
			Assert.assertTrue(by_sheet.browse_invalid());
			verbose("***********************************************************");
		}


		@Then("^verify the screen shouldn't be enabled and should see an validation message$")
		public void verify_the_screen_shouldn_t_be_enabled_and_should_see_an_validation_message() throws Throwable {
			verbose("***********************************************************");
			Assert.assertTrue(by_sheet.screen_button_not_enabled());
			verbose("***********************************************************");
		}

		@Given("^I click on Cancel button and then I should land in Screening results page$")
		public void i_click_on_Cancel_button_and_then_I_should_land_in_Screening_results_page() throws Throwable {
			verbose("***********************************************************");
			Assert.assertTrue(by_list.cancel_button());
			verbose("***********************************************************");
		}


	}


