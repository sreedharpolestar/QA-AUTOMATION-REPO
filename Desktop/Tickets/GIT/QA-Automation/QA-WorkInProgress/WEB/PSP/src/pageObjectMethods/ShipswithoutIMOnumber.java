package pageObjectMethods;

/*import modules.HighlightElement;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import scriptResources.*;
import administration.*;

public class ShipswithoutIMOnumber {
	private static WebElement element = null;
	
	public static WebElement ships_menu(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[4]/a/div"));
		return element;
	}
	
	public static WebElement ships_menu_click(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("//div[4]/a/div"));
		return element;
	}
	
	public static WebElement ships_header_title(WebDriver driver){
		element = driver.findElement(By.xpath("//div[2]/div/div[1]/div/h3"));
		
		return element;
	}
		
	public static WebElement register_ship_button(WebDriver driver){
		element = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
		return element;
	}
	
	public static WebElement register_ship_title(WebDriver driver){
		element = driver.findElement(By.cssSelector("h3.wizard-title.normal"));
		return element;
	}
	/****************REGISTER SHIP WITHOUT IMO NUMBER***************/
	public static WebElement ships_without_IMO_number_menu_text(WebDriver driver){
		element = driver.findElement(By.xpath("//a[2]/h5"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_title(WebDriver driver){
		element = driver.findElement(By.cssSelector("h3.wizard-title.normal"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_ship_name(WebDriver driver){
		element = driver.findElement(By.name("ship_name"));
		return element;
	}

	public static WebElement ships_without_IMO_number_register_page_ship_name_validation_message(WebDriver driver){
		element = driver.findElement(By.cssSelector("ul.list-unstyled > li"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_ship_type(WebDriver driver){
		element = driver.findElement(By.cssSelector("#ship-register__ship-form__stat_code_5"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_ship_type_validation_message(WebDriver driver){
		element = driver.findElement(By.xpath("//form/div[3]/div[2]/ul/li"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_ship_type_text_selected(WebDriver driver){
		element = driver.findElement(By.xpath("//li/div"));
		return element;
	}
		
	public static WebElement ships_without_IMO_number_register_page_ship_type_selected(WebDriver driver){
		element = driver.findElement(By.id("ship-register__ship-form__stat_code_5"));
		return element;
	}
		
	public static WebElement ships_without_IMO_number_register_page_registered_owner(WebDriver driver){
		element = driver.findElement(By.name("registered_owner"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_registered_owner_validation_messgae(WebDriver driver){
		element = driver.findElement(By.xpath("//div[4]/div/ul/li"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_ship_manager(WebDriver driver){
		element = driver.findElement(By.name("ship_manager"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_ship_manager_validation_message(WebDriver driver){
		element = driver.findElement(By.xpath("//div[5]/div/ul/li"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_ship_operator(WebDriver driver){
		element = driver.findElement(By.name("operator"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_ship_operator_validation_message(WebDriver driver){
		element = driver.findElement(By.xpath("//div[6]/div/ul/li"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_flag(WebDriver driver){
		element = driver.findElement(By.name("flag"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_flag_selected(WebDriver driver){
		element = driver.findElement(By.xpath("//div[7]/div/div/ul/li/div"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_flag_input(WebDriver driver){
		element = driver.findElement(By.id("ship-register__ship-form__flag"));
		return element;
	}
	
/*	public static WebElement ships_without_IMO_number_register_page_flag_data_selected(WebDriver driver){
		element = driver.findElement(By.xpath("//div[8]/div/input"));
		return element;
	}*/
	
	public static WebElement ships_without_IMO_number_register_page_MMSI_number(WebDriver driver){
		element = driver.findElement(By.name("mmsi"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_call_sign(WebDriver driver){
		element = driver.findElement(By.name("call_sign"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_ship_page_next(WebDriver driver){
		element = driver.findElement(By.xpath("//div[3]/div/div/div/div[2]/button"));
		return element;
	}

	public static WebElement ships_without_IMO_number_select_account(WebDriver driver){
		element = driver.findElement(By.xpath("//div[3]/div/h5"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_account_selected(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.col-sm-12 > h4"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_account_fleet_count(WebDriver driver){
		element = driver.findElement(By.cssSelector("span.td"));
		return element;
	}
		
	public static WebElement ships_without_IMO_number_select_fleet(WebDriver driver){
		element = driver.findElement(By.xpath("//a/div/div/div[2]/div[2]/div"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_select_fleet_selected(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.col-sm-12 > h4"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_select_fleet_validation_message(WebDriver driver){
		element = driver.findElement(By.cssSelector("ul.list-unstyled > li"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_transceiver_shipname_created(WebDriver driver){
		element = driver.findElement(By.xpath("//h3/span[2]"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_transceiver_model(WebDriver driver){
		element = driver.findElement(By.id("ship-register__transceiver-item__model"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_transceiver_model_selected(WebDriver driver){
		element = driver.findElement(By.xpath("//option[2]"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_model_validation_message(WebDriver driver){
		element = driver.findElement(By.cssSelector("ul.list-unstyled > li"));
		return element;
	}

	public static WebElement ships_without_IMO_number_register_transceiver_MMSI_validation_message(WebDriver driver){
		element = driver.findElement(By.cssSelector("ul.list-unstyled > li"));
		return element;
	}

	public static WebElement ships_without_IMO_number_register_transceiver_MMSI(WebDriver driver){
		element = driver.findElement(By.name("identifier_value"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_save(WebDriver driver){
		element = driver.findElement(By.xpath("//div[3]/div/div/div/div[2]/button"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_sort_by_name(WebDriver driver){
		element = driver.findElement(By.xpath("//div[2]/button/span[2]"));
		
		return element;
	}
	
	public static WebElement ships_without_IMO_number_search_most_recently_created_ship(WebDriver driver){
		element = driver.findElement(By.linkText("Sort by most recently added"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_search_most_recently_edited_ship(WebDriver driver){
		element = driver.findElement(By.linkText("Sort by most recently edited"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_search_field(WebDriver driver){
		element = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_search_field_ship_name(WebDriver driver){
		element = driver.findElement(By.xpath("//div/h4/span"));
		
		HighlightElement.highLightElement(driver, element);
		
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_account(WebDriver driver){
		element = driver.findElement(By.xpath("//div[2]/div/input"));
		HighlightElement.highLightElement(driver, element);
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_ship_name(WebDriver driver){
		element = driver.findElement(By.id("form__item__ship.ship_name"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_editship_name(WebDriver driver){
		element = driver.findElement(By.cssSelector("#form__item__ship\2e ship_name"));
		return element;
	}	
	
	public static WebElement ships_without_IMO_number_verify_ship_type(WebDriver driver){
		element = driver.findElement(By.id("form__item__ship.ship_type"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_ship_fleet(WebDriver driver){
		element = driver.findElement(By.id("form__item__fleet"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_registered_owner(WebDriver driver){
		element = driver.findElement(By.id("form__item__ship.registered_owner"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_ship_manager(WebDriver driver){
		element = driver.findElement(By.id("form__item__ship.ship_manager"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_ship_operator(WebDriver driver){
		element = driver.findElement(By.id("form__item__ship.operator"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_ship_flag(WebDriver driver){
		element = driver.findElement(By.id("form__item__ship_flag"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_ship_flag_remove(WebDriver driver){
		element = driver.findElement(By.xpath("/div/form/div/div[10]/div/div/button[1]"));
		
		return element;
	}
	
	//*[@id="application"]/div[2]/div[2]/div[2]/div[2]/div/div[2]
	
	
	
	public static WebElement ships_without_IMO_number_ship_flag_united_kingdom(WebDriver driver){
		element = driver.findElement(By.cssSelector("#form__item__ship_flag"));	
		
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_ship_MMSI_number(WebDriver driver){
		element = driver.findElement(By.id("form__item__ship.mmsi"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_ship_call_sign(WebDriver driver){
		element = driver.findElement(By.id("form__item__ship.call_sign"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_verify_ship_stat_code_5(WebDriver driver){
		element = driver.findElement(By.id("form__item__ship.stat_code_5"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_edit_save(WebDriver driver){
		element = driver.findElement(By.xpath("//button[@name='submit']"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_delete_ship(WebDriver driver){
		element = driver.findElement(By.xpath("//button[@name='delete']"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_delete_OK(WebDriver driver){
		element = driver.findElement(By.xpath("//div[3]/button[2]"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_ship_not_found(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.empty > p"));
		return element;
	}
}
