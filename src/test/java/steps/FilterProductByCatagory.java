package steps;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FilterMobileByCatagory;
import qa.DriverFactory;

public class FilterProductByCatagory {

	private FilterMobileByCatagory filter = new FilterMobileByCatagory(DriverFactory.getDriver());
	private List<String> devicelist;
	@When("user search for {string}")
	public void user_search_for_mobile(String device) {
	    filter.searchBoxClicker(device);
	}

	@When("user select brand {string} and {string} from the brand filter")
	public void user_select_brand_and_from_the_brand_filter(String string1, String string2) throws InterruptedException {
		filter.selectSamsungBrand();
		filter.selectRedmiBrand(string2);
	}

	@When("user selects price range from {int} to {int}")
	public void user_selects_price_range_from_to(Integer int1, Integer int2) {
	    
	    filter.selectmaxPrice(int2); 
		   filter.selectminPrice(int1);
	}

	@Then("validate oprions showing are of {string} and {string}")
	public void validate_oprions_showing_are_of_and(String string1, String string2) {
	    devicelist = filter.allDisplayedDevices(string1, string2);
	    for(String device : devicelist) {
	    if(device.toUpperCase().contains(string1)||device.toUpperCase().contains(string2))
	    {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.assertTrue(false);
	    }
	    }
	}
	
}
