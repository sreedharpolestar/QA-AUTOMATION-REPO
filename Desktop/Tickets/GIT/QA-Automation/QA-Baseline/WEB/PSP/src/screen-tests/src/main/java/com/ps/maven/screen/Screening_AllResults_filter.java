package com.ps.maven.screen;

import java.awt.Color;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ps.maven.utils.BrowserTypes;

public class Screening_AllResults_filter extends BrowserTypes {
	
	By All_results_button_title = By.xpath("//ps-screening-table/div/div/div[1]/ps-screening-filters/form/ps-dropdown-input[3]/div/button/div/span[1]");
	By All_results_button_arrow = By.xpath("//ps-screening-table/div/div/div[1]/ps-screening-filters/ps-dropdown-input[3]/div/button/div/span[2]");
	By Allresults_dropdown_afterclicked = By.xpath("//*[@id=\"all-results\"]/div");
	By Escalated_results_only = By.xpath("//*[@id=\"all-results\"]/div/div[1]/ps-toggle-button/div/label/ps-screening-severity/p");
	By Escalated_toggle_button = By.xpath("//*[@id=\"all-results\"]/div/div[1]/ps-toggle-button/div/label/span");
	By first_checkbox = By.xpath("//*[@id=\"all-results\"]/div/div[2]/div");
	//*[@id=\"0\"]
	By All_results_link = By.xpath("//*[@id=\"all-results\"]/div/p");
	By Select_all_link = By.xpath("//*[@id=\"all-results\"]/div/p/span");
	By critical_checkbox = By.xpath("//*[@id=\"0\"]");
	By All_results_filter_dropdown = By.xpath("//*[@id=\"all-results\"]/div/select");
	By warning_checkbox = By.xpath("//*[@id=\"1\"]");
	By ok_checkbox = By.xpath("//*[@id=\"2\"]");
	By unknown_checkbox = By.xpath("//*[@id=\"3\"]");
    By No_result_found_message = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/ps-fill-space-message/div/h2");
	By first_severity = By.xpath("//*[@id=\"all-results\"]/div/div[2]/label/ps-screening-severity/p");
	By filter_dropdown = By.xpath("//*[@id=\"all-results\"]/div/select");
	Common_methods screen  = new Common_methods();
	//Screening_AllResults_filter allresultsfilter = new Screening_AllResults_filter();
	Ship_name_click shipname = new Ship_name_click();
	String first_ship_result1;
	Validate_Accordion validate_accordion = new Validate_Accordion();
	
	Latest_Screening_Results screening = new Latest_Screening_Results();
	
	
	
	public int ship_count_only() {
		String total_ship_count = getElement(screen.ship_count).getText();		
		int ship_count_only = Integer.parseInt(total_ship_count);
		verbose("Ship count is :: " +  ship_count_only);
		return ship_count_only;

	}
	
	public boolean click_check_dropdown() {
		// TODO Auto-generated method stub
		getElement(All_results_button_title).getText();
		Assert.assertEquals("All results",getElement(All_results_button_title).getText());
		waitExplicitly(3);
		getElement(All_results_button_title).click();
		Select select=new Select(getElement(All_results_filter_dropdown));
		List<WebElement> list=select.getOptions();
		for(int i=0;i<list.size();i++)          
		    {
		        System.out.println(list.get(i).getText());
		    }
		if((getElement(All_results_filter_dropdown)).isDisplayed())
				{
			verbose("The dropdown filter is present");
			return true;
				}
		else {
			verbose("The dropdown not displayed correctly");
			return false;
		}
		
		
	}
	public boolean check_dropdown_select_ship_global_sanctions() {
		// TODO Auto-generated method stub
		getElement(All_results_button_title).getText();
		Assert.assertEquals("All results",getElement(All_results_button_title).getText());
		waitExplicitly(3);
		getElement(All_results_button_title).click();
		Select select=new Select(getElement(All_results_filter_dropdown));
		List<WebElement> list=select.getOptions();
		for(int i=0;i<list.size();i++)          
		    {
		        System.out.println(list.get(i).getText());
		    }
		if((getElement(All_results_filter_dropdown)).isDisplayed())
				{
			verbose("The dropdown filter is present");
				}
		else {
			verbose("The dropdown not displayed correctly");
		}
		verbose("Going to select Ship global sanctions list check");
		Select check_dropdown = new Select(getElement(filter_dropdown));
		check_dropdown.selectByVisibleText("Ship global sanctions list check");
		waitExplicitly(2);
		return true;
	}
	

	



