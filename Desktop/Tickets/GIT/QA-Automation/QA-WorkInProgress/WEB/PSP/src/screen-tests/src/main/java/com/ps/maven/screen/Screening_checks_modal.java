package com.ps.maven.screen;//psp-app/psp-core/ps-modal/div[1]/div/div/ps-ship-report/div[3]/button[1]
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import com.ps.maven.utils.BrowserTypes;

public class Screening_checks_modal extends BrowserTypes{
	
	By Ship_global_sanctions_link = By.xpath("//div[contains(.,' Ship global sanctions list check')]/a");
	By ship_global_sanctions_list_modal_title = By.xpath("//psp-app/psp-core/ps-modal/div[1]/div/div/ps-ship-report/div[1]/ps-check-modal-header/h4[1]");
	By ship_global_sanctions_modal_close_button = By.xpath("//psp-app/psp-core/ps-modal/div[1]/div/div/ps-ship-report/div[3]/button[1]");
	By Ship_global_sanctions_modal_download_button = By.xpath("//psp-app/psp-core/ps-modal/div[1]/div/div/ps-ship-report/div[3]/button[2]/span");
	By ship_global_modal_sanction_header = By.xpath("//ps-modal/div[1]/div/div/ps-ship-report/div[2]/ps-data-table/header/div[1]/span");
	By ship_global_modal_listedsince_header = By.xpath("//ps-modal/div[1]/div/div/ps-ship-report/div[2]/ps-data-table/header/div[2]/span");
	By ship_global_modal_listeduntil_header = By.xpath("//ps-modal/div[1]/div/div/ps-ship-report/div[2]/ps-data-table/header/div[3]/span");
    By Ship_global_sanctions_check_modal_result_title = By.xpath("//ps-modal/div[1]/div/div/ps-ship-report/div[1]/ps-check-modal-header/h4[2]");
    By ship_global_sanctions_modal_result = By.xpath("//ps-modal/div[1]/div/div/ps-ship-report/div[1]/ps-check-modal-header/h4[2]/span");
    By Ship_global_sanctions_modal_message = By.xpath("//ps-modal/div[1]/div/div/ps-ship-report/div[2]/p");
    By port_state_modal_result = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[1]/ps-check-modal-header/h4[2]/span");
    By port_state_modal_close_button = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[3]/button[1]");
    By port_state_modal_download_button = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[3]/button[2]/span");
    By Authority_modal_header = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[2]/ps-data-table/header/div[1]/span");
    By port_of_inspection_modal_header = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[2]/ps-data-table/header/div[2]/span");
    By Date_modal_header = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[2]/ps-data-table/header/div[3]/span");
    By Ship_detained_header = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[2]/ps-data-table/header/div[4]/span");
    By No_of_deficiencies_header = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[2]/ps-data-table/header/div[5]/span");
    By Port_state_control_history_check = By.xpath("//div[contains(.,'Port state control history check')]/a");
	By Port_state_control_history_check_result = By.xpath("//ps-accordion-item[1]/div[2]/div/ps-screening-detail-latest-history/div/div[6]/ps-screening-severity/p");
    By Port_state_control_history_check_title_in_modal = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[1]/ps-check-modal-header/h4[1]");
	By Port_state_control_history_check_modal_result_title = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[1]/ps-check-modal-header/h4[2]");
	By Port_state_modal_message = By.xpath("//ps-modal/div[1]/div/div/ps-port-report/div[2]/p");
    By country_sanctions_link = By.xpath("//div[contains(.,'Country sanctions check')]/a");
	By Country_sanctions_modal_title = By.xpath("//ps-modal/div[1]/div/div/ps-country-report/div[1]/ps-check-modal-header/h4[1]");
	By Country_sanctions_modal_result_title = By.xpath("//ps-modal/div[1]/div/div/ps-country-report/div[1]/ps-check-modal-header/h4[2]");
	By Country_sanctions_modal_result = By.xpath("//ps-modal/div[1]/div/div/ps-country-report/div[1]/ps-check-modal-header/h4[2]/span");
	By Country_sanctions_modal_close_button = By.xpath("//ps-modal/div[1]/div/div/ps-country-report/div[3]/button[1]");
	By Country_sanctions_modal_Download_button = By.xpath("//ps-modal/div[1]/div/div/ps-country-report/div[3]/button[2]/span");
	By Country_sanction_modal_Company_header = By.xpath("//ps-modal/div[1]/div/div/ps-country-report/div[2]/ps-data-table/header/div[2]/span");
	By Country_sanction_modal_Association_header = By.xpath("//ps-modal/div[1]/div/div/ps-country-report/div[2]/ps-data-table/header/div[1]/span");
	By Country_sanction_modal_Registration_country_header = By.xpath("//ps-modal/div[1]/div/div/ps-country-report/div[2]/ps-data-table/header/div[3]/span");
	By Country_sanction_modal_Domicile_country_header = By.xpath("//ps-modal/div[1]/div/div/ps-country-report/div[2]/ps-data-table/header/div[4]/span");
	By Country_sanction_modal_Control_country_header = By.xpath("//ps-modal/div[1]/div/div/ps-country-report/div[2]/ps-data-table/header/div[5]/span");
	By ship_movement_history_link = By.xpath("//div[contains(.,'Ship movement history check')]/a");
	By ship_movement_history_modal_title = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[1]/ps-check-modal-header/h4[1]");
	By Ship_movement_modal_close_button = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[3]/button[1]");
	By Ship_movement_modal_download_button = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[3]/button[2]/span");
	By Ship_movement_modal_OrbcommAIS_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/h5[1]");
	By SMH_Orbcomm_Entered_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[1]/header/div[1]/span");
	By SMH_Orbcomm_Departed_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[1]/header/div[2]/span");
	By SMH_Orbcomm_Port_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[1]/header/div[3]/span");
	By SMH_Orbcomm_Country_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[1]/header/div[4]/span");
	By SMH_Orbcomm_Blacklisted_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[1]/header/div[5]/span");
	By SMH_IHS_movement_data_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/h5[2]");
	By SMH_IHS_movement_Arrival_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[2]/header/div[1]/span");
	By SMH_IHS_movement_Departure_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[2]/header/div[2]/span");
	By SMH_IHS_movement_Port_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[2]/header/div[3]/span");
	By SMH_IHS_movement_Country_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[2]/header/div[4]/span");
	By SMH_IHS_movement_Last_port_of_call_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[2]/header/div[5]/span");
	By SMH_IHS_movement_Last_port_country_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[2]/header/div[6]/span");
	By SMH_IHS_movement_Destination_header = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[2]/ps-data-table[2]/header/div[7]/span");
	By SMH_modal_Result_title = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[1]/ps-check-modal-header/h4[2]");
	By SMH_modal_result = By.xpath("//ps-modal/div[1]/div/div/ps-movement-report/div[1]/ps-check-modal-header/h4[2]/span");
	By Company_global_sanctions_link = By.xpath("//div[contains(.,'Company global sanctions list check')]/a");
    By Company_global_sanctions_modal_title = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[1]/ps-check-modal-header/h4[1]");
	By Company_global_sanctions_modal_result = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[1]/ps-check-modal-header/h4[2]/span");
    By Company_global_modal_header1 = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[2]/h4[1]");
    By Company_global_modal_header2 = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[2]/h4[2]");
    By Company_global_modal_header3 = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[2]/h4[3]");
    By Company_global_modal_header4 = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[2]/h4[4]");
    By Company_global_modal_header5 = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[2]/h4[5]");
    By Company_global_modal_header6 = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[2]/h4[6]");
    By Company_global_close_button = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[3]/button[1]");
    By Company_global_download_button = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[3]/button[2]/span");
    By Company_global_result_title = By.xpath("//ps-modal/div[1]/div/div/ps-company-report/div[1]/ps-check-modal-header/h4[2]");
    
