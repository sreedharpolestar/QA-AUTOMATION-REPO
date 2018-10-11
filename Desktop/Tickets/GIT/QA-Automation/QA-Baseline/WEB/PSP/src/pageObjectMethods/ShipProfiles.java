package pageObjectMethods;

/*import modules.HighlightElement;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import scriptResources.*;
import administration.*;

public class ShipProfiles {
	
	private static WebElement element = null;

	public static WebElement shiprofiles_menu(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div/div[5]/a/div[1]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement shipprofiles_header(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ps-admin-ship-profile-index/div[1]/h3"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement firstdate(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ul/li[1]/ps-ship-profile-list-details/a/div/div[2]/div[3]/div[2]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement seconddate(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ul/li[2]/ps-ship-profile-list-details/a/div/div[2]/div[3]/div[2]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement thirddate(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ul/li[3]/ps-ship-profile-list-details/a/div/div[2]/div[3]/div[2]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement noprofiles_found(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div/ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[2]/div"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement sortr_recentlyadded(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ps-option-dropdown/div/button/span[1]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement sortr_byname(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#option-0"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement firstname(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ul/li[1]/ps-ship-profile-list-details/a/div/div[2]/div[1]/span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement secondname(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ul/li[2]/ps-ship-profile-list-details/a/div/div[2]/div[1]/span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	public static WebElement newprofile_button(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ps-admin-ship-profiles/ps-admin-ship-profile-index/div[2]/div[1]/div[1]/span/a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
}
