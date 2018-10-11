package com.ps.maven.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.ps.maven.utils.BrowserTypes;

public class Screening_Rescreen extends BrowserTypes {
	By Rescreenlist_button = By.xpath("//button[contains(.,'Rescreen')]");
    By Rescreen_modal_button = By.xpath("//ps-modal-confirmation[contains(.,'Rescreen')]//button[2]");
    By Rescreen_modal_cancel_button = By.xpath("//ps-modal-confirmation[contains(.,'Rescreen')]//button[1]");
    Ship_name_click ship_click = new Ship_name_click();
    By ship_name_xpath = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-table-row[1]/div/input");
    By ship_selected_number_in_rescreen = By.xpath("//button[contains(@class,'btn operation-btn btn-primary btn--divided')]//div[1]");
    CheckBox checkbox = new CheckBox();
    SoftAssert Stassert = new SoftAssert();
    ScreeningResultsDeclinePage checkbox1 = new ScreeningResultsDeclinePage();
   
    By rescreen_popup_title = By.xpath("//div[contains(@class,'modal__header modal__header--with-border')]//h4");
    By rescreen_popup_message = By.xpath("//*[contains(@class,'modal__body')]");
    By ship_count = By.xpath("//div/ps-screening-component/ps-screening-table/div/div/div[2]/ps-screening-table-totals/div[1]");
   // By rescreen_modal_text = By.xpath("//ps-modal/div[1]/div/div/ps-modal-confirmation/div[2]/div");
    By Screening_results_title = By.xpath("//header[contains(@class,'table__header')]//h3");
    By first_ship_in_table_current_result = By.xpath("//ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/ps-data-table-cell[6]");
    By second_ship_in_table_current_result = By.xpath("//div/ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[2]/ps-data-table-cell[5]/div//following::div[1]");
    Common_methods ship_count1 = new Common_methods();

  


	public boolean number_check() {
		// TODO Auto-generated method stub
	    verbose("The number next to rescreen button is:::::" +  getElement(ship_selected_number_in_rescreen).getText());
		return true;

	}

	public boolean rescreen_click() {
		// TODO Auto-generated method stub
		//This is to click Re screen list button on the screening table screen
		String ship_count2 = getElement(ship_count1.ship_count).getText();
		int ship_count_only = Integer.valueOf(ship_count2);
		verbose("Ship count only is :: " +  ship_count_only);
		//verbose("The ship count before clicking on Rescreen:::::" + shipcount.ship_count());
		String button_text = getElement(Rescreenlist_button).getText();
		verbose("The text on the rescreen button is ::::" + getElement(Rescreenlist_button).getText());
		//Stassert.assertEquals(button_text, "Rescreen list", "Rescreen button title not displayed correctly");
		waitExplicitly(3);
		verbose("Going to click on Rescreen list button");
		getElement(Rescreenlist_button).click();
		verbose("Rescreen button is clicked successfully and now going to validate the pop up.");
		return true;
	}
	public boolean validate_popup_without_ship_selection() {
		
		verbose("Going to validate the pop up before clicking on Cancel.");
		waitExplicitly(3);
		String ship_count2 = getElement(ship_count1.ship_count).getText();
		int ship_count_only = Integer.valueOf(ship_count2);
		String ship_count_only1 = String.valueOf(ship_count1.ship_count());
		verbose("Ship count only is :: " + ship_count2 );
		
		String popup_header = getElement(rescreen_popup_title).getText();
		String confMsg = getElement(rescreen_popup_message).getAttribute("innerText");
		verbose("The debug message is :  "+ confMsg);
		waitExplicitly(3);
		verbose("The rescreen pop up title is ::" + popup_header);
		Assert.assertTrue(confMsg.contains(ship_count2));
		Assert.assertTrue(popup_header.contains(ship_count2));
		if((confMsg.contains("You are about to rescreen the current list of")) && (confMsg.contains("Do you wish to continue?")) && (confMsg.contains("Tip: You can use the checkboxes to select fewer ships."))
				&& (confMsg.contains(ship_count2)) && (popup_header.contains(ship_count2))) {
			
		
			verbose("The rescreen pop up message displayed correctly.The ship count is correctly displayed in the pop up header and message.");
			return true;
		}
		else {
			verbose("The rescreen pop up message not displayed correctly.The ship count is not correctly displayed in the pop up header and message::::::::::::::::::::::::");	
			return false;
		}
		
	
	}
	

