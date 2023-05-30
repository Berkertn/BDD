package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.time.Duration;

public class Hooks {

    private static WebDriver driver;


    @Before
    public void setUp() {
        System.out.println("selam balım");
        driver = DriverManager.init("chrome");
        driver.get(DriverManager.baseUrl);
    }

    @After
    public void tearDown() {
        System.out.println("kaçtım");
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
