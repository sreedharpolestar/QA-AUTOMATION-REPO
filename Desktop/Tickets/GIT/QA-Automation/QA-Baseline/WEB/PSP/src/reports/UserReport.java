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

public class UserReport extends BasePage {
	
	/*LoginPage loginPage = new LoginPage(getDriver());*/
	
	/*LoginPage loginPage = new LoginPage(getDriver());
	
	Logger log = Logger.getLogger("Logger");*/
	
	public UserReport(WebDriver driver) {
		super(driver);
	}
	
// Reports module navigation and verifying the header
	
	@Test
	public static void userReport(WebDriver driver) throws Throwable{
			
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
	
//Creating a new report for Account reports
		
	 
	
		/*public static  void shipReport(WebDriver driver) throws Throwable {*/
			
			 //Selecting the Account report option from the drop down
			
			Reports.create_new_report_filter_UserReports(driver).click();
			
			Thread.sleep(1000);
			
			//Verifying the New user report & Standard user report links
			
			String NewUserReport_link = "New user report";
			String NewStandardUserReport_link = "Standard user report";
			String NewUserReport_link_act = Reports.create_new_report_filter_AccountReports_NewUserReport_link(driver).getText();
			String NewStandardUserReport_link_act = Reports.create_new_report_filter_AccountReports_NewStandardUserReport_link(driver).getText();
			
			Assert.assertEquals(NewUserReport_link, NewUserReport_link_act);
			
			Assert.assertEquals(NewStandardUserReport_link, NewStandardUserReport_link_act);
			
			
			Log.info("New user report link is getting displayed as : " + NewUserReport_link_act );
			
			Log.info("New standard user report link is getting displayed as : " + NewStandardUserReport_link_act );
			
			Thread.sleep(1000);
			
		
			//Clicking on the New user report link and validating the header title & sub-title of New user report page
			
			Reports.create_new_report_filter_AccountReports_NewUserReport_link(driver).click();
			
			String NewUserReport_tile = "New user report";
			String newUserreport_Title = Reports.newUserreport_Title(driver).getText();
			
			Assert.assertEquals(NewUserReport_tile, newUserreport_Title);
			Log.info("New user report page's title is getting displayed as : " + newUserreport_Title );
			
			Thread.sleep(1000);
			
			String NewUserReport_subtile = "Create a Report based on New user report model";
			String NewUserReport_subtile_act = Reports.newUserreport_subTitle(driver).getText();
			
			Assert.assertEquals(NewUserReport_subtile, NewUserReport_subtile_act);
			
			Log.info("New Usewr report page's title is getting displayed as : " + NewUserReport_subtile_act );
			
			Thread.sleep(1000);
			
//Creating the new User report by selecting/filling all the required details
			
			//Verifying whether user able to enter Report name into New user report name text filed
			
			Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).clear();
			
			Thread.sleep(3000);
			
			Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).sendKeys("User Report");
			
			String userreportName = Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).getText();
			
			Thread.sleep(1000);
			
			//Verifying the Filters drop down options and selecting options from those
			
			String[] exp = {"First name","Last name","Email", "Last login","Date joined","is active"};
			
			
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
				select.selectByVisibleText("First name");
			}else if(random == 2){
				select.selectByVisibleText("Last name");
			}else{
				select.selectByVisibleText("Email");
			}
				
			
	String selected_Filter_option = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters(driver).getText();
	
	if(selected_Filter_option == "First name"){
		
		WebElement dropdown1 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select1 = new Select(dropdown1);  

		 //Selecting the Starts with drop down value
		 
		 select1.selectByVisibleText("Starts with");
		 
		 String dropdown_1_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).sendKeys("A");
		 
		 String firstName_given = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).getText();
		 

		 
		 Thread.sleep(3000);
		 
	}else if(selected_Filter_option == "Last name"){
		
		
		 
		WebElement dropdown2 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select2 = new Select(dropdown2);  

		 //Selecting the Starts with drop down value
		 
		 select2.selectByVisibleText("Contains");
		 
		 String dropdown_2_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).sendKeys("P");
		 
		 String lastName_given = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).getText();
		 

		 
		 Thread.sleep(1000);
		
	}else{
		WebElement dropdown3 = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver);
		 Select select3 = new Select(dropdown3);  

		 //Selecting the Active drop down value
		 
		 select3.selectByVisibleText("Contains");
		 
		 String dropdown_3_selected = Reports.create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(driver).getText();
		 
		 driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).sendKeys("pole");
		 
		 String email_given = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[3]/input")).getText();
		 
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
	Reports.searchBox(driver).sendKeys(userreportName);
	
	String userreportName_found = Reports.search_contains(driver).getText();
	
	Assert.assertEquals(userreportName_found, userreportName);
		
	Log.info("User report is generated successfully");	

	
