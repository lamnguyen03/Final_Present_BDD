package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.SignUpPage;

import java.util.Random;

public class SignUpStep{
    private SignUpPage signUpPage;
    private BaseStep baseStep = new BaseStep();
    @And("^user navigate to the sign up page$")
    public void user_navigate_to_the_sign_up_page(){
        signUpPage = baseStep.homePage.navigateToSignUpPage();
    }
    @When("^user enters their (.+),(.+),(.+),(.+),(.+)$")
    public void the_user_enters_their_first_name_last_name_email_password_confirm_password(String firstName, String lastName, String email, String password, String confirmPassword) {
        signUpPage.setFirstName(generateRandomString(8) + "1")
                .setLastName(generateRandomString(8) + "1")
                .setEmail(generateRandomString(8) + "@example.com")
                .setPassword(password)
                .setConfirmPassword(confirmPassword);
    }

    @And("^the user clicks on the Create Account button$")
    public void the_user_clicks_on_the_Create_Account_button() {
        signUpPage.clickOnCreateButton();
    }

    @Then("^user should be redirected to the account dashboard page$")
    public void the_user_should_be_redirected_to_the_account_dashboard_page() {
        assert(signUpPage.isSuccessMessageDisplayed());
    }

    private String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