	public boolean Ship_global_result_Critical() {
		waitExplicitly(2);
		String result = getElement(screening.Ship_global_sanctions_list_check_result).getText();
		verbose("The result of ship global sanctions:::::" + result);
		if(result.equalsIgnoreCase("Critical"))
		{
			verbose("The result of Ship global sanctions is Critical for the ship in the table after filter -Correct");
			return true;
		}
		else {
			verbose("The result of Ship global sanctions is NOT ::Critical for the ship in the table after filter :::: InCorrect");
			return false;
		}
		
	}

	public boolean port_state_result_Warning() {
		// TODO Auto-generated method stub
		waitExplicitly(2);
		String result = getElement(screening.Port_state_control_history_check_result).getText();
		verbose("The result of Port state control :::::" + result);
		if(result.equalsIgnoreCase("Warning"))
		{
			verbose("The result of Port state control is Warning for the ship in the table after filter -Correct");
			return true;
		}
		else {
			verbose("The result of Port state control is NOT ::Warning for the ship in the table after filter :::: InCorrect");
			return false;
		}
		
	}
	
	public boolean check_dropdown_select_port_state_control() {
		// TODO Auto-generated method stub
		getElement(All_results_button_title).getText();
		Assert.assertEquals("All results",getElement(All_results_button_title).getText());
		waitExplicitly(3);
		getElement(All_results_button_title).click();
		Select select=new Select(getElement(All_results_filter_dropdown));
		List<WebElement> list=select.getOptions();
		for(int i=0;i<list.size();i++)          
		    {
		        System.out.println(list.get(i).getText());
		    }
		if((getElement(All_results_filter_dropdown)).isDisplayed())
				{
			verbose("The dropdown filter is present");
				}
		else {
			verbose("The dropdown not displayed correctly");
		}
		verbose("Going to select Port state control from the dropdown");
		Select check_dropdown = new Select(getElement(filter_dropdown));
		check_dropdown.selectByVisibleText("Port state control history check");
		waitExplicitly(2);
		return true;
	}
	
