package reports;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
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

public class ReportsPage extends BasePage {
	
	LoginPage loginPage = new LoginPage(getDriver());
	
	/*LoginPage loginPage = new LoginPage(getDriver());
	
	Logger log = Logger.getLogger("Logger");*/
	
	public ReportsPage(WebDriver driver) {
		super(driver);
	}
	
// Reports module navigation and verifying the header
	
	@Test
	public static Boolean reports(WebDriver driver) throws Throwable{
			
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
			
//Verifying the Reports header text
			
			String Reports_header_exp = "Reports";
		
			String Reports_header_act = Reports.reports_title_header(driver).getText();
			Assert.assertEquals(Reports_header_exp, Reports_header_act);
			log.info("Reports header text is getting deisplayed as :  " + Reports_header_act);
			 
//Verifying Create a new report button
	
	String Createanewreport = "Create a new report";
	
	String create_report= Reports.create_report_button(driver).getText();
	Assert.assertEquals(Createanewreport, create_report);
	log.info("Create new report button is getting displayed on the reports page");

//Verifying the clicking on the Create a new report button
	
	Reports.create_report_button(driver).click();
	log.info("Clicked on Create new report button");
	
//Verifying Create a new report page after clicking on "Create a new report" button

	//header text validation
	String Create_new_report_exp = "Create a new report";
	String Create_new_report_act= Reports.create_new_report_title_header(driver).getText();
	Assert.assertEquals(Create_new_report_exp, Create_new_report_act);
	log.info("Create new report page header is getting displayed as : " + Create_new_report_act);
	
	//Sub header text validation
		String Create_new_report_subtitle_exp = "Select the type of report that you wish to run from the set of standard reports";
		String Create_new_report_subtitle_act= Reports.create_new_report_subtitle_(driver).getText();
		Assert.assertEquals(Create_new_report_subtitle_exp, Create_new_report_subtitle_act);
		log.info("Create new report page sub title is getting displayed as : " + Create_new_report_subtitle_exp);
		
//Filter drop box values validation
		
		
		
		Reports.create_new_report_filter(driver).click();
		
		int count = 0;
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
		}
		Thread.sleep(100);
		
		log.info("Ship reports, Position reports, Account reports, User reports, Fleet reports, Custom and hello are exist in the Filter dropdown as expected");
		
		if (count==7){
		
			return true;
		} else {
			return false;
		}
	}
