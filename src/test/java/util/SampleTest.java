package util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SampleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Actions act = new Actions(driver);
		WebElement loginButton = driver.findElement(By.xpath("//span[text()= 'Login']"));          //xpath = "//span[text()= 'Login']";
		 act.moveToElement(loginButton).perform();
		List<WebElement> optionsOfLogin=driver.findElements(By.xpath("//*[@class='_3YjYK7 ecs1XG']//child::a//li"));
		for(WebElement eachOption:optionsOfLogin) {
			String text=eachOption.getText();
			System.out.println(text);
		}
		System.out.println("end");
	}

}