	public boolean check_dropdown_select_ship_movement_history() {
		getElement(All_results_button_title).getText();
		Assert.assertEquals("All results",getElement(All_results_button_title).getText());
		waitExplicitly(3);
		getElement(All_results_button_title).click();
		Select select=new Select(getElement(All_results_filter_dropdown));
		List<WebElement> list=select.getOptions();
		for(int i=0;i<list.size();i++)          
		    {
		        System.out.println(list.get(i).getText());
		    }
		if((getElement(All_results_filter_dropdown)).isDisplayed())
				{
			verbose("The dropdown filter is present");
				}
		else {
			verbose("The dropdown not displayed correctly");
		}
		verbose("Going to select Ship Movement history from the dropdown");
		Select check_dropdown = new Select(getElement(filter_dropdown));
		check_dropdown.selectByVisibleText("Ship movement history check");
		waitExplicitly(2);
		//selection_of_critical();
		return true;
	}
	public boolean ship_movement_history_OK() {
		waitExplicitly(2);
		String result = getElement(screening.Ship_movement_result).getText();
		verbose("The result of ship global sanctions:::::" + result);
		if(result.equalsIgnoreCase("OK"))
		{
			verbose("The result of Ship Movement history is OK for the ship in the table after filter -Correct");
			return true;
		}
		else {
			verbose("The result of Ship Movement history is NOT ::OK for the ship in the table after filter :::: InCorrect");
			return false;
		}
	}

	
	
	
public boolean selection_of_critical(){
		
		boolean local = getElement(critical_checkbox).isDisplayed();
		verbose("The first checkbox is displayed");
		
		for(int i=1; i<=3; i++)
		{
			
		
			By second_checkbox = By.xpath("//*[@id=" + i +"]");
			String local2 = getElement(second_checkbox).getText();
			boolean local1 = getElement(second_checkbox).isDisplayed();
			verbose("The checkbox is present ");
			getElement(second_checkbox).click();
		}
		
		waitExplicitly(3);
		getElement(All_results_button_title).click();
		verbose("Only critical is selected");
		
		getElement(All_results_button_title).click();
		
		
		waitExplicitly(3);
		String total_ship_count = getElement(screen.ship_count).getText();
		verbose("Debug code:::::::::::::::::::::::::::::::::::::::::::::::" + total_ship_count);
		int ship_count_only = Integer.parseInt(total_ship_count);
		verbose("Ship count is :: " +  ship_count_only);
		if(ship_count_only==0)
		{
	verbose("No result found");
		}
		else 
			{
		for(int i=1; i<=screen.ship_count(); i++)
		{
			
			By first_ship_current_result = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[6]/ps-screening-severity/p");
			waitExplicitly(2);
			
		
			String first_ship_result = getElement(first_ship_current_result).getText();
			verbose("The current result of the ship  listed in the table  :  " +  first_ship_result);
			first_ship_result1 = first_ship_result;
			if(!first_ship_result.equals("Critical"))
			{
				verbose("The result is incorrect");
				
			
			}
			else {
				verbose("The result is correct");
				
			}
			}
		}

			return true;
		}
	
	
	public boolean selection_of_Warning(){
		
		
		
	getElement(critical_checkbox).click();
	for(int i=2; i<=3; i++)
	{
		
		By second_checkbox = By.xpath("//*[@id=" + i +"]");
		String local2 = getElement(second_checkbox).getText();
		boolean local1 = getElement(second_checkbox).isDisplayed();
		verbose("The checkbox is present ");
		getElement(second_checkbox).click();
	}
	waitExplicitly(1);
	String All_results_number_on_button = getElement(All_results_button_title).getText();
	verbose("the number displayed on the button should be one :  " + All_results_number_on_button);
	

	String total_ship_count = getElement(screen.ship_count).getText();		
	int ship_count_only = Integer.parseInt(total_ship_count);
	verbose("Ship count is :: " +  ship_count_only);
	
	if(ship_count_only==0)
		
	{
verbose("No matching result is found:::: " + getElement(No_result_found_message).getText());
	}
	else {
	
	
	for(int i=1; i<=screen.ship_count(); i++)
	{
		By first_ship_current_result = By.xpath("//ps-data-table-row[" + i + "]/ps-data-table-cell[6]/ps-screening-severity/p");
		String first_ship_result = getElement(first_ship_current_result).getText();
		verbose("The current result of the ship  listed in the table  :  " +  first_ship_result);
		if(first_ship_result.equals("Warning"))
		{
			verbose("The result is correct");
			
		}
		else {
			verbose("The result is incorrect");
			
		}
		
	}
	}
	
		return true;
	
	}
public boolean selection_of_OK(){
		
		getElement(critical_checkbox).click();
		getElement(warning_checkbox).click();
		getElement(unknown_checkbox).click();
		
		waitExplicitly(4);
		waitExplicitly(1);
		String All_results_number_on_button = getElement(All_results_button_title).getText();
		verbose("the number displayed on the button should be one :  " + All_results_number_on_button);
		
		
		waitExplicitly(3);
		
		String total_ship_count = getElement(screen.ship_count).getText();		
		int ship_count_only = Integer.parseInt(total_ship_count);
		verbose("Ship count is :: " +  ship_count_only);
		/*if(getElement(No_result_found_message).getText().equals("No results found."))
		{
	verbose("No matching result is found:::: " + getElement(No_result_found_message).getText());
		}*/
		if(ship_count_only==0)
			
		{
	verbose("No matching result is found:::: " + getElement(No_result_found_message).getText());
		}
		else {
		
		
		for(int i=1; i<=screen.ship_count(); i++)
		{
			
			By first_ship_current_result = By.xpath("//ps-data-table-row[" + i + "]/ps-data-table-cell[6]/ps-screening-severity/p");
			String first_ship_result = getElement(first_ship_current_result).getText();
			verbose("The current result of the ship  listed in the table  :  " +  first_ship_result);
			if(first_ship_result.equals("OK"))
			{
				verbose("The result is correct");
				
			}
			else {
				verbose("The result is incorrect");
				
			}
		}
		}
		
		return true;
	}
	
public boolean Country_sanctions_check_OK() {
	waitExplicitly(2);
	String result = getElement(screening.Country_sanctions_check_result).getText();
	verbose("The result of ship global sanctions:::::" + result);
	if(result.equalsIgnoreCase("OK"))
	{
		verbose("The result of Country sanctions check  is OK for the ship in the table after filter -Correct");
		return true;
	}
	else {
		verbose("The result of Country sanctions check is NOT ::OK for the ship in the table after filter :::: InCorrect");
		return false;
	}
}
	
public boolean selection_of_Unknown() {
	getElement(critical_checkbox).click();
	getElement(warning_checkbox).click();
	getElement(ok_checkbox).click();
	
	waitExplicitly(4);
	waitExplicitly(1);
	String All_results_number_on_button = getElement(All_results_button_title).getText();
	verbose("the number displayed on the button should be one :  " + All_results_number_on_button);
	
	if(All_results_number_on_button.equals ("1 Results"))
	{
		verbose("The button displayed for the filter is correct");
	}
	
	else
	{
		verbose("The button displayed for the filter is incorrect");
	}

	
	waitExplicitly(3);
	
	String total_ship_count = getElement(screen.ship_count).getText();		
	int ship_count_only = Integer.parseInt(total_ship_count);
	verbose("Ship count is :: " +  ship_count_only);
	if(ship_count_only==0)
	{
verbose("No result found");
	}
	else 
		{
	for(int i=1; i<=screen.ship_count(); i++)
	{
		
		By first_ship_current_result = By.xpath("//ps-data-table-row[" + i + "]/ps-data-table-cell[6]/ps-screening-severity/p");
		String first_ship_result = getElement(first_ship_current_result).getText();
		verbose("The current result of the ship  listed in the table  :  " +  first_ship_result);
		if(first_ship_result.equals("OK"))
		{
			verbose("The result is correct");
			
		}
		else {
			verbose("The result is incorrect");
			
		}
	}
	}
	
	return true;
}
public boolean check_dropdown_select_country_sanctions() {
	getElement(All_results_button_title).getText();
	Assert.assertEquals("All results",getElement(All_results_button_title).getText());
	waitExplicitly(3);
	getElement(All_results_button_title).click();
	Select select=new Select(getElement(All_results_filter_dropdown));
	List<WebElement> list=select.getOptions();
	for(int i=0;i<list.size();i++)          
	    {
	        System.out.println(list.get(i).getText());
	    }
	if((getElement(All_results_filter_dropdown)).isDisplayed())
			{
		verbose("The dropdown filter is present");
			}
	else {
		verbose("The dropdown not displayed correctly");
	}
	verbose("Going to select Country sanctions check");
	Select check_dropdown = new Select(getElement(filter_dropdown));
	check_dropdown.selectByVisibleText("Country sanctions check");
	waitExplicitly(2);
	//selection_of_critical();
	return true;
}
public boolean check_dropdown_select_overall_screening_result() {
	getElement(All_results_button_title).getText();
	Assert.assertEquals("All results",getElement(All_results_button_title).getText());
	waitExplicitly(3);
	getElement(All_results_button_title).click();
	Select select=new Select(getElement(All_results_filter_dropdown));
	List<WebElement> list=select.getOptions();
	for(int i=0;i<list.size();i++)          
	    {
	        System.out.println(list.get(i).getText());
	    }
	if((getElement(All_results_filter_dropdown)).isDisplayed())
			{
		verbose("The dropdown filter is present");
			}
	else {
		verbose("The dropdown not displayed correctly");
	}
	Select check_dropdown = new Select(getElement(filter_dropdown));
	check_dropdown.selectByVisibleText("Overall screening result");
	waitExplicitly(2);
	return true;

}

public boolean Company_global_sanctions_check_Unknown() {
	waitExplicitly(2);
	String result = getElement(screening.Company_global_sanctions_list_check_result).getText();
	verbose("The result of Company global sanctions "
			+ ""
			+ ":::::" + result);
	if(result.equalsIgnoreCase("Incomplete"))
	{
		verbose("The result of Company global sanctions check  is Pending for the ship in the table after filter -Correct");
		return true;
	}
	else {
		verbose("The result of Company global sanctions check is NOT ::Pending for the ship in the table after filter :::: InCorrect");
		return false;
	}
}


public boolean check_dropdown_select_company_global_sanctions() {
	// TODO Auto-generated method stub
	getElement(All_results_button_title).getText();
	Assert.assertEquals("All results",getElement(All_results_button_title).getText());
	waitExplicitly(3);
	getElement(All_results_button_title).click();
	Select select=new Select(getElement(All_results_filter_dropdown));
	List<WebElement> list=select.getOptions();
	for(int i=0;i<list.size();i++)          
	    {
	        System.out.println(list.get(i).getText());
	    }
	if((getElement(All_results_filter_dropdown)).isDisplayed())
			{
		verbose("The dropdown filter is present");
			}
	else {
		verbose("The dropdown not displayed correctly");
	}
	verbose("Going to sleect Company Global sanctions list check from the dropsown");
	Select check_dropdown = new Select(getElement(filter_dropdown));
	check_dropdown.selectByVisibleText("Company global sanctions list check");
	waitExplicitly(2);

	return true;
}












