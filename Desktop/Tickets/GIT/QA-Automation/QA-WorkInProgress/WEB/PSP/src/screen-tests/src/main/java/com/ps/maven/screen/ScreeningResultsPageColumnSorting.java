package com.ps.maven.screen;

import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.itextpdf.text.log.LoggerFactory;
import com.ps.maven.utils.BrowserTypes;

import cucumber.runtime.Utils;

public class ScreeningResultsPageColumnSorting extends BrowserTypes{
	enum RecordStatus { 
		Critical, Warning, OK, Unknown;
		
	}
	//Unknown.compareTo(OK);   // returns -1
	//OK.compareTo(Warning); // returns 1
	//Warning.compareTo(Critical)	
	
	//}
	List<WebElement> myList;
	List<String>local;
	By flag_column_header = By.xpath("//span[contains(.,'Flag')]");
	By ship_type_column_header = By.xpath("//span[contains(.,'Ship type')]");
	By ship_name_header = By.xpath("//span[contains(.,'Ship name')]");
	By IMO_header = By.xpath("//span[contains(.,'IMO')]");
	By last_updated = By.xpath("//span[contains(.,'Last updated (UTC)')]");
	By Latest_result_icon = By.xpath("//span[contains(.,'Latest result')]//following::span[1]");
	Common_methods ship_count = new Common_methods();

	public boolean ship_name_ascending_sorting(){

		//getDriver().navigate().refresh();
		int count = 0;
		waitExplicitly(2);


		String attr = getElement(ship_name_header).getAttribute("class");
		logger.info("The attr is :: " + attr);

		if(!attr.equals("header-cell__icon fa fa-sort-asc")){
			logger.info("Clicking on the ship name to sort in ascending order"); 
			getElement(ship_name_header).click();
		}else{
			logger.info("Ship Name is already sorted in Ascending order continue the check");
		}

		waitExplicitly(2);

		By first_ship = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[2]/a");
		
		String first_ship1 = getElement(first_ship).getText();
		String a = first_ship1.toLowerCase().replaceAll("\\s","");

		for(int i = 2; i <= ship_count.ship_count();i++){
			By second_ship = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[2]/a");
			String second_ship1 = getElement(second_ship).getText();
			String b = second_ship1.toLowerCase().replaceAll("\\s","");
			if(a.compareToIgnoreCase(b) < 0 || a.compareToIgnoreCase(b) == 0){
				logger.info( first_ship1 + " is sorted before " + second_ship1);
				count++;				
			}else{
				logger.info( first_ship1 + " is NOT sorted before " + second_ship1);
			}

			first_ship1 = second_ship1;
		}


		if(count+1 == ship_count.ship_count()){
			logger.info("The Ship name is sorted in Ascending order");
			return true;
		}else{
			logger.info("The Ship name is NOT sorted in Ascending order");
			return false;
		}

	}

	public boolean ship_name_descending_sorting(){

		//getDriver().navigate().refresh();
		int count = 0;

		waitExplicitly(2);


		String attr = getElement(ship_name_header).getAttribute("class");
		logger.info("The attr is :: " + attr);

		if(!attr.equals("header-cell__icon fa fa-sort-desc")){
			logger.info("Clicking on the ship name to sort in Descending order"); 
			getElement(ship_name_header).click();
		}else{
			logger.info("Ship name column is already sorted in Descending order continue the check");
		}

		waitExplicitly(2);

		By first_ship = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[2]/a");
		
		String first_ship1 = getElement(first_ship).getText();
		String a = first_ship1.toLowerCase().replaceAll("\\s","");
		for(int i = 2; i <= ship_count.ship_count();i++){
			By second_ship = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[2]/a");
			String second_ship1 = getElement(second_ship).getText();
			String b = second_ship1.toLowerCase().replaceAll("\\s","");
			if(a.compareToIgnoreCase(b) > 0 || a.compareToIgnoreCase(b) == 0){
				logger.info( first_ship1 + " is sorted before " + second_ship1);
				count++;				
			}else{
				logger.info( first_ship1 + " is NOT sorted before " + second_ship1);
			}

			first_ship1 = second_ship1;
		}


		if(count+1 == ship_count.ship_count()){
			logger.info("The Ship name is sorted in Descending order");
			return true;
		}else{
			logger.info("The Ship name is NOT sorted in Descending order");
			return false;
		}

	}

