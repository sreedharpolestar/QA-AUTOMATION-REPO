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
import reports.ReportsPage;
import scriptResources.*;
import testDatas.AccountTestData;
import testEnviroments.Log;
import testEnviroments.enviroments;
//import Notification_resources.BasePage;
//import Notification_resources.LoginPage;

public class ReportTemplate_PositionReport extends BasePage {
	
	/*LoginPage loginPage = new LoginPage(getDriver());*/
	
	/*LoginPage loginPage = new LoginPage(getDriver());
	
	Logger log = Logger.getLogger("Logger");*/
	
	public ReportTemplate_PositionReport(WebDriver driver) {
		super(driver);
	}
	
// Report template module navigation and verifying the header
	
	@Test
	public static void reportTemplate_Position(WebDriver driver) throws Throwable{
			
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
			
			Reports.reportTemplates_link(driver).click();
			
			log.info("Reports templates sublink clicked");
			
			
			Thread.sleep(3000);

//Verifying the clicking on the Create a new report button
	
	Reports.createNewReportTemplate_button(driver).click();
	log.info("Clicked on Create new report template button");
		
	
//Clicking on New position report link
		
		Reports.createNewReportTemplate_PositionReport_link(driver).click();
		
		//New position report template page validation
		
		//header text validation
		String Create_new_report_exp1 = "New report template";
		String Create_new_report_act1= Reports.createNewReportTemplate_ShipReport_header(driver).getText();
		Assert.assertEquals(Create_new_report_exp1, Create_new_report_act1);
		log.info("Create new position report template page header is getting displayed as : " + Create_new_report_act1);
		
		//Sub header text validation
			String Create_new_report_subtitle_exp1 = "Create a report template based on New position report report model";
			String Create_new_report_subtitle_act1= Reports.createNewReportTemplate_ShipReport_subheader(driver).getText();
			Assert.assertEquals(Create_new_report_subtitle_exp1, Create_new_report_subtitle_act1);
			log.info("Create new report template page sub title is getting displayed as : " + Create_new_report_subtitle_act1);
			
		//Template name validation
			
		    driver.findElement(By.cssSelector("#form__item__name")).sendKeys("Position Template");
		    	    		    
		    String positionTemplateName = driver.findElement(By.cssSelector("#form__item__name")).getText();
		    
			
			   //Template group validation
			
			String TemplateGroup_exp = "Custom";
			
			String TemplateGroup_act = driver.findElement(By.cssSelector("#form__item__group")).getText();
			
		    Assert.assertEquals(TemplateGroup_exp, TemplateGroup_act);
			
			Log.info("Template group details are correct");
		
		
		
/*//Filter drop box values validation
		
		
		
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
		public static  void shipReport(WebDriver driver) throws Throwable {*/
			
			 //Selecting the Ship report option from the drop down
			
			/*Reports.create_new_report_filter_ShipReports(driver).click();
			
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
			
			Thread.sleep(3000);*/
			
			//Verifying the Filters drop down options and selecting options from those
			
			String[] exp = {"Position Creation Date","Position Terminal","Position LES","Position Longitude (decimal)","Position Latitude (decimal)","Position SOG Reported",
			"Position SOG Calculated","Position COG Reported","Position COG Calculated","Position Source","Account Company Name",
			"Ship Status","Creation date","Ship Name","Fleet Name","Ship Flag Name","Ship IMO Number","MMSI","Ship Call Sign","Ship Call Sign","Ship Type","Ship Type",
			"Ship Gross Tonnage","Ship Length Overall","Ship Year of Build","Alert status"};
			
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
				select.selectByVisibleText("Position Source");
			}else if(random == 2){
				select.selectByVisibleText("Position Creation Date");
			}else{
				select.selectByVisibleText("Ship Type");
			}
				
			
	String selected_Filter_option = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters(driver).getText();
	
