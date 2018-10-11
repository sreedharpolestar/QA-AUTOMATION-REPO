package reports;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;


//import modules.LoginModule;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import administration.*;

import com.thoughtworks.selenium.condition.ConditionRunner.Context;

import pageObjectMethods.Account;
import pageObjectMethods.LandingPage;
import pageObjectMethods.Reports;
import scriptResources.*;
import testDatas.AccountTestData;
import testEnviroments.Log;
import testEnviroments.enviroments;
//import Notification_resources.BasePage;
//import Notification_resources.LoginPage;

public class PositionReport extends BasePage {
	
	/*LoginPage loginPage = new LoginPage(getDriver());*/
	
	/*LoginPage loginPage = new LoginPage(getDriver());
	
	Logger log = Logger.getLogger("Logger");*/
	
	public PositionReport(WebDriver driver) {
		super(driver);
	}
	

	
// Reports module navigation and verifying the header
	
	@Test
	public static void positionReport(WebDriver driver) throws Throwable{
			
			Logger log = Logger.getLogger("Logger");
			Thread.sleep(3000);
		/*	driver.get(enviroments.url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			log.info("Web application launched");
			// Login
			LoginModule.login(driver);
			Thread.sleep(3000);*/
			Reports.reports_menu(driver).click();
			log.info("Reports menu clicked");
			Thread.sleep(3000);
			
/*//Verifying the Reports header text
			
			String Reports_header_exp = "Reports";
		
			String Reports_header_act = Reports.reports_title_header(driver).getText();
			Assert.assertEquals(Reports_header_exp, Reports_header_act);
			log.info("Reports header text is getting deisplayed as :  " + Reports_header_act);*/
			 
//Verifying Create a new report button
	
	String Createanewreport = "Create a new report";
	
	String create_report= Reports.create_report_button(driver).getText();
	Assert.assertEquals(Createanewreport, create_report);
	log.info("Create new report button is getting displayed on the reports page");

//Verifying the clicking on the Create a new report button
	
	Reports.create_report_button(driver).click();
	log.info("Clicked on Create new report button");
	
/*//Verifying Create a new report page after clicking on "Create a new report" button

	//header text validation
	String Create_new_report_exp = "Create a new report";
	String Create_new_report_act= Reports.create_new_report_title_header(driver).getText();
	Assert.assertEquals(Create_new_report_exp, Create_new_report_act);
	log.info("Create new report page header is getting displayed as : " + Create_new_report_act);
	
	//Sub header text validation
		String Create_new_report_subtitle_exp = "Select the type of report that you wish to run from the set of standard reports";
		String Create_new_report_subtitle_act= Reports.create_new_report_subtitle_(driver).getText();
		Assert.assertEquals(Create_new_report_subtitle_exp, Create_new_report_subtitle_act);
		log.info("Create new report page sub title is getting displayed as : " + Create_new_report_subtitle_exp);*/
		
//Filter drop box values validation
		
		
		
		Reports.create_new_report_filter(driver).click();
		
		/*int count = 0;
		Thread.sleep(100);
		
		String Option_1 = "Ship reports";
		String Option_1_act = Reports.create_new_report_filter_ShipReports(driver).getText();
		Assert.assertEquals(Option_1, Option_1_act);
		log.info("First drop down option is displayed as   :" + Option_1_act);
		if (Option_1_act == Option_1){
			count++;		
		}
		String Option_2 = "Position reports";
		String Option_2_act = Reports.create_new_report_filter_PositionReports(driver).getText();
		Assert.assertEquals(Option_2, Option_2_act);
		log.info("Second drop down option is displayed as   :" + Option_2_act);
		if (Option_2_act == Option_2){
			count++;			
		}
		Thread.sleep(100);
		String Option_3 = "Account reports";
		String Option_3_act = Reports.create_new_report_filter_AccountReports(driver).getText();
		Assert.assertEquals(Option_3, Option_3_act);
		log.info("Third drop down option is displayed as   :" + Option_3_act);
		if (Option_3 == Option_3_act){
			count++;			
		}
		Thread.sleep(100);
		String Option_4 = "User reports";
		String Option_4_act = Reports.create_new_report_filter_UserReports(driver).getText();
		Assert.assertEquals(Option_4, Option_4_act);
		log.info("Fourth drop down option is displayed as   :" + Option_4_act);
		if (Option_4 == Option_4_act){
			count++;			
		}
		
		Thread.sleep(100);
		String Option_5 = "Fleet reports";
		String Option_5_act = Reports.create_new_report_filter_FleetReports(driver).getText();
		Assert.assertEquals(Option_5, Option_5_act);
		log.info("Fifth drop down option is displayed as   :" + Option_5_act);
		if (Option_5 == Option_5_act){
			count++;			
		}
		
		Thread.sleep(100);
		String Option_6 = "Custom";
		String Option_6_act = Reports.create_new_report_filter_Custom(driver).getText();
		Assert.assertEquals(Option_6, Option_6_act);
		log.info("Sixth drop down option is displayed as   :" + Option_6_act);
		if (Option_6 == Option_6_act){
			count++;			
		}
		
		Thread.sleep(100);
		String Option_7 = "hello";
		String Option_7_act = Reports.create_new_report_filter_hello(driver).getText();
		Assert.assertEquals(Option_7, Option_7_act);
		log.info("Seventh drop down option is displayed as   :" + Option_7_act);
		if (Option_7 == Option_7_act){
			count++;	
			
			log.info("Create a new report filter options count is  :" + count);
		}*/
		/*Thread.sleep(100);
		
		log.info("Ship reports, Position reports, Account reports, User reports, Fleet reports, Custom and hello are exist in the Filter dropdown as expected");
		
		if (count==7){
		
			return true;
		} else {
			return false;
		}*/
	
//Creating a new report for Position reports
		
	 
	
		/*public static  void shipReport(WebDriver driver) throws Throwable {*/
			
			 //Selecting the Position report option from the drop down
			
			Reports.create_new_report_filter_PositionReports(driver).click();
			
            //Verifying the header of Position reports
			
			String Positionreport_header = "Position reports";
			Thread.sleep(1000);
			String Positionreport_header_act = Reports.create_new_report_filter_PositionReports_Title(driver).getText();
			Assert.assertEquals(Positionreport_header, Positionreport_header_act);
			Log.info("Position report title is getting displayed as : " + Positionreport_header_act );
			
			Thread.sleep(1000);
			
			//Verifying the New position report link
			
			String NewpositionReport_link = "New position report";
			String NewpositionReport_link_act = Reports.create_new_report_filter_Positions_NewShipReport_link(driver).getText();
			Assert.assertEquals(NewpositionReport_link, NewpositionReport_link_act);
			Log.info("New position report link is getting displayed as : " + NewpositionReport_link_act );
			
			Thread.sleep(1000);
			
		
			//Clicking on the New position report link and validating the header title & sub-title of New postion report page
			
			Reports.create_new_report_filter_Positions_NewShipReport_link(driver).click();
			
			String NewPositionReport_tile = "New position report";
			String NewPositionReport_tile_act = driver.findElement(By.xpath("//div[2]/div/div[1]/div/div/h3")).getText();
			
			Assert.assertEquals(NewPositionReport_tile, NewPositionReport_tile_act);
			Log.info("New position report page's title is getting displayed as : " + NewPositionReport_tile_act );
			
			Thread.sleep(1000);
			
			String NewPositionReport_subtile = "Create a Report based on New position report model";
			String NewPositionReport_subtile_act = driver.findElement(By.xpath("//div[2]/div[2]/div/div[1]/div/p")).getText();
			Assert.assertEquals(NewPositionReport_subtile, NewPositionReport_subtile_act);
			Log.info("New Position report page's title is getting displayed as : " + NewPositionReport_subtile_act );
			
			Thread.sleep(1000);
			
//Creating the new Position report by selecting/filling all the required details
			
			//Verifying whether user able to enter Report name into New Position report name text filed
			
			Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).clear();
			
