package com.ps.maven.screening.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import com.ps.maven.screen.LandingPage;
import com.ps.maven.screen.LoginPage;
import com.ps.maven.utils.BrowserTypes;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition_Login extends BrowserTypes{
	WebDriver driver = null;
	LoginPage login = new LoginPage(driver);
	LandingPage landing = new LandingPage();
	BrowserTypes browser = new BrowserTypes();	

	@Given("^I navigate to the devtest URL$")
	public void i_navigate_to_the_devtest_URL() throws Throwable {
		verbose("***********************************************************");
		WebDriver driver = BrowserTypes.setDriver("Chrome");
		verbose("Launching the application");
		verbose("The system path is : " + System.getProperty("user.dir"));
		driver.get(getProps().getProperty("platformURL"));
		driver.manage().window().maximize();
		waitExplicitly(1);
		verbose("***********************************************************");
	}

	@When("^given valid username and valid password$")
	public void given_valid_username_and_password() throws Throwable {
		verbose("***********************************************************");
		verbose("The username is : " + getProps().getProperty("valid_username"));
		verbose("The password is : " + getProps().getProperty("valid_password"));
		waitExplicitly(1);
		login.enterUsername(getProps().getProperty("valid_username"));
		waitExplicitly(1);
		login.enterPassword(getProps().getProperty("valid_password"));
		verbose("***********************************************************");
	}

	@Then("^Click on Login button$")
	public void click_on_Login_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		login.login();
		verbose("***********************************************************");
	}

	@Then("^I should be logged in successfully$")
	public void i_should_be_logged_in_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		verbose("***********************************************************");
		Assert.assertTrue(landing.isLoggedIn());
		verbose("***********************************************************");
	}

	@Then("^click on logout button$")
	public void click_on_logout_button() throws Throwable {
		verbose("***********************************************************");
		login.logout();
		verbose("***********************************************************");
	}

	@Then("^close the browser driver$")
	public void close_the_browser_driver() throws Throwable {
		verbose("***********************************************************");
		// Write code here that turns the phrase above into concrete actions
		browser.tearDown();
		verbose("***********************************************************");
	}

	@When("^give invalid username and invalid password$")
	public void give_invalid_username_and_password() throws Throwable {
		verbose("***********************************************************");
		verbose("The username is : " + getProps().getProperty("invalid_username"));
		verbose("The password is : " + getProps().getProperty("invalid_password"));
		waitExplicitly(1);
		login.enterUsername(getProps().getProperty("invalid_username"));
		waitExplicitly(1);
		login.enterPassword(getProps().getProperty("invalid_password"));
		verbose("***********************************************************");
	}


	@Then("^login should be unsuccessful$")
	public void login_should_be_unsuccessful() throws Throwable {
		verbose("***********************************************************");
		Assert.assertTrue(login.unsuccessful_login());
		verbose("***********************************************************");
	}

	@When("^give invalid username and valid password$")
	public void give_invalid_username_and_valid_password() throws Throwable {
		verbose("***********************************************************");
		verbose("The username is : " + getProps().getProperty("invalid_username"));
		verbose("The password is : " + getProps().getProperty("valid_password"));
		waitExplicitly(1);
		login.enterUsername(getProps().getProperty("valid_username"));
		waitExplicitly(1);
		login.enterPassword(getProps().getProperty("invalid_password"));
		verbose("***********************************************************");
	}

	@When("^I click on Login button without username and password$")
	public void i_click_on_Login_button_without_username_and_password() throws Throwable {
		verbose("***********************************************************");
		login.login();
		verbose("***********************************************************");
	}
}
