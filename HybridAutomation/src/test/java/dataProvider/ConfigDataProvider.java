package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	FileInputStream fis;

	public ConfigDataProvider() {

		//File src = new File("C:/expert2017/workspaceMaven/HybridAutomation/Configuration/config.properties");
		File src = new File("Configuration/config.properties");

		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	
	
	
	
	public String getChromePath() {
		
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
	}
	
	public String getFirefoxPath() {
		String firefoxPath = prop.getProperty("firefoxPath");
		return firefoxPath;
	}
	
	public String getApplicationUrl() {
		
		String url = prop.getProperty("url");
		
		return url;
	}

}