			Thread.sleep(3000);
			
			Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).sendKeys("Position Report");
			
			String positionreportName = Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).getText();
			
			Thread.sleep(3000);
			
			//Verifying the Filters drop down options and selecting options from those
			
			String[] exp = {"Position Creating Date","Position Terminal","Position LES","Position Longitude(decimal)","Position Latitude (decimal)","Position SOG Reported","Position SOG Calculated","Position COG Reported","Position COG Calculated"
					,"Position Source","Account Company Name","Ship Status","Creation date","Ship Name","Fleet Name","Ship Flag Name","Ship IMO Numner","MMSI","Ship Call Sign"};
			
			
			WebElement dropdown = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters(driver);
			Select select = new Select(dropdown);  
			List<WebElement> options = select.getOptions();  
			
			Log.info("expected length" + exp.length);
			for(WebElement we:options)  
			{ 
				
				  for (int i=0; i<exp.length; i++){
				      if (we.getText().equals(exp[i])){
				      System.out.println(we.getText());  
			}  
			 }  
			
			}	
			
	//Randomly selecting the options from the drop down		
			
			int random = randInt(1,3);
			verbose("The random number selected is :" + random);
			
			if(random == 1){
				select.selectByVisibleText("Position Creation Date");
			}else if(random == 2){
				select.selectByVisibleText("Position Terminal");
			}else{
				select.selectByVisibleText("Position Source");
			}
				
			
	String selected_Filter_option = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters(driver).getText();
	
	if(selected_Filter_option == "Position Creation Date"){
		
		String[] exp1 = {"Less than or equal to","Greater than or equal to"};
		
		 WebElement dropdown0 = driver.findElement(By.xpath("//div[2]/div[2]/select"));
				 
		 Select select1 = new Select(dropdown0);  

		 //Selecting the Less than or equal to drop down value
		 
		 select1.selectByVisibleText("Less than or equal to");
		 
		 String Option_selected = driver.findElement(By.xpath("//div[2]/div[2]/select")).getText();
	
		 //Getting the todays's date
		
	       
	       driver.findElement(By.xpath("//div/div[2]/div[2]/div[3]/div/input")).sendKeys("2017-05-22");
	   
		 
		 String Position_creationDate_selected = driver.findElement(By.xpath("//div/div[2]/div[2]/div[3]/div/input")).getText();
		 
		 Thread.sleep(3000);
		 
	}else if(selected_Filter_option == "Position Terminal"){
		
		
		WebElement dropdown2 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select2 = new Select(dropdown2);  

		 //Selecting the Greater than or equal to drop down value
		 
		 select2.selectByVisibleText("Greater than or equal to");
		 
		 driver.findElement(By.xpath("//div/div[2]/div[2]/div[3]/div/input")).sendKeys("2017-05-22");
		 
		 String PositionTerminal_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 Thread.sleep(1000);
		
		 
		 String PositionTerminal_date_selected = driver.findElement(By.xpath("//div/div[2]/div[2]/div[3]/div/input")).getText();
		
		 Thread.sleep(1000);
		
	}else{
		WebElement dropdown2 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select2 = new Select(dropdown2);  

		 //Selecting the Active drop down value
		 
		 select2.selectByVisibleText("Contains");
		 
		 String PositionSource_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).sendKeys("Pole");
		 
		 String PositionSource_given = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).getText();
		 
		 Thread.sleep(3000);
	}
		
		
			 //Clicking on "Add another" button
			 
			 Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Add(driver).click();
			 
			 
			 //Validating & Selecting the options from the Filters drop downs
			 
			 
			/* String[] exp2 = {"Ship status","Alert status","Ship IMO Number","Fleet Name","Creation date","Account Company Name"};*/
			 WebElement dropdown3 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_1(driver);
			 Select select2 = new Select(dropdown3); 
				
			 select2.selectByVisibleText("Ship Flag Name");
			 
			 Thread.sleep(1000);
			 
			 String[] exp3 = {"Exactly","Starts with"};
			 WebElement dropdown4 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_1(driver);
			 Select select3 = new Select(dropdown4);  
		
			 //Selecting Exactly option from the drop down
			 select3.selectByVisibleText("Starts with");
			 
			 String ShipFlagName_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_1(driver).getText();
			 
			 
			 Thread.sleep(3000);
			 
			 //Entering the Ship IMO Number in text field
			
		     driver.findElement(By.xpath("//div/div[2]/div/form/div/div[3]/div[1]/div[3]/input")).sendKeys("A");
		     
		     String ShipFlagName_given = driver.findElement(By.xpath("//div/div[2]/div/form/div/div[3]/div[1]/div[3]/input")).getText();
		     
		     /*//Clickin on Add another button to select Account Company Name option from the drop down
		     
		     driver.findElement(By.xpath("//div/form/div/div[3]/div[2]/button")).click();
		     
			 WebElement dropdown5 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_2(driver);
			 Select select4 = new Select(dropdown5); 
				
			 select4.selectByVisibleText("Account Company Name");
			 
			 Thread.sleep(3000);
			 
			 WebElement dropdown6 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_2(driver);
			 Select select5 = new Select(dropdown6);  
		
			 //Selecting Contains option from the drop down
			 select5.selectByVisibleText("Contains");
			 
			 String AccountCompanyName_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_2(driver).getText();
		 
			//Entering the Account Company Name in text field
				
		     driver.findElement(By.xpath("//div/form/div/div[4]/div[1]/div[3]/input")).sendKeys("Pole");
		     
		     String AccountCompanyName_given = driver.findElement(By.xpath("//div/form/div/div[4]/div[1]/div[3]/input")).getText();
		     
		     Thread.sleep(3000);*/
		     
