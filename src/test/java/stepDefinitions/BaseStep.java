package stepDefinitions;

import browsers.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;

public class BaseStep {
    protected HomePage homePage;
    protected WebDriver driver;

    public BaseStep() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("^user is on the home page$")
    public void user_is_on_the_home_page() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
    }
}
