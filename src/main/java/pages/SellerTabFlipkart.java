package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SellerTabFlipkart {
	
	
	
	@FindBy (xpath = "//button[text()='Start Selling']")
	private WebElement startSelling;
	
	@FindBy (xpath = "//input[@label='Enter Mobile Number']")
	private WebElement enterMobileNo;
	
	@FindBy (xpath = "//input[@label='Email ID']")
	private WebElement enterEmailId;
	
	@FindBy (xpath = "//input[@label='Enter GSTIN']")
	private WebElement enterGSTNo;
	
	@FindBy (xpath = "//span[text()='Register & Continue']")
	private WebElement registerbutton;
	
	@FindBy (xpath = "//p[text()= 'Please verify your mobile number through OTP before you register']")
	private WebElement otpErrorMsg;
	
	@FindBy (xpath = "//ul[contains(@class,'sd-header-list-container clearfix')]//a[text()='Sell Online']")
	private WebElement sellOnline;
	
	@FindBy (xpath = "//li[@class='sd-header-sub-list undefined']")
	private List<WebElement> sellOnlineList;
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions act;
	private ArrayList<String> list;
	public SellerTabFlipkart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		act = new Actions(driver);
	}

	public WebDriver getWebDriver() {
		return driver;
	}
	
	public void clickSelling() {
		wait.until(ExpectedConditions.visibilityOf(startSelling));
		startSelling.click();
	}
	
	public void enterMobileNo(String MobileNo) {
		enterMobileNo.sendKeys(MobileNo);
	}
	public void enterEmailId(String EmailID) {
		enterEmailId.sendKeys(EmailID);
	}
	public void enterGSTNo(String gstno) {
		enterGSTNo.sendKeys(gstno);
	}
	public void clickRegisterButton() {
		registerbutton.click();
	}
	public boolean otperrorValidation() {
		boolean result = otpErrorMsg.isDisplayed();
		return result;
	}
	
	public ArrayList<String> getSellOnlineOptions() {
		act.moveToElement(sellOnline).perform();
		list = new ArrayList<String>();
		for(WebElement option :sellOnlineList) {
			list.add(option.getText());
		}
		return list;
	}
}
