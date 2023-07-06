package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(linkText = "Sign In")
    private WebElement logInLink;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement logInBtn;

    @FindBy(className = "mage-error")
    private WebElement failMessage;

    @FindBy(className = "logged-in")
    private WebElement successMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        logInLink.click();
    }

    public LoginPage setEmail(String inputEmail) {
        emailInput.sendKeys(inputEmail);
        return this;
    }

    public LoginPage setPassword(String inputPassword) {
        passwordInput.sendKeys(inputPassword);
        return this;
    }

    public void clickLogInBtn() {
        logInBtn.click();
    }

    public boolean isLogInSuccess() {
        return successMessage.isDisplayed();
    }

    public boolean isLogInFail() {
        return failMessage.isDisplayed();
    }
}
