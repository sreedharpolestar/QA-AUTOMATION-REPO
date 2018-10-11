package scriptResources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjectMethods.*;
import testDatas.*;

import org.apache.log4j.Logger;

public class LoginPage extends BasePage {

	// Psudo
	// enterUsername() will find username field and enter the username by
	// finding it from the properties file
	// enterPassword() will find password field and enter the password by
	// finding it from the properties file
	// login() will call the above two methods and finally find the login button
	// and click it to login to the system

	By userNameField = By.name("username");
	By passwordField = By.name("password");
	By loginButton = By.xpath("//form/button");
	By accountButton = By.xpath("//li[2]/a/span[1]");
	By logoutLink = By.xpath("//li[2]/ul/li[4]/a");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	private void enterUsername(String username) {
		WebElement elementUserNameField = getElement(userNameField);
		elementUserNameField.click();
		elementUserNameField.clear();
		elementUserNameField.sendKeys(username);
	}

	private void enterPassword(String password) {
		WebElement elementPasswordField = getElement(passwordField);
		elementPasswordField.click();
		elementPasswordField.clear();
		elementPasswordField.sendKeys(password);
	}

	public void login() {
		
		By Username = By.name("username");
		
		By Password = By.name("password");
		
		getElement(Username).sendKeys("sreedhar.popuri+2@gmail.com"); 
		waitExplicitly(2);
		
		getElement(Password).sendKeys("letmein"); 
		waitExplicitly(2);
		
		/*enterUsername(getProps().getProperty("username"));
		enterPassword(getProps().getProperty("password"));*/

		getElement(loginButton).click();

	}

	public Boolean isLoggedIn() {

		return false;
	}

	public void logout() {
		getElement(accountButton).click();
		waitExplicitly(1);
		getElement(logoutLink).click();
	}

	public void loginNotifications() {
		getDriver().get(getProps().getProperty("platformURL"));
		waitExplicitly(2);
		login();
		waitExplicitly(5);
	}

	public void checkSystemStatus() {

		By adminPagelink = By.linkText("Administration");
		By sysStatusTab = By.partialLinkText("System status");
		By appVersionInfo = By.xpath(".//*[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div/ul[1]/li[1]");
		By systemInfoTabs = By.xpath(".//*[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div/ul[3]/li");

		getElement(adminPagelink).click();
		waitExplicitly(1);

		getElement(sysStatusTab).click();
		waitExplicitly(1);

		verbose("\n****************************************\n****************************************\n****************************************");
		verbose(" Testing App version info: " + getElement(appVersionInfo).getText());
		verbose("System info");
		int a = getElements(systemInfoTabs).size();
		for (int i = 1; i <= a; i++) {
			String s = getElement(
					By.xpath(".//*[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div/ul[3]/li[" + i + "]"))
							.getText();
			verbose(s);
			
		}
		verbose("\n****************************************\n****************************************\n****************************************");
		getDriver().get(getProps().getProperty("platformURL"));

	}
	
	public void login_speed() {
		// TODO Auto-generated method stub
		enterUsername(testDatas.LoginTestData.speed_username);
		enterPassword(testDatas.LoginTestData.speed_password);
		

		getElement(loginButton).click();
	}
	public void login_profiles() {
		// TODO Auto-generated method stub
		enterUsername(testDatas.LoginTestData.profile_username);
		enterPassword(testDatas.LoginTestData.profile_password);
		

		getElement(loginButton).click();
	}
}
