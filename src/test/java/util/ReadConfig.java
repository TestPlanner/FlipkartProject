package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import qa.DriverFactory;

public class ReadConfig {

	//String browserName;
	DriverFactory df;
	public  String readConfig() throws IOException {
		String path =System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties";
		File pathp = new File(path);
		FileInputStream file = new FileInputStream(pathp);
		Properties pro = new Properties();
	     pro.load(file);
		String browser = pro.getProperty("browser");
		
		return browser;
	}
	
}
