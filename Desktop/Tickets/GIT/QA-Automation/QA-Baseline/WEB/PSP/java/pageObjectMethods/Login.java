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

import modules.HighlightElement;

public class Login {
	public static WebElement element = null;

	public static WebElement username(WebDriver driver) throws Throwable {
		element = driver.findElement(By.name("username"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement password(WebDriver driver) throws Throwable {
		element = driver.findElement(By.name("password"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement login_button(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//form/button"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement invalid_email_password_validation_message(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("div.alert.alert-danger > ul > li"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement administration_text(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("li.admin > a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement administration_menu_link(WebDriver driver) throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Administration')]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}


}