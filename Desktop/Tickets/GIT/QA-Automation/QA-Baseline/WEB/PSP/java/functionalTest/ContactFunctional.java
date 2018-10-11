package functionalTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testDatas.*;
import testEnviroments.*;
import pageObjectMethods.*;
import browserType.*;
import modules.*;

public class ContactFunctional {
	
	 private static WebDriver driver = null;

	@Test
	public void createNewContact() throws Throwable {
		WebDriver driver = BrowserType.getBrowser("Chrome");
		Logger log = Logger.getLogger("Logger");

		driver.get(enviroments.url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		log.info("Web application launched");

		// Login
		IntegrationTest.login(driver);
		Thread.sleep(5000);

		// Click contact text link
		Contact.contact_menu(driver).click();
		log.info("Contact link text clicked");

		String contactHeaderText = Contact.contact_text_header(driver).getText();
		Assert.assertEquals(ContactTestData.contact_text_header, contactHeaderText);
		log.info("Contact H1 header Text:  " + contactHeaderText);

		// Click new contact button
		Contact.new_contact_button(driver).click();
		log.info("New contact button clicked");

		// Click save button contact
		Global.save_button(driver).click();
		log.info("Save button clicked");


		// Verify validation messages
		String firstNameRequired = Contact.first_name_validation_message(driver).getText();
		Assert.assertEquals(ContactTestData.first_name_validation_message, firstNameRequired);
		log.info("First Name is required validation message:  " + firstNameRequired);

		String lastNameRequired = Contact.last_name_validation_message(driver).getText();
		Assert.assertEquals(ContactTestData.last_name_validation_message, lastNameRequired);
		log.info("Last Name is required validation message:  " + lastNameRequired);

		String companyRequired = Contact.company_validation_message(driver).getText();
		Assert.assertEquals(ContactTestData.company_validation_message, companyRequired);
		log.info("Company is required validation message:  " + companyRequired);

		String contactsRequired = Contact.contacts_validation_message(driver).getText();
		Assert.assertEquals(ContactTestData.contacts_validation_message, contactsRequired);
		log.info("Contacts is required validation message:  " + contactsRequired);


		// Input test data
		Contact.title(driver).sendKeys(ContactTestData.title);
		log.info(ContactTestData.title + ": is entered in Title");

		String firstName = ContactTestData.first_name;
		Contact.first_name(driver).sendKeys(firstName);
		log.info(firstName + ": is entered in First Name");

		Contact.last_name(driver).sendKeys(ContactTestData.last_name);
		log.info(ContactTestData.last_name + ": is entered in Last Name");

		Contact.company(driver).sendKeys(ContactTestData.company);
		log.info(ContactTestData.company + ": is entered in Company");

		//		Contact.flag(driver).sendKeys(ContactTestData.flag);
		//		log.info(ContactTestData.flag + ": is selected");
		//
		//		String selectFlag =  Contact.select_flag(driver).getText();
		//		log.info(selectFlag + ": is displayed");
		//
		//		Contact.select_flag(driver).click();
		//		log.info(selectFlag + ": is picked");

		Contact.email_address(driver).sendKeys(ContactTestData.email_address);
		log.info(ContactTestData.email_address + ": is entered in Email Address");

		Contact.mobile_number(driver).sendKeys(ContactTestData.mobile_number);
		log.info(ContactTestData.mobile_number + ": is entered in Mobile Number ");

		Contact.fax_number(driver).sendKeys(ContactTestData.fax_number);
		log.info(ContactTestData.fax_number + ": is entered in Fax Number ");

		Contact.telex_number(driver).sendKeys(ContactTestData.telex_number);
		log.info(ContactTestData.telex_number + ": is entered in Telex Number");

		String csoOff = Contact.is_cso(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.cso_off, csoOff);
		log.info("This user is a Company Security Officer (CSO) is not preselected: " + csoOff );
		Contact.is_cso(driver).click();

		//Click save button 
		Global.save_button(driver).click();
		log.info("Save button clicked");
		Thread.sleep(2000);

		//Click contact link
		Contact.contact_link(driver).click();

		//Search for created contact
		Global.search_textbox(driver).click();
		Global.search_textbox(driver).sendKeys(firstName);
		log.info(firstName + ": is entered in search box");
		//Global.search_textbox(driver).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		//Search return created contact
		Global.search_result(driver).click();
		Thread.sleep(3000);


		//Verify details used in contact creation is the same
		String title = Contact.title(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.title, title);
		log.info("title is the same as title used in contact creation:  " + title);

		String fname = Contact.first_name(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.first_name, fname);
		log.info("First Name is the same as First Name used in contact creation:  " + fname);

		String lastname = Contact.last_name(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.last_name, lastname);
		log.info("Last Name is the same as Last Name used in contact creation:  " + lastname);

		String company = Contact.company(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.company, company);
		log.info("Company is the same as Company used in contact creation:  " + company);

		String emailAddress = Contact.email_address(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.email_address, emailAddress);
		log.info("Email Address is the same as Email Address used in contact creation:  " + emailAddress);

		String mobileNumber = Contact.mobile_number(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.mobile_number, mobileNumber);
		log.info("Mobile Number is the same as Mobile Number used in contact creation:  " + mobileNumber);

		String faxNumber = Contact.fax_number(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.fax_number, faxNumber);
		log.info("Fax Number is the same as Fax Number used in contact creation:  " + faxNumber);

		String telexNumber = Contact.telex_number(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.telex_number, telexNumber);
		log.info("Telex Number is the same as Telex Number used in contact creation:  " + telexNumber);

		String csoOn = Contact.is_cso(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.cso_off, csoOn);
		log.info("This user is a Company Security Officer (CSO) is selected: " + csoOn );	


		// Edit
		Contact.title(driver).clear();
		Contact.title(driver).sendKeys(ContactTestData.title_edited);
		log.info(ContactTestData.title_edited + ": is entered in Title");

		String firstNameEdited = ContactTestData.first_name_edited;
		Contact.first_name(driver).clear();
		Contact.first_name(driver).sendKeys(firstNameEdited);
		log.info(firstNameEdited + ": is entered in First Name");

		Contact.last_name(driver).clear();
		Contact.last_name(driver).sendKeys(ContactTestData.last_name_edited);
		log.info(ContactTestData.last_name_edited + ": is entered in Last Name");

		Contact.company(driver).clear();
		Contact.company(driver).sendKeys(ContactTestData.company_edited);
		log.info(ContactTestData.company_edited + ": is entered in Company");

		Contact.email_address(driver).clear();
		Contact.email_address(driver).sendKeys(ContactTestData.email_address_edited);
		log.info(ContactTestData.email_address_edited + ": is entered in Email Address");

		Contact.mobile_number(driver).clear();
		Contact.mobile_number(driver).sendKeys(ContactTestData.mobile_number_edited);
		log.info(ContactTestData.mobile_number_edited + ": is entered in Mobile Number ");

		Contact.fax_number(driver).clear();
		Contact.fax_number(driver).sendKeys(ContactTestData.fax_number_edited);
		log.info(ContactTestData.fax_number_edited + ": is entered in Fax Number ");

		Contact.telex_number(driver).clear();
		Contact.telex_number(driver).sendKeys(ContactTestData.telex_number_edited);
		log.info(ContactTestData.telex_number_edited + ": is entered in Telex Number");

		Contact.is_cso(driver).click();
		String csoOffEdited = Contact.is_cso(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.cso_off_edited, csoOffEdited);
		log.info("This user is a Company Security Officer (CSO) is not preselected: " + csoOffEdited );
		Contact.is_cso(driver).click();

		//Click save button 
		Global.save_button(driver).click();
		log.info("Save button clicked");
		Thread.sleep(2000);

		//Search for created contact
		Global.search_textbox(driver).clear();
		Global.search_textbox(driver).click();
		Global.search_textbox(driver).sendKeys(firstNameEdited);
		log.info(firstNameEdited + ": is entered in search box");
		Thread.sleep(2000);

		//Search return created contact
		Global.search_result(driver).click();
		Thread.sleep(3000);

		//Verify edited details used in contact update is the same

		String titleVerifyUpdate = Contact.title(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.title_edited, titleVerifyUpdate);
		log.info("title is the same as title used in editing contact details:  " + titleVerifyUpdate);

		String fnameVerifyUpdate = Contact.first_name(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.first_name_edited, fnameVerifyUpdate);
		log.info("First Name is the same as First Name used in editing contact details:  " + fnameVerifyUpdate);

		String lastnameVerifyUpdate = Contact.last_name(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.last_name_edited, lastnameVerifyUpdate);
		log.info("Last Name is the same as Last Name used in editing contact details:  " + lastnameVerifyUpdate);

		String companyVerifyUpdate = Contact.company(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.company_edited, companyVerifyUpdate);
		log.info("Company is the same as Company used in editing contact details:  " + companyVerifyUpdate);

		String emailAddressVerifyUpdate = Contact.email_address(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.email_address_edited, emailAddressVerifyUpdate);
		log.info("Email Address is the same as Email Address used in editing contact details:  " + emailAddressVerifyUpdate);

		String mobileNumberVerifyUpdate = Contact.mobile_number(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.mobile_number_edited, mobileNumberVerifyUpdate);
		log.info("Mobile Number is the same as Mobile Number used in editing contact details:  " + mobileNumberVerifyUpdate);

		String faxNumberVerifyUpdate = Contact.fax_number(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.fax_number_edited, faxNumberVerifyUpdate);
		log.info("Fax Number is the same as Fax Number used in editing contact details:  " + faxNumberVerifyUpdate);

		String telexNumberVerifyUpdate = Contact.telex_number(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.telex_number_edited, telexNumberVerifyUpdate);
		log.info("Telex Number is the same as Telex Number used in editing contact details:  " + telexNumberVerifyUpdate);

		String csoOnVerifyUpdate = Contact.is_cso(driver).getAttribute("value");
		Assert.assertEquals(ContactTestData.cso_off_edited, csoOnVerifyUpdate);
		log.info("This user is a Company Security Officer (CSO) is selected: " + csoOnVerifyUpdate);	

		//Deactivate the contact and verify activate button is visible
		Global.deactivate(driver).click();
		Thread.sleep(2000);
		Global.modal_ok(driver).click();
		Thread.sleep(2000);
		
		//Search for created contact
		Global.search_textbox(driver).clear();
		Global.search_textbox(driver).click();
		Global.search_textbox(driver).sendKeys(firstNameEdited);
		log.info(firstNameEdited + ": is entered in search box");
		Thread.sleep(2000);

		//Search return no contact		
		String noContactFound = Contact.no_contact_found(driver).getText();
		log.info(noContactFound + ": is present");
		Assert.assertEquals(ContactTestData.no_contact_found, noContactFound);
		log.info("*********Contact Delete is Successful*********");


	}

	@AfterTest
	public void tearDown() throws Exception {
		BrowserType.closeAllDriver();
		Reporter.log("User is Logged out and Application is closed | ");
	}

}