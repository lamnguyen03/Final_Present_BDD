package stepDefinitions;

import browsers.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void beforeScenario() {
        Driver driverBrowser = new Driver();
        driverBrowser.initDriver();
    }
    @After
    public void afterScenario() {
        driver.quit();
    }
}
