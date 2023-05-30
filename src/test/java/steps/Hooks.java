package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;
import utils.DriverManager;

import java.time.Duration;

public class Hooks {

    private static WebDriver driver;
    private final BaseTest testFunctions = new BaseTest();


    @Before
    public void setUp() {
        System.out.println("Tests Are Deploying...");
        driver = DriverManager.init("chrome");
        driver.get(DriverManager.baseUrl);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            testFunctions.takeScreenshot(scenario.getName(), scenario.getId());
        }
        System.out.println("Tearing Down");
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
