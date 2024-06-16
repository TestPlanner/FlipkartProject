package qa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverFactory {
private static WebDriver driver;

	public WebDriver initbrowser(String browserName) {
		
		if (browserName.equals("Chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (browserName.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		return driver;
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
}
