package com.ps.maven.utils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class BrowserTypes extends LoggingFactory {

	private static String binaryPath;
	public static WebDriver driver;

	public BrowserTypes() {
		binaryPath = getProps().getProperty("binaryPath");

		verbose("BrowserTypes class instanciated");
	}

	public static WebDriver setDriver(String browser) {


		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\DriversBinaries\\geckodriver.exe");
			driver = new FirefoxDriver();
			//profile.setEnableNativeEvents(true);
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\DriversBinaries\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\DriversBinaries\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			error("Browser type is unknown. terminating the tests for >>>>>>>" + browser);
			System.exit(1);

		}

		verbose("Launching " + browser + " browser for tests..");
		return driver;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public void waitExplicitly(int seconds) {

		try {

			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}
	public List<WebElement> getElements(By locator) {

		List<WebElement> elements = getDriver().findElements(locator);
		return elements;
	}
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		int numberOfElements = getElements(locator).size();


		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(getDriver()).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		if (numberOfElements == 1) {
			for (int i = 0; i < 3; i++) {

				element = getDriver().findElement(locator);

			}
		} else if (numberOfElements == 0) {

			error("Element cannot be located on the page. Locator used '" + locator.toString()
					+ "'.Number of elements found..." + numberOfElements);
			fwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			fwait.until(ExpectedConditions.elementToBeClickable(locator));
			element = getDriver().findElement(locator);

		} else {
			error("There are more than one elements on the page. Locator used '" + locator.toString()
					+ "'.\n Number of elements found..." + numberOfElements);
			element = getDriver().findElement(locator);
		}

		
		return element;

	}
	
	public static void tearDown() throws InterruptedException{
		if (getDriver() != null){
			verbose("Tearing down the test setup...");
			getDriver().quit();
			
		}
	}
	public static int randInt(int min, int max) {

		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
	
	
	
}
