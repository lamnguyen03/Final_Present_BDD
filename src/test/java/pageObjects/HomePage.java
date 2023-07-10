package pageObjects;

import io.cucumber.java.ro.Si;
import org.openqa.selenium.JavascriptExecutor;
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
    @FindBy(xpath = "//li[@class='product-item'][3]/div/a/span")
    private WebElement item;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage navigateToLoginPage() {
        logInLink.click();
        return new LoginPage(driver);
    }
    public SignUpPage navigateToSignUpPage() {
        createAccountLink.click();
        return new SignUpPage(driver);
    }
    public void scrollToSelectItem() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", item);
        item.click();
    }
}
