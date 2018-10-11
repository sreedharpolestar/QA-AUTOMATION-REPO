/**
 * 
 */
/**
 * @author collins.obasuyi
 *
 */
package pageObjectMethods;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Contact 
{
	private static WebElement element = null;

	public static WebElement contact_menu(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.xpath("//div[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div[5]/a/div"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement contact_text_header(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.cssSelector("h3.slim.aligned"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement new_contact_button(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.xpath("//li[2]/div/button"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement title(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.id("form__item__title"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement first_name(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.id("form__item__first_name"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement first_name_validation_message(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.xpath("//form/div/ul/li"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement last_name(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.id("form__item__last_name"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement last_name_validation_message(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.xpath("//form/div/ul/li[2]"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement company(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.id("form__item__company"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement company_validation_message(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.xpath("//div[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/form/div/ul/li[3]"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement flag(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.id("form__item__flag"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement select_flag(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.linkText("United Kingdom"));
		Thread.sleep(1000);return element; 
	}

	public static WebElement email_address(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.id("form__item__email_address"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement mobile_number(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.id("form__item__mobile_number"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement fax_number(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.id("form__item__fax_number"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement telex_number(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.id("form__item__telex_number"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement is_cso(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.id("form__item__is_cso"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement contacts_validation_message(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.xpath("//div[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/form/div/ul/li[4]"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement contact_link(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.linkText("Contacts"));
		Thread.sleep(1000);return element; 
	}
	
	public static WebElement no_contact_found(WebDriver driver) throws Throwable
	{
		element = driver.findElement(By.cssSelector("div.empty > p"));
		Thread.sleep(1000);return element; 
	}

}