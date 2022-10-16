package step_Definitions;

import POM.SelectProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utility.BaseClass;

public class Select_product extends BaseClass{

	
	SelectProductPage selectp;
	
	@Then("^click on this (.*)$")
	public void click_on_categories(String Cate) {
		selectp=new SelectProductPage(driver);
	   selectp.click_categories(Cate);
	}

	@And("^select product you like Eg:(.*)$")
	public void select_product_you_like(String product) throws InterruptedException {
		selectp.click_at_product(product);
	}

	@And("print product detail")
	public void print_product_detail() {
		selectp.product_detail();
	}	
	
	@Then("verify it is selected product")
	public void verify_it_is_selected_product() {
		selectp.validate_selected_pt();
	}

	@Then("click on add to cart")
	public void click_on_add_to_cart() throws InterruptedException {
		selectp.click_Add_to_cart();
	}

	@And("check if the product is added to cart")
	public void check_if_the_product_is_added_to_cart() {
	   selectp.check_product_at_cart();
	}

}
