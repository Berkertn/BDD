package tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import utils.DriverManager;

import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public abstract class BaseTest extends DriverManager {
    protected SoftAssertions softAssertion;
    protected Random random;

    @BeforeAll
    public void setUp() {
        setDriver("chrome");
    }

    @Before
    public void beforeTestCases() {
        driver.get(baseUrl);
        softAssertion = new SoftAssertions();
        random = new Random();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //helper functions
    public void scrollToTheElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void hoverTheElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    void takeScreenshot(String testMethod, String testClass) {
        Date date = new Date();
        String screenshotsDir = "src/test/resources/ScreenshotsOfDefects/";
        String extension = ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(screenshotsDir + testClass + "/" + testMethod + "_"
                    + date.getTime() + extension));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void highlightElement(WebElement element) {
        // Use JavaScript to change the element's border style to yellow
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '6px solid yellow'", element);
        // Wait for 500 milliseconds to see the highlighted element
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Use JavaScript to change the element's border style back to its original value
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = ''", element);
    }
}
