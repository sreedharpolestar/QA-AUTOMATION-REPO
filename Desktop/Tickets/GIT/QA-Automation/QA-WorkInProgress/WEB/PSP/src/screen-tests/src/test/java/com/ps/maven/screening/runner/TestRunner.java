package com.ps.maven.screening.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = {"src/test/resource"},
		glue = {"com.ps.maven.screening.stepDefinition"},
		plugin = {"pretty","html:Reports/screen-pretty","usage:Reports/screen-json/cucumber-usage.json","json:Reports/cucumber.json","junit:target/cucumber-results.xml"},
		tags = {"@All_results"},		
		monochrome = true		
		)
public class TestRunner{

}