//Dragging General Information values from Available fields  to Report fields   
	

		    	    	WebElement  sourceElement = Reports.create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_1(driver);
		    	        //WebElement dragTo = driver.findElement(By.id("div1"));
		    	    	WebElement targetElement = Reports.targetElement(driver);
		    	    
		    	    	
		    	    	Actions act = new Actions(driver);
		    	    	 
		    	        // Script for dragging an element and dropping it in another place
		    	      
		    	     
		    	       
		    	        System.out.println(sourceElement.getLocation());
		    	     
		    	        
		    	        System.out.println(targetElement.getLocation());
		    	        
		    	        act.dragAndDropBy(sourceElement, 611,544).perform();
		    	        
		    	        Thread.sleep(7000);
		    	       
		    	        
//Clicking on Run report and create a template button to generate the report
		    	        
		    	        
		    	        Reports.runReport_createtemplate_button(driver).click();
		    	        
		    	        
	
	
//Verifying the confirmation pop-up after clicking on Run report and create a template
	
	String Popup_text_exp = "Please wait while the report is being generated";
	
	String Popup_text_act = Reports.reports_title_header(driver).getText();
	
	Assert.assertEquals(Popup_text_exp, Popup_text_act);
	
	logger.info("Confirmation pop-up is getting displayed upon clicking on Run report and create template button");
	
	
