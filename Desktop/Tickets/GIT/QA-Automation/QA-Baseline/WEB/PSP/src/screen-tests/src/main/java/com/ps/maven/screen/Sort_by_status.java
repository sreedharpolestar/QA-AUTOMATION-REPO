package com.ps.maven.screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ps.maven.utils.BrowserTypes;

public class Sort_by_status extends BrowserTypes {
	
	By Status_header = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/header/div[6]/span[1]");
  By Status_sort_icon = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/header/div[6]/span[2]");

	public boolean header_check() {
		// TODO Auto-generated method stub
		verbose("Going to check whether the Status column is present");
		Assert.assertEquals(getElement(Status_header).getText(),"Status");
		verbose("Going to check the status icon tooltip");
		String xpath = "//psp-core/div/ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row/ps-data-table-cell[5]";
		List list=driver.findElements(By.xpath(xpath));
		waitExplicitly(2);
		for(int i=1;i<=list.size();i++) {
			By xpath2 = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row["+ i +"]/ps-data-table-cell[5]/i");
			By xpath1 = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row["+ i +"]/ps-data-table-cell[5]");
			waitExplicitly(1);
			Actions action = new Actions(driver);
			action.moveToElement(getElement(xpath1)).build().perform();
			waitExplicitly(3);
			verbose("The size is " + list.size());
			String local = getElement(xpath1).getAttribute("title");
			verbose(local);
			String local1 = getElement(xpath2).getAttribute("class");
			verbose(local1);
			
			if((local.equals("Screening complete") && local1.equals("ps-i-complete ng-star-inserted")) 
					|| (local.equals("Screening in progress") && local1.equals("ps-i-processing ng-star-inserted"))
					|| (local.equals("Screening queued") && local1.equals("ps-i-queued ng-star-inserted")))
					
			{
				verbose("The icon and tooltip of status is correct");
			}
			else {
				verbose("The icon and tooltip is INCORRECT");
			}
		}
		
		return true;
	}



	public boolean ascending_check() {
		
		if(!getElement(Status_sort_icon).getAttribute("class").equals("header-cell__icon fa ng-star-inserted fa-sort-asc"))
				{
			verbose("going to validate the status column in ascending order");
			getElement(Status_sort_icon).click();
			/*List<WebElement> myList= driver.findElements(By.tagName("ps-screening-severity"));
			List<String> all_elements_text = new ArrayList<String>();
			for(int i=1; i<myList.size(); i++){

		        //loading text of each element in to array all_elements_text
		        all_elements_text.add(myList.get(i).getText());

		        //to print directly
		        verbose("The status of all rows are ::::::: " +myList.get(i).getText());

		    }*/
			return true;
				}
		else {
			return false;
		}
	}
		
		
		
		
		

	public boolean descending_order() {
		// TODO Auto-generated method stub
		if(!getElement(Status_sort_icon).getAttribute("class").equals("header-cell__icon fa ng-star-inserted fa-sort-desc"))
				{
			verbose("going to validate the status column in ascending order");
			getElement(Status_sort_icon).click();
			return true;
				}
		else {
			return false;
		}
	
	}
}	

/*package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		sortRecordStatus();
	}*/

/*	private static void sortRecordStatus() {
		List<String> records = new ArrayList<>();
		records.add("BAD");
		records.add("OK");
		records.add("WORST");
		records.add("OK");
		records.add("BAD");
		records.add("OK");
		records.add("WORST");

		System.out.println("Unsorted list:-"+records);

		records.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int statusValueS1 = RecordStatus.valueOf(s1).getStatus();
				int statusValueS2 = RecordStatus.valueOf(s2).getStatus();
				if (statusValueS1 == statusValueS2) {
					return 0;
				} else if (statusValueS1 > statusValueS2) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		System.out.println("Sorted list:-"+records);


	}
}*/


	/*public class Comparator(String) {
	enum Severity { Critical, Warning, OK, Unknown }

	Low.compareTo(High);   // returns -1
	Medium.compareTo(Low); // returns 1
		
	
	}
	
	

	public class SeverityComparator implements Comparator<String> {
	     private int direction;

	     public SeverityComparator(boolean reverse) {
	         this.direction = reverse ? -1 : 1;
	     }

	     private int severity(String s) {
	         if (s.equals("Low")) { // you really should have constants for the values...
	             return 0;
	         } else if (s.equals("Medium")) {
	             return 1;
	         } else if (s.equals("High")) {
	             return 2;
	         } else {
	             throw new IllegalArgumentException("Not a severity: " + s);
	         }
	     }

	     @Override
	     public int compareTo(String other) {
	         return direction * (severity(this) - severity(other));
	     }
	}
*/