//Creating a new report for Ship reports
		
	 
	@Test		
		public static  void shipReport(WebDriver driver) throws Throwable {
			
			 //Selecting the Ship report option from the drop down
			
			Reports.create_new_report_filter_ShipReports(driver).click();
			
            //Verifying the header of Ship reports
			
			String Shipreport_header = "Ship reports";
			Thread.sleep(3000);
			String Shipreport_header_act = Reports.create_new_report_filter_ShipReports_title(driver).getText();
			Assert.assertEquals(Shipreport_header, Shipreport_header_act);
			Log.info("Ship report title is getting displayed as : " + Shipreport_header_act );
			
			Thread.sleep(3000);
			
			//Verifying the New ship report link
			
			String NewshipReport_link = "New ship report";
			String NewshipReport_link_act = Reports.create_new_report_filter_ShipReports_NewShipReport_link(driver).getText();
			Assert.assertEquals(NewshipReport_link, NewshipReport_link_act);
			Log.info("New ship report link is getting displayed as : " + NewshipReport_link_act );
			
			Thread.sleep(3000);
			
		
			//Clicking on the New ship report link and validating the header title & sub-title of New ship report page
			
			Reports.create_new_report_filter_ShipReports_NewShipReport_link(driver).click();
			
			String NewshipReport_tile = "New ship report";
			String NewshipReport_tile_act = Reports.create_new_report_filter_ShipReports_NewShipReport_title(driver).getText();
			Assert.assertEquals(NewshipReport_tile, NewshipReport_tile_act);
			Log.info("New ship report page's title is getting displayed as : " + NewshipReport_tile_act );
			
			Thread.sleep(3000);
			
			String NewshipReport_subtile = "Create a Report based on New ship report model";
			String NewshipReport_subtile_act = Reports.create_new_report_filter_ShipReports_NewShipReport_subtitle(driver).getText();
			
			
			Assert.assertEquals(NewshipReport_subtile, NewshipReport_subtile_act);
			Log.info("New ship report page's title is getting displayed as : " + NewshipReport_subtile_act );
			
			Thread.sleep(3000);
			
//Creating the new Ship report by selecting/filling all the required details
			
			//Verifying whether user able to enter Report name into New ship report name text filed
			
			Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).clear();
			
			Thread.sleep(3000);
			
			Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).sendKeys("Ship Report");
			
			String shipreportName = Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).getText();
			
			Thread.sleep(3000);
			
			//Verifying the Filters drop down options and selecting options from those
			
			String[] exp = {"Ship Status","Alert status","Ship Name","Ship IMO Number","Fleet Name","Creation date","Account Company Name"};
			
			WebElement mySelectElm = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters(driver); 
			Select mySelect= new Select(mySelectElm);
			mySelect.selectByVisibleText("Ship Status");
			
			/*Log.info("expected length" + exp.length);
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
			
			if(random == 4){
				mySelect.selectByVisibleText("Ship Status");
			}else if(random == 5){
				mySelect.selectByVisibleText("Ship Name");
			}else{
				mySelect.selectByVisibleText("Fleet Name");
			}*/
				
			
	String selected_Filter_option = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters(driver).getText();
	
	/*if(selected_Filter_option == "Ship Status"){
		
		String[] exp1 = {"Active","Deleted"};*/
		 WebElement dropdown1 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly_type(driver);
		 Select select1 = new Select(dropdown1);  

		 //Selecting the Active drop down value
		 
		 select1.selectByVisibleText("Active");
		 
		 String ShipStatus_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly_type(driver).getText();
		 
		 String ShipStatus_Exactly_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 Thread.sleep(3000);
		 
	/*}else if(selected_Filter_option == "Ship Name"){*/
		
		
		/*WebElement dropdown2 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select2 = new Select(dropdown2);  

		 //Selecting the Active drop down value
		 
		 select2.selectByVisibleText("Starts with");
		 
		 String ShipName_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 Thread.sleep(3000);
		
		 
		//*[@id="application"]/div[2]/div[2]
		 
		 driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).sendKeys("AAA");
		
		 Thread.sleep(3000);
		 
		 String ShipName_given = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).getText();
		
	}else{
		WebElement dropdown2 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select2 = new Select(dropdown2);  

		 //Selecting the Active drop down value
		 
		 select2.selectByVisibleText("Contains");
		 
		 String FleetName_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).sendKeys("Pole");
		 
		 String FleetName_given = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).getText();
		 
		 Thread.sleep(3000);
	}*/
		
		
			 //Clicking on "Add another" button
			 
			 Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Add(driver).click();
			 
			 
			 //Validating & Selecting the options from the Filters drop downs
			 
			 
			 String[] exp2 = {"Ship status","Alert status","Ship IMO Number","Fleet Name","Creation date","Account Company Name"};
			 WebElement dropdown3 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_1(driver);
			 Select select2 = new Select(dropdown3); 
				
			 select2.selectByVisibleText("Ship IMO Number");
			 
			 Thread.sleep(3000);
			 
			 String[] exp3 = {"Exactly","Starts with"};
			 WebElement dropdown4 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_1(driver);
			 Select select3 = new Select(dropdown4);  
		
			 //Selecting Exactly option from the drop down
			 select3.selectByVisibleText("Exactly");
			 
			 String ShipIMONumber_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_1(driver).getText();
			 
			 
			 Thread.sleep(3000);
			 
			 //Entering the Ship IMO Number in text field
			
		     driver.findElement(By.xpath("//div/div[2]/div/form/div/div[3]/div[1]/div[3]/input")).sendKeys("9999");
		     
		     String ShipIMONumber_given = driver.findElement(By.xpath("//div/div[2]/div/form/div/div[3]/div[1]/div[3]/input")).getText();
		     
		     //Clickin on Add another button to select Account Company Name option from the drop down
		     
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
		     
		     Thread.sleep(3000);
		     