	// ---------------------------------------
	public boolean dropdown_click(){
		
		getElement(All_results_button_title).getText();
		Assert.assertEquals("All results",getElement(All_results_button_title).getText());
		waitExplicitly(3);
		getElement(All_results_button_title).click();
		waitExplicitly(2);
		if(getElement(Allresults_dropdown_afterclicked).isDisplayed())
		{
			verbose("The dropdown is clicked and present");
			return true;
		}
		else{
			verbose("The dropdown is not clicked");
			return false;
		}
	}
	
	
	public boolean Allresults_dropdown_check(){
		String Sever = getElement(first_severity).getText();
		verbose("The severity is : " + Sever);
		
		for(int i = 2; i <= 5; i++){
			By Second_severity = By.xpath("//*[@id=\"all-results\"]/div/div[" + i + "]/label/ps-screening-severity/p");	
			String severity = getElement(Second_severity).getText();
			verbose("The severity is : " + severity);
		}
		
		boolean local = getElement(first_checkbox).isDisplayed();
		verbose("The first checkbox is displayed");
		//By first_checkbox = By.xpath("//*[@id=\"all-results\"]/div/div[i]");
		for(int i=3; i<=5; i++)
		{
			
			By second_checkbox = By.xpath("//*[@id=\"all-results\"]/div/div[" + i + "]/div");
			String local2 = getElement(second_checkbox).getText();
			boolean local1 = getElement(second_checkbox).isDisplayed();
			verbose("The checkbox is present: " + local2);
		}
		
		verbose("Checking on All results link");
		String local3 = getElement(All_results_link).getText();
		Assert.assertEquals(local3, "All results (Select all)");
		verbose("The All results link is present : " + local3);
		
		
		verbose("checking whether the toggle button is present");
		
		
		Assert.assertTrue(getElement(Escalated_toggle_button).isDisplayed());
	
		verbose("The toggle button is displayed");
	
		String Escalated_results_only_dropdown = getElement(Escalated_results_only).getText();
		verbose("The dropdown value is " + Escalated_results_only_dropdown );
		Assert.assertEquals(Escalated_results_only_dropdown,"Escalated results only");
		
		return true;
	}
	
	
	
	
	
	
	
	
	public boolean click_Allresults(){
		
		String total_ship_count = getElement(screen.ship_count).getText();		
		int ship_count_only = Integer.parseInt(total_ship_count);
		verbose("Ship count is :: " +  ship_count_only);
		
		for(int i=2; i<=4; i++)
		{
			
			By second_checkbox = By.xpath("//*[@id=\"all-results\"]/div/div[" + i + "]/div");
			String local2 = getElement(second_checkbox).getText();
			boolean local1 = getElement(second_checkbox).isDisplayed();
			verbose("The checkbox is present ");
			getElement(second_checkbox).click();
		}
		
		waitExplicitly(4);
		verbose("Only unknown checkbox is clicked and present");
		verbose("now clicking on the Allresults");
		getElement(All_results_link).click();
		waitExplicitly(5);
		
	
		String All_results_number_on_button = getElement(All_results_button_title).getText();
		verbose("the number displayed on the button should be one :  " + All_results_number_on_button);
		
		if(All_results_number_on_button.equals ("All results"))
		{
			verbose("The button displayed for the filter is correct");
		}
		
		else
		{
			verbose("The button displayed for the filter is incorrect::::::::::::::::::::::::::::::");
		}

		
		waitExplicitly(3);
		
		String total_ship_count_after_all_results = getElement(screen.ship_count).getText();		
		int ship_count_only1 = Integer.parseInt(total_ship_count_after_all_results);
		verbose("Ship count is :: " +  ship_count_only1);
		
		if(ship_count_only==ship_count_only1)
		{
			verbose("Clicking all results link in the filter works fine after comparing ship count");
			return true;
		}
		else {
			verbose("All results not working fine as ships count doesn't match");
			return false;
		}
	
	}





