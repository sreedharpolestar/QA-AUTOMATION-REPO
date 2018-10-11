package helpFAQ;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helpFAQ.Faq;
//import Notification_resources.LoginPage;
//import Notification_resources.BaseTest;
import pageObjectMethods.*;
import scriptResources.*;
import testDatas.*;

import org.apache.log4j.Logger;

public class FaqPageTest {

	/*LoginPage loginPage = new LoginPage(getDriver());
	Faq hFaq = new Faq(getDriver());
	
	
	
	@AfterMethod
	public void afterTestMethod(ITestResult testContext) {
		printEndOfTestIdentifierLogs();
		try{
			if(testContext.getStatus()==ITestResult.SUCCESS){
				verbose("End of executing Test: '" + testContext.getMethod().getMethodName()+"'. Test PASSED");
				
			}else if(testContext.getStatus()==ITestResult.FAILURE){
				error("End of executing Test: '" + testContext.getMethod().getMethodName()+"'. Test FAILED");
				
			}else if(testContext.getStatus()==ITestResult.SKIP){
				verbose("End of executing Test: '" + testContext.getMethod().getMethodName()+"'. Test was SKIPPED");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
	@BeforeClass
	//@Parameters("browser")
	public void beforeClass() throws Exception {
		
		setup("Chrome");
		loginPage.login();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDownTest() throws Throwable {
		waitExplicitly(5);
		tearDown();
	}
	
	@AfterClass
	public void afterClass() throws Exception {
		printEndOfTestClassIdentifierLogs();
		
	}*/
	
	@Test
	public static void checkIfHelpFAQAvailable(WebDriver driver)throws Throwable{
		
		
	/*	error("Help and FAQ section contents are not locatable by Selenium current version in use.\n Please check it manually.");*/
		/*Assert.assertTrue(true);*/
		
	
		Logger log = Logger.getLogger("Logger");
		FAQPage.FAQLink(driver).click();
		log.info("Help link clicked");
			/*getElement(helpFAQlink).click();*/
			
			/*// Get and store both window handles in array
			  Set<String> AllWindowHandles = driver.getWindowHandles();
			  String window1 = (String) AllWindowHandles.toArray()[0];
			  System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
			  String window2 = (String) AllWindowHandles.toArray()[1];
			  System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
			  
			  //Switch to window2(child window) and performing actions on it.
			  driver.switchTo().window(window2);*/
		
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		          
		          /*String FaqHeaderText = FAQPage.title(driver).getText();*/
					/*Assert.assertEquals("the Pole Star Platform", FaqHeaderText);*/
					/*log.info("Page Header Text is:  " + FaqHeaderText); */   
		          
		          FAQPage.title(driver).click();
		          Thread.sleep(3000);
		          String titlemenu = FAQPage.title(driver).getText();
		          Thread.sleep(3000);
		  		  /*Assert.assertEquals("Title", titlemenu);*/
		  		 Thread.sleep(3000);
		  		  log.info("User can see the Title as Pole Star Platgorm");
		  		FAQPage.title(driver).click();
		  		
		          FAQPage.contents(driver).click();
		          Thread.sleep(3000);
		          String contentsmenu = FAQPage.contents(driver).getText();
		          Thread.sleep(3000);
		  		  Assert.assertEquals("Contents", contentsmenu);
		  		 Thread.sleep(3000);
		  		  log.info("User can see the details under Contents menu");
		          /*String HowtoHeaderText = FAQPage.howto_header(driver).getText();*/
					/*Assert.assertEquals("the Pole Star Platform", FaqHeaderText);*/
					/*log.info("How to Page Header Text is:  " + HowtoHeaderText); */  
		  		FAQPage.contents(driver).click();
		  		FAQPage.revision(driver).click();
		          Thread.sleep(3000);
		          String revisionmenu = FAQPage.revision(driver).getText();
		          Thread.sleep(3000);
		  		  Assert.assertEquals("Revision History", revisionmenu);
		  		 Thread.sleep(3000);
		  		  log.info("User can see the details under Revision History menu");
		  		  
		  		FAQPage.revision(driver).click();
		          FAQPage.howto(driver).click();
		          Thread.sleep(3000);
		          String howtomenu = FAQPage.howto(driver).getText();
		          Thread.sleep(3000);
		  		  /*Assert.assertEquals("How to", howtomenu);*/
		  		 Thread.sleep(3000);
		  		  log.info("User can see the details under How to menu");
		  		  
		  		FAQPage.howto(driver).click();
		  		  
		  		FAQPage.about(driver).click();
		          FAQPage.about(driver).click();
		          Thread.sleep(3000);
		          String aboutmenu = FAQPage.about(driver).getText();
		          Thread.sleep(3000);
		  		  Assert.assertEquals("About", aboutmenu);
		  		 Thread.sleep(3000);
		  		  log.info("User can see the details under About menu");
		  		  
		  		FAQPage.about(driver).click();
		  		
		          Thread.sleep(3000);
		          FAQPage.downloads(driver).click();
		          String Downloads = FAQPage.downloads(driver).getText();
		  		  Assert.assertEquals("Downloads", Downloads);
		  		  log.info("User can see the details under Downloads menu");
		          Thread.sleep(3000);
		          FAQPage.downloads(driver).click();
		          Thread.sleep(3000);
		          FAQPage.index(driver).click();
		          log.info("Clciked on Index");
		          Thread.sleep(3000);
		          FAQPage.glossary(driver).click();
		          Thread.sleep(3000);
		          FAQPage.search_glossary(driver).sendKeys("COG");
		          log.info("Entered COG into search filed");
		          Thread.sleep(3000);
		          String searchresult = FAQPage.search_result(driver).getText();
					Assert.assertEquals("COG", searchresult);
					log.info("HelpFAQ is working fine");
		          Thread.sleep(3000);
		         driver.close(); //closing child window
		         driver.switchTo().window(parentWindow); //cntrl to parent window
		          }
		       }
			  /*String FaqHeaderText = FAQPage.title(driver).getText();
				Assert.assertEquals("About the Pole Star Platform", FaqHeaderText);
				log.info("Page Header Text is:  " + FaqHeaderText);*/

			  /*driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
			  driver.findElement(By.xpath("//input[@value='Bike']")).click();
			  driver.findElement(By.xpath("//input[@value='Car']")).click();
			  driver.findElement(By.xpath("//input[@value='Boat']")).click();
			  driver.findElement(By.xpath("//input[@value='male']")).click();*/
			
			/*Boolean boo=false;
			
			if(getElements(helpFAQContentTitle).size()>0){
				boo=true;
				verbose(getElement(helpFAQContentTitle).getText());
			} else{
				error("Help and FAQ Document is not loaded");
			}
			
			return boo;*/
		}
		
	}