//Clicking on confirmation pop-up 'OK' button 
	
	Reports.pop_Up_Ok(driver).click();
	
//Navigating back to the Reports module to validate the generated report
	
	Reports.reports_menu(driver).click();

		
	Reports.searchBox(driver).clear();
	Reports.searchBox(driver).click();
		verbose("Typing in the search box....");
	Reports.searchBox(driver).sendKeys(positionreportName);
	
	String PositionReport_found = Reports.search_contains(driver).getText();
	
	Assert.assertEquals(PositionReport_found, positionreportName);
		
	Log.info("Position report is generated successfully");	

	
//Validating the generated ship report details
	
	Reports.search_contains(driver).click();
	
	Thread.sleep(1000);
	
	//Verifying header title
	
	String positionreport_Header_act = driver.findElement(By.xpath("//div[2]/div[2]/div/div[1]/div/h3/span")).getText();
	
	Assert.assertEquals("Position report", positionreport_Header_act);
	
	//Verifying for the READY text on header
	
	String Ready_exp = "READY";
	
	String Ready_act = driver.findElement(By.xpath("//div[2]/div/div[1]/div/h3/div/span")).getText();
	Assert.assertEquals(Ready_exp, Ready_act);
	
	log.info("Ready text is appears on header part of report");
	
    //Verifying the Filters section 
	
	
