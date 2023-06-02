package steps;

import io.cucumber.java.en.*;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import tests.BaseTest;
import org.assertj.core.api.SoftAssertions;
import utils.DriverManager;

import java.time.Duration;

public class EbayHomeSteps extends CommonSteps {
    HomePage homePage;


    @Given("I am on Tech Crunch Home Page")
    public void home_page() {
        System.out.println("perform the first");
        homePage = new HomePage(driver);
    }

    @When("I click on {string} Button")
    public void click_on_login_button(String buttonName) throws Exception {
        WebElement wantedButton = homePage.getElement(homePage.loginButtonSelector);
        clickButton(wantedButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("I navigate to {string} page")
    public void i_navigate_to_advanced_search_page(String pageTitle) {
        // you can create an enum or something like that and take the action
        WebElement theLatestNewsElement;
        softAssertion.assertThat(homePage.getBrowserTitle())
                .as("Element Text Content Check for login button ")
                .doesNotContain(pageTitle);
        //.contains("TechCrunch");
        softAssertion.assertAll();
    }
}
