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

    @After(order = 0)
    public void tearDown() {
        System.out.println("Tearing Down");
        driver.quit();
    }
}