//Dragging General Information values from Available fields  to Report fi  
		     
		     /*Point point = Reports.targetElement(driver).getLocation();
		        int xcord = point.getX();
		        System.out.println("Element's Position from left side Is "+xcord +" pixels.");
		        int ycord = point.getY();
		        System.out.println("Element's Position from top side Is "+ycord +" pixels.");*/
		     
		     new Actions(driver).dragAndDropBy(Reports.create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_5(driver), 611, 544).build() .perform();
		     
		    /*new Actions(driver).clickAndHold(Reports.create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_5(driver)).moveByOffset(611,544).release().perform();*/
			/*Actions builder = new Actions(driver);
			builder.clickAndHold(Reports.create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_2(driver)).moveByOffset(152,360).build().perform();
			builder.release(Reports.targetElement(driver)).build().perform();*/
		     /*builder.keyDown(Keys.CONTROL)
		         .click(Reports.create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_1(driver))
		         .dragAndDrop(Reports.create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_1(driver), Reports.targetElement(driver))
		         .keyUp(Keys.CONTROL);

		         Action selected = builder.build();
*/
		      /*   selected.perform();*/
		         
		    	    	/*WebElement  sourceElement = Reports.create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_1(driver);
		    	        //WebElement dragTo = driver.findElement(By.id("div1"));
		    	    	WebElement targetElement = Reports.targetElement(driver);
		    	    	
		    	    	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		    	    	ChromeDriver driver1 = new ChromeDriver(capabilities);
		    	    
		    	    	 
		    	        // Script for dragging an element and dropping it in another place
		    	    	
		    	    	Actions dragAndDrop = new Actions(driver1);
		    	    	
		    	    
		    	        dragAndDrop.clickAndHold(sourceElement).moveToElement(targetElement).release().perform();*/
		    	      
		    	     
		    	       
		    	        /*System.out.println(sourceElement.getLocation());
		    	     
		    	        
		    	        System.out.println(targetElement.getLocation());
		    	        
		    	        act.dragAndDropBy(sourceElement, 611,544).perform();*/
		    	        
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
	Reports.searchBox(driver).sendKeys(shipreportName);
	
	String shipreportName_found = Reports.search_contains(driver).getText();
	
	Assert.assertEquals(shipreportName_found, shipreportName);
		
	Log.info("Ship report is generated successfully");	

	
//Validating the generated ship report details
	
	Reports.search_contains(driver).click();
	
	Thread.sleep(1000);
	
	//Verifying header title
	
	String shipreport_Header_act = driver.findElement(By.xpath("//div[2]/div[2]/div/div[1]/div/h3/span")).getText();
	
	Assert.assertEquals(shipreportName, shipreport_Header_act);
	
	//Verifying for the READY text on header
	
	String Ready_exp = "READY";
	
	String Ready_act = driver.findElement(By.xpath("//div[2]/div/div[1]/div/h3/div/span")).getText();
	Assert.assertEquals(Ready_exp, Ready_act);
	
	
    //Verifying the Filters section 
	
	