	public boolean escalated_results_only() {
		// TODO Auto-generated method stub
		
	/*String toggle_status = getElement(Escalated_toggle_button).getAttribute("style");
		verbose("the toggle status"  +  toggle_status);
		waitExplicitly(3);*/
		getElement(Escalated_toggle_button).click();
		boolean critical_checkbox_status = getElement(critical_checkbox).isEnabled();
		verbose("The status of the critical checkbox status : " + critical_checkbox_status );
		boolean warning_checkbox_status = getElement(warning_checkbox).isEnabled();
	
		if(critical_checkbox_status == true && warning_checkbox_status == true)
		{
			verbose("The Escalated results button is enabled");
		}
		else {
			verbose("The Escalated results button is not enabled");
		}
		waitExplicitly(3);

		String All_results_number_on_button = getElement(All_results_button_title).getText();
		verbose("the number displayed on the button should be one :  " + All_results_number_on_button);
		
		if(All_results_number_on_button.contains("2 Results"))
		{
			verbose("The button displayed for the filter is correct");
		}
		
		else
		{
			verbose("The button displayed for the filter is incorrect");
		}

		
		waitExplicitly(3);
		
		String total_ship_count = getElement(screen.ship_count).getText();		
		int ship_count_only = Integer.parseInt(total_ship_count);
		verbose("Ship count is :: " +  ship_count_only);

if(ship_count_only==0)
		
		{
	verbose("No matching result is found:::: " + getElement(No_result_found_message).getText());
		}
		else {
		
		
		
		for(int i=1; i<=screen.ship_count(); i++)
		{
			
			waitExplicitly(2);
		verbose("Inside the for loop - debug");
			By first_ship_current_result = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[" + i + "]/ps-data-table-cell[6]/ps-screening-severity/p");
			waitExplicitly(2);
			String first_ship_result = getElement(first_ship_current_result).getText();
			verbose("The current result of the ship  listed in the table  :  " +  first_ship_result);
			if(first_ship_result.equals("Critical") || first_ship_result.equals("Warning") )
			{
				verbose("The result is correct");
				
			}
			else {
				verbose("The result is incorrect");
				
			}
		}
			
		}
		return true;
		
		/*String toggle_status1 = getElement(Escalated_toggle_button).getCssValue("background-color");
		verbose("the toggle status"  +  toggle_status1);*/
		//String hex = hex(Escalated_toggle_button);
		
		/*if(hex.equals("#08ef4a")){
			verbose("Supervision On is seen" + i);
			inner_count_ON++; // This is to get the count of ships on which the supervision is ON
		}else{*/
		/*if(toggle_status == false)
		{
			verbose("The button is not enabled so clicking on it.");
			getElement(Escalated_toggle_button).click();
		}
		else {
			verbose("The toggle button is already enabled");
		}*/
		
		
		
		
	}

	

	/*for(int i=50; i<=ship_count_only(); i++)
	{
		verbose("The value of i is "  + i);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		By first_ship_current_result = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-table-row[" + i + "]/ps-table-cell[5]/div/ps-screening-severity/p");
		String first_ship_result = getElement(first_ship_current_result).getText();
		verbose("The current result of the ship  listed in the table  :  " +  first_ship_result);
		
	}
		*/
	
	

	

	

	

	
	
	
	

	

}
