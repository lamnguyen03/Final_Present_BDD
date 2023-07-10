package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends BasePage{
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "email_address")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//div[@class='actions-toolbar']/div/button/span[contains(text(),'Create an Account')]")
    private WebElement createButton;

    @FindBy(xpath = "//div[contains(text(),'Thank you for registering with Main Website Store.')]")
    private WebElement successMessage;

    public SignUpPage setFirstName(String firstName) {
        waitToBeAvailable(firstNameField);
        firstNameField.sendKeys(firstName);
        return this;
    }

    public SignUpPage setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public SignUpPage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public SignUpPage setConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
        return this;
    }

    public SignUpPage clickOnCreateButton() {
        createButton.click();
        return this;
    }

    public boolean isSuccessMessageDisplayed() {
        waitToBeAvailable(successMessage);
        return successMessage.isDisplayed();
    }
}