	public boolean Screening_1_ship_check() {
		verbose("Going to check the ship in the table and check the status and it should be pending");
		driver.navigate().refresh();
		waitExplicitly(8);
		//first_ship_in_table_current_result
		verbose("Going to check the result of the ship");
		waitExplicitly(5);
		
		String first_ship_status = getElement(first_ship_in_table_current_result).getText();
		String first_ship_status1 = getElement(first_ship_in_table_current_result).getAttribute("innerText");
		verbose("The status of the first ship is :::" + first_ship_status);
		verbose("The status of the first ship is :::" + first_ship_status1);
		if(first_ship_status.equalsIgnoreCase("Pending")) {
			verbose("The current result of ship is pending after rescreen: so rescreened correctly");
			return true;
		}else {
			verbose("The current result of ship is not pending after rescreen:::::::::::");
			return false;
		}
		
	}
	

	

	public boolean rescreen_modal_click() {
		// TODO Auto-generated method stub
		verbose("Going to click on Rescreen button in the pop up");
		getElement(Rescreen_modal_button).click();
		verbose("Clicked on the Rescreen button on the pop up.");
		return true;
	}

	

	public boolean rescreen_modal_cancel_click() {
		// TODO Auto-generated method stub
		/*getElement(ship_click.ship_name_xpath).click();
		rescreen_click();
		number_check();*/
		Assert.assertEquals(getElement(Rescreen_modal_cancel_button).getText(), "Cancel", "cancel button in Rescreen modal is not as expected");
		if(getElement(Rescreen_modal_cancel_button).getText().equalsIgnoreCase("Cancel")){
			verbose("cancel button is displayed correctly in rescreen pop up");
		}
		else {
			verbose("cancel button is not displayed correctly in rescreen pop up:::::::::::::::::::::::");
		}
		verbose("Going to check the Rescreen button in the pop up");
		if(getElement(Rescreen_modal_button).isEnabled() && getElement(Rescreen_modal_button).getText().equalsIgnoreCase("Rescreen")){
			verbose("Rescreen button is displayed correctly in rescreen pop up");
		}
		else {
			verbose("Rescreen button is not displayed correctly in rescreen pop up:::::::::::::::::::::::");
		}
		verbose("Going to click on cancel button in the rescreen modal");
		getElement(Rescreen_modal_cancel_button).click();
		if (getElement(checkbox1.checkbox_1).isSelected()) {
			verbose("Successfully cancelled the rescreen selection and the ship is still selected in the screening table.");
			return true;
		}
		else {
			verbose("Successfully not cancelled the rescreen selection and the ship is still selected in the screening table.:::::::::::::::::::");
			return false;
		}
		
	}

	public boolean click_cancel() {
		// TODO Auto-generated method stub
		getElement(Rescreen_modal_cancel_button).click();
		if(getElement(Screening_results_title).isDisplayed() && getElement(Rescreenlist_button).getText().equalsIgnoreCase("Rescreen list")){
			verbose("After clicking cancel back to screening table screen");
			return true;
		}
		else {
			verbose("After clicking cancel it is not back to screening table screen");
			return false;
		}
		
	}

	
	public boolean select_ship(int num) {
		//This is to select the ship from the list of ships

		waitExplicitly(3);

		if(num == 1) {
			verbose("Clicking on the check box");
			getElement(checkbox1.checkbox_1).click();
			waitExplicitly(1);
			if(getElement(checkbox1.checkbox_1).isSelected() && (getElement(Rescreenlist_button).isEnabled())) {
				verbose("One ship selected");
				return true;
			}else {
				verbose("One ship is not selected");
				return false;
			}
		}else {
			verbose("Clicking on two check box");
			getElement(checkbox1.checkbox_1).click();
			waitExplicitly(2);
			getElement(checkbox1.checkbox_1).click();
			if(getElement(checkbox1.checkbox_1).isSelected() && getElement(checkbox1.checkbox_2).isSelected() && getElement(Rescreenlist_button).isEnabled()) {
				verbose("Two ships are selected");
				return true;
			}else {
				verbose("Two ships are not selected");
				return false;
			}
		}


	}
	public boolean select_a_ship() {
		//This is to select a ship in the screening table.

		verbose("The rescreen button text is :::" + getElement(Rescreenlist_button).getText());
		verbose("The rescreen button enabled::::" + getElement(Rescreenlist_button).isEnabled());
		if(getElement(Rescreenlist_button).isEnabled() && getElement(Rescreenlist_button).getText().equalsIgnoreCase("Rescreen list"))
		{
			verbose("rescreen button is enabled and displayed correctly");
		
		}
		else {
			verbose("Rescreen button is not enabled and not displayed correctly::::::::");
		
		}
		
		if(select_ship(1)) {
			verbose("Successfully selected a ship and the Rescreen button is enabled");
			return true;
		}else {
			verbose("Ship is NOT selected");
			return false;
		}
	}
	
