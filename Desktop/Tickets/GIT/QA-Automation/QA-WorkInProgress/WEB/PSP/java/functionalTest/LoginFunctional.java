package functionalTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testDatas.*;
import testEnviroments.*;
import pageObjectMethods.*;
import browserType.*;

public class LoginFunctional {

	@Test
	public void Login() throws Throwable {
		WebDriver driver = BrowserType.getBrowser("Chrome");
		Logger log = Logger.getLogger("Logger");

		driver.get(enviroments.url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		log.info("Web application launched");

		// Login using login button only
		Login.login_button(driver).click();
		log.info("Login button clicked");

		String LoginValidationMessage = Login.invalid_email_password_validation_message(driver).getText();
		Assert.assertEquals(LoginTestData.invalid_email_password_text, LoginValidationMessage);
		log.info("Validation message displayed is:  " + LoginValidationMessage);

		// Login using invalid username and password
		Login.username(driver).sendKeys(LoginTestData.invalid_username);
		log.info("Username entered in username textbox is :  " + LoginTestData.invalid_username);
		
		Login.password(driver).sendKeys(LoginTestData.invalid_password);
		log.info("Password entered in password textbox is :  " + LoginTestData.invalid_password);
		
		Login.login_button(driver).click();
		Thread.sleep(3000);
		log.info("Login button clicked");
		
		
		Login.invalid_email_password_validation_message(driver).getText();
		Assert.assertEquals(LoginTestData.invalid_email_password_text, LoginValidationMessage);
		log.info("Validation message displayed is :  " + LoginValidationMessage);

		// Login successful;
		Login.username(driver).clear();
		log.info(LoginTestData.invalid_username+": Is cleared from username textbox");
		
		Login.username(driver).sendKeys(LoginTestData.valid_username);
		log.info("Username entered in username textbox is :  " + LoginTestData.valid_username);
		
		Login.password(driver).clear();
		log.info(LoginTestData.invalid_password+": Is cleared from password textbox");
	
		Login.password(driver).sendKeys(LoginTestData.valid_password);
		log.info("Password entered in password textbox is :  " + LoginTestData.valid_password);
		
		Login.login_button(driver).click();
		log.info("Login button clicked");
		
		Thread.sleep(3000);
		log.info("Login successfully");

		// Verify Administration text is display on top right hand corner 
		String administrationText = Login.administration_text(driver).getText();
		Assert.assertEquals(AccountTestData.administration_text, administrationText);
		log.info("Administration link is display at the top right hand corner:  " + administrationText);

		// Click Administration text link
		Login.administration_menu_link(driver).click();
		log.info("Administration link is clicked");

	}

	@AfterTest
	public void tearDown() throws Exception {
		BrowserType.closeAllDriver();
		Logger log = Logger.getLogger("Logger");
		log.info("User is Logged out and Application is closed | ");
	}

}