//Validating the generated user report details
	
	Reports.search_contains(driver).click();
	
	Thread.sleep(1000);
	
	//Verifying header title
	
	String userreport_Header_act = driver.findElement(By.xpath("//div[2]/div[2]/div/div[1]/div/h3/span")).getText();

	
	Assert.assertEquals("New user report", userreport_Header_act);
	
	//Verifying for the READY text on header
	
	String Ready_exp = "READY";
	
	String Ready_act = driver.findElement(By.xpath("//div[2]/div/div[1]/div/h3/div/span")).getText();
	Assert.assertEquals(Ready_exp, Ready_act);
	
	
    //Verifying the Filters section 
	
	
String Filters_1row_1column = driver.findElement(By.xpath("//div/div[2]/div/form/div/div[1]/div[2]/div[1]")).getText();

	
	if(Filters_1row_1column == "First name"){
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Starts with");
		
		Assert.assertEquals(Filters_1row_3column, "A");
		
		Log.info("Filters section first row details are correct when First name is selected");
		 
	}else if(Filters_1row_1column == "Last name"){
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Contains");
		
		Assert.assertEquals(Filters_1row_3column, "P");
		
		Log.info("Filters section first row details are correct when Last name is selected");
		
		 Thread.sleep(3000);
		
	}else if(Filters_1row_1column == "Email"){
		
		
		String Filters_1row_2column = driver.findElement(By.xpath("//div/form/div/div[1]/div[2]/div[2]")).getText();
		String Filters_1row_3column = driver.findElement(By.xpath("//div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]")).getText();
		
		Assert.assertEquals(Filters_1row_2column, "Contains");
		
		Assert.assertEquals(Filters_1row_3column, "pole");
		
		Log.info("Filters section first row details are correct when Email is selected");
		
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
			
     Assert.assertEquals(TemplateName_act, "User Report (clone)");
	
	Log.info("Template name details are correct");
	
	   //Template group validation
	
	String TemplateGroup_exp = "Custom";
	
	String TemplateGroup_act = driver.findElement(By.cssSelector("#form__item__group")).getText();
	
    Assert.assertEquals(TemplateGroup_exp, TemplateGroup_act);
	
	Log.info("Template group details are correct");
	
	//Updating the Template name 
	
	driver.findElement(By.cssSelector("#form__item__name")).clear();
	
	driver.findElement(By.cssSelector("#form__item__name")).sendKeys("A Cloned User report");
	
	
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

	
	
	
                                 //********Standard user report *************////
	
//Clicking on the New user report link and validating the header title & sub-title of New user report page
	
	Reports.reports_menu(driver).click();


//Verifying the clicking on the Create a new report button

Reports.create_report_button(driver).click();
log.info("Clicked on Create new report button");

Reports.create_new_report_filter(driver).click();

Reports.create_new_report_filter_UserReports(driver).click();

	
	Reports.create_new_report_filter_AccountReports_NewStandardUserReport_link(driver).click();
	
	String NewStandardUserReport_tile = "Standard user report";
	String newStanbdardUserreport_Title = Reports.newUserreport_Title(driver).getText();
	Assert.assertEquals(NewStandardUserReport_tile, newStanbdardUserreport_Title);
	Log.info("New standard user report page's title is getting displayed as : " + newStanbdardUserreport_Title );
	
	Thread.sleep(1000);
	
	String NewStandardUserReport_subtile = "Create a Report based on Standard user report template";
	String NewStandardUserReport_subtile_act = driver.findElement(By.xpath("//div[2]/div/div[1]/div/div/h3")).getText();
	
	Assert.assertEquals(NewStandardUserReport_subtile, NewStandardUserReport_subtile_act);
	
	Log.info("New Standard user report page's title is getting displayed as : " + NewStandardUserReport_subtile_act );
	
	Thread.sleep(1000);
	
//Creating the new Standard User report by selecting/filling all the required details
	
	//Verifying whether user able to enter Report name into New user report name text filed
	
	Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).clear();
	
	Thread.sleep(1000);
	
	Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).sendKeys("Standard User Report");
	
	String standarduserreportName = Reports.create_new_report_filter_ShipReports_NewShipReport_ReportName(driver).getText();
	
	Thread.sleep(1000);
	
	//Verifying the Filters drop down options and selecting options from those
	
	String[] exp1 = {"First name","Last name","Email", "Last login","Date joined","is active"};
	
	
	WebElement standard_dropdown = driver.findElement(By.cssSelector("#form__item__share_level"));

	Select select_standard = new Select(standard_dropdown);  

	select_standard.selectByVisibleText("All users of the same account");	
	
	String selected_Sharelevel = driver.findElement(By.cssSelector("#form__item__share_level")).getText();

    	        
//Clicking on Run report and create a template button to generate the report
    	        
    	        
    	        Reports.runReport_createtemplate_button(driver).click();
    	        
    	        


//Verifying the confirmation pop-up after clicking on Run report and create a template

