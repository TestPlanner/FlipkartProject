package steps;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlipkartHome;
import qa.DriverFactory;

public class LoginButtonOptions {
FlipkartHome hm = new FlipkartHome(DriverFactory.getDriver());
ArrayList<String> al1 = new ArrayList<>();
	@When("user scrolls on login button")
	public void user_scrolls_on_login_button() {
	    hm.scrollToLoginbutton();
	}

	@Then("user can see all six options")
	public void user_can_see_all_six_options(io.cucumber.datatable.DataTable dataTable) {
	   al1= hm.loginButtonOptions();
	   for(String option1:al1) {
		   System.out.println(option1);
	   }
	   List<String> al2 = dataTable.asList();
	   for(String option:al2) {
		   //System.out.println(option);
		   if(!al1.contains(option)) {
			   Assert.assertFalse(false);
			   System.out.println(option+": is not present in the list");
		   }
		   else {
			   Assert.assertTrue(true);
		   }
	   }
	}

}
