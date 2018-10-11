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

public class Global 
{
	private static WebElement element = null;
	
	public static WebElement save_button(WebDriver driver)
	{element =  driver.findElement(By.name("submit"));return element;}
	
	public static WebElement search_textbox(WebDriver driver)
	{element =  driver.findElement(By.cssSelector("#ps-list-menu > ul > li:nth-child(1) > form > div > div > input"));return element;}
	
	
	
	public static WebElement deactivate(WebDriver driver)
	{element =  driver.findElement(By.cssSelector("button[name=\"delete\"]"));return element;}
	
	public static WebElement activate(WebDriver driver)
	{element =  driver.findElement(By.cssSelector("button[name=\"undelete\"]"));return element;}
	
	public static WebElement modal_ok(WebDriver driver)
	{element =  driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"));return element;}
	
	public static WebElement search_result(WebDriver driver)
	{element =  driver.findElement(By.xpath("//div[2]/h5"));return element;}
	
	
	
	public static WebElement done_button(WebDriver driver)
	{element =  driver.findElement(By.cssSelector("button[name=\"done\"]"));return element;}
	
	public static WebElement ship_next(WebDriver driver)
	{element =  driver.findElement(By.xpath("//div[3]/div/div/div/div[2]/button"));return element;}
	
	public static WebElement ships_cancel(WebDriver driver){
		element = driver.findElement(By.xpath("//div[3]/button"));
		return element;
	}
	
	public static WebElement Fleets_cancel(WebDriver driver){
		element = driver.findElement(By.xpath("//button[@name='cancel']"));
		return element;
	}
	
	public static WebElement ships_page_title(WebDriver driver){
		element = driver.findElement(By.cssSelector("h3.wizard-title.normal"));
		return element;
	}


}

