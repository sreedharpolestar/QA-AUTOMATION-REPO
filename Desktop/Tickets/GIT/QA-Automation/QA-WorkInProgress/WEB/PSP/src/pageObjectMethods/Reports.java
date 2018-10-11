package pageObjectMethods;

/*import modules.HighlightElement;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import scriptResources.*;
import administration.*;

public class Reports {

	
	private static WebElement element = null;

	public static WebElement reports_menu(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#application > div.layout-main > div.layout-list > div.layout-navigation.hidden-xs.hidden-sm > div.menu.application__left-menu > div > a:nth-child(6) > span"));
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement reports_create_report(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#application > div.layout-main > div.layout-list.reports.full > div.layout-navigation.hidden-xs.hidden-sm > div.menu.application__left-menu > div > a.menu__item.active > div > ul > li.menu__item__sub-menu__item.active > a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	
	public static WebElement reports_report_templates(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("(#application > div.layout-main > div.layout-list.reports.full > div.layout-navigation.hidden-xs.hidden-sm > div.menu.application__left-menu > div > a.menu__item.active > div > ul > li:nth-child(2) > a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement reports_title_header(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#application > div.layout-main > div.layout-list.reports.full > div.layout-application > div.application__content > div > div.ps__header > div > h3"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement search_box(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//ul/li[1]/form/div/div/input"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement sort_dropdown(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/button"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement sort_dropdown_descending(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/ul/li/a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_report_button(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#ps-list-menu > ul > li:nth-child(2) > div > button"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	public static WebElement download_button(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/a/div/div/button"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement no_reports(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div/div/p"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_title_header(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div/div[1]/div/h3"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_subtitle_(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div/div[1]/div/p"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#ps-list-menu > div > button"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

	
	///Ship report objects
	public static WebElement create_new_report_filter_ShipReports(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#ps-list-menu > div > ul > li:nth-child(1) > a"));
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_title(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#application > div.layout-main > div.layout-list.reports.full > div.layout-application > div.application__content > div > div.content_scroller_viewport.scroller_viewport > div > div > div"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_link(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#application > div.layout-main > div.layout-list.reports.full > div.layout-application > div.application__content > div > div.content_scroller_viewport.scroller_viewport > div > div > a > div.title"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_title(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[1]/div/div/h3"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_subtitle(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#application > div.layout-main > div.layout-list.reports.full > div.layout-application > div.application__content > div > div.ps__header > div > p"));
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_ReportName(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__name"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div[1]/select"));
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters_exactly(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div[2]/select"));
	
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters_exactly_type(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div[3]/select"));
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters_clear(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div[4]/button/span"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters_Add(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[3]/button"));
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[1]/div[1]/select"));
		
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[1]/div[2]/select"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_type_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[3]/div[1]/div[3]/input"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[4]/div[1]/div[1]/select"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[4]/div[1]/div[2]/select"));
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_Filters_Filters_exactly_type_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[4]/div[1]/div[3]/input"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[2]"));
		
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[3]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_3(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[4]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_4(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[5]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_General_5(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[6]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[8]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[9]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_3(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[10]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_4(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[11]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_5(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[12]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_6(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[13]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_7(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[14]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_8(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[14]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_9(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[15]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_10(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[16]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_11(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[17]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_12(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[18]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_13(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[19]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_14(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[20]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_15(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[21]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_16(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[22]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_17(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[23]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_18(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[24]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_19(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[25]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_20(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[26]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Ship_21(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[27]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
//Last Position_options
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[30]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[31]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_3(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[32]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_4(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[33]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_5(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[34]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_6(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[35]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_7(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[36]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_8(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[37]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_9(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[38]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_10(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[39]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_11(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[40]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_12(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[41]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_13(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[42]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_14(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[43]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_15(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[44]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_16(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[45]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_17(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[46]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_18(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[47]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_19(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[48]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_20(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[49]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_21(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[50]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_22(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[51]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_23(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[52]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_24(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[53]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_LastPosition_25(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[54]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
//Alert options
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Alert_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[56]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Alert_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[57]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Alert_3(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[58]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Alert_4(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[59]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Alert_5(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[60]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Alert_6(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[61]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Alert_7(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[62]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Alert_8(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[63]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_AvaliableFields_Alert_9(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[64]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
//Report fields
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_ReportFields(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
//Share level
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_ShareLevel(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__share_level"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
//Report format
	
	
	public static WebElement create_new_report_filter_ShipReports_NewShipReport_ReportFormat(WebDriver driver) throws Throwable {
		element = driver.findElement(By.id("form__item__report_format"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	//Position report objects
	
	public static WebElement create_new_report_filter_PositionReports(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#ps-list-menu > div > ul > li:nth-child(2) > a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_Title(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[2]/div/div/div"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_Positions_NewShipReport_link(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#application > div.layout-main > div.layout-list.reports.full > div.layout-application > div.application__content > div > div.content_scroller_viewport.scroller_viewport > div > div > a > div.title"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[2]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[3]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_3(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[4]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_4(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[5]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_5(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[6]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_6(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[7]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_7(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[8]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_8(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[9]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_9(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[10]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_10(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[11]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_11(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[12]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_12(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[13]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_13(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[14]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Position_14(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[15]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
//Position Report - Ship information
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[17]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[18]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_3(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[19]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_4(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[20]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_5(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[21]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_6(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[22]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_7(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[23]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_8(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[24]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_9(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[25]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_10(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[26]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_11(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[27]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_12(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[28]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_13(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[29]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_14(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[30]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_15(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[31]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_16(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[32]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_17(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[33]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_18(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[34]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_ShipInfo_19(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[35]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
//Position report - Emissions
	
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[37]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[38]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_3(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[39]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_4(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[40]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_5(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[41]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_6(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[42]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_7(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[43]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_8(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[44]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_9(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[45]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_10(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[46]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_11(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[47]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_12(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[48]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Emissions_13(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[49]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	
//PositionReport-Weather
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Weather_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[51]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Weather_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[52]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Weather_3(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[53]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Weather_4(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[54]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Weather_5(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[55]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Weather_6(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[56]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Weather_7(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[57]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Weather_8(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[58]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Weather_9(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[59]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_PositionReports_NewShipReport_AvaliableFields_Weather_10(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[5]/ul/li[60]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	//*[@id="ps-list-menu"]
	
//Account reports objects
	
	public static WebElement create_new_report_filter_AccountReports(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/ul/li[3]/a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Title(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[2]/div/div/div"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_NewShipReport_link(WebDriver driver) throws Throwable {
		element = driver.findElement(By.cssSelector("#application > div.layout-main > div.layout-list.reports.full > div.layout-application > div.application__content > div > div.content_scroller_viewport.scroller_viewport > div > div > a > div.title"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}

//Account Report - Avaliable fields - General information
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_1(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[2]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_2(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[3]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_3(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[4]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_4(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[5]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_5(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[6]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_6(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[7]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_7(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[8]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_8(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[9]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_9(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[10]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_10(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[11]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_11(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[12]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_12(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[13]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_Avaliablefields_GeneralInfo_13(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/form/div/div[3]/ul/li[14]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
//User reports
	
	public static WebElement create_new_report_filter_UserReports(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/ul/li[4]/a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_NewUserReport_link(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[1]/a/div[1]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement create_new_report_filter_AccountReports_NewStandardUserReport_link(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[2]/div/div[2]/a/div[1]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement newUserreport_Title(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div/div[1]/div/div/h3"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement newUserreport_subTitle(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div[2]/div/div[1]/div/p"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
//Fleet reports
	
	public static WebElement create_new_report_filter_FleetReports(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/ul/li[5]/a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
		
	}
	
	public static WebElement create_new_report_filter_FleetReports_link(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div/a/div[1]"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
		
	}
	
	public static WebElement create_new_report_filter_FleetReports_Title(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/div[1]/div/div/h3"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
		
	}
//Custom
	
	public static WebElement create_new_report_filter_Custom(WebDriver driver) throws Throwable {
		element = driver.findElement(By.xpath("//div/ul/li[6]/a"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
//hello
	
		public static WebElement create_new_report_filter_hello(WebDriver driver) throws Throwable {
			element = driver.findElement(By.xpath("//div/ul/li[7]/a"));
			HighlightElement.highLightElement(driver, element);
			Thread.sleep(1000);
			return element;
		}
		
//Drag and drop - target
		public static WebElement targetElement(WebDriver driver) throws Throwable {
			element = driver.findElement(By.xpath("//div/div[2]/div/form/div/div[6]/ul"));
			HighlightElement.highLightElement(driver, element);
			Thread.sleep(1000);
			return element;
		}
		
//Run report button
		
		public static WebElement runReport_button(WebDriver driver) throws Throwable {
			element = driver.findElement(By.xpath("//div/div[4]/div/div/div[2]/button[3]"));
			HighlightElement.highLightElement(driver, element);
			Thread.sleep(1000);
			return element;
		}
		
//Run report and create template button
		
		public static WebElement runReport_createtemplate_button(WebDriver driver) throws Throwable {
			element = driver.findElement(By.xpath("//div/div[4]/div/div/div[2]/button[2]"));
			HighlightElement.highLightElement(driver, element);
			Thread.sleep(1000);
			return element;
		}
		
//Report generation confirmation pop-up
		
		public static WebElement pop_Up(WebDriver driver) throws Throwable {
			element = driver.findElement(By.xpath("//div[4]/div/div/div/div[1]/h4"));
			HighlightElement.highLightElement(driver, element);
			Thread.sleep(1000);
			return element;
		}
		
//Report generation confirmation pop-up 0K button
		
		public static WebElement pop_Up_Ok(WebDriver driver) throws Throwable {
			element = driver.findElement(By.xpath("//div[4]/div/div/div/div[3]/button"));
			HighlightElement.highLightElement(driver, element);
			Thread.sleep(1000);
			return element;
			
		
		}

//Generated report name link
		
				public static WebElement reportName(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[2]/div/a/div/div/b"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;
					
				
				}
		
				
//Clone report into a template button
				
				public static WebElement CloneReport(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div/div[2]/button[1]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
//Clone report template save
				
				public static WebElement CloneReport_Save(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[4]/div/div/div[2]/button[2]"));
					
					
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
//Templates_header (after cloning)
				
				public static WebElement Templates_header(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div[2]/div/div[1]/div/h3"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}

				
//Filters section remove button
				
				public static WebElement Filters_remove(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[5]/div[1]/div[4]/button"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				public static WebElement searchBox(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div/input"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				public static WebElement search_contains(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[2]/div/a/div/div/b"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				

			
//Ascending and descending
				
				public static WebElement reports_name(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div[2]/div/div[2]/div/a[1]/div/div/b"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				
//Reports delete
				
				
				public static WebElement delete_report(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div/div[1]/button"));
					
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				
				public static WebElement delete_report_popup(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div/div/div[1]/h4"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				public static WebElement delete_report_popup_message(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div/div/div[2]/p"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				public static WebElement delete_report_popup_cancel(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div/div/div[3]/button[1]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				
				public static WebElement delete_report_popup_ok(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div/div/div[3]/button[2]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				public static WebElement noreports_found(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/p"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
//Report templates
				
				public static WebElement reportTemplates_link(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/a[5]/div/ul/li[2]/a"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				public static WebElement reportTemplates_homepage_header(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[1]/div/h3"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				
				public static WebElement createNewReportTemplate_button(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//ul/li[2]/div/button"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				
				public static WebElement createNewReportTemplate_header(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div[2]/div[2]/div/div[1]/h3"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				
				public static WebElement createNewReportTemplate_subheader(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div[2]/div[2]/div/div[1]/p"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				public static WebElement createNewReportTemplate_ShipReport_link(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[2]/div[1]/a/div[1]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				public static WebElement createNewReportTemplate_ShipReport_header(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[1]/div/div/h3"));
					
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				public static WebElement createNewReportTemplate_ShipReport_subheader(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div[2]/div/div[1]/div/p"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
		
				
//report template - Share level
				
				
				
				public static WebElement createNewReportTemplate_ShipReport_ShareLevel(WebDriver driver) throws Throwable {
					element = driver.findElement(By.cssSelector("#form__item__share_level"));
					
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
//New report template - Save button
				
				
				public static WebElement createNewReportTemplate_ShipReport_Save(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div/div[2]/button[2]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
//Report templates home page 
				
				public static WebElement createNewReportTemplate_Reporttemplate_header(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div[2]/div/div[1]/div/h3"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				public static WebElement createNewReportTemplate_Reporttemplate_search(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//ul/li[1]/form/div/div/input"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				
				public static WebElement createNewReportTemplate_Reporttemplate_createdTemplate_namelink(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[2]/div/div/a/div[1]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
//Clone this template - Templates 	
				
				
				public static WebElement createdTemplate_cloneThisTemplate_button(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[2]/div/div/a/div[1]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
//Created Template - Save
				
				public static WebElement createdTemplate_Save_button(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div/div[2]/button[3]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
//Report template - Position report objects
				
				
				public static WebElement createNewReportTemplate_PositionReport_link(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[2]/div[2]/a/div[1]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
//Report template - Account report objects
				
				
				public static WebElement createNewReportTemplate_AccountReport_link(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[2]/div[3]/a/div[1]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}

				
//Report template - User report objects
				
				
				public static WebElement createNewReportTemplate_UserReport_link(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[2]/div[4]/a/div[1]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
//Report template - Fleet report objects
				
				
				public static WebElement createNewReportTemplate_FleetReport_link(WebDriver driver) throws Throwable {
					element = driver.findElement(By.xpath("//div/div[2]/div[5]/a/div[1]"));
					HighlightElement.highLightElement(driver, element);
					Thread.sleep(1000);
					return element;			
				
				}
				
				
				
}