	public boolean IMO_ascending_sorting(){

		//getDriver().navigate().refresh();
		int count = 0;
		waitExplicitly(2);
		String attr = getElement(IMO_header).getAttribute("class");
		logger.info("The attr is :: " + attr);

		if(!attr.equals("header-cell__icon fa ng-star-inserted fa-sort-asc")){
			logger.info("Clicking on the IMO column to sort in acsending order"); 
			getElement(IMO_header).click();
		}else{
			logger.info("IMO column is already sorted in Ascending order continue the check");
		}

		waitExplicitly(2);

		By first_IMO = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[3]");
		
		String first_IMO1 = getElement(first_IMO).getText();
		logger.info("The first IMO number in descending order is ::" + first_IMO1);
		for(int i = 2; i <= ship_count.ship_count();i++){
			By second_IMO = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[3]");
			String second_IMO1 = getElement(second_IMO).getText();
			if(first_IMO1.compareToIgnoreCase(second_IMO1) < 0 || first_IMO1.compareToIgnoreCase(second_IMO1) == 0){
				logger.info( first_IMO1 + " is sorted before " + second_IMO1);
				count++;				
			}else{
				logger.info( first_IMO1 + " is NOT sorted before " + second_IMO1);
			}

			first_IMO1 = second_IMO1;
		}

		if(count+1 == ship_count.ship_count()){
			logger.info("The IMO is sorted in Ascending order");
			return true;
		}else{
			logger.info("The IMO is NOT sorted in Ascending order");
			return false;
		}

	}

	public boolean IMO_descending_sorting(){

		//getDriver().navigate().refresh();
		int count = 0;

		waitExplicitly(2);


		String attr = getElement(IMO_header).getAttribute("class");
		logger.info("The attr is :: " + attr);

		if(!attr.equals("header-cell__icon fa ng-star-inserted fa-sort-desc")){
			logger.info("Clicking on the IMO to sort in Descending order"); 
			getElement(IMO_header).click();
		}else{
			logger.info("IMO column is already sorted in descending order continue the check");
		}

		waitExplicitly(2);

		By first_IMO = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[3]");
		
		String first_IMO1 = getElement(first_IMO).getText();
		logger.info("The first IMO number in descending order is ::" + first_IMO1);
		for(int i = 2; i <= ship_count.ship_count();i++){
			By second_IMO = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[3]");
			String second_IMO1 = getElement(second_IMO).getText();
			if(first_IMO1.compareTo(second_IMO1) > 0 || first_IMO1.compareTo(second_IMO1) == 0){
				logger.info( first_IMO1 + " is sorted before " + second_IMO1);
				count++;				
			}else{
				logger.info( first_IMO1 + " is NOT sorted before " + second_IMO1);
			}

			first_IMO1 = second_IMO1;
		}


		if(count+1 == ship_count.ship_count()){
			logger.info("The IMO is sorted in Descending order");
			return true;
		}else{
			logger.info("The IMO is NOT sorted in Descending order");
			return false;
		}
	}

