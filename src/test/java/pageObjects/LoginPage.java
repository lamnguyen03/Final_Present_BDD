package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private WebDriver driver;

    @FindBy(linkText = "Sign In")
    private WebElement logInLink;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement logInBtn;

    @FindBy(xpath = "//div[@role='alert' and @class='messages']")
    private WebElement failMessage;
    @FindBy(xpath = "//div[@class=\'field captcha required\']")
    private WebElement capCha;

    @FindBy(xpath = "(//span[@class='logged-in' and contains(text(),'Welcome')])[1]\n")
    private WebElement successMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
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
        try {
            waitToBeAvailable(successMessage);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            waitToBeAvailable(successMessage);
        }
        return successMessage.isDisplayed();
    }

    public boolean isLogInFail() {
        try {
            waitToBeAvailable(failMessage);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            waitToBeAvailable(failMessage);
        }
        return failMessage.isDisplayed();
    }



}
