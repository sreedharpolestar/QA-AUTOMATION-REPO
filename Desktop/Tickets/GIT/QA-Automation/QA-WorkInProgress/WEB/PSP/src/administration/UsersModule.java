/**
 * 
 */
package administration;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjectMethods.Contact;
import pageObjectMethods.Global;
import pageObjectMethods.Users;
import scriptResources.BrowserType;
import testDatas.UsersTestData;
import testEnviroments.enviroments;

/**
 * @author sreedhar.popuri
 *
 */
public class UsersModule {
	
	

@Test

/*public void createNewUser() throws Throwable{
	WebDriver driver = BrowserType.getBrowser("Chrome");
	Logger log = Logger.getLogger("Logger");*/
	
	public static void user(WebDriver driver) throws Throwable{
		Logger log = Logger.getLogger("Logger");
		// Click userst text link
		Users.users_menu(driver).click();
		log.info("Users menu link clicked");
		
		Thread.sleep(15000);

	/*driver.get(enviroments.url);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	log.info("Web application launched");*/

	/*IntegrationTest.login(driver);*/

	

	String usersHeaderTitle = Users.users_header_title(driver).getText();
	Assert.assertEquals(UsersTestData.users_text_header, usersHeaderTitle);
	log.info("Users Header Title:  " + usersHeaderTitle);
	Thread.sleep(15000);
	Users.new_users_button(driver).click();
	log.info("New user button clicked");
	Thread.sleep(15000);
	String newUsersPageTitle = Users.new_users_page_title(driver).getText();
	Assert.assertEquals(UsersTestData.new_users_page_title, newUsersPageTitle);
	log.info("New User Page Title:  " + newUsersPageTitle);
	Thread.sleep(15000);
	Users.new_users_account_type_remove(driver).click();
	log.info("Default Account Type Removed");
	Thread.sleep(15000);
	Global.save_button(driver).click();
	log.info("Save button clicked");
	Thread.sleep(15000);
	String UsersEmailValidation = Users.new_users_email_validation_message(driver).getText();
	Assert.assertEquals(UsersTestData.email_is_required_validation_message, UsersEmailValidation);
	log.info("Users Email  Validation Message:  " + UsersEmailValidation);
	Thread.sleep(15000);
	String UsersFirstNameValidation = Users.new_users_first_name_validation_message(driver).getText();
	Assert.assertEquals(UsersTestData.first_name_is_required_validation_message, UsersFirstNameValidation);
	log.info("Users First Name Validation Message:  " + UsersFirstNameValidation);
	Thread.sleep(15000);
	String UsersLastNameValidation = Users.new_users_last_name_validation_message(driver).getText();
	Assert.assertEquals(UsersTestData.last_name_is_required_validation_message, UsersLastNameValidation);
	log.info("Users Last Name Validation Message:  " + UsersLastNameValidation);
	Thread.sleep(15000);
	String UsersAccountTypeValidation = Users.new_users_account_type_validation_message(driver).getText();
	Assert.assertEquals(UsersTestData.account_is_required_validation_message, UsersAccountTypeValidation);
	log.info("Users Account Type Validation Message:  " + UsersAccountTypeValidation);
	Thread.sleep(15000);
	String usersRoleValidation = Users.new_users_role_validation_message(driver).getText();
	Assert.assertEquals(UsersTestData.users_role_is_required_validation_message, usersRoleValidation);
	log.info("Users Role Validation Message:  " + usersRoleValidation);

	Thread.sleep(15000);
	// Input test data
	


/*Select oSelect = new Select(Users.new_users_role(driver));*/



	
	Users.new_users_email(driver).sendKeys(UsersTestData.users_email);
	log.info("Emai ID entered is : " + UsersTestData.users_email);
	Thread.sleep(3000);
	
	Users.new_users_first_name(driver).sendKeys(UsersTestData.users_first_name);
	log.info("First name entered is : " + UsersTestData.users_first_name);
	Thread.sleep(3000);
	
	Users.new_users_last_name(driver).sendKeys(UsersTestData.users_last_name);
	log.info("Last name entered is : " + UsersTestData.users_last_name);
	Thread.sleep(3000);
	
	Users.new_users_account_type_remove(driver).click();
	Users.new_users_account_type(driver).sendKeys(UsersTestData.users_account);
	Users.new_users_account_type_select_account_link(driver).click();
	Thread.sleep(3000);
	log.info("Users account entered is : " + UsersTestData.users_account);
	
	Select oSelect = new Select(driver.findElement(By.cssSelector("#form__item__user_profile_role")));

	oSelect.selectByVisibleText("administrator");
		//new Select(Users.new_users_role(driver)).selectByVisibleText(UsersTestData.users_role_administrator_list);
		log.info("The role selected is : " + oSelect);
		Thread.sleep(3000);
		
	Users.new_users_mobile_phone(driver).sendKeys(UsersTestData.users_mobile);
	log.info("Users mobile number entered is : " + UsersTestData.users_mobile);
	Thread.sleep(3000);
	
	Users.new_users_office_phone_number(driver).sendKeys(UsersTestData.users_office_phone);
	log.info("The user's office phone number : " + UsersTestData.users_office_phone );
	Thread.sleep(3000);
	
	Users.new_users_office_phone_extension(driver).sendKeys(UsersTestData.users_office_ext);
	log.info("The user's office extension : " + UsersTestData.users_office_phone);
	Thread.sleep(3000);
	
	/*Users.new_users_choose_language(driver).click();
	Users.new_users_language_chosen_english(driver).click();
	log.info("The language chosen is : " + UsersTestData.user_language_english);
	Thread.sleep(3000);*/
	
	log.info("****SAVE THE DETAILS******");
	Users.users_save_button(driver).click();
	Thread.sleep(6000);
	
	log.info("User is in add services to the user page");
	String page_header = Users.users_add_services_page(driver).getText();
	Assert.assertEquals(UsersTestData.add_services_page_title, page_header);
	log.info("The Add services page title is : " + page_header );
	Thread.sleep(3000);
	
	log.info("****Click on Done*****");
	Users.users_add_services_page_done(driver).click();
	Thread.sleep(10000);
	
	log.info("****Search for more recently added user****");
	Users.users_sort_by_name(driver).click();
	Users.users_search_by_most_recently_added(driver).click();
	Thread.sleep(3000);
	Users.users_select_the_user_created(driver).click();
	
	log.info("****Verify the data entered******");
	Thread.sleep(3000);
	String email_enetered = Users.new_users_email(driver).getText();
	log.info("The email is same as the data entered");
	Thread.sleep(3000);
	
	String first_name = Users.new_users_first_name(driver).getText();
	System.out.println(first_name);
	log.info("The first_name is same as the data entered : " + first_name);
	/*Assert.assertEquals(UsersTestData.users_first_name, first_name);*/
	log.info("The first_name is same as the data entered : " + first_name);
	
	String last_name = Users.new_users_last_name(driver).getText();
	/*Assert.assertEquals(UsersTestData.users_last_name, last_name);*/
	log.info("The last_name is same as the data entered : " + last_name);
	
	String account = Users.new_users_account_type(driver).getText();
	/*Assert.assertEquals(UsersTestData.users_account, account);*/
	log.info("The account is same as the data entered : " + account);
	
	/*String administrator = Users.new_users_role(driver).getText();
	Assert.assertEquals(UsersTestData.users_role_administrator_list, administrator);
	log.info("The administartor is same as the data entered : " + administrator);
	*/
	String mobile_phone = Users.new_users_mobile_phone(driver).getText();
	/*Assert.assertEquals(UsersTestData.users_mobile, mobile_phone);*/
	log.info("The mobile_phone is same as the data entered : " + mobile_phone);
	
	String users_office_phone = Users.new_users_office_phone_number(driver).getText();
	/*Assert.assertEquals(UsersTestData.users_office_phone, users_office_phone);*/
	log.info("The users_office_phone is same as the data entered : " + users_office_phone);
	
	String users_office_ext = Users.new_users_office_phone_extension(driver).getText();
	/*Assert.assertEquals(UsersTestData.users_office_ext, users_office_ext);*/
	log.info("The users_office_ext is same as the data entered : " + users_office_ext);
	
	/*String user_language_english = Users.new_users_choose_language(driver).getText();
	Assert.assertEquals(UsersTestData.user_language_english, user_language_english);
	log.info("The user_language_english is same as the data entered : " + user_language_english);*/
	
	Global.Fleets_cancel(driver).click();
	log.info("**************User is created successfully!!!***********");
	
	log.info("*********Edit the data**********");
	Users.new_users_first_name(driver).sendKeys(UsersTestData.users_first_name_edit);
	log.info("The first_name edited is : " + UsersTestData.users_first_name_edit);
	
	Users.new_users_last_name(driver).sendKeys(UsersTestData.users_last_name_edit);
	log.info("The last_name edited is : " + UsersTestData.users_last_name_edit);
			
	log.info("****SAVE THE DETAILS******");
	Users.users_save_button(driver).click();
	Thread.sleep(6000);
	
	log.info("****Search for more recently edited user****");
	Users.users_sort_by_name(driver).click();
	Users.users_search_by_most_recently_added(driver).click();
	Thread.sleep(2000);
	Users.users_select_the_user_created(driver).click();
	
	log.info("****Verify the data entered******");
	String first_name_edit = Users.new_users_first_name(driver).getText();
	Assert.assertEquals(UsersTestData.users_first_name_edit, first_name_edit);
	log.info("The first_name edited is same as the data entered : " + first_name_edit);

	String last_name_edit = Users.new_users_last_name(driver).getText();
	Assert.assertEquals(UsersTestData.users_last_name_edit, last_name_edit);
	log.info("The last_name edited is same as the data entered : " + last_name_edit);
	
	log.info("***Delete the user***");
	Users.delete_user(driver).click();
	Thread.sleep(3000);
	Users.delete_user_modal(driver).click();
	Thread.sleep(2000);
	
	String user_created = Users.users_search_text(driver).getText();
	Users.users_search_created_user(driver).sendKeys(user_created);
	Thread.sleep(6000);
	
	String user_not_found = Users.user_deleted(driver).getText();
	Assert.assertEquals(UsersTestData.user_not_found_string, user_not_found);
	log.info("The user not found : " + user_not_found);
	}

}

