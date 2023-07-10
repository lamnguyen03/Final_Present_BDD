package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiniCartPage extends BasePage{
    public MiniCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='minicart-wrapper']//a[@class='action showcart']")
    private WebElement shoppingCartIcon;

    @FindBy(linkText = "View and Edit Cart")
    private WebElement viewCartLink;
    @FindBy(xpath = "//div[contains(text(),'You added Argus All-Weather Tank to your')]")
    private WebElement addToCartSuccessMessage;

    public MiniCartPage navigateToCheckOutCart() {
        waitToBeAvailable(addToCartSuccessMessage);
        shoppingCartIcon.click();
        waitToBeAvailable(viewCartLink);
        waitToBeClickAble(viewCartLink);
        viewCartLink.click();
        return this;
    }
}