String Filters_1row_1column = driver.findElement(By.xpath("//div/div[2]/div/form/div/div[1]/div[2]/div[1]")).getText();

	
	if(Filters_1row_1column == "Account Company Name"){
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, AccountCompanyName_selected);
		
		Assert.assertEquals(Filters_1row_3column, AccountCompanyName_given);
		
		Log.info("Filters section first row details are correct when Account Company Name is selected");
		 
	}else if(Filters_1row_1column == "Ship Name"){
		
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Starts with");
		
		Assert.assertEquals(Filters_1row_3column, "AAA");
		
		Log.info("Filters section first row details are correct when Ship Name is selected");
		
		 Thread.sleep(3000);
		
	}else if(Filters_1row_1column == "Ship Status"){
		
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Exactly");
		
		Assert.assertEquals(Filters_1row_3column, "ACTIVE");
		
		Log.info("Filters section first row details are correct when Ship Status is selected");
		
		 Thread.sleep(3000);
		 
	}else if(Filters_1row_1column == "Ship IMO Number"){
		
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, ShipIMONumber_selected);
		
		Assert.assertEquals(Filters_1row_3column, ShipIMONumber_given);
		
		Log.info("Filters section first row details are correct when Ship IMO Number is selected");
		
		 Thread.sleep(3000);
	}else if(Filters_1row_1column == "Fleet Name"){
		
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Contains");
		
		Assert.assertEquals(Filters_1row_3column, "Pole");
		
		Log.info("Filters section first row details are correct when Fleet Name is selected");
		
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
			
     Assert.assertEquals(TemplateName_act, "Ship Report (clone)");
	
	Log.info("Template name details are correct");
	
	   //Template group validation
	
	String TemplateGroup_exp = "Custom";
	
	String TemplateGroup_act = driver.findElement(By.cssSelector("#form__item__group")).getText();
	
    Assert.assertEquals(TemplateGroup_exp, TemplateGroup_act);
	
	Log.info("Template group details are correct");
	


	//Clicking on Save
	
	Reports.CloneReport_Save(driver).click();
	
	
//Verifying the details on Report templates page after cloning the report
	
	//Templates page header validation
	
	String Templates_header_exp = "Report templates";
	
	String Templates_header_act = Reports.Templates_header(driver).getText();
			
Assert.assertEquals(Templates_header_exp, Templates_header_act);
	
	Log.info("Templates header is getting displayed as : " + Templates_header_act);	
	
	
	//Validating the cloned report from the Report templates page
	
	String ClonedReport_name = driver.findElement(By.xpath("//div/div[2]/div/div[1]/a/div[1]")).getText();
	
Assert.assertEquals(ClonedReport_name, TemplateName_act);
	
	Log.info("Cloned report got updated in the Custom report templates list");	
	
	//Clicking on the cloned report name link#
	
	driver.findElement(By.xpath("//div/div[2]/div/div[1]/a/div[1]")).click();
	
	//Cloned report header validation
	
Assert.assertEquals(TemplateName_act, "Ship Report (clone)");
	
	Log.info("Template name details are correct");
	
	   //Template group validation
	
	String TemplateGroup_exp1 = "Custom";
	
	String TemplateGroup_act1 = driver.findElement(By.cssSelector("#form__item__group")).getText();
	
    Assert.assertEquals(TemplateGroup_exp1, TemplateGroup_act1);
	
	Log.info("Template group details are correct");
	
	
	//Modifying the Cloned report template by changing the name of the Template and deleting one row from the Filters section
	
	
	
	driver.findElement(By.cssSelector("#form__item__name")).clear();
	
	driver.findElement(By.cssSelector("#form__item__name")).sendKeys("Pole star report");
	
	String Updated_templateName = driver.findElement(By.cssSelector("#form__item__name")).getText();
	
	Reports.Filters_remove(driver).click();
	
	driver.findElement(By.xpath("//div[4]/div/div/div[2]/button[3]")).click();
	

	//Verifying whether Template got updated or not
	
	
	String Updated_templateName_act = driver.findElement(By.xpath("//div/div[2]/div/div[1]/a/div[1]")).getText();
	
    Assert.assertEquals(Updated_templateName, Updated_templateName_act);
	
	Log.info("Template name updated successfully");
	
	
	driver.findElement(By.xpath("//div/div[2]/div/div[1]/a/div[1]")).click();
	
	Assert.assertEquals(TemplateName_act, Updated_templateName_act);
	
	Log.info("Template details are updated successfully");
	
	
     //Deleting the report
	
     Reports.reports_menu(driver).click();
	
	Reports.searchBox(driver).clear();
	
	Reports.searchBox(driver).click();
	
		verbose("Typing in the search box....");
		
	Reports.searchBox(driver).sendKeys(shipreportName);
	
 //Clicking on report from the search results
	
	
	driver.findElement(By.xpath("//div[2]/div/div[2]/div/a/div/div/b")).click();
	
	
//Clicking on the delete button from the opened report
	
	Reports.delete_report(driver).click();
	
	
//Validating delete pop-up
	
	String popup = "Delete a report";
	
	String popup_act = Reports.delete_report_popup(driver).getText();
	
	Assert.assertEquals(popup_act,popup );
	
	Log.info("Delete a report pop-up invoked upon clicking on Delete");
	
	//Validating the message on delete pop-up
	
	String message_exp = "Are you sure you want to perform this operation? This can't be undone";
	
	String message_act = Reports.delete_report_popup_message(driver).getText();
	
	Assert.assertEquals(message_act,message_exp );
	
	
	Log.info("Delete a report pop-up confirmation message shows as : " +message_act);
	
	
	
//Verifying the delete report, if selects cancel from the delete report pop-up
	
    Reports.delete_report_popup_cancel(driver).click();
    
    //Now navigates back to the Reports page and make sure that report is not gets deleted
    
    
   Reports.reports_menu(driver).click();
	
	Reports.searchBox(driver).clear();
	
	Reports.searchBox(driver).click();
	
		verbose("Typing in the search box....");
		
	Reports.searchBox(driver).sendKeys(shipreportName);
	
String shipreportName_found1 = Reports.search_contains(driver).getText();
	
	Assert.assertEquals(shipreportName_found1, shipreportName);
		
	Log.info("Report is not deleted, as Cancel option selected from the Delete a report pop-up");
	
	

//Verifying the delete report, if selects Ok from the delete report pop-up
	
	Reports.search_contains(driver).click();
	
	Reports.delete_report(driver).click();
	
    Reports.delete_report_popup_ok(driver).click();
    
    //Now navigates back to the Reports page and make sure that report gets deleted
    
    
    Reports.reports_menu(driver).click();
	
	Reports.searchBox(driver).clear();
	
	Reports.searchBox(driver).click();
	
		verbose("Typing in the search box....");
		
	Reports.searchBox(driver).sendKeys(shipreportName);
	
    String Noreports_found_act = Reports.noreports_found(driver).getText();

    String Noreports_found_exp = "No reports found";

	
	Assert.assertEquals(Noreports_found_act, Noreports_found_exp);
		
	Log.info("Report is deleted successfully, as Ok option selected from the Delete a report pop-up");
	
	
	}
		    	        public static int randInt(int min, int max) {
		    	    	    
		    	    	    Random rand = new Random();
		    	        
		    	    	    int randomNum = rand.nextInt((max - min) + 1) + min;

		    	    	    return randomNum;
		    	    	}
			
		    	        
		    	        
	}
	

