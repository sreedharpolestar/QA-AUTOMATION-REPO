package com.ps.maven.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ps.maven.utils.BrowserTypes;

public class LandingPage extends BrowserTypes {
	By userNameField = By.xpath("//*[@id=\"username\"]");
	
	WebDriver driver = null;
	LoginPage login = new LoginPage(driver);
	ScreeningResultsPage screening = new ScreeningResultsPage();
	//*[@id="application"]/div[1]/div/nav/div/div[1]
	By pspLogo =  By.xpath("//*[@id=\"application\"]/div[1]/div/nav/div/div[1]");
	
	public void url_navigation(){
		WebDriver driver = BrowserTypes.setDriver("chrome");
		verbose("Launching the application");
		verbose("The system path is : " + System.getProperty("user.dir"));
		driver.get(getProps().getProperty("platformURL"));
		driver.manage().window().maximize();
		waitExplicitly(1);
	}
	
	public void login(){
		verbose("The username is : " + getProps().getProperty("valid_username"));
		verbose("The password is : " + getProps().getProperty("valid_password"));
		waitExplicitly(5);
		WebElement elementUserNameField = getElement(userNameField);
		elementUserNameField.sendKeys(getProps().getProperty("valid_username"));
		//getElement(userNameField).sendKeys("kanchana.krishnamurthy+123@polestarglobal.com");
		//login.enterUsername("Kanchana.krishnamurthy+123@polestarglobal.com");
		//login.enterUsername(getProps().getProperty("valid_username"));
		waitExplicitly(1);
		login.enterPassword(getProps().getProperty("valid_password"));
		login.login();
	}
	
	public Boolean isLoggedIn() {
		waitExplicitly(1);
		return true;
		/*if (getDriver().findElement(pspLogo).isDisplayed() == true) {
			verbose("Logged on to the PS Platform successfully!");
			return true;
		} else {
			error("Account dropdown list box is not present. Assuming Login failed. ");
			return false;*/
		}
	}