	public boolean validate_pop_up_1_ship(){
		verbose("Going to validate the pop up for 1 ship");
		if(validate_pop_up(1)) {
			verbose("Successfully validated the header and messahe in the pop up and it is correct ");
			return true;
		}else {
			verbose("Pop up message NOT correct ::::::::::::::::::::::::::::::::::::");
			return false;
		}
	
	}
	
	public boolean validate_pop_up(int num) {
		if(num == 1) {
			verbose("The number next to rescreen button is:::::" +  getElement(ship_selected_number_in_rescreen).getText());
			Assert.assertEquals(getElement(Rescreen_modal_cancel_button).getText(), "Cancel", "cancel button in Rescreen modal is not as expected");
			Assert.assertEquals(getElement(Rescreen_modal_button).getText(), "Rescreen", "Rescreen button in Rescreen modal is not as expected");
			String popup_title = getElement(rescreen_popup_title).getText();
			verbose("The popup header is ::::" + popup_title);
			String confMsg = getElement(rescreen_popup_message).getAttribute("innerText");
			verbose("The debug message is :  "+ confMsg);
			
			if((confMsg.contains("You are about to rescreen the current selection of 1 ship.")) && (confMsg.contains("Do you wish to continue?"))
					 && (popup_title.contains("Rescreen 1 ship"))) {
				verbose("Rescreen pop up header and message is correct for 1 ship.");
			
			return true;
			}
			
			else {
				verbose("Rescreen pop up header and message is incorrect for 1 ship.::::::::::::::::::::::::");
				return false;
			}
		}
		else {
			// This case was originally planned to write in features file but not written yet still the code exist:)
			verbose("going to check for 2 ships");
			verbose("The number next to rescreen button is:::::" +  getElement(ship_selected_number_in_rescreen).getText());
			Assert.assertEquals(getElement(Rescreen_modal_cancel_button).getText(), "Cancel", "cancel button in Rescreen modal is not as expected");
			Assert.assertEquals(getElement(Rescreen_modal_button).getText(), "Rescreen", "Rescreen button in Rescreen modal is not as expected");
			String popup_title = getElement(rescreen_popup_title).getText();
			String confMsg = getElement(rescreen_popup_message).getAttribute("innerText");
			verbose("The debug message is :  "+ confMsg);
			if((confMsg.contains("You are about to rescreen the current list of 2 ships. ")) && (confMsg.contains("Do you wish to continue? ")) 
					&& (confMsg.contains("this action is not reversible do you wish to continue? "))
			 && popup_title.equals("Rescreen 2 ship"))
			{
				verbose("Rescreen pop up header and message is correct for 2 ships.");
			return true;
			}
			else {
				verbose("Rescreen pop up header and message is incorrect for 2 ships.::::::::::::::::::::::::");
				return false;
			}
		}
		

	}
	
	public boolean validate_pop_up_ship_count() {
		if(validate_pop_up(2)) {
			verbose("Successfully checked the no. on the button and it is 1");
			return true;
		}else {
			verbose("Ship is NOT selected");
			return false;
		}
	
	}
}
