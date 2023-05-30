package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.BaseTest;
import utils.DriverManager;

import java.time.Duration;

public class EbayHomeSteps {

    BaseTest baseTest;
    WebDriver driver = Hooks.getDriver();

    @Given("I am on Ebay Home Page")
    public void i_am_on_ebay_home_page() {
        System.out.println("perform the first");
    }

    @When("I click on Advanced Link")
    public void i_click_on_advanced_link() {
        System.out.println("I click on Advanced Link but not with code aq");
        // WebElement loginButton = homePage.getElement(homePage.loginButtonSelector);
        //loginButton.click();
    }

    @Then("I navigate to Advanced Search page")
    public void i_navigate_to_advanced_search_page() {
        System.out.println("I came I saw praise to Lord");
    }
}