	if(selected_Filter_option == "Position Source"){
		
		String[] exp1 = {"Active","Deleted"};
		 WebElement dropdown1 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select1 = new Select(dropdown1);  

		 //Selecting the Contains drop down value
		 
		 select1.selectByVisibleText("Contains");
		 
		 String ShipStatus_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly_type(driver).getText();
		 
		 driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/form/div/div[3]/div[2]/div[3]/input")).sendKeys("A");
		 
		 String ShipStatus_Exactly_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 Thread.sleep(3000);
		 
	}else if(selected_Filter_option == "Position Creation Date"){
		
		
		WebElement dropdown2 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select2 = new Select(dropdown2);  

		 //Selecting the Active drop down value
		 
		 select2.selectByVisibleText("Less than or equal to");
		 
		 String ShipName_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		
		 
		 Thread.sleep(3000);
		
		 
		//*[@id="application"]/div[2]/div[2]
		 
		 driver.findElement(By.xpath("//div/div[3]/div[2]/div[3]/div/input")).sendKeys("2017-06-01");
		
		 Thread.sleep(3000);
		 
		 String ShipName_given = driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/form/div/div[3]/div[2]/div[3]/input")).getText();
		
	}else{
		WebElement dropdown3 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select3 = new Select(dropdown3);  

		 //Selecting the Active drop down value
		 
		 select3.selectByVisibleText("Starts with");
		 
		 String FleetName_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/form/div/div[3]/div[2]/div[3]/input")).sendKeys("Pole");
		 
		 
		 String FleetName_given = driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/form/div/div[3]/div[2]/div[3]/input")).getText();
		 
		 Thread.sleep(3000);
	}
		
		
			 //Clicking on "Add another" button
			 
			 Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Add(driver).click();
			 
			 
			 //Validating & Selecting the options from the Filters drop downs
			 
			 
			 WebElement dropdown4 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_1(driver);
			 Select select4 = new Select(dropdown4); 
				
			 select4.selectByVisibleText("Ship IMO Number");
			 
			 Thread.sleep(3000);
			 
			 String[] exp3 = {"Exactly","Starts with"};
			 WebElement dropdown5 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_1(driver);
			 Select select5 = new Select(dropdown5);  
		
			 //Selecting Exactly option from the drop down
			 select5.selectByVisibleText("Exactly");
			 
			 String ShipIMONumber_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_1(driver).getText();
			 
			 
			 Thread.sleep(3000);
			 
			 //Entering the Ship IMO Number in text field
			
		     driver.findElement(By.xpath("//div/form/div/div[4]/div[1]/div[3]/input")).sendKeys("9328649");

		     
		     String ShipIMONumber_given =  driver.findElement(By.xpath("//div/form/div/div[4]/div[1]/div[3]/input")).getText();
		     
		     //Clickin on Add another button to select Account Company Name option from the drop down
		     
		     
		     
//**********************************************************************************************************************************************//
		     
		     
		     Thread.sleep(3000);
		     
//Dragging General Information values from Available fields  to Report fi    
	

		    	    	WebElement  sourceElement = Reports.create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_1(driver);
		    	        //WebElement dragTo = driver.findElement(By.id("div1"));
		    	    	WebElement targetElement = Reports.targetElement(driver);
		    	    
		    	    	
		    	    	Actions act = new Actions(driver);
		    	    	 
		    	        // Script for dragging an element and dropping it in another place
		    	      
		    	     
		    	       
		    	        System.out.println(sourceElement.getLocation());
		    	     
		    	        
		    	        System.out.println(targetElement.getLocation());
		    	        
		    	        act.dragAndDropBy(sourceElement, 611,544).perform();
		    	        
		    	        Thread.sleep(7000);
		    	        
		    	        
		    	        
//Selecting Share level from the drop down
		    	        
		
		    	        
		    	     WebElement dropdown6 = Reports.createNewReportTemplate_ShipReport_ShareLevel(driver);
		   			 Select select6 = new Select(dropdown6);  
		   		
		   			 //Selecting Exactly option from the drop down
		   			 select6.selectByVisibleText("All users of the same account");
		   			 
		   			 String ShareLevel_selected = Reports.createNewReportTemplate_ShipReport_ShareLevel(driver).getText();
		    	       
		    	        
//Clicking on Save
		    	        
		    	        
		    	        Reports.createNewReportTemplate_ShipReport_Save(driver).click();
		    	        
		    	        
//Verifying the page has been moved to the Report templates home page or not after saving
		    	        
		    	        String Report_template_homepage = Reports.createNewReportTemplate_Reporttemplate_header(driver).getText();
		    	        
		    	        String Report_template_homepage_act = "Report templates";
		    	        
		    	        Assert.assertEquals(Report_template_homepage_act, Report_template_homepage);
		    	        
		    	        Log.info("User is navigates back to the Report templates page upon saving the template");
		    	        
//Verifying whether Template is created or not
		    	        
		    	        Log.info("Searching for the Template which was created in above");
		    	        
		    	    
	Reports.createNewReportTemplate_Reporttemplate_search(driver).clear();
	Reports.createNewReportTemplate_Reporttemplate_search(driver).click();
		verbose("Typing in the search box....");
	Reports.createNewReportTemplate_Reporttemplate_search(driver).sendKeys(positionTemplateName);
	
	String positionreportName_found = Reports.createNewReportTemplate_Reporttemplate_createdTemplate_namelink(driver).getText();
	
	Assert.assertEquals(positionreportName_found, positionTemplateName);
		
	Log.info("Position report template is generated successfully");	

	
//Validating the created position report template details
	
	Reports.createNewReportTemplate_Reporttemplate_createdTemplate_namelink(driver).click();
	
