package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FilterMobileByCatagory {

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private List<String> listText;
	
	public FilterMobileByCatagory(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		 js = (JavascriptExecutor)driver;
	}
	
	@FindBy (xpath = "//input[@title='Search for Products, Brands and More']")
	private WebElement searchBox;
     
	@FindBy (xpath = "//button[@type='submit']")  //Brand Redmi
	private WebElement submit;
	public void searchBoxClicker(String text){
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(text);
		submit.click();
	}

	@FindBy (xpath = "//div[@class ='suthUA']//select[@class='Gn+jFg']")
	private WebElement minPrice;

	public void selectminPrice(Integer minValue){
		wait.until(ExpectedConditions.visibilityOf(minPrice));
		Select s = new Select(minPrice);
	s.selectByValue(Integer.toString(minValue));
	}

	@FindBy (xpath = "//div[@class ='tKgS7w']//select[@class='Gn+jFg']")
	private WebElement maxPrice;

	public void selectmaxPrice(Integer maxValue){
		wait.until(ExpectedConditions.visibilityOf(maxPrice));
	Select s = new Select(maxPrice);
	s.selectByValue(Integer.toString(maxValue));
	}

	@FindBy (xpath = "//div[text() = 'SAMSUNG' and @class='_6i1qKy']")  //Brand Samsung
	private WebElement brandSamsung;

	public void selectSamsungBrand(){
    wait.until(ExpectedConditions.visibilityOf(brandSamsung));	
	brandSamsung.click();
	}

	@FindBy (xpath = "//div[text() ='REDMI'and @class='_6i1qKy']")  //Brand Redmi
	private WebElement brandRedmi;
	
	@FindBy (xpath = "//input[@class='XPD6hh']")
	private WebElement searchBrand;

	public void selectRedmiBrand(String brand) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(searchBrand));
		searchBrand.sendKeys(brand);
		Thread.sleep(5000);
		brandRedmi.click();
		Thread.sleep(5000);
		searchBrand.clear();
		Thread.sleep(5000);
//		if(!brandRedmi.isSelected()) {brandRedmi.click();}
		}
	
		//button[@type='submit']
	@FindBy (xpath = "//*[text()='REDMI Note 13 5G (Arctic White, 128 GB)']")
	private WebElement singleElement;
	
	@FindBy (xpath = "//*[@class='KzDlHZ']")  //list of webelement fetched on screen
	private List<WebElement> allFetchedResult;

	public List<String> allDisplayedDevices(String brand1, String brand2){
	//wait.until(ExpectedConditions.visibilityOfAllElements(allFetchedResult));
		wait.until(ExpectedConditions.visibilityOfAllElements(singleElement));
		System.out.println(singleElement.getText());;
	listText = new ArrayList<>();
	for( WebElement singleDevice : allFetchedResult){
	String text = singleDevice.getText();
    listText.add(text);}
	System.out.println(listText);
	return listText;
    
	}
	
	
	
}