String Filters_1row_1column = driver.findElement(By.xpath("//div/div[2]/div/form/div/div[1]/div[2]/div[1]")).getText();

	
	if(Filters_1row_1column == "Position Creation Date"){
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Less than or equal to");
		
		Assert.assertEquals(Filters_1row_3column, "2017-05-22");
		
		Log.info("Filters section first row details are correct when Position Creation Date is selected");
		 
	}else if(Filters_1row_1column == "Position Terminal"){
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Greater than or equal to");
		
		Assert.assertEquals(Filters_1row_3column, "2017-05-22");
		
		Log.info("Filters section first row details are correct when Position Terminal is selected");
		
		 Thread.sleep(3000);
		
	}else if(Filters_1row_1column == "Position Source"){
		
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Contains");
		
		Assert.assertEquals(Filters_1row_3column, "Pole");
		
		Log.info("Filters section first row details are correct when Position Source is selected");
		
		 Thread.sleep(3000);
		 
	}else if(Filters_1row_1column == "Ship Flag Name"){
		
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, ShipFlagName_selected);
		
		Assert.assertEquals(Filters_1row_3column, ShipFlagName_given);
		
		Log.info("Filters section first row details are correct when Ship Flag Name is selected");
		
		 Thread.sleep(3000);
	}
	
	
/*//Verifying the Report fields 
	
********************
*********************
*******************
*****************


Have to write the code once drag & drop issue is resolved.
	
	
//
*/	
	
	
//Verifying the Share level section
	
	String Sharelevel_text = driver.findElement(By.xpath("//div/div[2]/div/form/div/div[5]/span")).getText();
	
	Assert.assertEquals(Sharelevel_text, "Only creator can see");
	
	Log.info("Share level section details are correct");
	
//Verifying the Report format section
	
String Reportf_format_type = driver.findElement(By.xpath("//div/form/div/div[6]/span")).getText();
	
	Assert.assertEquals(Reportf_format_type, "CSV");
	
	Log.info("Report format section details are correct");
	
	

	
//Verifying the Clone report into a report template functionality
	
	//Clicking on Clone report into a report template button
	
	
	Reports.CloneReport(driver).click();
	
	//Validating the Clone Report Template page 
	
	    //Template name validation

	String TemplateName_act = driver.findElement(By.cssSelector("#form__item__name")).getText();
			
     Assert.assertEquals(TemplateName_act, "Position Report (clone)");
	
	Log.info("Template name details are correct");
	
	   //Template group validation
	
	String TemplateGroup_exp = "Custom";
	
	String TemplateGroup_act = driver.findElement(By.cssSelector("#form__item__group")).getText();
	
    Assert.assertEquals(TemplateGroup_exp, TemplateGroup_act);
	
	Log.info("Template group details are correct");
	
	//Updating the Template name 
	
	driver.findElement(By.cssSelector("#form__item__name")).clear();
	
	driver.findElement(By.cssSelector("#form__item__name")).sendKeys("A Cloned Position report");
	
	String Updated_clonedreport_name = driver.findElement(By.cssSelector("#form__item__name")).getText();

	//Clicking on Save
	
	Reports.CloneReport_Save(driver).click();
	
	log.info("cloned report is saved successfully");
	
	
//Verifying the details on Report templates page after cloning the report
	
	//Templates page header validation

			String Templates_header_exp1 = "Report templates";

			String Templates_header_act1 = Reports.Templates_header(driver).getText();
				
			Assert.assertEquals(Templates_header_exp1, Templates_header_act1);

			Log.info("Templates header is getting displayed as : " + Templates_header_act1);	



			//Searching for the updated cloned report

			driver.findElement(By.xpath("//div/div/input")).sendKeys(Updated_clonedreport_name);

			//Verifying whether cloned report name got updated or not

			driver.findElement(By.xpath("//div/div/a/div[1]")).click();


			String Updated_clonedreport_name_actual = driver.findElement(By.cssSelector("#form__item__name")).getText();


			Assert.assertEquals(Updated_clonedreport_name_actual, Updated_clonedreport_name);


			Log.info("Cloned report got updated in the Custom report templates list");	
	
	
	}
		    	        public static int randInt(int min, int max) {
		    	    	    
		    	    	    Random rand = new Random();
		    	        
		    	    	    int randomNum = rand.nextInt((max - min) + 1) + min;

		    	    	    return randomNum;
		    	    	}
			
	
}