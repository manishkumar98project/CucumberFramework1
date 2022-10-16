package step_Definitions;

import POM.Contactspage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utility.BaseClass;

public class Fill_Contacts_Details extends BaseClass{
	Contactspage con;
	
	@Then("click at Contacts to fill details")
	public void click_at_contacts_to_fill_details() {
	   con=new Contactspage(driver);
	   con.click_nav_contacts();
	}
	@And("^fill details Contact-email (.*)$")
	public void fill_details_contact_email_rgmail_com(String e) {
	    con.fill_email(e);
	}
	@And("^fill ContactName (.*)$")
	public void fill_contact_name_name1(String n) {
	    con.fill_name(n);
	}
	@And("^fill any Message (.*)$")
	public void fill_any_message_good_website_for_practice(String m) {
	    con.fill_message(m);
	}
	@Then("click send message")
	public void click_send_message() throws InterruptedException {
	   con.click_send_message();
	   
	}


}
