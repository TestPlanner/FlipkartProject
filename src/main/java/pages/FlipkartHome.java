package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartHome {

		
	@FindBy (xpath= "//input[@type='text']")
	private WebElement searchbox;
	
	@FindBy (xpath= "//*[@alt='Electronics']")
	private WebElement electronics;
	
	@FindBy (xpath = "//a[text()='Become a Seller']")
	private WebElement becomeSeller;
	
	@FindBy (xpath = "//span[text()='Sign Up']")
	private WebElement signup;
	
	@FindBy (xpath= "//li[1]//div[@class='_3idirA']")
    private WebElement laptopOption;
	
	@FindBy (xpath = "//li[2]//img[@class='_2puWtW _3a3qyb']")
	private WebElement laptop2;
	
	@FindBy (xpath = "//div[text()='Acer Aspire 3 Intel Core i3 12th Gen 1215U - (8 GB/512 GB SSD/Windows 11 Home) A315-59 Thin and Light ...']")
	private WebElement acerLaaptop;
	
	@FindBy (xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addtocart;
	
	@FindBy (xpath = "//*[text()='Place Order']")
	private WebElement placeOrder;
	
	@FindBy (xpath = "//*[@class='_1hUz_t _2-K-ro']")
	private WebElement loginTab;
	
	@FindBy (xpath = "//*[@type='text']")
	private WebElement mobilenumber;
	
	@FindBy (xpath = "//*[@class='_2KpZ6l _20xBvF _3AWRsL']")
	private WebElement continuebutton;
	
	@FindBy (xpath = "//div[@class='IiD88i GtCYSF'][2]")
	private WebElement otp;
	
	@FindBy (xpath= "//*[@class='_2KpZ6l _20xBvF _3AWRsL']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//*[@class='_1hUz_t _2-K-ro']")
	private WebElement deliveryAddressTab;
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	public FlipkartHome(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		 js = (JavascriptExecutor)driver;
	}
	
	public String getTitleOfThePage() {
		
		String title = driver.getTitle();
		return title;
	}
	
	public boolean pageloaded() {
		wait.until(ExpectedConditions.visibilityOf(electronics));
		boolean result=electronics.isDisplayed();
		return result;
	}
	
	public void enteringSearchOption(String item) {
		searchbox.sendKeys(item);
		wait.until(ExpectedConditions.visibilityOf(laptopOption));
		Actions act = new Actions(driver);
		act.moveToElement(laptopOption).click().build().perform();
		
	}
	
	public void signupClick() {
		
		signup.click();
	}
	
public void becomeSeller() {
		
	becomeSeller.click();
	}
	
	
}
