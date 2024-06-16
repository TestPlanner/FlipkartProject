package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class TestCaseCreatorAPI {

	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
               options.addArguments("--incognito");
           WebDriver driver = new ChromeDriver(options);
              driver.get("https://chatgpt.com/?oai-dm=1");
driver.manage().window().maximize();
driver.findElement(By.xpath("//textarea[@id='prompt-textarea']"))
.sendKeys("write down api test cases");   //ExcellReader.excelReader()
driver.findElement(By.xpath("//button[@data-testid='send-button']")).click();
System.out.println("test Complete");
	}

}
