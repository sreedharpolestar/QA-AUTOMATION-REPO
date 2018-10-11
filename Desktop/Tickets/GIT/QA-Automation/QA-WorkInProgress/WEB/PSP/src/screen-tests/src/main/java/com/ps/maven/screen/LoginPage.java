package com.ps.maven.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ps.maven.utils.BrowserTypes;

public class LoginPage extends BrowserTypes{
	By userNameField = By.xpath("//*[@id=\"username\"]");
	By passwordField = By.xpath("//*[@id=\"password\"]");
	By loginButton = By.xpath("//form/button");
	By accountButton = By.xpath("//li[2]/a/span[1]");
	By logoutLink = By.xpath("//li[2]/ul/li[4]/a");
	
	By invalid_login = By.xpath("//div/div/form/div[1]/ul/li");

	public LoginPage(WebDriver driver) {
		super();
	}

	public void enterUsername(String username) {
		WebElement elementUserNameField = getElement(userNameField);
		elementUserNameField.click();
		elementUserNameField.clear();
		elementUserNameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		WebElement elementPasswordField = getElement(passwordField);
		elementPasswordField.click();
		elementPasswordField.clear();
		elementPasswordField.sendKeys(password);
	}

	public void username_password() throws Throwable {
		verbose("The username is : " + getProps().getProperty("username"));
		verbose("The password is : " + getProps().getProperty("password"));
		waitExplicitly(1);
		enterUsername(getProps().getProperty("username"));
		waitExplicitly(1);
		enterPassword(getProps().getProperty("password"));
	}

	public void login() {
		waitExplicitly(1);
		getDriver().findElement(loginButton).click();
		waitExplicitly(1);
	}
	
	public void logout() throws Throwable {
		waitExplicitly(1);
		verbose("Clicking on the Account button");
		getDriver().findElement(accountButton).click();
		waitExplicitly(1);
		verbose("Clicking on the Logout button");
		getDriver().findElement(logoutLink).click();
	}

	public boolean unsuccessful_login(){
		waitExplicitly(1);

		if(getElement(invalid_login).getText().equals("Invalid email/password. Please try again")){
			verbose("Login was unsuccessful");
			return true;
		}else{
			error("User logged in with invalid username and password ");

			return false;

		}
	}
	public void checkSystemStatus() throws Throwable {

		By adminPagelink = By.linkText("Administration");
		By sysStatusTab = By.partialLinkText("System status");
		By appVersionInfo = By.xpath(".//*[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div/ul[1]/li[1]");
		By systemInfoTabs = By.xpath(".//*[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div/ul[3]/li");

		getDriver().findElement(adminPagelink).click();
		Thread.sleep(3000);

		getDriver().findElement(sysStatusTab).click();
		Thread.sleep(3000);

		verbose("\n****************************************\n****************************************\n****************************************");
		verbose(" Testing App version info: " + getDriver().findElement(appVersionInfo).getText());
		verbose("System info");
		int a = getDriver().findElements(systemInfoTabs).size();
		for (int i = 1; i <= a; i++) {
			String s = getDriver().findElement(
					By.xpath(".//*[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div/ul[3]/li[" + i + "]"))
					.getText();
			verbose(s);

		}
		verbose("\n****************************************\n****************************************\n****************************************");
		getDriver().get(getProps().getProperty("platformURL"));

	}
}
