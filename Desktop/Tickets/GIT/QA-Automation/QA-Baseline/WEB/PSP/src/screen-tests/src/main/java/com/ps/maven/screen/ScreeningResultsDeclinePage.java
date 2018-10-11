package com.ps.maven.screen;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.ps.maven.utils.BrowserTypes;

public class ScreeningResultsDeclinePage extends BrowserTypes{
	
	By decline_button = By.xpath("//psp-core/div/ps-screening-component/ps-screening-table/div/footer/ps-screening-table-operators/span/button[2]/div[2]");
	By decline_button_number = By.xpath("//ps-screening-component/ps-screening-table/div/footer/ps-screening-table-operators/button[1]/div[1]");
	By decline_modal = By.xpath("//ps-modal/div[1]/div/div");
	By modal_heading_single = By.xpath("//ps-modal/div[1]/div/div/ps-modal-confirmation/div[1]/h4");
	By modal_body_single = By.xpath("//ps-modal/div[1]/div/div/ps-modal-confirmation/div[2]");
	By modal_cancel = By.xpath("//ps-modal-confirmation/div[3]/button[1]");
	By modal_decline = By.xpath("//ps-modal-confirmation/div[3]/button[2]");
	By checkbox_1 = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]/div/input");
	By checkbox_2 = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[2]/div/input");
	Common_methods screen  = new Common_methods();
	int ship_count_before_decline_button_click = 0;
	SoftAssert Stassert = new SoftAssert();
	
	
	public int ship_count_decline() {
		String ship_count1 = getElement(screen.ship_count).getText();

		//int ship_count_only = Integer.parseInt(ship_count1.substring(0,ship_count1.indexOf(" ")));
		int ship_count_only = Integer.parseInt(ship_count1);

		return ship_count_only;

	}

	public boolean select_a_ship() {

		if(select_ship(1)) {
			verbose("Successfully selected a ship and the Decline button is enabled");
			return true;
		}else {
			verbose("Ship is NOT selected");
			return false;
		}
	}

	public boolean select_multiple_ships() {

		if(select_ship(2)) {
			verbose("Successfully selected two ships and the Decline button is enabled");
			return true;
		}else {
			verbose("Ships are NOT selected");
			return false;
		}
	} 

	public boolean select_ship(int num) {
		//This is to select the ship from the list of ships

		waitExplicitly(3);

		if(num == 1) {
			verbose("Clicking on the check box");
			getElement(checkbox_1).click();
			waitExplicitly(1);
			if(getElement(checkbox_1).isSelected() && getElement(decline_button).isEnabled()) {
				verbose("One ship selected");
				return true;
			}else {
				verbose("One ship is not selected");
				return false;
			}
		}else {
			verbose("Clicking on two check box");
			getElement(checkbox_1).click();
			waitExplicitly(2);
			getElement(checkbox_2).click();
			if(getElement(checkbox_1).isSelected() && getElement(checkbox_2).isSelected() && getElement(decline_button).isEnabled()) {
				verbose("Two ships are selected");
				return true;
			}else {
				verbose("Two ships are not selected");
				return false;
			}
		}


	}

	public boolean decline_number_one() {
		if(decline_number(1)){
			verbose("Number next to decline button is updated to \"1\" as expected");
			return true;
		}else {
			verbose("Number next to decline button is NOT updated to \"1\" as expected");
			return false;
		}
	}

	public boolean decline_number_two() {
		if(decline_number(2)){
			verbose("Number next to decline button is updated to \"2\" as expected");
			return true;
		}else {
			verbose("Number next to decline button is NOT updated to \"2\" as expected");
			return false;
		}
	}

	public boolean decline_number(int num) {
		String numer = getElement(decline_button_number).getText();
		verbose("The number next to the decline number is "  + numer );
waitExplicitly(4);
		//This is to verify the number next to the decline button
		if(num == 1)
			if(getElement(decline_button_number).getText().equals("1")) {
				verbose("Number next to decline button is updated as expected");
				return true;
			}else {
				verbose("Number next to decline button is NOT updated as expected");
				return false;
			}else {
				if(getElement(decline_button_number).getText().equals("2")) {
					verbose("Number next to decline button is updated as expected");
					return true;
				}else {
					verbose("Number next to decline button is NOT updated as expected");
					return false;
				}	
			}
	}

	public boolean decline_modal_click_message_one_ship() {
		if(decline_button_click(1)) {
			verbose("Heading and message seen correctly for declining one ship");
			return true;
		}else {
			verbose("Heading and message is NOT seen correctly for declining one ship");
			return false;
		}
	}

	public boolean decline_modal_click_message_more_ships() {
		if(decline_button_click(2)) {
			verbose("Heading and message seen correctly for declining two ships");
			return true;
		}else {
			verbose("Heading and message is NOT seen correctly for declining two ships");
			return false;
		}
	}
	public boolean decline_button_click(int num) {
		int ship_count_before_decline_button_click = ship_count_decline();
		verbose("ship_count_before_decline_button_click :::: " + ship_count_before_decline_button_click);

		//this is to verify the decline button
		verbose("Clicking on the decline button");
		getElement(decline_button).click();

		if(num == 1) {
			String message = " You are about to decline the current list of\r\n" + 
					"1 Ship. this action is not reversible do you wish to continue?\r\n" + 
					"\r\n" + 
					"Tip: You can use the checkboxes to select fewer ships.";
			
			//String local = message.substring(beginIndex)
			
			verbose("The message for declining 1 ship is  :::::"  + message );
			verbose("The modal heading is :: " + getElement(modal_heading_single).getText() );
			verbose("The modal body is :: " + getElement(modal_body_single).getText() );
			//verbose("The modal body is :: " + getElement(modal_body_single).getAttribute("innerHTML"));
			verbose("The modal body is :: " + getElement(modal_body_single).getAttribute("innerText"));
			/*Stassert.assertEquals(getElement(modal_heading_single).getText(), "Decline 1 Ship","Title not expected");
			Stassert.assertEquals(getElement(modal_body_single).getText(), "You are about to decline the current list of\r\n" + 
					"1 Ship. this action is not reversible do you wish to continue?\r\n" + 
					"\r\n" + 
					"Tip: You can use the checkboxes to select fewer ships.","message not expected");
			Stassert.assertAll();*/
			String confMsg = getElement(modal_body_single).getAttribute("innerText");
		
			//assertTrue(confMsgTit.contains("Decline 1 Ship") && (confMsg.contains("You are about to decline the current list of ")));
				if(getElement(modal_heading_single).getText().equals("Decline 1 ship") && (confMsg.contains("You are about to decline the current selection of 1 ship.")) && (confMsg.contains("Do you wish to continue?"))) {
				verbose("Message seen for one ship correctly");
				return true;
			}else {
				verbose("Message NOT seen for one ship correctly");
				return false;
			}
			
		}
	
		else {
			verbose("The modal heading is :: " + getElement(modal_heading_single).getText() );
			verbose("The modal body is :: " + getElement(modal_body_single).getText() );
			String confMsg = getElement(modal_body_single).getAttribute("innerText");
			if(getElement(modal_heading_single).getText().equals("Decline 2 ships") && (confMsg.contains("You are about to decline the current selection of 2 ships.")) && (confMsg.contains("Do you wish to continue?"))) {
				verbose("Message seen for two ships correctly");
				return true;
			}else {
				verbose("Message seen for two ships correctly");
				return false;
			}
		}
	}

	public boolean decline_cancel_button_one_ship() {
		if(decline_cancel_button(1)) {
			verbose("Successfully clicked on Cancel button and the ship is still selected");
			return true;	
		}else {
			verbose("Successfully NOT clicked on Cancel button and the ship is still selected");
			return false;	
		}
	}
	
	public boolean decline_cancel_button_two_ships() {
		if(decline_cancel_button(2)) {
			verbose("Successfully clicked on Cancel button and the two ships are still selected");
			return true;	
		}else {
			verbose("Successfully NOT clicked on Cancel button and two ships are still selected");
			return false;	
		}
	}
	
	public boolean decline_cancel_button(int num) {
	
		//This is to verify the cancel button
		By ship_selected  = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-screening-table-totals/div[2]/div[2]");

		verbose("Clicking on the cancel button");
		getElement(modal_cancel).click();

		verbose("Checking the ship is selected after clicking on Cancel");
		verbose("ship_count_decline() ::: " + ship_count_decline());
		waitExplicitly(3);
	verbose("The number is " + getElement(ship_selected).getText());
		
		
		if(num == 1) {
			if(getElement(ship_selected).getText().equals("1 ship selected")) {
				verbose("Successfully Clicked on Cancel button");
				return true;			
			}else {
				verbose("NOT clicked on Cancel button successfully");
				return false;	
			}
		}else {
			if(getElement(ship_selected).getText().equals("2 ships selected")) {
				verbose("Successfully Clicked on Cancel button");
				return true;			
			}else {
				verbose("NOT clicked on Cancel button successfully");
				return false;	
			}
		}
	}

	public boolean decline_button() {
		// This is to verify the decline 

		waitExplicitly(3);
		verbose("Clicking on the Decline button");
		getElement(modal_decline).click();

		waitExplicitly(2);
		int ship_count_only_after_decline = ship_count_decline();
		verbose("ship_count_only_after_decline :::: " + ship_count_only_after_decline);

		if(ship_count_before_decline_button_click != ship_count_only_after_decline) {
			verbose("Successfully clicked on Decline button");
			return true;			
		}else {
			verbose("NOT clicked on Decline button successfully");
			return false;	
		}
	}

}
