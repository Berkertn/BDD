package steps;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

public abstract class CommonSteps {

    BaseTest testFunctions = new BaseTest();
    Hooks hooks = new Hooks();
    WebDriver driver = hooks.getDriver();
    protected SoftAssertions softAssertion = new SoftAssertions();

    public void clickButton(WebElement element) {
        element.click();
    }
}
