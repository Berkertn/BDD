package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import tests.BaseTest;
import org.assertj.core.api.SoftAssertions;
import utils.DriverManager;

import java.time.Duration;

public class EbayHomeSteps {

    BaseTest testFunctions = new BaseTest();
    WebDriver driver = Hooks.getDriver();
    protected SoftAssertions softAssertion = new SoftAssertions();

    // declaring POMs'
    HomePage homePage;

    @Given("I am on Tech Crunch Home Page")
    public void home_page() {
        System.out.println("perform the first");
        homePage = new HomePage(driver);
    }

    @When("I click on Login Button")
    public void click_on_login_button() {
        WebElement loginButton = homePage.getElement(homePage.loginButtonSelector);
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("I navigate to Login page")
    public void i_navigate_to_advanced_search_page() {
        WebElement theLatestNewsElement;
        softAssertion.assertThat(homePage.getBrowserTitle())
                .as("Element Text Content Check for login button ")
                .doesNotContain("TechCrunch");
        softAssertion.assertAll();
    }
}
