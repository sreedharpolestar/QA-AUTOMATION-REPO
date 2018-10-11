package helpFAQ;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import Notification_resources.BasePage;

import scriptResources.*;

public class Faq extends BasePage{

	public Faq(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By helpFAQlink = By.partialLinkText("Help/FAQ");
	By helpFAQContentTitle = By.xpath(".//html/body/p[3]/a[2]");
	
	public Boolean isHelpFAQAvailable(){
		// this method is okay, but the elements are not located by the selenium for some reasons. 
		// may be coz the page embeds too many divs 
		
		getElement(helpFAQlink).click();
		waitExplicitly(5);
		
		Boolean boo=false;
		
		if(getElements(helpFAQContentTitle).size()>0){
			boo=true;
			verbose(getElement(helpFAQContentTitle).getText());
		} else{
			error("Help and FAQ Document is not loaded");
		}
		
		return boo;
	}
	
	

}
