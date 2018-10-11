/**
 * 
 */
/**
 * 
 *
 */
package pageObjectMethods;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import modules.HighlightElement;

public class Account {
	private static WebElement element = null;

	public static WebElement accounts_menu(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("div.title"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement accounts_text_header(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("h3.slim.aligned"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement new_account_button(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement save_button(WebDriver driver) throws Throwable {
		element = driver.findElement(By.name("submit"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement account_type_list(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__account_type"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement account_type_is_required_validation_text(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("div.alert.alert-danger > ul > li"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement sap_customer_code_is_required_validation_text(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//form/div/ul/li[2]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement account_name_is_required_validation_text(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//form/div/ul/li[3]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement account_type(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__account_type"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement sap_customer_code(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__code"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement account_name(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__company_name"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement address_line_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__postal_address_line_1"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement address_line_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__postal_address_line_2"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement town_city(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__postal_address_city"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement post_code(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__postal_address_post_code"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement state(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__postal_address_state"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement country(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__country"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement fax(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__facsimile"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement telephone(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__telephone"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}



}