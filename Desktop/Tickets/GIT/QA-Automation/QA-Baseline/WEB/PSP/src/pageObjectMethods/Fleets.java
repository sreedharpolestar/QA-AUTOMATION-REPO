package pageObjectMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Fleets {

	private static WebElement element = null;
	
	public static WebElement fleets_menu(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[3]/a/div"));
		return element;
	}
	
	
	public static WebElement fleets_header_title(WebDriver driver){
		element = driver.findElement(By.cssSelector("h3.slim.aligned"));
		return element;
	}
	
	public static WebElement new_fleets_button(WebDriver driver){
		element = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
		return element;
	}
	
	public static WebElement new_fleets_page_title(WebDriver driver){
		element = driver.findElement(By.cssSelector("h3.slim.aligned"));
		return element;
	}
	
	public static WebElement new_fleets_name(WebDriver driver){
		element = driver.findElement(By.id("form__item__name"));
		return element;
	}
	
	public static WebElement new_fleets_name_required_validation_messgae(WebDriver driver){
		element = driver.findElement(By.xpath("//form/div/ul/li"));
		return element;
	}
		
	public static WebElement new_fleets_account(WebDriver driver){
		element = driver.findElement(By.id("form__item__account"));
		return element;
	}
	
	public static WebElement new_fleets_account_remove(WebDriver driver){
		element = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
		return element;
	}
	
	public static WebElement new_fleets_account_field_search(WebDriver driver){
		element = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
		return element;
	}
	
	public static WebElement new_fleets_account_field_save(WebDriver driver){
		element = driver.findElement(By.name("submit"));
		return element;
	}
	
	public static WebElement select_account(WebDriver driver){
		element = driver.findElement(By.xpath("(//a[contains(@href, '#')])[38]"));
		return element;
	}
	
	public static WebElement account(WebDriver driver){
		element = driver.findElement(By.cssSelector("span.form-control.readonly"));
		return element;
	}
	

	public static WebElement No_fleet_found(WebDriver driver){
		element = driver.findElement(By.xpath("//div[2]/div/div/p"));
		return element;
	}
	
	/*public static WebElement modal_close_ok(WebDriver driver){
		element = driver.findElement(By.xpath("//div[3]/button[2]"));
		return element;
	}*/
}
