package pageObjectMethods;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Users 
{
	private static WebElement element = null;
	
	public static WebElement users_administartion_menu(WebDriver driver)
	{
		element = driver.findElement(By.xpath("(//a[contains(text(),'Administration')])[2]"));
		return element;
	}	
	
	public static WebElement users_menu(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[2]/a/div"));
		return element;
	}

	public static WebElement users_header_title(WebDriver driver){
		element = driver.findElement(By.cssSelector("h3.slim.aligned"));
		return element;
	}
		
	public static WebElement new_users_button(WebDriver driver){
		element = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
		return element;
	}
	
	public static WebElement new_users_page_title(WebDriver driver){
		element = driver.findElement(By.cssSelector("h3.slim.aligned"));
		return element;
	}
	
	public static WebElement new_users_email(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@id='form__item__email']"));
		return element;
	}
	public static WebElement new_users_email_validation_message(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.alert.alert-danger > ul > li"));
		return element;
	}
	
	public static WebElement new_users_first_name(WebDriver driver){
		element = driver.findElement(By.id("form__item__first_name"));
		return element;
	}
	
	public static WebElement new_users_first_name_validation_message(WebDriver driver){
		element = driver.findElement(By.xpath("//form/div/ul/li[2]"));
		return element;
	}
	
	public static WebElement new_users_last_name(WebDriver driver){
		element = driver.findElement(By.id("form__item__last_name"));
		return element;
	}
	
	public static WebElement new_users_last_name_validation_message(WebDriver driver){
		element = driver.findElement(By.xpath("//form/div/ul/li[3]"));
		return element;
	}
	
	public static WebElement new_users_account_type(WebDriver driver){
		element = driver.findElement(By.id("form__item__user_profile_account"));
		return element;
	}
	
	public static WebElement new_users_account_type_validation_message(WebDriver driver){
		element = driver.findElement(By.xpath("//form/div/ul/li[4]"));
		return element;
	}
	
	public static WebElement new_users_account_type_remove(WebDriver driver){
		element = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
		return element;
	}
	
	public static WebElement new_users_account_type_search(WebDriver driver){
		element = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
		return element;
	}
	
	public static WebElement new_users_account_type_select_account_link(WebDriver driver){
		element = driver.findElement(By.linkText("Pole Star Space Applications Ltd"));
		return element;
	}
	
	public static WebElement new_users_role(WebDriver driver){
		element = driver.findElement(By.id("form__item__user_profile_role"));
		return element;
	}
	
	public static WebElement new_users_role_administrator(WebDriver driver){
		element = driver.findElement(By.xpath("//option[2]"));
		return element;
	}
	
	public static WebElement new_users_role_validation_message(WebDriver driver){
		element = driver.findElement(By.xpath("//form/div/ul/li[5]"));
		return element;
	}
	
	public static WebElement new_users_mobile_phone(WebDriver driver){
		element = driver.findElement(By.id("form__item__user_profile_mobile_phone_number"));
		return element;
	}
	
	public static WebElement new_users_office_phone_number(WebDriver driver){
		element = driver.findElement(By.id("form__item__user_profile_office_phone_number"));
		return element;
	}
	
	public static WebElement new_users_office_phone_extension(WebDriver driver){
		element = driver.findElement(By.id("form__item__user_profile.office_phone_extension"));
		return element;
	}
	
	public static WebElement new_users_choose_language(WebDriver driver){
		element = driver.findElement(By.id("form__item__user_profile_language"));
		return element;
	}
	
	public static WebElement new_users_language_chosen_english(WebDriver driver){
		element = driver.findElement(By.xpath("//option[@value='en-gb']"));
		return element;
	}
	
	public static WebElement users_save_button(WebDriver driver){
		element = driver.findElement(By.name("submit"));
		return element;
	}
	
	public static WebElement users_search_created_user(WebDriver driver) {
		element = driver.findElement(By.xpath("//form/div/div/input"));
		return element;
	}
	
	public static WebElement users_add_services_page(WebDriver driver) {
		element = driver.findElement(By.cssSelector("h3.slim.aligned"));
		return element;
	}
	
	public static WebElement users_add_services_page_done(WebDriver driver) {
		element = driver.findElement(By.name("done"));
		return element;
	}
	
	public static WebElement users_sort_by_name(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[2]/div[2]/button"));
		return element;
	}
	
	public static WebElement users_search_by_most_recently_added(WebDriver driver) {
		element = driver.findElement(By.linkText("Sort by most recently added"));
		return element;
	}
	
	public static WebElement users_select_the_user_created(WebDriver driver) {
		element = driver.findElement(By.cssSelector("div.col-sm-12"));
		return element;
	}
	
	public static WebElement users_search_text(WebDriver driver) {
		element = driver.findElement(By.cssSelector("h3.slim.aligned"));
		return element;
	}
	
	public static WebElement delete_user(WebDriver driver) {
		element = driver.findElement(By.name("delete"));
		return element;
	}
	
	public static WebElement delete_user_modal(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[3]/button[2]"));
		return element;
	}
	
	public static WebElement user_deleted(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.empty > p"));
		return element;
	}
	
	
}