	public boolean Ship_Type_ascending_sorting(){

		//getDriver().navigate().refresh();
		int count = 0;
		waitExplicitly(2);


		waitExplicitly(2);

		String attr = getElement(ship_type_column_header).getAttribute("class");
		logger.info("The attr is :: " + attr);

		if(!attr.equals("header-cell__icon fa fa-sort-asc")){
			logger.info("Clicking on the Ship Type column to sort in ascending order"); 
			getElement(ship_type_column_header).click();
		}else{
			logger.info("Ship Type column is already sorted in Ascending order continue the check");
		}

		waitExplicitly(2);
		By first_ship_type = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[4]");
		
		String first_ship_type1 = getElement(first_ship_type).getText();
		//String first = first_ship_type1.split("\\(","\\\");
		String new_first = first_ship_type1.replace("(,),/","");
		logger.info("The first ship type in ascending order is : " + first_ship_type1);
		for(int i = 2; i <= ship_count.ship_count();i++){
			By second_ship_type = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[4]");
			String second_ship_type1 = getElement(second_ship_type).getText();
			String new_second = second_ship_type1.replace("(,),/","");
			if(new_first.compareToIgnoreCase(new_second) < 0 || new_first.compareToIgnoreCase(new_second) == 0){
				logger.info( first_ship_type1 + " is sorted before " + second_ship_type1);
				count++;				
			}else{
				logger.info( first_ship_type1 + " is NOT sorted before " + second_ship_type1);
			}

			first_ship_type1 = second_ship_type1;
		}


		if(count+1 == ship_count.ship_count()){
			logger.info("The Ship Type is sorted in Ascending order");
			return true;
		}else{
			logger.info("The Ship Type is NOT sorted in Ascending order");
			return false;
		}

	}
	public boolean Ship_Type_descending_sorting(){

		//getDriver().navigate().refresh();
		int count = 0;

		waitExplicitly(2);


		String attr = getElement(ship_type_column_header).getAttribute("class");
		logger.info("The attr is :: " + attr);

		if(!attr.equals("header-cell__icon fa ng-star-inserted fa-sort-desc")){
			logger.info("Clicking on the ship type to sort in Descending order"); 
			getElement(ship_type_column_header).click();
		}else{
			logger.info("Ship Type column is already sorted in Descending order continue the check");
		}

		//getDriver().navigate().refresh();
		waitExplicitly(5);

		By first_ship_type = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[4]");
		String first_ship_type1 = getElement(first_ship_type).getText();
		logger.info("The first ship type in descending order is :: " + first_ship_type1 );
		String new_first = first_ship_type1.replace("/"," ");
		//logger.info("NEW STRING IS ::: " + new_first);
		for(int i = 2; i <= ship_count.ship_count();i++){
			By second_ship_type = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[4]");
			String second_ship_type1 = getElement(second_ship_type).getText();
			String new_second = second_ship_type1.replace("/"," ");
			//	logger.info("NEW STRING IS ::: " + new_second);
			if(new_first.compareToIgnoreCase(new_second) > 0 || new_first.compareToIgnoreCase(new_second) == 0){
				logger.info( first_ship_type1 + " is sorted before " + second_ship_type1);
				count++;				
			}else{
				logger.info( first_ship_type1 + " is NOT sorted before " + second_ship_type1);
			}

			first_ship_type1 = second_ship_type1;
		}

		if(count+1 == ship_count.ship_count()){
			logger.info("The Ship Type is sorted in Descending order");
			return true;
		}else{
			logger.info("The Ship Type is NOT sorted in Descending order");
			return false;
		}
	}


	public boolean Flag_ascending_sorting(){
		//This is verify the flag sorting in ascending order
		//getDriver().navigate().refresh();
		int count = 0;
		waitExplicitly(2);

		String attr = getElement(flag_column_header).getAttribute("class");
		logger.info("The attr is :: " + attr);

		if(!attr.equals("header-cell__icon fa fa-sort-asc")){
			logger.info("Clicking on the Flag column to sort in ascending order"); 
			getElement(flag_column_header).click();
		}else{
			logger.info("Flag column is already sorted in Ascending order continue the check");
		}

		waitExplicitly(2);
		By first_flag = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[1]/ps-flag/span");
		
		String first_flag1 = getElement(first_flag).getAttribute("class");
		//String first = first_ship_type1.split("\\(","\\\");
		logger.info("The first ship type in ascending order is : " + first_flag1);
		for(int i = 2; i <= ship_count.ship_count();i++){
			By second_flag = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[1]/ps-flag/span");
			String second_flag1 = getElement(second_flag).getAttribute("class");
			if(first_flag1.compareToIgnoreCase(second_flag1) < 0 || first_flag1.compareToIgnoreCase(second_flag1) == 0){
				logger.info( first_flag1 + " is sorted before " + second_flag1);
				count++;				
			}else if(second_flag1.equals("flag flag-unknown")) {
				logger.info("The flag unknown is seen :: " + i);
				count++;
			}
			else{
				logger.info( first_flag1 + " is NOT sorted before " + second_flag1);
			}

			first_flag1 = second_flag1;
		}


		if(count+1 == ship_count.ship_count()){
			logger.info("The Ship Type is sorted in Ascending order");
			return true;
		}else{
			logger.info("The Ship Type is NOT sorted in Ascending order");
			return false;
		}

	}

