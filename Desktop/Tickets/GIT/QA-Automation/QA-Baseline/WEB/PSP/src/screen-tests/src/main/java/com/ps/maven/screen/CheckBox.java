package com.ps.maven.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.ps.maven.utils.BrowserTypes;

public class CheckBox extends BrowserTypes{

	ScreeningResultsDeclinePage checkbox = new ScreeningResultsDeclinePage();
	By row_higlight1 = By.xpath("//ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[1]");
	By row_higlight2 = By.xpath("//psp-core/div/ps-screening-component/ps-screening-table/div/div/div[2]/ps-data-table/div/div/ps-data-table-row[2]");
	
	public boolean single_checkbox_click_higlight() {
		if(checkbox_click_higlight(1)) {
			verbose("Successfully clicked on the single checkbox");
			return true;
		}else {
			verbose("Unsuccessfully click on the single checkbox");
			return true;
		}
	}
	
	public boolean single_unclick_checkbox() {
		if(unclick_checkbox(1)) {
			verbose("Successfully unclicked on the single checkbox");
			return true;
		}else {
			verbose("Unsuccessfully unclick on the single checkbox");
			return true;
		}
	}
	
	public boolean multiple_checkbox_click_higlight() {
		if(checkbox_click_higlight(2)) {
			verbose("Successfully clicked on the multiple checkboxes");
			return true;
		}else {
			verbose("Unsuccessfully click on the multiple checkboxes");
			return true;
		}
	}	
	
	public boolean multiple_checkbox_unclick() {
		if(unclick_checkbox(2)) {
			verbose("Successfully unclicked on the multiple checkbox");
			return true;
		}else {
			verbose("Unsuccessfully unclick on the multiple checkbox");
			return true;
		}
	}
	
	public boolean checkbox_click_higlight(int num) {
		
		if(num == 1) {
		verbose("Clicking on the checkbox");
		waitExplicitly(2);
		getElement(checkbox.checkbox_1).click();
		waitExplicitly(3);
		String color = getElement(row_higlight1).getCssValue("background-color");
		verbose("The debug color is "  + color);
		String hex = Color.fromString(color).asHex();
		verbose("The HEX is ::: " + hex);
		
		//if(getElement(checkbox.checkbox_1).isSelected() &&  color.equals("rgba(33, 150, 243, 0.3)")){
			if(getElement(checkbox.checkbox_1).isSelected() &&  hex.equals("#2196f3")){
			verbose("The checkbox is selected successfully and the row is higlighted");
			return true;
		}else {
			verbose("The checkbox is NOT selected successfully and the row is higlighted");
			return false;
		}
		}else {
			verbose("Clicking on the multiple checkboxes");
			waitExplicitly(2);
			getElement(checkbox.checkbox_1).click();
			waitExplicitly(2);
			getElement(checkbox.checkbox_2).click();
			waitExplicitly(3);
			String color = getElement(row_higlight1).getCssValue("background-color");		
			String hex = Color.fromString(color).asHex();
			String color2 = getElement(row_higlight2).getCssValue("background-color");		
			String hex2 = Color.fromString(color2).asHex();
			//verbose("The HEX is ::: " + hex);
				
			if(getElement(checkbox.checkbox_1).isSelected() && getElement(checkbox.checkbox_2).isSelected() && hex.equals("#2196f3") && hex2.equals("#2196f3")) {
				verbose("The checkbox is selected successfully and the row is higlighted");
				return true;
			}else {
				verbose("The checkbox is NOT selected successfully and the row is higlighted");
				return false;
			}
		
		}
	}
	
	public boolean unclick_checkbox(int num) {
		
		if(num == 1) {
		verbose("Unclicking the checkbox");
		waitExplicitly(2);
		getElement(checkbox.checkbox_1).click();
		waitExplicitly(3);
		String color = getElement(row_higlight1).getCssValue("background-color");
		verbose("The debug color is "  + color);
		String hex = Color.fromString(color).asHex();
		verbose("The HEX is ::: " + hex);
			
		if(!getElement(checkbox.checkbox_1).isSelected() && hex.equals("#000000")) {
			verbose("The checkbox is unselected successfully");
			return true;
		}else {
			verbose("The checkbox is NOT unselected successfully");
			return false;
		}
		}else {
			verbose("Unclicking the mutiple checkboxes");
			waitExplicitly(2);
			getElement(checkbox.checkbox_1).click();
			waitExplicitly(2);
			getElement(checkbox.checkbox_2).click();
			waitExplicitly(3);
			String color = getElement(row_higlight1).getCssValue("background-color");		
			String hex = Color.fromString(color).asHex();
			String color1 = getElement(row_higlight2).getCssValue("background-color");		
			String hex1 = Color.fromString(color1).asHex();
			//verbose("The HEX is ::: " + hex);
				
			if(!getElement(checkbox.checkbox_1).isSelected() && hex.equals("#000000") && !getElement(checkbox.checkbox_2).isSelected() && hex1.equals("#000000")) {
				verbose("The mutiple checkbox is unselected successfully");
				return true;
			}else {
				verbose("The mutiple checkbox is NOT unselected successfully");
				return false;
			}
		}
	}
	
}
