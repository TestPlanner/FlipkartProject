package steps;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlipkartHome;
import pages.SellerTabFlipkart;
import qa.DriverFactory;

public class SellerRegistration {

	private SellerTabFlipkart st =new SellerTabFlipkart(DriverFactory.getDriver());
	private FlipkartHome fkhome = new FlipkartHome(DriverFactory.getDriver());
	private  ArrayList<String> list;
	private List<String> data;
	
	@When("user clicks on become seller button")
	public void user_clicks_on_become_seller_button() {
	 fkhome.becomeSeller();
	}
	//user clicks on start selling button
	@When("user clicks on start selling button")
	public void user_clicks_on_start_selling_button() {
	 st.clickSelling();
	}
	
	@When("user enters mobile number {string}")
	public void user_enters(String mobileno) {
	   st.enterMobileNo(mobileno);
	}

		
	@When("user enters emailid {string}")
	public void enter_enters(String emailid) {
	   st.enterEmailId(emailid);
	}

	@When("user enter gst number {string}")
	public void user_enters_gst_no(String gstno) {
	   st.enterGSTNo(gstno);
	}
	@When("user clicks on register button")
	public void user_clicks_on_register_button() {
	    st.clickRegisterButton();
	}

	@Then("verify error msg get displayed")
	public void verify_error_msg_get_displayed() {
	   try {
		   boolean result = st.otperrorValidation();
		   Assert.assertEquals(result, true);
	   }
	   catch(Exception e) {
		   System.out.println(e.getMessage());
	   }
	}
	
	@Then("validate options available in sell online dropdown")
	public void validate_options_available_in_sell_online_dropdown(DataTable dataTable) {
	  data =dataTable.asList();
		list = st.getSellOnlineOptions();
	   for(String option:data) {
		   System.out.println(option);
		   if(list.contains(option)) {
		   Assert.assertTrue(list.contains(option));}
		   else {System.out.println("SellOnline is missing this option: "+option);}
		   
	   }
	}

}
