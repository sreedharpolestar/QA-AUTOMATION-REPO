package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.ps.maven.screen.LandingPage;
import com.ps.maven.screen.ScreeningResultsPage;
import com.ps.maven.screen.ScreeningResultsPageColumnSorting;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition_ScreeningTableSorting extends BrowserTypes{
	
	WebDriver driver = null;
	LandingPage landing = new LandingPage();
	ScreeningResultsPageColumnSorting screening = new ScreeningResultsPageColumnSorting();
	
	@Given("^I click on Ship name the column should be sorted by ascending order arrow up$")
	public void i_click_on_Ship_name_the_column_should_be_sorted_by_ascending_order_arrow_up() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.ship_name_ascending_sorting());
		verbose("***********************************************************");
	}

	@Then("^I click again on the column name it should be sorted by descending order$")
	public void i_click_again_on_the_column_name_it_should_be_sorted_by_descending_order() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.ship_name_descending_sorting());
		verbose("***********************************************************");
	}

	@Given("^I click on IMO header the column should be sorted by ascending order arrow up$")
	public void i_click_on_IMO_header_the_column_should_be_sorted_by_ascending_order_arrow_up() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.IMO_ascending_sorting());
		verbose("***********************************************************");
	}

	@Then("^I click again on the IMO column name it should be sorted by descending order$")
	public void i_click_again_on_the_IMO_column_name_it_should_be_sorted_by_descending_order() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.IMO_descending_sorting());
		verbose("***********************************************************");
	}

	@Given("^I click on Ship Type header the column should be sorted by ascending order arrow up$")
	public void i_click_on_Ship_Type_header_the_column_should_be_sorted_by_ascending_order_arrow_up() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.Ship_Type_ascending_sorting());
		verbose("***********************************************************");
	}

	@Then("^I click again on the Ship Type column name it should be sorted by descending order$")
	public void i_click_again_on_the_Ship_Type_column_name_it_should_be_sorted_by_descending_order() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.Ship_Type_descending_sorting());
		verbose("***********************************************************");
	}


	@Given("^I should see by default the page is sorted by Last Updated descending order$")
	public void i_should_see_by_default_the_page_is_sorted_by_Last_Updated_descending_order() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.last_updated_descending_sorting());
		verbose("***********************************************************");
	}

	@Then("^I click again on the Last Updated column it should be sorted by descending order$")
	public void i_click_again_on_the_Last_Updated_column_it_should_be_sorted_by_descending_order() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.last_updated_ascending_sorting());
		verbose("***********************************************************");
	}

	@Given("^I click on Flag heading the column should be sorted by ascending order arrow up$")
	public void i_click_on_Flag_heading_the_column_should_be_sorted_by_ascending_order_arrow_up() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.Flag_ascending_sorting());
		verbose("***********************************************************");
	}

	@Then("^I click again on the Flag heading column it should be sorted by descending order$")
	public void i_click_again_on_the_Flag_heading_column_it_should_be_sorted_by_descending_order() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(screening.flag_descending_sorting());
		verbose("***********************************************************");
	}
	@Then("^check the Latest result column$")
	public void check_the_Latest_result_column() throws Throwable {
		verbose("***********************************************************");
		//Assert.assertTrue(screening.));
		verbose("***********************************************************");
	}

	@Then("^check the ascending sorting$")
	public void check_the_ascending_sorting() throws Throwable {
	    verbose("***********************************************************");
		Assert.assertTrue(screening.Latest_result_sorting());
		verbose("***********************************************************");
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		verbose("***********************************************************");
		//Assert.assertTrue(screening.flag_descending_sorting());
		verbose("***********************************************************");
	}



}
