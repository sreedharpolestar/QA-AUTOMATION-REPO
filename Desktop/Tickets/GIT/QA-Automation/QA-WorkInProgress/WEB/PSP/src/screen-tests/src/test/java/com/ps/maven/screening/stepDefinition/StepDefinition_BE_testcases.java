package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;

import com.ps.maven.screen.BE_testcases;
import com.ps.maven.utils.BrowserTypes;

import cucumber.api.java.en.Then;

public class StepDefinition_BE_testcases extends BrowserTypes{
	BE_testcases BEtestcases = new BE_testcases();

		@Then("^click on the ship name XXX$")
		public void click_on_the_ship_name_XXX() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			verbose("***********************************************************");
			Assert.assertTrue(BEtestcases.specific_shipname_click());
			verbose("***********************************************************");
			
		
		}


}