String Popup_text_exp1 = "Please wait while the report is being generated";

String Popup_text_act1 = Reports.reports_title_header(driver).getText();

Assert.assertEquals(Popup_text_exp1, Popup_text_act1);

logger.info("Confirmation pop-up is getting displayed upon clicking on Run report and create template button");


//Clicking on confirmation pop-up 'OK' button 

Reports.pop_Up_Ok(driver).click();

//Navigating back to the Reports module to validate the generated report

//**************Need to write some loop to get the report which was generated through above steps******************//

Reports.reports_menu(driver).click();

Reports.searchBox(driver).clear();
Reports.searchBox(driver).click();
verbose("Typing in the search box....");
Reports.searchBox(driver).sendKeys(standarduserreportName);

String standarduserreportName_found = Reports.search_contains(driver).getText();

Assert.assertEquals(standarduserreportName_found, standarduserreportName);

Log.info("Standard user report is generated successfully");	


//Validating the generated user report details

Reports.search_contains(driver).click();

Thread.sleep(1000);

//Verifying header title

String standarduserreport_Header_act = driver.findElement(By.xpath("//div[2]/div[2]/div/div[1]/div/h3/span")).getText();


Assert.assertEquals(standarduserreportName, userreport_Header_act);

//Verifying for the READY text on header

String Ready_exp1 = "READY";

String Ready_act1 = driver.findElement(By.xpath("//div[2]/div/div[1]/div/h3/div/span")).getText();
Assert.assertEquals(Ready_exp1, Ready_act1);


//Verifying the Share level section

String Sharelevel_act = driver.findElement(By.xpath("//div/form/div/div[1]/span")).getText();

Assert.assertEquals(Sharelevel_act, selected_Sharelevel);

//Verifying the Report fields section

String reportFields_expected = "Company name, Role name, Email, First name, Last name, Last login";


String reportFields__act = driver.findElement(By.xpath("//div/div[2]/div/form/div/div[2]/div/p")).getText();


Assert.assertEquals(reportFields_expected, reportFields__act);


//Report format validation

String reportFormat_label = driver.findElement(By.xpath("//div/form/div/div[3]/label")).getText();

Assert.assertEquals("Report format", reportFormat_label);

String reportFormat_type = driver.findElement(By.xpath("//div/form/div/div[3]/span")).getText();

Assert.assertEquals("CSV", reportFormat_type);


Log.info("Standard user report details are correct as per generated format");

//Verifying the Clone report into a report template functionality

            //Clicking on Clone report into a report template button


            Reports.CloneReport(driver).click();

//Validating the Clone Report Template page 

      //Template name validation

String TemplateName_act1 = driver.findElement(By.cssSelector("#form__item__name")).getText();
	
Assert.assertEquals(TemplateName_act, "Standard User Report (clone)");

Log.info("Template name details are correct");

      //Template group validation

String TemplateGroup_exp1 = "Custom";

String TemplateGroup_act1 = driver.findElement(By.cssSelector("#form__item__group")).getText();


Assert.assertEquals(TemplateGroup_exp1, TemplateGroup_act1);

Log.info("Template group details are correct");

//Share level validation


String Sharelevel_actual = driver.findElement(By.cssSelector("#form__item__share_level")).getText();


Assert.assertEquals(Sharelevel_actual, selected_Sharelevel);
	
Log.info("Cloned report details are getting displayed correct as per orginal report");

//Updating the Template name 

driver.findElement(By.cssSelector("#form__item__name")).clear();

driver.findElement(By.cssSelector("#form__item__name")).sendKeys("A Cloned Standard User report");

String Updated_clonedreport_name1 = driver.findElement(By.cssSelector("#form__item__name")).getText();


//Clicking on Save

Reports.CloneReport_Save(driver).click();


//Verifying the details on Report templates page after cloning the report

//Templates page header validation

String Templates_header_exp2 = "Report templates";

String Templates_header_act2 = Reports.Templates_header(driver).getText();
	
Assert.assertEquals(Templates_header_exp2, Templates_header_act2);

Log.info("Templates header is getting displayed as : " + Templates_header_act2);	



//Searching for the updated cloned report

driver.findElement(By.xpath("//div/div/input")).sendKeys(Updated_clonedreport_name);

//Verifying whether cloned report name got updated or not

driver.findElement(By.xpath("//div/div/a/div[1]")).click();


String Updated_clonedreport_name_actual1 = driver.findElement(By.cssSelector("#form__item__name")).getText();


Assert.assertEquals(Updated_clonedreport_name_actual1, Updated_clonedreport_name1);


Log.info("Cloned report got updated in the Custom report templates list");	


	
	
	}
		    	        public static int randInt(int min, int max) {
		    	    	    
		    	    	    Random rand = new Random();
		    	        
		    	    	    int randomNum = rand.nextInt((max - min) + 1) + min;

		    	    	    return randomNum;
		    	    	}
			
	
}