	Thread.sleep(1000);
	
	//Verifying header title
	
	String positionreport_Header_act = driver.findElement(By.xpath("//div[2]/div[2]/div/div[1]/div/div/h3")).getText();
	
	
	Assert.assertEquals(positionTemplateName, positionreport_Header_act);
	
	//Verifying the Template name
	
		String Template_name = driver.findElement(By.cssSelector("#form__item__name")).getText();
		
		
	Assert.assertEquals(Template_name, positionTemplateName);
	
		
		Log.info("Template name details are correct");
		
		   //Template group validation
		
		String TemplateGroup_exp1 = "Custom";
		
		String TemplateGroup_act1 = driver.findElement(By.cssSelector("#form__item__group")).getText();
		
	    Assert.assertEquals(TemplateGroup_exp1, TemplateGroup_act1);
		
		Log.info("Template group details are correct");
	
	
    //Verifying the Filters section 
		
		WebElement dropdown_filters_1row_1column = driver.findElement(By.xpath("//div[2]/div[1]/select"));
		 Select select_filters1 = new Select(dropdown_filters_1row_1column);  
	
	
        String dropdown_filters_1row_1column_act = dropdown_filters_1row_1column.getText();
        

	if(dropdown_filters_1row_1column_act == "Position Source"){
		
		WebElement dropdown_filters_1row_2column = driver.findElement(By.xpath("//div[2]/div[2]/select"));
		
		 Select select_filters2 = new Select(dropdown_filters_1row_2column);  
		 
		 String dropdown_filters_1row_2column_act = dropdown_filters_1row_2column.getText();
		 
		 Assert.assertEquals(dropdown_filters_1row_2column_act, "Contains");
		 
		 
		 
		 WebElement dropdown_filters_1row_3column = driver.findElement(By.xpath("//div[2]/div[3]/select"));
			
		 Select select_filters3 = new Select(dropdown_filters_1row_3column);  
		 
		 String dropdown_filters_1row_3column_act = dropdown_filters_1row_3column.getText();
		 
		 Assert.assertEquals(dropdown_filters_1row_3column_act, "A");
		
		Log.info("Filters section first row details are correct when Position Source is selected");
		 
	}else if(dropdown_filters_1row_1column_act == "Position Creation Date"){
		
		WebElement dropdown_filters_1row_2column1 = driver.findElement(By.xpath("//div[2]/div[2]/select"));
		
		 Select select_filters2_1 = new Select(dropdown_filters_1row_2column1);  
		 
		 String dropdown_filters_1row_2column_act1 = dropdown_filters_1row_2column1.getText();
		 
		 Assert.assertEquals(dropdown_filters_1row_2column_act1, "Less than or equal to");
		 
		 
		 String Filters_1row_3column_text = driver.findElement(By.xpath("//div/div[3]/div[2]/div[3]/input")).getText();
		 
		 Assert.assertEquals(Filters_1row_3column_text, "2017-06-01");
		 
		Log.info("Filters section first row details are correct when Position Creation Date is selected");
		
		 Thread.sleep(3000);
		
	}else if(dropdown_filters_1row_1column_act == "Ship Type"){
		
		WebElement dropdown_filters_1row_2column1 = driver.findElement(By.xpath("//div[2]/div[2]/select"));
		
		 Select select_filters2_1 = new Select(dropdown_filters_1row_2column1);  
		 
		 String dropdown_filters_1row_2column_act1 = dropdown_filters_1row_2column1.getText();
		 
		 Assert.assertEquals(dropdown_filters_1row_2column_act1, "Starts with");
		 
		 
		 String Filters_1row_3column_text = driver.findElement(By.xpath("//div/div[3]/div[2]/div[3]/input")).getText();
		 
		 Assert.assertEquals(Filters_1row_3column_text, "Pole");
		 
		Log.info("Filters section first row details are correct when Ship Type is selected");
		
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
	
	String Sharelevel_text = driver.findElement(By.cssSelector("#form__item__share_level")).getText();
	
	
	
	Assert.assertEquals(Sharelevel_text, ShareLevel_selected);
	
	Log.info("Share level section details are correct");
	
	
//Updating the Template 
	
	//Changing the Template name
	
	driver.findElement(By.cssSelector("#form__item__name")).sendKeys("edit_Position Template");
	
	String Edit_PositionTemplate_name = driver.findElement(By.cssSelector("#form__item__name")).getText();
	
	//editing Template group 
	
	
     driver.findElement(By.cssSelector("#form__item__group")).sendKeys("edit_Position Template group");
	
	String Edit_PositionTemplateGroup_name = driver.findElement(By.cssSelector("#form__item__group")).getText();
	
	//Clicking on save
	
	Reports.createdTemplate_Save_button(driver).click();
	
	Thread.sleep(3000);	
	
	//Verifying whether Temple got updated or not
	
	
	Log.info("Searching for the Template which was updated in above");
    
    
	Reports.createNewReportTemplate_Reporttemplate_search(driver).clear();
	
	Reports.createNewReportTemplate_Reporttemplate_search(driver).click();
	
		verbose("Typing in the search box....");
		
	Reports.createNewReportTemplate_Reporttemplate_search(driver).sendKeys(Edit_PositionTemplate_name);
	
	Thread.sleep(6000);	
	
	String Edit_PositionTemplate_name_found = Reports.createNewReportTemplate_Reporttemplate_createdTemplate_namelink(driver).getText();
	
	Assert.assertEquals(Edit_PositionTemplate_name_found, Edit_PositionTemplate_name);
	
	String Edit_ShipTemplate_group_found = driver.findElement(By.xpath("/div/div[2]/div/div/div")).getText();
	
	Assert.assertEquals(Edit_ShipTemplate_group_found, Edit_PositionTemplateGroup_name);
	
	
	Reports.createNewReportTemplate_Reporttemplate_createdTemplate_namelink(driver).click();
	
	String Edit_ShipTemplate_name_found1 = driver.findElement(By.cssSelector("#form__item__name")).getText();
	
	String Edit_ShipTemplate_group_found1 = driver.findElement(By.cssSelector("#form__item__group")).getText();
	
	Assert.assertEquals(Edit_ShipTemplate_name_found1, Edit_PositionTemplate_name);
	
	Assert.assertEquals(Edit_ShipTemplate_group_found1, Edit_PositionTemplateGroup_name);

	Log.info("Position report template is updated successfully");	
	
	
	
//Verifying the Clone this template functionality
	
	//Clicking on Clone this template button
	
	
	Reports.createdTemplate_cloneThisTemplate_button(driver).click();
	
	//Validating the Clone Report Template page 
	
	    //Template name validation

	String TemplateName_act = driver.findElement(By.cssSelector("#form__item__name")).getText();

	   //Template group validation
	
	
	String TemplateGroup_act11 = driver.findElement(By.cssSelector("#form__item__group")).getText();
	
    Assert.assertEquals(TemplateGroup_act11, Edit_ShipTemplate_group_found1);
	
	Log.info("Template group details are correct");
	
	//Share level validation
	
	String cloned_Sharelevel = driver.findElement(By.cssSelector("#form__item__share_level")).getText();
	
	Assert.assertEquals(cloned_Sharelevel, ShareLevel_selected);
	
	Log.info("Share level details are correct");

	//Clicking on Save
	
	driver.findElement(By.xpath("//div[2]/div[2]/div/div[4]/div/div/div[2]/button[2]")).click();
	
	
//Verifying the details on Report templates page after cloning the report
	
	//Validating the cloned report from the Report templates page
	
    Reports.createNewReportTemplate_Reporttemplate_search(driver).clear();
	
	Reports.createNewReportTemplate_Reporttemplate_search(driver).click();
	
		verbose("Typing in the search box....");
		
	Reports.createNewReportTemplate_Reporttemplate_search(driver).sendKeys(TemplateName_act);
	
	Thread.sleep(6000);	
	
	String ClonedReport_name = driver.findElement(By.xpath("//div/div[2]/div/div[1]/a/div[1]")).getText();	
	
	
        Assert.assertEquals(ClonedReport_name, TemplateName_act);
	
	Log.info("Cloned template got updated successfully");	
	
	//Clicking on the cloned report name link#
	
	driver.findElement(By.xpath("//div/div[2]/div/div[1]/a/div[1]")).click();
	
	
//Deleting the report
	
         //Clicking on the delete button from the opened report
	
	Reports.delete_report(driver).click();
	
	
	
//Validating delete pop-up
	
	String popup = "Delete a report template";
	
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
    
    String template_cancel= driver.findElement(By.xpath("/div/div[1]/div/div/h3")).getText();
    
    Assert.assertEquals(template_cancel, TemplateName_act);
		
	Log.info("Report is not deleted, as Cancel option selected from the Delete a report pop-up");
	
	

//Verifying the delete report, if selects Ok from the delete report pop-up
	
	Reports.delete_report(driver).click();
	
    Reports.delete_report_popup_ok(driver).click();
	
Log.info("Searching for the Template which was updated in above");
    
    
	Reports.createNewReportTemplate_Reporttemplate_search(driver).clear();
	
	Reports.createNewReportTemplate_Reporttemplate_search(driver).click();
	
		verbose("Typing in the search box....");
		
	Reports.createNewReportTemplate_Reporttemplate_search(driver).sendKeys(TemplateName_act);
	
	Thread.sleep(6000);	
    
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
	

