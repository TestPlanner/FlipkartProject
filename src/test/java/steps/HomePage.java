package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlipkartHome;
import qa.DriverFactory;

public class HomePage {
	FlipkartHome fkhome = new FlipkartHome(DriverFactory.getDriver());
	
	@Given("user at home page")
	public void user_at_home_page() {
	   WebDriver driver =  DriverFactory.getDriver();
	    driver.get("https://www.flipkart.com/");
	    
	}

	@Then("user able to see content of page")
	public void user_able_to_see_content_of_page() {
	    boolean status = fkhome.pageloaded();
	    Assert.assertEquals(status, true);
	}

	@Then("title of the page is correct")
	public void title_of_the_page_is_correct() {
		String title = fkhome.getTitleOfThePage();
	    boolean result = title.contains("Online Shopping");
	    Assert.assertEquals(result, true);
	}
	
	@When("user enters {string} in search bar and clicks on any option")
	public void user_enters_in_search_bar_and_press_enter(String string) {
	    fkhome.enteringSearchOption(string);
	}


	@Then("user should redirect to product details page")
	public void user_should_redirect_to_product_details_page() {
	    
	}

	@When("user add selected laptop to the shopping cart")
	public void user_add_selected_laptop_to_the_shopping_cart() {
	   
	}

	@Then("laptop should get added to the shopping cart")
	public void laptop_should_get_added_to_the_shopping_cart() {
	    
	}
//
//	@When("user navigate to shopping cart")
//	public void user_navigate_to_shopping_cart() {
//	    
//	}
//
//	@Then("user should see correct item in the shopping cart")
//	public void user_should_see_correct_item_in_the_shopping_cart() {
//	    
//	}
//
//	@When("user click on proceed to checkout button")
//	public void user_click_on_proceed_to_checkout_button() {
//	    
//	}
//
//	@Then("user at checkout page")
//	public void user_at_checkout_page() {
//	   
//	}
//
//	@When("user enter valid mobile number and OTP and logs in")
//	public void user_enter_valid_mobile_number_and_otp_and_logs_in() {
//	    
//	}
//
//	@Then("user able to logged in successfully")
//	public void user_able_to_logged_in_successfully() {
//	   
//	}
//
//	@Then("user directed to delivery address tab")
//	public void user_directed_to_delivery_address_tab() {
//	    
//	}
//
//	@When("user enters address details such as city, state and zip code")
//	public void user_enters_address_details_such_as_city_state_and_zip_code() {
//	    
//	}
//
//	@When("user click on send and deliver here button")
//	public void user_click_on_send_and_deliver_here_button() {
//	    
//	}
//
//	@Then("user should be directed to order summary page")
//	public void user_should_be_directed_to_order_summary_page() {
//	    
//	}
//
//	@Then("correct product details displayed in order summary page")
//	public void correct_product_details_displayed_in_order_summary_page() {
//	    
//	}
//
//	@Given("user at payment options tab")
//	public void user_at_payment_options_tab() {
//	    
//	}
//
//	@When("user selects credit card option")
//	public void user_selects_credit_card_option() {
//	    
//	}

}
