package reports;
/*package Reports;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjectMethods.Reports;

public class ascending_Decending {
	
	public static boolean chkalphabetical_order(LinkedList<String> report_names , WebDriver driver){
		
		//create an LinkedList instead of arraylist because it preserves insertion order

		WebElement reports_Webelement = (WebElement) new LinkedList<WebElement>();

		//store the products (web elements) into the linkedlist

		reports_Webelement = Reports.reports_name(driver);

		//create another linked list of type string to store image title

		LinkedList<String> product_names =  new LinkedList<String>();

		//loop through all the elements of the product_webelement list get it title and store it into the product_names list

		for(int i=0;i<products_Webelement.size();i++){

		    String s = products_Webelement.get(i).getAttribute("alt");

		    product_names.add(s);


		//send the list to chkalphabetical_order method to check if the elements in the list are in alphabetical order    

		boolean result = chkalphabetical_order(product_names);


		//print the result    

		System.out.println(result);

	    String previous = ""; // empty string

	    for (final String current: product_names) {
	        if (current.compareTo(previous) < 0)
	            return false;
	        previous = current;
	    }

	    return true;

	    }
}*/