package speedvariance.manage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/*import Notification_resources.BasePage;
import Notification_resources.LoginPage;*/

import scriptResources.*;

import com.thoughtworks.selenium.webdriven.commands.GetElementPositionLeft;
import com.thoughtworks.selenium.webdriven.commands.GetText;

public class AdminSpeedVarianceAlarmSettingsPage extends BasePage{

	// This is the constructor for this class
	public AdminSpeedVarianceAlarmSettingsPage(WebDriver driver) {
		super(driver);

	}

	LoginPage loginPage = new LoginPage(getDriver());

	By administration_menu = By.linkText("Administration");
	By speedvariance_click = By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div/div[6]/a/div[1]");
	
	By alarmsettings_heading = By.cssSelector("h3");
	By alarmsettings_subtitle = By.cssSelector("div.text-muted");
	By changetab_tooltip = By.xpath("//psp-app/ps-speed-variance/div/div[1]/div[2]/button");
	By apply_button = By.xpath("//ps-alarm-settings/div/div[2]/button[2]");
	By cancel_button = By.xpath("//ps-alarm-settings/div/div[2]/button[1]");
	By ship_settings_button = By.xpath("//ps-speed-variance/div/div/div[2]/a");
	By alarm_settings_button = By.xpath("//ps-speed-variance/div/div/div[1]/a");

	//This module is click on speed Variance menu
	public boolean adminSpeedVarianceClick(){
		waitExplicitly(3);
		getElement(administration_menu).click();//Click on Administration menu at the top right corner
		verbose("Clicked on Adminitration menu");
		waitExplicitly(3);
		getElement(speedvariance_click).click();//Now clicking on SpeedVariance menu 
		verbose("Admin->Speed Variance menu is clicked");
		waitExplicitly(3);
		if(getElement(alarmsettings_heading).getText().equals("Alarm Settings") && getElement(alarmsettings_subtitle).getText().equals("Set the speed threshold for which you would like to receive alarms outside of the vessel's planned speed")){
			return true;
		}
		return false;		
	}

	//This module is check the tool-tip when changing the tabs
	public boolean verifyVesselsettingsTabtooltip(){
		verbose("Checking the tool-tip");
		Actions action = new Actions(getDriver());
		waitExplicitly(5);
		WebElement tool_tip = getElement(ship_settings_button);
		waitExplicitly(5);
		action.moveToElement(tool_tip).build().perform();
		waitExplicitly(5);
		String tool_tip_text = tool_tip.getAttribute("tooltiptext");

		verbose("The tool-tip is: " + tool_tip_text);
		waitExplicitly(5);
		if(tool_tip_text.equals("Performing this action will clear unapplied changes")){
			verbose("The tool-tip is seen");
			return true;
		}else{
			verbose("The tool-tip is not seen");
			return false;
		}
	}

