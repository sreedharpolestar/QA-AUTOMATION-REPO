package pageObjectMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ships {
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
		element = driver.findElement(By.cssSelector("h3.slim.aligned"));
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
	
	public static WebElement ships_without_IMO_number_register_page_ship_type(WebDriver driver){
		element = driver.findElement(By.name("stat_code_5"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_registered_owner(WebDriver driver){
		element = driver.findElement(By.name("registered_owner"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_ship_manager(WebDriver driver){
		element = driver.findElement(By.name("ship_manager"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_ship_operator(WebDriver driver){
		element = driver.findElement(By.name("operator"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_flag(WebDriver driver){
		element = driver.findElement(By.name("flag"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_MMSI_number(WebDriver driver){
		element = driver.findElement(By.name("mmsi"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_page_call_sign(WebDriver driver){
		element = driver.findElement(By.name("call_sign"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_ship_page_cancel(WebDriver driver){
		element = driver.findElement(By.xpath("//div[3]/button"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_register_ship_page_next(WebDriver driver){
		element = driver.findElement(By.xpath("//div[3]/div/div/div/div[2]/button"));
		return element;
	}
	
	public static WebElement ships_without_IMO_number_select_account_title(WebDriver driver){
		element = driver.findElement(By.cssSelector("h3.wizard-title.normal"));
		return element;
	}
	
	
}
