package functionalTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testDatas.*;
import testEnviroments.*;
import pageObjectMethods.*;
import browserType.*;
import modules.*;

public class AccountFunctional {

 @Test
 public void createNewAccount() throws Throwable {
  WebDriver driver = BrowserType.getBrowser("Chrome");
  Logger log = Logger.getLogger("Logger");

  driver.get(enviroments.url);
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  log.info("Web application launched");

  // Login
  IntegrationTest.login(driver);
  Thread.sleep(3000);

  // Click Account text link
  Account.accounts_menu(driver).click();
  Thread.sleep(3000);
  log.info("Account link text clicked");

  String accountHeaderText = Account.accounts_text_header(driver).getText();
  Assert.assertEquals(AccountTestData.accounts_text_header, accountHeaderText);
  log.info("Account H1 header Text:  " + accountHeaderText);

  // Click new account button
  Account.new_account_button(driver).click();
  log.info("New account button clicked");

  // Click save button accounts
  Global.save_button(driver).click();
  log.info("Save button clicked");


  // Verify validation messages
  String accountTypeRequired = Account.account_type_is_required_validation_text(driver).getText();
  Assert.assertEquals(AccountTestData.account_type_is_required_validation_text, accountTypeRequired);
  log.info("Account type is required validation message:  " + accountTypeRequired);

  String sapCustomerCodeRequired = Account.sap_customer_code_is_required_validation_text(driver).getText();
  Assert.assertEquals(AccountTestData.sap_customer_code_is_required_validation_text, sapCustomerCodeRequired);
  log.info("SAP customer code is required validation message:  " + sapCustomerCodeRequired);

  String storeAccountNameRequired = Account.account_name_is_required_validation_text(driver).getText();
  Assert.assertEquals(AccountTestData.account_name_is_required_validation_text, storeAccountNameRequired);
  log.info("Account name is required validation message:  " + storeAccountNameRequired);


  // Input test data
  new Select(Account.account_type(driver)).selectByVisibleText(AccountTestData.account_type_Distributor_list);
  log.info(AccountTestData.account_type_Distributor_list + ": Account Type selected");

  Account.sap_customer_code(driver).sendKeys(AccountTestData.sap_customer_code);
  log.info(AccountTestData.sap_customer_code + ": is entered in SAP customer code");

  String accounName = AccountTestData.account_name;
  Account.account_name(driver).sendKeys(accounName);
  log.info(accounName + ": is entered in Account name");

  Account.address_line_1(driver).sendKeys(AccountTestData.address_line_1);
  log.info(AccountTestData.address_line_1 + ": is entered in Address line 1");

  Account.address_line_2(driver).sendKeys(AccountTestData.address_line_2);
  log.info(AccountTestData.address_line_2 + ": is entered in Address line 2");

  Account.town_city(driver).sendKeys(AccountTestData.town_city);
  log.info(AccountTestData.town_city + ": is entered in Town/City");

  Account.post_code(driver).sendKeys(AccountTestData.post_code);
  log.info(AccountTestData.post_code + ": is entered in Post Code");

  Account.state(driver).sendKeys(AccountTestData.state);
  log.info(AccountTestData.state + ": is entered in State");

  Account.country(driver).sendKeys(AccountTestData.country);
  log.info(AccountTestData.country + ": is entered in country");

  Account.fax(driver).sendKeys(AccountTestData.fax);
  log.info(AccountTestData.fax + ": is entered in fax");

  Account.telephone(driver).sendKeys(AccountTestData.telephone);
  log.info(AccountTestData.telephone + ": is entered in telephone");

  //Click save button 
  Global.save_button(driver).click();
  log.info("Save button clicked");
  Thread.sleep(2000);

  //Search for created account
  Global.search_textbox(driver).click();
  Global.search_textbox(driver).sendKeys(accounName);
  log.info(accounName + ": is entered in search box");
  //Global.search_textbox(driver).sendKeys(Keys.ENTER);
  Thread.sleep(2000);

  //Search return created account
  Global.search_result(driver).click();
  Thread.sleep(5000);


  //Verify details used in account creation is the same
  String sapCustomerCode = Account.sap_customer_code(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.sap_customer_code, sapCustomerCode);
  log.info("SAP code is the same as SAP code used in account creation:  " + sapCustomerCode);

  String accountName = Account.account_name(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.account_name, accountName);
  log.info("Account name is the same as account name used in account creation:  " + accountName);

  String addressLine1 = Account.address_line_1(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.address_line_1, addressLine1);
  log.info("Address Line 1 is the same as Address Line 1 used in account creation:  " + addressLine1);

  String addressLine2 = Account.address_line_2(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.address_line_2, addressLine2);
  log.info("Address Line 2 is the same as Address Line 2 used in account creation:  " + addressLine2);

  String townCity = Account.town_city(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.town_city, townCity);
  log.info("Town / City is the same as Town / City used in account creation:  " + townCity);

  String postCode = Account.post_code(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.post_code, postCode);
  log.info("Post Code is the same as Post Code used in account creation:  " + postCode);

  String state = Account.state(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.state, state);
  log.info("State is the same as State used in account creation:  " + state);

  String country = Account.country(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.country, country);
  log.info("Country is the same as Country used in account creation:  " + country);

  String fax = Account.fax(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.fax, fax);
  log.info("Fax is the same as Fax used in account creation:  " + fax);

  String telephone = Account.telephone(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.telephone, telephone);
  log.info("Telephone is the same as Telephone used in account creation:  " + telephone);
  

  // Edit
  Account.sap_customer_code(driver).clear();
  Account.sap_customer_code(driver).sendKeys(AccountTestData.sap_customer_code_edited);
  log.info(AccountTestData.sap_customer_code_edited + ": is entered in SAP customer code");

  String accounNameEdited = AccountTestData.account_name_edited;
  Account.account_name(driver).clear();
  Account.account_name(driver).sendKeys(accounNameEdited);
  log.info(accounNameEdited + ": is entered in Account name");

  Account.address_line_1(driver).clear();
  Account.address_line_1(driver).sendKeys(AccountTestData.address_line_1_edited);
  log.info(AccountTestData.address_line_1_edited + ": is entered in Address line 1");

  Account.address_line_2(driver).clear();
  Account.address_line_2(driver).sendKeys(AccountTestData.address_line_2_edited);
  log.info(AccountTestData.address_line_2_edited + ": is entered in Address line 2");

  Account.town_city(driver).clear();
  Account.town_city(driver).sendKeys(AccountTestData.town_city_edited);
  log.info(AccountTestData.town_city_edited + ": is entered in Town/City");

  Account.post_code(driver).clear();
  Account.post_code(driver).sendKeys(AccountTestData.post_code_edited);
  log.info(AccountTestData.post_code_edited + ": is entered in Post Code");

  Account.state(driver).clear();
  Account.state(driver).sendKeys(AccountTestData.state_edited);
  log.info(AccountTestData.state_edited + ": is entered in State");

  Account.country(driver).clear();
  Account.country(driver).sendKeys(AccountTestData.country_edited);
  log.info(AccountTestData.country_edited + ": is entered in country");

  Account.fax(driver).clear();
  Account.fax(driver).sendKeys(AccountTestData.fax_edited);
  log.info(AccountTestData.fax_edited + ": is entered in fax");

  Account.telephone(driver).clear();
  Account.telephone(driver).sendKeys(AccountTestData.telephone_edited);
  log.info(AccountTestData.telephone_edited + ": is entered in telephone");

  //Click save button 
  Global.save_button(driver).click();
  log.info("Save button clicked");
  Thread.sleep(2000);

  //Search for created account
  Global.search_textbox(driver).click();
  Global.search_textbox(driver).clear();
  Global.search_textbox(driver).sendKeys(accounNameEdited);
  log.info(accounNameEdited + ": is entered in search box");
  //Global.search_textbox(driver).sendKeys(Keys.ENTER);
  Thread.sleep(2000);

  //Search return created account
  Global.search_result(driver).click();
  Thread.sleep(5000);
  
  //Verify edited details used in account update is the same
  String sapCustomerCode_Edited = Account.sap_customer_code(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.sap_customer_code_edited, sapCustomerCode_Edited);
  log.info("SAP code is the same as SAP code used in account creation:  " + sapCustomerCode_Edited);

  String accountName_Edited = Account.account_name(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.account_name_edited, accountName_Edited);
  log.info("Account name is the same as account name used in account creation:  " + accountName_Edited);

  String addressLine1_Edited = Account.address_line_1(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.address_line_1_edited, addressLine1_Edited);
  log.info("Address Line 1 is the same as Address Line 1 used in account creation:  " + addressLine1_Edited);

  String addressLine2_Edited = Account.address_line_2(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.address_line_2_edited, addressLine2_Edited);
  log.info("Address Line 2 is the same as Address Line 2 used in account creation:  " + addressLine2_Edited);

  String townCity_Edited = Account.town_city(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.town_city_edited, townCity_Edited);
  log.info("Town / City is the same as Town / City used in account creation:  " + townCity_Edited);

  String postCode_Edited = Account.post_code(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.post_code_edited, postCode_Edited);
  log.info("Post Code is the same as Post Code used in account creation:  " + postCode_Edited);

  String state_Edited = Account.state(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.state_edited, state_Edited);
  log.info("State is the same as State used in account creation:  " + state_Edited);

  String country_Edited = Account.country(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.country_edited, country_Edited);
  log.info("Country is the same as Country used in account creation:  " + country_Edited);

  String fax_Edited = Account.fax(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.fax_edited, fax_Edited);
  log.info("Fax is the same as Fax used in account creation:  " + fax_Edited);

  String telephone_Edited = Account.telephone(driver).getAttribute("value");
  Assert.assertEquals(AccountTestData.telephone_edited, telephone_Edited);
  log.info("Telephone is the same as Telephone used in account creation:  " + telephone_Edited);

  //Deactivate the account and verify activate button is visible
  Global.deactivate(driver).click();
  Thread.sleep(2000);
  Global.modal_ok(driver).click();
  Thread.sleep(2000);
  String activateText = Global.activate(driver).getText();
  Assert.assertEquals(GlobalTestData.activate, activateText);
  log.info("Account deactivated and activate text is displayed:  " + activateText);

 }

 @AfterTest
 public void tearDown() throws Exception {
  BrowserType.closeAllDriver();
  Reporter.log("User is Logged out and Application is closed | ");
 }

}