	//This module is to verify the Average Speed Deviation alarm definitions
	public boolean verifyAverageSpeedDeviation(){
		waitExplicitly(3);
		int count = 0;
		By max_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-slider[1]/div/ps-range-slider/span[2]");
		By min_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-slider[1]/div/ps-range-slider/span[1]");
		By right_arrow_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-slider[1]/div/ps-range-slider/button[2]");
		By left_arrow_Speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-slider[1]/div/ps-range-slider/button[1]/i");
		By left_arrow_deviation_period_of = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-slider[2]/div/ps-range-slider/button[1]/i");
		By right_arrow_deviation_period_of = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-slider[2]/div/ps-range-slider/button[2]");
		By alarm_level = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-summary/div/div[1]/ps-alarm-severity/div");
		By alarm_definition1 = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-summary/div/p/span[1]");
		By alarm_definition2 = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-summary/div/p/span[2]");
		By average_speeddeviation_heading = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-slider[1]/div/span");
		By deviation_over_a_period_of_heading = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-slider[2]/div/span");
		By speed_deviation_value = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-summary/div/p/span[1]/span");
		By speed_deviation_period_value = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-summary/div/p/span[2]/span");

		By average_speed_activate_name = By.xpath("//ps-average-speed/div/div[1]/div/div[1]/span");
		By average_speed_activate_toggle_button = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-summary/div/div[2]/div[1]/ps-toggle-button/div/label");
		By average_speed_auto_clear_toggle_button = By.xpath("//ps-alarm-settings/div/div[1]/div[2]/ps-alarm-summary/div/div[2]/div[2]/ps-toggle-button/div/label/span[1]");

		String initial_def1 = getElement(alarm_definition1).getText() ;
		String initial_def2 = getElement(alarm_definition2).getText();
		String alarm_initial_definition = initial_def1 + " " + initial_def2;
		verbose("The initial definition is " + alarm_initial_definition);
		String speed_deviation_value1 = getElement(speed_deviation_value).getText();
		verbose(speed_deviation_value1);
		waitExplicitly(3);
		String speed_deviation_period_value1 = getElement(speed_deviation_period_value).getText();
		verbose(speed_deviation_period_value1);
		waitExplicitly(3);

		/*//This is to drag the slider 
		By slider_position = By.xpath("//ps-alarm-settings/div[2]/div[1]/ps-average-speed/div/div[2]/div[1]/ps-slider/div/div[2]/input");
		int widthSliderBar = getElement(slider_position).getSize().width;
		verbose("The silder width is " + widthSliderBar);
		int offset = widthSliderBar/100 ;
		verbose("The offset is "+ offset);
		Actions move = new Actions(getDriver());
		WebElement slider = getElement(slider_position);
		if(getElement(speed_deviation_value).getText() != "0.5 kn" && getElement(speed_deviation_period_value).getText() != "10 min"){
		Action action = move.dragAndDropBy(slider, 15, 0).build();
		action.perform();
		}
		if(getElement(speed_deviation_value).getText() != "0.5 kn" && getElement(speed_deviation_period_value).getText() != "10 min"){
		 for (int i=0; i < 100; i++) {
	            move.dragAndDropBy(slider, 15, 0).perform();
	            //waitExplicitly(2);
	            System.out.println("Moved: (" + (i+1) + ")" + slider.getCssValue("left"));
	        }
		}*/

		//This is to verify the left and right arrow under speed deviation
		verbose("******This is to verify the left and right arrow under speed deviation*********");
		waitExplicitly(3);

		if(getElement(speed_deviation_value).getText().equals("0.5 kn") && getElement(speed_deviation_period_value).getText().equals("10 min")){
			for(int i=0;i<=2;i++){
				getElement(right_arrow_speed_deviation).click();
				getElement(right_arrow_deviation_period_of).click();
				i++;
			}
			verbose("The alarm definition is : " + getElement(alarm_definition1).getText() + " " + getElement(alarm_definition2).getText());

			waitExplicitly(2);
			getElement(left_arrow_Speed_deviation).click();
			getElement(left_arrow_deviation_period_of).click();
			waitExplicitly(2);
			verbose("The alarm definition is : " + getElement(alarm_definition1).getText() + " " + getElement(alarm_definition2).getText());
		}else if(getElement(speed_deviation_value).getText().equals("25 kn") && getElement(speed_deviation_period_value).getText().equals("180 min")){
			for(int i=0;i<=2;i++){
				getElement(left_arrow_Speed_deviation).click();
				getElement(left_arrow_deviation_period_of).click();
				i++;
			}
			waitExplicitly(2);
			verbose("The alarm definition is : " + getElement(alarm_definition1).getText() + " " + getElement(alarm_definition2).getText());
			getElement(right_arrow_speed_deviation).click();
			getElement(right_arrow_deviation_period_of).click();
			verbose("The alarm definition is : " + getElement(alarm_definition1).getText() + " " +getElement(alarm_definition2).getText());
		}else if(getElement(speed_deviation_value).getText().equals("1 kn") && getElement(speed_deviation_period_value).getText().equals("20 min")){
			for(int i=0;i<1;i++){
				getElement(left_arrow_Speed_deviation).click();
				getElement(left_arrow_deviation_period_of).click();
				i++;
			}
			waitExplicitly(2);
			for(int i=0;i<4;i++){
				verbose("The alarm definition is : " + getElement(alarm_definition1).getText() + " " + getElement(alarm_definition2).getText());
				getElement(right_arrow_speed_deviation).click();
				getElement(right_arrow_deviation_period_of).click();
				verbose("The alarm definition is : " + getElement(alarm_definition1).getText() + " " + getElement(alarm_definition2).getText());
			}
		}
		else{
			for(int i=0;i<=2;i++){
				getElement(left_arrow_Speed_deviation).click();
				getElement(left_arrow_deviation_period_of).click();
				i++;
			}
			verbose("The alarm definition is : " + getElement(alarm_definition1).getText() + " " + getElement(alarm_definition2).getText());
			waitExplicitly(2);
			getElement(right_arrow_speed_deviation).click();
			getElement(right_arrow_deviation_period_of).click();

			verbose("The alarm definition is : " + getElement(alarm_definition1).getText()+ " " + getElement(alarm_definition2).getText());
		}


		waitExplicitly(1);
		verbose("The definition is " + getElement(alarm_definition1).getText() + " " + getElement(alarm_definition2).getText());

		String string_moved = getElement(alarm_definition1).getText() + " " + getElement(alarm_definition2).getText();
		//This condition will check if the left and right arrow is moved successfully
		if(string_moved.equals("Average speed deviates " + getElement(speed_deviation_value).getText() + " above or below the Planned Speed over a period of " + getElement(speed_deviation_period_value).getText())){
			verbose("***The left and right arrow under speed deviation is moved successfully***");
			count++;
		}else{
			verbose("***The left and right arrow under speed deviation is NOT moved successfully***");
		}

		verbose("The alarm def is......" + alarm_initial_definition);
		//This is to verify the APPLY and CANCEL button are enabled
		int random1 = randInt(1,2);
		verbose("The random number selected is :" + random1);
		if(random1 == 1){
			apply_button();
			waitExplicitly(2);
			verbose("APPLY button is clicked");
			if(value_confirmation_vessel_settings()){
				String definition = "Average speed deviates " + getElement(speed_deviation_value).getText() + " above or below the Planned Speed over a period of " + getElement(speed_deviation_period_value).getText();
				verbose("The changed value is :" + definition);
				waitExplicitly(5);
				verbose("The definition seen after APPLY is :" + definition);
				if(!definition.equals(alarm_initial_definition)){
					verbose("*****Average Speed Deviation is SAVED********");
					count ++;

				}else{
					verbose("*****Average Speed Deviation is APPLY button is not working********");
					count --;
				}
			}
		}else{
			cancel_button();
			waitExplicitly(2);
			verbose("CANCEL button is clicked");
			if(value_confirmation_vessel_settings()){
				String definition2 = "Average speed deviates " + getElement(speed_deviation_value).getText() + " above or below the Planned Speed over a period of " + getElement(speed_deviation_period_value).getText();
				verbose("The changed value is :" + definition2);
				waitExplicitly(5);
				if(definition2.equals(alarm_initial_definition)){
					verbose("*****Average Speed Deviation is NOT SAVED as CANCEL was selected********");
					count ++;
				}else{
					verbose("*****Average Speed Deviation CANCEL not working********");
					count --;
				}
			}
		}

		waitExplicitly(2);


		//This is check the alaram_level
		if(getElement(alarm_level).getText().equals("MAJOR")){
			verbose("**********MAJOR severity is seen**********");
			count ++;			
		}else{
			verbose("MAJOR severity is not seen");
			count--;
		}
		//This is to the max value of the slider in Speed deviation
		if(getElement(max_speed_deviation).getText().equals("25 kn") && getElement(min_speed_deviation).getText().equals("0.5 kn")){
			verbose("*********Max deviation value and min speed deviation values are correct*******");
			count ++;
		}else{
			verbose("*********Max deviation value and min speed deviation values are incorrect************");
			count--;
		}
		//This is to check the "Speed deviation above or below Planned Speed" heading
		if(getElement(average_speeddeviation_heading).getText().equals("Speed deviation above or below Planned Speed")){		
			verbose("*********\"Speed deviation above or below Planned Speed\" heading is correct*********");
			count ++;
		}else{
			verbose("*********\"Speed deviation above or below Planned Speed\" heading is INCORRECT*********");
			count--;
		}
		//This is to check the "Deviation over a period of" heading
		if(getElement(deviation_over_a_period_of_heading).getText().equals("Deviation over a period of")){
			verbose("*********\"Deviation over a period of\" heading is correct*********");
			count ++;
		}else{
			verbose("*********\"Deviation over a period of\" heading is NOT correct*********");
			count --;
		}


		//This is to verify the activate toggle buttons
		if(getElement(average_speed_activate_toggle_button).isEnabled()){
			verbose("Clicking on the activate toggle OFF button");
			getElement(average_speed_activate_toggle_button).click();
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(average_speed_activate_toggle_button).isSelected()){
						verbose("*****activate toggle OFF is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(average_speed_activate_toggle_button).isEnabled()){
						verbose("*****activate toggle OFF is NOT SAVED********");
						count ++;
					}
				}
			}

		}else{
			verbose("Clicking on the activate toggle ON button");
			getElement(average_speed_activate_toggle_button).click();
			waitExplicitly(2);
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(average_speed_activate_toggle_button).isEnabled()){
						verbose("*****activate toggle ON is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(average_speed_activate_toggle_button).isSelected()){
						verbose("*****activate toggle ON is NOT SAVED********");
						count ++;
					}
				}
			}
		}

		//This is to verify the Auto-clear toggle buttons
		if(getElement(average_speed_auto_clear_toggle_button).isEnabled()){
			verbose("Clicking on the Auto-clear toggle OFF button");
			getElement(average_speed_auto_clear_toggle_button).click();
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(average_speed_auto_clear_toggle_button).isSelected()){
						verbose("*****Auto_clear toggle OFF is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(average_speed_auto_clear_toggle_button).isEnabled()){
						verbose("*****activate toggle OFF is NOT SAVED********");
						count ++;
					}
				}
			}

		}else{
			verbose("Clicking on the Auto_clear toggle ON button");
			getElement(average_speed_auto_clear_toggle_button).click();
			waitExplicitly(2);
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(average_speed_auto_clear_toggle_button).isEnabled()){
						verbose("*****Auto_clear toggle ON is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(average_speed_auto_clear_toggle_button).isSelected()){
						verbose("*****Auto_clear toggle ON is NOT SAVED********");
						count ++;
					}
				}
			}
		}




		verbose("count is " + count);

		if( count == 8){
			return true;
		}else{
			return false;
		}

	}

	public boolean verifyAccelaratedSpeedDeviation(){
		int count = 0;
		By accelarated_speed_deviation_above_value = By.xpath("//ps-speed-variance/div/ps-alarm-settings/div/div[1]/div[3]/ps-alarm-summary/div/p/span[1]");		
		By accelarated_speed_deviation_below_value = By.xpath("//ps-speed-variance/div/ps-alarm-settings/div/div[1]/div[3]/ps-alarm-summary/div/p/span[2]");
		By accelarated_speed_deviation_period_value = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-summary/div/p/span[3]");
		By accelarated_left_arrow_above_Speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[1]/div/ps-range-slider/button[1]/i");
		By accelarated_left_arrow_below_Speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[2]/div/ps-range-slider/button[1]/i");
		By accelarated_left_arrow_deviation_period_of = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[3]/div/ps-range-slider/button[1]/i");
		By accelarated_alarm_definition1 = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-summary/div/p/span[1]");
		By accelarated_alarm_definition2 =By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-summary/div/p/span[2]");
		By accelarated_alarm_definition3 = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-summary/div/p/span[3]");
		By accelarated_right_arrow_above_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[1]/div/ps-range-slider/button[2]");
		By accelarated_right_arrow_below_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[2]/div/ps-range-slider/button[2]");
		By accelarated_right_arrow_deviation_period_of = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[3]/div/ps-range-slider/button[2]");
		By accelarated_alarm_level = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-summary/div/div[1]/ps-alarm-severity/div/span");
		By accelarated_max_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[1]/div/ps-range-slider/span[2]");
		By accelarated_min_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[1]/div/ps-range-slider/span[1]");
		By accelarated_max_speed_deviation_below = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[2]/div/ps-range-slider/span[2]");
		By accelarated_min_speed_deviation_below = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[2]/div/ps-range-slider/span[1]");
		By accelarated_min_Deviation_for_a_period_of = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[3]/div/ps-range-slider/span[1]");
		By accelarated_max_Deviation_for_a_period_of = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[3]/div/ps-range-slider/span[2]");
		By accelarated_above_speeddeviation_heading = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[1]/div/span");
		By accelarated_below_speeddeviation_heading = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[2]/div/span");
		By accelarated_deviation_over_a_period_of_heading = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-slider[3]/div/span");
		By accelarated_speed_activate_toggle_button = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-summary/div/div[2]/div[1]/ps-toggle-button/div/label");
		By accelarated_speed_auto_clear_toggle_button = By.xpath("//ps-alarm-settings/div/div[1]/div[3]/ps-alarm-summary/div/div[2]/div[2]/ps-toggle-button/div/label/span[1]");

		String initial_def = getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText();
		verbose("Initial def is +" + initial_def);

		//This is to verify the left and right arrow under speed deviation
		verbose("******This is to verify the left and right arrow under speed deviation*********");
		waitExplicitly(3);

		if(getElement(accelarated_speed_deviation_above_value).getText().equals("0.5 kn") && getElement(accelarated_speed_deviation_below_value).getText().equals("0.5 kn")&& getElement(accelarated_speed_deviation_period_value).getText().equals("10 min")){
			for(int i=0;i<2;i++){
				getElement(accelarated_right_arrow_above_speed_deviation).click();
				getElement(accelarated_right_arrow_below_speed_deviation).click();
				getElement(accelarated_right_arrow_deviation_period_of).click();
				i++;
			}
			verbose("The right arrow definition is " + getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText());

			waitExplicitly(2);
			getElement(accelarated_left_arrow_above_Speed_deviation).click();
			getElement(accelarated_left_arrow_below_Speed_deviation).click();
			getElement(accelarated_left_arrow_deviation_period_of).click();
			waitExplicitly(2);
			verbose("The left definition is " + getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText());
		}else if(getElement(accelarated_speed_deviation_above_value).getText().equals("25 kn") && getElement(accelarated_speed_deviation_below_value).getText().equals("25 kn") && getElement(accelarated_speed_deviation_period_value).getText().equals("180 min")){
			for(int i=0;i<2;i++){
				getElement(accelarated_left_arrow_above_Speed_deviation).click();
				getElement(accelarated_left_arrow_below_Speed_deviation).click();
				getElement(accelarated_left_arrow_deviation_period_of).click();
				i++;
			}
			waitExplicitly(2);
			verbose("The left definition is " + getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText());
			getElement(accelarated_right_arrow_above_speed_deviation).click();
			getElement(accelarated_right_arrow_below_speed_deviation).click();
			getElement(accelarated_right_arrow_deviation_period_of).click();
			verbose("The right definition is " + getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText());
		}else if(getElement(accelarated_speed_deviation_above_value).getText().equals("1 kn") && getElement(accelarated_speed_deviation_below_value).getText().equals("1 kn") && getElement(accelarated_speed_deviation_period_value).getText().equals("20 min")){
			for(int i=0;i<1;i++){
				getElement(accelarated_left_arrow_above_Speed_deviation).click();
				getElement(accelarated_left_arrow_below_Speed_deviation).click();
				getElement(accelarated_left_arrow_deviation_period_of).click();
				i++;
			}
			verbose("The left definition is " + getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText());
			waitExplicitly(2);
			for(int i=0;i<4;i++){
				//	getElement(accelarated_alarm_definition).getText();
				getElement(accelarated_right_arrow_above_speed_deviation).click();
				getElement(accelarated_right_arrow_below_speed_deviation).click();
				getElement(accelarated_right_arrow_deviation_period_of).click();
				
			}
			verbose("The right definition is " + getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText());
		}else{
			verbose("Inside the \"else\" condition where speed and time are not at 0.5 or 25 or 10 or 180");
			for(int i=0;i<2;i++){
				getElement(accelarated_left_arrow_above_Speed_deviation).click();
				getElement(accelarated_left_arrow_below_Speed_deviation).click();
				
				i++;
			}if(getElement(accelarated_speed_deviation_period_value).getText().equals("20 min")){
			getElement(accelarated_left_arrow_deviation_period_of).click();
			}
			verbose("The left definition is " + getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText());
			waitExplicitly(2);
			for(int i=0;i<3;i++){
			getElement(accelarated_right_arrow_above_speed_deviation).click();
			getElement(accelarated_right_arrow_below_speed_deviation).click();
			getElement(accelarated_right_arrow_deviation_period_of).click();
			}
			verbose("The right definition is " + getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText());
		}


		waitExplicitly(1);
		verbose("The definition is " + getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText());
		String definition = getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText();
		verbose("sdjffgsdfgsdf ::::: " + getElement(accelarated_speed_deviation_above_value).getText() + " " + getElement(accelarated_speed_deviation_below_value).getText() + " " + getElement(accelarated_speed_deviation_period_value).getText());
		//This condition will check if the left and right arrow is moved successfully
		if(definition.equals(getElement(accelarated_speed_deviation_above_value).getText() + " " + getElement(accelarated_speed_deviation_below_value).getText() + " " + getElement(accelarated_speed_deviation_period_value).getText())){
			verbose("***The left and right arrow under speed deviation is moved successfully***");
			count++;
		}else{
			verbose("***The left and right arrow under speed deviation is NOT moved successfully***");
		}


		waitExplicitly(2);
		verbose("The changed value is :" + definition);
		verbose("The alarm def is......" + initial_def);

		//This is to verify the APPLY and CANCEL button are enabled
		int random1 = randInt(1,2);
		verbose("The random number selected is :" + random1);
		if(random1 == 1){
			apply_button();
			waitExplicitly(2);
			verbose("APPLY button is clicked");
			if(value_confirmation_vessel_settings()){
				String definition1 = getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText();
				verbose("The changed value is :" + definition1);
				if(!initial_def.equals(definition1)){
					verbose("*****Accelarated Speed Deviation is SAVED********");
					count ++;

				}else{
					verbose("*****Accelarated Speed Deviation is APPLY button is not working********");
					count --;
				}
			}
		}else{
			cancel_button();
			waitExplicitly(2);
			verbose("CANCEL button is clicked");
			if(value_confirmation_vessel_settings()){
				String definition1 = getElement(accelarated_alarm_definition1).getText() + " " + getElement(accelarated_alarm_definition2).getText() + " " + getElement(accelarated_alarm_definition3).getText();
				verbose("The changed value is :" + definition1);
				if(initial_def.equals(definition1)){
					verbose("*****Accelarated Speed Deviation is NOT SAVED as CANCEL was selected********");
					count ++;
				}else{
					verbose("*****Accelarated Speed Deviation CANCEL not working********");
					count --;
				}
			}
		}

		//This is check the alaram_level
		if(getElement(accelarated_alarm_level).getText().equals("MAJOR")){
			verbose("**********MAJOR severity is seen**********");
			count ++;			
		}else{
			verbose("MAJOR severity is not seen");
		}
		//This is to check the max & min value of the slider in above Planned Speed deviation
		if(getElement(accelarated_max_speed_deviation).getText().equals("25 kn") && getElement(accelarated_min_speed_deviation).getText().equals("0.5 kn")){
			verbose("*********Max and Min deviation value and min speed deviation values are correct*******");
			count ++;
		}else{
			verbose("*********Max and Min deviation value and min speed deviation values are incorrect************");
			count--;
		}
		//This is to the check the max & min value of the slider in below Planned Speed deviation
		if(getElement(accelarated_max_speed_deviation_below).getText().equals("25 kn") && getElement(accelarated_min_speed_deviation_below).getText().equals("0.5 kn")){
			verbose("*********Max and Min deviation value and min speed deviation values are correct*******");
			count ++;
		}else{
			verbose("*********Max and Min deviation value and min speed deviation values are incorrect************");
			count--;
		}

		//This is to the check the max & min value of the slider in Deviation for a period of
		if(getElement(accelarated_max_Deviation_for_a_period_of).getText().equals("180 min") && getElement(accelarated_min_Deviation_for_a_period_of).getText().equals("10 min")){
			verbose("*********Max and Min \"Deviation for a period of\" values are correct*******");
			count ++;
		}else{
			verbose("*********Max and Min \"Deviation for a period of\" values are correct*******");
			count--;
		}

		//This is to check the "Speed deviation above" heading
		if(getElement(accelarated_above_speeddeviation_heading).getText().equals("Speed deviation above Planned Speed")){		
			verbose("*********\"Speed deviation above or below Planned Speed\" heading is correct*********");
			count ++;
		}else{
			verbose("*********\"Speed deviation above or below Planned Speed\" heading is INCORRECT*********");
			count--;
		}

		//This is to check the "Speed deviation below" heading
		if(getElement(accelarated_below_speeddeviation_heading).getText().equals("Speed deviation below Planned Speed")){		
			verbose("*********\"Speed deviation above or below Planned Speed\" heading is correct*********");
			count ++;
		}else{
			verbose("*********\"Speed deviation above or below Planned Speed\" heading is INCORRECT*********");
			count--;
		}
		//This is to check the "Deviation over a period of" heading
		if(getElement(accelarated_deviation_over_a_period_of_heading).getText().equals("Deviation for a period of")){
			verbose("*********\"Deviation for a period of\" heading is correct*********");
			count ++;
		}else{
			verbose("*********\"Deviation for a period of\" heading is NOT correct*********");
			count--;
		}


		//This is to verify the activate toggle buttons
		if(getElement(accelarated_speed_activate_toggle_button).isEnabled()){
			verbose("Clicking on the activate toggle OFF button");
			getElement(accelarated_speed_activate_toggle_button).click();
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(accelarated_speed_activate_toggle_button).isSelected()){
						verbose("*****activate toggle OFF is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(accelarated_speed_activate_toggle_button).isEnabled()){
						verbose("*****activate toggle OFF is NOT SAVED********");
						count ++;
					}
				}
			}

		}else{
			verbose("Clicking on the activate toggle ON button");
			getElement(accelarated_speed_activate_toggle_button).click();
			waitExplicitly(2);
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(accelarated_speed_activate_toggle_button).isEnabled()){
						verbose("*****activate toggle ON is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(accelarated_speed_activate_toggle_button).isSelected()){
						verbose("*****activate toggle ON is NOT SAVED********");
						count ++;
					}
				}
			}
		}

		//This is to verify the Auto-clear toggle buttons
		if(getElement(accelarated_speed_auto_clear_toggle_button).isEnabled()){
			verbose("Clicking on the Auto-clear toggle OFF button");
			getElement(accelarated_speed_auto_clear_toggle_button).click();
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(accelarated_speed_auto_clear_toggle_button).isSelected()){
						verbose("*****Auto_clear toggle OFF is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(accelarated_speed_auto_clear_toggle_button).isEnabled()){
						verbose("*****activate toggle OFF is NOT SAVED********");
						count ++;
					}
				}
			}

		}else{
			verbose("Clicking on the Auto_clear toggle ON button");
			getElement(accelarated_speed_auto_clear_toggle_button).click();
			waitExplicitly(2);
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(accelarated_speed_auto_clear_toggle_button).isEnabled()){
						verbose("*****Auto_clear toggle ON is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(accelarated_speed_auto_clear_toggle_button).isSelected()){
						verbose("*****Auto_clear toggle ON is NOT SAVED********");
						count ++;
					}
				}
			}
		}


		verbose("count is " + count);

		if( count == 11){
			return true;
		}else{
			return false;
		}					

	}

	public boolean verifySingleSpeedDeviation(){
		int count = 0;
		By left_arrow_above_Speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[1]/div/ps-range-slider/button[1]");
		By left_arrow_below_Speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[2]/div/ps-range-slider/button[1]/i");
		By singlespeed_alarm_definition1 = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-summary/div/p/span[1]");
		By singlespeed_alarm_definition2 = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-summary/div/p/span[2]");
		By singlespeed_alarm_definition3 = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-summary/div/p/span[3]");
		By right_arrow_above_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[1]/div/ps-range-slider/button[2]/i");
		By right_arrow_below_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[2]/div/ps-range-slider/button[2]");
		By singlespeed_alarm_level = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-summary/div/div[1]/ps-alarm-severity/div/span");
		By singlespeed_max_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[1]/div/ps-range-slider/span[2]");
		By singlespeed_min_speed_deviation = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[1]/div/ps-range-slider/span[1]");
		By singlespeed_max_speed_deviation_below = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[2]/div/ps-range-slider/span[2]");
		By singlespeed_min_speed_deviation_below = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[2]/div/ps-range-slider/span[1]");
		By singlespeed_above_speeddeviation_heading = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[1]/div/span");
		By singlespeed_below_speeddeviation_heading = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[2]/div/span");
		By single_speed_activate_toggle_button = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-summary/div/div[2]/div[1]/ps-toggle-button/div/label");
		By single_speed_auto_clear_toggle_button = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-summary/div/div[2]/div[2]/ps-toggle-button/div/label");
		By single_speed_deviation_above_value = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[1]/div");
		By single_speed_deviation_below_value = By.xpath("//ps-alarm-settings/div/div[1]/div[4]/ps-alarm-slider[2]/div");

		String initial_def = getElement(singlespeed_alarm_definition1).getText()+ " " + getElement(singlespeed_alarm_definition2).getText() + " " + getElement(singlespeed_alarm_definition3).getText();
		verbose("Initial def is : " + initial_def);

		//This is to verify the left and right arrow under speed deviation
		verbose("******This is to verify the left and right arrow under speed deviation*********");
		waitExplicitly(3);

		if(getElement(single_speed_deviation_above_value).getText().equals("0.5 kn") && getElement(single_speed_deviation_below_value).getText().equals("0.5 kn")){
			for(int i=0;i<=2;i++){
				getElement(right_arrow_above_speed_deviation).click();
				getElement(right_arrow_below_speed_deviation).click();
				i++;
			}
			//getElement(singlespeed_alarm_definition).getText();

			waitExplicitly(2);
			getElement(left_arrow_above_Speed_deviation).click();
			getElement(left_arrow_below_Speed_deviation).click();
			waitExplicitly(2);
			//getElement(singlespeed_alarm_definition).getText();
		}else if(getElement(single_speed_deviation_above_value).getText().equals("25 kn") && getElement(single_speed_deviation_below_value).getText().equals("25 kn")){
			for(int i=0;i<=2;i++){
				getElement(left_arrow_above_Speed_deviation).click();
				getElement(left_arrow_below_Speed_deviation).click();
				i++;
			}
			waitExplicitly(2);
			//	getElement(singlespeed_alarm_definition).getText();
			getElement(right_arrow_above_speed_deviation).click();
			getElement(right_arrow_below_speed_deviation).click();
			//	getElement(singlespeed_alarm_definition).getText();
		}else if(getElement(single_speed_deviation_above_value).getText().equals("1 kn") && getElement(single_speed_deviation_below_value).getText().equals("1 kn")){
			for(int i=0;i<1;i++){
				getElement(left_arrow_above_Speed_deviation).click();
				getElement(left_arrow_below_Speed_deviation).click();
				i++;
			}
			waitExplicitly(2);
			for(int i=0;i<4;i++){
				//getElement(singlespeed_alarm_definition).getText();
				getElement(right_arrow_above_speed_deviation).click();
				getElement(right_arrow_below_speed_deviation).click();
				//getElement(singlespeed_alarm_definition).getText();
			}
		}else{
			for(int i=0;i<=2;i++){
				getElement(left_arrow_above_Speed_deviation).click();
				getElement(left_arrow_below_Speed_deviation).click();
				i++;
			}
			//	getElement(singlespeed_alarm_definition).getText();
			waitExplicitly(2);
			getElement(right_arrow_above_speed_deviation).click();
			getElement(right_arrow_below_speed_deviation).click();

			//	getElement(singlespeed_alarm_definition).getText();
		}


		waitExplicitly(1);
		verbose("The definition is : " + getElement(singlespeed_alarm_definition1).getText()+ " " + getElement(singlespeed_alarm_definition2).getText() + " " + getElement(singlespeed_alarm_definition3).getText());
		String definition = getElement(singlespeed_alarm_definition1).getText()+ " " + getElement(singlespeed_alarm_definition2).getText() + " " + getElement(singlespeed_alarm_definition3).getText();

		//verbose("sdkjfhsdfhjusdfhg ::::: " +  getElement(single_speed_deviation_above_value).getText() + " " + getElement(single_speed_deviation_below_value).getText());
		//This condition will check if the left and right arrow is moved successfully
		if(!definition.equals(initial_def)){
			verbose("***The left and right arrow under speed deviation is moved successfully***");
			count++;
		}else{
			verbose("***The left and right arrow under speed deviation is NOT moved successfully***");
		}


		int random1 = randInt(1,2);
		verbose("The random number selected is :" + random1);
		if(random1 == 1){
			apply_button();
			waitExplicitly(2);
			verbose("APPLY button is clicked");
			if(value_confirmation_vessel_settings()){
				String def1 = getElement(singlespeed_alarm_definition1).getText()+ " " + getElement(singlespeed_alarm_definition2).getText() + " " + getElement(singlespeed_alarm_definition3).getText();
				verbose("The value after APPLY : " + def1);
				if(!initial_def.equals(def1)){
					verbose("*****Single Speed Deviation is SAVED********");
					count ++;

				}else{
					verbose("*****Single Speed Deviation is APPLY button is not working********");
					count --;
				}
			}
		}else{
			cancel_button();
			waitExplicitly(2);
			verbose("CANCEL button is clicked");
			if(value_confirmation_vessel_settings()){
				String def2 = getElement(singlespeed_alarm_definition1).getText()+ " " + getElement(singlespeed_alarm_definition2).getText() + " " + getElement(singlespeed_alarm_definition3).getText();
				verbose("The value after CANCEL : " + def2);
				if(initial_def.equals(def2)){
					verbose("*****Single Speed Deviation is NOT SAVED as CANCEL was selected********");
					count ++;
				}else{
					verbose("*****Single Speed Deviation CANCEL not working********");
					count --;
				}
			}
		}
		//This is check the alaram_level
		if(getElement(singlespeed_alarm_level).getText().equals("MAJOR")){
			verbose("**********MAJOR severity is seen**********");
			count ++;			
		}else{
			verbose("MAJOR severity is not seen");
			count --;
		}
		//This is to the max & min value of the slider in above Planned Speed deviation
		if(getElement(singlespeed_max_speed_deviation).getText().equals("25 kn") && getElement(singlespeed_min_speed_deviation).getText().equals("0.5 kn")){
			verbose("*********Max deviation value and min speed deviation values are correct*******");
			count ++;
		}else{
			verbose("*********Max deviation value and min speed deviation values are incorrect************");
			count --;
		}
		//This is to the max & min value of the slider in below Planned Speed deviation
		if(getElement(singlespeed_max_speed_deviation_below).getText().equals("25 kn") && getElement(singlespeed_min_speed_deviation_below).getText().equals("0.5 kn")){
			verbose("*********Max deviation value and min speed deviation values are correct*******");
			count ++;
		}else{
			verbose("*********Max deviation value and min speed deviation values are incorrect************");
			count --;
		}
		//This is to check the "Speed deviation above" heading
		if(getElement(singlespeed_above_speeddeviation_heading).getText().equals("Speed deviation above Planned Speed")){		
			verbose("*********\"Speed deviation above or below Planned Speed\" heading is correct*********");
			count ++;
		}else{
			verbose("*********\"Speed deviation above or below Planned Speed\" heading is INCORRECT*********");
			count --;
		}

		//This is to check the "Speed deviation below" heading
		if(getElement(singlespeed_below_speeddeviation_heading).getText().equals("Speed deviation below Planned Speed")){		
			verbose("*********\"Speed deviation above or below Planned Speed\" heading is correct*********");
			count ++;
		}else{
			verbose("*********\"Speed deviation above or below Planned Speed\" heading is INCORRECT*********");
			count --;
		}



		//This is to verify the activate toggle buttons
		if(getElement(single_speed_activate_toggle_button).isEnabled()){
			verbose("Clicking on the activate toggle OFF button");
			getElement(single_speed_activate_toggle_button).click();
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(single_speed_activate_toggle_button).isSelected()){
						verbose("*****activate toggle OFF is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(single_speed_activate_toggle_button).isEnabled()){
						verbose("*****activate toggle OFF is NOT SAVED********");
						count ++;
					}
				}
			}

		}else{
			verbose("Clicking on the activate toggle ON button");
			getElement(single_speed_activate_toggle_button).click();
			waitExplicitly(2);
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(single_speed_activate_toggle_button).isEnabled()){
						verbose("*****activate toggle ON is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(single_speed_activate_toggle_button).isSelected()){
						verbose("*****activate toggle ON is NOT SAVED********");
						count ++;
					}
				}
			}
		}

		//This is to verify the Auto-clear toggle buttons
		if(getElement(single_speed_auto_clear_toggle_button).isEnabled()){
			verbose("Clicking on the Auto-clear toggle OFF button");
			getElement(single_speed_auto_clear_toggle_button).click();
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(single_speed_auto_clear_toggle_button).isSelected()){
						verbose("*****Auto_clear toggle OFF is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(single_speed_auto_clear_toggle_button).isEnabled()){
						verbose("*****activate toggle OFF is NOT SAVED********");
						count ++;
					}
				}
			}

		}else{
			verbose("Clicking on the Auto_clear toggle ON button");
			getElement(single_speed_auto_clear_toggle_button).click();
			waitExplicitly(2);
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(single_speed_auto_clear_toggle_button).isEnabled()){
						verbose("*****Auto_clear toggle ON is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(single_speed_auto_clear_toggle_button).isSelected()){
						verbose("*****Auto_clear toggle ON is NOT SAVED********");
						count ++;
					}
				}
			}
		}

		verbose("count is " + count);

		if( count == 9){
			return true;
		}else{
			return false;
		}					


	}

	public boolean verifyNoPlannedSpeedDeviation(){
		int count = 0;
		By nospeed_alarm_level = By.xpath("//ps-alarm-settings/div/div[1]/div[5]/ps-alarm-summary/div/div[1]/ps-alarm-severity/div/span");
		By no_speed_activate_toggle_button = By.xpath("//ps-alarm-settings/div/div[1]/div[5]/ps-alarm-summary/div/div[2]/div[1]/ps-toggle-button/div/label");
		By no_speed_auto_clear_toggle_button = By.xpath("//ps-alarm-settings/div/div[1]/div[5]/ps-alarm-summary/div/div[2]/div[2]/ps-toggle-button/div/label");
		By noplanned_speeddeviation_heading = By.xpath("//ps-alarm-settings/div/div[1]/div[5]/ps-alarm-summary/div/p/span");

		//This is check the alaram_level
		if(getElement(nospeed_alarm_level).getText().equals("WARNING")){
			verbose("**********WARNING severity is seen**********");
			count ++;			
		}else{
			verbose("WARNING severity is not seen");
			count --;
		}

		//This is to check the "Speed deviation below" heading
		if(getElement(noplanned_speeddeviation_heading).getText().equals("No planned speed applied to the ship")){		
			verbose("*********\"No planned speed applied to the ship\" heading is correct*********");
			count ++;
		}else{
			verbose("*********\"No planned speed applied to the ship\" heading is INCORRECT*********");
			count --;
		}

		//This is to verify the activate toggle buttons
		if(getElement(no_speed_activate_toggle_button).isEnabled()){
			verbose("Clicking on the activate toggle OFF button");
			getElement(no_speed_activate_toggle_button).click();
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(no_speed_activate_toggle_button).isSelected()){
						verbose("*****activate toggle OFF is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(no_speed_activate_toggle_button).isEnabled()){
						verbose("*****activate toggle OFF is NOT SAVED********");
						count ++;
					}
				}
			}

		}else{
			verbose("Clicking on the activate toggle ON button");
			getElement(no_speed_activate_toggle_button).click();
			waitExplicitly(2);
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(no_speed_activate_toggle_button).isEnabled()){
						verbose("*****activate toggle ON is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(no_speed_activate_toggle_button).isSelected()){
						verbose("*****activate toggle ON is NOT SAVED********");
						count ++;
					}
				}
			}
		}

		//This is to verify the Auto-clear toggle buttons
		if(getElement(no_speed_auto_clear_toggle_button).isEnabled()){
			verbose("Clicking on the Auto-clear toggle OFF button");
			getElement(no_speed_auto_clear_toggle_button).click();
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(no_speed_auto_clear_toggle_button).isSelected()){
						verbose("*****Auto_clear toggle OFF is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(no_speed_auto_clear_toggle_button).isEnabled()){
						verbose("*****activate toggle OFF is NOT SAVED********");
						count ++;
					}
				}
			}

		}else{
			verbose("Clicking on the Auto_clear toggle ON button");
			getElement(no_speed_auto_clear_toggle_button).click();
			waitExplicitly(2);
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(no_speed_auto_clear_toggle_button).isEnabled()){
						verbose("*****Auto_clear toggle ON is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(no_speed_auto_clear_toggle_button).isSelected()){
						verbose("*****Auto_clear toggle ON is NOT SAVED********");
						count ++;
					}
				}
			}
		}


		verbose("count is " + count);

		if( count == 4){
			return true;
		}else{
			return false;
		}					

	}

	public boolean verifyOverdueSpeedDeviation(){
		int count = 0;
		By odspeed_alarm_level = By.xpath("//ps-alarm-settings/div/div[1]/div[6]/ps-alarm-summary/div/div[1]/ps-alarm-severity/div/span");
		By od_speed_activate_toggle_button = By.xpath("//ps-alarm-settings/div/div[1]/div[6]/ps-alarm-summary/div/div[2]/div[1]/ps-toggle-button/div/label");
		By od_speed_auto_clear_toggle_button = By.xpath("//ps-alarm-settings/div/div[1]/div[6]/ps-alarm-summary/div/div[2]/div[2]/ps-toggle-button/div/label");
		By od_speeddeviation_heading = By.xpath("//ps-alarm-settings/div/div[1]/div[6]/ps-alarm-summary/div/p/span");

		//This is check the alaram_level
		if(getElement(odspeed_alarm_level).getText().equals("MINOR")){
			verbose("**********MINOR severity is seen**********");
			count ++;			
		}else{
			verbose("MINOR severity is not seen");
			count --;
		}
		//This is to check the "Speed deviation below" heading
		if(getElement(od_speeddeviation_heading).getText().equals("Ship not reporting for more than 60 min")){		
			verbose("*********\"Ship not reporting for more than 60 min\" heading is correct*********");
			count ++;
		}else{
			verbose("*********\"Ship not reporting for more than 60 min\" heading is INCORRECT*********");
			count --;
		}

		//This is to verify the activate toggle buttons
		if(getElement(od_speed_activate_toggle_button).isEnabled()){
			verbose("Clicking on the activate toggle OFF button");
			getElement(od_speed_activate_toggle_button).click();
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(od_speed_activate_toggle_button).isSelected()){
						verbose("*****activate toggle OFF is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(od_speed_activate_toggle_button).isEnabled()){
						verbose("*****activate toggle OFF is NOT SAVED********");
						count ++;
					}
				}
			}

		}else{
			verbose("Clicking on the activate toggle ON button");
			getElement(od_speed_activate_toggle_button).click();
			waitExplicitly(2);
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(od_speed_activate_toggle_button).isEnabled()){
						verbose("*****activate toggle ON is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(od_speed_activate_toggle_button).isSelected()){
						verbose("*****activate toggle ON is NOT SAVED********");
						count ++;
					}
				}
			}
		}

		//This is to verify the Auto-clear toggle buttons
		if(getElement(od_speed_auto_clear_toggle_button).isEnabled()){
			verbose("Clicking on the Auto-clear toggle OFF button");
			getElement(od_speed_auto_clear_toggle_button).click();
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(od_speed_auto_clear_toggle_button).isSelected()){
						verbose("*****Auto_clear toggle OFF is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(od_speed_auto_clear_toggle_button).isEnabled()){
						verbose("*****activate toggle OFF is NOT SAVED********");
						count ++;
					}
				}
			}

		}else{
			verbose("Clicking on the Auto_clear toggle ON button");
			getElement(od_speed_auto_clear_toggle_button).click();
			waitExplicitly(2);
			waitExplicitly(2);
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			if(random == 1){
				apply_button();
				waitExplicitly(2);
				verbose("APPLY button is clicked");
				if(value_confirmation_vessel_settings()){
					if(getElement(od_speed_auto_clear_toggle_button).isEnabled()){
						verbose("*****Auto_clear toggle ON is SAVED********");
						count ++;
					}
				}
			}else{
				cancel_button();
				waitExplicitly(2);
				verbose("CANCEL button is clicked");
				if(value_confirmation_vessel_settings()){
					if(!getElement(od_speed_auto_clear_toggle_button).isSelected()){
						verbose("*****Auto_clear toggle ON is NOT SAVED********");
						count ++;
					}
				}
			}
		}

		verbose("count is " + count);

		if( count == 4){
			return true;
		}else{
			return false;
		}					

	}

	public boolean value_confirmation_vessel_settings(){
		waitExplicitly(1);
		getElement(ship_settings_button).click();
		waitExplicitly(1);
		getElement(alarm_settings_button).click();
		return true;		
	}

	public boolean apply_button(){
		if(getElement(apply_button).isEnabled()){
			waitExplicitly(1);
			getElement(apply_button).click();
			waitExplicitly(1);
			return true;
		}else{
			return false;
		}
	}

	public boolean cancel_button(){
		if(getElement(cancel_button).isEnabled()){
			waitExplicitly(1);
			getElement(cancel_button).click();
			waitExplicitly(1);
			return true;
		}else{
			return false;
		}

	}

	public static int randInt(int min, int max) {

		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public boolean right_left_arrow_verification(){

		return true;

	}
}