	Latest_Screening_Results Latest_screening = new Latest_Screening_Results();
	SoftAssert Stassert = new SoftAssert();
		

	public boolean Ship_global_sanctions_list_link_click() {
		waitExplicitly(2);
		verbose("Going to click on ship global sanctions list link  to open the modal");
		getElement(Ship_global_sanctions_link).click();
		waitExplicitly(3);
	
		String modal_title = getElement(ship_global_sanctions_list_modal_title).getText();
		verbose("The title of the modal is " + modal_title);
		waitExplicitly(3);
		verbose("The result is ::"  +  getElement(Latest_screening.Ship_global_sanctions_list_check_result).getText());
		verbose("The result is ::"  +  getElement(ship_global_sanctions_modal_result).getText() );
		waitExplicitly(3);
		if((modal_title.equals("Ship global sanctions list check") && (getElement(ship_global_sanctions_modal_result).getText().equals(getElement(Latest_screening.Ship_global_sanctions_list_check_result).getText()))))
		{
			
			verbose("Title is correct and the pop up window opened correctly");
			return true;
		}
		else {
		
			verbose("Title is incorrect and pop up window did not open correctly.");
			return false;
		}

		
	}



	public boolean Ship_global_sanctions_list_modal() throws IOException {
		waitExplicitly(2);
		String button = getElement(ship_global_sanctions_modal_close_button).getText();
		if(button.equals("Close"))
		{
			verbose("The close button is displayed correct");
		}
			
		else {
			verbose("The close button is not displayed correctly::::::::::::::::::::::::::::::::::::::::::::");
		}
		
		
		waitExplicitly(2);
		boolean button_status = getElement(ship_global_sanctions_modal_close_button).isEnabled();
		if(button_status == true)
		{
			verbose("The close button is enabled ");
		}
			
		else {
			verbose("The close button is not enabled");
		}
		
		String button1 = getElement(Ship_global_sanctions_modal_download_button).getText();
		String local1 = getElement(Ship_global_sanctions_modal_download_button).getCssValue("color");
		String hex = Color.fromString(local1).asHex();
		verbose("The color of the text is  " +   hex);
		if(button1.equals("Download full report") && hex.equals("#428bca"))
		{
			verbose("The Download full report button is displayed correct with color blue");
		}
			
		else {
			verbose("The Download full report button is not displayed correctly::::::::::::::::::::::::::::::::");
		}
		
		
		waitExplicitly(2);
		boolean button_status1 = getElement(Ship_global_sanctions_modal_download_button).isEnabled();
		if(button_status == true)
		{
			verbose("The Download full report button is enabled ");
		}
			
		else {
			verbose("The Download full report button is not enabled::::::::::::::::::::::::::::::::::::::::::::::");
		}
		waitExplicitly(1);
		verbose("Checking for the headers");
		waitExplicitly(2);
		boolean Ship_global_message = getElement(Ship_global_sanctions_modal_message).isDisplayed();
		verbose("the message is " + getElement(Ship_global_sanctions_modal_message).isDisplayed());
		if(Ship_global_message==true) {
		
			String local = getElement(Ship_global_sanctions_modal_message).getText();
			verbose("The message dispalyed is" + local);
			
		}
		
		
		else if(Ship_global_message==false) {
		verbose("The headers are " + getElement(ship_global_modal_sanction_header).getText());
		verbose("The headers are " + getElement(ship_global_modal_listedsince_header).getText());
		verbose("The headers are " + getElement(ship_global_modal_listeduntil_header).getText());
		
		if ((getElement(ship_global_modal_sanction_header).getText().equals("Sanction name"))&&
				(getElement(ship_global_modal_listedsince_header).getText().equals("Listed since"))&& 
				(getElement(ship_global_modal_listeduntil_header).getText().equals("Listed until")))
		{
			verbose("Headers are correct for Ship global sanctions list check modal");
			
		}
		else {
			verbose("Headers are incorrect for Ship global sanctions list check modal::::::::::::::::::::::::::::::::::: ");
			
		}
		
		}
		
		if(Ship_global_message==false) {
		if ((getElement(ship_global_modal_sanction_header).getCssValue("font-weight").equals("700")) && 
				(getElement(ship_global_modal_listedsince_header).getCssValue("font-weight").equals("700")) &&
				(getElement(ship_global_modal_listeduntil_header).getCssValue("font-weight").equals("700")))
				{
			        verbose("Headers are displayed in correct boldness");
				}
		
		else {
			verbose("Headers are not displayed in correct boldness");
		}
		}
		String result_title = getElement(Ship_global_sanctions_check_modal_result_title).getText();
		verbose("The Result heading is displayed " +  result_title);
		String result = getElement(ship_global_sanctions_modal_result).getText();
		verbose("The result is::: " + result);
		waitExplicitly(2);
		String local = getElement(ship_global_sanctions_modal_result).getCssValue("color");
		String Hex = Color.fromString(local).asHex();
		verbose("The color of the result::::  " +Hex);
		waitExplicitly(2);
		
	
		verbose("Taking screenshot of the modal and saving it to the folder in path C:\\\\Users\\kanchana.krishna\\Screening_Auto_Screenshots\\ ");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now copying the screenshot to the file.
		waitExplicitly(5);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\kanchana.krishna\\Screening_Auto_Screenshots\\sc.shot_ship_global_modal.png"));
		
		waitExplicitly(5);
		if((result.equalsIgnoreCase("Warning") && Hex.equals("#e7b03a")) || (result.equalsIgnoreCase("OK")&& Hex.equals("#6fb84e"))|| (result.equalsIgnoreCase("Critical")&& Hex.equals("#b12607")))
		//if(result.equals("OK") && Hex.equals("#6fb84e"))
		{
			
			verbose("The result as expected including color : " + result);
			return true;
		}
		else {
			verbose("The result not as expected::::::::::::::::::::::::::::::::::::::::::::");
			return false;
		}
		
	}
		
