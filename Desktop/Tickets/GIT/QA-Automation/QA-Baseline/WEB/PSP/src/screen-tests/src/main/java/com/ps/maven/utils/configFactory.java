package com.ps.maven.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class configFactory {
	private static Properties properties;

	//private static String propertiesResourcePath = System.getProperty("user.dir") + "\\src\\test\\resource\\properties\\";
	private static String propertiesFileName = "framework.properties";

	public configFactory(){
		configFactory.loadProperties();
	}
	
	public static Properties getProps(){
		return properties;
	}
	
	private static void loadProperties() {

		try {
		if (properties == null) {
			properties = new Properties();
			
			
				properties.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\" + propertiesFileName));
		}	
		} catch (Exception e) {
				LoggingFactory.error(e);
				
		}
	}
}
