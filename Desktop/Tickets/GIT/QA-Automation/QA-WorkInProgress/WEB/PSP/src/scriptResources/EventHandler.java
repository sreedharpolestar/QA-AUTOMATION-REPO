package scriptResources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler  implements WebDriverEventListener{
	
	
	

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		
		System.out.println("Inside method afterChangingValueOf on"+arg0.toString());
	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("Found element on"+arg1.toString()+ "Using method  "+arg0.toString());
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("Inside the after navigate back to "+arg0.getCurrentUrl());
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		//
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		System.out.println("Changing the value of the element.."+arg0.toString());
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("Just before finding element " + arg1.toString());
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("Clicked on"+arg0.toString());
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("Going to click on .."+arg0.toString());
		
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		System.out.println("Error!!! Exception occured at >>>>>>>>>>>>>>>> " + arg0.getMessage());
		
	}

}