		public boolean port_state_modal() throws WebDriverException, IOException {
			
			waitExplicitly(2);
			String button = getElement(port_state_modal_close_button).getText();
			if(button.equals("Close"))
			{
				verbose("The close button is displayed correct");
			}
				
			else {
				verbose("The close button is not displayed correctly:::::::::::::::::::::::::::::::::");
			}
			verbose("The close button is present " + button);
			
			waitExplicitly(2);
			boolean button_status = getElement(port_state_modal_close_button).isEnabled();
			if(button_status == true)
			{
				verbose("The close button is enabled ");
			}
				
			else {
				verbose("The close button is not enabled::::::::::::::::::::::::::::::::::::::::::::::");
			}
		
			String button1 = getElement(port_state_modal_download_button).getText();
			String local1 = getElement(port_state_modal_download_button).getCssValue("color");
			String hex = Color.fromString(local1).asHex();
			verbose("The color of the text is  " +   hex);
			if(button1.equals("Download full report") && hex.equals("#428bca"))
			{
				verbose("The Download full report button is displayed correct with color blue");
			}
				
			else {
				verbose("The Download full report button is not displayed correctly:::::::::::::::::::::::::::");
			}
			
			
			waitExplicitly(2);
			boolean button_status1 = getElement(port_state_modal_download_button).isEnabled();
			if(button_status == true)
			{
				verbose("The Download full report button is enabled ");
			}
				
			else {
				verbose("The Download full report button is not enabled");
			}
			waitExplicitly(1);
			verbose("Checking for the headers");
			waitExplicitly(3);
			boolean message_status = getElement(Port_state_modal_message).isDisplayed();
	
				
				if(message_status==true) {
					
					String local = getElement(Port_state_modal_message).getText();
					verbose("The message dispalyed is" + local);
					
				}
				else if (message_status==false) {
					
				
			waitExplicitly(2);
			verbose("The headers are " + getElement(Authority_modal_header).getText());
			verbose("The headers are " + getElement(port_of_inspection_modal_header).getText());
			verbose("The headers are " + getElement(Date_modal_header).getText());
			verbose("The headers are " + getElement(Ship_detained_header).getText());
			verbose("The headers are " + getElement(No_of_deficiencies_header).getText());
			
			if((getElement(Authority_modal_header).getText().equals("Authority"))&&(getElement(port_of_inspection_modal_header).getText().equals("Port of inspection"))&& (getElement(Date_modal_header).getText().equals("Date"))&&(getElement(Ship_detained_header).getText().equals("Ship detained?"))&& (getElement(No_of_deficiencies_header).getText().equals("No. deficiencies")))
			{
				verbose("Headers are correct for port state control history check modal");
				
			}
			else {
				verbose("Headers are incorrect for port state control history check modal");
				
			}
				}
			if (message_status==false) {
			if((getElement(Authority_modal_header).getCssValue("font-weight").equals("700")) && 
					(getElement(port_of_inspection_modal_header).getCssValue("font-weight").equals("700")) && 
					(getElement(Date_modal_header).getCssValue("font-weight").equals("700")) && 
					(getElement(Ship_detained_header).getCssValue("font-weight").equals("700")) && 
					(getElement(No_of_deficiencies_header).getCssValue("font-weight").equals("700")))
			{
				verbose("Headers are displayed in correct boldness");
			}
			else {
				verbose("Headers not displayed in correct boldness");
			}
				}
			waitExplicitly(1);
			String result_title = getElement(Port_state_control_history_check_modal_result_title).getText();
			verbose("The Result heading is displayed " +  result_title);
			String result = getElement(port_state_modal_result).getText();
			verbose("The result is  " + result);
			waitExplicitly(2);
			String local = getElement(port_state_modal_result).getCssValue("color");
			String Hex = Color.fromString(local).asHex();
			verbose("The color of the result::::  " +Hex);
			waitExplicitly(2);
			String modal_message = getElement(Port_state_modal_message).getText();
			verbose("The modal message is:::::"  + modal_message);
			
			verbose("Taking screenshot of the modal and saving it to the folder in path C:\\\\Users\\kanchana.krishna\\Screening_Auto_Screenshots\\ ");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now copying the screenshot to the file.
			waitExplicitly(5);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\kanchana.krishna\\Screening_Auto_Screenshots\\sc.shot_port_state_modal.png"));
			
			waitExplicitly(5);
			if((result.equalsIgnoreCase("Warning") && Hex.equals("#e7b03a") && modal_message.equalsIgnoreCase("This check is flagged as Warning because this ship has two or more detentions in its last two years."))
					|| (result.equalsIgnoreCase("OK")&& Hex.equals("#6fb84e") && modal_message.equalsIgnoreCase("This ship has no detentions in its past port inspection history."))
					|| (result.equalsIgnoreCase("Critical")&& Hex.equals("#b12607") && modal_message.equalsIgnoreCase("This check is flagged as Critical because this ship has been detained in its last inspection or because it has two or more detentions in its last one year.")))
			
			{
				
				verbose("The result as expected including color : " + result);
				return true;
			}
			else {
				verbose("The result not as expected:::::::::::::::::::::::::::::::::::::::::::::::::::::::");
				return false;
			}
			
			
		}
		

