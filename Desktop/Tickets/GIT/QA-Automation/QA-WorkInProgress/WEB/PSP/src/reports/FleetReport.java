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

//import modules.HighlightElement;

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

public class FleetReport extends BasePage {
	
	/*LoginPage loginPage = new LoginPage(getDriver());*/
	
	/*LoginPage loginPage = new LoginPage(getDriver());
	
	Logger log = Logger.getLogger("Logger");*/
	
	public FleetReport(WebDriver driver) {
		super(driver);
	}
	
// Reports module navigation and verifying the header
	
	@Test
	public static void fleetReport(WebDriver driver) throws Throwable{
			
			Logger log = Logger.getLogger("Logger");
			Thread.sleep(3000);
			Reports.reports_menu(driver).click();
			log.info("Reports menu clicked");
			Thread.sleep(3000);
			
			 
//Verifying Create a new report button
	
	String Createanewreport = "Create a new report";
	
	String create_report= Reports.create_report_button(driver).getText();
	Assert.assertEquals(Createanewreport, create_report);
	log.info("Create new report button is getting displayed on the reports page");

//Verifying the clicking on the Create a new report button
	
	Reports.create_report_button(driver).click();
	log.info("Clicked on Create new report button");
		
	
	//Clicking on the Filter drop down
		Reports.create_new_report_filter(driver).click();
		
	//Selecting the Fleet report from the Filter drop down
		
			Reports.create_new_report_filter_FleetReports(driver).click();
			
			//Clicking on New fleet report link
			
			Reports.create_new_report_filter_FleetReports_link(driver).click();
		
			
            //Verifying the header of Fleet reports
			
			String Fleetreport_header = "New fleet report";
			Thread.sleep(1000);
			String Fleetreport_header_act = Reports.create_new_report_filter_FleetReports_Title(driver).getText();
			Assert.assertEquals(Fleetreport_header, Fleetreport_header_act);
			Log.info("New Fleet report title is getting displayed as : " + Fleetreport_header_act );
			
			String NewFleetReport_subtile = "Create a Report based on New fleet report model";
			String NewFleetReport_subtile_act = driver.findElement(By.xpath("//div[2]/div/div[1]/div/p")).getText();
		
			Assert.assertEquals(NewFleetReport_subtile, NewFleetReport_subtile_act);
			Log.info("New Fleet report page sub title is getting displayed as : " + NewFleetReport_subtile_act );
			
			Thread.sleep(1000);
			
//Creating the new Fleet report by selecting/filling all the required details
			
			//Verifying whether user able to enter Report name into New Fleet report name text filed
			
			Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).clear();
			
			Thread.sleep(3000);
			
			Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).sendKeys("Fleet Report");
			
			String fleetreportName = Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).getText();
			
			Thread.sleep(1000);
			
			//Verifying the Filters drop down options and selecting options from those
			
			String[] exp = {"Creation date","Status","Name"};
			
			
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
			
			int random = randInt(1,2);
			verbose("The random number selected is :" + random);
			
			if(random == 1){
				select.selectByVisibleText("Status");
			}else {
				select.selectByVisibleText("Name");
			}
				
			
	String selected_Filter_option = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters(driver).getText();
	
	 if(selected_Filter_option == "Status"){
		
		
		 
		String[] exp2 = {"Active","Deleted"};
		
		 WebElement dropdown1 = driver.findElement(By.xpath("//div[2]/div[3]/select"));
				 
		 Select select1 = new Select(dropdown1);  

		 //Selecting the Deleted option from drop down value
		 
		 select1.selectByVisibleText("Active");
		 
		 String Status_Exactly_Type_selected = driver.findElement(By.xpath("//div[2]/div[3]/select")).getText();
	      
		 String Status_Exactly_selected  = driver.findElement(By.xpath("//div[2]/div[2]/select")).getText();
		 
		 Thread.sleep(3000);
		
	}else{
		WebElement dropdown2 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select2 = new Select(dropdown2);  

		 //Selecting the Active drop down value
		 
		 select2.selectByVisibleText("Contains");
		 
		 String Name_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).sendKeys("P");
		 
		 String Name_given = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).getText();
		 
		 Thread.sleep(3000);
	}
		
		     
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
	
	//**************Need to write some loop to get the report which was generated through above steps******************//
	
	Reports.reports_menu(driver).click();
	
	Reports.searchBox(driver).clear();
	Reports.searchBox(driver).click();
		verbose("Typing in the search box....");
	Reports.searchBox(driver).sendKeys(fleetreportName);
	
	String fleetreportName_found = Reports.search_contains(driver).getText();
	
	Assert.assertEquals(fleetreportName_found, fleetreportName);
		
	Log.info("Fleet report is generated successfully");	

	
//Validating the generated Fleet report details
	
	Reports.search_contains(driver).click();
	
	Thread.sleep(1000);
	
	//Verifying header title
	
	String fleetreport_Header_act = driver.findElement(By.xpath("//div[2]/div[2]/div/div[1]/div/h3/span")).getText();

	
	Assert.assertEquals(fleetreportName, fleetreport_Header_act);
	
	//Verifying for the READY text on header
	
	String Ready_exp = "READY";
	
	String Ready_act = driver.findElement(By.xpath("//div[2]/div/div[1]/div/h3/div/span")).getText();
	Assert.assertEquals(Ready_exp, Ready_act);
	
	
    //Verifying the Filters section 
	
	
String Filters_1row_1column = driver.findElement(By.xpath("//div/div[2]/div/form/div/div[1]/div[2]/div[1]")).getText();

	
	if(Filters_1row_1column == "Status"){
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Exactly");
		
		Assert.assertEquals(Filters_1row_3column, "ACTIVE");
		
		Log.info("Filters section first row details are correct when Status is selected");
		 
	}else if(Filters_1row_1column == "Name"){
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Contains");
		
		Assert.assertEquals(Filters_1row_3column, "P");
		
		Log.info("Filters section first row details are correct when Name is selected");
		
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
			
     Assert.assertEquals(TemplateName_act, "Fleet Report (clone)");
	
	Log.info("Template name details are correct");
	
	   //Template group validation
	
	String TemplateGroup_exp = "Custom";
	
	String TemplateGroup_act = driver.findElement(By.cssSelector("#form__item__group")).getText();
	
    Assert.assertEquals(TemplateGroup_exp, TemplateGroup_act);
	
	Log.info("Template group details are correct");
	
	//Updating the Template name 
	
	driver.findElement(By.cssSelector("#form__item__name")).clear();
	
	driver.findElement(By.cssSelector("#form__item__name")).sendKeys("A Cloned Fleet report");
	
	String Updated_clonedreport_name = driver.findElement(By.cssSelector("#form__item__name")).getText();

	//Clicking on Save
	
	Reports.CloneReport_Save(driver).click();
	
	
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