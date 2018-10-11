package pageObjectMethods;

/*import modules.HighlightElement;*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import scriptResources.*;
import administration.*;
public class Notifications {
	
	public static WebElement element = null;
	
	public static WebElement notofications_module(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("(/html/body/psp-app/secondary-nav/ul/li[4]/a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
}

	public static WebElement notofications_default(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("(/html/body/psp-app/secondary-nav/ul/li[4]/a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement new_notification(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("(//ps-notification-index/div/div/div[1]/h3"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
}
}
	