		public boolean Port_state_link_click() {
			// TODO Auto-generated method stub
			
			waitExplicitly(2);
			verbose("going to click on port state control link to open the modal");
			getElement(Port_state_control_history_check).click();
			waitExplicitly(3);
			
			
			String modal_title = getElement(Port_state_control_history_check_title_in_modal).getText();
			verbose("The title of the modal is " + modal_title);
		
		if((modal_title.equals("Port state control history check") && 
				(getElement(Port_state_control_history_check_result).getText().equals(getElement(Latest_screening.Port_state_control_history_check_result).getText()))))
		{
			
			verbose("Title is correct and the pop up window opened correctly:::::::::::::::::::::::::::::::::::::::");
			return true;
		}
		else {
		
			verbose("Title is incorrect and pop up window did not open correctly.");
			return false;
		}

	
	}


		public boolean country_sanctions_check_link_click() {
			// TODO Auto-generated method stub
			waitExplicitly(2);
			verbose("Going to click on Country sanctions check");
			getElement(country_sanctions_link).click();
			waitExplicitly(3);
			
			
			String modal_title = getElement(Country_sanctions_modal_title).getText();
			verbose("The title of the modal is ::::" + modal_title);
			
			if((modal_title.equals("Country sanctions check") && (getElement(Country_sanctions_modal_result).getText().equals(getElement(Latest_screening.Country_sanctions_check_result).getText()))))
			{
				
				verbose("Title is correct and the pop up window opened correctly");
				return true;
			}
			else {
			
				verbose("Title is incorrect and pop up window did not open correctly::::::::::::::::::::::::::::::::::::::::::::::");
				return false;
			}

			
		}



