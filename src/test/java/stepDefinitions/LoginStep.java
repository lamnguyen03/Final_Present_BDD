package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginStep {
    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriver driver;

    @Given("^user is on the home page$")
    public void user_is_on_the_home_page() {
        driver = Hooks.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
    }

    @And("^user navigates to the login page$")
    public void user_navigates_to_the_login_page() {
        loginPage = homePage.navigateToLoginPage();
    }

    @When("^user enters email \"(.*)\" and password \"(.*)\"$")
    public void user_enters_email_and_password(String email, String password) {
        loginPage.setEmail(email).setPassword(password);
    }

    @And("^user clicks on the login button$")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLogInBtn();
    }

    @Then("^display success message and navigate to the home page$")
    public void display_success_message_and_navigate_to_the_home_page() {
        Assert.assertTrue("Login success message is not displayed", loginPage.isLogInSuccess());
    }

    @Then("^display fail message and navigate to the home page$")
    public void display_fail_message_and_navigate_to_the_home_page() {
        Assert.assertTrue("Login fail message is not displayed", loginPage.isLogInFail());
    }
}