	public boolean flag_descending_sorting(){

		//This is verify the flag sorting in descending order
		//getDriver().navigate().refresh();
		int count = 0;

		waitExplicitly(2);


		String attr = getElement(flag_column_header).getAttribute("class");
		logger.info("The attr is :: " + attr);

		if(!attr.equals("header-cell__icon fa fa-sort-asc")){
			logger.info("Clicking on the Flag to sort in Descending order"); 
			getElement(flag_column_header).click();
		}else{
			logger.info("Flag column is already sorted in Descending order continue the check");
		}

		//getDriver().navigate().refresh();
		waitExplicitly(5);
		int i =0;
		for(i = 1; i <= ship_count.ship_count();i++) {
			By first_flag = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[1]/ps-flag/span");
			String first_flag1 = getElement(first_flag).getAttribute("class");
			logger.info("The first ship type in descending order is :: " + first_flag1 );
			if(first_flag1.equals("flag flag-unknown")) {
				logger.info("Flag unknown is seen :: " + i);
			}else {
				logger.info("Known flag is seen :: " + i);
				break;
			}
		}
	
		String first_flag1 = getElement(By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[1]/ps-flag/span")).getAttribute("class");
		for(int j = i+1; j <= ship_count.ship_count();j++){
			By second_flag = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + j + "]/ps-data-table-cell[1]/ps-flag/span");
			String second_flag1 = getElement(second_flag).getAttribute("class");
			if(first_flag1.compareToIgnoreCase(second_flag1) > 0 || first_flag1.compareToIgnoreCase(second_flag1) == 0){
				logger.info( first_flag1 + " is sorted before " + second_flag1);
				count++;				
			}else{
				logger.info( first_flag1 + " is NOT sorted before " + second_flag1);
			}

			first_flag1 = second_flag1;
		}
		//logger.info("The count of ships checked is :: " + count + " i is :: " + i + " ship count - i is :: " + (ship_count()-i));
		if(count == (ship_count.ship_count()-i)){
			logger.info("The Flag is sorted in Descending order");
			return true;
		}else{
			logger.info("The Flag is NOT sorted in Descending order");
			return false;
		}
	}

	public boolean last_updated_descending_sorting() throws ParseException{

		//getDriver().navigate().refresh();

		int count = 0;
		int internal_count = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm");
		waitExplicitly(2);
		
		String fontWeight = getElement(last_updated).getCssValue("font-weight");			
		boolean isBold = "bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) >= 700;

		String attr = getElement(last_updated).getAttribute("class");
		logger.info("The attr is :: " + attr);

		if(!attr.equals("header-cell__icon fa fa-sort-asc") && isBold){
			logger.info("The Last Updated column to sort in descending order continue with the further checking"); 
			count++;
		}else{
			logger.info("Last Updated column is NOT sorted in descending order");
		}

		waitExplicitly(2);
		By first_date = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[6]");
		
		String first_date1 = getElement(first_date).getText();
		logger.info("The first date in descending order is : " + first_date1);
		Date first = sdf.parse(first_date1);
		//String first = first_ship_type1.split("\\(","\\\");
		logger.info("The first date in descending order is : " + first_date1);
		for(int i = 2; i <= ship_count.ship_count();i++){
			By second_date = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[6]");
			String second_date1 = getElement(second_date).getText();
			Date second = sdf.parse(second_date1);
			if(first.compareTo(second) > 0 || first.compareTo(second) == 0){
				logger.info( first + " is sorted before " + second);
				internal_count++;				
			}else{
				logger.info( first+ " is NOT sorted before " + second);
			}

			first = second;
		}


		if(internal_count+1 == ship_count.ship_count()){
			logger.info("The Last Updated is sorted in descending order");
			count++;
		}else{
			logger.info("The Last Updated is NOT sorted in descending order");
		}

		if(count == 2 ){
			logger.info("The default sorting is by Last Updated");
			return true;
		}else{
			logger.info("The default sorting is NOT by Last Updated");
			return false;
		}

	}

	public boolean last_updated_ascending_sorting() throws ParseException{

		//	getDriver().navigate().refresh();
		int count = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm");
		waitExplicitly(2);

		String fontWeight = getElement(last_updated).getCssValue("font-weight");			
		boolean isBold = "bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) >= 700;

		String attr = getElement(last_updated).getAttribute("class");
		logger.info("The attr is :: " + attr);

		if(!attr.equals("header-cell__icon fa fa-sort-asc") && isBold){
			logger.info("Clicking on the Last Updated column to sort in ascending order click on it"); 
		waitExplicitly(3);
			getElement(last_updated).click();
		}else{
			logger.info("Last Updated column is NOT sorted in as order");
		}

		waitExplicitly(2);
		By first_date = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[6]");
		
		String first_date1 = getElement(first_date).getText();
		Date first = sdf.parse(first_date1);
		//String first = first_ship_type1.split("\\(","\\\");
		logger.info("The first date in ascending order is : " + first_date1);
		for(int i = 2; i <= ship_count.ship_count();i++){
			By second_date = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[6]");
			String second_date1 = getElement(second_date).getText();
			Date second = sdf.parse(second_date1);
			if(first.compareTo(second) < 0 || first.compareTo(second) == 0){
				logger.info( first + " is sorted before " + second);
				count++;				
			}else{
				logger.info( first+ " is NOT sorted before " + second);
			}

			first = second;
		}


		if(count+1 == ship_count.ship_count()){
			logger.info("The Ship Type is sorted in ascending order");
			return true;
		}else{
			logger.info("The Ship Type is NOT sorted in ascending order");
			return false;
		}

	}

