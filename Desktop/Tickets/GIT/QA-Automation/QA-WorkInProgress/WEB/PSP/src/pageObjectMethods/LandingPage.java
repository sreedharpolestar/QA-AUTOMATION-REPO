/**
 * 
 */
package pageObjectMethods;

/*import modules.HighlightElement;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import scriptResources.*;
import administration.*;

/**
 * @author sreedhar.popuri
 *
 */
public class LandingPage {
	
	private static WebElement element = null;

	public static WebElement Layertools_Icon(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#map > div.leaflet-control-container > div.leaflet-top.leaflet-right > div.leaflet-control-sidebar-toggle.layers.leaflet-control > a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_Header(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#layers-sidebar > div.sidebar-header"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	

	public static WebElement Layertools_options_Terrain(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[1]/img"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement Layertools_options_Streets(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[2]/img"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_options_Satellite(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[3]/img"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_options_Cmap(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[4]/img"));	
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	public static WebElement Layertools_Overlay(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#overlays-section > div.panel-heading > h4"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement Layertools_Overlay_expand(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#overlays-section > div.panel-heading > div"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_Overlay_Lables_checckbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[1]/label/input"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement Layertools_Overlay_Latitude_checkbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[2]/label/input"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	public static WebElement Layertools_Overlay_Bathymetry_checkbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[3]/label/input"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_Overlay_Cyclones_checkbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[4]/label/input"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_MeteorologicalLayers(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers-section > div.panel-heading > h4"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	public static WebElement Layertools_MeteorologicalLayers_rangeslider(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers > div > div.range-slider-container > div > div > div > div"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_MeteorologicalLayers_expand(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers-section > div.panel-heading > div"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_MeteorologicalLayers_Seasurface_checckbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers > div > div:nth-child(2) > label > span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement Layertools_MeteorologicalLayers_Primary_checckbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers > div > div:nth-child(3) > label > span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_MeteorologicalLayers_Primaryandperiod_checckbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers > div > div:nth-child(4) > label > span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_MeteorologicalLayers_Windwave_checckbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers > div > div:nth-child(5) > label > span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_MeteorologicalLayers_Swell_checckbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers > div > div:nth-child(6) > label > span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_MeteorologicalLayers_Windspeed_checckbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers > div > div:nth-child(7) > label > span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_MeteorologicalLayers_Winddirection_checckbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers > div > div:nth-child(8) > label > span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement Layertools_MeteorologicalLayers_Presssure_checckbox(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#meteorological-layers > div > div:nth-child(9) > label > span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement close(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div[2]/a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
}
