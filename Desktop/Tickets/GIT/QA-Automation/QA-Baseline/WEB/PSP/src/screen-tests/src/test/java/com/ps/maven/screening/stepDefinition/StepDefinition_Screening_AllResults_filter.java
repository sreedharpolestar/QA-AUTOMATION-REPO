package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.Screening_AllResults_filter;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class StepDefinition_Screening_AllResults_filter extends BrowserTypes {
	Screening_AllResults_filter Allresults = new Screening_AllResults_filter();
	
	
	@Then("^click on the All results dropdown$")
	public void click_on_the_All_results_dropdown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.dropdown_click());
		verbose("***********************************************************");
	}

	@Then("^check for all the values in dropdown$")
	public void check_for_all_the_values_in_dropdown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.Allresults_dropdown_check());
		verbose("***********************************************************");
	   
	}

	@Then("^Critical value alone should be selected$")
	public void critical_value_alone_should_be_selected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.selection_of_critical());
		verbose("***********************************************************");
	  
	}

	@Then("^Warning value alone should be selected$")
	public void warning_value_alone_should_be_selected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.selection_of_Warning());
		verbose("***********************************************************");
	    
	}

	@Then("^OK value alone should be selected$")
	public void ok_value_alone_should_be_selected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.selection_of_OK());
		verbose("***********************************************************");
	   
	}

	@Then("^Unknown value alone should be selected$")
	public void unknown_value_alone_should_be_selected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.selection_of_Unknown());
		verbose("***********************************************************");
	   
	}

	@Then("^click on the Escalated results only toggle button$")
	public void click_on_the_Escalated_results_only_toggle_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.escalated_results_only());
		verbose("***********************************************************");
	    
	}


	@Then("^click  All results$")
	public void click_All_results() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.click_Allresults());
		verbose("***********************************************************");
	    
	}

	@Then("^check the filter and select Ship global sanction check\\.$")
	public void check_the_filter_and_select_Ship_global_sanction_check() throws Throwable {
	    
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.check_dropdown_select_ship_global_sanctions());
		verbose("***********************************************************");
	    
	}
	@Then("^check the filter and select port state control check$")
	public void check_the_filter_and_select_port_state_control_check() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.check_dropdown_select_port_state_control());
		verbose("***********************************************************");

	}

	@Then("^check the filter and select ship movement history check$")
	public void check_the_filter_and_select_ship_movement_history_check() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.check_dropdown_select_ship_movement_history());
		verbose("***********************************************************");
	}

	@Then("^check the filter and select Country sanctions check$")
	public void check_the_filter_and_select_Country_sanctions_check() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.check_dropdown_select_country_sanctions());
		verbose("***********************************************************");
	}

	@Then("^check the filter and select Company global sanctions check$")
	public void check_the_filter_and_select_Company_global_sanctions_check() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.check_dropdown_select_company_global_sanctions());
		verbose("***********************************************************");
	}

	@Then("^check the filter and select overall screening result option$")
	public void check_the_filter_and_select_overall_screening_result_option() throws Throwable {
	    verbose("***********************************************************");
		Assert.assertTrue(Allresults.check_dropdown_select_overall_screening_result());
		verbose("***********************************************************");
	}
	@Then("^check the filter$")
	public void check_the_filter() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.click_check_dropdown());
		verbose("***********************************************************");
	   
	}
	@Then("^validate whether Ship global sanctions list check result is Critical$")
	public void validate_whether_Ship_global_sanctions_list_check_result_is_Critical() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.Ship_global_result_Critical());
		verbose("***********************************************************");
	}
	@Then("^validate whether port state control check result is Warning$")
	public void validate_whether_port_state_control_check_result_is_Warning() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.port_state_result_Warning());
		verbose("***********************************************************");
	}
	@Then("^validate whether ship movementhistory check result is OK$")
	public void validate_whether_ship_movementhistory_check_result_is_OK() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.ship_movement_history_OK());
		verbose("***********************************************************");
	}
	@Then("^validate whether Country sanctions check result is OK$")
	public void validate_whether_Country_sanctions_check_result_is_Unknown() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.Country_sanctions_check_OK());
		verbose("***********************************************************");
	}
	@Then("^validate whether Company global sanctions check result is Pending$")
	public void validate_whether_Company_global_sanctions_check_result_is_Pending() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(Allresults.Company_global_sanctions_check_Unknown());
		verbose("***********************************************************");
	}
}