	public boolean Latest_result_sorting() {
		// TODO Auto-generated method stub
		
		
		if(!getElement(Latest_result_icon).getAttribute("class").equals("header-cell__icon fa ng-star-inserted fa-sort-desc"))
		{
			
	verbose("going to validate the status column in ascending order");
	waitExplicitly(2);
	getElement(Latest_result_icon).click();
	verbose("Clicked the icon");
	String attr = getElement(Latest_result_icon).getAttribute("class");
	verbose("Latest results are arranged in Descending order" + attr);
	
		}
		getElement(Latest_result_icon).click();
		String attr = getElement(Latest_result_icon).getAttribute("class");
		verbose("Latest results are arranged in Descending order" + attr);
		if(getElement(Latest_result_icon).getAttribute("class").equals("header-cell__icon fa ng-star-inserted fa-sort-asc"))
		{
			verbose("Latest result is in ascending order");
			return true;
		}
		else {
			verbose("latest result not in ascending order");
			return false;
		}
	}
}

		
	
		/*}
		try {
		    WebElement date = driver.findElement(By.xpath("//p[contains(@class,'ng-star-inserted')]"));
		    
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		    WebElement date = driver.findElement(By.xpath("//p[contains(@class,'ng-star-inserted')]"));
		   
		}
		
	myList= driver.findElements(By.xpath("//p[contains(@class,'ng-star-inserted')]"));
	List<String> all_elements_text = new ArrayList<String>();

	verbose("The ship count is " + ship_count.ship_count());
   int local = ship_count.ship_count();
	//for(int i=0; i<myList.size(); i++){
		for(WebElement s : myList) {
		verbose("The list size is :::" +  myList.size());
		try {
		    WebElement date = driver.findElement(By.xpath("//p[contains(@class,'ng-star-inserted')]"));
		    
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		    WebElement date = driver.findElement(By.xpath("//p[contains(@class,'ng-star-inserted')]"));
		   
		}
      
     System.out.println(s.getText());
     try {
		    WebElement date = driver.findElement(By.xpath("//p[contains(@class,'ng-star-inserted')]"));
		    
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		    WebElement date = driver.findElement(By.xpath("//p[contains(@class,'ng-star-inserted')]"));
		   
		}
      all_elements_text.add(s.getText());
   // System.out.println(i);
   
	}
	System.out.println("Unsorted list:-"+ all_elements_text);

	*/
		
	
	/*public class SeverityComparator implements RecordStatus<String> {
	     private int direction;

	     public SeverityComparator(boolean reverse) {
	         this.direction = reverse ? -1 : 1;
	     }

	     private int severity(String s) {
	         if (s.equals("Unknown")) { // you really should have constants for the values...
	             return 0;
	         } else if (s.equals("OK")) {
	             return 1;
	         } else if (s.equals("Warning")) {
	             return 2;
	         } 
	         else if (s.equals("Critical")) {
	             return 3;
	         }
	             else {
	             throw new IllegalArgumentException("Not a severity: " + s);
	         }
	     }

	  
	     public int compareTo(String other) {
	         return direction * (severity(this) - severity(other));
	     }
	}*/
	/*return true;
	}
}*/

	/*myList.sort(new Comparator<String>() {
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
}
	public enum RecordStatus{
	    Critical(0),
	    Warning(1),
	    OK(2);
		Unknown(3);
		
	    private final int status;

	    RecordStatus(int status) {
	        this.status = status;
	    }

	    public int getStatus() {
	        return  status;
	    }

	
	}	
	
	
	
	public enum RecordStatus {
    OK(0),
    BAD(1),
    WORST(2);

    private final int status;

    RecordStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return  status;
    }

}
	

	package com.example.demo;

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
		}

		private static void sortRecordStatus() {
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
	}



*/
	
