package pageObjectMethods;

/*import modules.HighlightElement;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import scriptResources.*;
import administration.*;

public class ShipsIMOnumber {

	private static WebElement element = null;

	/********* Register with IMO number **********/
	public static WebElement ships_menu(WebDriver driver) {
		//div[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div[4]/a/div[1]
		element = driver.findElement(By.xpath("//a[@href='#admin/subscriptions']/div[text()='Ships']"));
		return element;
	}
	public static WebElement ships_header_title(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".slim.aligned"));
		return element;
	}
	public static WebElement new_register_ship(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".btn.btn-primary.navbar-btn.btn-add"));
		return element;
	}
	public static WebElement register_ship_header(WebDriver driver) {
		//*[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div/h3
		element = driver.findElement(By.xpath("//div[@class='ps-intro wizard--header']//h3[text()='Register ship']"));
		return element;
	}
	public static WebElement with_IMO_number(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='application']/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div/div/a[1]"));
		return element;
	}

	public static WebElement enter_search_for_ship_link(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//form/div/div/input"));
		return element;
	}
	public static WebElement click_on_first_ship_link(WebDriver driver) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='awesomplete']/ul/li/div/mark[contains(text(),'9328649')]")));
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("//div[@class='awesomplete']/ul/li/div/mark[contains(text(),'9328649')]"));
		return element;
	}
	public static WebElement verify_ship_IMO_number(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='ship-register__ship-card']/descendant::td[text()='9328649']"));
		return element;
	}
	public static WebElement select_ship_IMO_number(WebDriver driver) {
		element = driver.findElement(By.xpath("//li/div"));
		return element;
	}
	public static WebElement verify_ship_name(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#application > div.layout-main > div.layout-list.admin.full > div.layout-application > div.application__content > div > div > div:nth-child(2) > div > div > div.panel-body.wizard--step > div > div > div.ship-register__ship-select__region-card > div > div > div.media-body > h4"));
		
		return element;
	}
	public static WebElement verify_ship_imo(WebDriver driver) {
		element = driver.findElement(By.cssSelector("td"));
		return element;
	}
	public static WebElement verify_ship_type(WebDriver driver) {
		element = driver.findElement(By.xpath("//tr[2]/td"));
		return element;
	}
	public static WebElement verify_registered_owner(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[3]/td"));
		return element;
	}
	public static WebElement verify_ship_manager(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[4]/td"));
		return element;
	}
	public static WebElement verify_ship_operator(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[5]/td"));
		return element;
	}
	public static WebElement verify_ship_flag(WebDriver driver) {		
		element = driver.findElement(By.xpath("//table/tbody/tr[6]/td"));
		return element;
	}
	public static WebElement verify_mmsi(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[7]/td"));
		
		
		return element;
	}
	public static WebElement verify_call_sign(WebDriver driver) {		
		element = driver.findElement(By.xpath("//table/tbody/tr[8]/td"));
		
		return element;
	}
	public static WebElement port_of_registry(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[9]/td"));
		return element;
	}
	public static WebElement classification_society(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[10]/td"));
		return element;
	}
	public static WebElement stat_code_5(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[11]/td"));
		return element;
	}
	public static WebElement deadweight(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[12]/td"));
		return element;
	}
	public static WebElement displacement(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[13]/td"));
		return element;
	}
	public static WebElement gross_tonnage(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[14]/td"));
		return element;
	}
	public static WebElement length_of_overall(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[15]/td"));
		return element;
	}
	public static WebElement breadth(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[16]/td"));
		return element;
	}
	public static WebElement depth(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[17]/td"));
		return element;
	}
	public static WebElement draught(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[18]/td"));
		return element;
	}
	public static WebElement ship_builder(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[19]/td"));
		return element;
	}
	public static WebElement country_of_build(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[20]/td"));
		return element;
	}
	public static WebElement year_of_build(WebDriver driver) {		
		element = driver.findElement(By.xpath("//tr[21]/td"));

		return element;
	}
	public static WebElement Search_for_ship_next(WebDriver driver) {		
		element = driver.findElement(By.cssSelector(".btn.btn-primary.btn-next"));
		return element;
	}
	public static WebElement click_on_first_account(WebDriver driver) {
		element = driver.findElement(By.xpath("//div/div/div/div/input"));
		
		return element;
	}
	public static WebElement verify_parent_account_name(WebDriver driver) {
		element = driver.findElement(By.xpath("//a/div/div/div[2]/div/div"));
		return element;
	}
	public static WebElement verify_register_transceive(WebDriver driver) {
		element = driver.findElement(By.xpath("//h3"));
		return element;
	}
	public static WebElement verify_account_name(WebDriver driver) {
		element = driver.findElement(By.xpath("//h3"));
		return element;
	}
	public static WebElement search_for_ship_cancel(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".btn.btn-default.btn-cancel"));
		return element;
	}
	public static WebElement register_transceiver_account_name(WebDriver driver) {
		element = driver.findElement(By.className("label-summary"));
		return element;
	}	
	public static WebElement search_for_ship_back(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".btn.btn-default.btn-back"));
		return element;
	}
	public static WebElement select_account(WebDriver driver) {
		element = driver.findElement(By.name("account"));
		return element;
	}
	public static WebElement select_fleet(WebDriver driver) {
		element = driver.findElement(By.xpath("//div/div/div/h3"));
		
		return element;
	}
	
	public static WebElement fleet_name(WebDriver driver) {
		element = driver.findElement(By.xpath("//div/div/a/div/div/div[1]/div/input"));
		return element;
	}
	public static WebElement register_transceiver(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".btn.btn-primary.btn-save"));
		return element;
	}
	public static WebElement ships_with_IMO_number_save(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[3]/div/div/div/div[2]/button"));
		return element;
	}
	public static WebElement ships_required_field_transceiver_menu(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[2]/div/ul/li"));
		return element;
	}	
	public static WebElement ships_with_IMO_number_register_transceiver_model(WebDriver driver){
		element = driver.findElement(By.id("ship-register__transceiver-item__model"));
		return element;
	}
	public static WebElement ships_with_IMO_number_register_transceiver_model_selected(WebDriver driver){
		element = driver.findElement(By.xpath("//option[2]"));
		return element;
	}
	public static WebElement transceiver_reporting_rate(WebDriver driver) {
		element = driver.findElement(By.id("#ship-register__transceiver-item__periodic_interval"));
		return element;
	}
	public static WebElement verify_ship_and_transciver_registered(WebDriver driver) {
		element = driver.findElement(By.xpath("html/body/div[4]"));
		return element;
	}
	
	public static WebElement ship_name(WebDriver driver) {
		element = driver.findElement(By.xpath("//div/div[1]/div/h3/span[2]"));
		return element;
	}
	
	public static WebElement transceiver_save(WebDriver driver) {
		element = driver.findElement(By.xpath("//div/div/div[3]/div/div/div/div[2]/button"));
		return element;
	}
	
	public static WebElement transceiver(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ship-register__transceiver-item__model"));
		return element;
	}
	
	public static WebElement recentlyadded_dropdown(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[2]/button/span[2]"));
		
		return element;
	}
	
	public static WebElement recentlyadded_select(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[2]/ul/li[1]/a"));
		
		return element;
	}
	
	public static WebElement ship_select(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#application > div.layout-main > div.layout-list.admin.full.admin-list.admin-subscription > div.layout-application > div.application__content > div > div.content_scroller_viewport.scroller_viewport > div > a:nth-child(1) > div > div:nth-child(2) > div.col-sm-9 > h5"));
		return element;
	}
	
	
	public static WebElement regidtered_ship(WebDriver driver) throws Exception {
		element = driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div/h3"));
		HighlightElement.highLightElement(driver, element);
		Thread.sleep(1000);
		return element;
	}
	
	public static WebElement account(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#form__item__account"));
		
		
		return element;
	}
	
	
	
	
	
	
}
