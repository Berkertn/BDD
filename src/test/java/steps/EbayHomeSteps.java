package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHomeSteps extends BaseSteps {

    @Given("I am on Ebay Home Page")
    public void i_am_on_ebay_home_page() {
        System.out.println("I have a precondition");
    }

    @When("I click on Advanced Link")
    public void i_click_on_advanced_link() {
        System.out.println("I perform an action");
    }

    @Then("I navigate to Advanced Search page")
    public void i_navigate_to_advanced_search_page() {
        System.out.println("I came I saw praise to Lord");
    }
}
