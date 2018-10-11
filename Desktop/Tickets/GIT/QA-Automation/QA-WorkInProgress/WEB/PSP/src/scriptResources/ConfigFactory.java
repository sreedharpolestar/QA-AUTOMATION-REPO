package scriptResources;


import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFactory extends DataFactory{

	private static Properties properties;

	private static String propertiesResourcePath = "C://Users//sreedhar.popuri//workspace//selenium//Jenkins//Automation_Jenkins//PSP-Baseline//src//Notification_resources//";
	
	private static String propertiesFileName = "framework.properties";

	public ConfigFactory(){
		ConfigFactory.loadProperties();
	}
	
	public static Properties getProps(){
		return properties;
	}
	
	private static void loadProperties() {

		try {
		if (properties == null) {
			properties = new Properties();
			
				properties.load(new FileInputStream(propertiesResourcePath + propertiesFileName));
		}	
		} catch (Exception e) {
				LoggingFactory.error(e);
				
		}
	}
}
