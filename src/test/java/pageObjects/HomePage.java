package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(linkText = "Sign In")
    private WebElement logInLink;

    @FindBy(linkText = "Create an Account")
    private WebElement createAccountLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage navigateToLoginPage() {
        logInLink.click();
        return new LoginPage(driver);
    }
}
