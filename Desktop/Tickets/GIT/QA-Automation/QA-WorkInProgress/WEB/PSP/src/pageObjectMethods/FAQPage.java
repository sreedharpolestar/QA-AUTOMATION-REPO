package pageObjectMethods;

/*import modules.HighlightElement;
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import scriptResources.*;
import administration.*;

public class FAQPage {

	
	private static WebElement element = null;

	public static WebElement FAQLink(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#header__content-nav > div.application__top-menu > ul > li.link > a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement title(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#toc > ul > li.tree-node.tree-node-leaf.tree-node-selected > div > span > a > img"));
		
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement title_header(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("body > p:nth-child(5)"));
		
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	

	public static WebElement text_message(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//html/body/p[3]"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement email(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//html/body/div[2]/table/tbody/tr/td[2]/p[2]/a"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement companyInfo(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//html/body/div[2]/table/tbody/tr/td[3]/p[1]"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement contents(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#toc > ul > li:nth-child(2) > div > span > a"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement howto(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#toc > ul > li:nth-child(5) > div > span > a > img"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	

	
	
	
	public static WebElement howto_header(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//html/body/h1"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;	
	}
	
	
	public static WebElement about(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ul/li[4]/div/span/a"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement revision(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ul/li[3]/div/span/a"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
/*	(By.xpath("//form/div/ul/li[2]"));*/
	
	public static WebElement downloads(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#toc > ul > li:nth-child(7) > div > span > a"));			
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	
	public static WebElement downloads_header(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//html/body/h1"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement index(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#IndexTab > div > span.tabs-nav-text"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement glossary(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#GlossaryTab > div > span.tabs-nav-icon.active"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement search_glossary(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#search-glossary"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement search_result(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#glossary > ul > li:nth-child(4) > div > span > a > span"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	
}
