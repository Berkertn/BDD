package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;
import utils.DriverManager;


public class Hooks extends DriverManager {
    private final BaseTest testFunctions = new BaseTest();


    @Before
    public void setUp() {
        setDriver("chrome");
        System.out.println("Tests Are Deploying...");
        driver.get(DriverManager.baseUrl);
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Test failed, perform actions
            System.out.println("Test failed: " + scenario.getName());

            // Take a screenshot or perform any other necessary actions
            testFunctions.takeScreenshot(scenario.getName(), scenario.getClass().toString());
        }
    }

    @After(order = 0)
    public void tearDown() {
        System.out.println("Tearing Down Latest");
        driver.quit();
    }
}