		public  boolean country_sanctions_check_modal() throws IOException {
			// TODO Auto-generated method stub
			
			
			waitExplicitly(2);
			String button = getElement(Country_sanctions_modal_close_button).getText();
			if(button.equals("Close"))
			{
				verbose("The close button in country sanctions check modal is displayed correct");
			}
				
			else {
				verbose("The close button in country sanctions check modal is not displayed correctly:::::::::::::::::");
			}
			
			
			waitExplicitly(2);
			boolean button_status = getElement(Country_sanctions_modal_close_button).isEnabled();
			Assert.assertTrue(button_status, "Close Debug ::::::::::Button displayed Correctly");
			if(button_status == true)
			{
				verbose("The close button is enabled ");
			}
				
			else {
				verbose("The close button is not enabled::::::::::::::::::::::::::::::::::::::::::::::::");
			}
			
			String button1 = getElement(Country_sanctions_modal_Download_button).getText();
			String local1 = getElement(Country_sanctions_modal_Download_button).getCssValue("color");
			String hex = Color.fromString(local1).asHex();
			verbose("The color of the text is  :::" +   hex);
			if(button1.equals("Download full report") && hex.equals("#428bca"))
			{
				verbose("The Download full report button is displayed correct with color blue");
			}
				
			else {
				verbose("The Download full report button is not displayed correctly");
			}
			
			
			waitExplicitly(2);
			boolean button_status1 = getElement(Country_sanctions_modal_Download_button).isEnabled();
			//Assert.assertTrue(button_status1,"false");
			//Assert.assertFalse(button_status1, "Download not as expected:::::::");
			//SoftAssert Stassert = new SoftAssert();
			//Stassert.assertEquals(button_status1, "false", "Download not as expected");
			//Stassert.assertFalse(button_status1, "Download not as expected");
			Stassert.assertFalse(button_status1, "Download not as expected:::::::");
			//Stassert.assertAll();
		
			
			/*if(button_status == true)
			{
				verbose("The Download full report button is enabled ");
			}
				
			else {
				verbose("The Download full report button is not enabled");
			}*/
			waitExplicitly(1);
			verbose("Checking for the headers");
			waitExplicitly(2);
			String fontWeight = getElement(Country_sanction_modal_Company_header).getCssValue("font-weight");
			waitExplicitly(2);
			verbose("The debug:::::::" +  fontWeight);
			waitExplicitly(2);
			verbose("The headers are " + getElement(Country_sanction_modal_Company_header).getText());
			verbose("The headers are " + getElement(Country_sanction_modal_Association_header).getText());
			verbose("The headers are " + getElement(Country_sanction_modal_Registration_country_header).getText());
			verbose("The headers are " + getElement(Country_sanction_modal_Domicile_country_header).getText());
			verbose("The headers are " + getElement(Country_sanction_modal_Control_country_header).getText());
			
			waitExplicitly(2);
			//Stassert.assertEquals(getElement(Country_sanction_modal_Company_header).getText(), "Company", "Company not in correct header");
		
			if((getElement(Country_sanction_modal_Company_header).getText().equals("Company") && getElement(Country_sanction_modal_Company_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(Country_sanction_modal_Association_header).getText().equals("Association") && getElement(Country_sanction_modal_Association_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(Country_sanction_modal_Registration_country_header).getText().equals("Registration Country") && getElement(Country_sanction_modal_Registration_country_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(Country_sanction_modal_Domicile_country_header).getText().equals("Domicile Country") && getElement(Country_sanction_modal_Domicile_country_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(Country_sanction_modal_Control_country_header).getText().equals("Control Country") && getElement(Country_sanction_modal_Control_country_header).getCssValue("font-weight").equals("700")))
			{
				verbose("Headers in correct text and boldness "   );
				
			}
			else {
				verbose("Header not in correct text and  boldness");
				
			}
			
			String result_title = getElement(Country_sanctions_modal_result_title).getText();
			verbose("The Result heading is displayed : : " +  result_title);
			String result = getElement(Country_sanctions_modal_result).getText();
			verbose("The result is:::  " + result);
			waitExplicitly(2);
			String local = getElement(Country_sanctions_modal_result).getCssValue("color");
			String Hex = Color.fromString(local).asHex();
			verbose("The color of the result::::  " +Hex);
			waitExplicitly(2);
			
			
			verbose("Taking screenshot of the modal and saving it to the folder in path C:\\\\Users\\kanchana.krishna\\Screening_Auto_Screenshots\\ ");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now copying the screenshot to the file.
			waitExplicitly(5);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\kanchana.krishna\\Screening_Auto_Screenshots\\sc.shot_country_sanctions_modal.png"));
			
			waitExplicitly(5);
			debug(result);
			//Stassert.assertAll();
			//return true;
			//return debug;
			if((result.equalsIgnoreCase("Warning") && Hex.equals("#e7b03a")) || (result.equalsIgnoreCase("OK")&& Hex.equals("#6fb84e"))|| (result.equalsIgnoreCase("Critical")&& Hex.equals("#b12607")))
			
			{
				
				verbose("The result as expected including color ::: " + result);
				return true;
			}
			else {
				verbose("The result not as expected");
				return false;
			}
			
		}
	


		public boolean ship_movement_history_click() {
			// TODO Auto-generated method stub
			waitExplicitly(2);
			verbose("Going to click on Ship movement history check");
			getElement(ship_movement_history_link).click();
			waitExplicitly(3);
			
			
			String modal_title = getElement(ship_movement_history_modal_title).getText();
			verbose("The title of the modal is ::::" + modal_title);
			
			
			if((modal_title.equals("Ship movement history check") && (getElement(SMH_modal_result).getText().equals(getElement(Latest_screening.Ship_movement_result).getText()))))
			{
				
				verbose("Title is correct and the pop up window opened correctly");
				return true;
			}
			else {
			
				verbose("Title is incorrect and pop up window did not open correctly.");
				return false;
			}

			
		}



		public boolean ship_movement_history_check_modal() throws IOException {
			// TODO Auto-generated method stub
			
			waitExplicitly(2);
			String button = getElement(Ship_movement_modal_close_button).getText();
			if(button.equals("Close"))
			{
				verbose("The close button in country sanctions check modal is displayed correct");
			}
				
			else {
				verbose("The close button in country sanctions check modal is not displayed correctly::::::::");
			}
			
			
			waitExplicitly(2);
			boolean button_status = getElement(Ship_movement_modal_close_button).isEnabled();
			if(button_status == true)
			{
				verbose("The close button is enabled ");
			}
				
			else {
				verbose("The close button is not enabled::::::::::::");
			}
			
			String button1 = getElement(Ship_movement_modal_download_button).getText();
			String local1 = getElement(Ship_movement_modal_download_button).getCssValue("color");
			String hex = Color.fromString(local1).asHex();
			verbose("The color of the text is  :::" +   hex);
			if(button1.equals("Download full report") && hex.equals("#428bca"))
			{
				verbose("The Download full report button is displayed correct with color blue");
			}
				
			else {
				verbose("The Download full report button is not displayed correctly");
			}
			
			waitExplicitly(1);
			verbose("Checking for the headers in Orbcomm AIS section");
			waitExplicitly(2);
			String fontWeight = getElement(Ship_movement_modal_OrbcommAIS_header).getCssValue("font-weight");
			waitExplicitly(2);
			verbose("The debug ORBCOMSS AIS:::::::" +  fontWeight);
			waitExplicitly(2);
			String fontWeight1 = getElement(SMH_Orbcomm_Entered_header).getCssValue("font-weight");
			waitExplicitly(2);
			verbose("The debug Entered:::::::" +  fontWeight1);
			waitExplicitly(2);
			
			verbose("The headers are " + getElement(Ship_movement_modal_OrbcommAIS_header).getText());
			verbose("The headers are " + getElement(SMH_Orbcomm_Entered_header).getText());
			verbose("The headers are " + getElement(SMH_Orbcomm_Departed_header).getText());
			verbose("The headers are " + getElement(SMH_Orbcomm_Port_header).getText());
			verbose("The headers are " + getElement(SMH_Orbcomm_Country_header).getText());
			verbose("The headers are " + getElement(SMH_Orbcomm_Blacklisted_header).getText());
	
			waitExplicitly(2);
			
			if((getElement(SMH_Orbcomm_Entered_header).getText().equals("Entered") && getElement(SMH_Orbcomm_Entered_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(SMH_Orbcomm_Departed_header).getText().equals("Departed") && getElement(SMH_Orbcomm_Departed_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(SMH_Orbcomm_Port_header).getText().equals("Port") && getElement(SMH_Orbcomm_Port_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(SMH_Orbcomm_Country_header).getText().equals("Country") && getElement(SMH_Orbcomm_Country_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(SMH_Orbcomm_Blacklisted_header).getText().equals("Blacklisted") && getElement(SMH_Orbcomm_Blacklisted_header).getCssValue("font-weight").equals("700")))
		
			{
				verbose("ORBCOMM AIS Headers in correct text and boldness");
				
			}
			else {
				verbose("ORBCOMM AIS Header not in correct text and  boldness::::::::::");
				
			}
			
			
			verbose("The headers are " + getElement(SMH_IHS_movement_data_header).getText());
			verbose("The headers are " + getElement(SMH_IHS_movement_Arrival_header).getText());
			verbose("The headers are " + getElement(SMH_IHS_movement_Departure_header).getText());
			verbose("The headers are " + getElement(SMH_IHS_movement_Port_header).getText());
			verbose("The headers are " + getElement(SMH_IHS_movement_Country_header).getText());
			verbose("The headers are " + getElement(SMH_IHS_movement_Last_port_of_call_header).getText());
			verbose("The headers are " + getElement(SMH_IHS_movement_Last_port_country_header).getText());
			verbose("The headers are " + getElement(SMH_IHS_movement_Destination_header).getText());
			
			
			waitExplicitly(2);
			
			if((getElement(SMH_IHS_movement_Arrival_header).getText().equals("Arrival") && getElement(SMH_IHS_movement_Arrival_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(SMH_IHS_movement_Departure_header).getText().equals("Departure") && getElement(SMH_IHS_movement_Departure_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(SMH_IHS_movement_Port_header).getText().equals("Port") && getElement(SMH_IHS_movement_Port_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(SMH_IHS_movement_Country_header).getText().equals("Country") && getElement(SMH_IHS_movement_Country_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(SMH_IHS_movement_Last_port_of_call_header).getText().equals("Last port of call") && getElement(SMH_IHS_movement_Last_port_of_call_header).getCssValue("font-weight").equals("700"))
					&& (getElement(SMH_IHS_movement_Last_port_country_header).getText().equals("Last port country") && getElement(SMH_IHS_movement_Last_port_country_header).getCssValue("font-weight").equals("700"))
					&& (getElement(SMH_IHS_movement_Destination_header).getText().equals("Destination") && getElement(SMH_IHS_movement_Destination_header).getCssValue("font-weight").equals("700")))
		
			{
				verbose("IHS movement data  headers in correct text and boldness");
				
			}
			else {
				verbose("IHS movement data Header not in correct text and  boldness::::::::::");
				
			}
			verbose("The headers are " + getElement(Ship_movement_modal_OrbcommAIS_header).getText());
			verbose("The headers are " + getElement(SMH_IHS_movement_data_header).getText());
			
			if((getElement(Ship_movement_modal_OrbcommAIS_header).getText().equals("Orbcomm AIS") && getElement(Ship_movement_modal_OrbcommAIS_header).getCssValue("font-weight").equals("700")) 
					&& (getElement(SMH_IHS_movement_data_header).getText().equals("IHS movement data") && getElement(SMH_IHS_movement_data_header).getCssValue("font-weight").equals("700")))
					{
						verbose("IHS movement data  and ORBCOMM AIS header in correct text and boldness");
						
					}
					else {
						verbose("IHS movement data  and ORBCOMM AIS header not in correct text and  boldness::::::::::");
					}
			
			String result_title = getElement(SMH_modal_Result_title).getText();
			verbose("The Result heading is displayed : : " +  result_title);
			String result = getElement(SMH_modal_result).getText();
			verbose("The result is:::  " + result);
			waitExplicitly(2);
			String local = getElement(SMH_modal_result).getCssValue("color");
			String Hex = Color.fromString(local).asHex();
			verbose("The color of the result::::  " +Hex);
			waitExplicitly(2);
			verbose("Taking screenshot of the modal and saving it to the folder in path C:\\\\Users\\kanchana.krishna\\Screening_Auto_Screenshots\\ ");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now copying the screenshot to the file.
			waitExplicitly(5);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\kanchana.krishna\\Screening_Auto_Screenshots\\sc.shot_Ship_movement_history_check.png"));
			
			waitExplicitly(5);
			if((result.equalsIgnoreCase("Warning") && Hex.equals("#e7b03a")) || (result.equalsIgnoreCase("OK")&& Hex.equals("#6fb84e"))|| (result.equalsIgnoreCase("Critical")&& Hex.equals("#b12607")))
			//if(result.equals("OK") && Hex.equals("#6fb84e"))
			{
				
				verbose("The result as expected including color ::: " + result);
				return true;
			}
			else {
				verbose("The result not as expected");
				return false;
			}
			
			
		}
		
		
		public boolean debug(String result) {
			String local = getElement(Country_sanctions_modal_result).getCssValue("color");
			String Hex = Color.fromString(local).asHex();
			verbose("The color of the result::::  " +Hex);
			if((result.equalsIgnoreCase("Warning") && Hex.equals("#e7b03a")) || (result.equalsIgnoreCase("OK")&& Hex.equals("#6fb84e"))|| (result.equalsIgnoreCase("Critical")&& Hex.equals("#b12607")))
				//if(result.equals("OK") && Hex.equals("#6fb84e"))//ps-modal/div[1]/div/div/ps-ship-report/div[2]/p
				{
					
					verbose("The result as expected including color ::: " + result);
					return true;
				}
				else {
					verbose("The result not as expected");
					return false;
				}
			
		}



		public boolean company_global_sanctions_check_click() {
			// TODO Auto-generated method stub
			waitExplicitly(2);
			verbose("Going to click on Company global sanctions check");
			getElement(Company_global_sanctions_link).click();
			waitExplicitly(3);
			
			
			String modal_title = getElement(Company_global_sanctions_modal_title).getText();
			verbose("The title of the modal is ::::" + modal_title);
			
			
			if((modal_title.equals("Company global sanctions list check") && (getElement(Company_global_sanctions_modal_result).getText().equals(getElement(Latest_screening.Company_global_sanctions_list_check_result).getText()))))
			{
				
				verbose("Title is correct and the pop up window opened correctly");
				
			}
			else {
			
				verbose("Title is incorrect and pop up window did not open correctly.");
				
			}

			return true;
		
		}
		
		
		
		public boolean company_global_sanctions_modal() throws IOException {
			
			waitExplicitly(2);
			String button = getElement(Company_global_close_button).getText();
			if(button.equals("Close"))
			{
				verbose("The close button in country sanctions check modal is displayed correct");
			}
				
			else {
				verbose("The close button in country sanctions check modal is not displayed correctly:::::::::::::::::");
			}
			
			
			waitExplicitly(2);
			boolean button_status = getElement(Company_global_close_button).isEnabled();
			Assert.assertTrue(button_status, "Close Debug ::::::::::Button displayed Correctly");
			if(button_status == true)
			{
				verbose("The close button is enabled ");
			}
				
			else {
				verbose("The close button is not enabled::::::::::::::::::::::::::::::::::::::::::::::::");
			}
			
			String button1 = getElement(Company_global_download_button).getText();
			String local1 = getElement(Company_global_download_button).getCssValue("color");
			String hex = Color.fromString(local1).asHex();
			verbose("The color of the text is  :::" +   hex);
			if(button1.equals("Download full report") && hex.equals("#428bca"))
			{
				verbose("The Download full report button is displayed correct with color blue");
			}
				
			else {
				verbose("The Download full report button is not displayed correctly");
			}
			
			
			waitExplicitly(2);
			boolean button_status1 = getElement(Company_global_download_button).isEnabled();
			verbose("going to check the soft assert");

			//Stassert.assertFalse(button_status1, "Download not as expected:::::::");
			
			waitExplicitly(1);
			verbose("Checking for the headers");
			waitExplicitly(2);
			String fontWeight = getElement(Company_global_modal_header1).getCssValue("font-weight");
			waitExplicitly(2);
			verbose("The debug:::::::" +  fontWeight);
			waitExplicitly(2);
			verbose("The headers are " + getElement(Company_global_modal_header1).getText());
			verbose("The headers are " + getElement(Company_global_modal_header2).getText());
			verbose("The headers are " + getElement(Company_global_modal_header3).getText());
			verbose("The headers are " + getElement(Company_global_modal_header4).getText());
			verbose("The headers are " + getElement(Company_global_modal_header5).getText());
			verbose("The headers are " + getElement(Company_global_modal_header6).getText());
			waitExplicitly(2);
			Stassert.assertEquals(getElement(Company_global_modal_header1).getText(), "Group beneficial owner company sanctions", "Company not in correct header");
		
			if((getElement(Company_global_modal_header1).getText().equals("Group beneficial owner company sanctions") && getElement(Company_global_modal_header1).getCssValue("font-weight").equals("500")) 
					&& (getElement(Company_global_modal_header2).getText().equals("Ship manager company sanctions") && getElement(Company_global_modal_header2).getCssValue("font-weight").equals("500")) 
					&& (getElement(Company_global_modal_header3).getText().equals("Technical manager company sanctions") && getElement(Company_global_modal_header3).getCssValue("font-weight").equals("500")) 
					&& (getElement(Company_global_modal_header4).getText().equals("Operator company sanctions") && getElement(Company_global_modal_header4).getCssValue("font-weight").equals("500")) 
					&& (getElement(Company_global_modal_header5).getText().equals("Ship registered owner sanction") && getElement(Company_global_modal_header5).getCssValue("font-weight").equals("500"))
					&& (getElement(Company_global_modal_header6).getText().equals("Relatives / Close associates sanctions") && getElement(Company_global_modal_header6).getCssValue("font-weight").equals("500")))
			{
				verbose("Headers in correct text and boldness "   );
				
			}
			else {
				verbose("Header not in correct text and  boldness");
				
			}
			
			String result_title = getElement(Company_global_result_title).getText();
			verbose("The Result heading is displayed : : " +  result_title);
			String result = getElement(Company_global_sanctions_modal_result).getText();
			verbose("The result is:::  " + result);
			waitExplicitly(2);
			String local = getElement(Company_global_sanctions_modal_result).getCssValue("color");
			String Hex = Color.fromString(local).asHex();
			verbose("The color of the result::::  " +Hex);
			waitExplicitly(2);
			
			
			verbose("Taking screenshot of the modal and saving it to the folder in path C:\\\\Users\\kanchana.krishna\\Screening_Auto_Screenshots\\ ");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now copying the screenshot to the file.
			waitExplicitly(5);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\kanchana.krishna\\Screening_Auto_Screenshots\\sc.shot_company_global_sanctions_modal.png"));
			
			waitExplicitly(5);
		
			//Stassert.assertAll();
			
		
		if((result.equalsIgnoreCase("Warning") && Hex.equals("#e7b03a")) || (result.equalsIgnoreCase("OK")&& Hex.equals("#6fb84e"))|| (result.equalsIgnoreCase("Critical")&& Hex.equals("#b12607")))
		
			{
				
				verbose("The result as expected including color ::: " + result);
				return true;
			}
			else {
				verbose("The result not as expected");
				return false;
			}
			
		
	
			
		
			
			
			
		}
}




