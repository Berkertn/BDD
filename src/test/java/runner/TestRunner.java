package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import steps.Hooks;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps"
        //,tags = "@regression" it like a grep and if you add @regression on top of the scenario you can run with filter
        //plugin = {"pretty", "html:target/cucumber-reports"}
        //,dryRun = true that used to check step definitions are okay and is there any missing
        //,name = "nameFilterTest" filter the name of scenario and run
)
public class TestRunner {

    @ClassRule
    public static ScreenshotTestWatcher customTestWatcher = new ScreenshotTestWatcher(Hooks.getDriver());

    @BeforeClass
    public static void setUp() {
        // Test setup code
    }

    @AfterClass
    public static void tearDown() {
        // Test teardown code
    }
}
