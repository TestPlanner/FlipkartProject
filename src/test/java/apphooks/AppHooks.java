package apphooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.DriverFactory;
import util.ReadConfig;

public class AppHooks {
	
	private WebDriver driver;
	private DriverFactory df;
	 private ReadConfig rc;
	 
    @Before
	public void launchBrowser() throws IOException
	{
    	 rc = new ReadConfig();
    	 String browser = rc.readConfig();
    	 df = new DriverFactory();
		 driver = df.initbrowser(browser);
		 driver.manage().window().maximize();
	}
	
    
    @After(order =1)
    public void takeScreenShot(Scenario scenario) {
    	boolean result=scenario.isFailed();
    	String scenarioName = scenario.getName();
    	if(result) {
    		byte[] source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(source, "image/png", scenarioName);
    		  	}
    }
	@After(order=0)
	public void tearDown()
	{
		//driver.quit();
	}
}
