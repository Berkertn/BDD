package runner;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenshotTestWatcher extends TestWatcher {
    private final WebDriver driver;

    public ScreenshotTestWatcher(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        System.out.println("Test failed: " + description.getMethodName());
        captureScreenshot(description.getMethodName());
    }

    private void captureScreenshot(String methodName) {
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
            try {
                String screenshotFileName = methodName + ".png";
                FileUtils.copyFile(screenshotFile, new File("test/resources/failed/screenshots/" + screenshotFileName));
            } catch (IOException e) {
                System.out.println("Failed to save screenshot: " + e.getMessage());
            }
        }
    }
}
