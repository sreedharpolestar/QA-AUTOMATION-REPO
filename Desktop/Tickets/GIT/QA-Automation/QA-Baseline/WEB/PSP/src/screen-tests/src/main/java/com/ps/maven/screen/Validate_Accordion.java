package com.ps.maven.screen;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.ps.maven.utils.BrowserTypes;

public class Validate_Accordion extends BrowserTypes {
	By Latest_Screening_results = By.xpath("//div/div/ps-accordion/div/ps-accordion-item[1]/div[1]/h4/div");
	By Screening_history = By.xpath("//div/ps-accordion/div/ps-accordion-item[2]/div[1]/h4/div");
	By Ship_information = By.xpath("//div/ps-accordion/div/ps-accordion-item[3]/div[1]/h4/div");
	
	
	
	public boolean Validate_accordion_Latest_screening_results(){
		verbose("clicking on the Latest Screening Results");
		waitExplicitly(5);
		
		
	getElement(Latest_Screening_results).click();
	verbose("clicked on the Latest Screening results");
	waitExplicitly(5);
	String attr = getElement(Latest_Screening_results).getAttribute("class");
	verbose("The attr is :"+ attr);
	waitExplicitly(5);
	getElement(Latest_Screening_results).click();
	if(attr.equals("ps-accordion-item__icon fa fa-plus"))
	{
		verbose("The Latest Screening results accordion is expandded");
		return true;
	}
	else {
		verbose("The accordion is not clicked and expanded");
		return false;
	}	
	}
	
public boolean Validate_accordion_Screening_history(){
	verbose("clicking on the Screening history");
	waitExplicitly(5);
getElement(Screening_history).click();

verbose("Clicked on the Screening history");

String attr = getElement(Screening_history).getAttribute("class");
waitExplicitly(5);
if(attr.equals("ps-accordion-item__icon fa fa-minus"))
{
	verbose("The Screening history accordion is expandded");
	return true;
}
else {
	verbose("The accordion is not clicked and expanded");
	return false;
}	
}	
	
public boolean Validate_accordion_Ship_information(){
	
	verbose("clicking on the Ship Information accordion");
	waitExplicitly(5);
getElement(Ship_information).click();
verbose("Clicked on the Ship information");

String attr = getElement(Ship_information).getAttribute("class");
verbose("The attribute is :" + attr);
waitExplicitly(5);
if(attr.equals("ps-accordion-item__icon fa fa-minus"))
{
	verbose("The Ship information accordion is expandded");
	return true;
}
else {
	verbose("The accordion is not clicked and expanded");
	return false;
}	
}

	

}
