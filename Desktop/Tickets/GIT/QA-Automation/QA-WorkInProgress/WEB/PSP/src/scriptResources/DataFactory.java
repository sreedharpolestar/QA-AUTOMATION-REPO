package scriptResources;

import java.io.FileInputStream;
import java.util.Properties;

public class DataFactory {
	private static Properties properties;
	private static String dataSourceFilePath = "C://Users//sreedhar.popuri//workspace//selenium//Jenkins//Automation_Jenkins//src//Notification_resources//data//";
	private static String dataSourceFileName = "testData.properties";
	

	public DataFactory() {
		DataFactory.loadData();

	}

	public static Properties getTestData() {
		return properties;
	}

	private static void loadData() {
		try {
			if (properties == null) {
				properties = new Properties();

				properties.load(new FileInputStream(dataSourceFilePath + dataSourceFileName));

			}
		} catch (Exception e) {
			LoggingFactory.error(e);
			e.printStackTrace();
		}

	}

}
